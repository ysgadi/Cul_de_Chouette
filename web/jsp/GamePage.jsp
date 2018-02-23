<%@page import="Singleton.ListeJoueurPartie"%>
<%@page import="Singleton.ChouetteVelute"%>
<%@page import="Singleton.Checked"%>
<%@page import="Singleton.SuiteInteger"%>
<%@page import="Singleton.SingEntierServ"%>
<%@page import="Singleton.tourGame"%>
<%@page import="servlet.SingInvite"%>
<%@page import="servlet.ListeInvite"%>
<%@page import="java.util.List"%>
<%@page import="servlet.sessionList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Donnes.*"%>
<%@page import="DAOJPA.*"%>
<%  sessionList list=sessionList.getInstance();%>
<% Joueur j=(Joueur)session.getAttribute("joueur"); %>
<%SingInvite jrt=SingInvite.getInstance(j);%>
<% 
   tourGame tourJoueur=tourGame.getInstance();
   Checked ini=Checked.getInstance();
   SingEntierServ indice=SingEntierServ.getInstance();
   SuiteInteger nb=SuiteInteger.getInstance();
   ListeJoueurPartie listePartie=ListeJoueurPartie.getInstance();
    ChouetteVelute Chv=ChouetteVelute.getInstance();
    int k; 
%>
<%! int a;%>





