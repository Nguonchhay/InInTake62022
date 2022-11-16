package injavaintake6.week6;

import java.util.ArrayList;
import java.util.List;

public class PaymentForm {
    List<Object> transactions = new ArrayList<>();

    public void initTransactions() {
        transactions.add(new Aba(5.5));
        transactions.add(new Wing(10.0));
        transactions.add(new Acleda(7.5));
        transactions.add(new Aba(3.5));
        transactions.add(new Aba(15.5));
        transactions.add(new Wing(8.5));
    }

    public void displayTransactions() {
        System.out.println("\nAll Transactions:");
        transactions.forEach(transaction -> {
            if (transaction instanceof Aba) {
                ((Aba) transaction).pay();
            } else if (transaction instanceof Wing) {
                ((Wing) transaction).transfer();
            } else if (transaction instanceof Acleda) {
                ((Acleda) transaction).pay();
            }
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
                double amountI = 0;
                Object transactionI = transactions.get(i);
                if (transactionI instanceof Aba) {
                    amountI = ((Aba) transactionI).getAmount();
                } else if (transactionI instanceof Wing) {
                    amountI = ((Wing) transactionI).getFee();
                } else if (transactionI instanceof Acleda) {
                    amountI = ((Acleda) transactionI).getAmount();
                }

                Object transactionK = transactions.get(k);
                double amountK = 0;
                if (transactionK instanceof Aba) {
                    amountK = ((Aba) transactionK).getAmount();
                } else if (transactionK instanceof Wing) {
                    amountK = ((Wing) transactionK).getFee();
                } else if (transactionK instanceof Acleda) {
                    amountK = ((Acleda) transactionK).getAmount();
                }

                if (amountI < amountK) {
                    Object temp = transactions.get(i);
                    transactions.set(i, transactions.get(k));
                    transactions.set(k, temp);
                }
            }
        }

        displayTransactions();
    }
}
