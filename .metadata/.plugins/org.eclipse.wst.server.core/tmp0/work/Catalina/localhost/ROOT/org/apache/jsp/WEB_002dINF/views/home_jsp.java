/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.93
 * Generated at: 2024-01-10 02:22:08 UTC
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

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

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
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      out.write("	<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"data:image/x-icon;\">\r\n");
      out.write("	<!-- Bootstrap core JavaScript-->\r\n");
      out.write("	<script src=\"/resources/template/vendor/jquery/jquery.min.js\"></script>\r\n");
      out.write("  <script src=\"/resources/template/vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("    \r\n");
      out.write("	<!-- Custom template -->\r\n");
      out.write("	<link rel=\"stylesheet\" href=\"/resources/template/css/sb-admin-2.min.css\">\r\n");
      out.write("	<link rel=\"stylesheet\" href=\"/resources/template/css/custom.css\">\r\n");
      out.write("	<link\r\n");
      out.write("        href=\"https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i\"\r\n");
      out.write("        rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"/resources/template/vendor/fontawesome-free/css/all.min.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("	\r\n");
      out.write("	<!-- Encryption -->\r\n");
      out.write("	<script src=\"/resources/js/rsa/jsbn.js\"></script>\r\n");
      out.write("	<script src=\"/resources/js/rsa/rsa.js\"></script>\r\n");
      out.write("	<script src=\"/resources/js/rsa/prng4.js\"></script>\r\n");
      out.write("	<script src=\"/resources/js/rsa/rng.js\"></script>\r\n");
      out.write("	<title>login page</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"bg-gradient-light\">\r\n");
      out.write("	<form name=\"loginForm\" method=\"post\" action=\"/member/login.do\" id=\"loginForm\">\r\n");
      out.write("	    <div class=\"container\">\r\n");
      out.write("	\r\n");
      out.write("	        <!-- Outer Row -->\r\n");
      out.write("	        <div class=\"row justify-content-center\">\r\n");
      out.write("	\r\n");
      out.write("	            <div class=\"col-xl-10 col-lg-12 col-md-9\">\r\n");
      out.write("	\r\n");
      out.write("	                <div class=\"card o-hidden border-0 shadow-lg my-5\">\r\n");
      out.write("	                    <div class=\"card-body p-0\">\r\n");
      out.write("	                        <!-- Nested Row within Card Body -->\r\n");
      out.write("	                        <div class=\"row\">\r\n");
      out.write("	                            <div class=\"col-lg-6 d-none d-lg-block bg-login-image\"></div>\r\n");
      out.write("	                            <div class=\"col-lg-6\">\r\n");
      out.write("	                                <div class=\"p-5\">\r\n");
      out.write("	                                    <div class=\"text-center\">\r\n");
      out.write("	                                        <h1 class=\"h4 text-gray-900 mb-4\">Welcome to NOLBU!</h1>\r\n");
      out.write("	                                    </div>\r\n");
      out.write("	                                        <div class=\"form-group\">\r\n");
      out.write("	                                            <input type=\"text\" class=\"form-control form-control-user\"\r\n");
      out.write("	                                                id=\"id\" name=\"id\" aria-describedby=\"emailHelp\"\r\n");
      out.write("	                                                placeholder=\"Enter id...\">\r\n");
      out.write("	                                        </div>\r\n");
      out.write("	                                        <div class=\"form-group\">\r\n");
      out.write("	                                            <input type=\"password\" class=\"form-control form-control-user\" id=\"password\" placeholder=\"Password\" onkeyup=\"enterkey()\">\r\n");
      out.write("																							<input type=\"hidden\" id=\"rsaPublicKeyModulus\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${publicKeyModulus}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("																							<input type=\"hidden\" id=\"rsaPublicKeyExponent\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${publicKeyExponent}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("																							<input type=\"hidden\" name=\"pw\" id=\"pw\"> \r\n");
      out.write("	                                        </div>\r\n");
      out.write("	                                        ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("	\r\n");
      out.write("	                                        <div class=\"form-group\">\r\n");
      out.write("	                                            <div class=\"custom-control custom-checkbox small\">\r\n");
      out.write("	                                                <input type=\"checkbox\" name=\"rememberId\" class=\"custom-control-input\" id=\"customCheck\" value=\"rememberId\">\r\n");
      out.write("	                                                <label class=\"custom-control-label\" for=\"customCheck\">Remember Me</label>\r\n");
      out.write("	                                            </div>\r\n");
      out.write("	                                        </div>\r\n");
      out.write("	                                        \r\n");
      out.write("	                                        <button type=\"button\" id=\"loginBtn\" class=\"btn btn-primary btn-user btn-block\" onclick=\"login();\">\r\n");
      out.write("	                                            Login\r\n");
      out.write("	                                        </button>\r\n");
      out.write("	                                        <button type=\"button\" class=\"btn btn-red btn-user btn-block\" id=\"loginGoogle\">\r\n");
      out.write("	                                            <i class=\"fab fa-google\" aria-hidden=\"true\"></i>&nbsp;&nbsp;Google Login\r\n");
      out.write("	                                        </button>\r\n");
      out.write("	                                        <hr>\r\n");
      out.write("	                                        	                                        \r\n");
      out.write("	                                        <button type=\"button\" class=\"btn btn-crimson btn-user btn-block\" id=\"signUpBtn\">\r\n");
      out.write("	                                            <i class=\"fa fa-id-badge\" aria-hidden=\"true\"></i>&nbsp;&nbsp;SignUp\r\n");
      out.write("	                                        </button>\r\n");
      out.write("	                                        <button type=\"button\" class=\"btn btn-royalBlue btn-user btn-block\" id=\"listBtn\">\r\n");
      out.write("	                                            <i class=\"fa fa-list-alt\" aria-hidden=\"true\"></i>&nbsp;&nbsp;Board List\r\n");
      out.write("	                                        </button>\r\n");
      out.write("	                                    <hr>\r\n");
      out.write("	                                    <div class=\"text-center\">\r\n");
      out.write("	                                        <a class=\"small\" href=\"/member/forgotPassword\">Forgot Password?</a>\r\n");
      out.write("	                                    </div>\r\n");
      out.write("	                                </div>\r\n");
      out.write("	                            </div>\r\n");
      out.write("	                        </div>\r\n");
      out.write("	                    </div>\r\n");
      out.write("	                </div>\r\n");
      out.write("	\r\n");
      out.write("	            </div>\r\n");
      out.write("	\r\n");
      out.write("	        </div>\r\n");
      out.write("	\r\n");
      out.write("	    </div>\r\n");
      out.write("	</form>\r\n");
      out.write("	\r\n");
      out.write("	<!-- validation Modal-->\r\n");
      out.write("	\r\n");
      out.write("	<!-- validation Modal-->\r\n");
      out.write("    <div class=\"modal fade\" id=\"validationModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"ModalLabel\"\r\n");
      out.write("        aria-hidden=\"true\">\r\n");
      out.write("        <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("            <div class=\"modal-content\">\r\n");
      out.write("                <div class=\"modal-header\">\r\n");
      out.write("                    <h5 class=\"modal-title\" id=\"ModalLabel\">Check your password</h5>\r\n");
      out.write("                    <button class=\"close\" type=\"button\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n");
      out.write("                        <span aria-hidden=\"true\">×</span>\r\n");
      out.write("                    </button>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"modal-body\" id=\"modalContent\">You need to write more than 7 letters on password</div>\r\n");
      out.write("                <div class=\"modal-footer\">\r\n");
      out.write("                    <button class=\"btn btn-secondary\" type=\"button\" data-dismiss=\"modal\">Try Again</button>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	<script>\r\n");
      out.write("		$(function(){\r\n");
      out.write("			// css\r\n");
      out.write("			$(\"div.container, table, #BtnBox\").css({\"text-align\" : \"center\", \"vertical-align\" : \"middle\"});\r\n");
      out.write("			\r\n");
      out.write("			// 회원가입 버튼\r\n");
      out.write("			$(\"#signUpBtn\").click(function(){\r\n");
      out.write("				window.location.replace(\"/member/signUp\");\r\n");
      out.write("			});\r\n");
      out.write("			\r\n");
      out.write("			// 글 미리보기 버튼\r\n");
      out.write("			$(\"#listBtn\").click(function(){\r\n");
      out.write("				window.location.replace(\"/board/toList\");\r\n");
      out.write("			});\r\n");
      out.write("			\r\n");
      out.write("			// remember Me 체크 한 경우\r\n");
      out.write("			var cookie = document.cookie;\r\n");
      out.write("			var ckName = \"rememberId=\";\r\n");
      out.write("			var ckVal  = cookie.substr(cookie.lastIndexOf(ckName) + ckName.length);\r\n");
      out.write("			if(ckVal.length > 0) {\r\n");
      out.write("				$(\"#id\").val(ckVal);\r\n");
      out.write("				$(\"#customCheck\").prop(\"checked\", true);\r\n");
      out.write("			}\r\n");
      out.write("			\r\n");
      out.write("			$(\"#customCheck\").change(function(){\r\n");
      out.write("				if(!$(\"#customCheck\").is(\":checked\")){\r\n");
      out.write("					var date = new Date();\r\n");
      out.write("					date.setTime(date.getTime() + (-1 * 24 * 60 * 60 * 1000));\r\n");
      out.write("					\r\n");
      out.write("					document.cookie = 'rememberId=; domain=.demo.com; expires=' + date.toUTCString() + '; path=/;'\r\n");
      out.write("					$(\"#id\").val(\"\");\r\n");
      out.write("				}\r\n");
      out.write("			});\r\n");
      out.write("			\r\n");
      out.write("			// googleLogin 버튼\r\n");
      out.write("			$(\"#loginGoogle\").click(function(){\r\n");
      out.write("				$.ajax({\r\n");
      out.write("					type : \"post\",\r\n");
      out.write("					url : \"/api/google-login\",\r\n");
      out.write("					data : {},\r\n");
      out.write("					success : function(rs){\r\n");
      out.write("						loginGoogle(rs);\r\n");
      out.write("					},\r\n");
      out.write("					error : function(rs){\r\n");
      out.write("						alert(\"URL 받아오기 실패\");\r\n");
      out.write("					}\r\n");
      out.write("				});\r\n");
      out.write("				\r\n");
      out.write("				function loginGoogle(url){\r\n");
      out.write("					var width = 470;\r\n");
      out.write("					var height = 620;\r\n");
      out.write("					var popupX = window.screen.width/2 - width/2;\r\n");
      out.write("					var popupY = (window.screen.height/2) - (height/2);\r\n");
      out.write("					console.log(width + ' / ' + height + ' / ' + popupX + ' / ' + popupY);\r\n");
      out.write("					window.open(url, 'google login popup', 'width=' + width + ',height=' + height + ',left=' + popupX + ',top=' + popupY);\r\n");
      out.write("				}\r\n");
      out.write("			});\r\n");
      out.write("		})	// function() end\r\n");
      out.write("		\r\n");
      out.write("		// 비밀번호에서 엔터\r\n");
      out.write("		function enterkey() {\r\n");
      out.write("			if(window.event.keyCode == 13) login();\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		// 로그인 버튼\r\n");
      out.write("		function login() {\r\n");
      out.write("			\r\n");
      out.write("			// ID 유효성 검사\r\n");
      out.write("			if($(\"#id\").val().trim().length < 5) {\r\n");
      out.write("				$(\"#ModalLabel\").text(\"Check your ID\");\r\n");
      out.write("				$(\"#modalContent\").text(\"Required 4 or more letters for ID\");\r\n");
      out.write("				$(\"#validationModal\").modal(\"show\");\r\n");
      out.write("				return ;\r\n");
      out.write("			}\r\n");
      out.write("			\r\n");
      out.write("			// 비밀번호 유효성 검사\r\n");
      out.write("			var testPw = $(\"#password\").val().trim();\r\n");
      out.write("			var regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/;\r\n");
      out.write("			if(testPw.length < 8 && testPw != 'aaa') {\r\n");
      out.write("				//alert(\"비밀번호는 8자리 이상이어야 합니다.\");\r\n");
      out.write("				$(\"#ModalLabel\").text(\"Check your password\");\r\n");
      out.write("				$(\"#modalContent\").text(\"Required 8 or more letters for password\");\r\n");
      out.write("				$(\"#validationModal\").modal(\"show\");\r\n");
      out.write("				return;\r\n");
      out.write("			} else {\r\n");
      out.write("				if(!regex.test(testPw) && testPw != 'aaa'){\r\n");
      out.write("					//alert(\"대문자, 소문자, 특수문자, 숫자 각 1개 이상 씩 입력하세요. (8~25자리)\");\r\n");
      out.write("					$(\"#ModalLabel\").text(\"Check your password\");\r\n");
      out.write("					$(\"#modalContent\").text(\"Required one of each upper, lower, special characters and number for password\");\r\n");
      out.write("					$(\"#validationModal\").modal(\"show\");\r\n");
      out.write("					return;\r\n");
      out.write("				} else {\r\n");
      out.write("					// 비밀번호 RSA 암호화\r\n");
      out.write("					//// RSAKey 객체 생성\r\n");
      out.write("					const rsa = new RSAKey();\r\n");
      out.write("					//// 공개키 설정 값 가져오기\r\n");
      out.write("					const rsaPublicKeyModulus = $(\"#rsaPublicKeyModulus\").val();\r\n");
      out.write("					const rsaPublicKeyExponent = $(\"#rsaPublicKeyExponent\").val();\r\n");
      out.write("					//// RSAKey 객체에 공개키 설정\r\n");
      out.write("					rsa.setPublic(rsaPublicKeyModulus, rsaPublicKeyExponent);\r\n");
      out.write("					//// RSAKey 객체의 encrypt메서드 이용하여 비밀번호 암호화\r\n");
      out.write("					const securedPassword = rsa.encrypt(testPw);\r\n");
      out.write("					\r\n");
      out.write("					$(\"#pw\").val(securedPassword);\r\n");
      out.write("				}\r\n");
      out.write("			}\r\n");
      out.write("			\r\n");
      out.write("			$(\"#loginForm\").submit();	\r\n");
      out.write("		}\r\n");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /WEB-INF/views/home.jsp(57,41) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!requestURI.equals('') }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("																						<input type=\"hidden\" name=\"requestURI\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestURI }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("																					");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }
}
