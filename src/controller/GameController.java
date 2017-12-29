package controller;

import bean.Game;
import bean.User;
import model.GameDbUtil;
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
import java.util.regex.Pattern;

@WebServlet("/GameController")
public class GameController extends HttpServlet {
    private final static String TAG = "GameController";
    private static final long serialVersionUID = 1L;
    private GameDbUtil gameDbUtil;

    @Resource(name = "jdbc/Trivia")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            gameDbUtil = new GameDbUtil(dataSource);
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
                case "ADMIN_GAME":
                    adminGame(request, response);
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

    private boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    private void adminGame(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String playerName = request.getParameter("player_name");
        String gameId = request.getParameter("game_id");
        boolean searchId;
        int id = 0;
        if(gameId == null || gameId == "" || !isInteger(gameId)){
            searchId = false;
        }
        else{
            searchId = true;
            id = Integer.valueOf(gameId);
        }

        List<Game> gameList = gameDbUtil.getGameListbyAdmin(playerName, id, searchId);

        request.setAttribute("game_list", gameList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/adminGame.jsp");
        dispatcher.forward(request, response);
    }

}
