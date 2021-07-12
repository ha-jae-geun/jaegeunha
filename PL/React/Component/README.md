# 컴포넌트
* 컴포넌트는 UI 를 구성하는 조각(piece)에 해당되며, 독립적으로 분리되어 재사용을 됨을 목적으로 사용됩니다.
* React 앱에서 컴포넌트는 개별적인 JavaScript 파일로 분리되어 관리합니다.
* (예: Header, HeaderTitle, Wrapper, List, ListItem 컴포넌트)
* 함수형 컴포넌트와 클래스형 컴포넌트 두가지가 있음
* 예전엔 클래스형 요즘은 함수형으로 작업하지만 그래도 예전부터 리액트를 한사람들은 클래스형으로 작업을 하기도함


## 함수형 컴포넌트
* React 컴포넌트는 개념상 JavaScript 함수와 유사합니다. 컴포넌트 외부로부터 속성(props)을 전달 받아 어떻게 UI 를구성해야 할지 설정하여 React 요소(JSX 를 Babel 이 변환 처리)로 반환합니다. 이러한 문법 구문을 사용하는
* 컴포넌트를 React 는 '함수형(functional)'으로 분류합니다.


## 함수형? 클래스형? 각 컴포넌트는 차이가 있나요?
* React 세계관에서 함수형과 클래스 컴포넌트는 유사합니다. 다만, 클래스 컴포넌트의 경우 함수형 컴포넌트에 없는 기능을 추가적으로 사용할 수 있다는 점이 다릅니다.

# component import
* // import 참조변수 컴포먼트명과 동일 권장 from '경로'
* 한 줄 이상일 경우 반드시 div로 묶어준다.

```javascript
import React from 'react'
import Test1 from './components/Test1'

const App = () => {

  return(
    <div>
      테스트
      <Test1 />
    </div>
  )
}

export default App
```
