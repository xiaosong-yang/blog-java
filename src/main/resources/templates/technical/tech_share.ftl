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
                <span style="margin-left: 10px;">技术分类</span>
            </div>
            <div class="content-div" style="overflow: hidden;">
                <div style="font-size: 15px;margin-left:-2%;">
                    <#list techTypes as techtype>
                    <button class="layui-btn layui-btn-sm layui-btn-warm types" onclick="getTechList('${techtype.typeName}');">${techtype.typeName} (${techtype.count})</button>
                    </#list>
                </div>

            </div>
        </div>
    </div>
    <script type="text/javascript">
        function getTechList(type){
            var params = "type="+type+"&pageIndex=1&pagelimit="+pageSize;
            window.location="/blog/shareTechnical?"+params;
        }
    </script>


    <div class="col-xs-12 col-sm-6">
        <div class="row">
            <div class="col-sm-12" id="main_container" style="min-height: 80%;">
                <div class="row">

                    <div
                            style="background-color: white; overflow: hidden;">
                        <div
                              clas="col-sm-12 diary-type-sm diary-type-xs"  style="margin-left: 1%; margin-top: 10px;font-weight: 600;">技术分享</div>
                        <div
                                class="col-xs-12" style="height: 2px; background-color: orange;"></div>
                        <div
                               class="col-xs-12">
                            <#list techList.result as tech>
                            <div class="item">
                                <div style="overflow: hidden;">
                                    <a href="/blog/shareTechDetail?technicalId=${tech.id}" class="col-sm-4 hidden-xs"><img
                                                src="${tech.faceUrl}" style="width: 100%;"/></a>
                                    <div class="col-sm-8 col-xs-12">
                                        <h3 style="font-size: 18px; font-weight: 600;">
                                            <a href="/blog/shareTechDetail?technicalId=${tech.id}">${tech.title}</a>
                                        </h3>
                                        <p
                                                style="word-break: break-all; text-overflow: ellipsis; overflow: hidden; font-size: 12px; color: gray; margin-top: 5px;">
                                            ${tech.overView}<a v-bind:href="/blog/shareTechDetail?technicalId=${tech.id}" style="color: black;">[详情]</a>
                                        </p>
                                        <p style="font-size: 12px; color: gray; margin-top: 5px;">
                                            <span><i class="fa fa-paperclip" aria-hidden="true"></i>&nbsp;${tech.type}</span>
                                            <span style="margin-left: 10px;"><i
                                                        class="fa fa-calendar-minus-o" aria-hidden="true"></i>&nbsp;${tech.time}</span>
                                            <span style="float: right;"><i class="fa fa-thumbs-o-up"
                                                                           aria-hidden="true"></i>（${tech.praiseCount}）</span> <span
                                                    style="float: right; margin-right: 10px;"><i
                                                        class="fa fa-eye" aria-hidden="true"></i>&nbsp;浏览数（${tech.browseCount}）</span>
                                            <span style="float: right; margin-right: 10px;"><i
                                                        class="fa fa-comment-o" aria-hidden="true"></i>&nbsp;评论数（${tech.commentCount}）</span>
                                        </p>
                                    </div>
                                </div>
                                <div style="height: 1px; background-color: gray; width: 100%; margin-top: 5px;"></div>
                            </div>
                            </#list>
                            <div style="display: inline-block; margin-left: 50%;" class="hidden-xs">
                                <div id="pagination" style="position: relative; right: 50%;"></div>
                            </div>
                            <div style="display: inline-block;" class="visible-xs-block">
                                <div id="paginationMin" style="float: right"></div>
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
    var menu_id = "menu_id2";
    //对于pcWeb
    var techType = "${nowType!}";
    layui.use('laypage',function() {
        var laypage = layui.laypage;
        var pageInitParams = {
            elem : 'pagination', //注意，这里的 test1 是 ID，不用加 # 号
            count : "${totalCount}",
            limit : "${techList.pageSize}",
            groups : showPages,
            curr:"${techList.curPage}",
            jump : function(obj, first) {
                if(!first){
                    var params = "type="+techType+"&pageIndex="+obj.curr+"&pagelimit="+obj.limit;
                    window.location ="/blog/shareTechnical?"+params;
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
            limit : "${techList.pageSize}",
            groups : minShowPage,
            curr:"${techList.curPage}",
            prev:"<",
            next:">",
            jump : function(obj, first) {
                if(!first){
                    var params = "type="+techType+"&pageIndex="+obj.curr+"&pagelimit="+obj.limit;
                    window.location ="/blog/shareTechnical?"+params;
                }
            }
        };
        laypage.render(pageInitParams);
    });

</script>
</html>