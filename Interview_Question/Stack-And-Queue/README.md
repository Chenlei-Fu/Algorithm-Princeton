## Interview Questions: Stacks and Queues
### 1. Queue with two stacks. 
Implement a queue with two stacks so that each queue operations takes a constant amortized number of stack operations.

### Solution
* Enqueue: Push the new element onto inbox
* Dequeue: If outbox is empty, refill it by popping each element from inbox and pushing it onto outbox. Pop and return the top element from outbox

[Simple Code](QueueWithTwoStack.java)

### 2. Stack with max. 
Create a data structure that efficiently supports the stack operations (push and pop) and also a return-the-maximum operation. Assume the elements are real numbers so that you can compare them.
### Solution
just using two stack(max stack and min stack)
[Simple Code](StackWithMaxMin.java)

### 3. Java generics. 
Explain why Java prohibits generic array creation.
### Solution
* It's because Java's arrays (unlike generics) contain, at runtime, information about its component type. So you must know the component type when you create the array. Since you don't know what T is at runtime, you can't create the array.
* But there are some solutions to solve this:
```java
T[] ts = (T[]) new Object[n];
```
