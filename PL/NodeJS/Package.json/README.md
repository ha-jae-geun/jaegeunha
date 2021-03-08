# [Package.json](https://programmingsummaries.tistory.com/385)
* [--save](https://pewww.tistory.com/11)
```json
{
  "name": "fingerprint-storage",
  "version": "2.0.0",
  "description": "",
  "main": "index.js",
  "scripts": {
    "build": "webpack",
    "watch": "webpack --watch --progress",
    "watch-debug": "webpack -d --config webpack.config.debug.js --watch --progress",
    "start-debug": "start npm run watch-debug && webpack-dev-server -d --config webpack.config.debug.js",
    "test": "karma start karma.conf.js --display-error-details --single-run",
    "dev": "webpack --config webpack.config.debug.js"
  },
  "repository": {
    "type": "git",
    "url": "http://172.16.10.14:9000/FPStorage/FPStorage"
  },
  "keywords": [
    "javascript"
  ],
  "babel": {
    "presets": [
      "es2015"
    ],
    "plugins": [
      "transform-regenerator",
      "es6-promise"
    ]
  },
  "author": "",
  "license": "ISC",
  "devDependencies": {
    "babel-core": "^6.25.0",
    "babel-loader": "^7.1.1",
    "babel-plugin-es6-promise": "^1.1.1",
    "babel-plugin-transform-regenerator": "^6.26.0",
    "babel-polyfill": "^6.26.0",
    "babel-preset-es2015": "^6.24.1",
    "babel-regenerator-runtime": "^6.5.0",
    "clean-webpack-plugin": "^0.1.19",
    "copy-webpack-plugin": "^4.5.2",
    "es6-promise": "^4.1.1",
    "jasmine-core": "^3.1.0",
    "jscrambler-webpack-plugin": "^5.5.25",
    "karma": "^2.0.4",
    "karma-chrome-launcher": "^2.2.0",
    "karma-cli": "^1.0.1",
    "karma-jasmine": "^1.1.2",
    "karma-phantomjs-launcher": "^1.0.4",
    "karma-webpack": "^3.0.0",
    "phantomjs-prebuilt": "^2.1.16",
    "webpack": "^3.3.0",
    "webpack-dev-server": "^2.5.1",
    "webpack-stream": "^4.0.0",
    "webpack-zip-files-plugin": "^1.0.0"
  }
}

```

# [Package-lock.json](https://hyunjun19.github.io/2018/03/23/package-lock-why-need/)
* package-lock.json 파일은 의존성 트리에 대한 정보를 모두 가지고 있습니다.
* package-lock.json 파일은 저장소에 꼭 같이 커밋해야 합니다.
* package-lock.json 파일은 node_modules 없이 배포하는 경우 반드시 필요합니다.


# scripts
```javascript
  "scripts": {
    "build": "webpack",
    "watch": "webpack --watch --progress",
    "watch-debug": "webpack -d --config webpack.config.debug.js --watch --progress",
    "start-debug": "start npm run watch-debug && webpack-dev-server -d --config webpack.config.debug.js",
    "test": "karma start karma.conf.js --display-error-details --single-run",
    "dev": "webpack --config webpack.config.debug.js"
  },
```
