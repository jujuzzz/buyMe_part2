<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bid - buyMe</title>



</head>
<body >
 <div>
  <form action="servlet/bidServlet" method="post">    
        
    <br/> Please enter your bid:
    <table>
	<tr><td>Bid</td><td><input type="text"  name="money"/>*</td></tr>
	<tr><td><input type="submit" name="g" value="Confirm"/></td></tr>
	
    </table>            
  </form>
</div>
</body>
</html>
