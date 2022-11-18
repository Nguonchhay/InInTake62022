package injavaintake6.week6_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Week6Demo {
    public static void launch() {
//        week3Task6();
        PaymentDemo.launch();
    }

    public static void week3Task6() {
        Scanner scanner = new Scanner(System.in);
        List<Product> carts = new ArrayList<>();
        char answer = ' ';
        do {
            Product product = new Product();

            System.out.print("\nProduct name: ");
            String name = scanner.nextLine();
            product.setName(name);

            System.out.print("Quantity: ");
            int quantity = scanner.nextInt();
            product.setQuantity(quantity);

            System.out.print("Unit Price: ");
            double price = scanner.nextDouble();
            product.setPrice(price);

            scanner.nextLine();
            System.out.print("\n==> Continue (press y|Y)? ");
            answer = scanner.nextLine().charAt(0);

            carts.add(product);
        } while(answer == 'y' || answer == 'Y');

        System.out.println("\n========================================");
        System.out.println("Product Name Quantity Unit Price Total");

        double total = 0.0;
        for (int i = 0; i < carts.size(); i++) {
            Product product = carts.get(i);
            double subTotal = product.getTotal();
            product.printInConsole();
            total += subTotal;
        }

        System.out.println("\n========================================");
        System.out.println("                             Total = " + total);
    }
}
