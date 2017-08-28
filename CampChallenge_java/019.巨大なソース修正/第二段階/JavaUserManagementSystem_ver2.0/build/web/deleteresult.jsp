<%@page import="jums.JumsHelper" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>削除結果画面</title>
    </head>
    <body>
        <h1>削除確認</h1>
        削除しました。<br><br>
        <form action="SearchResult" method="post">
            <input type="hidden" name="name" value="<%=session.getAttribute("name")%>">
            <input type="hidden" name="year" value="<%=session.getAttribute("year")%>">
            <input type="hidden" name="type" value="<%=session.getAttribute("type")%>">
            <input type="hidden" name="ac" value="<%=session.getAttribute("ac")%>">
            <input type="submit" name="back" value="検索結果へ戻る" style="width:100px">
        </form>
        <br>
    </body>
    <%=jh.home()%>
</html>
