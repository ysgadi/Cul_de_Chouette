<%--
    Document   : inscription
    Created on : 21 nov. 2016, 11:01:48
    Author     : utilisateur
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Donnes.*"%>
<%@page import="DAOJPA.*"%>


<% String msg1 = (String) request.getAttribute("msg");%>
<% String pseudo = (String) request.getAttribute("pseudo");%>
<% String password = (String) request.getAttribute("password");%>
<% String ville = (String) request.getAttribute("ville");%>
<% String age = (String) request.getAttribute("age");%>
<% String cree = (String) request.getAttribute("cree");%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <script type="text/javascript" src="http://code.jquery.com/jquery-1.4.4.js"></script>
        <script type="text/javascript" src="js/insj.js"></script>
        <link type="text/css" rel="stylesheet" href="css/stylee.css" />
        <title>Inscription</title>
        
    </head>
    <body>
        <div class="div_barre">

            <img src="images/1.jpg" class="image"/>
        </div>

        <section class="container">
            <div class="ins">
                <h1>Création d'un compte</h1>
                <form id="form2" action="Inscription" method="post" onsubmit="return valider_ajout_joueur(this);" >
                    <%--Pseudo:--%>


                  <p><input placeholder="Pseudo"type="text" name="psd" onblur="verif_pseudo(this)" onkeyup="verif_pseudo(this)"
                              value="<%if (pseudo != null) {out.print(pseudo);} %>">
                      <font color="red">
                      <%if (msg1 != null) 
                         out.print(msg1);%>
                         </font> </P>
                    <div class="div-droit-droit">
                        <p id="gpsd"> </p></div>

                  


                    <p><input placeholder="Mot de passe" type="text" name="pswd" onblur="verif_password(this)"   value="<%if (password != null) {
         out.print(password);
     } %>"onkeyup="verif_password(this)"/>
                    <div class="div-droit-droit">
                        <p id="gpss"> </p></div>
                    </p>



                    <p><input placeholder="Age"type="text" name="age"    value="<%if (age != null) {
         out.print(age);
     }   %>"onblur="verif_age(this)" onkeyup="verif_age(this)"/>
                    <div class="div-droit-droit">
                        <p id="gpage"> </p></div>


                    <p id="radio"> <input type="radio" name="sex" value="H" checked/>Homme</p>
                    <p id="radio" >  <input type="radio" name="sex" value="F"/>Femme</p>
                    <p><input type="text" name="ville" placeholder="Ville"   value="<%if (ville != null) {
        out.print(ville);
    }   %>"onblur="verif_ville(this)" onkeyup="verif_ville(this)" />
                    <div class="div-droit-droit">
                        <p id="gpville"> </p></div>
                    </p>
                     <font color="red" size="2px"><span style="font-weight:bold">
                         <p id="msg" align="center"></p></span></font>
                         <font color="green" size="2px"><span style="font-weight:bold">
                         <p id="msg1" align="center"></p></span></font>

                    <p class="submit"><input type="submit" value="Créer compte"> </p>
                    </form>

                    <br>
                    <div class="div-droit">
                 
                </span><p>
                            
              </div>
         
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
                $( "#msg" ).text("Pseudo existe déjà").show().fadeOut(2000);
                else
                {
                  $( "#msg1" ).text("votre compte a été crée");
               }
                
                   }
               });         
               return false;       
           });  
           </script>

                <br>
            </div>
            <div class="login-help">
                <a href="Login">Cliquer ici pour connecter</a>
            </div>
        </section>
    </body>
</html>
