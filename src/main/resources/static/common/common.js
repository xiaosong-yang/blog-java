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

/**
 * 获取链接参数(有中文的参数，英文也可以)
 * @param name 参数key
 * @returns 参数value
 */
function GetCNQueryString(name)  
{  
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");  
     var r = encodeURI(window.location.search).substr(1).match(reg);  
     if(r!=null)return  decodeURI(unescape(r[2])); return null;  
}

var pageSize=10;

var showPages=10;




var browserVersion = window.navigator.userAgent.toUpperCase();
var isOpera = browserVersion.indexOf("OPERA") > -1 ? true : false;
var isFireFox = browserVersion.indexOf("FIREFOX") > -1 ? true : false;
var isChrome = browserVersion.indexOf("CHROME") > -1 ? true : false;
var isSafari = browserVersion.indexOf("SAFARI") > -1 ? true : false;
var isIE = (!!window.ActiveXObject || "ActiveXObject" in window);
var isIE9More = (! -[1, ] == false);


function reinitIframe(iframeId, minHeight) {
    try {
        var iframe = document.getElementById(iframeId);
        var bHeight = 0;
        if (isChrome == false && isSafari == false)
            bHeight = iframe.contentWindow.document.body.scrollHeight;

        var dHeight = 0;
        if (isFireFox == true)
            dHeight = iframe.contentWindow.document.documentElement.offsetHeight + 2;
        else if (isIE == false && isOpera == false)
            dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
        else if (isIE == true && isIE9More) {//ie9+
            var heightDeviation = bHeight - eval("window.IE9MoreRealHeight" + iframeId);
            if (heightDeviation == 0) {
                bHeight += 3;
            } else if (heightDeviation != 3) {
                eval("window.IE9MoreRealHeight" + iframeId + "=" + bHeight);
                bHeight += 3;
            }
        }
        else//ie[6-8]、OPERA
            bHeight += 3;

        var height = Math.max(bHeight, dHeight);
        if (height < minHeight) height = minHeight;
        iframe.style.height = height + "px";
    } catch (ex) { }
}
function startInit(iframeId, minHeight) {
    eval("window.IE9MoreRealHeight" + iframeId + "=0");
    window.setInterval("reinitIframe('" + iframeId + "'," + minHeight + ")", 100);
}


