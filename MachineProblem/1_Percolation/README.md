# Resources
[Percolation](https://coursera.cs.princeton.edu/algs4/assignments/percolation/specification.php)

## Test
Mac OS / Linux / Windows
```
$ javac -cp ../lib/* Percolation.java PercolationStats.java
$ java -cp "../lib/*:." PercolationStats 200 1000
```
## Tricky part
I got stuck in the *BackWash* test cases. And find a concise way to make the explanation clearly:
There are three categories in the sites:
1. Full: IFF one side of the opened-site-path can connect to top.
2. BackWash: The opened-path connect to bottom, without connecting to the top.
3. Precolation: Connect to both top and bottom.

We know that there is a function *isFull()* in assignment. So we need to exclude the second and third cases. 
However, since we add a top point and a bottom point to union them easily, we will easily ignore the exceiption:
|   |      |   | open |   |   |   |   |
|---|------|---|------|---|---|---|---|
|   |      |   | open |   |   |   |   |
|   |      |   | open |   |   |   |   |
|   |      |   | open |   |   |   |   |
|   |      |   | open |   |   |   |   |
|   |      |   | open |   |   |   |   |
|   | open |   | open |   |   |   |   |
|   | open |   | open |   |   |   |   |
         \       /
            Bottom

The default part is we connect the bottom sites with bottom point. If we do not exclude the connection, the left path will be full(but it's not full!).
The solution will become: we set a new *WeightedQuickUnionUF backWashUf* to exclude the connection(int Union function). In the *isFull()* fuction. We return both 
```
uf.connection(point, top) && backWash.connection(point, top)
```
