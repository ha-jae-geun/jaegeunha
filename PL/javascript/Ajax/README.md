# [XMLHttpRequest](https://www.zerocho.com/category/HTML&DOM/post/594bc4e9991b0e0018fff5ed)
```javascript
    function AJAX(url, jsonstring, resultCallback) {
        var xhr = new XMLHttpRequest();
        xhr.open('post', url, true);
        xhr.send(jsonstring);
        xhr.onreadystatechange = function() {
            if (xhr.readyState == 4) {
                if (xhr.status != 200) {

                    /* error */
                    //resultCallback(new error(xhr.status, 'commnication error : abnormal http code:' + xhr.status + ', readyState:' + xhr.readyState));
                    resultCallback(new error(xhr.status, '통신에 실패했습니다.(http code:' + xhr.status + ', readyState:' + xhr.readyState) + ')');
                    return;
                }
                resultCallback(xhr.responseText);
                return;
            }
        }
    }
```
