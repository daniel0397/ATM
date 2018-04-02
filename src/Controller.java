//Daniel Smith 15075097

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Controller {
		public static List<String> statement = new ArrayList<String>(); 
		public static int transaction; 

	    public static void main(String[] args) {
	    	Scanner input = new Scanner(System.in);
	    	
	    	//user inputs amount of card holders and start balance
	    	System.out.println("Enter amount of cards");
	    	int amount = input.nextInt();
	    	System.out.println("Enter card start balance");
	    	int balance = input.nextInt();
	    	
	    	if(amount < 1){
	    		System.out.println("Error: Invalid number of access cards");
	    		System.exit(1);
	    	}
	    	else if(balance < 1){
	    		System.out.println("Error: Invalid start balance");
	    		System.exit(1);
	    	}
	    	
	    	//Call account and atm class with the values inputed by the user
	    	Account a = new Account(balance);
	        ATM[] cards= new ATM[amount];
	        
	        // create a loop to produce the amount of cards listed by the user
	        for (int i=1; i <= amount; i++) {
	        	cards[i-1] = new ATM(a);
	        	cards[i-1].start(); 
	        }
	        
	        // create a loop to join the cards
	        for (int i=1; i <= amount; i++) {        	
	        	try {
					cards[i-1].join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
	        }        
	  
	        System.out.println("\t\t***TRANSACTION STATEMENT***");
	        System.out.println("Transaction\tWithdrawral\tDeposit\t\tBalance");
	        System.out.println("\t\t\t\t\t\t£" + balance);
	        
	       //print the bank statement for the account
	       for (int i = 0 ; i < statement.size(); i++){
	    	   System.out.println(statement.get(i));
	       }

	    }

	}

