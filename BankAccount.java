import javax.swing.JOptionPane;
import java.util.Random;
import java.util.*;
public class BankAccount{
	
	private double accountBalance; // creating private attribute accountBalance
	private String accountName; // creating private attribute accountName
	private int accountNumber; // creating private attribute accountNumber
	public String last_withdrawal; // creating private attribute that will record last withdrawal
	
	BankAccount(){
		accountBalance = 0;
		accountName = "";
		Random rand = new Random();
		accountNumber = rand.nextInt((968984-456788)+1)+456788; //I decided to generate random account numbers between 456788 and 968984 
	}
	
	BankAccount(String _accountName){
		accountName = _accountName;
		Random rand = new Random(); // Instantiate random account number
		accountNumber = rand.nextInt((968984-456788)+1)+456788; // same as previous comment on account Number
	}
	
	BankAccount(int _accountNumber, double _accountBalance){ // In this constructor I only accept the accountNumber and accountBalance as parameters
		accountNumber = _accountNumber;
		accountBalance = _accountBalance;
	}
	
	BankAccount(int _accountNumber, String _accountName){  //In this constructor I only accept the account Number and accountBalance
		accountNumber = _accountNumber;
		accountName = _accountName;
	}
	
	BankAccount(String _accountName, double _accountBalance, int _accountNumber){ // In this constructor I accept 3 parameters 
		accountBalance = _accountBalance; 
		accountName = _accountName;
		accountNumber = _accountNumber;
	}
	
	public String getAccountName(){ // Accessor method to access AccountName
		return accountName;
	} 
	
	public int getAccountNumber(){
		return accountNumber;
	}
	
	public double getAccountBalance(){
		return accountBalance;
	}
	
	public String getLastWithdrawal(){ // This function retrieves the most recent withdrawal
		return last_withdrawal;
	}
	public void setAccountName(String _accountName){
		accountName = _accountName;
	}
	
	public void setAccountNumber(int _accountNumber){
		accountNumber = _accountNumber; 
	}
	
	
	public void Deposit(double amount){ // This function deposits money into a specific account 
		accountBalance  = accountBalance + amount - 5; 
		JOptionPane.showMessageDialog(null,	amount + " has been deposited in your account " + accountNumber);
	}
	
	public void Withdrawal(double amount, String sdate){ // This function withdraws money into a specific account 
		if (amount <= accountBalance){
			accountBalance = accountBalance - amount - 5;
			JOptionPane.showMessageDialog(null,amount + "has been withdrawn from your account " + accountNumber);
			JOptionPane.showMessageDialog(null,"your current balance is now "+accountBalance);
		}
		else{
			JOptionPane.showMessageDialog(null,"You have insufficient funds to perform this transaction","Error",JOptionPane.ERROR_MESSAGE);
		}
		last_withdrawal = sdate;
	}
	public String toString(){ //To string method to put everything in one line
		return "Account Name: "+accountName+ "Account Number: "+accountNumber+ "Account Balance: "+accountBalance;
	}
	
	public BankAccount myClone(){
		BankAccount another = new BankAccount();
		another.accountName = this.accountName;
		another.accountBalance = this.accountBalance;
		another.accountNumber = this.accountNumber;
		another.last_withdrawal = this.last_withdrawal;
		return another;
	}
	public static void main(String[] args){
		BankAccount test = new BankAccount("MP TJEGE"); //This is to test the class using one of the constructors
		test.Deposit(5000); // Random deposit made to test function
	}
}