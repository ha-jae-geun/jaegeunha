
# [이벤트 등록, 해제](https://www.zerocho.com/category/JavaScript/post/57432d2aa48729787807c3fc)

# [Event Delegation](https://joshua1988.github.io/web-development/javascript/event-propagation-delegation/)

# keyup
- 왜 keypress 가 아닌 keyup 이벤트를 사용하는 것일까요? 영문을 입력하면 keypress 이벤트가 사용하기 좋지만 한글은 keypress 이벤트를 지원하지 않습니다. 따라서 keypress 이벤트는 배제해야 합니다. 그리고 keydown 이벤트가 아니가 keyup 이벤트를 사용해야 합니다. 이는 키보드 이벤트가 어떠한 순서로 발생하는지를 안다면 이해하기 수월할 것입니다.

- 키보드 이벤트는 다음과 같은 순서로 진행됩니다.
1. 사용자가 키보드를 누른다.
2. keydown 이벤트가 발생한다.
3. 글자가 입력된다.
4. keypress 이벤트가 발생한다.
5. 사용자가 키보드에서 손을 뗀다.
6. keyup 이벤트가 발생한다.
- 따라서 keydown 이벤트가 발생한 순간에는 글자가 입력돼 있지 않습니다. 여기서는 입력한 글자 수를 표시해야 하므로 keyup 이벤트를 사용했습니다.

# keydown
* key.preventDefault(); // ie에서 필요

## addEventListener
* 이벤트를 붙이는 다른 방법으로 addEventListener가 있습니다. 저는 on으로 붙이는 것보다 이 방식을 더 추천합니다. 
* 여러 이벤트를 등록할 수 있고, 특정 이벤트를 제거(removeEventListener)할 수도 있거든요.


