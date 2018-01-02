package controller;

import bean.Ques;
import model.QuesDbUtil;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/QuesController")
public class QuesController extends HttpServlet {
    private final static String TAG = "QuesController";
    private static final long serialVersionUID = 1L;
    private QuesDbUtil quesDbUtil;

    @Resource(name = "jdbc/Trivia")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            quesDbUtil = new QuesDbUtil(dataSource);
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        try {
            // read the "command" parameter
            String theCommand = request.getParameter("command");

            // if the command is missing, then default to listing students
            if (theCommand == null) {
            }

            // route to the appropriate method
            switch (theCommand) {
                case "ADMIN_QUES":
                    getQuesList(request, response);
                    break;
                case "ADD_QUES":
                    addQues(request, response);
                    break;
                case "GET_QUES":
                    getQues(request, response);
                    break;
                case "UPDATE_QUES":
                    updateQues(request, response);
                    break;
                case "DELETE_QUES":
                    deleteQues(request, response);
                    break;
                default:
                    break;
            }

        } catch (Exception exc) {
            throw new ServletException(exc);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    private void getQues(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int quesId = Integer.valueOf(request.getParameter("ques_id"));
        int quesCate = Integer.valueOf(request.getParameter("ques_cate"));
        Ques ret = quesDbUtil.getQues(quesId, quesCate);
        request.setAttribute("ques", ret);
        RequestDispatcher dispatcher = request.getRequestDispatcher("quesDetail.jsp");
        dispatcher.forward(request, response);
    }

    private void addQues(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String quesText = request.getParameter("ques_text");
        String ansA = request.getParameter("ans_a");
        String ansB = request.getParameter("ans_b");
        String ansC = request.getParameter("ans_c");
        String ansD = request.getParameter("ans_d");
        String ans = request.getParameter("ans");
        int quesCate = Integer.valueOf(request.getParameter("ques_cate"));
        int quesId = quesDbUtil.addQues(quesText, ansA, ansB, ansC, ansD, ans, quesCate);
        Ques ret = quesDbUtil.getQues(quesId, quesCate);
        request.setAttribute("ques", ret);
        RequestDispatcher dispatcher = request.getRequestDispatcher("quesDetail.jsp");
        dispatcher.forward(request, response);
    }

    private void updateQues(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String quesText = request.getParameter("ques_text");
        String ansA = request.getParameter("ans_a");
        String ansB = request.getParameter("ans_b");
        String ansC = request.getParameter("ans_c");
        String ansD = request.getParameter("ans_d");
        String ans = request.getParameter("ans");
        int quesCate = Integer.valueOf(request.getParameter("ques_cate"));
        int quesId = Integer.valueOf(request.getParameter("ques_id"));
        quesDbUtil.updateQuesById(quesId, quesText, ansA, ansB, ansC, ansD, ans, quesCate);
        Ques ret = quesDbUtil.getQues(quesId, quesCate);
        request.setAttribute("ques", ret);
        RequestDispatcher dispatcher = request.getRequestDispatcher("quesDetail.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteQues(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int quesId = Integer.valueOf(request.getParameter("ques_id"));
        int quesCate = Integer.valueOf(request.getParameter("ques_cate"));
        quesDbUtil.deleteQuesById(quesId, quesCate);
    }

    private void getQuesList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String quesText = request.getParameter("ques_text");
        boolean searchQuesCate;
        int quesCate = 0;
        String quesCateS = request.getParameter("ques_cate");
        if (quesCateS != null && !quesCateS.equals("")) {
            quesCate = Integer.valueOf(quesCateS);
            searchQuesCate = true;
        } else {
            searchQuesCate = false;
        }
        List<Ques> quesList = quesDbUtil.getQuesListByAdmin(quesText, quesCate, searchQuesCate);
        request.setAttribute("ques_list", quesList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("adminQues.jsp");
        dispatcher.forward(request, response);
    }

}
