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
                        </div>
                        <div class="dashboardBoxBg mb30">
                            <div class="profileIntro paraMargin">
                                <h3>About</h3>
                                <p>We are not responsible for any damages caused by the use of this website, or by
                                    posting business listings here. Please use our site at your own discretion and
                                    exercise good judgement as well as common sense when advertising business here.</p>
                                <div class="row">
                                    <div class="form-group col-sm-6 col-xs-12">
                                        <label for="listingTitle">Listing Title</label>
                                        <input type="text" class="form-control" id="listingTitle"
                                               placeholder="Listing Title">
                                    </div>
                                    <div class="form-group col-sm-6 col-xs-12">
                                        <label for="listingCategory">Category</label>
                                        <div class="contactSelect">
                                            <select name="guiest_id9" id="guiest_id9" class="select-drop">
                                                <option value="0">All Category</option>
                                                <option value="1">Restaurant</option>
                                                <option value="2">Bar</option>
                                                <option value="3">Cafe</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-xs-12">
                                        <label for="discribeTheListing">Discribe the listing</label>
                                        <textarea class="form-control" rows="3"
                                                  placeholder="Discribe the listing"></textarea>
                                    </div>
                                    <div class="form-group col-xs-12">
                                        <label for="addTags">Tags</label>
                                        <input type="text" class="form-control" id="addTags" placeholder="Add Tags">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-footer text-center">
                            <button type="submit" class="btn-submit">Submit</button>
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
