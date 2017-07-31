<%-- 
    Document   : sample
    Created on : 2017/07/29, 16:48:44
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="./queryString.jsp" method="post">
            <!--radioボタンで商品の種類を選択--> 
            商品選択<br>
            <input type="radio" name="type" value="1">雑貨<br>
            <input type="radio" name="type" value="2">生鮮食品<br>
            <input type="radio" name="type" value="3">その他<br>
            <!--金額を手入力-->
            金額<br>
            <input type="text" name="total"><br>
            <!--個数をプルダウンボタンで選択-->
            個数<br>
            <select name="count">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
            </select>
            <br>
            <input type="submit" name="submit">
        </form>
    </body>
</html>
