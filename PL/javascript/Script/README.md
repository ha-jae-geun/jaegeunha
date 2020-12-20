# 동적 
1. Iframe
2. Document
3. [동적](https://codediver.tistory.com/m/33)

```javascript
function   addScripts ( j ) {​​​​​ 

             var   _servlet  = []; 

             var   surl  = '/transkeyServlet' ; 

             var   origin = "" ; 

             _servlet . push ( surl + '?op=getToken&' + new   Date (). getTime ()+ origin ); 

             _servlet . push ( surl + '?op=getInitTime' + tk_origin ); 

             var   scripts  =  document . createElement ( "script" ); 

             scripts . src  =  _servlet [ j ]; 

  

             var   callback  =  function  () {=

                 if  ( j  ==  1 )  

                     return ; 

                  

  

                 addScripts (++ j ); 

             

  

             var   flag  =  false ; 

             if  ( scripts . addEventListener )  

                 scripts . addEventListener ( "load" ,  callback ); 

            }

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
```

``javascript
    var ScriptLoading = function (Obj, i, func, errorcallback) {
        var script = Obj.getScript();
        var scriptLen = script.length;

        if (scriptLen == 0) {
            errorcallback();
            return;
        }

        var callback = function () {
            if (i == scriptLen - 1) {
                if (Obj.isCert()) {
                    getInfo(function (result) {
                        var data = {
                            publicKey: result.publicKey,
                            keySaferPath: Obj.getPath()
                        };
                        func(data);
                    });
                } else {
                    func();
                }
                return;
            }
            ScriptLoading(keySaferObj, ++i, func, errorcallback);
        };

        var head = document.getElementsByTagName("head")[0];
        var Script = document.createElement("script");
        Script.src = keySaferObj.getPath() + script[i];

        var flag = false;
        if (Script.addEventListener) {
            Script.addEventListener("load", callback);
        }
        else if (Script.readyState) {
            Script.onreadystatechange = function () {
                if (this.readyState == "loaded" || this.readyState == "complete") {
                    if (!flag) {
                        flag = true;
                        callback();
                    }
                }
            };
        } else {
            rObj = keySafer();
        }

        Script.onerror = function (error) {
            errorcallback(error.target.src);
        };

        head.appendChild(keyScript);
    };


```
