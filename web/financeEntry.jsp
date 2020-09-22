<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>boot</title>
    <link href="plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/financeEntry.css" rel="stylesheet">
</head>
<body>
<div class="my-body">
    <div class="panel panel-default">
        <div class="panel-heading">财务入账</div>
        <div class="panel-body">
            <form class="navbar-form navbar-left" role="search">
                <div class="input-group">
                    <div class="input-group-addon">资产编码</div>
                    <input type="text" class="form-control" placeholder="请输入资产编码...">
                </div>
                <button type="submit" class="btn btn-default">搜索</button>
            </form>
        </div>

    </div>
    <table class="table table-bordered table-hover table-condensed myTable" id="myTable" >
        <tr class="active">
            <td>产品编码</td>
            <td>产品序列号</td>
            <td>产品名称</td>
            <td>规格型号</td>
            <td>单位</td>
            <td>数量</td>
            <td>单价</td>
            <td>入库时间</td>
            <td>操作</td>
        </tr>
        <tr v-for="da in list">
            <td>{{da.id}}</td>
            <td>{{da.productId}}</td>
            <td>{{da.name}}</td>
            <td>{{da.model}}</td>
            <td>{{da.unit}}</td>
            <td>{{da.num}}</td>
            <td>{{da.price}}</td>
            <td>{{da.datetime}}</td>
            <td>
                <button type="button" class="glyphicon glyphicon-ok btn btn-default" aria-hidden="true" data-toggle="modal" data-target="#myModal" title="入账"></button>
                <!-- Modal -->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="myModalLabel">财务入账</h4>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    <label for="voucherId">
                                        <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                                        凭证号</label>
                                    <input type="text" class="form-control" id="voucherId" placeholder="请输入凭证号" v-model="voucherId">
                                </div>
                                <div class="form-group">
                                    <label for="datetime">
                                        <span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
                                        入账时间</label>
                                    <input type="date" class="form-control" id="datetime" placeholder="请输入入账时间" v-model="datetime">
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                <button type="button" class="btn btn-primary" onclick="doAdd(this)" >保存</button>
                            </div>
                        </div>
                    </div>
                </div>
            </td>
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
<script src="js/financeEntry.js"></script>
</body>
</html>