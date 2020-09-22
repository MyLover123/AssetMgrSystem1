var app = new Vue({
    el: '.my-body',
    data: {
        nowPage: 1,
        maxSize: 1,
        list: [],
        pageList: [],

        staffName: '',
        staffYear: '',
        staffSex: '',
        staffAccount: '',
        staffPassword: '',
        staffRole: ''

    },
    methods: {
        doAdd: function () {
            var staffName = this.staffName;
            var staffYear = this.staffYear;
            var staffSex = this.staffSex;
            var staffAccount = this.staffAccount;
            var staffPassword = this.staffPassword;
            var staffRole = this.staffRole;

            $.ajax({
                url: "/addStaff.ajax",
                type: "POST",
                data: {
                    staffName: staffName,
                    staffYear: staffYear,
                    staffSex: staffSex,
                    staffAccount: staffAccount,
                    staffPassword: staffPassword,
                    staffRole: staffRole
                },
                dataType: "JSON",
                success: function (data) {
                    if (data.code === 0) {
                        alert("添加成功！");
                    } else {
                        alert("添加失败！");
                    }
                },
                error: function () {
                    alert("err");
                }
            });

        },
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
                url: "/staff.ajax",
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

function doLock(obj) {
    var trObj = getRowObj(obj);
    var tableId = document.getElementById("myTable");
    var trArr = trObj.parentNode.children;
    var staffId = 0;
    for (var trNo = 0; trNo < trArr.length; trNo++) {
        if (trObj == trObj.parentNode.children[trNo]) {
            staffId = tableId.rows[trNo].cells[0].innerHTML;
        }
    }
    if(confirm("确定锁定/解锁吗？")){

    }else{
        return;
    }
    $.ajax({
        url: "/changeState.ajax",
        type: "POST",
        data: {
            staffId: staffId
        },
        dataType: "JSON",
        success: function (data) {
            if (data.code === 0){
                alert("解锁/锁定成功！");
                window.location.reload();
            } else {
                alert("操作失败！");
            }
        },
        error: function () {
            alert("err");
        }
    });
}

function doDelete(obj) {
    var trObj = getRowObj(obj);
    var tableId = document.getElementById("myTable");
    var trArr = trObj.parentNode.children;
    var staffId = 0;
    for (var trNo = 0; trNo < trArr.length; trNo++) {
        if (trObj == trObj.parentNode.children[trNo]) {
            staffId = tableId.rows[trNo].cells[0].innerHTML;
        }
    }

    if(confirm("确定删除吗？")){

    }else{
        return;
    }
    $.ajax({
        url: "/doDelete.ajax",
        type: "POST",
        data: {
            staffId: staffId
        },
        dataType: "JSON",
        success: function (data) {
            if (data.code === 0) {
                alert("删除成功！");
                window.location.reload();
            } else {
                alert("删除失败！");
            }
        },
        error: function () {
            alert("err");
        }
    });
}

function doReset(obj) {
    var trObj = getRowObj(obj);
    var tableId = document.getElementById("myTable");
    var trArr = trObj.parentNode.children;
    var staffId = 0;
    for (var trNo = 0; trNo < trArr.length; trNo++) {
        if (trObj == trObj.parentNode.children[trNo]) {
            staffId = tableId.rows[trNo].cells[0].innerHTML;
        }
    }
    if(confirm("确定重置密码吗？"+"\n(重置密码为：123456)")){

    }else{
        return;
    }

    $.ajax({
        url: "/doReset.ajax",
        type: "POST",
        data: {
            staffId: staffId
        },
        dataType: "JSON",
        success: function (data) {
            if (data.code === 0) {
                alert("重置成功！");
                window.location.reload();
            } else {
                alert("重置失败！");
            }
        },
        error: function () {
            alert("err");
        }
    });
}
