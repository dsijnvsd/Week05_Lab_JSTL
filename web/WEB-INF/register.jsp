<%-- 
    Document   : register
    Created on : 18-Oct-2020, 6:02:09 PM
    Author     : 809968
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="<c:url value='/ShoppingList'/>" method="post">
            <input type="text" name="username" value="${username}"/>
            <input type="hidden" name="action" value="register"/><br>
            <input type="submit" value="Register"/>
        </form>
            
              <div>
            <c:if test="${invalid}">
            <p>Invalid login.</p>
            </c:if>
        </div>
            ${logoutMessage}
    </body>
</html>
