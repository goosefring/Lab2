<%-- 
    Document   : arithmeticcalculator
    Created on : Sep 13, 2022, 2:17:29 PM
    Author     : Rehan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>
        
        <form action="arithmetic" method="POST">
            <p><label>First: </label>
                <input type="number" id="first" name="first" value="" min="0"></p>
            
            <p><label>Second: </label>
                <input type="number" id="second" name="second" value="" min="0"></p>
            
            <button type="submit" id="add" name="operation" value="+">+</button>
            <button type="submit" id="subtract" name="operation" value="-">-</button>
            <button type="submit" id="multiply" name="operation" value="*">*</button>
            <button type="submit" id="divide" name="operation" value="%">%</button>
            
            <p>Result: <%= request.getAttribute("message") %></p>
            <a href="http://localhost:8080/Lab2/age" title="Age Calculator">Age Calculator</a>

        </form>
    </body>
</html>
