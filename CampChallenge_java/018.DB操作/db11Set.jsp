<%-- 
    Document   : db11Set
    Created on : 2017/08/07, 14:25:42
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>更新入力画面</title>
    </head>
    <body>
        <form action ="./db11" method="post">
            更新するデータのIDを入力してください<br>
            <input type="text" name="id"><br><br>
            更新するデータを入力してください<br>
            名前<br>
            <input type="text" name="name"><br>
            電話番号<br>
            <input type="text" name="tel"><br>
            年齢<br>
            <input type="text" name="age"><br>
            誕生日<br>
            <input type="text" name="birthday"><br><br>
            <input type="submit" name="submit" value="送信">
        </form>
    </body>
</html>
