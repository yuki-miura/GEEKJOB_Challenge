<%-- 
    Document   : if1
    Created on : 2017/07/14, 12:36:47
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
    //int型では0と表示されるのでlong型を使用
    long total = 1;
    
    //8を20回掛ける処理
    for(int i = 0; i <= 20; i++){
        total = total * 8;
    }
    
    //計算結果を表示
    out.print(total);
    %>
        
    </body>
</html>
