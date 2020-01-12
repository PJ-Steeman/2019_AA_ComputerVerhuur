<%-- 
    Document   : footer
    Created on : 12-Jan-2020, 10:09:14
    Author     : Pieter-Jan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <title>Footer pagina</title>
    </head>
    <body>
        <br>
        <br>
        Uw login info :
        <c:if test="${!empty sessionScope.naam}">
            Usernaam = ${sessionScope.naam}
        </c:if>
            
        <c:if test="${!empty sessionScope.rol}">
            Rol = ${sessionScope.rol}
        </c:if>

        <c:if test="${!empty sessionScope.richting}">
            Richting = ${sessionScope.richting}
        </c:if>
        <br>
        <form method="post" action="<c:url value="CVcontroller"/>">
            <input name="submitKnop" type="submit" value="Afmelden">
        </form>
    </body>
</html>
