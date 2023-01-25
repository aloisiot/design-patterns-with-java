package br.com.cod3r.proxy.bank.services;

public class ATM implements BankOperations {
    private final BankOperations bank;

    public ATM(BankOperations bank) {
        this.bank = bank;
    }

    @Override
    public void deposit(Long account, Long amount) {
        System.out.println("ATM proxy sending request to bank");
        bank.deposit(account, amount);
    }

    @Override
    public void withdraw(Long account, String passwd, Long amount) {
        if(amount > 300) {
            System.out.println("You mey not withdrow amounts over 300 here");
        } else {
            System.out.println("ATM proxy sending request to bank");
            bank.withdraw(account, passwd, amount);
        }
    }

    @Override
    public void changePassword(Long account, String oldPassword, String newPassword) {
        System.out.println("You must go to the back to perform this operation");
    }
}
