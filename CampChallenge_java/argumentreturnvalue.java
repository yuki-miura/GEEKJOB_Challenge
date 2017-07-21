/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author yuki
 */
public class argumentreturnvalue extends HttpServlet {
    
    //3人のプロフィールを作成し、ランダムに値を返す
    String[] data(int id){
        String[] a = {"1","橋本 <br>","2015/12/18 <br>","大阪市 <br>"};
        String[] b = {"2","河村 <br>","2017/7/21 <br>",null};
        String[] c = {"3","林 <br>","20017/7/21 <br>","横浜市<br>"};
       
        switch(id){
            case 1:
                return a;
            
            case 2:
                return b;
            
            case 3:
                return c;
        }
        return null;
    }
    

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
            
            //値が離れているidも検索できるように設定
            int[] ids = {1,2,3, 52, 100, 33000};
            
            //limitの数までプロフィールを表示し、nullの項目は表示しない
            Integer limit = 2;
            
            for(int z = 0; z < ids.length; z++){
                String[] prof = data(ids[z]);
                    for(int i= 1; i < prof.length; i++){
                        if (prof[i] == null){
                            continue; 
                    }
                                if(limit > z){
                                    out.println(prof[i]);
                                }
                    
                    }
            }
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet argumentreturnvalue</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet argumentreturnvalue at " + request.getContextPath() + "</h1>");
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
