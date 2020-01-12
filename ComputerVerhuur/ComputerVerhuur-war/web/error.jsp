<%-- 
    Document   : error
    Created on : 12-Jan-2020, 10:24:07
    Author     : pieji
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="fragment.jspf"/>
        <title>Error pagina</title>
    </head>
    <body>
        <h1>Er liep iets mis, gelieve u terug aan te melden</h1>
        <form method="post" action="<c:url value="CVcontroller"/>">
            <input name="submitKnop" type="submit" value="Opnieuw Aanmelden">
        </form>
    </body>
</html>
