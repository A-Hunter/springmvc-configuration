<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Blog Post</title>

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
	<br></br>
	<a href="${pageContext.request.contextPath}/newBlogPost.html">New Blog Post</a>
	<br></br>

	<h1>Blog Post</h1>

	<c:if test="${empty blogposts}">
		No Blog Post is found<br></br>
	</c:if>
	<a href="${pageContext.request.contextPath}">Back</a>

		<c:if test="${not empty blogposts}">

    			<table style="width: 650px"class="table table-striped">
    			    <c:forEach var="blogpost" items="${blogposts}">
                        <tr><td>Blog post id</td><td><c:out value="${blogpost.id}"></td></tr>
                        <tr><td>Title</td><td><c:out value="${blogpost.title}"></td></tr>
                        <tr><td>Content</td><td><div style="white-space:pre"><c:out value="${blogpost.content}"></div></td></tr>
                        <tr><td>Draft</td><td><c:out value="${blogpost.draft}"></td></tr>

    			    </c:forEach>
        		</table>
    	</c:if>

<%-- 	<a href="${pageContext.request.contextPath}/displayUsersFromMySQL">Display Users stored in the MySQL database</a> --%>
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