var projectName="/blog";

document.write('<meta name="viewport" content="width=device-width, initial-scale=1">')
document.write('<link rel="stylesheet" href="'+projectName+'/layui/css/layui.css">')
document.write('<link rel="stylesheet" href="'+projectName+'/css/mian.css">')
document.write('<link rel="stylesheet" href="'+projectName+'/css/yyf256.min.css">')
document.write('<link rel="stylesheet" href="'+projectName+'/font-awesome-4.7.0/css/font-awesome.min.css">')
document.write('<script src="'+projectName+'/layui/layui.js"></script>')
document.write('<script src="'+projectName+'/js/jquery-1.8.3.min.js"></script>')
document.write('<script src="'+projectName+'/js/vue.min.js"></script>')


function show_big_pic(url) {
	top.layui.use('layer', function() {
		var layer = layui.layer;
		layer.msg('<img src="' + url + '" width="80%;"></img>');
	});
}

function show_warn_dialog(msg) {
	top.layui.use('layer', function() {
		var layer = layui.layer;
		layer.open({
			  title: '提示'
			  ,content: '<div style="display: inline-block; margin-left: 50%;"><div id="pagination" style="position: relative; right: 50%;">'+msg+'</div></div>'
			});  
	});
}

/**
 * 获取链接参数
 * @param name 参数key
 * @returns 参数value
 */
function GetQueryString(name)  
{  
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");  
     var r = window.location.search.substr(1).match(reg);  
     if(r!=null)return  unescape(r[2]); return null;  
}


var pageSize=10;

var showPages=10;


/**
 * iframe自适应高度，height为手动设置的最小高度
 */
function initIframeHeight(height,frame_id){
    var userAgent = navigator.userAgent;
//    var iframe = document.getElementById(frame_id);
    var iframe=$("#"+frame_id);
    var subdoc = iframe.contentDocument || iframe.contentWindow.document;
    var subbody = subdoc.body;
    var realHeight;
    //谷歌浏览器特殊处理
    if(userAgent.indexOf("Chrome") > -1){
        realHeight = subdoc.documentElement.scrollHeight;
    }
    else{
        realHeight = subbody.scrollHeight;
    }
    if(realHeight < height){
        $("#"+frame_id).height(height);
    }
    else{
        $("#"+frame_id).height(realHeight);
    }
}