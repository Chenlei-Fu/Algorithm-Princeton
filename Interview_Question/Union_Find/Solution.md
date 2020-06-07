# Interview Questions: Union–Find

## Question 1
#### Social network connectivity. 
Given a social network containing nn members and a log file containing mm timestamps at which times pairs of members formed friendships, design an algorithm to determine the earliest time at which all members are connected (i.e., every member is a friend of a friend of a friend ... of a friend). Assume that the log file is sorted by timestamp and that friendship is an equivalence relation. The running time of your algorithm should be m \log nmlogn or better and use extra space proportional to nn.

### Solution
This can be easily solved using <strong>Weighted Union Find with Path compression</strong>. Everytime the person get friendship, we calculate its group size of friends. 
1. As for the union method. Traverse all timestamps to do <strong>Weighted Union</strong>. <strong>$\mathbb{O} (M)$</strong>
2. As for the find method. Since the height of union tree will not be greater then $\log N$, we can get time complexity <strong>$\mathbb{O} (\log N$)</strong>. Also, each time we do find method, we set the id of each examined node to point to that root.
3. So the total time is <strong>$\mathbb{O} (M \log N$)</strong>

[Code Here](WeightedQuickUnionUF.java)

## Question 2
#### Union-find with specific canonical element. 
Add a method $find()$ to the union-find data type so that $find(i)$ returns the largest element in the connected component containing i. The operations, $union()$, $connected()$, and $find()$ should all take logarithmic time or better.

For example, if one of the connected components is $\{1, 2, 6, 9\}$, then the $find()$ method should return 99 for each of the four elements in the connected components.

### Solution
We can still use <strong>Weighted Union Find with Path compression</strong>. But we need to add an array called $large[]$ as the largest element in components. And when we do union, we need to update $large[]$. For instance:
1 2 6 9 -- $large[1] = 1, large[2] = 2, large[6] = 6, large[9] = 9$
-> Union(1,2)
(1,2) 6 9 -- since $find(1) = 1 < 2 = find(2)$, we can get $large[1] = 2. large[2] = 2, , large[6] = 6, large[9] = 9$
...

[Code Here](UFWithLargest.java)

## Question 3
####Successor with delete. 
Given a set of nn integers $S = \{ 0, 1, ... , n-1 \}$ and a sequence of requests of the following form:

* Remove $x$ from $S$
* Find the successor of $x$: the smallest $y$ in $S$ such that $y \geq x$.
  
design a data type so that all operations (except construction) take logarithmic time or better in the worst case.

### Solution
We can get the hint from Question2. When an element is removed, we union its neighbor. Everytime when we call find, it will return the smallest one of its neighbors that is greater than its value and not be removed.  

[Code Here](SuccessorWithDelete.java)


