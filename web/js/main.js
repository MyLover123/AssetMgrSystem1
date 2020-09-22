$(".mybtn").bind("click", function () {
    var url = $(this).attr("url");
    $("#myif").attr("src", url);
});

function outLogin() {
    window.location.href = "/login.html";
    alert("退出成功！");
}

$(function () {
    var str = sessionStorage.obj;
    var account = str.replace("\"", "");
    account = account.substring(0, account.length - 1);
    $.ajax({
        url: "/searchName.ajax",
        type: "POST",
        data: {
            account: account
        },
        dataType: "JSON",
        success: function (data) {
            $(".welcomeName").append(data.name);
        },
        error: function () {
            alert("err");
        }
    });
})

// function outLogin() {
//     $.ajax({
//         url : "/out-login",
//         type : "POST",
//         dataType : "JSON",
//         success : function (data) {
//             if (data.type) {
//                 alert("退出成功");
//                 window.location.href = "login.html";
//             } else {
//                 alert("系统异常");
//             }
//         },
//         error : function () {
//             alert("err");
//         }
//     });
// }