
function verif_password(champ)
{
    var cname =/^[A-Za-z0-9]{4,30}$/;;
	if (champ.value=="") 
	{
	  champ.style.color='red'; 
	  document.getElementById("gpss").textContent="Veuillez saisir votre mot de passe";
      return false ; 
	  }
    if (!cname.test(champ.value))
        { 
           champ.style.color='red';
		   document.getElementById("gpss").textContent="Veuillez saisir un mot de passe valide";
           return false ; 
        }
    else 
    {   document.getElementById("gpss").textContent="";
		champ.style.color='green';
		return true ; 
    }
}

function verif_age(champ)
{
    var cname = /^[0-9]{2}$/;
	if (champ.value=="") 
	{
	  champ.style.color='red'; 
	  document.getElementById("gpage").textContent="Veuillez saisir votre age";
      return false ; 
	  }
    if (!cname.test(champ.value))
        { 
           champ.style.color='red';
		   document.getElementById("gpage").textContent="Veuillez saisir un age valide";
           return false ; 
        }
    else 
    {   document.getElementById("gpage").textContent="";
		champ.style.color='green';
		return true ; 
    }
}

function verif_ville(champ)
{
    var cname = /^[A-Za-z]{3,30}$/;;
	if (champ.value=="") 
	{
	  champ.style.color='red'; 
	  document.getElementById("gpville").textContent="Veuillez saisir votre ville";
      return false ; 
	  }
    if (!cname.test(champ.value))
        { 
           champ.style.color='red';
		   document.getElementById("gpville").textContent="Veuillez saisir une ville valide";
           return false ; 
        }
    else 
    {   document.getElementById("gpville").textContent="";
		champ.style.color='green';
		return true ; 
    }
}

 function valider_modify_joueur(f) 
{  
   
   var password = verif_password(f.pswd);
    var age = verif_age(f.age);
     var ville = verif_ville(f.ville);
   
    
	
 if (password &&age&&ville )       
	 
    {return true ; }
 
 else 
 
 { //alert(" Veuillez bien remplir vos informations correctement ");
   return false ; 
 }
 }