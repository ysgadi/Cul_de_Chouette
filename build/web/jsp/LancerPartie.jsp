<%-- 
    Document   : modification
    Created on : 22 nov. 2016, 00:59:35
    Author     : utilisateur
--%>

<%@page import="Donnes.Joueur"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Donnes.*"%>
<%@page import="DAOJPA.*"%>
<% Joueur j=(Joueur)session.getAttribute("joueur"); %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <script type="text/javascript" src="http://code.jquery.com/jquery-1.4.4.js"></script>
          <link type="text/css" rel="stylesheet" href="css/Lpartie.css" />
           <META http-equiv="REFRESH" content="14">
           
         
          <title>Lancer la partie</title>
    </head>
    
    <body>

        
        <h1></h1>
           <div class="div_barre">
            
            <img src="images/1.jpg" class="image"/>
        </div>
        
     <section class="container">
    <div class="login">
        <h1 size>Lancer la partie  <font color="green"><%out.print( j.getPseudo());%> </font></h1>
            
      
           <form id="form2" method="get" action="TestInvite">
               
                <font color="green" size="2px"><span style="font-weight:bold">
                <p id="msg1" align="center"></p>
                 <p hidden id="hid1" align="center">  <a href="TourServlet">Cliquer ici pour Définir l'ordre des joueurs</a></p>
                 <p hidden id="hid2" align="center">  <a href="Compte">Cliquer ici pour retourner à votre compte</a></p>
                 <font color="red" size="2px"><span style="font-weight:bold">
                 <p id="msg" align="center"></p>
                 <input type="submit" value="Lancer Partie"  id="btn"/>
            </form>
            <script type="text/javascript">
            
                var frm=$("#form2");
                frm.submit(function (){
                  $.ajax({
                   type: frm.attr('method'),
                   url: frm.attr('action'),
                   //datatype: 'json',
                   data: frm.serialize(),
                   success:function(data)
                   {  
                   var a=parseInt(data);
                   if(a===0)
                    $( "#msg" ).text("Veuillez patienter ils ya des notifications en Attentes").show().fadeOut(3000);  
                   else
                   {
                     if(a===1)
                     {
                    $( "#msg" ).text("Toutes les notifications ont été refuser");
                      $("#hid2").toggle(400);
                    $("#btn").hide();
                    } 
                    else
                    {
                    $( "#msg1" ).text("Tous les joueurs ont répondu à votre invitation").show().fadeOut(3000);  
                     $("#hid1").toggle(400); 
                    $("#btn").hide();
                     
           
                    }
                   }//fin else
                   }
               });         
               return false;       
           });  
           </script>
             
            
        
    </div>
    
  </section>
     
     
    </body>
</html>
