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
                <span style="margin-left: 10px;">项目分类</span>
            </div>
            <div class="content-div" style="overflow: hidden;">
                <div style="margin-left: 10px; font-size: 15px;">
                    <button class="layui-btn layui-btn-sm layui-btn-warm types">Java后端</button>
                    <button class="layui-btn layui-btn-sm layui-btn-warm types">Web前端</button>
                    <button class="layui-btn layui-btn-sm layui-btn-warm types">Python</button>
                </div>

            </div>
        </div>
    </div>

    <script type="text/javascript">
        var vm5 = new Vue({
            el: "#left",
            data: {}
        })


    </script>


    <div class="col-xs-12 col-sm-6">
        <div class="row">
            <div class="col-sm-12" id="main_container" style="min-height: 80%;">
                <div class="row">

                    <div
                            style="background-color: white; overflow: hidden;">
                        <div
                                clas="col-sm-12 diary-type-sm diary-type-xs"
                                style="margin-left: 1%; margin-top: 10px;font-weight: 600;">开源项目
                        </div>
                        <div
                                class="col-xs-12" style="height: 2px; background-color: orange;"></div>
                        <div
                                class="col-xs-12">
                            <div style="display: inline-block; margin-left: 50%;">
                                <div id="pagination" style="position: relative; right: 50%;color: gray;">
                                    <div>个人项目暂不开放，尽请期待！</div>
                                </div>
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
    var menu_id = "menu_id6";
    var vm6 = new Vue({
        el: "#main_container",
        data: {},
        methods: {}
    })
</script>
</html>