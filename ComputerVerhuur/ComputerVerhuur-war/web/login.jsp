<%-- 
    Document   : login
    Created on : 20-nov-2019, 16:30:09
    Author     : jonas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login met uw gebruikersnaam en wachtwoord a.u.b.</h1>
        <h2>(Externen gebruiken "e" als gebruikersnaam, geen wachtwoord)</h2>
        <form method= "post" action="j_security_check" > 
            <input type="text"  name= "j_username" > 
            <input type="password"  name= "j_password" >
            <input name="submitKnop" type="submit" value="login" >
        </form>
    </body>
</html>
