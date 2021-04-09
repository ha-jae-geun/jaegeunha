# [에러 처리](https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/Error)

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


## errorLang
```javascript

(function (window, vest, undefined) {
    'use strict';

    var type = {
        'ko': 0,
        'ko-kr': 0,
        'en-us': 1,
        'ja': 2,
        'ja-jp': 2,
        'cn': 3,
        'zh-cn': 3
    };

    var language = [
        {
            SERVICE_ERROR_CHANGE_PIN_INVALID_JSON_DATA: "入力した値は正しくありません。",
        },
        {
            SERVICE_ERROR_CHANGE_PIN_INVALID_JSON_DATA: "输入无效"
        }
    ];

    function getBrwoserLang() {
        if (typeof (window.navigator.browserLanguage) === 'undefined')
            return window.navigator.language.toLowerCase();
        return window.navigator.browserLanguage.toLowerCase();
    };

    var getErrorMessage = function (code, mode) {
        // 공통저장소 7자리 넘어옴. 앞 4자리 + 000 일곱자리 다시 생성.
        if ((typeof code.legnth !== 'undefined' && code.length == 7) || code >= 1000000) {
            code = code + '';
            code = code.substr(0, 4) + '000';
            code = Number(code);
        }
        
        var _mode = (typeof mode === 'undefined' || '' + mode == '' || mode > language.length) ? type[getBrwoserLang()] : mode;
        var _message = language[_mode];
        for (var i in _message) {
            if (vest.error.errorCode[i] == code) {
                return _message[i];
            }
        }
        return 'undefined';
    };

    if (vest) {
        vest.error.getErrorMessage = getErrorMessage;
    }
})(window, vest);
```

## error_code
```javascript

(function (window, vest, undefined) {
    'use strict';


    var errorCode = {
        SERVICE_ERROR_CHANGE_PIN_INVALID_JSON_DATA: 3101000,

    };

    if (vest) {
        vest.error.errorCode = vest.error.errorCode || (vest.error.errorCode = {});
        vest.extend(vest.error, {
            'errorCode': errorCode
        });
    }
})(window, vest);
```

## 사용법
```javascript
util.refactoryMsg.convertMsg(error)
```
