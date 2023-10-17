<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Calulate</h2>
	<form:form method="GET" action="${pageContext.request.contextPath}/caculate">
        <label for="a">A:</label>
        <input type="text" id="a" name="a"/><br/><br/>
        
        <label for="b">B:</label>
        <input type="text" id="b" name="b"/><br/><br/>
        
        <input type="submit"/>
    </form:form>
    <br></br>
    <h2>UploadFileCheck</h2>
    <form:form method="POST" action="${pageContext.request.contextPath}/uploadFile">
        <label for="a">A:</label>
        <input type="text" id="a" name="a"/>
        <input type="submit"/>
    </form:form>
</body>
</html>