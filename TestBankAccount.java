import javax.swing.JOptionPane;
import java.util.*; 
import java.util.Random;
import java.util.ArrayList;
public class TestBankAccount extends BankAccount{
	public static void main(String[] args){
		ArrayList<String> optionList = new ArrayList<String>(); //List to store options. 
		optionList.add("1. Create an account"); //Option 1
		optionList.add("2. Deposit an ammount"); //Option 2
		optionList.add("3. Withdraw from account"); //Option 3
		optionList.add("4. Display the balance of an account"); //Option 4
		optionList.add("5. Quit"); //Option 5 
		Object[] options = optionList.toArray(); //Convert array list to type array 
		BankAccount [] accounts = new BankAccount[20];
		while (true){ // Menu will pop up until user decides to quit
		Object value = JOptionPane.showInputDialog(null, //Ask user to choose transaction
											   "How can we help you today?",
											   "Tranactions",
											   JOptionPane.QUESTION_MESSAGE, //Drop Down Bounds
											   null,
											   options,
											   options[0]);
		int selection = optionList.indexOf(value); //This retrieves the users choice of action
		
		switch(selection){ // This statement is used to execute instructions according to user choice
			case 0:
				String sAccountName = JOptionPane.showInputDialog("Please enter account name");
				String sAccountNumber = JOptionPane.showInputDialog("Please enter account number");
				int iAccountNumber = Integer.parseInt(sAccountNumber);
				for (int i = 0; i < accounts.length ; i++){
					if ((accounts[i] != null)){
						BankAccount temp = accounts[i];
							while ((temp.getAccountName() == sAccountName) || (temp.getAccountNumber() == iAccountNumber)){
							JOptionPane.showMessageDialog(null,"This account already exists");
							sAccountName = JOptionPane.showInputDialog("Please enter account name");
							sAccountNumber = JOptionPane.showInputDialog("Please enter account number");
							iAccountNumber = Integer.parseInt(sAccountNumber);
							}
					}	
				}
				for (int j = 0; j < accounts.length; j++){
					if ((accounts[j] == null)){
						BankAccount create = new BankAccount(iAccountNumber,sAccountName);
						accounts[j] = create;
						JOptionPane.showMessageDialog(null,"Account created!!");
						break;
					}
				}
				
				break;
			case 1:
				int count = 0; // This is to check if an account exists
				sAccountNumber = JOptionPane.showInputDialog("Please enter account number");
				iAccountNumber = Integer.parseInt(sAccountNumber);
				for (int i = 0; i < accounts.length; i++){
						if ((accounts[i] != null)){
							BankAccount temp = accounts[i];
							if ((temp.getAccountNumber() == iAccountNumber)){
								String sAmount = JOptionPane.showInputDialog("Please enter the amount you want to deposit");
								double Amount = Double.parseDouble(sAmount);
								while (Amount <= 0 ){
										sAmount = JOptionPane.showInputDialog("Please enter a valid amount! No less than 1 rand");
										Amount = Double.parseDouble(sAmount);
								}
								temp.Deposit(Amount);
							}
							else{
								count = count + 1;
							}
						}
			
				}
				if (count >= 19){
					JOptionPane.showMessageDialog(null,"This Account does not exist");
				}
				break;
			case 2:
				count = 0; // This is to check if an account exists
				sAccountNumber = JOptionPane.showInputDialog("Please enter account number");
				iAccountNumber = Integer.parseInt(sAccountNumber);
				for (int i = 0; i < accounts.length; i++){  // Check if there is an account and then compare
						if ((accounts[i] != null)){
							BankAccount temp = accounts[i];
							if ((temp.getAccountNumber() == iAccountNumber)){ //Comparison is done here
								String sAmount = JOptionPane.showInputDialog("Please enter the amount you want to withdraw");
								double Amount = Double.parseDouble(sAmount);
								while ((Amount+5) > temp.getAccountBalance()){
										sAmount = JOptionPane.showInputDialog("You have insufficient funds to withdraw soo much. You ain't a baller bra");
										Amount = Double.parseDouble(sAmount);
								}
								Date date = new Date();
								temp.Withdrawal(Amount,date.toString());;
							}
							else{
								count = count + 1;
							}
						}
			
				}
				if (count >= 19){
					JOptionPane.showMessageDialog(null,"This Account does not exist");
				}
				break;
			case 3:
				for (int j  = 0; j<accounts.length-1;j++){ // Sort the accounts according to smallest account number to highest
					for (int k = j+1; k < accounts.length; k++){
					if (accounts[k] != null){
						if (accounts[j].getAccountNumber() > accounts[k].getAccountNumber()){
							BankAccount tempo = accounts[j];
							accounts[j] = accounts[k];
							accounts[k] = tempo;
						}
					}
					else
						break;
					}
				}
				for (int d = 0; d<accounts.length;d++){ // Show all accounts balance alongside most recent withdrawal
					if (accounts[d] != null){
						BankAccount tempo = accounts[d];
						JOptionPane.showMessageDialog(null,"Accout Balance: "+tempo.getAccountBalance() + "Account Number: "+tempo.getAccountNumber()+"Most recent withdrawal "+tempo.getLastWithdrawal()) ;
					}
				}
				break;
			case 4:
				for (int d = 0; d<accounts.length;d++){ // Display all accounts balances and then terminate program
					if (accounts[d] != null){
						BankAccount tempo = accounts[d];
						JOptionPane.showMessageDialog(null,"Account Number: "+tempo.getAccountNumber()+" Account Balance: "+tempo.getAccountBalance());				
					}
				}
				System.exit(0);
			}
		}	
	}
}