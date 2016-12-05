<html lang="zh-CN">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="name" scope="request" type="java.lang.String"/>
<jsp:useBean id="selections" scope="request" type="java.util.List"/>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
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
                <li><a href="/geonamesplus/">查询</a></li>
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
        <div class="col-lg-4 top">
            <div class="input-group">
                <input type="text" id="search-input" class="form-control" value="${name}">
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

            <table class="table table-striped table-margin-top">
                <tr>
                    <td>标号</td>
                    <td>名称</td>
                    <td>类型</td>
                    <td>国家</td>
                    <td>详情</td>
                </tr>
                <c:forEach var="selection" items="${selections}">
                    <tr>
                        <td>${selection.id}</td>
                        <td>${selection.name}</td>
                        <td>${selection.fclass}</td>
                        <td>${selection.country}</td>
                        <td><a href="/geonamesplus/view/${selection.geonameid}"><span
                                class="glyphicon glyphicon-chevron-right"></span></a></td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </div>
</div>

</body>
</html>