<%-- 
    Document   : TourInvite
    Created on : 9 déc. 2016, 00:25:36
    Author     : utilisateur
--%>

<%@page import="Singleton.ListeJoueurPartie"%>
<%@page import="servlet.SingInvite"%>
<%@page import="servlet.ListeInvite"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Donnes.*"%>
<%@page import="DAOJPA.*"%>

<% Joueur j=(Joueur)session.getAttribute("joueur"); %>
<%ListeJoueurPartie listePartie=ListeJoueurPartie.getInstance();%>
<%SingInvite jrt=SingInvite.getInstance(j);%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <script type="text/javascript" src="http://code.jquery.com/jquery-1.4.4.js"></script>
          <link type="text/css" rel="stylesheet" href="css/tour_j.css" />
          
         
        <title>Détails de votre tour</title>
    </head>
    <body>
       
        <div class="div_barre">
            
            <img src="images/1.jpg" class="image"/>
        </div>
        
     <section class="container">
    <div class="login">
      <h1>Détails de votre tour <font color="green"><%=j.getPseudo()%></font></h1>
     
         <form  id="form2" method="get" action="TesteTour" >
             <% 
                for(Joueur e:listePartie.list)
                if(e.equals(j))
                {
                    j.setTour(e.getTour());
                    break;
                }
              %>
           <p hidden id="hid1" align="center">  <a href="game">Cliquer ici pour rejoindre la partie</a></p>
        <font color="red" size="2px"><span style="font-weight:bold">
         <p id="msg1" align="center"></p>
         <font color="green" size="2px"><span style="font-weight:bold">
          <p id="msg" align="center"></p>
         <p class="submit"><input type="submit" name="invit" id="invit" value="Afficher"></p>
         
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
                    {
                   $( "#msg1" ).text("Votre tour n'a pas été encore défini").show().fadeOut(3000);
                     }
                    else
                    {
                   $( "#msg" ).text("Votre tour a été défini");  
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

