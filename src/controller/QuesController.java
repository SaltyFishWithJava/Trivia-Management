package controller;

import bean.User;
import model.QuesDbUtil;
import model.UserDbUtil;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
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

}
