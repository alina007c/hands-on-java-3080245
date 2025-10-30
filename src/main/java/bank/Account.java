package bank;

public class Account {

  private int id;
  private String type;
  private double balance;

  public Account (int id, String type, double balance){
    setId(id);
    setType(type);
    setBalance(balance);
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public float getBalance() {
    return this.balance;
  }

  public void setBalance(float balance) {
    this.balance = balance;
  }


}
