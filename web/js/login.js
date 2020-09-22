var app = new Vue({
    el: '.login',
    data: {
        username: '',
        passwd: ''
    },
    methods: {
        doLogin: function () {
            var username = this.username;
            var passwd = this.passwd;
            var role = $("input[name='role']:checked").val();
            if (username === "") {
                alert("用户名不能为空");
                return;
            }
            if (passwd === "") {
                alert("密码不能为空");
                return;
            }
            $.ajax({
                url: "/login.ajax",
                type: "POST",
                data: {
                    uname: username,
                    passwd: passwd,
                    role: role
                },
                dataType: "JSON",
                success: function (data) {
                    if (data.code === 0) {
                        sessionStorage.obj=JSON.stringify(username);
                        if(role==="3"){
                            window.location.href = "/main.jsp";
                            alert("登录成功!");
                        }else if(role==="2"){
                            window.location.href = "/commonMain.jsp";
                            alert("登录成功!");
                        }else {
                            window.location.href = "/financeMain.jsp";
                            alert("登录成功!");
                        }

                    } else {
                        alert("您的用户名或密码错误!(或账号被锁定)");
                    }
                },
                error: function () {
                    alert("err");
                }
            });
        }
    }
});
