<%-- 
    Document   : index
    Created on : 23 nov. 2016, 01:29:37
    Author     : utilisateur
--%>


<%@page import="jeux.gestionDes.ChercherJoueur"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="jeux.gestionDes.ChercherJoueur"%>
<%@page import="Singleton.ListeJoueurPartie"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Donnes.*"%>
<% Joueur jj=(Joueur)session.getAttribute("joueur"); %>
<% ListeJoueurPartie listePartie=ListeJoueurPartie.getInstance();
Integer tab[]=new Integer[listePartie.list.size()];
List<Integer> list=new ArrayList<Integer>();
List<Joueur> listCl2=new ArrayList<Joueur>();
%>
<%! int cpt=0;
int j=0;
%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
          <script type="text/javascript" src="http://code.jquery.com/jquery-1.4.4.js"></script>
          <link type="text/css" rel="stylesheet" href="css/classement.css" />
          
        <title>Classement</title>
    </head>
    <body>
        <%
         
      
            cpt=0;
            j=0;
            for(Joueur e:listePartie.list)
           {
              tab[cpt]=e.getScore();
              cpt++;
           }
           Arrays.sort(tab,Collections.reverseOrder());  
           for(int cpt=0;cpt<tab.length;cpt++)
           {
               list.add(tab[cpt]);
           }
           
           for(int k=0;k<list.size();k++)
           {
               
               listCl2.add(ChercherJoueur.find(tab[k],listePartie.list));       
               
           }
      
        %>
        
        <div class="div_barre">
            
            <img src="images/1.jpg" class="image"/>
        </div>
        
     <section class="container">
    <div class="login">
      <h1>Classement des joueurs</h1>
      <%
       %>
          
      <table>
      <tr>
      <th>Pseudo</th>
      <th>Score</th>
      <th>Classement</th>
     </tr>
     <%  j=1;            
         cpt=0;
         while(cpt<listCl2.size())
         {
             %>
             <tr>
                 <% if(listCl2.get(cpt).equals(jj))
               {
                  
               %>
               <td><font color="green"><%=listCl2.get(cpt).getPseudo()%><font></td>
               <td><font color="green"><%=listCl2.get(cpt).getScore()%></font></td>
               <td><font color="green"><%=j%></font></td>
             </tr>
             <%
                 }
                else
               {
 
             %>
             <td> <%=listCl2.get(cpt).getPseudo()%></td>
              <td><%=listCl2.get(cpt).getScore()%></td>
              <td><%=j%></td>
             <%
                 
                 }
             
         j++;
         cpt++;
         }//fin while

     %>
      </table>
       <form id="form2" method="post" action="FinPartie">
      <input type="submit" value="Accueil" id="ac"/> 
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
                     window.location="Compte"; 
                    
                   }
               });         
               return false;       
           });  
           </script>

      </div>           
     
  </section>
    </body>
</html>
