package com.simple.account;

public class BankAccount implements Account{
	
	private int accountID;
	private String ownerName;
	private float balance;
	private static float interestRate;
	
	public BankAccount(int accountID, String ownerName, float balance) {
		super();
		this.accountID = accountID;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	

	public void deposit(float amount) {
		this.balance = this.balance + amount;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		if (balance > 0f) {
			this.balance = balance;
		} else {
			System.out.println("Error. Balance cannot be negative.");
		}
		
	}
	
	public static float getInterestRate() {
		return interestRate;
	}

	public static void setInterestRate(float interestRate) {
		BankAccount.interestRate = interestRate;
	}
	
	
	public void withdraw(float amount) throws InsufficientFundsException {
		if (amount > this.getBalance()) {
			throw new InsufficientFundsException(
					"Amount " + amount + " exceeds balance " + this.getBalance());
		}
		this.setBalance(this.getBalance() - amount);
	}
	
	
	public void print() {
		System.out.println("A Bank Account");
		System.out.printf("ID: %s\n", this.accountID);
		System.out.printf("Balance: %s\n", this.balance);
		System.out.printf("Owner: %s\n", this.ownerName);
		System.out.printf("Interest Rate: %s\n", BankAccount.interestRate);

	}


	@Override
	public String toString() {
		return "An account with id " + this.getAccountID() +
				" with balance " + this.getBalance() +
				" owned by " + this.getOwnerName() + ".";
	}
	
	
	
	

}
