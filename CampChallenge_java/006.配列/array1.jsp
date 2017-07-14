<%-- 
    Document   : array
    Created on : 2017/07/14, 11:30:20
    Author     : yuki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta charset="UTF-8"><!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
 <%@ page import="java.util.ArrayList"%>       
 <%
//配列の作成
ArrayList<String> datas = new ArrayList<String>();

//"10"、"100"、"soeda"、"hayashi"、"-20"、"118"、"END"を追加
datas.add("10");
datas.add("100");
datas.add("soeda");
datas.add("hayashi");
datas.add("-20");
datas.add("118");
datas.add("END");

%> 
    </body>
</html>
