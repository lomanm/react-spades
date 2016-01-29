import java.io.*;
import java.util.Scanner;

/* Business Expense Report - prompt the user to enter
 * expenses, amounts and dates, then output the data
 * to a file expenses.txt
 */
public class expenseMain {

	public static void main(String[] args) throws IOException {
				
		// initialize variables
		String promptE;	// expense
		String promptA;	// amount
		String promptD;	// date
		String promptU;	// user name
		String cont = "";	// continue (answer)
		Scanner s = new Scanner(System.in);	// scanner variable
		boolean loop = true;	// loop variable
		
		while (loop) {
			System.out.println("Would you like to enter an expense (Y/N)?");
			cont = s.nextLine();
			cont = cont.toUpperCase();
			if (!cont.equals("Y")) {
				loop = false;
				continue;
			}
				
			System.out.println("Enter expense: ");
			promptE = s.nextLine();
			System.out.println("Enter amount:  ");
			promptA = s.nextLine();
			System.out.println("Enter date:    ");
			promptD = s.nextLine();
			System.out.println("Your name:    ");
			promptU = s.nextLine();
			Expense expense = new Expense(promptE, promptA, promptD, promptU);
			
			// check for existence of expenses.txt, create it if not found
			// if it is found open it for appending
			String fileName = "Expenses.txt";
			File f = new File(fileName);
			boolean fAlive = false;
			if (f.exists()) {
				fAlive = true;
			}
			FileOutputStream fout = new FileOutputStream(fileName,fAlive);
			ObjectOutputStream oout = new ObjectOutputStream(fout);	
			// write information out to the file
			oout.writeObject(expense);
			fout.flush();
			fout.close();
			
			// now open the file and read the 
			try {
				FileInputStream file = new FileInputStream(fileName);
				ObjectInputStream oin = new ObjectInputStream(file);
				Expense exp = (Expense) oin.readObject();
				System.out.println(exp.expString());
				oin.close();
				file.close();
			} catch(IOException e)  {
			} catch(ClassNotFoundException e)  {	
			} finally{
			}
		}
		s.close();
	}
}
