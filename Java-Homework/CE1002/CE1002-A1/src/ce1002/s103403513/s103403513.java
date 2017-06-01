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
			System.out.printf("目前總和為：%.01f\n",total);
			System.out.printf("請輸入欲執行之操作(+,-,*,/,exit):\n");
			operation = in.next();
			// if detect exit , break out
			if(operation.equals("exit")){
				System.out.print("Bye!");
				break;
			}
			// if not we continue to process
			System.out.println("請輸入與總和進行操作之數值：");
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