<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <script type="text/javascript" src="http://code.jquery.com/jquery-1.4.4.js"></script>
        <title>Game</title>
          <link type="text/css" rel="stylesheet" href="css/game.css" /> 
          <%-- <META http-equiv="REFRESH" content="2">--%>
          
        
   
        <title>Cul de chouette</title>
    </head>
    <body>
      <div id="ca">
        <div class="div_barre">
            
            <img src="images/1.jpg" class="image"/>
            
        </div>
        
     <section class="container" id="container">
    <div class="login">
        <h1>Bienvenue au jeu cul de chouette <font color="green"><%out.print(" "+j.getPseudo());%></font></h1>
      <%--Afficher les information --%>
      
       <table id="table">
          
      </table>
      <br>
      
      <font color="green" size="3.5px"><span style="font-weight:bold"> <p hidden id="tour" align="center">Veuillez lancer les dés</p></span></font>
      <font color="green" size="3.5px"><span style="font-weight:bold"> <p hidden id="ntour" align="center"></p></span></font>
       <font color="red" size="3.5px"><span style="font-weight:bold"> <p hidden id="last1" align="center">Tous les joueurs ont quitté la partie </p></span></font>
      <p id="imgg"></p>
       <font size="3px" color="green"><span style="font-weight:bold"><p id="pt" hidden>La partie est terminée</p></font>
        <font size="2.5px"><span style="font-weight:bold"> <p hidden id="classement" align="center">  <a href="classement">Cliquer ici pour voir votre classement</a></p></span></font>
          <font size="2.5px"><span style="font-weight:bold"> <p hidden id="last2" align="center">  <a href="Compte">Cliquer ici pour revenir à votre compte</a></p></span></font>
        
        <input hidden type="submit" value="LancerDes" id="ld"/>
       <font color="green" size="2px"><span style="font-weight:bold">
       <p id="msg1" align="center"></p>
        <font color="green" size="2px"><span style="font-weight:bold">
       <p id="msg2" align="center"></p>
       <input type="submit" value="GrelotteCapicote" id="gr"/>
        <input type="submit" value="PasMouLeCaillou" id="pm"/>
        <font color="red" size="2px"><span style="font-weight:bold">
        <input type="submit" Value="Quitter" id="qt"/>
         <p id="msg"></p>
      <div class="div_barre">
            
            <img hidden id="img"src="images/winner.jpg" class="image"/>
        </div>
  <%-------------------------------------------------------------------------------------%>
    <script>
         $(document).ready(
             function() {
              var x=0;
                x=setInterval(function() {
                
                 $.get('servletGameDes', {
                        reqo: "tourJoueur"
                    }, function (responseText) {
                    if(responseText==="tour1")
                    {
                      $("#ld").show();
                      $("#tour").show();
                      $("#ntour").hide();
                      
                    }//fin if
                    else
                    {
                       $("#ntour").text(responseText).show();
                       $("#tour").hide();
                       $("#ld").hide();
                      
                      // alert(responseText);
                    }//fin else
                    }, false);
                    //fin get
  /******************************************************************************/
                     $.get('servletGameDes', {
                     reqo: "AfficheDes"
                    }, function (responseText) {
                     var json = JSON.parse(responseText);
                      document.getElementById("table").innerHTML =json.tab;
                    }, false);        
   /****************************************************/
                  
        
        
               /*****************tester le nombre de joueur qui jouent******************************/
                    
        
                     $.get('servletGameDes', {
                     reqo: "NbrJoueur"
                     }, function (responseText) {
                        var a=parseInt(responseText);
                      // var json = JSON.parse(responseText);
                     if(a===0)
                     {
                     
                       $("#gr").hide();
                       $("#pm").hide();
                       $("#qt").hide();
                       $("#ld").hide();
                        $("#tour").hide();
                        $("#ntour").hide();  
                        $("#img").hide();
                        $("#table").hide();
                        $("#change").hide();
                         $("#scr").hide();
                        $("#last1").show();
                        $("#last2").show();
                        clearInterval(x); 
                    }
                   
                    }, false);
                    /*******************************************************/
                     $.get('servletGameDes', {
                     reqo: "Gagnant"
                     }, function (responseText) {
                       var a=parseInt(responseText);
                       if(a!==1)
                       {
                            var json = JSON.parse(responseText);
                            document.getElementById("imgg").innerHTML =json.data;
                          
                            $("#gr").hide();
                            $("#pm").hide();
                            $("#qt").hide();
                            $("#ld").hide();
                            $("#tour").hide();
                            $("#ntour").hide(); 
                             $("#change").hide();
                             $("#scr").hide();
                             $("#pt").show();
                             $("#classement").show();
                            clearInterval(x); 
                       }
                      //alert("mazal");
                    }, false);
                    /****************************************************/
                  //fin setintervale
                },500);
                //1er get pour fair tourner le bouton Lancer
                  $( "#ld" ).click(function( event ) {
                        //alert("lol");
                     $.get('servletGameDes', {
                        reqo: "LancerDes"
                    }, function (responseText) {
                     //alert(responseText);
                     $("#ld").show();    
                    }, false);
                    //fin get
                    });//fin submit
                    
                    $( "#gr" ).click(function( event ) {
                        //alert("lol");
                     $.get('servletGameDes', {
                        reqo: "GrelotteCapicote"
                    }, function (responseText) {
                     //alert(responseText); 
                     $( "#msg1" ).text("Grelotte Capicote").show().fadeOut(2000); 
                    }, false);
                    //fin get
                    });//fin submit
                     $( "#pm" ).click(function( event ) {
                        //alert("lol");
                        
                     $.get('servletGameDes', {
                        reqo: "PasMouLeCaillou"
                    }, function (responseText) {
                     //alert(responseText); 
                     $( "#msg2" ).text("PasMou Le Caillou").show().fadeOut(2000); 
                    }, false);
                    //fin get
                    });//fin submit
                    /*Quitter la partie*/
                   $( "#qt" ).click(function( event ) {
                        
                     $.get('servletGameDes', {
                        reqo: "Quitter"
                    }, function (responseText) {
                      $("#gr").hide();
                      $("#pm").hide();
                      $("#qt").hide();
                      $("#ld").hide();
                      $("#tour").hide();
                      $("#ntour").hide();
                     window.location="http://localhost:8084/WebApplicationCulDeChouette/Compte";
             
                    }, false);
                    //fin get
                    });//fin submit
                   
                   /************************************************/
                  
                    
                   
           });
            </script>
            <%
                if(j.getTour()==1)
                {
            %>
              <form id="form2" method="post" action="servletGameDes">
              
               <font color="red" size="2px"><span style="font-weight:bold">
               <p><input placeholder="Modifier Limite Score"type="text" id="scr" name="scr"/></p>
             <input type="submit" value="ChangerScore" id="change"/>
              <p id="msg" align="center"></p>
              </form>
             <script>
                  var frm=$("#form2");
                frm.submit(function (){
                  if($("#scr").val()>343 ||$("#scr").val()<50 )
                     $( "#msg" ).text("Le score limite doit être entre 50 et 343").show().fadeOut(3000);
                 else
                 {
                  $.ajax({
                   type: frm.attr('method'),
                   url: frm.attr('action'),
                   //datatype: 'json',
                   data: frm.serialize(),
                   success:function(data)
                   {  
        
                   }
                    }); 
                }
               return false;       
           });  
               
             </script>
            <%
                }
             %>
 
    </div>

  </section>

      </div>
      </body>
</html>

