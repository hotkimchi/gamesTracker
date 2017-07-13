<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Index Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <body>
        <div class="container">
            <h1>Spring MVC Application from Archetype</h1>
            <hr/>
            <form method="POST" action="addGame">
                Name: <input type="text" name="name"/>
                Publisher: <input type="text" name="publisher"/>
                Genre: <select name="genre">
                    <option>Action</option>
                    <option>FPS</option>
                    <option>Strategy</option>
                    <option>RPG</option>
                </select>
                Year Published: <input type="text" name="releaseYear"/>
                <input type="submit" value="Add Game"/>
            </form>
            <hr/>
            <table class="table table-hover">
                <tr>
                    <th>Name</th>
                    <th>Publisher</th>
                    <th>Genre</th>
                    <th>Release Year</th>
                    <th></th>
                    <th></th>
                </tr>
            
            <c:forEach items="${games}" var="game">
                <tr>
                    <td><c:out value="${game.name}"/></td>
                    <td><c:out value="${game.publisher}"/></td>
                    <td><c:out value="${game.genre}"/></td>
                    <td><c:out value="${game.releaseYear}"/></td>
                    <td><a href="editGame?id=${game.id}">Edit</a></td>
                    <td><form method="post" action="deleteGame">
                            <input type="hidden" value="${game.id}" name="gameId">
                            <button type="submit">Delete</button>
                        </form></td>
                </tr>
                    
            </c:forEach>
            </table>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

