<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Provider</title>

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
			<h2>Provider Details</h2>
		</div>
	</div>

	<div id="container">
	    <div id ="content">
		<h3>Save Provider</h3>

		<form:form action="save" modelAttribute="providers" method="POST">

		    <!-- need to associate this data with customer id -->
            <form:hidden path="id" />

			<table>
				<tbody>

					<tr>
						<td><label>Provider Name: </label></td>
						<td><form:input path="providerName" />
						<form:errors path="providerName" cssClass="error" /></td>
					</tr>

                    <tr>
						<td><label>email:</label></td>
						<td><form:input path="email" />
						<form:errors path="email" cssClass="error" /></td>
					</tr>

					<tr>
                    						<td><label>speciality:</label></td>
                    						<td><form:input path="speciality" />
                    						<form:errors path="speciality" cssClass="error" /></td>
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
			<a href="${pageContext.request.contextPath}/providers/list">Back to List</a>
		</p>

	</div>
	</div>

</body>

</html>