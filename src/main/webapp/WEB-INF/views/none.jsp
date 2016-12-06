<html lang="zh-CN">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="message" scope="request" type="java.lang.String"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
${message}
</body>
</html>
