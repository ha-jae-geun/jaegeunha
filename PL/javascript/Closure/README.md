# [클로저](https://joshua1988.github.io/web-development/javascript/javascript-interview-3questions/)

# [iife closure](https://youtu.be/1S8SBDhA7HA)

# [for loop; var, let](https://exploringjs.com/es6/ch_variables.html#sec_let-const-loop-heads)
```javascript
var-declaring a variable in the head of a for loop creates a single binding (storage space) for that variable:

const arr = [];
for (var i=0; i < 3; i++) {
    arr.push(() => i);
}
arr.map(x => x()); // [3,3,3]
Every i in the bodies of the three arrow functions refers to the same binding, which is why they all return the same value.

If you let-declare a variable, a new binding is created for each loop iteration:

const arr = [];
for (let i=0; i < 3; i++) {
    arr.push(() => i);
}
arr.map(x => x()); // [0,1,2]
This time, each i refers to the binding of one specific iteration and preserves the value that was current at that time. 
Therefore, each arrow function returns a different value.

const works like var, but you can’t change the initial value of a const-declared variable:

// TypeError: Assignment to constant variable
// (due to i++)
for (const i=0; i<3; i++) {
    console.log(i);
}
```

# [for in](https://exploringjs.com/es6/ch_variables.html#sec_let-const-loop-heads)
```javascript
9.5.2 for-of loop and for-in loop 
In a for-of loop, var creates a single binding:

const arr = [];
for (var i of [0, 1, 2]) {
    arr.push(() => i);
}
arr.map(x => x()); // [2,2,2]
const creates one immutable binding per iteration:

const arr = [];
for (const i of [0, 1, 2]) {
    arr.push(() => i);
}
arr.map(x => x()); // [0,1,2]
let also creates one binding per iteration, but the bindings it creates are mutable.

The for-in loop works similarly to the for-of loop.
```
