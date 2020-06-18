# Resource
[Collinear Points](https://coursera.cs.princeton.edu/algs4/assignments/collinear/specification.php)

The problem. Given a set of n distinct points in the plane, find every (maximal) line segment that connects a subset of 4 or more of the points.
This client program takes the name of an input file as a command-line argument; read the input file (in the format specified below); prints to standard output the line segments that your program discovers, one per line; and draws to standard draw the line segments.

## Test
#### Mac OS || Linux || Windows
```
% java-algs4 BruteCollinearPoints input8.txt
(10000, 0) -> (0, 10000) 
(3000, 4000) -> (20000, 21000) 

% java-algs4 FastCollinearPoints input8.txt
(3000, 4000) -> (20000, 21000) 
(0, 10000) -> (10000, 0)

% java-algs4 FastCollinearPoints input6.txt
(14000, 10000) -> (32000, 10000) 
```
