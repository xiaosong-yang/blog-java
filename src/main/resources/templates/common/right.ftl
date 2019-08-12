<div id="right" class="hidden-xs col-xs-3 col-sm-3">
    <div class="float-board-right">
        <div class="title-div">
            <span style="margin-left: 10px;">联系我</span>
        </div>
        <div class="content-div">
            <div class="center-header-pic">
                <img alt="" src="${connectInfos.wechat}"
                     width="40%" height="70%;" style="float: left;" id="right_wechat_pic"
                > <img alt="" src="${connectInfos.qq}" width="40%"
                       height="70%;" style="float: right;" id="right_qq_pic"
                >
            </div>
            <div style="margin: 15px 15px;">
                <label style="font-weight: bold; font-size: 18px;">邮箱 ：</label> <span
                        style="font-size: 16px;">${connectInfos.email}</span>
            </div>
        </div>
    </div>
    <div class="float-board-right" style="margin-top: 20px;">
        <div class="title-div">
            <span style="margin-left: 10px;">心情</span>
        </div>
        <div class="content-div">
            <ul class="layui-timeline" style="margin-right: 10px;">
                <#list moods as mood>
                <li class="layui-timeline-item"><i
                            class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">${mood.time}</h3>
                        <p>${mood.content}
                        </p>
                    </div></li>
                </#list>
                <li class="layui-timeline-item"><i
                            class="layui-icon layui-timeline-axis"></i>
                    <div class="layui-timeline-content layui-text">
                    </div></li>
            </ul>
        </div>
    </div>
</div>
<script type="text/javascript">

    // var vm4=new Vue({
    //     el:"#right",
    //     data:{
    //         wechat:"",
    //         qq:"",
    //         email:"",
    //         moods:[]
    //     }
    // })

    $(function(){
        $("#right_wechat_pic").hover(function(){
            top.show_big_pic("${connectInfos.wechat}");
        },function(){

        })
        $("#right_qq_pic").hover(function(){
            top.show_big_pic("${connectInfos.qq}");
        },function(){

        })

    })
</script>