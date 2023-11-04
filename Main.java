package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//Bellow is a class for Creating employee objects
class Employee {
    private int id; //employee id variable
    private String name; //employee name variable

    // Employee constructor
    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Get function  for fetching  employee ID
    public int getEmployeeId() {
        return id;
    }

    // Get function  for fetching  employee name
    public String getEmployeeName() {
        return name;
    }

    // Overriding the toString() method to provide a string return message
    @Override
    public String toString() {
        return "id=" + id + ", name=" + name ;
    }
}

class FixedFrontQueue {
    private Employee[] queue;
    private int front;
    private int rear;
    private int size;

    // FixedFrontQueue constructor
    public FixedFrontQueue(int capacity) {
        queue = new Employee[capacity];
        size = 0;
        front = 0;
        rear = -1;
    }

    // Enqueue an employee into the queue
    public boolean enqueue(Employee e) {
        if (size == queue.length) { //checking if the size of the queue is equal to the number of employees added
            System.out.println("Employee Queue is full. can't add more employees enqueue.");
            return false;
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = e;
        size++;
        return true;
    }

    // Dequeue an employee from the queue
    public Employee dequeue() {
        if (isEmpty()) {
            System.out.println("the Queue is empty, we cannot remove from a empty Queue");
            return null;
        }
        Employee removedEmployee = queue[front];
        queue[front] = null;
        front = (front + 1) % queue.length;
        size--;
        return removedEmployee;
    }

    // Checking  if the queue is empty or not
    public boolean isEmpty() { // it should return a boolean . ie. true or False , but for my case it returns size of the queue as zero
        return size == 0;
    }

    // Printing  the elements in the employees queue
    public void printQueue() {
        for (int i = 0; i < size; i++) {
            int index = (front + i) % queue.length;
            System.out.println(queue[index]);
        }
    }
}

//Bellow is a class for Floating Front Queues
class FloatingFrontQueue {
    private Employee[] queue;
    private int size;

    // FloatingFrontQueue constructor for the floating front queue
    public FloatingFrontQueue(int capacity) {
        queue = new Employee[capacity];
        size = 0;
    }

        // This will add   employee into the  employees queue
    public boolean enqueue(Employee e) {
        if (size == queue.length) {
            System.out.println("Employee Queue is full. Can't add more employees");
            return false;
        }
        queue[size] = e;
        size++;
        return true;
    }

    // this will remove  an employee from the queue
    public Employee dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return null;
        }
        Employee removedEmployee = queue[0];
        for (int i = 0; i < size - 1; i++) {
            queue[i] = queue[i + 1];
        }
        queue[size - 1] = null;
        size--;
        return removedEmployee;
        }

    // This function checks whether the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    //A function that  Prints  the elements in the queue when called
    public void printQueue() {
        for (int i = 0; i < size; i++) {
            System.out.println(queue[i]);
        }
     }
}

public class Main {
    public static void main(String[] args) {
        int capacity = 10; //A variable storing  the capacity of each queue
        FixedFrontQueue fixedFrontQueue = new FixedFrontQueue(capacity); //creating an abject of the  FixedFrontQueue class
        FloatingFrontQueue floatingFrontQueue = new FloatingFrontQueue(capacity); //creating an object of the FloatingFrontQueue class

        try {
            BufferedReader reader = new BufferedReader(new FileReader("emp.txt")); //reading from the txt file
            String line;
            int employeeCount = 0; //initializing employee count to Zero
            while ((line = reader.readLine()) != null && employeeCount < 5) { // using a while loop . A for loop can work as an alternative
                String[] employeeData = line.split(" ");
                // This is the order of  parsing data
                int id = Integer.parseInt(employeeData[1]);// converting employee ID  into an integer
                String name = employeeData[0];
                Employee employee = new Employee(id, name); // Creating an employee object and assigning an ID and a Name from the text file data

                // Enqueue employees to both types of queues
                fixedFrontQueue.enqueue(employee); //Adding the created employee into fixedFrontQueue using the enque function
                floatingFrontQueue.enqueue(employee); //adding the employee into the  floatingFrontQueue queue

                employeeCount++; //incrementing the employee count by one till it reaches 4 for the while loop to stop
            }
            reader.close(); //calling the .close() function to close the emp.txt file after fetching 5 records
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Printing  elements stored in each  queue
        System.out.println("*********** Fixed Front Queue Elements **********");
        fixedFrontQueue.printQueue();

        System.out.println("\n******** Floating Front Queue Elements ************");
        floatingFrontQueue.printQueue();

        // Dequeue two times  from both queues
        fixedFrontQueue.dequeue();
        fixedFrontQueue.dequeue();
        floatingFrontQueue.dequeue();
        floatingFrontQueue.dequeue();

        // Printing  elements stored in both queues after dequeuing
        System.out.println("\n********** Fixed Front Queue Elements After Dequeue *************");
        fixedFrontQueue.printQueue();

        System.out.println("\n******* Floating Front Queue Elements After Dequeue *********");
        floatingFrontQueue.printQueue();


    }
}








