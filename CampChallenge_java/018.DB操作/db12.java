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
public class db12 extends HttpServlet {

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

            //入力データが存在するとき中身を上書きする
            String human = null;
            if (request.getParameter("name") != null) {
                human = request.getParameter("name");
            }

            int old = 0;
            if (!(request.getParameter("age").equals(""))) {
                old = Integer.parseInt(request.getParameter("age"));
            }

            String bd = null;
            if (request.getParameter("birthday") != null) {
                bd = request.getParameter("birthday");
            }

            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "miura0808y", "quick1234");

                String andor = request.getParameter("andor");
                //ANDは完全一致でのみ検索できる
                if (andor.equals("1")) {
                    
                    //sql文の設定
                    db_st = db_con.prepareStatement("select * from profiles where name=? and age=? and birthday=?");
                    db_st.setString(1, human);
                    db_st.setInt(2, old);
                    db_st.setString(3, bd);

                    db_da = db_st.executeQuery();

                    //該当したデータを表示
                    while (db_da.next()) {
                        out.println("ID:" + db_da.getInt("profileID") + "<br>");
                        out.println("name:" + db_da.getString("name") + "<br>");
                        out.println("tel:" + db_da.getString("tel") + "<br>");
                        out.println("age:" + db_da.getInt("age") + "<br>");
                        out.println("birthday:" + db_da.getString("birthday") + "<br>");
                    }
                //ORでは要素が１つでも該当すれば表示される   
                } else if (andor.equals("2")) {
                    
                    //sql文の設定
                    db_st = db_con.prepareStatement("select * from profiles where name=? or age=? or birthday=?");
                    db_st.setString(1, human);
                    db_st.setInt(2, old);
                    db_st.setString(3, bd);

                    db_da = db_st.executeQuery();

                    //該当したデータを表示
                    while (db_da.next()) {
                        out.println("ID:" + db_da.getInt("profileID") + "<br>");
                        out.println("name:" + db_da.getString("name") + "<br>");
                        out.println("tel:" + db_da.getString("tel") + "<br>");
                        out.println("age:" + db_da.getInt("age") + "<br>");
                        out.println("birthday:" + db_da.getString("birthday") + "<br>");
                    }
                }

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
            out.println("<title>Servlet db12</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet db12 at " + request.getContextPath() + "</h1>");
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
