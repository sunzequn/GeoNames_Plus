<html lang="zh-CN">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no"/>
    <script type="text/javascript"
            src="http://api.map.baidu.com/api?v=2.0&ak=OLBEClvDD5tLTAGB1oQ83QwcFTZ8VslV"></script>
    <title>实体详情</title>
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
                    <li><a href="/geonamesplus/">查询</a></li>
                    <li><a href="/geonamesplus/as/">关联搜索</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="http://ws2.nju.edu.cn/geokb-wiki/">关于我们</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="row view-row">
        <div class="col-lg-4">

            <div id="allmap" class="bdmap"></div>

        </div>
        <div class="col-lg-4">
            <table class="table table-striped div-margin-top">
                <jsp:useBean id="propValues" scope="request" type="java.util.List"/>
                <c:forEach var="propValue" items="${propValues}">
                    <tr>
                        <td>${propValue.prop}</td>
                        <td>${propValue.value}</td>
                    </tr>
                </c:forEach>
                <c:if test="${wiki != null}">
                    <tr>
                        <td>来源</td>
                        <td><a href="${wiki}">维基百科</a></td>
                    </tr>
                </c:if>
            </table>

            <div class="alert alert-warning div-margin-top40" role="alert">数据有误? 请反馈给我们! 谢谢~</div>

            <div class="input-group div-margin-top ">
                <input type="text" id="feed-input" class="form-control" onkeyup="feed_enter(event)">
                <div class="input-group-btn">
                    <button type="button" class="btn btn-default" onclick="feed_input(${id})">提交</button>
                </div>
            </div>
            <br/>
            <br/>
        </div>
        <div class="col-lg-4"></div>
        <br/>
    </div>
</div>

</body>
</html>

<script type="text/javascript">
    // 百度地图API功能
    var map = new BMap.Map("allmap");    // 创建Map实例
    map.centerAndZoom(new BMap.Point(${lng}, ${lat}), 11);  // 初始化地图,设置中心点坐标和地图级别
    map.addControl(new BMap.MapTypeControl());   //添加地图类型控件
    map.setCurrentCity(${name});          // 设置地图显示的城市 此项是必须设置的
    map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
</script>