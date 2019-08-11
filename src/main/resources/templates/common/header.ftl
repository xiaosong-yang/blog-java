<div class="row">
    <div class="header" style="background: #408080;" id="header">
        <div class="col-sm-12">
        <div  style="z-index: 100">
            <h1 class="logo pull-left  col-sm-3 col-xs-9">
                <a href="/blog" target="_parent"> <img v-bind:src="logo_url" alt=""
                                                                  class="logo-img"><span class="title-sm title-xs" style="color: mediumblue;">程序员老杨的博客</span>
                </a>
            </h1>
            <div class="blog-nav pull-right">
                <ul class="layui-nav pull-left">
                    <li class="layui-nav-item" id="menu_id1"><a href="/blog" target="_parent">首页</a></li>
                    <li class="layui-nav-item" id="menu_id2"><a href="/blog/shareTechnical" target="_parent">技术分享</a>
                    </li>
                    <li class="layui-nav-item" id="menu_id3"><a href="/blog/diary" target="_parent">逝水流年</a>
                    </li>
                    <li class="layui-nav-item" id="menu_id4"><a href="/blog/dotaDiary" target="_parent">刀塔岁月</a>
                    </li>
                    <li class="layui-nav-item" id="menu_id5"><a href="/blog/book" target="_parent">私人书屋</a>
                    </li>
                    <li class="layui-nav-item" id="menu_id6"><a href="/blog/project" target="_parent">开源项目</a>
                    </li>
                </ul>
                <a href="/blog/" class="personal pull-left" target="_parent"> <i
                            class="layui-icon layui-icon-username"></i>
                </a>
            </div>
            <div class="mobile-nav pull-right" id="mobile-nav">
                <a href="javascript:;"> <i class="layui-icon layui-icon-more"></i>
                </a>
            </div>
        </div>
        <ul class="pop-nav" id="pop-nav" style="background-color:rgb(64, 128, 128);width: 40%;margin-left: 60%;">
            <li><a href="/blog/shareTechnical" target="_parent">技术分享</a></li>
            <li><a href="/blog/diary" target="_parent">逝水流年</a></li>
            <li><a href="/blog/dotaDiary" target="_parent">刀塔岁月</a></li>
            <li><a href="/blog/book" target="_parent">私人书屋</a></li>
            <li><a href="/blog/project" target="_parent">开源项目</a></li>
        </ul>
    </div>
    </div>

    <script type="application/javascript">

        // start 导航显示隐藏


        $(function () {
            $("#" + top.menu_id).addClass("layui-nav-item layui-this");

            $("#mobile-nav").on('click', function(){
                console.log("hahahah")
                $("#pop-nav").toggle();
            });
        })

        var vm = new Vue({
            el: "#header",
            data: {
                logo_url: ""
            }
        })
        $(function () {
            $.ajax({
                "url": "/blog/user/getUserLogo",
                "type": "POST",
                "success": function (response) {
                    vm.logo_url = response.rspContent;
                }
            })
        })
    </script>
</div>
