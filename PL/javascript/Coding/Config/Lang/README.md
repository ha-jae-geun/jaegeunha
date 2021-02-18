# Lang
```javascript

function jsLang(index) {
    var type = {
        'ko': 0,
        'ko-KR': 0,
        'en-US': 1,
        'ja': 2,
        'ja-JP': 2,
        'cn': 3,
        'zh-cn': 3
    }

    var text = [
        [
        ],
        [
        ],
        [
        ]
    ];

    var brwoserLang = (function () {
        if (typeof (window.navigator.browserLanguage) === 'undefined')
            return window.navigator.language;
        return window.navigator.browserLanguage;
        // return 'ja-JP';
    })();

    var _config = VestSign.getConfig();
    if (_config.langIndex === undefined)
        return text[type[brwoserLang]][index];

    return text[_config.langIndex][index];
}
```
