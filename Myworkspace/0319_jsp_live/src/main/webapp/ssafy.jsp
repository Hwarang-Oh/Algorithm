<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.Date, java.sql.*" 
    import ="java.text.*" session="false"
    %> 
    <!-- �����ݷ� X -->
    <!-- �Ӽ� ���̴� �׻� white Space�� �־�� �Ѵ�!! -->
<%
  String name = "��ȭ��";
  Date date = new Date();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>Hello SSAFY JSP!!</h1>
<h1>�ȳ� ���� ���̿�����!</h1>
<h3><%out.print(name + "�� �ȳ�"); %></h3>
<h3><%=name %>�� �ȳ�</h3>
<div>������ <%= date %></div>
</body>
</html>