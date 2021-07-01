# [클래스 선언](https://exploringjs.com/es6/ch_variables.html#sec_const-immutability)
```javascript
9.8 Function declarations and class declarations 
Function declarations…

are block-scoped, like let.
create properties in the global object (while in global scope), like var.
are hoisted: independently of where a function declaration is mentioned in its scope, it is always created at the beginning of the scope.
The following code demonstrates the hoisting of function declarations:

{ // Enter a new scope

    console.log(foo()); // OK, due to hoisting
    function foo() {
        return 'hello';
    }
}
Class declarations…

are block-scoped.
don’t create properties on the global object.
are not hoisted.
```
