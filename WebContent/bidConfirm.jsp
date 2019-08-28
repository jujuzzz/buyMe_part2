<%@page import="vo.auctionVo"%>
<%@page import="dao.auctionDao"%>
<%@page import="vo.createItemVo"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
 pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>bid confirmation</title>
</head>
<body>

 <script>
   window.onload = function() {
   document.forms['confirm'].submit();
  }
 </script>

 <form action="bidConfirmServlet" name="confirm" method="get"></form>
 
</body>
</html>