<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>errorPage.jsp</title>
</head>
<body>

	<h1>/WEB-INF/views/errors/errorPage.jsp</h1>
    <h1>${exception}</h1>
    
    <hr>
    
    <ul>
    	<c:forEach items="${exception.getStackTrace() }" var="stack">
    		<li>${c:out value="${stack}" /}</li>
    	</c:forEach>
    </ul>

</body>
</html>