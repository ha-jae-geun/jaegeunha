# [개발용: 로컬빌드]
1. npm install
2-1, 2-2 중 하나 사용. ★차이점: 2-1로 빌드시 .map파일이 같이 생성되어 디버깅시 용이함(Chrome)
2-1. webpack --config webpack.config.dev.js (혹은 npm run dev)
  * npm run dev로 빌드할 경우,  webpack-dev-server를 띄워 코드 수정시 자동빌드됨
2-2. webpack --config webpack.config.js

```javascript
var path = require('path');
var webpack = require('webpack');
var copy = require('copy-webpack-plugin');
const fs = require('fs');
const build_number = process.env.BUILD_NUMBER ? process.env.BUILD_NUMBER : 'local';
const pack = JSON.parse(fs.readFileSync('./package.json'));
const ZipFilesPlugin = require('webpack-zip-files-plugin');
const CleanWebpackPlugin = require('clean-webpack-plugin');
const JsDocPlugin = require('jsdoc-webpack-plugin');

module.exports = {
    entry: ['babel-regenerator-runtime', './src/index.js'],
    output: {
        filename: 'fpStorage.js',
        path: path.resolve(__dirname, 'dist', 'js')
    },
    externals: {
        ytcrypto: 'ytcrypto'
    },
    module: {
        rules: [{
            test: /\.js$/,
            exclude: /node_modules/,
            use: [{
                loader: 'babel-loader'
            }]
        }] 
    },
    devtool: 'source-map',
    plugins: [
        new webpack.DefinePlugin({
            VERSION: "'" + pack.version + "'"
        }),
		new webpack.LoaderOptionsPlugin({
            debug: true
        }),
        new JsDocPlugin({
            conf: 'jsdoc.config.json',
            cwd: './',
            preserveTmpFile: false
        }),
        new copy([
            {from: './src/index.html', to: '../index.html'},
            {from: './src/jsrose_crypto.min.js', to: '../js'}
        ], {}),
        new ZipFilesPlugin({
            entries: [
                { src: path.join(__dirname, 'dist'), dist: './' }
            ],
            output: './FPStorage_debug-' + pack.version + '_#' + build_number,
            format: 'zip'
        }),
        new CleanWebpackPlugin(['dist', '*.zip'])
    ],
    devServer: {
        host: '0.0.0.0',
        port: 9898,
        disableHostCheck: true,
        publicPath: '/js/',
        contentBase: 'dist/'
    }
};

```
