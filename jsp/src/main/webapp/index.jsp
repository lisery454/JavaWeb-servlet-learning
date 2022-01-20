<html>
<body>
<h2>
    Hello World!
</h2>
<h1>
    <%= new java.util.Date()%>
</h1>
<hr>
<%
    for (int i = 0; i < 10; i++) {
%>

<h1>Hello, World!</h1>

<%
    }
%>

<hr>

<%!
    int a = 0;

    public String f() {
       return ("a = " + a);
    }
%>

<%=
    f()
%>

<hr>

</body>
</html>
