<%-- 
    Document   : Welkom Pagina
    Created on : 20-Nov-2019, 15:28:57
    Author     : Pieter-Jan Steeman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welkom</title>
        <jsp:include page="fragment.jspf"/>
    </head>
    <body>
        <h1>Welkom op de computerreservatie site</h1>
        <h2>Klik op de knop om verder te gaan naar het computer overzicht</h2>
        
        <form method="post" action='<c:url value="CVcontroller"/>'>
            <input name="submitKnop" type="submit" value="Overzicht">
        </form>
    </body>
</html>
