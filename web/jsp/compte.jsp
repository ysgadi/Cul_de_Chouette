<%-- 
    Document   : modification
    Created on : 22 nov. 2016, 00:59:35
    Author     : utilisateur
--%>

<%@page import="Singleton.ListeJoueurPartie"%>
<%@page import="Singleton.tourGame"%>
<%@page import="Donnes.Joueur"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Donnes.*"%>
<%@page import="DAOJPA.*"%>
<%@page import="servlet.*"%>
<% Joueur j=(Joueur)session.getAttribute("joueur"); %>
<% Joueur joueur_invit=(Joueur)session.getAttribute("joueur_invit"); %>
<%  String Pseudo_invit= (String)session.getAttribute("invite"); %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <script type="text/javascript" src="http://code.jquery.com/jquery-1.4.4.js"></script>
          <link type="text/css" rel="stylesheet" href="css/compte.css" />
           
          <!-- compte modifier la classe container !-->
        <title>Compte</title>
    </head>
    
    <body>

        
        <h1></h1>
           <div class="div_barre">
            
            <img src="images/1.jpg" class="image"/>
        </div>
        
     <section class="container">
    <div class="login">
        <h1 size>Bienvenue <font color="green"><%out.print( j.getPseudo());%> </font></h1>
        
 <table id="table">
 
  </table>  
        <p id="ici"></p>     
       <a hidden id="lieninvite" href="Invitation"> <img src="images/notification.png" class="notif"/></a>
       <font color="green" size="2px"><span style="font-weight:bold"> <p id="nominvite" align="center"></p>
       <script>
         $(document).ready(
             function() {
              var x=0;
                x=setInterval(function() {
       
                     $.get('essay', {
                     reqo: "information"
                    }, function (responseText) {
                     var json = JSON.parse(responseText);
                    document.getElementById("table").innerHTML =json.tab;
                   // alert(responseText);
                    }, false);
                    
                     $.get('essay', {
                     reqo: "notification"
                    }, function (responseText) {
                  if(responseText!=="0")
                  {
                  $("#lieninvite").show();
                 $( "#nominvite" ).text("Nouvelle Notification de la part du joueur "+responseText).show();
                  }
                    }, false);
                  //fin setintervale
                },100);
                //1er get pour fair tourner le bouton Lancer
                 
           });
            </script>
   
            </script>
       <input type="submit" value="Statistique" id="stat"/>
       <script>
             $( "#stat" ).click(function( event ) {
                     window.location="http://localhost:8084/WebApplicationCulDeChouette/AfficheStat";
                    //fin get
                    });//fin submit
       </script>
    </div>
   
   
     
      <%-- -----------------------------------------------------------%>
      
     
    <div class="login-help">
        
         <p><a href="Modification">Cliquer ici pour modifier vos informations</a></p>
        <p><a href="OnlineP">Cliquer ici pour voir les joueurs en ligne</a></p>
          <p><a href="Logout">Cliquer ici pour déconnecter</a></p>
        
    </div>
    
  </section>
     
     
    </body>
</html>
