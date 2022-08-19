package Problem_Statement;

import java.util.Scanner;

class InsufficientBalanceException extends Exception{
    InsufficientBalanceException(){
        System.out.println(" :: Insufficient balance !!! ");
    }
}
class AccountNotPresentException extends Exception{
    AccountNotPresentException()
    {
        System.out.println("Invalid Account Number");
    }
}
class Bank
{
    static int balance;
    private String name;
    String address;
    String email_Id;
    String account_type;
     long Account_no;
    public void account_Details(String name,String address,String email_Id,String account_type)
    {
       this.name=name;
       this.address=address;
       this.email_Id=email_Id;
       this.account_type=account_type;
        long min=1000000000;
        long max=999999999;
        Account_no=(long)Math.random()*(max-min+1)+min;
        System.out.println("Your Account Number is"+Account_no);
    }
    public void deposit_Amount(long account_number,int amount)
    {
               balance=balance+amount;
        System.out.println("The Amount is"+amount+":added to your account"+ "\nCurrent Balance is  "+balance);
    }
    public void withdrawAmount(long account_number,int withdrawAmount)
    {
        if(withdrawAmount>balance)
        {
            try
            {
                throw new InsufficientBalanceException();
            }
            catch(InsufficientBalanceException e)
            {
                e.printStackTrace();
            }
        }
        else {
            balance=balance-withdrawAmount;
            System.out.println("Balance left in your Account " +balance);
        }
    }
    public void display()
    {
        System.out.println("Your name is: "+name);
        System.out.println("Your address is: "+address);
        System.out.println("Your email Id is :"+email_Id);
        System.out.println("Your account type is: "+account_type);

    }

}
public class Bank_Details {
    public static void main(String[] args) {
        Bank bank=new Bank();
        int transaction_type = 15;
        Scanner sc=new Scanner(System.in);

        while(transaction_type != 0)

        {
            System.out.println("Which type of transaction you want to perform \n"+
                    "Enter 0 for Exit & Enter 1 for Account_Type & Enter 2 for Deposit & Enter 3 for Withdraw & " +
                    "Enter 4 for Account_Details " + ":\")");
            transaction_type=sc.nextInt();
            switch(transaction_type)
            {
                case 0:
                    System.out.println("Exit!!!");
                    transaction_type = 0;
                    break;
                case 1:
                    System.out.println("Your account details is \n");
                    String name=sc.next();
                    String address=sc.next();
                    String email_Id=sc.next();
                    String account_type=sc.next();
                    bank.account_Details(name,address,email_Id,account_type);
                    bank.display();
                    break;
                case 2:
                    System.out.println("Enter your deposit amount");
                    bank.deposit_Amount(bank.Account_no,sc.nextInt());
                    break;
                case 3:
                    System.out.println("Enter your withdrawl amount");
                    bank.withdrawAmount(bank.Account_no, sc.nextInt());
                    break;
                case 4:
                    System.out.println("Your Bank Details is \n");
                    bank.display();
                    break;
            }
        }
    }
}
