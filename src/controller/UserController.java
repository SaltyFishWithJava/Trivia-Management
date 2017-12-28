package controller;

import bean.*;
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
@WebServlet("/UserController")
public class UserController extends HttpServlet {
    private final static String TAG = "UserController";
    private static final long serialVersionUID = 1L;
    private UserDbUtil userDbUtil;

    @Resource(name = "jdbc/Trivia")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            userDbUtil = new UserDbUtil(dataSource);
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
                case "ADMIN_USER":
                    adminUser(request, response);
                    break;
                case "ACTIVATE_USER":
                    activateUser(request, response);
                    break;
                case "SUSPEND_USER":
                    suspendUser(request, response);
                    break;
                case "ADMIN_USER_UPDATE":
                    updateUser(request, response);
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

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text");
        PrintWriter out = response.getWriter();
        out.print(userDbUtil.updateUserByName(request.getParameter("user_name"), request.getParameter("user_psw")));
    }

    private void suspendUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        userDbUtil.suspendUserByName(request.getParameter("user_name"));
        response.setCharacterEncoding("utf-8");
        response.setContentType("text");
        PrintWriter out = response.getWriter();
    }

    private void activateUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        userDbUtil.activateUserByName(request.getParameter("user_name"));
        response.setCharacterEncoding("utf-8");
        response.setContentType("text");
        PrintWriter out = response.getWriter();
    }


    private void adminUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String userName = request.getParameter("user_name");
        String userValid = request.getParameter("user_valid");

        List<User> userList = userDbUtil.getUserListbyAdmin(userName, userValid);

        request.setAttribute("user_list", userList);
        //Forward to adminUser.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/adminUser.jsp");
        dispatcher.forward(request, response);

    }

}
