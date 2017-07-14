<%-- 
    Document   : while
    Created on : 2017/07/14, 14:11:14
    Author     : yuki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta gharset="UTF-8"><!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <%
    //iが「100」以下になるまで繰り返す
    //ループ回数を表示する
    int i = 1000;
    int count = 0;
    
    while(i <= 100 == false){
    i = i / 2;
    count++;
    }
    out.print(count + "回ループしました！");
    
    %>        
    </body>
</html>
