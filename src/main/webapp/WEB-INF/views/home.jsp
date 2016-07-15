<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- %@ page session="false" %-->
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<!-- 
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
-->
<%@include file="include/header.jsp" %>

    <!-- Main content -->
    <section class="content">
      <div class="row">
      <!-- left column -->
      <div class="col-md-12">
        <!-- general form elements -->

					<div class="box">
            <div class="box-header with-border">
              <h3 class="box-title">HOME PAGE ! WELCOME ${USER_KEY.email } </h3>
            </div>
          </div>
      </div><!--/.col (left) -->
      </div>   <!-- /.row -->
    </section><!-- /.content -->
<P>  The time on the server is ${serverTime}. </P>
    
<%@include file="include/footer.jsp" %>
</body>
</html>
