<div id="left" class="hidden-xs col-xs-3 col-sm-3">
    <!-- 	<div style="float: left; width: 20%;"> -->
    <div class="float-board-left">
        <div class="title-div">
            <span style="margin-left: 10px;">个人资料</span>
        </div>
        <div class="content-div">
            <div class="center-header-pic">
                <img alt="" src="${photoAndTips.photo}" width="100%"
                     height="70%;">
            </div>
            <div style="margin: 15px 15px;">
                <label style="font-weight: bold; font-size: 18px;">标签：</label> <span
                        style="font-size: 16px;">${photoAndTips.tips}</span>
            </div>
        </div>
    </div>
    <div class="float-board-left" style="margin-top: 20px;">
        <div class="title-div">
            <span style="margin-left: 10px;">最新书藏</span>
        </div>
        <div class="content-div">
            <div style="margin-left: 20px; font-size: 15px;">
                <#list books as book>
                    <div style="margin-top: 20px;" >
                    <i class="fa fa-circle"></i> <span><a href="/blog/bookDetail?bookId=${book.bookId}" target="_blank">《${book.bookName}》</a></span>
                    </div>
                </#list>
            </div>

        </div>

        <script type="text/javascript">
            // var vm5 = new Vue({
            //     el: "#left",
            //     data: {
            //         photo_url: "",
            //         tips: "",
            //         books: []
            //     }
            // })
            // console.log("执行到此处");

            // $(function () {
            //     $.ajax({
            //         "url": "/blog/user/getPhotoAndTips",
            //         "type": "POST",
            //         "success": function (response) {
            //             if (response.rspType == "rspSuccess") {
            //                 vm5.photo_url = response.rspContent.photo;
            //                 vm5.tips = response.rspContent.tips;
            //                 console.log(vm5.tips);
            //             } else if (response.rspType == "rspFail") {
            //                 top.show_warn_dialog(response.failReason);
            //             }
            //         }
            //     });
            //     $.ajax({
            //         "url": "/blog/book/getNearlyBooks",
            //         "type": "POST",
            //         "success": function (response) {
            //             if (response.rspType == "rspSuccess") {
            //                 vm5.books = response.rspContent;
            //             } else if (response.rspType == "rspFail") {
            //                 top.show_warn_dialog(response.failReason);
            //             }
            //         }
            //     });
            // })
        </script>

    </div>


</div>

