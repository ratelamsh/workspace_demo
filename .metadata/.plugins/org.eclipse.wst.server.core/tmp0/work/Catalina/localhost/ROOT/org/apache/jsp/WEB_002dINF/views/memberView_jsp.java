/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.93
 * Generated at: 2023-10-13 08:43:48 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class memberView_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("	<meta charset=\"UTF-8\">\r\n");
      out.write("	<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN\" crossorigin=\"anonymous\">\r\n");
      out.write("	<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js\"></script>\r\n");
      out.write("	<title>member view page</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<div class=\"container\">\r\n");
      out.write("		<div class=\"row\" style=\"margin: 10px;\">\r\n");
      out.write("			<div class=\"col-3\" style=\"border:1px solid\" id=\"rs\">\r\n");
      out.write("				\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"col-6\" style=\"border:1px solid\">\r\n");
      out.write("				<form action=\"/member/editMember.do\" method=\"post\" name=\"editMemberForm\" id=\"editMemberForm\">\r\n");
      out.write("					<div class=\"row\" style=\"padding: 5px 0px 5px\">\r\n");
      out.write("						<div class=\"col-6\">\r\n");
      out.write("							<span>ID</span>\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"col-6\">\r\n");
      out.write("							<input type=\"text\" class=\"form-control\" name=\"m_id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${map.m_id }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" readonly>\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("					<div class=\"row\" style=\"padding: 5px 0px 5px\">\r\n");
      out.write("						<div class=\"col-6\">\r\n");
      out.write("							<span>비밀번호</span>\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"col-6\">\r\n");
      out.write("							<input type=\"password\" class=\"form-control\" name=\"m_pw\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${map.m_pw }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("					<div class=\"row\" style=\"padding: 5px 0px 5px\">\r\n");
      out.write("						<div class=\"col-6\">\r\n");
      out.write("							<span>닉네임</span>\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"col-6\">\r\n");
      out.write("							<input type=\"text\" class=\"form-control\" name=\"m_nickname\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${map.m_nickname }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("					<div class=\"row\" style=\"padding: 5px 0px 5px\">\r\n");
      out.write("						<div class=\"col-6\">\r\n");
      out.write("							<span>이름</span>\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"col-6\">\r\n");
      out.write("							<input type=\"text\" class=\"form-control\" name=\"m_name\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${map.m_name }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("					<div class=\"row\" style=\"padding: 5px 0px 5px\">\r\n");
      out.write("						<div class=\"col-6\">\r\n");
      out.write("							<span>주소</span>\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"col-6\">\r\n");
      out.write("							<input type=\"text\" class=\"form-control\" name=\"m_address\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${map.m_address }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("					<div class=\"row\" style=\"padding: 5px 0px 5px\">\r\n");
      out.write("						<div class=\"col-6\">\r\n");
      out.write("							<span>전화번호</span>\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"col-6\">\r\n");
      out.write("							<input type=\"text\" class=\"form-control\" name=\"m_phone\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${map.m_phone }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("				</form>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"col-3\" style=\"border:1px solid; padding: 2px;\">\r\n");
      out.write("				<button class=\"btn btn-success\" type=\"button\" form=\"editMemberForm\" id=\"save\">수정하기</button>\r\n");
      out.write("				<button class=\"btn btn-dark\" type=\"button\" id=\"showList\">목록출력</button>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("	<script>\r\n");
      out.write("	$(function(){\r\n");
      out.write("		\r\n");
      out.write("		// 수정하기\r\n");
      out.write("		$(\"#save\").on(\"click\", function(){\r\n");
      out.write("/* 			var data = JSON.stringify({m_id: $(\"input[name=m_id]\").val(), m_pw: $(\"input[name=m_pw]\").val(), m_nickname: $(\"input[name=m_nickname]\").val(),\r\n");
      out.write("												m_name: $(\"input[name=m_name]\").val(), m_address: $(\"input[name=m_address]\").val(), m_phone: $(\"input[name=m_phone]\").val()\r\n");
      out.write("										});\r\n");
      out.write("			console.log(data);\r\n");
      out.write("			$(\"<input type='hidden' name='memberDto' value='\" + data + \"'>\").appendTo(\"#editMemberForm\");\r\n");
      out.write("			alert('submit'); */\r\n");
      out.write("			$(\"#editMemberForm\").submit();\r\n");
      out.write("		});\r\n");
      out.write("		\r\n");
      out.write("		// 목록출력\r\n");
      out.write("		$(\"#showList\").click(function(){\r\n");
      out.write("			window.location.replace(\"/member/list\");\r\n");
      out.write("		});\r\n");
      out.write("		\r\n");
      out.write("		// ID input 태그 색상 변경\r\n");
      out.write("		$(\"input[name='m_id']\").css({\"background-color\":\"grey\", \"color\":\"white\"});\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("	}); // function() end\r\n");
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
