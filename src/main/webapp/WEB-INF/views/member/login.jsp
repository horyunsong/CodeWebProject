<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%@include file="../include/header.jsp" %>
<spring:hasBindErrors name="memberVO" />
<form:errors name="memberVO" />
	<form method="post" action="/member/login">
		<table>
			<tr>
				<td>아이디 :</td>
				<td><input type="text" name="userid" />
				<div style="color:red"><form:errors path="memberVO.userid"/><!-- properties에 정의한 key 값 --></div>
				</td>
			</tr>
			<tr>
				<td>패스워드 :</td>
				<td><input type="password" name="userpw" />
				<div style="color:red"><form:errors path="memberVO.userpw"/></div></td>
				
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" name="로그인" />&nbsp;&nbsp;
					<input type="reset" name="취소" /></td>
					<div style="color:red"><form:errors path="memberVO"/></div>
			</tr>
		</table>
	</form>
	<%@include file="../include/footer.jsp" %>
</body>
</html>