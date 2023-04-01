package searches;

import exception.ElementException;

import java.util.*;

import static enumerator.ConstantValues.RANDOM_SIZE;
import static enumerator.ConstantValues.VECTOR_SIZE;

public class SortedSearch {

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
            double seconds = (double) timeElapsed / 1000000000.0;
            System.out.println("\nThe number's sorting (using Random method) took " + seconds + " seconds");
            System.out.println("Before bubbleSort method: ");
            System.out.println(Arrays.toString(sortedList));
            bubbleSort(sortedList);
            System.out.println(Arrays.toString(sortedList));
            System.out.print("\nType the element you want to fetch the index: ");
            Integer element = scanner.nextInt();
            if (messyList.contains(element)) {
                int elementIndex = Arrays.asList(sortedList).indexOf(element);
                System.out.println("\nThe " + element + " index is " + elementIndex);
            } else {
                System.out.println("The given element is not present in the list");
            }
            scanner.close();
        } catch (Exception exception) {
                throw new ElementException("You passed a letter!");
        }
    }

        public static void bubbleSort (Integer[]messyList){
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
            double seconds = (double) timeElapsed / 1000000000.0;
            System.out.println("\nThe bubbleSort's performance took " + seconds + " seconds");
        }
    }
