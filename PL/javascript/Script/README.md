# 동적 
1. Iframe
2. Document
3. [동적](https://codediver.tistory.com/m/33)

'''Javascript
function   addScripts ( j ) {​​​​​ 

             var   _servlet  = []; 

             var   transkey_surl  = '/transkeyServlet' ; 

             var   tk_origin = "" ; 

             _servlet . push ( transkey_surl + '?op=getToken&' + new   Date (). getTime ()+ tk_origin ); 

             _servlet . push ( transkey_surl + '?op=getInitTime' + tk_origin ); 

             var   scripts  =  document . createElement ( "script" ); 

             scripts . src  =  _servlet [ j ]; 

  

             var   callback  =  function  () {​​​​​ 

                 if  ( j  ==  1 ) {​​​​​ 

                     return ; 

                }​​​​​  

  

                 addScripts (++ j ); 

            }​​​​​; 

  

             var   flag  =  false ; 

             if  ( scripts . addEventListener ) {​​​​​ 

                 scripts . addEventListener ( "load" ,  callback ); 

            }​​​​​ 

             else   if  ( scripts . readyState ) {​​​​​ 

                 scripts . onreadystatechange  =  function  () {​​​​​ 

                     if  ( this . readyState  ==  "loaded"  ||  this . readyState  ==  "complete" ) {​​​​​ 

                         if  (! flag ) {​​​​​ 

                             flag  =  true ; 

                             callback (); 

                        }​​​​​ 

                    }​​​​​ 

                }​​​​​; 

            }​​​​​ 

  

             document . getElementsByTagName ( "head" )[ 0 ]. appendChild ( scripts ); 

        }​​​​​ 
'''
