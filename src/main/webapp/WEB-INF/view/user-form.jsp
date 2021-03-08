<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Customer</title>

	<link
		  rel="stylesheet"
		  href="/css/style.css">

	<link
		  rel="stylesheet"
		  href="/css/add-customer-style.css">

		  <style>
          		.error {color:red}
          	</style>
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Claim Details</h2>
		</div>
	</div>

	<div id="container">
	    <div id="content">
		<h3>Save Claim</h3>

		<form:form action="save" modelAttribute="users" method="POST">

		    <!-- need to associate this data with customer id -->
            <form:hidden path="id" />

			<table>
				<tbody>

					<tr>
						<td><label>User Name:</label></td>
						<td><form:input path="userName" />
						<form:errors path="userName" cssClass="error" /></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" />
						<form:errors path="email" cssClass="error" /></td>
					</tr>


					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>


				</tbody>
			</table>


		</form:form>

		<div style="clear; both;"></div>

		<p>
			<a href="${pageContext.request.contextPath}/claims/list">Back to List</a>
		</p>

	</div>
	</div>

</body>

</html>