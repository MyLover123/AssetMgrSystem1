var app = new Vue({
    el: '.mymodel',
    data: {
        staffName:'',
        staffSex:'',
        staffPassword:''
    },
    methods: {
        doChange: function () {
            var str = sessionStorage.obj;
            var account = str.replace("\"", "");
            account = account.substring(0, account.length - 1);
            var staffName=this.staffName;
            var staffSex=this.staffSex;
            var staffPassword=this.staffPassword;

            $.ajax({
                url: "/changeStaff.ajax",
                type: "POST",
                data: {
                    staffName: staffName,
                    staffSex: staffSex,
                    account: account,
                    staffPassword: staffPassword
                },
                dataType: "JSON",
                success: function (data) {
                    if (data.code === 0) {
                        alert("修改成功！");
                    } else {
                        alert("修改失败！");
                    }
                },
                error: function () {
                    alert("err");
                }
            });

        }
    }
});

// function doSearchStaff() {
//     var str = sessionStorage.obj;
//     var account = str.replace("\"", "");
//     account = account.substring(0, account.length - 1);
//     $.ajax({
//         url: "/searchStaff.ajax",
//         type: "POST",
//         data: {
//             account: account
//         },
//         dataType: "JSON",
//         success: f(data),
//         error: function () {
//             alert("err");
//         }
//     });
// }
// function f(var data) {
//     $("#staffId").val(data.list);
// }
