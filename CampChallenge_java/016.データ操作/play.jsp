<%-- 
    Document   : play
    Created on : 2017/07/29, 14:01:00
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <!--背景色の指定-->
    <body bgcolor="gold">
        <!--リンクの指定-->
        <h1><a target="_brank" href="https://www.apple.com/">apple<a/><h1><br>
                    
        <!--画像の表示-->     
        <img src="gazou.jpg" alt="Sample"><br>
        
        <!--表の作成-->
        <table>
            <tr>
                <th>名前</th>
                <th>年齢</th>
                <th>出身県</th>
            </tr>
            <tr>
                <td>田中</td>
                <td>20</td>
                <td>鹿児島</td>
            </tr>
            <tr>
                <td>鈴木</td>
                <td>29</td>
                <td>埼玉</td>
            </tr>
        </table>
        
        <!--箇条書きの作成と段落の作成-->
        <p>
        アメコミ最強候補
            <ul>
                <li>ハルク</li>
                <li>ソー</li>
                <li>サノス</li>
            </ul>
        </p>
        <!--ルビを追加する-->
        <ruby>
            白
            <rt>
            <!--フォントの色指定-->
            <font color="red">みどり</font> 
            </rt>
        </ruby>
        
        <!--文字サイズの指定、段落の作成-->
        <h4>面白き<p>こともなき</p>世を面白く</h4>
        
        <!--リストボックスの作成-->
        <select>
            <option value="0">succer</option>
            <option value="1">baseball</option>
            <option value="2">basketball</option>
        </select>

        <!--文字を斜めにする-->
        <h1>Hello World!<i>Hello World!</i></h1>
    </body>
</html>
