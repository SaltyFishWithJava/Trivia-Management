<%@ page import="bean.Ques" %>
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
    <title>题目管理</title>
</header>

<body class="body-wrapper">
<div class="page-loader" style="background: url(img/preloader.gif) center no-repeat #fff;"></div>
<div class="main-wrapper">

    <script>
        var PAGEID = "adp3";
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
                        <h2><b>Trivia</b> 题目管理</h2>
                    </div>
                    <div class="dashboardBoxBg mb30">
                        <div class="profileIntro">
                            <form action="/UserController" method="GET" class="row" id="userSearchForm">
                                <input type="hidden" name="command" value="ADMIN_USER"/>
                                <div class="form-group col-md-4 col-sm-6 col-xs-12">
                                    <label for="quesText">题面</label>
                                    <input type="text" class="form-control" id="quesText" placeholder="请输入题面关键字"
                                           name="user_name">
                                </div>
                                <div class="form-group col-md-4 col-sm-6 col-xs-12">
                                    <label for="quesID">题目ID</label>
                                    <input type="text" class="form-control" id="quesID" placeholder="请输入题目ID"
                                           name="user_name">
                                </div>
                                <div class="form-group col-md-4 col-sm-6 col-xs-12">
                                    <label for="userStatus">题目种类</label>
                                    <div class="contactSelect">
                                        <select id="userStatus" class="select-drop" name="user_valid" size="1"
                                                multiple="false">
                                            <option value="">不限</option>
                                            <option value="4">生活常识类</option>
                                            <option value="3">历史知识类</option>
                                            <option value="2">人文知识类</option>
                                            <option value="1">娱乐知识类</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group col-md-4 col-sm-6 col-xs-12" style="padding-top: 2.3%;">
                                    <button type="submit" class="btn btn-primary btn-lg"><i
                                            class="fa fa-search" aria-hidden="true"></i>搜索
                                    </button>
                                    <button type="reset" class="btn btn-primary btn-lg"><i
                                            class="fa fa-circle-o" aria-hidden="true"></i>清空
                                    </button>
                                </div>
                                <div class="form-group col-md-4 col-sm-6 col-xs-12" style="padding-top: 2.3%;">
                                    <button type="" class="btn btn-primary btn-lg"><i
                                            class="fa fa-search" aria-hidden="true"></i>添加
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>


                <p style="margin-left: 2%; height: 0px; padding-top: 30px">共搜索到了<span style="font-weight: bold;">
                    <%
                        List<Ques> result = (List<Ques>) request.getAttribute("ques_list");
                        out.print(result.size());
                    %></span> 条记录</p>
                <div class="col-xs-12">
                    <div class="table-responsive bgAdd" data-pattern="priority-columns">
                        <table id="ordersTable" class="table table-small-font table-bordered table-striped"
                               cellspacing="0" width="100%">
                            <thead>
                            <tr>
                                <th>题目ID</th>
                                <th>题面</th>
                                <th>选项A</th>
                                <th>选项B</th>
                                <th>选项C</th>
                                <th>选项D</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>题目ID</th>
                                <th>题面</th>
                                <th>选项A</th>
                                <th>选项B</th>
                                <th>选项C</th>
                                <th>选项D</th>
                                <th>正确答案</th>
                                <th>操作</th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <%
                                for (Ques it : result) { %>
                            <tr id="result<%=it.getQuesId()%>">
                                <td><%=it.getQuesText()%>
                                </td>
                                <td><%=it.getChoiceA()%>
                                </td>
                                <td><%=it.getChoiceB()%>
                                </td>
                                <td><%=it.getChoiceC()%>
                                </td>
                                <td><%=it.getChoiceD()%>
                                </td>
                                <td><%=it.getAns()%>
                                </td>
                                <td>
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-primary" name="editUser"
                                                value="<%=it.getQuesId()%>">修改
                                        </button>
                                        <button type="button" class="btn btn-primary" name="deleteQues"
                                                value="<%=it.getQuesId()%>">删除
                                        </button>
                                    </div>
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
<script>


    $("button[name='deleteQues']").click(
        function () {
            var quesId = this.value;
            $.get("/QuesController?command=DELETE_QUES", {
                ques_id : quesId
            }, function (data, textStatus) {
                this.parent().parent().parent().remove();
            });
        }
    );

</script>
</html>