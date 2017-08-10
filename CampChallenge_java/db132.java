/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;

/**
 *
 * @author guest1Day
 */
//商品登録の処理
public class db132 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            request.setCharacterEncoding("UTF-8");

            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_da = null;
            
            //入力画面よりデータを入手し、変数に入れる
            String name = request.getParameter("name");
            int price = Integer.parseInt(request.getParameter("price"));
            int stock = Integer.parseInt(request.getParameter("stock"));

            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "miura0808y", "quick1234");
                
                //sql文の設定
                db_st = db_con.prepareStatement("insert into product(name,price,stock) values(?,?,?)");
                db_st.setString(1, name);
                db_st.setInt(2, price);
                db_st.setInt(3, stock);
                db_st.executeUpdate();

                //sql文の設定
                db_st = db_con.prepareStatement("select * from product where name = ?");
                db_st.setString(1, name);
                db_da = db_st.executeQuery();

                //登録データを表示
                while (db_da.next()) {
                    out.println("No:" + db_da.getInt("No") + "<br>");
                    out.println("name:" + db_da.getString("name") + "<br>");
                    out.println("price:" + db_da.getString("price") + "<br>");
                    out.println("stock:" + db_da.getInt("stock") + "<br>");
                }
                out.println("登録しました");
                
                db_da.close();
                db_st.close();
                db_con.close();

            } catch (SQLException e_sql) {
                out.println("接続エラー:" + e_sql.getMessage());
            } catch (Exception e) {
                out.println("接続エラー:" + e.getMessage());
            } finally {
                if (db_con != null) {
                    try {
                        db_con.close();
                    } catch (Exception e_con) {
                        out.println(e_con.getMessage());
                    }
                }
            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet db132</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet db132 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
