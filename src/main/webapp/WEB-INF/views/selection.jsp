<html lang="zh-CN">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="selections" scope="request" type="java.util.List"/>
<head>
    <meta charset="UTF-8">
    <title>实体列表</title>
</head>
<body>
<jsp:include page="common.jsp"></jsp:include>
<div class="container-fluid">
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#navbar">
                    <span class="sr-only">导航条</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">地理基础知识库</a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="/geonamesplus/">查询</a></li>
                    <li><a href="/geonamesplus/as/">关联搜索</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="http://ws2.nju.edu.cn/geokb-wiki/">关于我们</a></li>
                </ul>
            </div>
        </div>
    </nav>


    <div class="row selection-label-row">
        <div class="col-xs-3"></div>
        <div class="col-xs-6">
            <c:if test="${message != null}">
                <div class="alert alert-info" role="alert">${message}</div>
            </c:if>
            <br/>
            <table class="table table-striped">
                <tr>
                    <td>标号</td>
                    <td>名称</td>
                    <td>类型</td>
                    <td>具体类型</td>
                    <td>国家</td>
                    <td>详情</td>
                    <td>附近地点</td>
                </tr>
                <c:forEach var="selection" items="${selections}">
                    <tr>
                        <td>${selection.id}</td>
                        <td>${selection.name}</td>
                        <td>${selection.fclass}</td>
                        <td>${selection.fcode}</td>
                        <td>${selection.country}</td>
                        <td><a href="/geonamesplus/view/${selection.geonameid}"><span
                                class="glyphicon glyphicon-search"></span></a></td>
                        <td><a href="/geonamesplus/nearby/${selection.geonameid}/${selection.name}"><span
                                class="glyphicon glyphicon-map-marker"></span></a></td>
                    </tr>
                </c:forEach>
            </table>

        </div>
        <div class="col-xs-3"></div>
        <br/>
        <br/>
    </div>

</div>
</body>
</html>