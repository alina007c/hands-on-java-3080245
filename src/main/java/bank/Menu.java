package bank;

import java.util.Scanner;

import javax.security.auth.login.LoginException;

public class Menu {

  private Scanner scanner;

  public static void main(String[] args) {
    System.out.println("Welcome to the Bank Application!");
    Menu menu = new Menu();
    menu.scanner = new Scanner(System.in);

    Customer customer = menu.authenticateUser();
    if (customer != null){
      Account account = DataSource.getAccount(customer.getAccountId());
      menu.showMenu(customer, account);
    }

    menu.scanner.close();
  }


  private Customer authenticateUser(){
    System.out.print("Please enter your username: ");
    String username = scanner.next();
    
    System.out.print("Please enter your password: ");
    String password = scanner.next();

    Customer customer = null;
    try{
      customer = Authenticator.login(username, password);
    } catch (LoginException e){
      System.out.println("There was an error: " + e.getMessage());
    }

   return customer;
  }

private void showMenu(Customer customer, Account account){
    int selection =0;
    while (selection != 4 && customer.isAuthenticated(){
      System.out.println("------------------------------------------");
      System.out.println("Please enter one of the following options: ");
      System.out.println("1. Deposit");
      System.out.println("2. Withdraw Funds");
      System.out.println("3. Check Balance");
      System.out.println("4. Exit");
      System.out.println("------------------------------------------");
      
      selection = scanner.nextInt();

      double amount = 0;  

      switch (selection){
        case 1:
          System.out.println("How much whould you like to deposit?");
          amount = scanner.nextDouble();
          account.deposit(amount);
          break;

        case 2:
          System.out.println("How much whould you like to withdraw?"); 
          amount = scanner.nextDouble();
          account.withdraw(amount);
          break;

        case 3:
          System.out.println("Current balance: " + account.getBalance());
          break;

        case 4:
          Authenticator.logout(customer);
        System.out.println("Thank you for using the Bank Application. Goodbye!");
          break;

        default:
          System.out.println("Invalid option. Please try again:).");
          break;
      }
    })
  }

  /*
   * private void showMenu(Customer customer, Account account){
   * int choice = -1;
   * while (choice != 0){
   * System.out.println("\nMenu:");
   * System.out.println("1. View Balance");
   * System.out.println("2. Deposit Funds");
   * System.out.println("3. Withdraw Funds");
   * System.out.println("0. Exit");
   * System.out.print("Please enter your choice: ");
   * choice = scanner.nextInt();
   * 
   * switch (choice){
   * case 1:
   * System.out.printf("Your current balance is: $%.2f%n", account.getBalance());
   * break;
   * case 2:
   * System.out.print("Enter amount to deposit: ");
   * double depositAmount = scanner.nextDouble();
   * account.deposit(depositAmount);
   * System.out.printf("Successfully deposited $%.2f%n", depositAmount);
   * break;
   * case 3:
   * System.out.print("Enter amount to withdraw: ");
   * double withdrawAmount = scanner.nextDouble();
   * if (account.withdraw(withdrawAmount)){
   * System.out.printf("Successfully withdrew $%.2f%n", withdrawAmount);
   * } else {
   * System.out.println("Insufficient funds for this withdrawal.");
   * }
   * break;
   * case 0:
   * System.out.println("Thank you for using the Bank Application. Goodbye!");
   * break;
   * default:
   * System.out.println("Invalid choice. Please try again.");
   * }
   * }
   * }
   */
}
