# each
```javascript
            $('.pastidAgreeList>li>a').each(function(){
                var agreeCheckBtn = $(this);
                var agreeCheckBtnIndex =  $(this).parent().index() + 1;
                var agreeCheckDialog = "#agreeCheckDialog" + agreeCheckBtnIndex;
                var agreeOkBtn = "#agreeCheckOkBtn" + agreeCheckBtnIndex;
                var agreementSample = "./agreementSample" + agreeCheckBtnIndex + '.html';

                if(agreeCheckBtnIndex == 5){
                    return;
                }

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
                                of: $('#draggableWrap')
                            });
                            $(this).parent().css('top', (parseInt($(this).parent().css('top'),10)) +'px');
                            $(this).parent().addClass('appear');
                        },
                        resizeStop: function () {
                            $(this).dialog({ height: "auto" });
                        }
                    });
                });
            });
```
