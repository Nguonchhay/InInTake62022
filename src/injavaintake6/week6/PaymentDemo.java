package injavaintake6.week6;

public class PaymentDemo {
    public static void launch() {
        PaymentForm paymentForm = new PaymentForm();
        paymentForm.initTransactions();
        paymentForm.displayTransactions();

        // 2. Display number transaction via ABA
        System.out.println("\n Total paid by ABA = " + paymentForm.countAba());

        // 3. Display all transactions sort by total price descending
        paymentForm.sortTransactions();
    }
}
