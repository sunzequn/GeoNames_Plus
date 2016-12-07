<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<head>
    <meta charset="UTF-8">
    <title>基础库</title>
</head>
<body>
<jsp:include page="common.jsp"></jsp:include>
<div class="container-fluid">
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">导航条</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">地理基础知识库</a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">查询</a></li>
                    <li><a href="/geonamesplus/as/">关联搜索</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="http://ws2.nju.edu.cn/geokb-wiki/">关于我们</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="row search-row">
        <div class="col-lg-4"></div>
        <div class="col-lg-4">
            <div class="label-search-info">
                <label class="label label-info">请输入要查询的实体名称, 比如南京或Nanjing</label>
            </div>

            <div class="input-group">
                <input type="text" id="search-input" class="form-control" onkeyup="search_enter(event)">
                <div class="input-group-btn">
                    <button type="button" class="btn btn-default" onclick="search_input()">查询</button>
                </div>
            </div>

            <c:if test="${message != null}">
                <div class="alert alert-warning alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert"><span
                            aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <strong>${message}</strong>
                </div>
            </c:if>
        </div>
        <div class="col-lg-4"></div>
    </div>

    <div class="row jumbotron-row">
        <div class="col-lg-3"></div>
        <div class="col-lg-6">
            <div class="jumbotron inner-padding">
                <h2>地理基础知识库</h2>
                <h4>基础库以GeoNames数据集为核心. GeoNames是一个地点基础信息知识库, 收录了全球1000多万地点实体.
                    通过实体链接, 基础库从Wikidata和Clinga等知识库补充了地点的中文名称数据.
                    基础库还包括了从国家统计局获得的中国城市数据、从中国气象网获取的中国气候要素数据、从NASA的GPCP项目获取的全球降水数据以及Koppen气候类型分布数据等.
                    基础库一共包含超过1100万的地点实体和约2亿多条三元组.</h4>
            </div>
        </div>
        <div class="col-lg-3"></div>
    </div>


    <div class="row bottom">
        &copy; 2016 <a href="http://ws.nju.edu.cn/" onclick="window.open(this.href); return false;">
        The Websoft Research Group</a>, Nanjing University, P.R. China
    </div>

</div>


</body>
</html>