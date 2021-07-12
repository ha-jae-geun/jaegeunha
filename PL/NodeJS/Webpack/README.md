# [poeimaweb 웹팩](https://poiemaweb.com/es6-babel-webpack-1)

# [Webpack](https://www.zerocho.com/category/Webpack/post/58aa916d745ca90018e5301d)
* entry -> loader -> plugins -> output의 흐름

# [번들러](https://webclub.tistory.com/635)


## Plugins
* [CleanWebpackPlugin](https://studyingych.tistory.com/50)


## [loader와 plugins의 차이](https://bogyum-uncle.tistory.com/112)
* loader는 파일을 해석하고 변환하는 과정에 관여하여 모듈을 처리 
* plugin은 해당 결과물의 형태를 바꾸는 역할을 하므로 번들링된 파일을 처리한다는 점


# package.json 설정
```javascript
webpack을 사용하기 위한 설정 - pakage.json

"script": {
  "build": "webpack"
}

// pakage.json 파일
로컬 설치일 시에만 위 처럼 pakage.json에 추가를 해 주어야 한다.

글로벌 설치를 하지 않으면, npm이 webpack 경로를 찾지 못하여 webpack 명령어를 사용할 수 없다. 
그러나 위 처럼 pakage.json에 추가를 해 주면, npm이 프로젝트 내 modules 디렉토리의 webpack을 알아서 찾아 실행시켜준다.
```
