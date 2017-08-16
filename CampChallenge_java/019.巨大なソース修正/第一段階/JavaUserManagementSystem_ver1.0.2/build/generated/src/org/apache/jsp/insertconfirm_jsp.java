package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import jums.JumsHelper;
import jums.UserDataBeans;
import javax.servlet.http.HttpSession;

public final class insertconfirm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");

    HttpSession hs = request.getSession();
    UserDataBeans udb = (UserDataBeans) hs.getAttribute("udb");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>登録確認画面</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
 if (!(udb.getName().equals("")) && !(udb.getYear().equals("")) && !(udb.getMonth().equals("")) && !(udb.getDay().equals("")) 
                && !(udb.getType().equals("")) && !(udb.getTell().equals("")) && !(udb.getComment().equals(""))) {
      out.write("\n");
      out.write("        <h1>登録確認</h1>\n");
      out.write("        名前:");
      out.print(udb.getName());
      out.write("<br>\n");
      out.write("        生年月日:");
      out.print(udb.getYear() + "年" + udb.getMonth() + "月" + udb.getDay() + "日");
      out.write("<br>\n");
      out.write("        種別:");
if (udb.getType().equals("1")) {
      out.write(" エンジニア ");
}
      out.write("\n");
      out.write("         ");
if(udb.getType().equals("2")) {
      out.write(" 営業 ");
}
      out.write("\n");
      out.write("         ");
if(udb.getType().equals("3")) {
      out.write("その他");
}
      out.write("<br>\n");
      out.write("        電話番号:");
      out.print(udb.getTell());
      out.write("<br>\n");
      out.write("        自己紹介:");
      out.print(udb.getComment());
      out.write("<br>\n");
      out.write("        上記の内容で登録します。よろしいですか？\n");
      out.write("        <form action=\"insertresult\" method=\"POST\">\n");
      out.write("            <input type=\"hidden\" name=\"ac\" value=\"");
      out.print( hs.getAttribute("ac"));
      out.write("\">\n");
      out.write("            <input type=\"submit\" name=\"yes\" value=\"はい\">\n");
      out.write("        </form>\n");
      out.write("        ");
 } else {
      out.write("\n");
      out.write("        ");

                if (udb.getName().equals("")) {
                    out.println("名前の入力がありません<br>");
                }
                if (udb.getYear().equals("")) {
                    out.println("年の選択がされていません<br>");
                }
                if (udb.getMonth().equals("")) {
                    out.println("月の選択がされていません<br>");
                }
                if (udb.getDay().equals("")) {
                    out.print("日の選択がされていません<br>");
                }
                if (udb.getType().equals("")) {
                    out.print("種別が選択されていません<br>");
                }
                if (udb.getTell().equals("")) {
                    out.print("電話番号が入力されていません<br>");
                }
                if (udb.getComment().equals("")) {
                    out.print("自己紹介が入力されていません<br>");
                }
            }
      out.write("\n");
      out.write("        <form action=\"insert\" method=\"POST\">\n");
      out.write("            <input type=\"submit\" name=\"no\" value=\"登録画面に戻る\">\n");
      out.write("        </form>\n");
      out.write("        <br>\n");
      out.write("        ");
      out.print(JumsHelper.getInstance().home());
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
