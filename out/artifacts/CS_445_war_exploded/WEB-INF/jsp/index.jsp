<%--
  Created by IntelliJ IDEA.
  User: valentinpichavant
  Date: 6/6/17
  Time: 6:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <head>
      <script src="${pageContext.request.contextPath}/static/js/jquery-2.0.3.js"></script>
      <script>
          $(document).ready(function(){
              $("#hide").click(function(){
                  $("p").hide();
              });
              $("#show").click(function(){
                  $("p").show();
              });
          });
      </script>
    </head>
  </head>
  <body>
  $END$
  <p>If you click on the "Hide" button, I will disappear.</p>

  <button id="hide">Hide</button>
  <button id="show">Show</button>
  ${controller}
  </body>
</html>
