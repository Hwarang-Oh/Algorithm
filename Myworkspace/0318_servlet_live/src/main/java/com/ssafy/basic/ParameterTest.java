package com.ssafy.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ParameterTest
 */
@WebServlet("/param")
public class ParameterTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParameterTest() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 1. 이름, 비밀번호, 과일을 얻어내자 2. Logic 처리 3. 응답페이지 작성
		String name = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		String[] fruit = request.getParameterValues("fruit");
		
		response.setContentType("text/html; charset-utf-8"); // 이거는 한방에 가능한 것!!
		PrintWriter out = response.getWriter(); // Client와 연결성 => html in Java
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>과일 선호도 조사 </h1>");
		out.println(name + "(" + pwd + ")님이 좋아하는 과일은"); // 한글 깨짐!! 
		if (fruit != null) {
			for (int i= 0 ; i < fruit.length ; i++) {
				out.println(fruit[i]);
				if (i != fruit.length - 1) out.print(", ");
			}
			out.println("입니다!");
		} else out.println("없습니다.");
		out.println("</body>");
		out.println("</html>");
		
	}
}
