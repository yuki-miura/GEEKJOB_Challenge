/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yuki
 */
public class battleField extends HttpServlet {

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

            //インスタンスの生成
            Dealer dealer = new Dealer();
            User user = new User();
            
            out.print(dealer.cards+"<br>");

            String dh = "Dealerの手札:";
            String uh = "Userの手札:";

            //手札をセット
            dealer.setCard(dealer.deal());
            user.setCard(dealer.deal());

            out.print(uh + user.myCards + user.open() + "<br>");
            out.print(dh + dealer.myCards + dealer.open() + "<br>" + "<br>");
            out.print(dealer.cards+"<br>");

            //out.print(myCards);
            //ヒットするか判断
            
            int dealCount = 0;
            while (dealer.checkSum()){
                dealer.setCard(dealer.hit());
                dealCount++;
            }
            out.print("Dealerは" + dealCount + "hitしました <br>");
             out.print(dh + dealer.myCards + dealer.open() + "<br><br>");
            
            
             int userCount = 0;
            while (user.checkSum()){
                user.setCard(dealer.hit());
                userCount++;
            }
            out.print("Userは" + userCount + "hitしました <br>");
             out.print(dh + user.myCards + user.open() + "<br><br>");

            

            String u = "Userの勝利です!";
            String d = "Dealerの勝利です!";
            String h = "引き分けです";
            String b = "Burst!";

            if (user.open() == dealer.open() || user.open() > 21 && dealer.open() > 21) {
                out.print(h);
            } else if (user.open() > 21) {
                out.print(b + "<br>" + d);
            } else if (dealer.open() > 21) {
                out.print(b + "<br>" + u);
            } else if (user.open() > dealer.open()) {
                out.print(u);
            } else {
                out.print(d);
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet battleField</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<br>Servlet battleField at " + request.getContextPath() );
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
