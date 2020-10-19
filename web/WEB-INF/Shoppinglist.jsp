<%-- 
    Document   : Shoppinglist
    Created on : 18-Oct-2020, 6:08:11 PM
    Author     : 809968
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ShoppintgList</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello ${username}</p>
        <a href="<c:url value='/ShoppingList?action=logout'/>"> Logout</a>
        
        <h2>Add Item</h2>
        <form action="<c:url value='/ShoppingList'/>" method="post">
            <input type="text" name="item" value=""/>
            <input type="submit" value="Add"/>
            <input type="hidden" name="action" value="add"/>
        </form>
              <div>
            <c:if test="${isAddEmpty}">
            <p>Invalid input.</p>
            </c:if>
        </div>
            
        <c:if test="${sessionScope.items.size() > 0}">
        <form action="<c:url value='/ShoppingList'/>" method="post">
            <c:forEach items="${sessionScope.items}" var='singleItem'>        
                <input type="radio" name="${delete}" value="${singleItem}"/> ${singleItem}       
            </c:forEach>
                <input type="submit" value="delete"/>
                <input type="hidden" name="action" value="delete"/>
        </form>
        </c:if>
        
               <div>
            <c:if test="${isDeleteEmpty}">
            <p>Invalid input.</p>
            </c:if>
        </div>
    </body>
</html>
