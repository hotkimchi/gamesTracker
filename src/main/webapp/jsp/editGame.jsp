<%-- 
    Document   : editGame
    Created on : Jun 22, 2017, 11:50:01 AM
    Author     : apprentice
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <title>Edit Game</title>
    </head>
    <body>
        <h1>Edit Game</h1>
        <sf:form method="post" action="editGame" modelAttribute="game">
            Name: <sf:input type="text" path="name"/><br/>
            Publisher: <sf:input type="text" path="publisher"/><br/>
            Name: <sf:select path="genre">
                <sf:option value="Action">Action</sf:option>
                <sf:option value="FPS">FPS</sf:option>
                <sf:option value="Strategy">Strategy</sf:option>
                <sf:option value="RPG">RPG</sf:option>
            </sf:select><br/>
            Year: <sf:input type="text" path="releaseYear"/><br/>
            <sf:hidden path="id"/>
            <sf:button type="submit">Edit</sf:button>
        </sf:form>
    </body>
    <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</html>
