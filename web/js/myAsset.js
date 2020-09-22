var app = new Vue({
    el: '.my-body',
    data: {
        nowPage: 1,
        maxSize: 1,
        list: [],
        pageList: [],

        productId:'',
        productName:'',
        productModel:'',
        unit:'',
        num:'',
        price:'',
        datetime:''

    },
    methods: {
        doAdd:function(){
            var productId=this.productId;
            var productName=this.productName;
            var productModel=this.productModel;
            var unit=this.unit;
            var num=this.num;
            var price=this.price;
            var datetime=this.datetime;

            $.ajax({
                url: "/addAsset.ajax",
                type: "POST",
                data: {
                    productId: productId,
                    productName: productName,
                    productModel: productModel,
                    unit: unit,
                    num: num,
                    price: price,
                    datetime: datetime,
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
            var str=sessionStorage.obj;
            var account=str.replace("\"","");
            account=account.substring(0,account.length-1);
            $.ajax({
                url: "/myAsset.ajax",
                type: "POST",
                data: {
                    index: indexPage,
                    account:account
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



$(function () {
    var str=sessionStorage.obj;
    var account=str.replace("\"","");
    account=account.substring(0,account.length-1);
    $.ajax({
        url: "/searchName.ajax",
        type: "POST",
        data: {
            account: account
        },
        dataType: "JSON",
        success: function (data) {
            $(".user").append(data.name);
        },
        error: function () {
            alert("err");
        }
    });
});

