<%@page 
    import="jums.JumsHelper"
    import="java.util.ArrayList"
    import="jums.UserDataBeans"
    import="jums.UserDataDTO" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    UserDataBeans udb = (UserDataBeans)session.getAttribute("udb");
    ArrayList<String> chkList = udb.chkproperties();
    UserDataDTO udd = (UserDataDTO) session.getAttribute("resultData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS更新結果画面</title>
    </head>
    <body>
        <% if(chkList.size()==0){ %>
        <h1>変更結果</h1><br>
        名前:<%= udd.getName()%><br>
        生年月日:<%= udd.getBirthday()%><br>
        種別:<%= udd.getType()%><br>
        電話番号:<%= udd.getTell()%><br>
        自己紹介:<%= udd.getComment()%><br>
        以上の内容で更新しました。<br>
        <% }else{ %>
        <h1>入力が不完全です</h1>
        <%=jh.chkinput(chkList) %>
    <% } %>
    <br>
    <a href="resultdetail.jsp">詳細画面へ戻る</a>
    <br><br>
    <a href="Search">検索画面へ戻る</a>
    <br><br>
    </body>
    <%=jh.home()%>
    </body>
</html>
