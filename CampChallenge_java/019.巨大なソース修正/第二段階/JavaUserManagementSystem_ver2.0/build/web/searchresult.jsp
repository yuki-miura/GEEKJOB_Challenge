<%@page import="jums.JumsHelper"
        import="java.util.ArrayList"
        import="javax.servlet.http.HttpSession"
        import="java.text.SimpleDateFormat"
        import="jums.UserDataDTO" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    ArrayList<UserDataDTO> uddArray = (ArrayList<UserDataDTO>) hs.getAttribute("resultDataList");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS検索結果画面</title>
    </head>
    <body>
        <h1>検索結果</h1>
        <% for (UserDataDTO udd : uddArray) {%>
        <table border=1>
            <tr>
                <th>名前</th>
                <th>生年</th>
                <th>種別</th>
                <th>登録日時</th>
            </tr>
            <tr>
                <td><a href="ResultDetail?id=<%= udd.getUserID()%>"><%= udd.getName()%></a></td>
                <td><%= udd.getBirthday()%></td>
                <td><%= udd.getType()%></td>
                <td><%= sdf.format(udd.getNewDate())%></td>
            </tr>
            <% }%>
        </table>
        <% if (uddArray.size() == 0 || uddArray == null) { %>
        該当データがありません。
        <% }%>
    </body>
    <%=jh.home()%>
</html>
