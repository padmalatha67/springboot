<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
<head>
    <title>List Claims </title>
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
    			<h2>Claim Details</h2>

    			</div>
                    </div>

 <div id="container">

		<div id="content">

    			<!-- put new button: Add Customer -->

                            <input type="button" value="Add Claims"
                            				   onclick="window.location.href='new'; return false;"
                            				   class="add-button"
                            />



			<!--  add our html table here -->


            <c:choose>
            <c:when test="${empty claims}">
                <h2> Sorry No  Claims are present, please add </h2>
            </c:when>
           <c:otherwise>
			<table class="table table-striped">
				<tr>
				    <th>Claim ID </th>
					<th>ProviderID</th>
					<th>User ID</th>
					<th>Date Of Service </th>
					<th>Procedure Code</th>
                    <th>Procedure Code Description</th>
                    <th>Cost</th>
                    <th>Action</th>



</tr>
				<!-- loop over and print our customers -->
				<c:forEach var="tempClaim" items="${claims}">

                        <!-- construct an "update" link with customer id -->
    					<c:url var="updateLink" value="/claims/update">
    						<c:param name="claimId" value="${tempClaim.id}" />
    					</c:url>

    					<!-- construct an "update" link with customer id -->
                        <c:url var="deleteLink" value="/claims/delete">
                            <c:param name="claimId" value="${tempClaim.id}" />
                        </c:url>

					<tr>
					    <td> ${tempClaim.claimId} </td>
						<td> ${tempClaim.providerId.getId()} </td>
						<td> ${tempClaim.userId.getId()} </td>
						<td> ${tempClaim.dateOfService}</td>
						<td> ${tempClaim.procedureCode} </td>
                        <td> ${tempClaim.procedureCodeDescription} </td>
                        <td> ${tempClaim.cost} </td>
                        <td>
                        							<!-- display the update link -->
                        							<a href="${updateLink}">Update</a>
                        							|
                        							<a href="${deleteLink}"
                        							   onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
                        						</td>

					</tr>

				</c:forEach>


			</table>
			</c:otherwise>
			</c:choose>

			<div style="clear; both;"></div>

            		<p>
            			<a href="${pageContext.request.contextPath}/">Back to Home Page</a>
            		</p>

            	</div>

			<!-- Add a logout button -->
            	<form:form action="${pageContext.request.contextPath}/logout"
            			   method="POST">

            		<input type="submit" value="Logout" />

            	</form:form>

            	</div>

                	</div>

</body>

</html>