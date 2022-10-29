package injavaintake6;

import java.util.*;

public class Week4Demo {
    public static void launch() {
//        task1();
//        task2();
//        task3();
//        task4();
//        task5();
        task5_1();
    }

    public static void displayIntList(ArrayList<Integer> arr) {
//        for (int i = 0; i < arr.size(); i++) {
//            System.out.print(arr.get(i) + " ");
//        }
        arr.forEach(item -> {
            System.out.print(item + " ");
        });
    }

    public static void displayDoubleList(ArrayList<Double> arr) {
        arr.forEach(item -> {
            System.out.print(item + " ");
        });
    }

    public static void task1() {
        // int[] arr = new int[20];
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        System.out.println("\n Original array: ");
        displayIntList(arr);

//        Clone by reference
//        ArrayList<Integer> newArr = arr;
//        System.out.println("\n Clone array: ");
//        displayIntList(newArr);

        ArrayList<Integer> newArr = new ArrayList<>();
        System.out.println("\n Clone array: ");
        newArr.addAll(arr);

        newArr.remove(1);

        System.out.println("\n Original array: ");
        displayIntList(arr);
    }

    public static void task2() {
        ArrayList<Double> arrNumber = new ArrayList<>();
        arrNumber.add(2.0);
        arrNumber.add(1.0);
        arrNumber.add(1.5);
        arrNumber.add(2.0);
        arrNumber.add(2.0);
        arrNumber.add(3.0);
        arrNumber.add(2.0);
        System.out.println("Before remove");
        displayDoubleList(arrNumber);

        double removeItem = 2.0;
//        for (int i = 0; i < arrNumber.size(); i++) {
//            if (arrNumber.get(i) == removeItem) {
//                arrNumber.remove(i);
//            }
//        }

//        int i = 0;
//        while (i < arrNumber.size()) {
//            if (arrNumber.get(i) == removeItem) {
//                arrNumber.remove(i);
//                i--;
//            }
//            i++;
//        }

        arrNumber.removeIf(item -> item == removeItem);
        System.out.println("\nAfter remove");
        displayDoubleList(arrNumber);
    }

    public static void task3() {
        LinkedList<Integer> myList = new LinkedList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        System.out.println("Before reverse");
        Iterator<Integer> iterator = myList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println("\nAfter reverse");
        Iterator<Integer> reverseIterator = myList.descendingIterator();
        while (reverseIterator.hasNext()) {
            System.out.print(reverseIterator.next() + " ");
        }
    }

    public static void task4() {
        Set<String> firstSet = new HashSet<>();
        firstSet.addAll(Arrays.asList("AA", "BB", "CC"));

        Set<String> secondSet = new HashSet<>();
        secondSet.addAll(Arrays.asList("XX", "AA", "ZZ"));

        Set<String> combinedSet = new HashSet<>();
        combinedSet.addAll(firstSet);
        combinedSet.addAll(secondSet);
        System.out.println("Combined Set");
        combinedSet.forEach(item -> {
            System.out.print(item + " ");
        });
    }

    public static void task5() {
        ArrayList<Integer> coll1 = new ArrayList<>();
        coll1.addAll(Arrays.asList(1, 4, 6));

        ArrayList<Integer> coll2 = new ArrayList<>();
        coll2.addAll(Arrays.asList(10, 3));

        int sumCol1 = 0;
        for (int i = 0; i < coll1.size(); i++) {
            sumCol1 += coll1.get(i);
        }

        int sumCol2 = 0;
        for (int i = 0; i < coll2.size(); i++) {
            sumCol2 += coll2.get(i);
        }

        if (sumCol1 > sumCol2) {
            System.out.println("Collection 1 > Collection 2");
        } else {
            System.out.println("Collection 1 < Collection 2");
        }
    }

    public static void task5_1() {
        Set<Integer> coll1 = new HashSet<>();
        coll1.addAll(Arrays.asList(1, 4, 6));
        int sumCol1 = coll1.stream().mapToInt(item -> item.intValue()).sum();

        Set<Integer> coll2 = new HashSet<>();
        coll2.addAll(Arrays.asList(1, 3));
        int sumCol2 = coll2.stream().mapToInt(item -> item.intValue()).sum();

        if (sumCol1 > sumCol2) {
            System.out.println("Collection 1 > Collection 2");
        } else {
            System.out.println("Collection 1 < Collection 2");
        }
    }
}
