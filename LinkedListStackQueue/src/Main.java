import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        String sourcefilePath = "./src/Source.txt";
        String searchFilePath = "./src/Search.txt";

        long startTime;
        long endTime;
        long executionTime;

        startTime = System.currentTimeMillis();
        try (BufferedReader reader = new BufferedReader(new FileReader(sourcefilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                for (String valueStr : values) {
                    try {
                        int value = Integer.parseInt(valueStr.trim());
                        if (!linkedList.search(value)) {
                            linkedList.insertToEnd(value);
                        }
                    } catch (NumberFormatException e) {

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        linkedList.display();
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println("Execution Time (Method 1): " + executionTime + "ms");



        int totalMemoryAccesses = 0;
        int totalValuesSearched = 0;

        startTime = System.currentTimeMillis();
        try (BufferedReader search = new BufferedReader(new FileReader(searchFilePath))) {
            String searchLine;
            while ((searchLine = search.readLine()) != null) {
                String[] values = searchLine.split(",");
                for (String valueStr : values) {
                    try {
                        int value = Integer.parseInt(valueStr.trim());
                        if (linkedList.search(value)) {
                            linkedList.moveToBeginning(value);
                            totalMemoryAccesses += linkedList.getMemoryAccessCount();
                            totalValuesSearched++;
                        }
                    } catch (NumberFormatException e) {

                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println("Execution Time (Method 2): " + executionTime + "ms");


        double averageMemoryAccesses = totalValuesSearched == 0 ? 0 :  totalMemoryAccesses / totalValuesSearched;

        System.out.println("Total Memory Accesses: " + totalMemoryAccesses);
        System.out.println("Total Values Searched: " + totalValuesSearched);
        System.out.println("Average Memory Accesses: " + averageMemoryAccesses);
        linkedList.display();


            Map<Integer, Node<Integer>> valueToNodeMap = new HashMap<>();
            LinkedList<Integer> linkedListHash= new LinkedList<>();

            int totalMemoryAccessesHash = 0;
            int totalValuesSearchedHash = 0;

            try (BufferedReader reader = new BufferedReader(new FileReader(sourcefilePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] values = line.split(",");
                    for (String valueStr : values) {
                        try {
                            int value = Integer.parseInt(valueStr.trim());
                            if (!valueToNodeMap.containsKey(value)) {
                                Node<Integer> newNode = new Node<>(value);
                                linkedListHash.insertToFront(value);
                                valueToNodeMap.put(value, newNode);
                                totalMemoryAccessesHash++;
                            }
                            totalValuesSearchedHash++;
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        double averageMemoryAccessesHash = totalValuesSearchedHash == 0 ? 0 : totalMemoryAccessesHash / totalValuesSearchedHash;

        System.out.println("Total Memory Accesses: " + totalMemoryAccessesHash);
        System.out.println("Total Values Searched: " + totalValuesSearchedHash);
        System.out.println("Average Memory Accesses: " + averageMemoryAccessesHash);
        linkedList.display();



    }


}


