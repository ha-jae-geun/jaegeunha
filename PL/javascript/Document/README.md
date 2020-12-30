# onmousemove
```java

Despite what the MSDN docs say, onmousemove doesn't work when applied to the window object. 
It should work in all browsers if you apply it to the document object instead:

document.onmousemove = function(e) {
    e = e || window.event;
    var copyLabel = document.getElementById("<%= lblCopyEnabled.ClientID %>");
    if (e.shiftKey) {
        copyLabel.style.display = "inline";
        ob_copyOnNodeDrop = true;
    }
    else {
        copyLabel.style.display = "none";
        ob_copyOnNodeDrop = false;
    }
}
```
