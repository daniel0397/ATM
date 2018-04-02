//Daniel Smith 15075097
public class ATM extends Thread {
	
	Account balance;
	Account account;
	
	public ATM(Account a){
		account = a;
	}
	
	public void run() {
		//randomise transactions in order to test the program
		for (int i = 0; i < 20; i++) { 
			if (Math.random() > 0.5) {		
				account.withdraw((int)(Math.random()*10));
			} 
			else {
				account.deposit((int)(Math.random()*10));
			}
			try {
				sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//prints out what threads have finished  being used 
        System.out.println("Thread "+getId()+" Completed");
	}

}
