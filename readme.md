# my readme file

## Employee Queue Program
 
This Java program demonstrates two types of Queue data structures (Fixed Front Queue and Floating Front Queue) using Employee objects. It reads employee data from a text file and performs enqueuing, dequeuing, and printing operations on the queues. 
 
### How the Program Works
 
1. **Employee Class**: The `Employee` class encapsulates employee details, including ID and name. It overrides the `toString` method to provide a string representation of an employee.
 
2. **FixedFrontQueue Class**: The `FixedFrontQueue` class represents a queue with a fixed front. It has methods for enqueueing, dequeuing, checking if the queue is empty, and printing the elements in the queue. The queue uses circular indexing for efficient memory usage.
 
3. **FloatingFrontQueue Class**: The `FloatingFrontQueue` class represents a queue with a floating front. It has methods for enqueueing, dequeuing, checking if the queue is empty, and printing the elements in the queue.
 
4. **Main Class**: The `Main` class is the entry point of the program. It creates instances of both queue types, reads employee data from a file (emp.txt), enqueues employees into both queues, and performs enqueuing, dequeuing, and printing operations. The program prints the elements stored in both queues before and after dequeuing.
 
#### Running the Program
•	    java -jar QueueData.jar

