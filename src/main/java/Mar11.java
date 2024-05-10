public class Mar11 {
    public static void main(String[] args){
        //System.out.println("working");
        BankAccount savingsAccount = new SavingsAccount(300, 1.25);
        System.out.println();
        BankAccount currentAccount = new CurrentAccount(500);
        System.out.println();

        savingsAccount.deposit(100);
        currentAccount.deposit(500);
        savingsAccount.withdraw(150);
        System.out.println();

        savingsAccount.viewBalance();
        currentAccount.viewBalance();
        System.out.println();


    }
}

abstract class BankAccount{
    public double balance = 0;
    abstract void deposit(double amount);
    abstract void withdraw(double amount);
    abstract void viewBalance();
}

class SavingsAccount extends BankAccount{
    double interestRate;
    SavingsAccount(double initialDeposit, double interestRate){
        this.balance = initialDeposit;
        this.interestRate = interestRate;
        System.out.println("Account type: Saving");
        System.out.println("Initial Deposit: " + initialDeposit);
        System.out.println("Interest Rate: " + interestRate + "%");
    }
    void deposit(double amount){
        this.balance += amount;
        System.out.printf("Deposited %.2f", amount);
        System.out.println(" to Savings account\nNew Balance: " + balance);
    }
    void withdraw(double amount){
        this.balance -= amount;
        System.out.printf("Cash out %.2f", amount);
        System.out.println(" From Savings account\nNew Balance: " + balance);
    }
    void calculateInterest(int year){
        System.out.println("After applying interest rate for " + year + ": ");
        System.out.print((Math.pow((1 + interestRate / 100), year)));
        System.out.println();
    }
    void viewBalance(){
        System.out.printf("Current Balance: %.2f%n", balance);
    }
}

class CurrentAccount extends BankAccount{

    CurrentAccount(double initialDeposit){
        this.balance = initialDeposit;
        System.out.println("Account type: Current");
        System.out.println("Initial Deposit: " + initialDeposit);
        System.out.println("OverDraftLimit: $1000");
    }
    void deposit(double amount){
        this.balance += amount;
        System.out.printf("Deposited %.2f", amount);
        System.out.println(" to current account\nNew Balance: " + balance);
    }
    void withdraw(double amount){
        this.balance -= amount;
        System.out.printf("Cash out %.2f", amount);
        System.out.println(" From current account\nNew Balance: " + balance);
    }
    void viewBalance(){
        System.out.printf("Current Balance: %.2f%n", balance);
    }
}
