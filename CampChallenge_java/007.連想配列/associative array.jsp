<%-- 
    Document   : associative array
    Created on : 2017/07/14, 11:05:30
    Author     : yuki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta charset="UTF-8">DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
 <%@ page import="java.util.HashMap" %>   
    
 <%
//連想配列の作成  
HashMap<String,String> detas =
    new HashMap<String,String>();

//情報の追加
detas.put("1", "AAA");
detas.put("hello", "world");
detas.put("soeda","33" );
detas.put("20", "20");
        
%>    
    <body>
       
    </body>
</html>
