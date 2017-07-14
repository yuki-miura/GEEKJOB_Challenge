<%-- 
    Document   : if2
    Created on : 2017/07/14, 13:29:10
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
        
    String x = "";
      
    //30回変数xに"A"を追加する処理
    for(int i = 0; i<=30; i++){
    x = x + "A";  
    }
    //処理結果を表示
    out.print(x);

    %>    
    </body>
</html>
