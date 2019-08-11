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
                <span style="margin-left: 10px;">时光轴</span>
            </div>
            <div class="content-div" style="overflow: hidden;">
                <ul class="layui-timeline" style="margin-right: 10px;">
                    <#list diarytimeLines as timeLine>
                    <li class="layui-timeline-item" ><i
                                class="layui-icon layui-timeline-axis">&#xe63f;</i>
                        <div class="layui-timeline-content layui-text">
                            <h3 class="layui-timeline-title">${timeLine.title}</h3>
                            <p>${timeLine.overView}</p>
                        </div></li>
                    </#list>
                    <li class="layui-timeline-item"><i
                                class="layui-icon layui-timeline-axis"></i>
                        <div class="layui-timeline-content layui-text"></div></li>
                </ul>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        // var vm5 = new Vue({
        //     el: "#left",
        //     data: {
        //         diarytimeLines:[]
        //     }
        // })
        //
        //
        // $.ajax({
        //     "url":"/blog/diary/getNearlyDiarys",
        //     "type":"POST",
        //     "success":function(response){
        //         if(response.rspType="rspSuccess"){
        //             vm5.diarytimeLines=response.rspContent
        //         }else if(response.rspType="rspFail"){
        //             show_warn_dialog(response.failReason);
        //         }
        //     }
        // });
    </script>


    <div class="col-xs-12 col-sm-6">
        <div class="row">
            <div class="col-sm-12" id="main_container" style="min-height: 80%;">
                <div class="row">

                    <div
                            style="background-color: white; overflow: hidden;">
                        <div
                              clas="col-sm-12 diary-type-sm diary-type-xs"  style="margin-left: 1%; margin-top: 10px;font-weight: 600;">逝水流年</div>
                        <div
                                class="col-xs-12" style="height: 2px; background-color: orange;"></div>
                        <div
                               class="col-xs-12">
                            <#list diarys.result as diary>
                            <div class="item">
                                <div style="overflow: hidden;">
                                    <a href="/blog/diaryDetail?diaryId${diary.id}" class="col-sm-4 hidden-xs"><img
                                                src="${diary.faceUrl}" style="width: 100%;"/></a>
                                    <div class="col-sm-8 col-xs-12">
                                        <h3 style="font-size: 18px; font-weight: 600;">
                                            <a v-bind:href="'/blog/diaryDetail?diaryId='+diary.id">${diary.title}</a>
                                        </h3>
                                        <p
                                                style="word-break: break-all; text-overflow: ellipsis; overflow: hidden; font-size: 12px; color: gray; margin-top: 5px;">
                                            ${diary.overView}<a v-bind:href="/blog/diaryDetail?diaryId${diary.id}" style="color: black;">[详情]</a>
                                        </p>
                                        <p style="font-size: 12px; color: gray; margin-top: 5px;">
                                            <span><i class="fa fa-paperclip" aria-hidden="true"></i>&nbsp;${diary.type}</span>
                                            <span style="margin-left: 10px;"><i
                                                        class="fa fa-calendar-minus-o" aria-hidden="true"></i>&nbsp;${diary.time}</span>
                                            <span style="float: right;"><i class="fa fa-thumbs-o-up"
                                                                           aria-hidden="true"></i>（${diary.praiseCount}）</span> <span
                                                    style="float: right; margin-right: 10px;"><i
                                                        class="fa fa-eye" aria-hidden="true"></i>&nbsp;浏览数（${diary.browseCount}）</span>
                                            <span style="float: right; margin-right: 10px;"><i
                                                        class="fa fa-comment-o" aria-hidden="true"></i>&nbsp;评论数（${diary.commentCount}）</span>
                                        </p>
                                    </div>
                                </div>
                                <div style="height: 1px; background-color: gray; width: 100%; margin-top: 5px;"></div>
                            </div>
                            </#list>
                            <div style="display: inline-block; margin-left: 50%;" class="hidden-xs">
                                <div id="pagination" style="float:right"></div>
                            </div>
                            <div style="display: inline-block;" class="visible-xs-block">
                                <div id="paginationMin" style="float:right"></div>
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
    var menu_id = "menu_id3";

    //对于pcWeb
    layui.use('laypage',function() {
        var laypage = layui.laypage;
        var pageInitParams = {
            elem : 'pagination', //注意，这里的 test1 是 ID，不用加 # 号
            count : "${totalCount}",
            limit : "${diarys.pageSize}",
            groups : showPages,
            curr:"${diarys.curPage}",
            jump : function(obj, first) {
                if(!first){
                    var parmas = "pageIndex="+obj.curr+"&pagelimit="+obj.limit;
                    window.location="/blog/diary?"+parmas;
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
            limit : "${diarys.pageSize}",
            groups : minShowPage,
            curr:"${diarys.curPage}",
            prev:"<",
            next:">",
            jump : function(obj, first) {
                if(!first){
                    var params = "type="+techType+"&pageIndex="+obj.curr+"&pagelimit="+obj.limit;
                    window.location ="/blog/diary?"+params;
                }
            }
        };
        laypage.render(pageInitParams);
    });

</script>
</html>