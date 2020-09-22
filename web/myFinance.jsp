<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>boot</title>
    <link href="plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/myFinance.css" rel="stylesheet">
</head>
<body>
<div class="my-body">
    <div class="panel panel-default">
        <div class="panel-heading">我的财务</div>
        <div class="panel-body">
            <form class="navbar-form navbar-left" role="search">
                <div class="input-group">
                    <div class="input-group-addon">财务编码</div>
                    <input type="text" class="form-control" placeholder="请输入财务编码...">
                </div>
                <button type="submit" class="btn btn-default">搜索</button>
            </form>

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
<script src="js/myFinance.js"></script>
</body>
</html>
