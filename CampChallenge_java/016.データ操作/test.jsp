<%-- 
    Document   : test
    Created on : 2017/07/28, 16:09:07
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta charset="UTf-8"><!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        request.setCharacterEncoding("UTF-8");
        //名前を表示
        out.println(request.getParameter("name"));
        out.print("<br>");
        //genderで選択したものが表示
        String g = request.getParameter("gender");
        if (g.equals("1")) {
            out.println("男");
        } else {
            out.println("女");
        }
        out.print("<br>");
        //趣味を表示
        out.println(request.getParameter("hobby"));
    %>
    <body>
    </body>
</html>
