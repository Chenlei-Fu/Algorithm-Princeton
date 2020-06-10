## Analysis of Algorithms
### 1. 3-SUM in quadratic time. 
Design an algorithm for the 3-SUM problem that takes time proportional to $n^2$ in the worst case. You may assume that you can sort the n integers in time proportional to $n^2$ or better.
### Solution
[threeSum](threeSum.java)

### 3. Search in a bitonic array. 
An array is bitonic if it is comprised of an increasing sequence of integers followed immediately by a decreasing sequence of integers. Write a program that, given a bitonic array of nn distinct integer values, determines whether a given integer is in the array.

Standard version: Use $\sim 3 \lg n$ compares in the worst case.
Signing bonus: Use $\sim 2 \lg n$ compares in the worst case (and prove that no algorithm can guarantee to perform fewer than $\sim 2 \lg n$ compares in the worst case).

### Solustion
1. Take the middle of the array
2. Compare the middle element with one of its neighbor to see if the max is on the right or on the left
3. Compare the middle element with the desired value
4. If the middle element is smaller than the desired value AND the max is on the left side, then do bitonic search on the left subarray (we are sure that the value is not in the right subarray)
5. If the middle element is smaller than the desired value AND the max is on the right side, then do bitonic search on the right subarray
6. If the middle element is bigger than the desired value, then do descending binary search on the right subarray and ascending binary search on the left subarray.
**Time Complexity: $\mathbb{O} (2logn)$**
### Sample Code:
[bitonicSearch](bitonicSearch.java)


### 2.Egg drop. 
Suppose that you have an n-story building (with floors 1 through n) and plenty of eggs. An egg breaks if it is dropped from floor T or higher and does not break otherwise. Your goal is to devise a strategy to determine the value of T given the following limitations on the number of eggs and tosses:

* Version 0: 1 egg, $\le T$ tosses.
* Version 1: $\sim 1 \lg n$ eggs and $\sim 1 \lg n$ tosses.
* Version 2: $\sim \lg T$ eggs and $\sim 2 \lg T$ tosses.
* Version 3: 2 eggs and $\sim 2 \sqrt n$ tosses.
* Version 4: 2 eggs and $\le c \sqrt T$ tosses for some fixed constant c.

### Solution
* Version 0: simple iterative search starting from the $1st$ floor and working up to the $Nth$ floor in increments of 1 will work.
* Version 1: a binary search across the floors 1 to N
* Version 2: 
  * iteratively double floors, visiting 1, then 2, then 4, then 8, etc. until the egg breaks at floor $2^k$. 
    * At the time we have used 1 egg
    * $\lg T$ tosses
  * Then do binary search between $2^{k-1}$ and $2^k$. 
    * In the worst case, you need to use $\lg T - 1$ eggs.
    * $\lg T$ tosses

* Version 3:
  * Drop the egg at $\sqrt n$ floor. 
  * If it doesn't break, increase the floor by $\sqrt n$ and repeat until the egg breaks.
    * maximum $\sqrt n$ tosses
    * 1 egg
  * Do a sequential search in the range(range size is $\sqrt n$), use the other remaining egg. Because the length of that range is $\sqrt n$, it takes maximum $\sqrt n$ tosses, 1 egg.
  * So the total usage is 2 egg and $2 \sqrt n$ tosses
* Version 4
  * Drop eggs starting from floors $1, 3(1+2), 6(1+2+3), 10(1+2+3+4)$...Note that $1+2+3+4+...k = \frac{k(k+1)}{2} = \frac{1}{2} k^2$. We can get $T = \frac{1}{2} k^2, k = \sqrt{2T}$. k is the number of tosses.
  * Then we toss egg one by one from $\frac{k(k-1)}{2}$ to $\frac{k(k+1)}{2}$, it takes k tosses ($\sqrt{2T}$).
  * Total egg: 2; total tosses: $2 \sqrt{2T}$
