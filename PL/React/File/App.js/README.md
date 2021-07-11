# App.js 처음
```javascript
import logo from './logo.svg';
import './App.css';

function App() {
  //함수 영역
  return (
    //JSX 영역
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          test
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          안녕하세요
        </a>
      </header>
    </div>
  );
}

export default App;

```


# App.js 테스트
```javascript
import React from 'react'

const App = () => {

  return(
    <div>
      테스트
    </div>
  )
}

export default App
```
