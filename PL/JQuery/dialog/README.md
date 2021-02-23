# [dialog](https://roqkffhwk.tistory.com/56)
```javascript
agreeCheckBtn.click(function() {
    $(agreeCheckDialog).dialog({
        autoOpen: true,
        scroll: "no",
        modal: true,
        resizable: false,
        open: function (type, data) {
            $(this).load(agreementSample, function() {
            
                $(agreeOkBtn).unbind("click");
                $(agreeOkBtn).click(function () {
                    $(agreeCheckDialog).dialog("close");
                });

                $(agreeOkBtn).keydown(function (key) {
                    if(key.keyCode == 13){
                        $(agreeCheckDialog).dialog("close");
                        key.preventDefault();
                    }
                });
                $(agreeOkBtn).focus();
            });
            
            $(".ui-dialog-titlebar", $(this).parent()).remove();
            $(agreeCheckDialog).dialog({ width: "auto", height: "auto" });
            $(agreeCheckDialog).css('overflow', 'hidden');
            $(this).parent().css({
                    'width': '468px', 
                    'height': '691px',
                    'border' : '1px solid #555',
                    'background-color' : '#fff',
                    'z-index' : '999999',
                    'border-radius' : '10px' 
            });
            $(this).dialog("widget").position({
                my: 'center',
                at: 'center',
                of: $('#simpleSign')
            });
            $(this).parent().css('top', (parseInt($(this).parent().css('top'), 10)) +'px');
            $(this).parent().addClass('appear');
        },
        resizeStop: function () {
            $(this).dialog({ height: "auto" });
        }
    });
});
```

# [callback 값](https://sararing.tistory.com/245)
