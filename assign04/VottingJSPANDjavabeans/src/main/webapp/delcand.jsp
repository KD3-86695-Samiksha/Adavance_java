<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h1>delete Candidate</h1>
<jsp:useBean id="dcl" class="com.sunbeam.beans.DeleteCandidateBean"/>
<jsp:setProperty name="dcl" property="id" param="id"/>


${dcl.delete()}
<jsp:forward page="result.jsp"/>



</body>
</html>