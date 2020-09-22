<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>boot</title>
    <link href="plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/financeTab.css" rel="stylesheet">
</head>
<body>
<div class="my-body">
    <div class="panel panel-default">
        <div class="panel-heading">财务列表</div>
        <div class="panel-body">
            <form class="navbar-form navbar-left" role="search">
                <div class="input-group">
                    <div class="input-group-addon">财务编码</div>
                    <input type="text" class="form-control" placeholder="请输入财务编码...">
                </div>
                <button type="submit" class="btn btn-default">搜索</button>
            </form>
            <div class="center-block" align="center ">


                <!-- Modal -->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="myModalLabel">资产添加</h4>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    <label for="productName">
                                        <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                                        产品名称</label>
                                    <input type="text" class="form-control" id="productName" placeholder="请输入产品名称" v-model="productName">
                                </div>
                                <div class="form-group">
                                    <label for="productId">
                                        <span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
                                        产品序列号</label>
                                    <input type="text" class="form-control" id="productId" placeholder="请输入产品序列号" v-model="productId">
                                </div>
                                <div class="form-group">
                                    <label for="productModel">
                                        <span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
                                        规格型号</label>
                                    <input type="text" class="form-control" id="productModel" placeholder="请输入规格型号" v-model="productModel">
                                </div>

                                <div class="form-group">
                                    <label for="unit">
                                        <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                                        单位</label>
                                    <input type="text" class="form-control" id="unit" placeholder="请输入单位" v-model="unit">
                                </div>
                                <div class="form-group">
                                    <label for="num">
                                        <span class="glyphicon glyphicon-adjust" aria-hidden="true"></span>
                                        数量</label>
                                    <input type="text" class="form-control" id="num" placeholder="请输入数量" v-model="num">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                </div>
                                <div class="form-group">
                                    <label for="price">
                                        <span class="glyphicon glyphicon-picture" aria-hidden="true"></span>
                                        单价</label>
                                    <input type="text" class="form-control" id="price" placeholder="请输入单价" v-model="price">
                                </div>
                                <div class="form-group">
                                    <label for="datetime">
                                        <span class="glyphicon glyphicon-save" aria-hidden="true"></span>
                                        时间</label>
                                    <input type="date" class="form-control" id="datetime" placeholder="请输入时间" v-model="datetime">
                                </div>


                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                <button type="button" class="btn btn-primary" v-on:click="doAdd">保存</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </div>
    <table class="table table-bordered table-hover table-condensed">
        <tr class="active">
            <td>财务编码</td>
            <td>凭证码</td>
            <td>入账时期</td>
            <td>保管员</td>
        </tr>
        <tr v-for="da in list">
            <td>{{da.id}}</td>
            <td>{{da.voucherNo}}</td>
            <td>{{da.datetime}}</td>
            <td>{{da.name}}</td>
        </tr>
    </table>
    <div class="my-nav">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a aria-label="Previous" v-on:click="upPage()">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li v-for="page in pageList">
                    <a v-on:click="getData(page)">{{page}}</a>
                </li>
                <li>
                    <a aria-label="Next" v-on:click="downPage()">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
</div>
<script src="plugins/jq/jquery.min.js"></script>
<script src="plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="plugins/vue/vue.js"></script>
<script src="js/financeTab.js"></script>
</body>
</html>

