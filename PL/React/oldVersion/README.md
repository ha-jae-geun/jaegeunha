# 예제
```html
<!DOCTYPE html>
<html>
<head></head>
<meta charset="UTF-8" />
<title> test </title>
<script src="https://unpkg.com/react@16/umd/react.development.js"></script>
<script src="https://unpkg.com/react-dom@16/umd/react-dom.development.js"></script>
<script src="https://unpkg.com/babel-standalone@6.26.0/babel.js"></script>
</head>
<body>
    <!-- 실제 dom-->
    <div id="root" >화면에보일부분</div>
    <script type="text/babel">
    // 값처리
    // 가상돔
    //React.createElement('요소', 속성, '값')
    const el = React.createElement('h1', {}, '제목');
    const dom = document.querySelector('#root');

    // 실제 돔에 가상돔을 한번만 끼워넣기(마운트)
    // render 화면에 그려줌
    ReactDOM.render(el, dom);

    </script>
</body>
</html>
```
