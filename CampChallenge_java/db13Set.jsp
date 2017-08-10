<%-- 
    Document   : db13Set
    Created on : 2017/08/09, 10:19:18
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta charaset="UTF-8"><!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ログイン画面</title>
    </head>
    <body>

        <%
            try {
                String ms = (String) session.getAttribute("miss");
                //Sessionに値があれば、文字を表示
                if (ms != null) {
                    out.println("※ログインに失敗しました<br><br>");
                }
            }catch (Exception e){
                out.println("接続エラー:" + e.getMessage());
            }
        %>

        <form action="./DB13" method="post">
            <p>"name"を入力してください<br>
                <input type="text" name="name"></p>
            <p>"pass"を入力してください<br>
            <input type="text" name="pass"></p>
            <input type="submit" name="submit" value="ログイン">
        </form>

    </body>
</html>
