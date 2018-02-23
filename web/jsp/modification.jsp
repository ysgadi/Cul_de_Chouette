<%-- 
    Document   : modification
    Created on : 24 nov. 2016, 17:00:48
    Author     : utilisateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Donnes.*"%>
<%@page import="DAOJPA.*"%>
<% Joueur j=(Joueur)session.getAttribute("joueur"); %>

<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <script type="text/javascript" src="http://code.jquery.com/jquery-1.4.4.js"></script>
        <script type="text/javascript" src="js/modif.js"></script>
         <link type="text/css" rel="stylesheet" href="css/modif.css" />
        <title>Modification du compte</title>
        
    </head>
    <body>
        <div class="div_barre">
            
            <img src="images/1.jpg" class="image"/>
        </div>
        
         <section class="container">
           <div class="ins">
               <h1>Modification du compte <font color="green"><%=j.getPseudo()%></font></h1>
       <form id="form3" action="Modification" method="post" onsubmit="return valider_modify_joueur(this);" > 
           
          
            <p><input placeholder="Mot de passe" type="text" name="pswd" onblur="verif_password(this)"   value=""onkeyup="verif_password(this)"/>
     <div class="div-droit-droit">
         <p id="gpss"> </p></div>
 </p>
  
 <p><input placeholder="Age"type="text" name="age"    value=""onblur="verif_age(this)" onkeyup="verif_age(this)"/>
     <div class="div-droit-droit">
         <p id="gpage"> </p></div>
 
 
<p><input type="text" name="ville" placeholder="Ville"   value=""onblur="verif_ville(this)" onkeyup="verif_ville(this)" />
     <div class="div-droit-droit">
         <p id="gpville"> </p></div>
</p>
<div id="modif1">
<p align="center" id="modif"> <font size="3px"></p>
</div>
    <p class="submit"><input type="submit" value="Modifier"> </p>
</form>
              <script type="text/javascript">
                var frm=$("#form3");
                frm.submit(function (){
                  $.ajax({
                   type: frm.attr('method'),
                   url: frm.attr('action'),
                   //datatype: 'json',
                   data: frm.serialize(),
                   success:function(data)
                   { 
                    
                   $( "#modif" ).text(data).show();
                   }
               });         
               return false;       
           });  
           </script>

<br>  
           </div>
      <div class="login-help">
        <a href="Compte">Cliquer ici pour retourner à votre compte</a>
        
    </div>
         </section>
    </body>
</html>
