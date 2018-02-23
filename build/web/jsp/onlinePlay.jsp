<%-- 
    Document   : onlinePlay
    Created on : 25 nov. 2016, 14:34:23
    Author     : utilisateur
--%>



<%@page import="java.util.List"%>
<%@page import="servlet.sessionList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Donnes.*"%>
<%@page import="DAOJPA.*"%>
<%  sessionList list=sessionList.getInstance();%>
<% Joueur j1=(Joueur)session.getAttribute("joueur"); %>
<% List<Joueur> j=(List<Joueur>)session.getAttribute("listj");%>
<% Joueur joueur_invit=(Joueur)session.getAttribute("joueur_invit"); %>
<% String joueur_qui_invite=(String)session.getAttribute("joueur_qui_invite"); %>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <script type="text/javascript" src="http://code.jquery.com/jquery-1.4.4.js"></script>
        <title>Online Players</title>
          <link type="text/css" rel="stylesheet" href="css/invite.css" /> 
          <script type="text/javascript" src="js/online.js"></script>
          
        
          
        <title>Login</title>
    </head>
    <body>
      
        <div class="div_barre">
            
            <img src="images/1.jpg" class="image"/>
            
        </div>
        
     <section class="container">
         
         
    <div class="login">
      <h1>Les joueurs en ligne</h1>
      
      <table id="table" hidden>
          
      </table>
      <p align="center" id="lolo"><font color="green" size="4px"><span style="font-weight:bold"></p>
                
        
          
           <p align="center" id="nop" hidden><font color="red" size="4px" align=""><span style="font-weight:bold">Aucun joueur en ligne</span></font>  
           <p align="center"><font color="green" size="4px"><span style="font-weight:bold">
              <img hidden src="images/co.jpg" id="img1"/>
    </div>
            

	
        

    <div class="login-help">
        <p id="inv" hidden><a href="Invite" >Cliquer ici pour inviter les joueurs en ligne</a></p>
        <p><a href="Compte">Cliquer ici pour retourner à votre compte</a>.</p>
        
    </div>
      <script>
             $(document).ready(
             function() {
               setInterval(function() {
                   $.get('OnlinePP', {
                        reqo: "listJoueur"
                    }, function (responseText) {
                     
                     
                     if(responseText==="1")
                     {
                     $("#table").hide();
                     $("#nop").show(); 
                     $("#inv").hide();
                     }
                     
                      else
                      {
                      var json = JSON.parse(responseText);
                      $("#table").show();
                      $("#nop").hide();
                      $("#inv").show();
                      document.getElementById("table").innerHTML =json.joueurs;  
                       }
                    }, false);
                }, 200);
           });
            </script>
  </section>

  

</html>
