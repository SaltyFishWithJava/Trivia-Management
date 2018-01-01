<%@ page import="bean.Ques" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html lang="en">

<%@include file="templates/headers.jsp" %>

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
                    <form action="" method="" class="listing__form">
                        <div class="dashboardPageTitle text-center">
                            <h2><b>Trivia</b> 题目</h2>
                            <%
                                Ques ques = (Ques) request.getAttribute("ques");
                                out.print("<input value=" + ques.getQuesId() + " name=\"ques_id\" hidden=\"hidden\">");
                            %>

                        </div>
                        <div class="dashboardBoxBg mb30">
                            <div class="profileIntro paraMargin">
                                <div class="row">
                                    <div class="form-group col-xs-12">
                                        <label for="questionContent">题面：</label>
                                        <textarea class="form-control" rows="3" id="questionContent"
                                                  placeholder="请输入题面……"><%
                                            if (ques != null){
                                                out.print(ques.getQuesText());
                                            }
                                                  %></textarea>
                                    </div>
                                    <div class="form-group col-sm-3 col-xs-12">
                                        <label for="questionSelect_A">选项：</label><br>
                                        A<input class="form-control" name="questionSelect_A" id="questionSelect_A">
                                    </div>
                                    <div class="form-group col-sm-3 col-xs-12">
                                        <label for="questionSelect_B">选项：</label><br>
                                        B<input class="form-control" name="questionSelect_B" id="questionSelect_B">
                                    </div>
                                    <div class="form-group col-sm-3 col-xs-12">
                                        <label for="questionSelect_C">选项：</label><br>
                                        C<input class="form-control" name="questionSelect_C" id="questionSelect_C">
                                    </div>
                                    <div class="form-group col-sm-3 col-xs-12">
                                        <label for="questionSelect_D">选项：</label><br>
                                        D<input class="form-control" name="questionSelect_D" id="questionSelect_D">
                                    </div>

                                    <div class="form-group col-sm-6 col-xs-12">
                                        <label for="questionAnswer">正确答案：</label>
                                        <div class="contactSelect">
                                            <select name="question_answer" id="questionAnswer" class="select-drop">
                                                <option value="1">A</option>
                                                <option value="2">B</option>
                                                <option value="3">C</option>
                                                <option value="4">D</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group col-sm-6 col-xs-12">
                                        <label for="qusetionCategory">题目类型：</label>
                                        <div class="contactSelect">
                                            <select name="qusetion_category" id="qusetionCategory" class="select-drop">
                                                <option value="0">第一种</option>
                                                <option value="1">第二种</option>
                                                <option value="2">第三种</option>
                                                <option value="3">第四种</option>
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

