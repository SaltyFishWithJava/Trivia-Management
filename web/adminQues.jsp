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
                        <h2><b>Trivia</b> 题目管理</h2>
                    </div>
                    <div class="dashboardBoxBg mb30">
                        <div class="profileIntro">
                            <form action="/QuesController" method="GET" class="row">
                                <input type="hidden" name="command" value="ADMIN_QUES"/>
                                <div class="form-group col-md-4 col-sm-6 col-xs-12">
                                    <label for="quesText">题面</label>
                                    <input type="text" class="form-control" id="quesText" placeholder="请输入题面关键字"
                                           name="ques_text">
                                </div>
                                <div class="form-group col-md-4 col-sm-6 col-xs-12">
                                    <label for="userStatus">题目种类</label>
                                    <div class="contactSelect">
                                        <select id="userStatus" class="select-drop" name="ques_cate" size="1"
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
                                    <button id="quesSearchBtn" type="submit" class="btn btn-primary btn-lg"><i
                                            class="fa fa-search" aria-hidden="true"></i>搜索
                                    </button>
                                    <button id="addQuesBtn" type="button" onclick="jump()" class="btn btn-primary btn-lg"><i class="fa fa-plus"
                                                                                                             aria-hidden="true"></i>添加
                                    </button>
                                </div>
                            </form>
                            <script>
                                function jump() {
                                    window.location.href = "quesDetail.jsp";
                                }
                            </script>
                        </div>
                    </div>
                </div>


                <p style="margin-left: 2%; height: 0px; padding-top: 30px">共搜索到了<span id="quesResultNum" style="font-weight: bold;"><%
                        List<Ques> result = (List<Ques>) request.getAttribute("ques_list");
                        if(result == null) pageContext.forward("/QuesController?command=ADMIN_QUES");
                        out.print(result.size());
                    %></span> 条记录</p>
                <div class="col-xs-12">
                    <div class="table-responsive bgAdd" data-pattern="priority-columns">
                        <table id="ordersTable" class="table table-small-font table-bordered table-striped"
                               cellspacing="0" width="100%">
                            <thead>
                            <tr>
                                <th data-priority="2">题面</th>
                                <th data-priority="2">正确答案</th>
                                <th data-priority="1">类型</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>题面</th>
                                <th>正确答案</th>
                                <th>类型</th>
                                <th>操作</th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <%
                                for (Ques it : result) { %>
                            <tr id="result<%=it.getQuesId()%>">
                                <td><%
                                    out.print("题目: ");
                                    if (it.getQuesText().length() > 30) {
                                        out.print(it.getQuesText().substring(0, 29) + "</br>");
                                        out.print(it.getQuesText().substring(30, it.getQuesText().length() - 1));
                                    } else {
                                        out.print(it.getQuesText());
                                    }
                                    out.print("</br>A:");
                                    out.print(it.getChoiceA());
                                    out.print("</br>B:");
                                    out.print(it.getChoiceB());
                                    out.print("</br>C:");
                                    out.print(it.getChoiceC());
                                    out.print("</br>D:");
                                    out.print(it.getChoiceD());
                                %>
                                </td>
                                <td class="ques-ans"><%=it.getAns()%>
                                </td>
                                <td class="ques-type"><%
                                    switch (it.getQuesCate()) {
                                        case 1:
                                            out.print("娱乐知识类");
                                            break;
                                        case 2:
                                            out.print("人文知识类");
                                            break;
                                        case 3:
                                            out.print("历史知识类");
                                            break;
                                        case 4:
                                            out.print("生活常识类");
                                            break;
                                    }
                                %></td>
                                <td>
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-primary" name="editQues"
                                                ques_id="<%=it.getQuesId()%>" ques_cate="<%=it.getQuesCate()%>">修改
                                        </button>
                                        <button type="button" class="btn btn-primary" name="deleteQues"
                                                ques_id="<%=it.getQuesId()%>" ques_cate="<%=it.getQuesCate()%>">删除
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
            var quesId = $(this).attr("ques_id");
            var quesCate = $(this).attr("ques_cate");
            console.log(quesId);
            console.log(quesCate);
            $.get("/QuesController?command=DELETE_QUES", {
                ques_id: quesId,
                ques_cate: quesCate
            }, function (data, textStatus) {
                $("#result" + quesId).remove();
            });
        }
    );

    $("button[name='editQues']").click(
        function () {
            var quesId = $(this).attr("ques_id");
            var quesCate = $(this).attr("ques_cate");
            window.location.href = "QuesController?command=GET_QUES&ques_id="+quesId+"&ques_cate="+quesCate;
        }
    )

</script>
</html>