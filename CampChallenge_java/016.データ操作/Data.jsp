<%-- 
    Document   : Data
    Created on : 2017/07/28, 14:05:21
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta charaset ="UTF-8"><!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>入力フィールド</title>
    </head>
    <body>

    <form action="./test.jsp" method="post">
    名前<input type="text" name="name"><br>
    性別<br>
    <input type="radio" name="gender" value="1">男<br>
    <input type="radio" name="gender" value="2">女<br>
    趣味
    <textarea name="hobby"></textarea><br>
    <input type="submit" name="submit"　value="送信">
    </form>
    </body>
</html>
