<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>PAGINA NUEVA</p>

<table>
                                <tr>				
                                    <th>Title</th>
                                    <th>Author</th>
                                    <th>Body</th>
                                
                                </tr>
            
                                  <c:forEach var="suggestions" items="${suggestions}">
                                
						 
                                    <tr>
                                  	   <td>${suggestions.title}</td>
                                    
                                     	<td>${suggestions.user.username}</td>
                                     	 
                                        <td>${suggestions.body}</td>
                                                                                                                        

								   </tr>
							
                                </c:forEach>
			</table>



</body>
</html>