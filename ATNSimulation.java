import java.util.Scanner;
class BankAccount
{
    private double balance;

    public BankAccount(double initialBalance) 
    {
        this.balance = initialBalance;
    }

    // Method to get the current balance
    public double getBalance()
    {
        return balance;
    }
    public void deposit(double amount)
    {
        if (amount > 0)
        {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
        } 
        else
        {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    public boolean withdraw(double amount) 
    {
        if (amount > 0 && amount <= balance) 
        {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
            return true;
        }
         else if (amount > balance)
        {
            System.out.println("Insufficient balance.");
            return false;
        }
         else
        {
            System.out.println("Invalid withdrawal amount.");
            return false;
        }
    }
}

class ATM 
{
    private BankAccount account;

    public ATM(BankAccount account)
    {
        this.account = account;
    }
    public void displayMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do 
        {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice)
           {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 4);

        sc.close();
    }

    // Method to check balance
    private void checkBalance()
    {
        System.out.println("Current balance: $" + account.getBalance());
    }

    // Method to deposit money
    private void depositMoney()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter deposit amount: $");
        double amount = sc.nextDouble();
        account.deposit(amount);
    }

    // Method to withdraw money
    private void withdrawMoney()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter withdrawal amount: $");
        double amount = sc.nextDouble();
        account.withdraw(amount);
    }
}
public class ATNSimulation 
{
    public static void main(String[] args)
    {
        BankAccount account = new BankAccount(1000.00);
        ATM atm = new ATM(account);
        atm.displayMenu();
    }
}

