<%-- 
    Document   : sample
    Created on : 2017/07/31, 19:01:16
    Author     : guest1Day
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="javax.servlet.http.HttpSession"%> 
<%

    request.setCharacterEncoding("UTF-8");

    HttpSession hs = request.getSession();
    String human = "";
    String sex = "";
    String syumi = "";

    if (hs.getAttribute("name") != null) {
        human = (String) hs.getAttribute("name");
    }

    if (hs.getAttribute("gender") != null) {
        sex = (String) hs.getAttribute("gender");
    }

    if (hs.getAttribute("hobby") != null) {
        syumi = (String) hs.getAttribute("hobby");
    }

%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession"%>
<meta charset="UTF-8"><!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <form action="./settion2" method="post">
        名前<input type="text" name="name" value="<%=human%>"><br>
        性別<br>           
        <input type="radio" name="gender" value="1"
               <%if (sex.equals("1")) {
                       out.print("checked");
                   }%>>男<br>
        <input type="radio" name="gender" value="2"
               <%if (sex.equals("2")) {
                       out.print("checked");
                   }%>>女<br>
        趣味<br>
        <textarea name="hobby"><%=syumi%></textarea><br>
        <input type="submit" name="submit" value="送信">
    </form>
    <body>
    </body>
</html>
