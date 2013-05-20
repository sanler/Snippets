<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nuevo snippet</title>
</head>
<body>
<p>nuevo snippet</p>


            <form action="addSnippet" method="POST">

                <table id="tablaSnippet" style="margin-left: 240px; width: 661px;" cellspacing="0" cellpadding="0" cellspacing="0" cellpadding="0">
                    
                    <tr>
                        <td>
                            Usuario:
                            <input type="text" maxlength="20" size="20" name="username" value="pepita"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Texto:
                            <input type="text" maxlength="20" size="20" name="text" value="codigo"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                          Tipo de código fuente:
                            <input type="text" maxlength="20" size="20" name="type" value="java"/>
                        </td>
                    </tr>
                   
                </table>
                        <p>
                           <input type="submit"  value="Guardar" />
                   		</p>
                  
            </form>





</body>
</html>