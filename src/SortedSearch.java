import java.util.*;

public class SortedSearch {

    private static final int VECTOR_SIZE = 50;
    private static final int RANDOM_SIZE = 100;

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> messyList = new ArrayList<>();

        Random random = new Random();
        do {
            int number = random.nextInt(RANDOM_SIZE) + 1;
            if (!messyList.contains(number)) {
                messyList.add(number);
            }
        } while (messyList.size() != VECTOR_SIZE);

        Integer[] sortedList = messyList.toArray(new Integer[0]);

        System.out.println("\nBefore bubbleSort method: ");
        System.out.println(Arrays.toString(sortedList));

        bubbleSort(sortedList);

        System.out.println("\nAfter bubbleSort method: ");
        System.out.println(Arrays.toString(sortedList));

        System.out.print("\nType the element you want to fetch the index: ");
        Integer element = scanner.nextInt();

        if (messyList.contains(element)) {
            int elementIndex = Arrays.asList(sortedList).indexOf(element);
            System.out.println("\nThe " + element + " index is " + elementIndex);
        }

        scanner.close();
    }

    public static void bubbleSort(Integer[] messyList) {
        for (int index = 0; index < messyList.length - 1; index++) {
            for (int i = 0; i < messyList.length - 1 - index; i++) {
                if (messyList[i] > messyList[i + 1]) {
                    int aux = messyList[i];
                    messyList[i] = messyList[i + 1];
                    messyList[i + 1] = aux;
                }
            }
        }
    }
}
