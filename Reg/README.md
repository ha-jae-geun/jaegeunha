# 브라우저 버전 가져오기
```javascript
    function getBrowserVersion() {
        var word;
        var agent = navigator.userAgent.toLowerCase();
        var browser = '';

        // IE old version ( IE 10 or Lower ) 
        if (navigator.appName == "Microsoft Internet Explorer") word = "msie ";
        // IE 11 
        else if (agent.search("trident") > -1) word = "trident/.*rv:";
        // Microsoft Edge  
        else if (agent.search("edge/") > -1) word = "edge/";
        else if (agent.indexOf('safari') > -1) { // Chrome or Safari
            if (agent.indexOf('opr') > -1) { // Opera
                browser = 'opera';
            } else if (agent.indexOf('chrome') > -1) { // Chrome
                browser = 'chrome';
            } else { // Safari
                browser = 'safari';
            }
            // safari일 경우 임의로 3리턴
            //if (browser == 'safari') return 3;
            //else 
            return -1;
        }
        // 그외
        else return -1;

        var reg = new RegExp(word + "([0-9]{1,})(\\.{0,}[0-9]{0,1})");
        if (reg.exec(agent) != null) return parseFloat(RegExp.$1 + RegExp.$2);
        return -1;
    }
```
