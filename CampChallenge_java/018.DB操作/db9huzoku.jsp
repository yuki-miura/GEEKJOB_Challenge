<%-- 
    Document   : db9huzoku
    Created on : 2017/08/07, 10:35:16
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<mete charaset="UTF-8"><!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>データ登録</title>
        </head>
        <body>
            <form action ="./db9" method="post">
                データ登録<br>
                ID<br>
                <input type="text" name="id"><br>
                名前<br>
                <input type="text" name="name"><br>
                電話番号<br>
                <input type="text" name="tel"><br>
                例　090-111-1111<br>
                年齢<br>
                <input type="text" name="age"><br>
                誕生日<br>
                <input type="text" name="birthDay"><br>
                例　2017-08-07<br><br>
                <input type="submit" name="submit" value="送信">
            </form>
        </body>
    </html>
