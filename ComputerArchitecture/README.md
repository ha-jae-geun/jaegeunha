## bus
* bus is terminal between CPU and Main memory to save data
* Address bus, Data bus, Control bus
* [Bus link](http://ssoonidev.tistory.com/14)
* [Bus link2](http://contents.kocw.net/KOCW/document/2015/cup/leesangkwan/6.pdf)

##SSD HDD
* Hdd: disk has to spin
* Gigabyte Company made the HDD with RAM. It didn't release
* SSD is 5times faster than HDD
* Reading and writing have a limit in SSD
* SSD: Flash memory(Like USB) + Controller
  # Reading is faster than writing
  # Cell(Memory Storation way) SLC(single) > MLC(Multi) > TLC(triple)  //Usually we use MLC
    - The number of cell decides SSD's price
    - SLC: 1 bit will be stored in one room
    - SLC: It makes a controller complicated and it makes it unstable


## Clipboard
* It

## Process
* Concurrent
* Code, Stack, Heap, Data
* Stack:  

## Memory structure
* Data; initialized
  - static variable, global variable
  - it is called first and remain until programs terminate 
  - -> it's fixed
* Stack(function): local variable, parameter, pointer variable
  - when the funcion is called, it starts to be stacked. (recursive)
  - when memory is allocated, stack area has to be extended(compile time)
  - At compie time, stack size has to be decided
  - if the function is terminated, stack is also deleted
  - -> it's static
  - Array's length has to be a constant
* Heap; dynamic(malloc, free)
  - <> stack; running time 
* BSS; uninitialized
* Text(Code); assembly code

## Thread
* Parallel