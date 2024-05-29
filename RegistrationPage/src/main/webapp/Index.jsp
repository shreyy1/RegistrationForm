<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="regForm" method ="post">
		Name :<input type="text" name="name1" placeholder="EnterYourName"><br><br>
		
		Email :<input type="email" name ="email1" placeholder="EnterYourEmail"><br><br>
		
		Password :<input type="password" name ="pass1" placeholder="EnterYourPassword"><br><br>
		
		Gender : Male<input type="radio" name ="gender1"  value ="male" placeholder="EnterYourEmail"> Female:<input type ="radio" name ="gender1" value="female">
		<br><br>
Enter Your City:
<select name ="city1">

    <option>Bangalore</option>
    <option>Delhi</option>
    <option>Chennai</option>
    <option>Hyderabad</option>
    <option>Mumbai</option>
    <option>Pune</option>
</select><br><br>

		<input type ="submit" value="Register">
		
	
	
	</form>

</body>
</html>