<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>

<form action="${pageContext.request.contextPath}/login" method="get">
    username:<input type="text" name="username"> <br>
    password:<input type="password" name="password"> <br>
    <input type="submit">
</form>

</body>
</html>
