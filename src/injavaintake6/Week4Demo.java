package injavaintake6;

import java.util.*;

public class Week4Demo {
    public static void launch() {
//        task1();
//        task2();
//        task3();
//        task4();
//        task5();
//        task5_1();
//        task6();
        week3Task6();
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

    public static void task6() {
        /**
         * Solution:
         * 1. Initialize numeric array with int data type
         * 2. Declare hash map
         * 3. Loop numeric array then assign value to hash map
         * 4. Display all values from hash map
         */
        int[] numericArray = {2, 3, 5, 10};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numericArray.length; i++) {
            map.put(numericArray[i], numericArray[i]);
        }

        map.forEach((key, value) -> {
            System.out.println("key = " + key + ", value = " + value);
        });
        map.get(4);
    }

    public static void week3Task6() {
        Scanner scanner = new Scanner(System.in);
//        String[] productNames = new String[50];
//        int[] quantities = new int[50];
//        double[] prices = new double[50];
//        Map<String, String> product = new HashMap<>();
//        product.put("name", "Milk");
//        product.put("quantity", "2");
//        product.put("price", "2.5");

        List<Map<String, String>> carts = new ArrayList<>();

        int index = 0;
        char answer = ' ';
        do {
            Map<String, String> product = new HashMap<>();

            System.out.print("\nProduct name: ");
            String name = scanner.nextLine();
            product.put("name", name);

            System.out.print("Quantity: ");
            int quantity = scanner.nextInt();
            product.put("quantity", quantity + "");

            System.out.print("Unit Price: ");
            double price = scanner.nextDouble();
            product.put("price", price + "");

            scanner.nextLine();
            System.out.print("\n==> Continue (press y|Y)? ");
            answer = scanner.nextLine().charAt(0);

            carts.add(product);
            index++;
        } while(answer == 'y' || answer == 'Y');

        System.out.println("\n========================================");
        System.out.println("Product Name Quantity Unit Price Total");

        double total = 0.0;
        for (int i = 0; i < carts.size(); i++) {
            Map<String, String> product = carts.get(i);
            int quantity = Integer.parseInt(product.get("quantity"));
            double price = Double.parseDouble(product.get("price"));
            double subTotal = quantity * price;
            System.out.println(product.get("name") + "        " + quantity + "     " + price + "   " + subTotal);
            total += subTotal;
        }

        System.out.println("\n========================================");
        System.out.println("                             Total = " + total);
    }
}
