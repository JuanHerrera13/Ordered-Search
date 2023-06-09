package searches;

import exception.ElementException;

import java.util.*;

import static enumerator.ConstantValues.RANDOM_SIZE;
import static enumerator.ConstantValues.VECTOR_SIZE;

public class BinarySearch {

    /**
     * Retrieve a list of numbers and the index of the desired number
     *
     * @param args args
     * @throws ElementException when a letter is passed in the search method
     */
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
            Integer[] sortedList = messyList.toArray(new Integer[0]);

            long methodEnding = System.nanoTime();
            long timeElapsed = methodEnding - methodBeginning;
            System.out.println("\nThe number's sorting (using Random method) took " + timeElapsed + " nano seconds");
            System.out.println("Before bubbleSort method: ");
            System.out.println(Arrays.toString(sortedList));
            bubbleSort(sortedList);
            System.out.println(Arrays.toString(sortedList));
            System.out.print("\nType the element you want to fetch the index: ");
            int element = scanner.nextInt();
            int searchedElement = binarySearch(List.of(sortedList), element);
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

    /**
     * Sort the numbers list in ascending order through bubble sort method
     *
     * @param messyList messyList
     */
    public static void bubbleSort(Integer[] messyList) {
        long methodBeginning = System.nanoTime();
        for (int index = 0; index < messyList.length - 1; index++) {
            for (int i = 0; i < messyList.length - 1 - index; i++) {
                if (messyList[i] > messyList[i + 1]) {
                    int aux = messyList[i];
                    messyList[i] = messyList[i + 1];
                    messyList[i + 1] = aux;
                }
            }
        }
        long methodEnding = System.nanoTime();
        long timeElapsed = methodEnding - methodBeginning;
        System.out.println("\nThe bubbleSort's performance took " + timeElapsed + " nano seconds");
    }

    /**
     * Retrieve the index of given element
     *
     * @param sortedList sortedList
     * @param element element
     * @return the index of the element informed by the binary search algorithm
     */
    public static int binarySearch(List<Integer> sortedList, int element) {
        long methodBeginning = System.nanoTime();
        int beginning = 0;
        int ending = sortedList.size() - 1;
        while (beginning <= ending) {
            int middle = (beginning + ending) / 2;
            if (sortedList.get(middle) == element) {
                long methodEnding = System.nanoTime();
                long timeElapsed = methodEnding - methodBeginning;
                System.out.println("\nThe binary search performance took " + timeElapsed + " nano seconds");
                return middle;
            } else if (sortedList.get(middle) < element) {
                beginning = middle + 1;
            } else {
                ending = middle - 1;
            }
        }
        long methodEnding = System.nanoTime();
        long timeElapsed = methodEnding - methodBeginning;
        System.out.println("\nThe binary search performance took " + timeElapsed + " nano seconds");
        return -1;
    }

}
