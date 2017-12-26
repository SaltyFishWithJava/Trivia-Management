package controller;

import model.SpaceDbUtil;

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

@WebServlet("/SpaceController")
public class SpaceController extends HttpServlet {
    private final static String TAG = "SpaceController";
    private SpaceDbUtil spaceDbUtil;

    @Resource(name = "jdbc/2017J2EE")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();
        // create our student db util ... and pass in the conn pool / datasource
        try {
            spaceDbUtil = new SpaceDbUtil(dataSource);
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        try {
            String theCommand = request.getParameter("command");
            // if the command is missing, then default to listing cars which are available
            if (theCommand == null) {
            }
            // route to the appropriate method
            switch (theCommand) {
                case "ADMIN_SPACE":
                    adminSpace(request, response);
                    break;
                case "GET_PRICE":
                    getSpacePriceById(request, response);
                    break;
                case "USER_SPACE":
                    userSpace(request, response);
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

    private void getSpacePriceById(HttpServletRequest request, HttpServletResponse response) throws Exception {

    }

    private void adminSpace(HttpServletRequest request, HttpServletResponse response) throws Exception {

    }

    private void userSpace(HttpServletRequest request, HttpServletResponse response) throws Exception {

    }
}
