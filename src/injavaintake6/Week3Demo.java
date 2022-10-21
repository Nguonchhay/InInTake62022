package injavaintake6;

public class Week3Demo {

    public static void printAllArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
    }

    public static void task1() {
        /**
         * Solution:
         * 1. Declare array with initialize values
         * 2. Declare variable to store name "maxValue"
         * 3. Determine first array item is the biggest value and
         *      assign to "maxValue"
         * 4. Loop all array item
         * 5. compare array item with "maxValue"
         * 5.1 if array item > maxValue then assign that array item to maxValue
         */
        int[] arrNumber = {1, 4, 6, 2, 3};
        int maxValue = arrNumber[0];
        for (int i = 0; i < arrNumber.length; i++) {
            if (arrNumber[i] > maxValue) {
                maxValue = arrNumber[i];
            }
        }

        printAllArray(arrNumber);
        System.out.println("\nMax value = " + maxValue);
    }

    public static void task2() {
        int[] arrNumber = {1, 4, 6, 2, 3};

        System.out.println("Before sort: ");
        printAllArray(arrNumber);
        for (int i = 0; i < arrNumber.length - 1; i++) {
            for (int k = i + 1; k < arrNumber.length; k++) {
                if (arrNumber[i] > arrNumber[k]) {
                    int temp = arrNumber[i];
                    arrNumber[i] = arrNumber[k];
                    arrNumber[k] = temp;
                }
            }
        }

        System.out.println("\nAfter sort: ");
        printAllArray(arrNumber);
    }

    public static void task3() {
        int[] arrNumber = {4, 4, 6, 8, 3};
        int sum = 0;
        int index = 0;
        while (index < arrNumber.length) {
            sum = sum + arrNumber[index];
            index++;
        }
        printAllArray(arrNumber);
        System.out.println("\nSum = " + sum);
    }

    public static void task4() {
        int[] arrNumber = {1, 4, 6, 6, 3, 6, 4, 7};
        int removeValue = 6;
        int countRemove = 0;

        int index = 0;
        do {
            if (arrNumber[index] == removeValue) {
                countRemove++;
            }
            index++;
        } while(index < arrNumber.length);

        int[] newArrNumber = new int[arrNumber.length - countRemove];
        index = 0;
        for (int i = 0; i < arrNumber.length; i++) {
            if (arrNumber[i] != removeValue) {
                newArrNumber[index] = arrNumber[i];
                index++;
            }
        }
        System.out.println("Before remove");
        printAllArray(arrNumber);
        System.out.println("\n After remove: " + removeValue);
        printAllArray(newArrNumber);
    }
}
