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

## Multi Process

##Thread
* it shares code, data and heap area. It has own stack area.

## Multi Thread
* If one thread breaks data space, it could affect the rest of threads
  - Critical Section
    + if threads more than two are excuted at the same time, it could affect statiic variable.
      * Mutual Exclusion; synchronized
      * Progress
      * Bounded Waiting

## Memory structure
1. Data; initialized
  - static variable, global variable
  - it is called first and remain until programs terminate 
  - -> it's fixed
  - BSS (Block Stated Symbol); uninitialized
2. Stack(function): local variable, parameter, return, pointer variable
  - ALl programs have stacks. It helps to go back
  - from bottom to top
  - when the funcion is called, it starts to be stacked. (recursive)
  - when memory is allocated, stack area has to be extended(compile time)
  - At compile time, stack size has to be decided
  - if the function is terminated, stack is also deleted
  - -> it's static
  - Array's length has to be a constant
  - stack size is fixed
3. Heap; dynamic(malloc, free)  C++: new()
  - from top to bottom
  - <> stack; running time 
4. Text(Code); assembly code about function; function, statement, constant
* SMA(Static Memory Allocation): data, stack   | DMA(Dynamic Memory Allocation): Heap Area
* Stack and heap are in inverse proportion

## Thread
* Parallel