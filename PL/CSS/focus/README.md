# focus border
```html
#agreeCheckBox2>label:focus {border:1px solid #000;border-radius: 10px; width: 160px; height: 22px}
```


# focus in/out
```javascript
            $('#' + leftTabName).focusin(function() {
                $(this).css({
                    'border' : '2px solid #000',
                    'border-radius' : '10px'
                });
            });

            
            //leftTab focus out 됐을 경우
            $('#' + leftTabName).focusout(function() {
                $(this).css({
                    'border' : '0px',
                    'border-radius' : '0px'
                });
            });
```
