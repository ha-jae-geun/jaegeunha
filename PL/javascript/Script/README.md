# [script 로딩](https://velog.io/@jakeseo_me/%ED%94%84%EB%A1%A0%ED%8A%B8%EC%97%94%EB%93%9C-%EC%9D%B8%ED%84%B0%EB%B7%B0-%EB%AC%B8%EC%A0%9C-%EB%8B%B5%ED%95%B4%EB%B3%B4%EA%B8%B0-9-script-%ED%83%9C%EA%B7%B8%EC%97%90-%EB%8C%80%ED%95%B4-%EC%96%BC%EB%A7%88%EB%82%98-%EC%95%8C%EA%B3%A0-%EC%9E%88%EB%82%98%EC%9A%94-yhik1pws)
* HTML 안에 직접 스크립트를 작성하는 방식은 대개 스크립트가 아주 간단할 때만 사용합니다. 스크립트가 길어지면 별개의 분리된 파일로 만들어 저장하는 것이 좋습니다.
* 스크립트를 별도의 파일에 작성하면 브라우저가 스크립트를 다운받아 캐시(cache)에 저장하기 때문에, 성능상의 이점이 있습니다.
* 여러 페이지에서 동일한 스크립트를 사용하는 경우, 브라우저는 페이지가 바뀔 때마다 스크립트를 새로 다운받지 않고 캐시로부터 스크립트를 가져와 사용합니다. 스크립트 파일을 한 번만 다운받으면 되죠.
* 이를 통해 트래픽이 절약되고 웹 페이지의 실제 속도가 빨라집니다.


# 속성
* type 과 language 속성은 필수가 아닙니다.
* 외부 스크립트 파일은 <script src="path/to/script.js"></script>와 같이 삽입합니다.

## src 속성
```javascript
src 속성이 있으면 태그 내부의 코드는 무시됩니다.
<script> 태그는 src 속성과 내부 코드를 동시에 가지지 못합니다.

다음 코드는 실행되지 않습니다.

<script src="file.js">
  alert(1); // src 속성이 사용되었으므로 이 코드는 무시됩니다.
</script>
따라서 <script src="…">로 외부 파일을 연결할지 아니면 <script> 태그 내에 코드를 작성할지를 선택해야 합니다.

위의 예시는 스크립트 두 개로 분리하면 정상적으로 실행됩니다.

<script src="file.js"></script>
<script>
  alert(1);
</script>
```

# [호출 스택](https://www.zerocho.com/category/JavaScript/post/597f34bbb428530018e8e6e2)

# [동적 로딩](https://ko.javascript.info/script-async-defer)


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
