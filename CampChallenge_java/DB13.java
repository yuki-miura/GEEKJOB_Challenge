/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author guest1Day
 */
//ログイン判断の処理
public class DB13 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param db_login servlet request
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
            response.setCharacterEncoding("UTF-8");

            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_da = null;

            //Sessionに初期値を入力
            HttpSession session = request.getSession();
            session.setAttribute("miss", null);

            ServletContext context = this.getServletContext();
            RequestDispatcher dispatcher1 = context.getRequestDispatcher("/db13Set.jsp");

            //入力画面よりデータを入手し、変数に入れる
            String human = request.getParameter("name");
            String word = request.getParameter("pass");

            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "miura0808y", "quick1234");

                //空文字があればログイン失敗
                if (request.getParameter("name").equals("") || request.getParameter("pass").equals("")) {
                    //ログイン失敗時に値を追加
                    session.setAttribute("miss", "out");
                    dispatcher1.forward(request, response);
                } else {
                    //sql文の設定    
                    db_st = db_con.prepareStatement("select * from user where name = ? and pass = ?");
                    db_st.setString(1, human);
                    db_st.setString(2, word);

                    db_da = db_st.executeQuery();

                    ArrayList<ArrayList> al = new ArrayList<ArrayList>();

                    //DBに該当データがあれば、al1に要素を追加
                    while (db_da.next()) {
                        ArrayList<String> al1 = new ArrayList<String>();
                        al1.add(db_da.getString("name"));
                        al1.add(String.valueOf(db_da.getInt("pass")));

                        //alにal1を追加
                        al.add(al1);
                    }
                    //alに要素があればログインに成功
                    if (al.size() != 0) {
                        String in = "/login.jsp";
                        RequestDispatcher dispatcher = request.getRequestDispatcher(in);
                        dispatcher.forward(request, response);
                    } else {
                        session.setAttribute("miss", "out");
                        dispatcher1.forward(request, response);
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
            out.println("<title>Servlet DB13</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DB13 at " + request.getContextPath() + "</h1>");
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
