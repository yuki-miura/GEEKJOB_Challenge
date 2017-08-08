<%-- 
    Document   : db12Set
    Created on : 2017/08/07, 15:39:51
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>複合検索ページ</title>
    </head>
    <body>
        <form action ="./db12" method="post">
        検索するデータを入力してください<br><br>
        名前<br>
        <input type="text" name="name"><br>
        年齢<br>
        <input type="text" name="age"><br>
        誕生日<br>
        <input type="text" name="birthday"><br><br>
        <input type="radio" name="andor" value="1" checked>AND<br>        
        <input type="radio" name="andor" value="2">OR<br><br>        
        <input type="submit" name="submit" value="検索">
        </form>
    </body>
</html>
