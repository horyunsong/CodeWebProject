<%@ page pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%@include file="../include/header.jsp" %>

		<table>
			<tr>
				<td>아이디 :</td>
				<td>${memberVO.userid }</td>
			</tr>
			<tr>
				<td>패스워드 :</td>
				<td>${memberVO.userid }</td>
			</tr>

		</table>

	<%@include file="../include/footer.jsp" %>
</body>
</html>