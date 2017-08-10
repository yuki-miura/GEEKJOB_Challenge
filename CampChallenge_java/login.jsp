<%-- 
    Document   : login
    Created on : 2017/08/09, 10:36:52
    Author     : guest1Day
--%>
<!--ログイン成功でこの画面に遷移-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta charset="UTF-8>"<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>メインページ</title>
    </head>
    <body>
        <form action="./db132" method="post">
            <p>・商品情報登録<br>
            商品名<br>
            <input type="text" name="name"><br>
            値段<br>
            <input type="text" name="price"><br>
            個数<br>
            <input type="text" name="stock"><br>
            <input type="submit" name="submit"value="登録"></p>
        </form>

        <form action="./db131" method="post">
            <p>・商品一覧表示<br>
            <input type="submit" name="reference" value="表示"></p>
        </form>

        <!--ログアウトボタン-->
        <form action="./db13Set.jsp" method="post">
            <input type="submit" name="submit" value="ログアウト">
        </form>
    </body>
</html>
