# TypeTest
```javascript
        // // 0-1. boolean 값
        // plain = false;

        // // 0-2. 숫자
        // plain = 1;

        // // 0-3. null
        // plain = null;

        // // 0-4. function
        plain = function() {1+2};

        // // 0-5. undefined;
        // var plain2;
        // plain = plain2;

        // // 0-6. boolean Array
        // plain = [];
        // plain.push(true);
        // plain.push(false);

        // // 0-7. Number Array
        // plain = [];
        // plain.push(1);
        // plain.push(2);

        // // 0-8. null Array
        // plain = [];
        // plain.push(null);
        // plain.push(null);

        // // 0-9. function Array
        // plain = [];
        // plain.push(function() {1+2});
        // plain.push(function() {1+2});

        // // 0-10. undefined Array
        // var plain2;
        // var plain3;
        // plain = [];
        // plain.push(plain2);
        // plain.push(plain3);

        // 1. String(VestSign: 그대로 사용, Fincert: 1. JSON.parse 2. exception => binary)
        // plain = "test";

        //1-2. String으로 되어있는 JSON
        // plain = '{"test": "1234567890123", "test1": "test", "test2": "10000"}';

        // // 2. String Array(VestSign: 그대로 사용, Fincert: 1. JSON.parse Array 2. exception => binary Array)
        // plain = ["test", "test2"];

        // //3. JSON(VestSign: stringfy, Fincert: 그대로 사용)
        // var test = '{"test": "1234567890123", "test1": "test", "test2": "10000"}';
        // plain = JSON.parse(test);

        // // 4. JSON Array(VestSign: JSON.stringify Array => String Array, Fincert: 그대로 사용)
        // var test = '{"test": "1234567890123", "test1": "test", "test2": "10000"}';
        // var test2 = '{"test2": "1234567890123", "test3": "test", "test4": "10000"}';
        // plain = [];
        // plain.push(JSON.parse(test));
        // plain.push(JSON.parse(test2));
```
