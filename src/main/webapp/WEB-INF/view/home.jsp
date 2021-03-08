<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
	<title>Home Page</title>
	<link
    		  rel="stylesheet"
    		  href="/css/style.css">

    	<link
    		  rel="stylesheet"
    		  href="/css/add-customer-style.css">
</head>

<body>
<div id="wrapper">
		<div id="header">
	<h2>Home Page</h2>
	</div>
    	</div>
	<hr>
	<p>
	Welcome to home page!
	</p>


	<hr>


                                    <div id="container">

                                    		<div id="content">
	<!-- display user name and role
	    principal.username will display the user_id by the spring -->
	<p>
		User:<security:authentication property="principal.username"/>
		<br><br>
		Roles:<security:authentication property="principal.authorities"/>
	</p>

	<!-- this security tag will display content based on the role  if we do not give this for john in the home page it will be able to see the links
	but using access-denied we are giving a custom message as the user is unauthorized -->

	<security:authorize access="hasRole('ADMIN')">
	<p>
		<a href="${pageContext.request.contextPath}/claims/list">List of Claims</a>
		(Only for Admin)
	</p>

	<p>
        		<a href="${pageContext.request.contextPath}/providers/list">List of Providers</a>
        		(Only for Admin)
        	</p>

        	<p>
                		<a href="${pageContext.request.contextPath}/users/list">List of Users</a>
                		(Only for Admin)
                	</p>
	</security:authorize>




	<security:authorize access="hasRole('PROVIDER')">
    	<p>
    		<a href="${pageContext.request.contextPath}claims/list/by/provider">List of Claims</a>
    		(Only for Provider)
    	</p>
    	</security:authorize>


	<security:authorize access="hasRole('INDIVIDUAL')">
    	<p>
    		<a href="${pageContext.request.contextPath}claims/list/by/user">List of Claims</a>
    		(Only for User)

    	</p>

    	<p>
            		<a href="${pageContext.request.contextPath}/providers/list">List of Providers</a>
            		(Only for User Viewing)
            	</p>


    	</security:authorize>
	<hr>
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
	
		<input type="submit" value="Logout" />
	
	</form:form>

	</div>
	</div>

</body>

</html>