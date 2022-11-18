package injavaintake6.week6_1;

import java.util.ArrayList;
import java.util.List;

public class PaymentForm {
    List<AbstractBank> transactions = new ArrayList<>();

    public void initTransactions() {
        transactions.add(new Aba(5.5));
        transactions.add(new Wing(10.0));
        transactions.add(new Acleda(7.5));
        transactions.add(new Aba(3.5));
        transactions.add(new Prince(4.0));
        transactions.add(new Aba(15.5));
        transactions.add(new Wing(8.5));
    }

    public void displayTransactions() {
        System.out.println("\nAll Transactions:");
        transactions.forEach(transaction -> {
            transaction.pay();
        });
    }

    public int countAba() {
        int count = 0;
        for (int i = 0; i < transactions.size(); i++) {
            if (transactions.get(i) instanceof Aba) {
                count++;
            }
        }
        return count;
    }

    public void sortTransactions() {
        int count = transactions.size();
        for (int i = 0; i < count - 1; i++) {
            for (int k = i + 1; k < count; k++) {
                double amountI = transactions.get(i).getAmount();
                double amountK = transactions.get(k).getAmount();
                if (amountI < amountK) {
                    AbstractBank temp = transactions.get(i);
                    transactions.set(i, transactions.get(k));
                    transactions.set(k, temp);
                }
            }
        }

        displayTransactions();
    }
}
