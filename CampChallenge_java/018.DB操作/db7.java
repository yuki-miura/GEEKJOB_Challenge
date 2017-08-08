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

/**
 *
 * @author guest1Day
 */
public class db7 extends HttpServlet {

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

            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_da = null;

            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "miura0808y", "quick1234");
                
                //更新するデータを入力
                db_st = db_con.prepareStatement("update profiles set name = ?,age = ?, birthday = ? where profileID = ?");
                db_st.setString(1, "松岡修三");
                db_st.setInt(2, 48);
                db_st.setString(3, "1967-11-06");
                db_st.setInt(4, 1);
                db_st.executeUpdate();

                //sql文の設定
                db_st = db_con.prepareStatement("select * from profiles where profileID = ?");
                db_st.setInt(1, 1);
                db_da = db_st.executeQuery();
                
                //更新したデータを表示
                while(db_da.next()){
                    out.println(db_da.getInt("profileID"));
                    out.println(db_da.getString("name"));
                    out.println(db_da.getString("tel"));
                    out.println(db_da.getInt("age"));
                    out.println(db_da.getString("birthday"));
                }
                
                db_da.close();
                db_st.close();
                db_con.close();

            } catch (SQLException e_sql) {
                out.println(e_sql.getMessage());
            } catch (Exception e) {
                out.println(e.getMessage());
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
            out.println("<title>Servlet db7</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet db7 at " + request.getContextPath() + "</h1>");
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
