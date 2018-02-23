<%-- 
    Document   : index
    Created on : 23 nov. 2016, 01:29:37
    Author     : utilisateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Donnes.*"%>
<%@page import="DAOJPA.*"%>
<% Joueur j=(Joueur)session.getAttribute("joueur"); %>
<% Joueur joueur_invit=(Joueur)session.getAttribute("joueur_invit"); %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%--
         <META http-equiv="REFRESH" content="10">
        --%>
          <script type="text/javascript" src="http://code.jquery.com/jquery-1.4.4.js"></script>
          <link type="text/css" rel="stylesheet" href="css/stylee.css" />
          
         
        <title>Confirmer l'invitation</title>
    </head>
    <body>
       
        <div class="div_barre">
            
            <img src="images/1.jpg" class="image"/>
        </div>
        
     <section class="container">
    <div class="login">
      <h1>Confirmer l'invitation<font color="green"><%out.print(" "+j.getPseudo());%></font></h1>
      
      <form  id="form2" method="post" action="Invitation" >
          <div style="margin-left:65px"> 
           <font color="black" size="2px"><span style="font-weight:bold">
                
                <input type="radio" name="reponse" value="Accepter" checked="checked"/>
                Accepter
               
                <br><br>
               
                <input type="radio" name="reponse" value="Refuser" />
                Refuser
          </div>   
      
          <br>
           <p hidden id="hid" align="center">  <a href="TourJoueur">Cliquer ici pour afficher votre tour</a></p>
            <p hidden id="hid1" align="center">  <a href="Compte">Cliquer ici pour retourner à votre compte</a></p>
           
         <p class="submit"><input type="submit" name="invit" id="invit" value="Confirmer"></p>
         <font color="green" size="2px"><span style="font-weight:bold">
                <p id="msg1" align="center"></p>
               <font color="red" size="2px"><span style="font-weight:bold">
                <p id="msg" align="center"></p>
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
                    if(a===1)
                    {
                   $( "#msg1" ).text("Invitation Accepter").show();
                    $("#hid").toggle(400);
                    $("#invit").hide();
                     }
                     else
                     {
                   $( "#msg" ).text("Invitation Refuser").show();  
                       $("#hid1").toggle(400);
                        $("#invit").hide();
                      }
                   }
               });         
               return false;       
           });  
           </script>


      </div>           
    
  </section>
    </body>
</html>
