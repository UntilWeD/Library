<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
pageContext.setAttribute("result", "hello");
%>
<!--  ------------------------------------------------------- -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%=request.getAttribute("result") %> 입니다.
	${requestScope.result} <br>
	${names[1]} <br>
	${notice.title} <br>
	${result} <br>
	${param.n/2} <br>
	${header.accept} <br> 
</body>
</html>