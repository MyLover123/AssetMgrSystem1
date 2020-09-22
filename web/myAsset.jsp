<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>boot</title>
    <link href="plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/myAsset.css" rel="stylesheet">
</head>
<body>
<div class="my-body">
    <div class="panel panel-default">
        <div class="panel-heading">我的资产</div>
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
            <td>卡片编号</td>

            <td>资产编码</td>
            <td>产品序列号</td>
            <td>资产类别</td>
            <td>资产名称</td>
            <td>规格型号</td>
            <td>入库时间</td>
            <td>单位</td>
            <td>数量</td>
            <td>单价</td>
            <td>保管人</td>
            <td>使用人</td>
            <td>操作</td>
        </tr>
        <tr v-for="da in list">
            <td>{{da.id}}</td>

            <td>{{da.assetId}}</td>
            <td>{{da.productId}}</td>
            <td>{{da.typeId}}</td>
            <td>{{da.name}}</td>
            <td>{{da.model}}</td>
            <td>{{da.datetime}}</td>
            <td>{{da.unit}}</td>
            <td>{{da.num}}</td>
            <td>{{da.price}}</td>
            <td>保密</td>
            <td class="user"></td>
            <td>
                <button type="button" class="glyphicon glyphicon-remove btn btn-default" aria-hidden="true" title="归还" onclick="doReturn(this)"></button>
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
<script src="js/myAsset.js"></script>
<script src="js/myAsset2.js"></script>
</body>
</html>
