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

		<form:form action="save" modelAttribute="claims" method="POST">

		    <!-- need to associate this data with customer id -->
            <form:hidden path="id" />

			<table>
				<tbody>
                    <tr>
						<td><label>Claim ID:</label></td>
						<td><form:input path="claimId" />
						<form:errors path="claimId" cssClass="error" /></td>
					</tr>

					<tr>
						<td><label>Provider ID:</label></td>
						<td><form:input path="providerId" />
						<form:errors path="providerId" cssClass="error" /></td>
					</tr>

					<tr>
						<td><label>User ID:</label></td>
						<td><form:input path="userId" />
						<form:errors path="userId" cssClass="error" /></td>
					</tr>


                    <tr>
						<td><label>Procedure Code(*):</label></td>
						<td><form:input path="procedureCode" />
						<form:errors path="procedureCode" cssClass="error" /></td>
					</tr>

                    <tr>
						<td><label>Procedure Code Description:</label></td>
						<td><form:input path="procedureCodeDescription" />
						<form:errors path="procedureCodeDescription" cssClass="error" /></td>
					</tr>

                    <tr>
						<td><label>Cost:</label></td>
						<td><form:input path="cost" />
						<form:errors path="cost" cssClass="error" /></td>
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