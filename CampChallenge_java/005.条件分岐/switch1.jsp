<%-- 
    Document   : switch
    Created on : 2017/07/13, 15:19:24
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
            int sum = 1;
        switch(sum){
            case 1:
              out.print("one");
                break;
                
            case 2:
                out.print("two");
                break;
            
            default:
                out.print("想定外");
                break;
         
          }
            %>
    </body>
</html>
