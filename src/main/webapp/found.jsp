<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>--%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Movie Game App</title>
    </head>

    <body>
        <br/>
        <div align = "center">
            <h1> ${isSuccessful} </h1>
        </div>

        <c:forEach items="${results}" var="result">
            <div align="center">
                <h5>${result.getTitle()}</h5>
                <p>${result.getUrl()}</p>
            </div>
        </c:forEach>
    </body>
</html>