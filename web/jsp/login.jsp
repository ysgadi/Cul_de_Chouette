<%-- 
    Document   : index
    Created on : 23 nov. 2016, 01:29:37
    Author     : utilisateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Donnes.*"%>
<%@page import="DAOJPA.*"%>

<% String notfound=(String)request.getAttribute("notfound");%>
<% String pseudo=(String)request.getAttribute("logn");%>
<% String pwd=(String)request.getAttribute("passerror");%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <script type="text/javascript" src="http://code.jquery.com/jquery-1.4.4.js"></script>
          <link type="text/css" rel="stylesheet" href="css/loginCompte.css" />
          <script type="text/javascript" src="js/insj.js"></script>
         
        <title>Page de connexion</title>
    </head>
    <body>
       
        <div class="div_barre">
            
            <img src="images/1.jpg" class="image"/>
        </div>
        
     <section class="container">
    <div class="login">
      <h1>Page de connexion</h1>
     

        
        <form id="form2" method="get" action="Conexion">
            <p><input type="text" name="login" onblur="verif_pseudo(this)" onkeyup="verif_pseudo(this)" value="<%if(pseudo!=null)out.print(pseudo);%>"placeholder="Pseudo"></font></p>
          <div class="div-droit-droit">
            <p id="gpsd"> </p>
          </div>
       
          <p><input type="password" name="password"  value="" placeholder="Mot de passe" onblur="verif_password(this)" onkeyup="verif_password(this)"></p>
          <div class="div-droit-droit">
            <p id="gpss"> </p>
          </div>
          <br>
               <font color="red" size="2px"><span style="font-weight:bold">
                <p id="msg" align="center"></p>
                <p class="submit">     <input type="submit" value="Connecter"  id="btn"/></p>
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
                 if(data==="0")
                 $( "#msg" ).text("Votre pseudo n'existe pas").show().fadeOut(2000);
                 else
                  {
                  if(data==="1")
                  $( "#msg" ).text("Mot de passe incorrect").show().fadeOut(2000);
                  else
                window.location="Compte"; 
                
               }
                   }
               });         
               return false;       
           });  
           </script>
           <a href="Compte">
           <p align="center">
             <font color="green" size="2px" ><span style="font-weight:bold">
              
            <%Joueur j1=(Joueur)session.getAttribute("joueur");
            if(j1!=null)
            out.print("vous êtes déjà connecté");
            %>
            </font>
           </a>
     
    </div>

    <div class="login-help">
        <p>Vous n'avez pas un compte? <a href="Inscription">Cliquer ici pour s'enregistrer</a>.</p>
        
    </div>
    
  </section>

  

    </body>
</html>
