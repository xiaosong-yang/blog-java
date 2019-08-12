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
                <span style="margin-left: 10px;">Dota大事年表</span>
            </div>
            <div class="content-div" style="overflow: hidden;">
                <ul class="layui-timeline" style="margin-right: 10px;">
                    <#list dotaTimeLines as timeLine>
                    <li class="layui-timeline-item"><i
                                class="layui-icon layui-timeline-axis">&#xe63f;</i>
                        <div class="layui-timeline-content layui-text">
                            <h3 class="layui-timeline-title">${timeLine.time}</h3>
                            <p>
                                <a href="${timeLine.url}">${timeLine.title}</a>
                            </p>
                        </div>
                    </li>
                    </#list>
                    <li class="layui-timeline-item"><i
                                class="layui-icon layui-timeline-axis"></i>
                        <div class="layui-timeline-content layui-text"></div>
                    </li>
                </ul>
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
                                clas="col-sm-12 diary-type-sm diary-type-xs"
                                style="margin-left: 1%; margin-top: 10px;font-weight: 600;">刀塔岁月
                        </div>
                        <div
                                class="col-xs-12" style="height: 2px; background-color: orange;"></div>
                        <div
                                class="col-xs-12">
                            <#list dotas.result as dota>
                            <div class="item">
                                <div style="overflow: hidden;">
                                    <a href="/blog/dotaDiaryDetail?dotaDiaryId=${dota.id}"
                                       class="col-sm-4 hidden-xs"><img
                                                src="${dota.faceUrl}" style="width: 100%;"/></a>
                                    <div class="col-sm-8 col-xs-12">
                                        <h3 style="font-size: 18px; font-weight: 600;">
                                            <a href="/blog/dotaDiaryDetail?dotaDiaryId=${dota.id}">${dota.title}</a>
                                        </h3>
                                        <p
                                                style="word-break: break-all; text-overflow: ellipsis; overflow: hidden; font-size: 12px; color: gray; margin-top: 5px;">
                                            ${dota.overView}<a
                                                    href="/blog/dotaDiaryDetail?dotaDiaryId=${dota.id}"
                                                    style="color: black;">[详情]</a>
                                        </p>
                                        <p style="font-size: 12px; color: gray; margin-top: 5px;">
                                            <span><i class="fa fa-paperclip" aria-hidden="true"></i>&nbsp;${dota.type}</span>
                                            <span style="margin-left: 10px;"><i
                                                        class="fa fa-calendar-minus-o" aria-hidden="true"></i>&nbsp;${dota.time}</span>
                                            <span style="float: right;"><i class="fa fa-thumbs-o-up"
                                                                           aria-hidden="true"></i>（${dota.praiseCount}）</span>
                                            <span
                                                    style="float: right; margin-right: 10px;"><i
                                                        class="fa fa-eye" aria-hidden="true"></i>&nbsp;浏览数（${dota.browseCount}）</span>
                                            <span style="float: right; margin-right: 10px;"><i
                                                        class="fa fa-comment-o" aria-hidden="true"></i>&nbsp;评论数（${dota.commentCount}）</span>
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
    var menu_id = "menu_id4";

    //对于pcWeb
    layui.use('laypage',function() {
        var laypage = layui.laypage;
        var pageInitParams = {
            elem : 'pagination', //注意，这里的 test1 是 ID，不用加 # 号
            count : "${totalCount}",
            limit : "${dotas.pageSize}",
            groups : showPages,
            curr:"${dotas.curPage}",
            jump : function(obj, first) {
                if(!first){
                    var parmas = "pageIndex="+obj.curr+"&pagelimit="+obj.limit;
                    window.location="/blog/dotaDiary?"+parmas;
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
            limit : "${dotas.pageSize}",
            groups : minShowPage,
            curr:"${dotas.curPage}",
            prev:"<",
            next:">",
            jump : function(obj, first) {
                if(!first){
                    var params = "type="+techType+"&pageIndex="+obj.curr+"&pagelimit="+obj.limit;
                    window.location ="/blog/dotaDiary?"+params;
                }
            }
        };
        laypage.render(pageInitParams);
    });

</script>
</html>