<%@ page language="java" 
	info="�� JSP ������ ���� �߿��� XXX ����"
	contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- �ּ����� �־�θ� -> Ŀ���� �θ� Ȯ���� �ǹ��� => info ������ ó�� ����! -->
<%
String name = request.getParameter("username");
String pwd = request.getParameter("userpwd");
String[] fruit = request.getParameterValues("fruit");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%= name %>(<%= pwd %>)���� �����ϴ� ������
<%
if (fruit != null) {
	for (int i = 0 ; i < fruit.length ; i++) {
%>
<%= fruit[i] %>,
<%	
	}
} else {
%>
�����ϴ�.
<%
}
%>
</body>
</html>