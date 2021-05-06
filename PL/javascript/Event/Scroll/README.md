# 스크롤 위치에 따른 이벤트 발생
```javascript
<html>
    <head>
        <style>
            body, html {
                height: 100%;
            }

            #wrapper {
                height: 400%;
                background: none repeat scroll 0 0 #f99ccc ;
                text-align:center;
                padding-top:20px;
                font-size:22px;
            }

            #tester {
                padding-top:1200px;    
                height: 600px;
                background: none repeat scroll 0 0 #fff;
                border: 5px solid black;
            }
        </style>
    </head>
    <script type="text/javascript" src="../styles/js/jquery-1.11.0.min.js?revision=@@gitRevision"></script>
    <script>
        var isVisible = false;

        $(window).on('scroll',function() {
            if (checkVisible($('#tester'))&&!isVisible) {
                alert("Visible!!!");
                isVisible=true;
            }
        });

        function checkVisible( elm, eval ) {
            eval = eval || "object visible";
            var viewportHeight = $(window).height(), // Viewport Height
                scrolltop = $(window).scrollTop(), // Scroll Top
                y = $(elm).offset().top,
                elementHeight = $(elm).height();   
            
            if (eval == "object visible") return ((y < (viewportHeight + scrolltop)) && (y > (scrolltop - elementHeight)));
            if (eval == "above") return ((y < (viewportHeight + scrolltop)));
        }

    </script>
    <body>
        <div id="wrapper">
            scroll down to see the div
        </div>
        <div id="tester"></div>
    </body>
</html>
```
