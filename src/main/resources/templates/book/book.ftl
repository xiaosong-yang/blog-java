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
                    <#list nearlyBooks as book>
                    <div style="margin-top: 20px;" >
                        <i class="fa fa-circle"></i> <span><a
                                    href="/blog/html/book_detail.html?id=${book.bookId}" target="_parent">《${book.bookName}》</a></span>
                    </div>
                    </#list>
                </div>
            </div>
        </div>
    </div>



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
                            <#list books.result as book>
                            <div style="margin: 10px; width: 150px; float: left;" >
                                <a href="/blog/bookDetail?bookId=${book.id}">
                                    <img alt="" src="${book.faceUrl}" style="width: 150px;">
                                </a>
                                <div>
                                    <h3 style="font-size: 16px; font-weight: 600; text-align: center;">
                                        <a href="/blog/bookDetail?bookId=${book.id}">《${book.bookName}》</a>
                                    </h3>
                                </div>
                            </div>
                            </#list>
                        </div>
                        <div
                                class="visible-xs-block" style="margin-top: 10px;">
                            <#list books.result as book>
                            <div class="col-xs-6" >
                                <a href="/blog/bookDetail?bookId=${book.id}">
                                    <img alt="" src="${book.faceUrl}" style="width: 150px;">
                                </a>
                                <div>
                                    <h3 style="font-size: 16px; font-weight: 600; text-align: center;">
                                        <a href="/blog/bookDetail?bookId=${book.id}">《${book.bookName}》</a>
                                    </h3>
                                </div>
                            </div>
                            </#list>
                        </div>
                        <div class="col-xs-12">
                            <div style="display: inline-block; margin-left: 50%;" class="hidden-xs">
                                <div id="pagination" style="float: right;"></div>
                            </div>
                            <div style="display: inline-block;" class="visible-xs-block">
                                <div id="paginationMin" style="float: right;"></div>
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

    //对于pcWeb
    layui.use('laypage',function() {
        var laypage = layui.laypage;
        var pageInitParams = {
            elem : 'pagination', //注意，这里的 test1 是 ID，不用加 # 号
            count : "${totalCount}",
            limit : "${books.pageSize}",
            groups : showPages,
            curr:"${books.curPage}",
            jump : function(obj, first) {
                if(!first){
                    var parmas = "pageIndex="+obj.curr+"&pagelimit="+obj.limit;
                    window.location="/blog/book?"+parmas;
                }
            }
        };
        laypage.render(pageInitParams);
    });

    //对于appweb
    layui.use('laypage',function() {
        var laypage = layui.laypage;
        var pageInitParams = {
            elem : 'paginationMin', //注意，这里的 test1 是 ID，不用加 # 号
            count : "${totalCount}",
            limit : "${books.pageSize}",
            groups : minShowPage,
            curr:"${books.curPage}",
            prev:"<",
            next:">",
            jump : function(obj, first) {
                if(!first){
                    var params = "type="+techType+"&pageIndex="+obj.curr+"&pagelimit="+obj.limit;
                    window.location ="/blog/book?"+params;
                }
            }
        };
        laypage.render(pageInitParams);
    });

</script>
</html>