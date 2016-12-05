<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<head>
    <meta charset="UTF-8">
    <title>基础库</title>
</head>
<body>
<jsp:include page="common.jsp"></jsp:include>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">地理基础知识库</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">查询</a></li>
                <li><a href="http://ws.nju.edu.cn/explass/">关联搜索</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="http://ws2.nju.edu.cn/geokb-wiki/">关于我们</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">

    <div class="row">
        <div class="col-lg-3 center">
            <div class="input-group">
                <input type="text" id="search-input" class="form-control">
                <div class="input-group-btn">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">查询内容 <span
                            class="caret"></span></button>
                    <ul id="search-type" class="dropdown-menu dropdown-menu-right" role="menu">
                        <li><a id="1" onclick="search_input(this.id)">基础信息</a></li>
                        <li><a id="2" onclick="search_input(this.id)">附近城市</a></li>
                        <li><a id="3" onclick="search_input(this.id)">国家信息</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>