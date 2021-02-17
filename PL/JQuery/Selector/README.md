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


# find
```javascript
        $(".certificationList>li>a").each(function(){
            var a = $(this);
            var img = a.find("img");
            var src_off = img.attr("src");
            var src_on = src_off.replace("_off", "_on");
            a.hover(function(){
                img.attr("src", src_on);
                $(this).addClass("listHover");

            },function(){
                if(!($(this).hasClass("listClick"))){
                    img.attr("src", src_off);
                }
                $(this).removeClass("listHover");
            });

            a.click(function(){
                $(".certificationList>li>a").each(function(){
                    var b = $(this);
                    var img2 = b.find("img");
                    var src_off2 = img2.attr("src");
                    var src_replace = src_off2.replace("_on", "_off");

                    img2.attr("src", src_replace);
                    $(this).removeClass("listClick");
                });
                var selectedImage = $(this).find("img");
                var onImage = selectedImage.attr("src").replace("_off", "_on");
                selectedImage.attr("src", onImage);
                $(this).addClass("listClick");

            });
        });
```
