<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html>
<head>
    <title>List Of Users </title>
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
    			<h2>User Details</h2>

    			</div>
    			</div>

    			<div id="container">

                                                    		<div id="content">



                    <security:authorize access="hasRole('ADMIN')">


                            <input type="button" value="Add user"
                            				   onclick="window.location.href='new'; return false;"
                            				   class="add-button"
                            />

                     </security:authorize>

			<!--  add our html table here -->

 <c:choose>
            <c:when test="${empty users}">
                <h2> Sorry No  users are present, please add </h2>
            </c:when>
           <c:otherwise>
			<table>
				<tr>
					<th>Name</th>
					<th>Email</th>
					 <security:authorize access="hasRole('ADMIN')">
                        <th>Action</th>
                     </security:authorize>
				</tr>

				<!-- loop over and print our customers -->
				<c:forEach var="tempUser" items="${users}">

                     <security:authorize access="hasRole('ADMIN')">
                        <!-- construct an "update" link with customer id -->
    					<c:url var="updateLink" value="/users/update">
    						<c:param name="userId" value="${tempUser.id}" />
    					</c:url>

    					<!-- construct an "update" link with customer id -->
                        <c:url var="deleteLink" value="/users/delete">
                            <c:param name="userId" value="${tempUser.id}" />
                        </c:url>
                     </security:authorize>

					<tr>
						<td> ${tempUser.userName} </td>
						<td> ${tempUser.email} </td>
						 <security:authorize access="hasRole('ADMIN')">
                             <td>
                        							<!-- display the update link -->
                        							<a href="${updateLink}">Update</a>
                        							|
                        							<a href="${deleteLink}"
                        							   onclick="if (!(confirm('Are you sure you want to delete this user?'))) return false">Delete</a>
                        						</td>
                        </security:authorize>

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

	<div style="clear; both;"></div>

                                		<p>
                                			<a href="${pageContext.request.contextPath}/">Back to Home Page</a>
                                		</p>

                                	</div>

                                	</div>
                                	</div>
</body>

</html>