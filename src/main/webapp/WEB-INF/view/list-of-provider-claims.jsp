<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
<head>
    <title>List of Claims </title>
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


 <!-- need to associate this data with customer id -->

			<!--  add our html table here -->

<c:choose>
                        <c:when test="${empty providerClaims}">
                            <h2> Sorry No Claims are present </h2>
                        </c:when>
                       <c:otherwise>
			<table>
				<tr>
				    <th>Claim ID </th>
					<th>ProviderID</th>
					<th>User ID</th>
					<th>DependentID</th>
					<th>Date Of Service </th>
					<th>Procedure Code</th>
                    <th>Procedure Code Description</th>
                    <th>Cost</th>
                    <th>Action</th>
				</tr>

				<!-- loop over and print our customers -->
				<c:forEach var="tempClaim" items="${providerClaims}">


					<tr>
					    <td> ${tempClaim.claimId} </td>
						<td> ${tempClaim.providerId.getId()} </td>
						<td> ${tempClaim.userId.getId()} </td>
						<td> ${tempClaim.dateOfService}</td>
						<td> ${tempClaim.procedureCode} </td>
                        <td> ${tempClaim.procedureCodeDescription} </td>
                        <td> ${tempClaim.cost} </td>

					</tr>

				</c:forEach>

			</table>
			</c:otherwise>
            			</c:choose>

			<!-- Add a logout button -->
            	<form:form action="${pageContext.request.contextPath}/logout"
            			   method="POST">

            		<input type="submit" value="Logout" />

            	</form:form>
            </div>

                            	</div>

</body>

</html>