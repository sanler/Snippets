<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>


<p id="nuevoUsuariobutton">
    <a id="button"  href="/snippets/newUser">Crear nuevo usuario</a>
</p>

	<button onclick="document.location.href = '/snippets/newUser'">Registrarse</button>
	
	<p id="nuevoSnippetbutton">
    <a id="button2"  href="/snippets/newSnippet">Crear nuevo snippet</a>
</p>

	<button onclick="document.location.href = '/snippets/newSnippet'">Crear nuevo snippet</button>
	
<form action="addSuggestion" method="POST">

                <table id="tablaSuggestion">
                   
                    <tr>
                        <td>
                            Usuario:
                            <input type="text" maxlength="20" size="20" name="username" value="pepita"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                          Titulo:
                            <input type="text" maxlength="100" size="100" name="title" value="una sugerencia.."/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                         Body:
                            <input type="text" maxlength="100" size="100" name="body" value="Sugiero que pongan una seccion de preguntas."/>
                        </td>
                    </tr>
                   
                </table>
                        <p>
                           <input type="submit"  value="Guardar" />
                   		</p>
                  
            </form>
            
            <table>
                                <tr>				
                                    <th>Title</th>
                                    <th>Author</th>
                                    <th>Body</th>
                                
                                </tr>
            
                                  <c:forEach var="suggestion" items="${suggestionList}">
                                
						 
                                    <tr>
                                  	  <td>${suggestion.title}</td>
                                    
                                     	<td><a href="/snippets/userSuggestion?name=${suggestion.user.username}" >${suggestion.user.username}</a></td>
                                     	 
                                        <td>${suggestion.body}</td>
                                                                                                                        

								   </tr>
							
                                </c:forEach>
			</table>
			
			<table>
                                <tr>		
                               		<th>Id</th>		
                                    <th>Type</th>
                                    <th>User</th>
                                    <th>Text</th>
                                    
                                
                                </tr>
            
                                  <c:forEach var="snippet" items="${snippetList}">
                                
						 
                                    <tr>
                                     <td><a href="/snippets/addComment?name=${snippet.id}" >${snippet.id}</a></td>
                                  	  <td>${snippet.type}</td>
                                    
                                     	<td>${snippet.user.username}</td>
                                     	 
                                        <td>${snippet.text}</td>
                                                                                                                        

								   </tr>
							
                                </c:forEach>
			</table>
			
</body>
</html>
