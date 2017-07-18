<%-- 
    Document   : FortuneTellingResult
    Created on : 2017/07/18, 8:00:11
    Author     : yuki
--%>
<meta charset="UTF-8"><!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.camp.servlet.ResultData"%>
<html>
    <head>
        <%
            ResultData data = (ResultData)request.getAttribute("DATA");
            %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if (data != null){
                out.print("<h1>あなたの"+data.getD() + "の運勢は、" +data.getLuck()+"です！<h1>");
            }
            %>
           
    </body>
</html>
