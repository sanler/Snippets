<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Añadir un comentario a un snippet</title>
</head>
<body>
<p>Añadir un comentario al snippet con id: ${snippetId}</p>

<form action="regComment" method="POST">

                <table id="tablaSnippet" style="margin-left: 240px; width: 661px;" cellspacing="0" cellpadding="0" cellspacing="0" cellpadding="0">
                    
                    <tr>
                        <td>
                            Usuario:
                            <input type="text" maxlength="20" size="20" name="nameuser" value="pepita"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Comentario:
                            <input type="text" maxlength="100" size="100" name="text" />
                        </td>
                    </tr>
                    
                    <tr>
                        <td>
                         
                            <input type="hidden" maxlength="100" size="100" name="snippetId" value="${snippetId}"/>
                        </td>
                    </tr>
                    
                </table>
                        <p>
                           <input type="submit"  value="Guardar" />
                   		</p>
                  
            </form>



</body>
</html>