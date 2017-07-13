<%-- 
    Document   : variable
    Created on : 2017/07/13, 10:22:15
    Author     : yuki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <meta charset="UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       
       <%
                
         int a = (1+4);
         int ge = 5;
         float age = a * ge;
         
         String my = "三浦";
         String name ="優輝";
         String is = "です！";
         
    out.print(my+name+is);    
    out.print("<br>");
    out.print("年齢は"+age);

     
        %>
    </body>
</html>
