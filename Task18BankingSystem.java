class InsufficientFundsException extends Exception {

    public InsufficientFundsException(String message) {
        super(message);
    }
}

class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }

        balance += amount;
        System.out.println("Deposited: $" + amount);
    }

    public void withdraw(double amount)
            throws InsufficientFundsException {

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }

        if (amount > balance) {
            throw new InsufficientFundsException(
                    "Insufficient funds. Withdrawal not possible.");
        }

        balance -= amount;
        System.out.println("Withdrawn: $" + amount);
    }

    public void displayBalance() {
        System.out.println("Current Balance: $" + balance);
    }
}

public class Task18BankingSystem {
    public static void main(String[] args) {

        BankAccount account = new BankAccount(1000);

        try {
            account.deposit(500);
            account.withdraw(300);
            account.withdraw(2000);

        } catch (InsufficientFundsException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        account.displayBalance();
    }
}