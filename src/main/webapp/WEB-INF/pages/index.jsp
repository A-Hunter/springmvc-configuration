<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>

<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet"/>
<link href="${pageContext.request.contextPath}/resources/css/template.css" rel="stylesheet"/>
<script src="${pageContext.request.contextPath}/resources/js/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="brand" href="http://www.google.com"><b>Google</b></a>
			<div class="nav-collapse collapse">
				<ul class="nav">
					<li class="active"><a href="${pageContext.request.contextPath}">Home</a></li>
					<li><a href="${pageContext.request.contextPath}/promo.html">Promo</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>

<div>
	<h1>Java Spring MVC Configuration</h1>
	<p>This application provides configuration a simple spring mvc project.</p>
	<a href="${pageContext.request.contextPath}/displayUsers">Display Users stored in the embedded database</a>
	<br></br>
	<a href="${pageContext.request.contextPath}/displayUsersFromMySQL">Display Users stored in the MySQL database</a>
	
	<br></br>
	<a href="${pageContext.request.contextPath}/newBlogPost.html">New Blog Post</a>
	

</div>

<footer class="footer">
	<div class="container">
		<p class="text-muted"><b>For further information, you can send your emails to : support@corp.com</b></p>
		<a href="<%=request.getContextPath()%>?language=en">EN</a>
		<a href="<%=request.getContextPath()%>?language=fr">FR</a>
		<a href="<%=request.getContextPath()%>?language=de">DE</a>
<!-- 		<spring:message code="language"/> -->
<!-- 		<font color="green"><b><spring:message code="welcome.text"/></b></font> -->
	</div>
</footer>

</body>
</html>