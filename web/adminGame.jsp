<%@ page import="bean.Game" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/4
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@include file="templates/headers.jsp" %>

<header>
    <title>游戏记录管理</title>
</header>

<body class="body-wrapper">
<div class="page-loader" style="background: url(img/preloader.gif) center no-repeat #fff;"></div>
<div class="main-wrapper">

    <script>
        var PAGEID = "adp2";
    </script>
    <header id="pageTop" class="header">
        <%@include file="templates/adminNavbar.jsp" %>
    </header>


    <!-- DASHBOARD ORDERS SECTION -->
    <section class="clearfix bg-dark dashboardOrders">
        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <div class="dashboardPageTitle text-center">
                        <h2><b>Trivia</b> 游戏记录管理</h2>
                    </div>
                    <div class="dashboardBoxBg mb30">
                        <div class="profileIntro">
                            <form action="/GameController" method="GET" class="row">
                                <input type="hidden" name="command" value="ADMIN_GAME"/>
                                <div class="form-group col-md-4 col-sm-6 col-xs-12">
                                    <label for="gameId">游戏ID</label>
                                    <input type="text" class="form-control" id="gameId" placeholder="请输入游戏ID"
                                           name="game_id">
                                </div>
                                <div class="form-group col-md-4 col-sm-6 col-xs-12">
                                    <label for="playerName">游戏玩家</label>
                                    <input type="text" class="form-control" id="playerName" placeholder="请输入游戏玩家名"
                                           name="player_name">
                                </div>
                                <div class="form-group col-md-4 col-sm-6 col-xs-12" style="padding-top: 2.3%;">
                                    <button type="submit" class="btn btn-primary btn-lg"><i
                                            class="fa fa-search" aria-hidden="true"></i>搜索
                                    </button>
                                    <button type="reset" class="btn btn-primary btn-lg"><i
                                            class="fa fa-circle-o" aria-hidden="true"></i>清空
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>


                <p style="margin-left: 2%; height: 0px; padding-top: 30px">共搜索到了<span style="font-weight: bold;">
                    <%
                        List<Game> result = (List<Game>) request.getAttribute("game_list");
                        out.print(result.size());
                    %></span> 条记录</p>
                <div class="col-xs-12">
                    <div class="table-responsive bgAdd" data-pattern="priority-columns">
                        <table id="ordersTable" class="table table-small-font table-bordered table-striped"
                               cellspacing="0" width="100%">
                            <thead>
                            <tr>
                                <th data-priority="">游戏ID</th>
                                <th data-priority="">游戏时间</th>
                                <th data-priority="">玩家一 / 得分</th>
                                <th data-priority="">玩家二 / 得分</th>
                                <th data-priority="">玩家三 / 得分</th>
                                <th data-priority="">玩家四 / 得分</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>游戏ID</th>
                                <th>游戏时间</th>
                                <th>玩家一 / 得分</th>
                                <th>玩家二 / 得分</th>
                                <th>玩家三 / 得分</th>
                                <th>玩家四 / 得分</th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <%
                                for (Game mGame : result) { %>
                            <tr>
                                <td><%=mGame.getId()%>
                                </td>
                                <td><%=mGame.getTime()%>
                                </td>
                                <td><%
                                    if(mGame.getScore1() == 6){
                                        out.print("<span class=\"label label-success\">");
                                        out.print(mGame.getPlayer1());
                                        out.print(" / ");
                                        out.print(mGame.getScore1());
                                        out.print("</span>");
                                    }
                                    else{
                                        out.print(mGame.getPlayer1());
                                        out.print(" / ");
                                        out.print(mGame.getScore1());
                                    }
                                %>
                                </td>

                                <td><%
                                    if(mGame.getScore2() == 6){
                                        out.print("<span class=\"label label-success\">");
                                        out.print(mGame.getPlayer2());
                                        out.print(" / ");
                                        out.print(mGame.getScore2());
                                        out.print("</span>");
                                    }
                                    else{
                                        out.print(mGame.getPlayer2());
                                        out.print(" / ");
                                        out.print(mGame.getScore2());
                                    }
                                %>
                                </td>
                                <td><%
                                    if(mGame.getScore3() == 6){
                                        out.print("<span class=\"label label-success\">");
                                        out.print(mGame.getPlayer3());
                                        out.print(" / ");
                                        out.print(mGame.getScore3());
                                        out.print("</span>");
                                    }
                                    else{
                                        out.print(mGame.getPlayer3());
                                        out.print(" / ");
                                        out.print(mGame.getScore3());
                                    }
                                %>
                                </td>
                                <td><%
                                    if(mGame.getScore4() == 6){
                                        out.print("<span class=\"label label-success\">");
                                        out.print(mGame.getPlayer4());
                                        out.print(" / ");
                                        out.print(mGame.getScore4());
                                        out.print("</span>");
                                    }
                                    else{
                                        out.print(mGame.getPlayer4());
                                        out.print(" / ");
                                        out.print(mGame.getScore4());
                                    }
                                %>
                                </td>
                            </tr>
                            <%
                                }
                            %>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>

<%@include file="/templates/footers.jsp" %>

</body>
</html>