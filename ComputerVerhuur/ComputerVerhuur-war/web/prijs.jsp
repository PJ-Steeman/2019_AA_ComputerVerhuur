<%-- 
    Document   : prijs
    Created on : 12-Dec-2019, 16:23:33
    Author     : Pieter-Jan Steeman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prijs controle</title>
    </head>
    <body>
        <h1>Deze reservatie zal u ${sessionScope.prijs} euro kosten</h1>
        
        <form method="post" action='<c:url value="CVcontroller"/>'>
           <input name="submitKnop" type="submit" value="Bevestig Reservatie">
           <input name="submitKnop" type="submit" value="Annuleer">
        </form>
    </body>
</html>
