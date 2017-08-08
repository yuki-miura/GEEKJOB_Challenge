<%-- 
    Document   : sagasu
    Created on : 2017/08/04, 20:31:26
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta charaset="UTF-8"><!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>検索ページ</title>
    </head>
    <body>
        <form action ="./db8" method="post">
            名前の検索<br>
            <input type="text" name="name"><br><br>
            <input type="submit" name="submit" value="検索">
        </form>
    </body>
</html>
