function getRowObj(obj) {
    var i = 0;
    while (obj.tagName.toLowerCase() != "tr") {
        obj = obj.parentNode;
        if (obj.tagName.toLowerCase() == "table")
            return null;
    }
    return obj;
}

function doApply(obj) {
    var trObj = getRowObj(obj);
    var tableId = document.getElementById("myTable");
    var trArr = trObj.parentNode.children;
    var state = " ";
    var assetId = 0;
    for (var trNo = 0; trNo < trArr.length; trNo++) {
        if (trObj == trObj.parentNode.children[trNo]) {
            state = tableId.rows[trNo].cells[14].innerHTML;
            assetId = tableId.rows[trNo].cells[4].innerHTML;
        }
    }
    var str = sessionStorage.obj;
    var account = str.replace("\"", "");
    account = account.substring(0, account.length - 1);

    if (state === "使用中") {
        alert("该产品已经被人使用!");
        return;
    }

    if (confirm("确定申请吗？")) {

    } else {
        return;
    }
    $.ajax({
        url: "/doApply.ajax",
        type: "POST",
        data: {
            assetId: assetId,
            account: account
        },
        dataType: "JSON",
        success: function (data) {
            if (data.code === 0) {
                alert("申请成功！");
                window.location.reload();
            } else {
                alert("申请失败！");
            }
        },
        error: function () {
            alert("err");
        }
    });
}