# [Dialog 옵션](http://blog.naver.com/PostView.nhn?blogId=javaking75&logNo=140197306077)

# modal 예제
```javascript
                        $(modalId).dialog({
                            
                            autoOpen: true,
                            scroll: "no",
                            modal: true,
                            resizable: false,
                            open: function (type, data) {

                                $(".ui-dialog-titlebar", $(this).parent()).remove();
                                $(modalId).dialog({ width: "auto", height: "auto" });
                                $(modalId).css('overflow', 'hidden');

                                // 닫기 클릭 이벤트
                                $(".close-reveal-modal").on("click", function () {
                                    $("#keysafer_loading").remove();
                                    $(modalId).dialog("close");
                                    $(modalId).css("display", "none");
                                });

                                // 취소 클릭 이벤트
                                $("#modalCloseBtn").on("click", function () {
                                    $("#keysafer_loading").remove();
                                    $(modalId).dialog("close");
                                    $(modalId).css("display", "none");
                                });

                                $("#modalConfirmBtn").on("click", function() {
                                    $("#keysafer_loading").remove();
                                    _param.callback({
                                        SecureCertificateStorageItem: _certificateList[_selected],
                                        action: 'REMOVECERTIFICATE',
                                        option: _param.option,
                                        msg: '성공'
                                    });
                                })

                                // Modal 위치, 크기 조정
                                $(modalId).css('visibility', 'visible');
                                $(this).parent().css('top', -(window.innerHeight / 1.2));
                                document.getElementById("myModal").style.minHeight = '0px';
                                $(modalId).width((window.innerWidth / 1.8) + 'px');

                                // Modal 떠있는 동안 터치 불가
                                addLoadingBar();
                            }
                        });
```

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
