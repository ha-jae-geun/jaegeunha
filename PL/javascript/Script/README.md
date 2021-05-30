# [script 로딩](https://velog.io/@jakeseo_me/%ED%94%84%EB%A1%A0%ED%8A%B8%EC%97%94%EB%93%9C-%EC%9D%B8%ED%84%B0%EB%B7%B0-%EB%AC%B8%EC%A0%9C-%EB%8B%B5%ED%95%B4%EB%B3%B4%EA%B8%B0-9-script-%ED%83%9C%EA%B7%B8%EC%97%90-%EB%8C%80%ED%95%B4-%EC%96%BC%EB%A7%88%EB%82%98-%EC%95%8C%EA%B3%A0-%EC%9E%88%EB%82%98%EC%9A%94-yhik1pws)

# 동적 
1. Iframe
2. Document
3. [동적](https://codediver.tistory.com/m/33)


# [async_defer](https://webclub.tistory.com/630)
# [asyncc defer 엘리](https://www.youtube.com/watch?v=tJieVCgGzhs&list=PLv2d7VI9OotTVOL4QmPfvJWPJvkmv6h-2&index=20)

# async
* fetching이 parsing과 병렬로 수행
* fetching 이후 바로 parsing이 block되면서 자바스크립트 실행
* 자바 스크립트 execute가 랜덤

# defer
* fetching이 parsing과 병렬로 수행
* parsing이 끝나고 execute 실행
  * 자바 스크립트 execute 순서가 일정


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

```javascript
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
