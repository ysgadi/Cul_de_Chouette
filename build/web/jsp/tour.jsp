


<%-- 
    Document   : index
    Created on : 23 nov. 2016, 01:29:37
    Author     : utilisateur
--%>

<%@page import="Singleton.*"%>
<%@page import="java.util.List"%>
<%@page import="servlet.ListeInvite"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Donnes.*"%>
<%@page import="DAOJPA.*"%>
<% Joueur joueur_invit=(Joueur)session.getAttribute("joueur_invit"); %>
<% ListeInvite listI=ListeInvite.getInstance();%>
<% 
   SingEntier tour=SingEntier.getInstance();
   SingEntierServ indice=SingEntierServ.getInstance();
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <script type="text/javascript" src="http://code.jquery.com/jquery-1.4.4.js"></script>
          <link type="text/css" rel="stylesheet" href="css/tourr.css" />
          
          
         
        <title>Affecter Tour</title>
    </head>
    <body>
       
        <div class="div_barre">
            
            <img src="images/1.jpg" class="image"/>
        </div>
        
     <section class="container">
    <div class="login">
      <h1>La liste des joueurs qui ont accepté votre invitation</h1>
      
    
      <form  id="form2" method="post" action="AffectTourJ" >
          <div style="margin-left:65px"> 
               
          </div>   
     
          <%--tour=0,1,... --%>
          <font  size="2px"><span style="font-weight:bold">
      <% for (Joueur  e: listI.list)
     {
       %>
     <img src="images/co.jpg" id="img1"/>
       <%
     out.print(e.getPseudo());
     %>
     <input type="text" id="inp"name="<%=tour.tour%>" />
     <p class="submit"><input type="submit" name="invit" id="btn" value="Ordre Joueur <%=e.getPseudo() %>"></p>  
       <p id="msg" align="center"></p>
     <%
       tour.inc();
     %>
     
     </form>
     <% }//fin for %>

      
          <p hidden id="hid" align="center">  <a href="#">Click ici pour Afficher Votre Tour</a></p>
           
        
         <font color="green" size="2.5px"><span style="font-weight:bold">
             <p align="center" disabled>  <a href="scoreLimit" id="lien"></a></p>
                   
         
               <script type="text/javascript">
                var frm=$("#form2");
                frm.submit(function (){
                  $.ajax({
                   type: frm.attr('method'),
                   url: frm.attr('action'),
                   data: frm.serialize(),
                   success:function(data)
                   {  
                   if(data==="1")
                    $( "#lien" ).text("Cliquer ici pour définir le score limite du partie");
                   }
               });         
               return false;       
           });  
           </script>         
      </div>           
    
  </section>
    </body>
</html>
