<html lang="zh-CN">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta charset="UTF-8">
    <title>实体详情</title>
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
                <input type="text" id="search-input" value="${name}" class="form-control" onkeyup="search_enter(event)">
                <div class="input-group-btn">
                    <button type="button" class="btn btn-default" onclick="search_input()">查询</button>
                </div>
            </div>

            <table class="table table-striped table-margin-top">
                <jsp:useBean id="propValues" scope="request" type="java.util.List"/>
                <c:forEach var="propValue" items="${propValues}">
                    <tr>
                        <td>${propValue.prop}</td>
                        <td>${propValue.value}</td>
                    </tr>
                </c:forEach>
            </table>


        </div>
    </div>
</div>

</body>
</html>