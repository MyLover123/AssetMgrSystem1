<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>boot</title>
    <link href="plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/staffTab.css" rel="stylesheet">
</head>
<body>
<div class="my-body">
    <div class="panel panel-default">
        <div class="panel-heading">用户列表</div>
        <div class="panel-body">
            <form class="navbar-form navbar-left" role="search">
                <div class="input-group">
                    <div class="input-group-addon">编号</div>
                    <input type="text" class="form-control" placeholder="请输入编号...">
                </div>
                <button type="submit" class="btn btn-default">搜索</button>
            </form>


            <div class="center-block" align="center ">
                <button type="button" class="btn btn-primary " data-toggle="modal" data-target="#myModal" >
                    添加员工
                </button>

                <!-- Modal -->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="myModalLabel">员工</h4>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    <label for="staffName">
                                        <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                                        员工姓名</label>
                                    <input type="text" class="form-control" id="staffName" placeholder="请输入员工姓名" v-model="staffName">
                                </div>
                                <div class="form-group">
                                    <label for="staffYear">
                                        <span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
                                        员工工龄</label>
                                    <input type="text" class="form-control" id="staffYear" placeholder="请输入员工工龄" v-model="staffYear">
                                </div>
                                <div class="form-group">
                                    <label for="staffSex">
                                        <span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
                                        员工性别</label>
                                    <input type="text" class="form-control" id="staffSex" placeholder="请输入员工性别" v-model="staffSex">
                                </div>

                                <div class="form-group">
                                    <label for="staffAccount">
                                        <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                                        员工账号</label>
                                    <input type="text" class="form-control" id="staffAccount" placeholder="请输入员工账号" v-model="staffAccount">
                                </div>
                                <div class="form-group">
                                    <label for="staffPassword">
                                        <span class="glyphicon glyphicon-adjust" aria-hidden="true"></span>
                                        员工密码</label>
                                    <input type="text" class="form-control" id="staffPassword" placeholder="请输入员工密码" v-model="staffPassword">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                </div>
                                <div class="form-group">
                                    <label for="staffRole">
                                        <span class="glyphicon glyphicon-adjust" aria-hidden="true"></span>
                                        员工角色</label>
                                    <input type="text" class="form-control" id="staffRole" placeholder="请输入员工角色" v-model="staffRole">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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
    <table class="table table-bordered table-hover table-condensed myTable" id="myTable">
        <tr class="active">
            <td>编号</td>
            <td>角色</td>
            <td>姓名</td>
            <td>工龄</td>
            <td>性别</td>
            <td>账号</td>
            <td>密码</td>
            <td>状态</td>
            <td>操作</td>
        </tr>
        <tr v-for="da in list" class="staff">
            <td>{{da.id}}</td>
            <td>{{da.role}}</td>
            <td>{{da.name}}</td>
            <td>{{da.year}}</td>
            <td>{{da.sex}}</td>
            <td>{{da.account}}</td>
            <td>{{da.password}}</td>
            <td class="state">{{da.state}}</td>
            <td>
                <button type="button" class="glyphicon glyphicon-remove-circle btn btn-default" aria-hidden="true" title="删除" onclick="doDelete(this)"></button>
                <button type="button" class="glyphicon glyphicon-lock btn btn-default dolock" aria-hidden="true" title="锁定" onclick="doLock(this)"></button>
                <button type="button" class="glyphicon glyphicon-repeat btn btn-default" aria-hidden="true" title="重置密码" onclick="doReset(this)"></button>
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
<script src="js/staffTab.js"></script>
</body>
</html>
