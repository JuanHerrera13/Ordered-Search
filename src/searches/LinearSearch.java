package searches;

import exception.ElementException;

import java.util.*;

import static enumerator.ConstantValues.RANDOM_SIZE;
import static enumerator.ConstantValues.VECTOR_SIZE;

public class LinearSearch {

    public static void main(String[] args) throws ElementException {
        try {
            Locale.setDefault(Locale.US);
            Scanner scanner = new Scanner(System.in);
            ArrayList<Integer> messyList = new ArrayList<>();
            long methodBeginning = System.nanoTime();
            Random random = new Random();
            do {
                int number = random.nextInt(RANDOM_SIZE.getValue()) + 1;
                if (!messyList.contains(number)) {
                    messyList.add(number);
                }
            } while (messyList.size() != VECTOR_SIZE.getValue());
            long methodEnding = System.nanoTime();
            long timeElapsed = methodEnding - methodBeginning;
            double seconds = (double) timeElapsed / 1000000000.0;
            System.out.println("\nThe number's sorting (using Random method) took " + seconds + " seconds");
            System.out.println(messyList);
            System.out.print("\nType the element you want to fetch the index: ");
            Integer element = scanner.nextInt();
            int searchedElement = linearSearch(messyList, element);
            if (searchedElement != -1) {
                System.out.println("The index of " + element + " is " + searchedElement);
            } else {
                System.out.println("The given element is not present in the list");
            }
            scanner.close();
        } catch (Exception exception) {
            throw new ElementException("You passed a letter!");
        }
    }

    public static int linearSearch(List<Integer> vector, Integer element) {
        long methodBeginning = System.nanoTime();
        for (int index = 0; index < vector.size(); index++)
            if (vector.get(index).equals(element)) {
                long methodEnding = System.nanoTime();
                long timeElapsed = methodEnding - methodBeginning;
                double seconds = (double) timeElapsed / 1000000000.0;
                System.out.println("\nThe linear search performance took " + seconds + " seconds");
                return index;
            }
        long methodEnding = System.nanoTime();
        long timeElapsed = methodEnding - methodBeginning;
        double seconds = (double) timeElapsed / 1000000000.0;
        System.out.println("\nThe linear search performance took " + seconds + " seconds");
        return -1;
    }
}
