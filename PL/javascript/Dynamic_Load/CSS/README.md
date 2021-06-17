# CSS 동적 로딩
```javascript
        function addCss () {
            //var len = document.getElementsByTagName("link").length;
            var css = document.createElement("link");
            css.setAttribute("rel", "stylesheet");
            css.setAttribute("type", "text/css");
            css.setAttribute("href", _path + "css/vikie.css");
            document.getElementsByTagName("head")[0].appendChild(css);
        };
```
