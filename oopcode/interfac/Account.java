package interfac;

public interface Account {
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
}

class SavingAcc implements Account{
    double balance;
    int interest;

    @Override
    public void deposit(double amount) {
        balance+=amount;
    }

    @Override
    public void withdraw(double amount) {
        if(amount>0){
        balance-=amount;}
        else {
            System.out.println("insufficient balance");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }
}