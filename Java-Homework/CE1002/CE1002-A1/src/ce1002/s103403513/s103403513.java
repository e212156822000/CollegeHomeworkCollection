package ce1002.s103403513;
import java.util.*;

public class s103403513 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		double total = 0;
		String operation = "";
		double number = 0;
		do{
			System.out.printf("�ثe�`�M���G%.01f\n",total);
			System.out.printf("�п�J�����椧�ާ@(+,-,*,/,exit):\n");
			operation = in.next();
			// if detect exit , break out
			if(operation.equals("exit")){
				System.out.print("Bye!");
				break;
			}
			// if not we continue to process
			System.out.println("�п�J�P�`�M�i��ާ@���ƭȡG");
			number = Double.parseDouble(in.next());
			
			if(operation.equals("+")){
				total += number;
			}else if(operation.equals("-")){
				total -= number;
			}else if(operation.equals("*")){
				total *= number;
			}else {
				total /= number;
			}			
			//to initialize input for next loop
			operation = "";
			number = 0;
		}while(!operation.equals("exit"));
	}
}
