package Chapter2.lesson2;


public class Main {
	public static void main(String[]args){
		Account account = new Account();
		account.setBalance(0);
		
		Bank bank = new Bank(account);
		Company company = new Company(account);
		
		Thread backThread = new Thread(bank);
		Thread companyThread = new Thread(company);
		
		System.out.printf("Account: Initial Banlance: %f\n", account.getBalance());
		backThread.start();
		companyThread.start();
		
		try {
			backThread.join();
			companyThread.join();
			System.out.printf("Account: Final Banlance: %f\n", account.getBalance());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
