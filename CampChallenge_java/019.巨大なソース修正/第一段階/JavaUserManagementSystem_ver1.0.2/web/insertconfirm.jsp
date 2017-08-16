<%@page import="jums.JumsHelper" %>
<%@page import="jums.UserDataBeans" %>
<%@page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession hs = request.getSession();
    UserDataBeans udb = (UserDataBeans) hs.getAttribute("udb");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登録確認画面</title>
    </head>
    <body>
        <% if (!(udb.getName().equals("")) && !(udb.getYear().equals("")) && !(udb.getMonth().equals("")) && !(udb.getDay().equals(""))
                    && !(udb.getType().equals("")) && !(udb.getTell().equals("")) && !(udb.getComment().equals(""))) {%>
        <h1>登録確認</h1>
        名前:<%=udb.getName()%><br>
        生年月日:<%=udb.getYear() + "年" + udb.getMonth() + "月" + udb.getDay() + "日"%><br>
        種別:<%if (udb.getType().equals("1")) {%> エンジニア <%}%>
        <%if (udb.getType().equals("2")) {%> 営業 <%}%>
        <%if (udb.getType().equals("3")) {%>その他<%}%><br>
        電話番号:<%=udb.getTell()%><br>
        自己紹介:<%=udb.getComment()%><br>
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
            <input type="hidden" name="ac" value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="yes" value="はい">
        </form>
        <% } else {%>
        <%
                if (udb.getName().equals("")) {
                    out.println("名前の入力がありません<br>");
                }
                if (udb.getYear().equals("")) {
                    out.println("年の選択がされていません<br>");
                }
                if (udb.getMonth().equals("")) {
                    out.println("月の選択がされていません<br>");
                }
                if (udb.getDay().equals("")) {
                    out.print("日の選択がされていません<br>");
                }
                if (udb.getType() == null) {
                    out.print("種別が選択されていません<br>");
                }
                if (udb.getTell().equals("")) {
                    out.print("電話番号が入力されていません<br>");
                }
                if (udb.getComment().equals("")) {
                    out.print("自己紹介が入力されていません<br>");
                }
            }%>
        <form action="insert.jsp" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
        </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
