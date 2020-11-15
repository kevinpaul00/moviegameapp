<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>--%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Movie Game App</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

        <style>

            input{
                display: block;
                width: 100%;
                height: calc(1.5em + 0.75rem + 2px);
                padding: 0.375rem 0.75rem;
                font-size: 1rem;
                font-weight: 400;
                line-height: 1.5;
                color: #495057;
                background-color: #fff;
                background-clip: padding-box;
                border: 1px solid #ced4da;
                border-radius: 0.25rem;
                transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
            }

            body{
                background-image:linear-gradient(120deg,#3ecbe7 ,#d77af3);
                min-height:100vh;
            }

            .container{
                max-width:800px;
                margin:auto;
                padding:10px;
            }


            h3{
                margin:10px 0;
            }

            .task{
                width:100%;
                background:rgba(255,255,255,0.5);
                padding:25px;
                margin :40px 0px;
            }

            .task i{
                float:right;
                margin-left:20px;
                cursor:pointer;
            }
        </style>
    </head>

<body>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <nav class="navbar navbar-default navbar-expand-md bg-dark navbar-dark fixed-top">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="/">Home</a>
            </li>

            <li>
                <a class="nav-link" href="/dataStore">Data Store</a>
            </li>
        </ul>
    </nav>
    <br/><br/><br/>
    <div align = "center">
        <h1> ${isSuccessful} </h1>
    </div>

    <div class = "Wrapper">
        <div class = "container">
            <c:forEach items="${results}" var="result">
                <div class = "task">
                    <h5>${result.getSq()}</h5>
                    <h5>${result.getTitle()}</h5>
                    <a href="${result.getUrl()}">
                        <button type="button" class="btn btn-light">Visit!</button>
                    </a>
                </div>
            </c:forEach>
        </div>
    </div>

<%--    <c:forEach items="${results}" var="result">--%>
<%--        <div align="center">--%>
<%--            <h5>${result.getTitle()}</h5>--%>
<%--            <p>${result.getUrl()}</p>--%>
<%--        </div>--%>
<%--    </c:forEach>--%>

    </body>
</html>