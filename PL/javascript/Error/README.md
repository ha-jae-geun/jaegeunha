# [에러](https://www.zerocho.com/category/JavaScript/post/5c1913622e014f001e827a89)


```javascript
        convertMsg: function (error) {
            var message = vest.error.getErrorMessage(error.code, VestSign.getConfig().langIndex);
            if (message == 'undefined') {
                if (typeof(error.getReason()) === "object") {
                    message = error.getReason() + "";
                    var subIndex = message.indexOf('reason:');
                    if (subIndex != -1) {
                        message = message.substring(subIndex + 7);
                    }
                }
            }

            var refactoryMessage;

            if (!test.getConfig().useBracket && message.indexOf('(') != -1) {
                var subIndex = message.indexOf('(');
                refactoryMessage = message.substring(0, subIndex) + ".";
            }
            error.msg = (refactoryMessage !== undefined ? refactoryMessage : message) + ' [' + error.code + ']';
        },
```
