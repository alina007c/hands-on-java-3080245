package bank;

import javax.security.auth.login.LoginException;

public class Authenticator {

  public static Customer login (String username, String password) throws LoginException {

    Customer customer = DataSource.getCustomer(username);

    if (customer == null){
      throw new LoginException("username not found");
    }

    if password.equals(Customer.getPassword()) {
      customer.setAuthenticated(true);
      return customer;
    }
    else throw new LoginException("incorrect password");
    
    /*
     * Customer customer = DataSource.getCustomer(username);
     * 
     * if(customer != null && customer.getPassword().equals(password)){
     * return customer;
     * } else {
     * return null;
     * }
     * 
     * if (!customer.getPassword().equals(password)){
     * throw new LoginException("invalid password");
     * }
     */
  }

  public static void logout (Customer customer){
    // no action needed for a simple logout
    Customer.setAuthenticated(false);
  }

}
