<%-- 
    Document   : ListCasosDeUso
    Created on : 06-may-2013, 21:50:37
    Author     : George
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" ></script>
        <script>
            
            var casosDeUso;
            
            $(document).ready(function(){
                
                drawChart(casosDeUso); 
            });
            
            function drawChart(elements){

                var c=document.getElementById("casosDeUsoCanvas");
                var ctx=c.getContext("2d");
                ctx.fillStyle="#FF0000";
                ctx.fillRect(0,0,150,75);

            }

        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show All Casos de Uso</title>
    </head>
    <body>
        <canvas id="casosDeUsoCanvas" width="200" height="1000">
            
            casosDeUso = new Array();

            <c:forEach items="${casosDeUso}" var="cdu">
                    casoDetails = new Object();
                    casoDetails.positionX = ${cdu.positionX}; 
                    casoDetails.positionY = ${cdu.positionY};
                    casoDetails.text = ${cdu.text};
                    System.out.println(casoDetails);
                    casosDeUso.push(casoDetails);
             </c:forEach>
        </canvas>
    
    <p><a href="CasoDeUsoController?action=insert">Add Caso De Uso</a></p>
</body>
</html>
