<%-- 
    Document   : if3
    Created on : 2017/07/14, 12:44:14
    Author     : yuki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta charset="UTF-8"><!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <%
    int total = 0;
    
    //1から100まで合計する処理
    for(int i = 1; i <= 100; i++){
        total = total + i;
    }
    
    //計算結果を表示
    out.print(total);
    %>
        
    </body>
</html>
