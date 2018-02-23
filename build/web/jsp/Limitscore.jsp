<%-- 
    Document   : Limitscore
    Created on : 13 déc. 2016, 00:46:22
    Author     : utilisateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Donnes.*"%>
<%@page import="DAOJPA.*"%>
<% Joueur joueur_invit=(Joueur)session.getAttribute("joueur_invit"); %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%--
         <META http-equiv="REFRESH" content="10">
        --%>
          <script type="text/javascript" src="http://code.jquery.com/jquery-1.4.4.js"></script>
          <link type="text/css" rel="stylesheet" href="css/lcl.css" />
          
         
        <title>Score Limite</title>
    </head>
    <body>
       
        <div class="div_barre">
            
            <img src="images/1.jpg" class="image"/>
        </div>
        
     <section class="container">
    <div class="login">
      <h1>Score limite</h1>
      
      <form  id="form2" method="post" action="scoreLimit" >
          <div style="margin-left:65px"> 
           
              <p><input placeholder="Score Limite"type="text" id="btnn"name="score" /></p>
          </div>   
      
          <br>
             <font color="green" size="2px"><span style="font-weight:bold">
                <p id="msg1" align="center"></p>
               <font color="red" size="2px"><span style="font-weight:bold">
                <p id="msg" align="center"></p>
          <p hidden id="hid" align="center"> <a href="game">Cliquer ici pour commencer la partie</a></p>   
         <p class="submit"><input type="submit" name="score" id="score" value="Valider"></p>
              
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
                   
                      var a= $("#btnn").val();
                 
                 if(a==0 || a<50)
                   $( "#msg" ).text("Le socre limit doit être entre 50 et 350").show().fadeOut(2000); 
                  else
                  {
                      if(a>350)
                       $( "#msg" ).text("Le score limit doit être inférieur à 350").show().fadeOut(2000); 
                      else
                      {
                          $( "#msg1" ).text("Le socre limite est valide").show();
                          $("#hid").show();
                          $("#score").hide();
                      }
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

