<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
<link
        		  rel="stylesheet"
        		  href="/css/style.css">

        	<link
        		  rel="stylesheet"
        		  href="/css/add-customer-style.css">
	<title>No Claims Page</title>
</head>
<body>
 <div id="container">

                                    		<div id="content">
Sorry no claims are present
<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
			   method="POST">

		<input type="submit" value="Logout" />

	</form:form>

	<div style="clear; both;"></div>

                		<p>
                			<a href="${pageContext.request.contextPath}/">Back to Home Page</a>
                		</p>

                	</div>

                	</div>
                	<div>
</body>
</html>