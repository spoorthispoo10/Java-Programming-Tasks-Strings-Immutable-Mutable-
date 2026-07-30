class BankAccount {

    private int balance = 1000;

    public synchronized void deposit(int amount) {

        balance += amount;

        System.out.println(
                Thread.currentThread().getName()
                        + " deposited $" + amount);

        System.out.println("Balance: $" + balance);
    }

    public synchronized void withdraw(int amount) {

        if (balance >= amount) {

            balance -= amount;

            System.out.println(
                    Thread.currentThread().getName()
                            + " withdrew $" + amount);

            System.out.println("Balance: $" + balance);

        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

class DepositThread extends Thread {

    private BankAccount account;

    public DepositThread(BankAccount account) {
        this.account = account;
    }

    public void run() {
        account.deposit(500);
    }
}

class WithdrawThread extends Thread {

    private BankAccount account;

    public WithdrawThread(BankAccount account) {
        this.account = account;
    }

    public void run() {
        account.withdraw(300);
    }
}

public class Task24ThreadSynchronization {

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        Thread deposit = new DepositThread(account);
        Thread withdraw = new WithdrawThread(account);

        deposit.start();
        withdraw.start();
    }
}