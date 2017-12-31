<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/4
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>


<div class="navbar-dashboard-area">
    <nav class="navbar navbar-default lightHeader navbar-dashboard" role="navigation">
        <div class="container">

            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-dash">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-dash">
                <ul class="nav navbar-nav mr0">
                    <%--<li class="" id="adp1">--%>
                        <%--<a href="adminDashboard.jsp"><i class="fa fa-tachometer" aria-hidden="true"></i>--%>
                            <%--管理主页</a>--%>
                    <%--</li>--%>
                    <li class="" id="adp2">
                        <a href="/QuesController?command=ADMIN_QUES"><i class="fa fa-list-ul" aria-hidden="true"></i></i></i>
                            题目管理</a>
                    </li>
                    <li class="" id="adp3">
                        <a href="/GameController?command=ADMIN_GAME"><i class="fa fa-gamepad" aria-hidden="true"></i>
                            游戏记录</a>
                    </li>
                    <li class="" id="adp4">
                        <a href="/UserController?command=ADMIN_USER"><i class="fa fa-user" aria-hidden="true"></i>
                            用户管理</a>
                    </li>
                </ul>
            </div>
            <script>
                $("#" + PAGEID).attr("class", "active");
            </script>
        </div>
    </nav>
</div>
