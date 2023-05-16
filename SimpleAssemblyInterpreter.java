import java.util.Scanner;
import java.util.*;

public class SimpleAssemblyInterpreter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a map to store variables and their values
        HashMap<String, Integer> variables = new HashMap<>();

        // Keep looping until the user enters "quit"
        while (true) {
            System.out.print("Enter command (e.g., MV variable1 10, ADD variable1 variable2, SHOW variable1): ");
            String command = scanner.nextLine();

            // Split the command into parts based on spaces
            String[] parts = command.split(" ");

            // Check the type of command and perform the corresponding action
            if (parts[0].equals("MV")) {
                // MV command: Set variable's value to the given integer
                String variableName = parts[1];
                int value = Integer.parseInt(parts[2]);
                variables.put(variableName, value);
            } else if (parts[0].equals("ADD")) {
                // ADD command: Add the values of two variables or an integer value to a variable
                String variableName = parts[1];
                int value;
                if (parts[2].startsWith("#")) {
                    // If the second part starts with '#', it represents an integer value
                    value = Integer.parseInt(parts[2].substring(1));
                } else {
                    // Otherwise, it represents the name of another variable
                    value = variables.get(parts[2]);
                }

                // If the variable already exists, add the new value to the existing value; otherwise, create a new entry
                if (variables.containsKey(variableName)) {
                    value += variables.get(variableName);
                }
                variables.put(variableName, value);
            } else if (parts[0].equals("SHOW")) {
                // SHOW command: Display the value of the specified variable and terminate the program
                String variableName = parts[1];
                int value = variables.get(variableName);
                System.out.println("Value of " + variableName + ": " + value);
                break;
            }
        }

        scanner.close();
    }
}
