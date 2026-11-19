import java.util.Scanner;

class ATM{
    public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        int pin=1234;
        int attempts=0;
        boolean loggedIn=false;
        double balance=1000;
        String history[]=new String[100];
        int count=0;
        int choice;

        while(attempts<3 && !loggedIn){
            System.out.print("Enter your PIN: ");
            int enteredPin=input.nextInt();
            if(enteredPin==pin){
                loggedIn=true;
            }
            else{
                attempts++;
                System.out.println("Wrong PIN. Attempts left: "+(3-attempts));
            }
        }

        if(!loggedIn){
            System.out.println("Too many wrong attempts. Card blocked.");
            return;
        }

        do{
            System.out.println("\n====ATM MENU====");
            System.out.println("1. Check balance");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. View transactions");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice=input.nextInt();

            if(choice==1){
                System.out.println("Your balance is "+balance);
            }
            else if(choice==2){
                System.out.print("Enter amount to deposit: ");
                double amount=input.nextDouble();
                if(amount>0 && count<100){
                    balance=balance+amount;
                    history[count]="Deposit: "+amount;
                    count++;
                    System.out.println("Deposit successful");
                }
                else{
                    System.out.println("Invalid amount");
                }
            }
            else if(choice==3){
                System.out.print("Enter amount to withdraw: ");
                double amount=input.nextDouble();
                if(amount<=0 || count>=100){
                    System.out.println("Invalid amount");
                }
                else if(amount>balance){
                    System.out.println("Not enough money in your account");
                }
                else{
                    balance=balance-amount;
                    history[count]="Withdraw: "+amount;
                    count++;
                    System.out.println("Withdrawal successful");
                }
            }
            else if(choice==4){
                if(count==0){
                    System.out.println("No transactions yet");
                }
                else{
                    System.out.println("====TRANSACTIONS====");
                    for(int i=0; i<count; i++){
                        System.out.println((i+1)+". "+history[i]);
                    }
                }
            }
            else if(choice==5){
                System.out.println("Thank you for using our ATM");
            }
            else{
                System.out.println("Wrong option, try again");
            }
        }while(choice!=5);
    }
}