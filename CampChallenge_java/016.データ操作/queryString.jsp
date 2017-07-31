<%-- 
    Document   : queryString
    Created on : 2017/07/29, 16:43:35
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta charaset="UTF-8>"<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            request.setCharacterEncoding("UTF-8");

            String a = "お買い上げ頂いたのは「";
            String b = "」の商品です";

            int c = Integer.valueOf(request.getParameter("type"));
            //typeの中身に応じて商品の種類を表示
            switch (c) {
                case 1:
                    out.println(a + "雑貨" + b);
                    break;

                case 2:
                    out.println(a + "生鮮食品" + b);
                    break;

                case 3:
                    out.println(a + "その他" + b);
                    break;
            }

            //商品1個当たりの値段を表示
            int d = Integer.valueOf(request.getParameter("total"));
            int e = Integer.valueOf(request.getParameter("count"));
            out.println("1個当たりの値段は" + d / e + "円です");

            //会計金額に応じて付随するポイントの倍率が変化
            String f = "ポイントお付けいたします";
            if (d >= 5000) {
                out.println(d * 0.05 + f);
            } else if (d >= 3000) {
                out.println(d * 0.04 + f);
            }
        %>    

    </body>
</html>
