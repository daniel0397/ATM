//Daniel Smith 15075097
public class Account {
private int balance;

	
    public Account(int number) {
    	balance = number;
    }
    
    public int getBalance() {
        return balance;
    }
    
    public synchronized void withdraw(int amount) {
    		//the cardholder can only withdraw as much money as there is in the account
            while (amount > balance) {
            	try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
            }
            
            //take away the amount from the balance and add the transaction to the bank statement
            balance = balance - amount;
            Controller.transaction++;
            Controller.statement.add(Controller.transaction+"(" + Thread.currentThread().getId() + ")" + "\t\t   £"  + amount + "\t\t\t\t£" + getBalance());              
		}
                  
    public synchronized void deposit(int amount) {
        //add the amount to the balance and add the transaction to the bank statement 
    	balance = balance + amount;
    	Controller.transaction++;
    	Controller.statement.add(Controller.transaction +"(" + Thread.currentThread().getId() +")" +  "\t\t\t\t £"+ amount + "\t\t£" + getBalance());
        notifyAll();
    }
}
