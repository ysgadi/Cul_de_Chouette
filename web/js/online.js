
 $(document).ready(function(){
                var frm=$("#form1");
                frm.submit(function (){
                  $.ajax({
                   type: frm.attr('method'),
                   url: frm.attr('action'),
                   //datatype: 'json',
                   data: frm.serialize(),
                   success:function(data)
                   {
                     var k=JSON.parse(data);  
                    alert(k.ville);
                   }
               });
               return false;
           });
           });