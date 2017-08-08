<%-- 
    Document   : db10Set
    Created on : 2017/08/07, 11:31:54
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>消去入力画面</title>
    </head>
    <body>
        <form action ="./db10" method="post">
                消去するデータのIDを入力してください<br>
                <input type="text" name="id"><br><br>
                <input type="submit" name="submit" value="送信">
            </form>
    </body>
</html>
