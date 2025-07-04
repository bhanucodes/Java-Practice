import java.util.ArrayList;

abstract class Account{
    abstract double getBalance();
}

class SavingsAccount extends Account{
    private double fixedDeposit;

    SavingsAccount(double fixedDeposit){
        this.fixedDeposit=fixedDeposit;
    }

    @Override
    double getBalance() {
        return fixedDeposit;
    }
}

class CurrentAccount extends Account{
    private double cashCredit;

    CurrentAccount(double cashCredit){
        this.cashCredit = cashCredit;
    }

    @Override
    double getBalance() {
        return cashCredit;
    }

}

public class P2 {
    public static void main(String[] args) {
        ArrayList <Account> accounts = new ArrayList<>();

        accounts.add(new CurrentAccount(500000));
        accounts.add(new CurrentAccount(600000));
        accounts.add(new CurrentAccount(700000));
        accounts.add(new CurrentAccount(800000));
        

        double totalBalance = 0;
        for (Account account : accounts) {
            totalBalance += account.getBalance();            
        }
        System.out.println("Total Cash in Bank: "+ totalBalance);
    }
}
