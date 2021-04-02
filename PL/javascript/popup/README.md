# [크롬, 팝업, alert](https://stackoverflow.com/questions/51618100/in-chrome-alert-doesnt-show-html-until-pop-up-is-executed)

# 팝업 종료 form 전송
```java
        $(window).unbind("beforeunload").bind("beforeunload", function() {
            _parent.off();
        });
        

        // _this.off = function() {
        //     var hiddenIframe = document.createElement("iframe");
        //     hiddenIframe.name = "hiddenResult";
        //     hiddenIframe.width = "0px";
        //     hiddenIframe.height = "0px";
        //     hiddenIframe.style.border = "none";
        //     document.body.appendChild(hiddenIframe);

        //     var form = document.createElement("form");
        //     form.setAttribute("method", "post");
        //     form.setAttribute("action", "https://127.0.0.1:144/Manager");
        //     form.setAttribute("enctype", "text/plain");
        //     form.setAttribute("target", "hiddenResult");

        //     var hiddenField = document.createElement("input");
        //     hiddenField.setAttribute("type", "hidden");
        //     hiddenField.setAttribute("name", '{"test":"');
        //     hiddenField.setAttribute("value", '",""}');
        //     form.appendChild(hiddenField);

        //     form.submit();
        // };
```
