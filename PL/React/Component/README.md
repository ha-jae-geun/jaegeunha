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
