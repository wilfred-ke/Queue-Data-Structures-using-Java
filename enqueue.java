import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class EmployeeQueueExample {

    public static void main(String[] args) {
        // the actual file path
        String filePath = "emp.txt";

        // Create a fixed-size queue with a capacity of 5
        Queue<String> employeeQueue = new LinkedList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int count = 0;

            // Read lines from the file and add them to the queue
            while ((line = reader.readLine()) != null && count < 5) {
                employeeQueue.offer(line);
                count++;
            }

            // Display the elements in the queue
            System.out.println("Employee elements in the queue:");
            while (!employeeQueue.isEmpty()) {
                System.out.println(employeeQueue.poll());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
