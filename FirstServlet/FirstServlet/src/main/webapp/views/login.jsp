<html>
<head>
login page
</head>
<body>
<h2>employee login  form</h2>
<form action="<%=request.getContextPath()%>/login" method="post">
user name:
<input type="text" name="username"><br>
password:
<input type="password" name="password"><br>

<input type="submit" value="submit">
</form>
</body>
</html>