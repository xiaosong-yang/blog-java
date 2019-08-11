<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>程序员老杨的博客</title>
    <script src="${Application.projectName}/js/common.js"></script>
    <#include "../common/header_css.ftl" />
</head>
<body class="lay-blog container-fluid">
<#include "../common/header.ftl" />
<div class="container-wrap row"
     style="padding-top: 0px; padding-bottom: 0px;min-height: 80%;">
    <div id="left" class="hidden-xs col-xs-3 col-sm-3">
        <!-- 	<div style="float: left; width: 20%;"> -->
        <div class="float-board-left">
            <div class="title-div">
                <span style="margin-left: 10px;">最新藏书</span>
            </div>
            <div class="content-div" style="overflow: hidden;">
                <div style="margin-left: 20px; font-size: 15px;">
                    <div style="margin-top: 20px;" v-for="book in nearlyBooks">
                        <i class="fa fa-circle"></i> <span><a
                                    v-bind:href="'/blog/html/book_detail.html?id='+book.bookId" target="_parent">《{{book.bookName}}》</a></span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        var vm5 = new Vue({
            el: "#left",
            data: {
                nearlyBooks:[]
            }
        })


        $.ajax({
            "url":"/blog/book/getNearlyBooks",
            "type":"POST",
            "success":function(response){
                if(response.rspType=="rspSuccess"){
                    vm5.nearlyBooks=response.rspContent;
                }else if(response.rspType=="rspFail"){
                    top.show_warn_dialog(response.failReason);
                }
            }
        });
    </script>


    <div class="col-xs-12 col-sm-6">
        <div class="row">
            <div class="col-sm-12" id="main_container" style="min-height: 80%;">
                <div class="row">

                    <div
                            style="background-color: white; overflow: hidden;">
                        <div
                              clas="col-sm-12 diary-type-sm diary-type-xs"  style="margin-left: 1%; margin-top: 10px;font-weight: 600;">私人书屋</div>
                        <div
                                class="col-xs-12" style="height: 2px; background-color: orange;"></div>
                        <div
                               class="col-xs-12 hidden-xs">
                            <div style="margin: 10px; width: 150px; float: left;" v-for="book in books">
                                <a v-bind:href="'/blog/bookDetail?bookId='+book.id">
                                    <img alt="" v-bind:src="book.faceUrl" style="width: 150px;">
                                </a>
                                <div>
                                    <h3 style="font-size: 16px; font-weight: 600; text-align: center;">
                                        <a v-bind:href="'/blog/bookDetail?bookId='+book.id">《{{book.bookName}}》</a>
                                    </h3>
                                </div>
                            </div>
                        </div>
                        <div
                                class="visible-xs-block" style="margin-top: 10px;">
                            <div class="col-xs-6" v-for="book in books">
                                <a v-bind:href="'/blog/bookDetail?bookId='+book.id">
                                    <img alt="" v-bind:src="book.faceUrl" style="width: 150px;">
                                </a>
                                <div>
                                    <h3 style="font-size: 16px; font-weight: 600; text-align: center;">
                                        <a v-bind:href="'/blog/bookDetail?bookId='+book.id">《{{book.bookName}}》</a>
                                    </h3>
                                </div>
                            </div>
                        </div>
                        <div class="col-xs-12">
                            <div style="display: inline-block; margin-left: 50%;" class="hidden-xs">
                                <div id="pagination" style="position: relative; right: 50%;"></div>
                            </div>
                            <div style="display: inline-block;" class="visible-xs-block">
                                <div id="paginationMin" style="position: relative;margin-left:10%;"></div>
                            </div>
                        </div>

                    </div>


                </div>
            </div>
        </div>
    </div>
    <#include "../common/right.ftl">
</div>
<#include "../common/footer.ftl" />
</body>
<script type="text/javascript">
    var menu_id = "menu_id5";
    var vm6 = new Vue({
        el : "#main_container",
        data : {
            books:[]
        },
        methods:{
        }
    })


    $(function(){
        $.ajax({
            "url" : "/blog/book/geetBooksCount",
            "type" : "POST",
            "success" : function(response) {
                if (response.rspType == "rspSuccess") {
                    var totalCount = response.rspContent;
                    layui.use('laypage',function() {
                        var laypage = layui.laypage;
                        laypage.render({
                            elem : 'pagination', //注意，这里的 test1 是 ID，不用加 # 号
                            count : totalCount,
                            limit : pageSize,
                            groups : showPages,
                            jump : function(obj, first) {
                                var data = {
                                    "cur" : obj.curr,
                                    "size" : obj.limit
                                };
                                $.ajax({
                                    "url" : "/blog/book/getBooksByPage",
                                    "type" : "POST",
                                    "data" : data,
                                    "success" : function(
                                        diary_response) {
                                        if (diary_response.rspType == "rspSuccess") {
                                            vm6.books = diary_response.rspContent.result;
                                        } else if (diary_response.rspType == "rspFail") {
                                            show_warn_dialog(response.failReason);
                                        }
                                    }
                                });
                            }
                        });

                        laypage.render({
                            elem : 'paginationMin', //注意，这里的 test1 是 ID，不用加 # 号
                            count : totalCount,
                            limit : pageSize,
                            groups : minShowPage,
                            prev:"<",
                            next:">",
                            jump : function(obj, first) {
                                var data = {
                                    "cur" : obj.curr,
                                    "size" : obj.limit
                                };
                                $.ajax({
                                    "url" : "/blog/book/getBooksByPage",
                                    "type" : "POST",
                                    "data" : data,
                                    "success" : function(
                                        diary_response) {
                                        if (diary_response.rspType == "rspSuccess") {
                                            vm6.books = diary_response.rspContent.result;
                                        } else if (diary_response.rspType == "rspFail") {
                                            show_warn_dialog(response.failReason);
                                        }
                                    }
                                });
                            }
                        });
                    });
                } else if (response.rspType == "rspFail") {
                    show_warn_dialog(response.failReason);
                }
            }
        });
    })
</script>
</html>