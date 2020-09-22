// var app = new Vue({
//     el: '.my-body',
//     data: {
//         nowPage: 1,
//         maxSize: 1,
//         searchLise:[],
//         pageList: [],
//
//         aid:''
//
//     },
//     methods: {
//         doSearch:function(){
//             var aid=this.aid;
//
//             $.ajax({
//                 url: "/searchAsset.ajax",
//                 type: "POST",
//                 data: {
//                     aid:aid
//                 },
//                 dataType: "JSON",
//                 success: function (searchData) {
//                     app.maxSize = searchData.maxSize;
//                     app.pageList = [];
//                     for (var i = 1; i <= searchData.maxSize; i++) {
//                         app.pageList.push(i);
//                     }
//                     app.searchLise = searchData.list;
//                 },
//                 error: function () {
//                     alert("err");
//                 }
//             });
//         },
//         upPage: function () {
//             if (this.nowPage === 1) {
//                 this.nowPage = 1;
//             } else {
//                 this.nowPage = this.nowPage - 1;
//                 this.getData(this.nowPage);
//             }
//         },
//         downPage: function () {
//             var maxSize = this.maxSize;
//             if (this.nowPage === maxSize) {
//                 this.nowPage = maxSize;
//             } else {
//                 this.nowPage = this.nowPage + 1;
//                 this.getData(this.nowPage);
//             }
//         },
//         getData: function (indexPage) {
//             $.ajax({
//                 url: "/asset",
//                 type: "POST",
//                 data: {
//                     index: indexPage
//                 },
//                 dataType: "JSON",
//                 success: function (data) {
//                     app.maxSize = data.maxSize;
//                     app.pageList = [];
//                     for (var i = 1; i <= data.maxSize; i++) {
//                         app.pageList.push(i);
//                     }
//                     app.list = data.list;
//                 },
//                 error: function () {
//                     alert("err");
//                 }
//             });
//         }
//     }
// });
// app.getData(1);