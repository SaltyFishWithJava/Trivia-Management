<%@ page import="bean.Ques" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html lang="en">

<%@include file="templates/headers.jsp" %>
<head>
    <title>题目详情</title>
</head>
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
    <section class="clearfix bg-dark listingSection">
        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <form action="QuesController" method="POST" class="listing__form"4>
                        <div class="dashboardPageTitle text-center">
                            <h2><b>Trivia</b> 题目详情</h2>
                            <%
                                Ques ques = (Ques) request.getAttribute("ques");
                                if (ques != null) {
                                    out.print("<input value=" + ques.getQuesId() + " name=\"ques_id\" hidden=\"hidden\">");
                                    out.print("<input value=\"UPDATE_QUES\" name=\"command\" hidden=\"hidden\">");
                                }
                                else{
                                    out.print("<input value=\"ADD_QUES\" name=\"command\" hidden=\"hidden\">");
                                }
                            %>
                        </div>
                        <div class="dashboardBoxBg mb30">
                            <div class="profileIntro paraMargin">
                                <div class="row">
                                    <div class="form-group col-xs-12">
                                        <label for="questionContent">题面：</label>
                                        <textarea class="form-control" rows="3" id="questionContent" name="ques_text"
                                                  placeholder=""><%
                                            if (ques != null) {
                                                out.print(ques.getQuesText());
                                            }
                                        %></textarea>
                                    </div>
                                    <div class="form-group col-sm-12 col-xs-12">
                                        <label for="questionSelect_A">选项A：</label><br>
                                        <input class="form-control" name="ans_a" id="questionSelect_A"
                                               value="<%
                                               if (ques != null){
                                                   out.print(ques.getChoiceA());
                                               }%>">
                                    </div>
                                    <div class="form-group col-sm-12 col-xs-12">
                                        <label for="questionSelect_B">选项B：</label><br>
                                        <input class="form-control" name="ans_b" id="questionSelect_B"
                                               value="<%
                                               if (ques != null){
                                                   out.print(ques.getChoiceB());
                                               }%>">
                                    </div>
                                    <div class="form-group col-sm-12 col-xs-12">
                                        <label for="questionSelect_C">选项C：</label><br>
                                        <input class="form-control" name="ans_c" id="questionSelect_C"
                                               value="<%
                                               if (ques != null){
                                                   out.print(ques.getChoiceC());
                                               }%>">
                                    </div>
                                    <div class="form-group col-sm-12 col-xs-12">
                                        <label for="questionSelect_D">选项D：</label><br>
                                        <input class="form-control" name="ans_d" id="questionSelect_D"
                                               value="<%
                                               if (ques != null){
                                                   out.print(ques.getChoiceD());
                                               }%>">
                                    </div>
                                    <div class="form-group col-sm-6 col-xs-12">
                                        <label for="questionAnswer">正确答案：</label>
                                        <div class="contactSelect">
                                            <select name="ans" id="questionAnswer" class="select-drop">
                                                <option value="A" <%
                                                    if (ques != null && ques.getAns().equals("A")){
                                                        out.print("selected=\"selected\"");}
                                                %>>A</option>
                                                <option value="B" <%
                                                    if (ques != null && ques.getAns().equals("B")){
                                                        out.print("selected=\"selected\"");}
                                                %>>B</option>
                                                <option value="C" <%
                                                    if (ques != null && ques.getAns().equals("C")){
                                                        out.print("selected=\"selected\"");}
                                                %>>C</option>
                                                <option value="D"<%
                                                    if (ques != null && ques.getAns().equals("D")){
                                                        out.print("selected=\"selected\"");}
                                                %>>D</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group col-sm-6 col-xs-12">
                                        <label for="qusetionCategory">题目类别：</label>
                                        <div class="contactSelect">
                                            <select name="ques_cate" id="qusetionCategory" class="select-drop">
                                                <%
                                                    if (ques == null){
                                                        out.print("<option value=\"4\">生活常识类</option>\n" +
                                                                "                                                <option value=\"3\">历史知识类</option>\n" +
                                                                "                                                <option value=\"2\">人文知识类</option>\n" +
                                                                "                                                <option value=\"1\">娱乐知识类</option>");
                                                    }
                                                    else {
                                                        switch (ques.getQuesCate()){
                                                            case 1:
                                                                out.print("<option value=\"1\">娱乐知识类</option>");
                                                                break;
                                                            case 2:
                                                                out.print("<option value=\"2\">人文知识类</option>");
                                                                break;
                                                            case 3:
                                                                out.print("<option value=\"3\">历史知识类</option>");
                                                                break;
                                                            case 4:
                                                                out.print("<option value=\"4\">生活常识类</option>");
                                                                break;
                                                        }
                                                    }
                                                %>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-footer text-center">
                            <button type="submit" class="btn-submit">提交</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
</div>
</body>
<%@include file="templates/footers.jsp" %>

</html>

