<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>资产管理界面</title>
    <link href="plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">
</head>
<body>
<div class="modal fade mymodel" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">个人资料页面</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label for="staffId">
                        <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                        用户id</label>
                    <input type="text" class="form-control" id="staffId" disabled="disabled" v-model="staffId">
                </div>
                <div class="form-group">
                    <label for="staffName">
                        <span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
                        用户姓名</label>
                    <input type="text" class="form-control" id="staffName"  v-model="staffName">
                </div>
                <div class="form-group">
                    <label for="staffYear">
                        <span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
                        工龄</label>
                    <input type="text" class="form-control" id="staffYear" disabled="disabled" v-model="staffYear">
                </div>

                <div class="form-group">
                    <label for="staffSex">
                        <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                        性别</label>
                    <input type="text" class="form-control" id="staffSex"  v-model="staffSex">
                </div>
                <div class="form-group">
                    <label for="staffAccount">
                        <span class="glyphicon glyphicon-adjust" aria-hidden="true"></span>
                        账号</label>
                    <input type="text" class="form-control" id="staffAccount" disabled="disabled" v-model="staffAccount">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </div>
                <div class="form-group">
                    <label for="staffPassword">
                        <span class="glyphicon glyphicon-picture" aria-hidden="true"></span>
                        密码</label>
                    <input type="text" class="form-control" id="staffPassword"  v-model="staffPassword">
                </div>
                <div class="form-group">
                    <label for="staffRole">
                        <span class="glyphicon glyphicon-save" aria-hidden="true"></span>
                        角色</label>
                    <input type="text" class="form-control" id="staffRole"  disabled="disabled" v-model="staffRole">
                </div>
                <div class="form-group">
                    <label for="staffState">
                        <span class="glyphicon glyphicon-save" aria-hidden="true"></span>
                        状态</label>
                    <input type="text" class="form-control" id="staffState" disabled="disabled" v-model="staffState">
                </div>


            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" v-on:click="doChange">保存</button>
            </div>
        </div>
    </div>
</div>
<div class="main">
    <div>
        <nav class="navbar navbar-default my-nav">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
                            aria-expanded="false">
                        <span class="sr-only"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">资产管理系统</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="welcomeName" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                欢迎您！<span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#" data-toggle="modal" data-target="#myModal">修改资料</a></li>
                                <!-- Modal -->
                                <li role="separator" class="divider"></li>
                                <li><a href="#" onclick="outLogin()">退出</a></li>
                            </ul>
                        </li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
    </div>
    <div>
        <div>
            <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingOne">
                        <h4 class="panel-title">
                            <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true"
                               aria-controls="collapseOne">
                                资产
                            </a>
                        </h4>
                    </div>
                    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                        <div class="panel-body">
                            <a url="assetTab.jsp" class="btn btn-link btn-block mybtn" role="button">资产列表</a>
                            <a url="myAsset.jsp" class="btn btn-link btn-block mybtn" role="button">我的资产</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div>
            <iframe id="myif" src="assetTab.jsp" border="0" frameborder="0" width="100%" height="100%"></iframe>
        </div>

    </div>
    <div>
        CopyRight© 吴文敏版权所有
    </div>
</div>


<script src="plugins/jq/jquery.min.js"></script>
<script src="plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="plugins/vue/vue.js"></script>
<script src="js/main.js"></script>
<script src="js/main2.js"></script>
</body>
</html>
