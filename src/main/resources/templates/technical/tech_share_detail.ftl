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
                    <button class="layui-btn layui-btn-sm layui-btn-warm types"
                            onclick="getTechList('${techtype.typeName}');">${techtype.typeName} (${techtype.count})
                    </button>
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
        // var vm5 = new Vue({
        //     el: "#left",
        //     data: {
        //         techTypes: []
        //     },
        //     methods:{
        //         getTechList:function(type){
        //             vm6.getTechList(type);
        //         }
        //     }
        // })
        //
        // $(function () {
        //     $.ajax({
        //         "url": "/blog/technical/getTechTypes",
        //         "type": "POST",
        //         "success": function (response) {
        //             if (response.rspType == "rspSuccess") {
        //                 vm5.techTypes = response.rspContent;
        //             } else if (response.rspType == "rspFail") {
        //                 show_warn_dialog(response.failReason);
        //             }
        //         }
        //     });
        // })

    </script>


    <div class="col-xs-12 col-sm-6">
        <div class="row">
            <div class="col-sm-12" id="main_container" style="min-height: 80%;">
                <div class="row">
                    <div class="col-xs-12">
                        <div
                                style="float: left; width: 100%; margin-left: 10px; margin-top: 10px; font-weight: 600; font-size: 24px;">
                            ${techdetail.title}
                            <div
                                    style="float: right; margin-right: 5%; font-weight: 500; font-size: 15px; vertical-align: middle;">
                                <a href="javascript:history.back(-1);">返回</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-12">
                        <div
                                style="float: left; width: 100%; margin-left: 15px; margin-top: 10px; font-size: 12px; color: gray;">
                            <i class="fa fa-calendar-o" aria-hidden="true"></i> <span
                                    style="margin-left: 10px;">${techdetail.time}</span>
                        </div>
                    </div>
                    <div class="col-xs-12">
                        <div
                             style="float: left; width: 95%; margin-left: 15px; margin-top: 10px; font-size: 16px; color: black; text-indent: 2em; line-height: 28px;">
                            ${techdetail.content}
                        </div>
                    </div>
                    <div class="col-xs-12">
                        <div
                                style="float: left; width: 100%; font-weight: 600; margin-left: 20px; margin-top: 30px;">
                            打赏</div>
                        <div
                                style="float: left; width: 100%; height: 1px; background-color: orange;"></div>
                    </div>
                    <div class="col-xs-12">
                        <div style="float: left; width: 100%; font-weight: 600;">
                            <div class="center-header-pic" style="width: 60%;">
                                <img alt="" src="${aliPay}" width="40%" height="70%;"
                                     style="float: left;" id="wechat_pic"> <img alt=""
                                                                                src="${wehcatPay}" width="40%" height="70%;"
                                                                                style="float: right;" id="qq_pic">
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-12">
                        <div id="SOHUCS" style="width:98%;"></div>
                        <#--<div id="gitalk-container"></div>-->
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

    (function () {
        var appid = 'cytOjncda';
        var conf = 'prod_5293b3ef1a37c9b2d932ef376da02941';
        var width = window.innerWidth || document.documentElement.clientWidth;
        if (width < 960) {


            var cnzz_s_tag =document.createElement('script');


            cnzz_s_tag.type ='text/javascript';

            cnzz_s_tag.id= 'changyan_mobile_js'


            cnzz_s_tag.async =true;


            cnzz_s_tag.charset= 'utf-8';


            cnzz_s_tag.src ='https://changyan.sohu.com/upload/mobile/wap-js/changyan_mobile.js?client_id=' + appid + '&conf=' + conf;


            var root_s =document.getElementsByTagName('script')[0];


            root_s.parentNode.insertBefore(cnzz_s_tag,root_s);


            // window.document.write('<script id="changyan_mobile_js" charset="utf-8" type="text/javascript" src="https://changyan.sohu.com/upload/mobile/wap-js/changyan_mobile.js?client_id=' + appid + '&conf=' + conf + '"><\/script>');
        } else {
            var loadJs = function (d, a) {
                var c = document.getElementsByTagName("head")[0] || document.head || document.documentElement;
                var b = document.createElement("script");
                b.setAttribute("type", "text/javascript");
                b.setAttribute("charset", "UTF-8");
                b.setAttribute("src", d);
                if (typeof a === "function") {
                    if (window.attachEvent) {
                        b.onreadystatechange = function () {
                            var e = b.readyState;
                            if (e === "loaded" || e === "complete") {
                                b.onreadystatechange = null;
                                a()
                            }
                        }
                    } else {
                        b.onload = a
                    }
                }
                c.appendChild(b)
            };
            loadJs("https://changyan.sohu.com/upload/changyan.js", function () {
                window.changyan.api.config({appid: appid, conf: conf})
            });
        }
    })();

</script>
</html>