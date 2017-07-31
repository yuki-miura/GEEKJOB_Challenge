<%-- 
    Document   : queryString2
    Created on : 2017/07/31, 14:04:17
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta charaset="UTF-8"><!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            request.setCharacterEncoding("UTF-8");
            //変数をint型に変換
            int a = Integer.valueOf(request.getParameter("sum"));
            int i = 2;
            out.println(a+"<br>");
            //素因数分解を行い、分解に使った素数と途中経過を表示
            while (a != 1) {
                if (a % i == 0) {
                    a /= i;
                    out.println("素因数" + i + "<br>" + a +"<br>");
                    
                } else {
                    i++;
                }
            }


        %>
    </body>
</html>
