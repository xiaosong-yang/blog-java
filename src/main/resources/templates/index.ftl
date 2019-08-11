<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>程序员老杨的博客</title>
    <script src="${Application.projectName}/js/common.js"></script>
    <#include "common/header_css.ftl" />
</head>
<body class="lay-blog container-fluid">
<#include "common/header.ftl" />
<div class="container-wrap row"
     style="padding-top: 0px; padding-bottom: 0px;min-height: auto;">
    <#include "common/left.ftl">
    <div class="col-xs-12 col-sm-6">
        <div class="row">
            <div class="col-sm-12" id="main_container">
                <div class="row">
                    <h4 class="col-sm-12">
                        <p>
                            <i class="layui-icon layui-icon-speaker"></i>公告：<span>${announcement}</span>
                        </p>
                    </h4>
                    <div class="col-sm-12">
                        <div id="myCarousel" class="carousel slide">
                            <!-- 轮播（Carousel）指标 -->
                            <ol class="carousel-indicators">
                                <#list faceImgs as faceimg>
                                    <#if faceimg_index==0><li data-target="#myCarousel" data-slide-to="0" class="active"></li></#if>
                                    <#if faceimg_index!=0><li data-target="#myCarousel" data-slide-to="${faceimg_index}"></li></#if>
                                </#list>
                            </ol>
                            <!-- 轮播（Carousel）项目 -->
                            <div class="carousel-inner">
                                <#list faceImgs as faceimg>
                                    <#if faceimg_index==0>
                                        <div class="item active">
                                            <img src="${faceimg.url}"
                                                 alt="${faceimg.imgName}" style="width: 100%;">
                                        </div>
                                    </#if>
                                    <#if faceimg_index!=0>
                                        <div class="item">
                                        <img src="${faceimg.url}"
                                    alt="${faceimg.imgName}" style="width: 100%;">
                                        </div>
                                    </#if>
                                </#list>
                            </div>
                            <!-- 轮播（Carousel）导航 -->
                            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                                <span class="sr-only">Previous</span>
                            </a>
                            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                                <span class="sr-only">Next</span>
                            </a>
                        </div>
                    </div>

                    <div class="visible-xs-block" style="margin-top: 20px;">
                        <div class="title-div">
                            <span style="margin-left: 10px;">最新书藏</span>
                        </div>
                        <div class="content-div">
                            <div style="margin-left: 20px; font-size: 15px;">
                                <#list books as book>
                                <div style="margin-top: 20px;">
                                    <i class="fa fa-circle"></i> <span><a
                                                href="/blog/bookDetail?bookId=${book.bookId}"
                                                target="_blank">《${book.bookName}》</a></span>
                                </div>
                                </#list>
                            </div>

                        </div>
                    </div>

                    <div class="visible-xs-block"  style="margin-top: 20px;">
                        <div class="title-div">
                            <span style="margin-left: 10px;">联系我</span>
                        </div>
                        <div class="content-div">
                            <div class="center-header-pic">
                                <img alt="" src="${connectInfos.wechat}"
                                     width="40%" height="70%;" style="float: left;"
                                > <img alt="" src="${connectInfos.qq}" width="40%"
                                       height="70%;" style="float: right;"
                                >
                            </div>
                            <div  class="center-header-pic" style="width:60%;">
                                <label style="font-weight: bold; font-size: 18px;">邮箱 ：</label> <span
                                        style="font-size: 16px;">${connectInfos.email}</span>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
    <#include "common/right.ftl">
</div>
<#include "common/footer.ftl" />
</body>
<script type="text/javascript">
    var menu_id = "menu_id1";

    // var vm3 = new Vue({
    //     el: "#main_container",
    //     data: {
    //         announcement: "",
    //         books: "",
    //         wechat: "",
    //         qq: "",
    //         email: ""
    //     }
    // })
    //
    // $(function () {
    //     $.ajax({
    //         "url": "/blog/user/getAnnouncement",
    //         "type": "POST",
    //         "success": function (response) {
    //             if (response.rspType == "rspSuccess") {
    //                 vm3.announcement = response.rspContent;
    //             } else if (response.rspType == "rspFail") {
    //                 top.show_warn_dialog(response.failReason);
    //             }
    //         }
    //     });
    //
    //     $.ajax({
    //         "url": "/blog/book/getNearlyBooks",
    //         "type": "POST",
    //         "success": function (response) {
    //             if (response.rspType == "rspSuccess") {
    //                 vm3.books = response.rspContent;
    //             } else if (response.rspType == "rspFail") {
    //                 top.show_warn_dialog(response.failReason);
    //             }
    //         }
    //     });
    //
    //     $.ajax({
    //         "url": "/blog/user/getConnectInfo",
    //         "type": "POST",
    //         "success": function (response) {
    //             vm3.wechat = response.rspContent.wechat;
    //             vm3.qq = response.rspContent.qq;
    //             vm3.email = response.rspContent.email;
    //         }
    //     });
    // })

</script>
</html>