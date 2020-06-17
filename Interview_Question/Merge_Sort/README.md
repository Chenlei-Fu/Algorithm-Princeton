# Interview Questions: Mergesort

## 1. Merging with smaller auxiliary array. 
Suppose that the subarray $\mathtt{a[0]}$ to $\mathtt{a[n-1]}$ is sorted and the subarray $\mathtt{a[n]}$ to $\mathtt{a[2*n-1]}$ is sorted. How can you merge the two subarrays so that $\mathtt{a[0]}$ to $\mathtt{a[2*n-1]}$ is sorted using an auxiliary array of length n (instead of 2n)?

### Solution
[Merge With Smaller](mergeWithSmaller.java)

## 2. Counting inversions
An inversion in an array $a[\,]$ is a pair of entries $a[i]$ and $a[j]$ such that $i < j$ but $a[i] > a[j]$. Given an array, design a linearithmic algorithm to count the number of inversions.

### Solution
[Count Inversion](countInversion.java)

## 3. Shuffling a linked list.
Given a singly-linked list containing n items, rearrange the items uniformly at random. Your algorithm should consume a logarithmic (or constant) amount of extra memory and run in time proportional to $n \log n$ in the worst case.

[Shuffle Linked List](shuffle.java)
