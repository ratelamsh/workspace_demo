/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.93
 * Generated at: 2023-10-24 09:38:03 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class writeArticle_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("	<!-- jquery -->\r\n");
      out.write("    <script src=\"/resources/js/jquery/jquery-3.7.1.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("	<!-- bootstrap -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/resources/css/bootstrap/bootstrap.min.css\">\r\n");
      out.write("    <script src=\"/resources/js/bootstrap/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("	<!-- summernote -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/resources/css/summernote/summernote-lite.css\">\r\n");
      out.write("    <script src=\"/resources/js/summernote/summernote-lite.js\"></script>\r\n");
      out.write("    <script src=\"/resources/js/summernote/summernote-ko-KR.js\"></script>\r\n");
      out.write("	<title>Article Writing Page</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <!-- <div id=\"summernote\"></div> -->\r\n");
      out.write("    <h1>글 작성 페이지</h1>\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("    	<form method=\"post\" action=\"/board/write.do\" name=\"writeArticleForm\" id=\"writeArticleForm\" encType=\"multipart/form-data\">\r\n");
      out.write("    		<input type=\"text\" name=\"title\">\r\n");
      out.write("    		<input type=\"text\" name=\"author\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginId }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("    		<select name=\"category\" class=\"custom-select\" id=\"category\">\r\n");
      out.write("    			<option value=\"free\">자유게시판</option>\r\n");
      out.write("    		</select>\r\n");
      out.write("    		<br><br>\r\n");
      out.write("    		<textarea id=\"summernote\" name=\"content\"></textarea>\r\n");
      out.write("    		<button type=\"button\" class=\"btn btn-success\" id=\"saveBtn\">글 작성하기</button>\r\n");
      out.write("    	\r\n");
      out.write("    	</form>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <script>\r\n");
      out.write("	    $(function(){\r\n");
      out.write("			//섬머노트 실행\r\n");
      out.write(" 			$('#summernote').summernote({\r\n");
      out.write("				placeholder: 'Hello Bootstrap 4',\r\n");
      out.write("				tabsize: 2,\r\n");
      out.write("				height: 100,\r\n");
      out.write("				\r\n");
      out.write("				// 콜백함수\r\n");
      out.write("  				callbacks : {\r\n");
      out.write("					onImageUpload : function(files, editor) {\r\n");
      out.write("						// 파일 업로드(다중 업로드를 위해 반복문 사용)\r\n");
      out.write(" 						 for(var i = 0; i < files.length; i++) {\r\n");
      out.write("							sendFile(files[i], this);\r\n");
      out.write("						}  \r\n");
      out.write("					}\r\n");
      out.write("				} \r\n");
      out.write("			});\r\n");
      out.write(" 			$(\"button[aria-label='Video']\").hide();	// 비디오 버튼 숨김\r\n");
      out.write("			\r\n");
      out.write("			// 글 저장\r\n");
      out.write("			$(\"#saveBtn\").click(function(){\r\n");
      out.write("				$(\"#writeArticleForm\").submit();\r\n");
      out.write("			});\r\n");
      out.write("	    }) // function() end\r\n");
      out.write("	    \r\n");
      out.write("	    \r\n");
      out.write("	    // 썸머노트 이미지 업로드 콜백함수\r\n");
      out.write("	    function sendFile(file, editor) {\r\n");
      out.write("	    	data = new FormData();\r\n");
      out.write("	    	data.append(\"file\", file);\r\n");
      out.write("	    	$.ajax({\r\n");
      out.write("	    		data: data,\r\n");
      out.write("	    		type: \"post\",\r\n");
      out.write("	    		url: \"/board/summernoteImgSave\",\r\n");
      out.write("	    		contentType: false,\r\n");
      out.write("	    		processData: false,\r\n");
      out.write("	    		enctype: \"multipart/form-data\",\r\n");
      out.write("	    		success: function(data) {\r\n");
      out.write("	    			console.log(\"썸머노트 url 변경 성공\");\r\n");
      out.write("	    			console.log(data);\r\n");
      out.write("	    			$(editor).summernote('editor.insertImage', data);\r\n");
      out.write("	    			//editor.insertImage(data);\r\n");
      out.write("	    		} ,\r\n");
      out.write("	    		error: function(data) {\r\n");
      out.write("	    			console.log(\"썸머노트 url 변경 실패\");\r\n");
      out.write("	    			console.log(data);\r\n");
      out.write("	    		}\r\n");
      out.write("	    	});\r\n");
      out.write("	    }\r\n");
      out.write("      \r\n");
      out.write("      \r\n");
      out.write("    </script>\r\n");
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
