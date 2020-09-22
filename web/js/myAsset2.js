function getRowObj(obj) {
    var i = 0;
    while (obj.tagName.toLowerCase() != "tr") {
        obj = obj.parentNode;
        if (obj.tagName.toLowerCase() == "table")
            return null;
    }
    return obj;
}

function doReturn(obj) {
    var trObj = getRowObj(obj);
    var tableId = document.getElementById("myTable");
    var trArr = trObj.parentNode.children;
    var assetId = 0;
    for (var trNo = 0; trNo < trArr.length; trNo++) {
        if (trObj == trObj.parentNode.children[trNo]) {
            assetId = tableId.rows[trNo].cells[1].innerHTML;
        }
    }
    if(confirm("确定归还吗？")){

    }else{
        return;
    }
    $.ajax({
        url: "/doReturn.ajax",
        type: "POST",
        data: {
            assetId: assetId
        },
        dataType: "JSON",
        success: function (data) {
            if (data.code === 0) {
                alert("归还成功！");
            } else {
                alert("归还失败！");
            }
        },
        error: function () {
            alert("err");
        }
    });
}
