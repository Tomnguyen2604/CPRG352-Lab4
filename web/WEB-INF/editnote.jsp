<%-- 
    Document   : editnote
    Created on : 5-Jun-2021, 12:33:11 AM
    Author     : rider
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <form method="post" action="note">
        <label>Title</label>
        <input type="text" name="titleInput" value="${note.title}">
        <br>
        <label>Content</label>
        <textarea type="text" name="descriptionInput" >${note.description}</textarea>
        <br>
        <input type="submit" value="Save">
        </form>
    </body>
</html>
