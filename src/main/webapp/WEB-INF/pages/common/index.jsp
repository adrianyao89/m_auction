<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><sitemesh:write property='title'/></title>
<link rel="stylesheet"  href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.min.js"></script>
<sitemesh:write property='head'/>
</head>
<body>
main
<sitemesh:write property='body'/>
</body>
</html>