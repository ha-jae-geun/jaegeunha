# ALt 동적으로 넣기
```javascript
functionsetAlt(num, str) {
$("[tabindex=" + num + "]").attr("alt", str);
}

<script>webAccess.setAlt(7, passwordType2Lang(2))</script>


```
