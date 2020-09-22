var app = new Vue({
    el: '.my-body',
    data: {
        nowPage: 1,
        maxSize: 1,
        list: [],
        pageList: [],

        voucherId: '',
        datetime: ''

    },
    methods: {
        upPage: function () {
            if (this.nowPage === 1) {
                this.nowPage = 1;
            } else {
                this.nowPage = this.nowPage - 1;
                this.getData(this.nowPage);
            }
        },
        downPage: function () {
            var maxSize = this.maxSize;
            if (this.nowPage === maxSize) {
                this.nowPage = maxSize;
            } else {
                this.nowPage = this.nowPage + 1;
                this.getData(this.nowPage);
            }
        },
        getData: function (indexPage) {
            $.ajax({
                url: "/financeEntry.ajax",
                type: "POST",
                data: {
                    index: indexPage
                },
                dataType: "JSON",
                success: function (data) {
                    app.maxSize = data.maxSize;
                    app.pageList = [];
                    for (var i = 1; i <= data.maxSize; i++) {
                        app.pageList.push(i);
                    }
                    app.list = data.list;
                },
                error: function () {
                    alert("err");
                }
            });
        }
    }
});
app.getData(1);
function getRowObj(obj) {
    var i = 0;
    while (obj.tagName.toLowerCase() != "tr") {
        obj = obj.parentNode;
        if (obj.tagName.toLowerCase() == "table")
            return null;
    }
    return obj;
}
function doAdd(obj) {
    var trObj = getRowObj(obj);
    var tableId = document.getElementById("myTable");
    var trArr = trObj.parentNode.children;
    var productId = 0;
    for (var trNo = 0; trNo < trArr.length; trNo++) {
        if (trObj == trObj.parentNode.children[trNo]) {
            productId = tableId.rows[trNo].cells[0].innerHTML;
        }
    }
    var str = sessionStorage.obj;
    var account = str.replace("\"", "");
    account = account.substring(0, account.length - 1);

    var voucherId = document.getElementById("voucherId").value;
    var datetime = document.getElementById("datetime").value;

    $.ajax({
        url: "/addFinance.ajax",
        type: "POST",
        data: {
            productId: productId,
            voucherId: voucherId,
            datetime: datetime,
            account: account
        },
        dataType: "JSON",
        success: function (data) {
            if (data.code === 0) {
                alert("入账成功！");
                window.location.reload();
            } else {
                alert("入账失败！");
            }
        },
        error: function () {
            alert("err");
        }
    });

}