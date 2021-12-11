package Model.Users;

public class Wallet {
    double balance;

    public Wallet(double balance) {
        this.balance = balance;
    }

    public double checkBalance(){
        return this.balance;
    }

    public void addMoney(double amount){
        this.balance += amount;
    }

    public void deduceMoney(double amount){
        this.balance -= amount;
    }
}
