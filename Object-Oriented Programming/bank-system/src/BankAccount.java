class BankAccount {
    protected String accountName;
    protected double accountBalance;

    public BankAccount(String accountName) {
        this.accountName = accountName;
        this.accountBalance = 0;
    }

    public void deposit(double amount) throws BankException {
        if (amount <= 0) {
            throw new BankException("The amount must be greater than 0.");
        }
        accountBalance += amount;
        System.out.println("Deposit successful! Current balance: " + accountBalance);
    }

    public void withdraw(double amount) throws BankException {
        if (amount <= 0) {
            throw new BankException("The amount must be greater than 0.");
        }
        if (amount > accountBalance) {
            throw new BankException("Insufficient balance.");
        }
        accountBalance -= amount;
        System.out.println("Withdraw successful! Current balance: " + accountBalance);
    }
}