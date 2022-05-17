<%@ page import="java.util.List" %>
<%@ page import="com.example.model.Todo" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body class="container">

<hr/>
<h1>springboot-web</h1>
<hr/>

<table class="table">
    <%
        List<Todo> todos = (List<Todo>) request.getAttribute("todos");
        for (Todo todo : todos) {
    %>

    <tr>
        <td><%=todo.getId()%>
        </td>
        <td><%=todo.getTitle()%>
        </td>
        <td><%=todo.isCompleted()%>
        </td>
    </tr>

    <%
        }
    %>

</table>

</body>
</html>