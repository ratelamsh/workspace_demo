/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.93
 * Generated at: 2023-10-24 09:28:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/D:/workspace_demo/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Demo/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1696575023656L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("	<meta charset=\"UTF-8\">\r\n");
      out.write("	<link rel=\"shortcut icon\" href=\"#\">\r\n");
      out.write("	<link rel=\"stylesheet\" href=\"/resources/css/bootstrap/bootstrap.min.css\">\r\n");
      out.write("	<script src=\"/resources/js/jquery/jquery-3.7.1.min.js\"></script>\r\n");
      out.write("	<title>Login page</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<h1>로그인 페이지</h1>\r\n");
      out.write("	<div class=\"container\">\r\n");
      out.write("		<form name=\"loginForm\" method=\"post\" action=\"member/login.do\" id=\"loginForm\">\r\n");
      out.write("			<table class=\"table table-bordered\">\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>아이디</td>\r\n");
      out.write("					<td><input type=\"text\" class=\"form-control\" name=\"id\" id=\"id\"></td>\r\n");
      out.write("					<td rowspan=\"2\"><button type=\"button\" class=\"btn btn-primary\" id=\"loginBtn\">로그인</button></td> \r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>비밀번호</td>\r\n");
      out.write("					<td><input type=\"password\" class=\"form-control\" name=\"pw\" id=\"pw\"></td>\r\n");
      out.write("				</tr>\r\n");
      out.write("			</table>		\r\n");
      out.write("		</form>\r\n");
      out.write("	\r\n");
      out.write("		<div class=\"row\" id=\"signUpBox\">\r\n");
      out.write("			<div class=\"col\">\r\n");
      out.write("				<span>아직 회원이 아니신가요?</span>\r\n");
      out.write("				<button type=\"button\" class=\"btn btn-success\" id=\"signUpBtn\">회원가입</button>\r\n");
      out.write("			</div>\r\n");
      out.write("		\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	<script>\r\n");
      out.write("		$(function(){\r\n");
      out.write("			// css\r\n");
      out.write("			$(\"table, #signUpBox\").css({\"text-align\" : \"center\", \"vertical-align\" : \"middle\"});\r\n");
      out.write("			\r\n");
      out.write("			// 로그인 버튼\r\n");
      out.write("			$(\"#loginBtn\").click(function(){\r\n");
      out.write("				// ID 유효성 검사\r\n");
      out.write("				if($(\"#id\").val().length < 5) {\r\n");
      out.write("					alert(\"ID를 5자 이상 입력해주세요.\");\r\n");
      out.write("					return ;\r\n");
      out.write("				}\r\n");
      out.write("				\r\n");
      out.write("				if($(\"#pw\").val().length < 8) {\r\n");
      out.write("					alert(\"비밀번호를 8자리 이상 입력해주세요.\");\r\n");
      out.write("					return ;\r\n");
      out.write("				}\r\n");
      out.write("				\r\n");
      out.write("				$(\"#loginForm\").submit();\r\n");
      out.write("				\r\n");
      out.write("			});\r\n");
      out.write("			\r\n");
      out.write("			// 회원가입 버튼\r\n");
      out.write("			// 회원가입 화면으로 이동\r\n");
      out.write("			$(\"#signUpBtn\").click(function(){\r\n");
      out.write("				alert(\"회원가입 화면으로 이동\");\r\n");
      out.write("				window.location.replace(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/member/signUp\");\r\n");
      out.write("			});\r\n");
      out.write("			\r\n");
      out.write("		})	// function() end\r\n");
      out.write("	</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
