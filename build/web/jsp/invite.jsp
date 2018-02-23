<%-- 
    Document   : onlinePlay
    Created on : 25 nov. 2016, 14:34:23
    Author     : utilisateur
--%>


<%@page import="Singleton.Checked"%>
<%@page import="java.util.List"%>
<%@page import="servlet.sessionList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="servlet.*"%>"
<%@page import="Donnes.*"%>
<%@page import="DAOJPA.*"%>
<%  sessionList list=sessionList.getInstance();%>
<% Joueur j1=(Joueur)session.getAttribute("joueur"); %>
<% List<Joueur> j=(List<Joueur>)session.getAttribute("listj");%>
<% Joueur joueur_invit=(Joueur)session.getAttribute("joueur_invit"); %>
<% String joueur_qui_invite=(String)session.getAttribute("joueur_qui_invite"); %>
<% String invite=(String)session.getAttribute("invite"); %>
<%ListeInvite listI=ListeInvite.getInstance();%>
<% 
   Checked nb=Checked.getInstance();
   
   
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Invitation des joueurs </title>
       
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <script type="text/javascript" src="http://code.jquery.com/jquery-1.4.4.js"></script>
          <link type="text/css" rel="stylesheet" href="css/invite.css" /> 
          <script type="text/javascript" src="js/online.js"></script>
          
      
    </head>
    <body>
        <div class="div_barre">
            
            <img src="images/1.jpg" class="image"/>
        </div>
        
     <section class="container">
    <div class="login">
      <h1>Veuillez sélectionner les joueurs invités</h1>
 
     
      <font  color="green" size="3px"><span style="font-weight:bold"><p hidden id="invt"> Invitations envoyées aux joueurs sélectionnés </p></span></font>
      <font color="gray" size="3px"><span style="font-weight:bold"><p hidden id="lien" align="center"><a href="LancerPartie">Cliquer ici Pour Lancer la partie</a></p></span></font>
        <font color="gray" size="3px"><span style="font-weight:bold"><p hidden id="lien1" align="center"><a href="Invitation">Cliquer ici Pour Répondre à l'invitation</a></p></span></font>
      <font color="red"><span style="font-weight:bold"> <p id="msg" align="center"></p></span></font>
      
                </font></span>
          <div id="div">         
      <form action="Invite" method="POST" id="form">
               <%
              joueur_qui_invite=(String)session.getAttribute(joueur_qui_invite);
             for(Joueur e: j) 
             {
                if(!e.equals(j1))
             {%>
            <br><br>
            <img src="images/co.jpg" id="img1"/>
            <font color="green" size="3px"><span style="font-weight:bold"><%out.print(e.getPseudo());%>
             <input type="checkbox" id="chck"  name="<%=e.getPseudo()%>" value="<%=e.getPseudo()%>"/>
            </span></font>
   
            <% }
             
           }//fin for
            %>
            <br>
            <input type="submit" name="Valider" id="vld" value="Inviter">
            </div>
             </form>
          
              <script type="text/javascript">
                var frm=$("#form");
                frm.submit(function (){
                  $.ajax({
                   type: frm.attr('method'),
                   url: frm.attr('action'),
                   //datatype: 'json',
                   data: frm.serialize(),
                   success:function(data)
                   { 
                    //personne n'est invité
                    if(data==="4")
                    $( "#msg" ).text("Veuillez patienter jusqu'au début de la partie courante").show().fadeOut(2000);
                    else
                    {
                    if(data==="3")
                    {
                     $( "#msg" ).text("Vous êtes déjà invités").show().fadeOut(2000);
                     $("#lien1").show();
                    }
                    else
                    {
                    if(data==="0")
                    {
                   $( "#msg" ).text("Veuillez Inviter au moins un joueur").show().fadeOut(2000);  
                    
                    }
                    else
                    {
                    //plus de 5 joueurs invités
                    if(data==="1")
                    {
                     $( "#msg" ).text("Veuillez Inviter 5 joueurs maximum").show().fadeOut(2000);
                    }
                    else
                    {
                    $("#az1").hide();
                    $("#vld").hide();
                    $("#lien").show();
                    $("#div").hide();
                    $("#invt").show();
                    }
                     }
                   }
               }
               }
               });         
               return false;       
           });  
           </script>
          
                 
                
    </div>
    
    <div class="login-help">
        <p><a href="Compte">Cliquer ici pour retourner à votre compte</a>.</p>
        
    </div>
    
  </section>

  

</html>