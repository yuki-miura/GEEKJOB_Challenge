package jums;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author hayashi-s
 */
public class SearchResult extends HttpServlet {

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

        //セッションスタート
        HttpSession session = request.getSession();

        try {
            request.setCharacterEncoding("UTF-8");//リクエストパラメータの文字コードをUTF-8に変更

            //アクセスルートチェック
            String accesschk = request.getParameter("ac");

            if (accesschk == null || (Integer) session.getAttribute("ac") != Integer.parseInt(accesschk)) {
                throw new Exception("不正なアクセスです");
            }

            //フォームからの入力をセッションに追加
            session.setAttribute("name", request.getParameter("name"));
            session.setAttribute("year", request.getParameter("year"));
            session.setAttribute("type", request.getParameter("type"));

            //セッションからの入力を取得して、JavaBeansに格納
            UserDataBeans udb = new UserDataBeans();

            if (session.getAttribute("name") != null) {
                udb.setName(session.getAttribute("name").toString());
            }

            if (session.getAttribute("year") != null) {
                udb.setYear(session.getAttribute("year").toString());
            }

            if (session.getAttribute("type") != null) {
                String type = (session.getAttribute("type").toString());
                if (type.equals("null")) {
                    type = "0";
                }
            }

            //DTOオブジェクトにマッピング。DB専用のパラメータに変換
            //udbフィールドに上の3つが格納された状態で、DTOで使うための形に変換
            //変換されたものがsearchData
            UserDataDTO searchData = new UserDataDTO();
            udb.UD2DTOMapping(searchData);

            //resultDataListは検索に当てはまったもののDBからの情報が入っているArrayListのインスタンス
            //resultDataListはsearchresult.jspで主に利用
            ArrayList<UserDataDTO> resultDataList = new ArrayList<UserDataDTO>();
            resultDataList = UserDataDAO.getInstance().search(searchData);
            session.setAttribute("resultDataList", resultDataList);

            request.getRequestDispatcher("/searchresult.jsp").forward(request, response);
        } catch (Exception e) {
            //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
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
