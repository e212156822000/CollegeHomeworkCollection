/***********************************************************
輸入數學式子如：2+3、4*7 等等兩個數字且不含括號的運算。
該程式會吐出 正確的解答，且具有先乘除後加減的基本特性。
**********************************************************/

import java.io.*;//BufferedReader

class calculator{
	private String MathF;//Mathematical Forms
	private int Num[]=new int[2];//left number, right number
	private char MathSymbol;//Math Symbol
	private int result = 0;
	//constructor -> save user's Mathematical Forms
	public calculator(String F){
		MathF = F;
	}
	
	int GetAns(){//result
		 different();
		 result = compute();
		 return result;
	}
	
	int compute(){// compute answer
		switch(MathSymbol){
			case '+':	return Add();
			case '-':	return Sub();
			case '*':	return Mul();
			case '/':	return Div();
			default:
				return 0;
		}
	}
	
	void different(){//find left number, right number and math symbol
		int i = 0;
		for(i = 0;i < MathF.length();i++){
			if( MathF.charAt(i) == '+' || MathF.charAt(i) == '-' || MathF.charAt(i) == '*' || MathF.charAt(i) == '/'){
				MathSymbol = MathF.charAt(i);
				break;
			}
		}
		
		Num[0] = Integer.parseInt(MathF.substring(0,i));
		Num[1] = Integer.parseInt(MathF.substring(i+1,MathF.length()));
	}		
	
	int Add(){//do Addition 
		return Num[0]+Num[1];
	}
	
	int Sub(){//do Subtraction
		return Num[0]-Num[1];
	}
	
	int Mul(){//do Multiplication
		return Num[0]*Num[1];
	}
	
	int Div(){//do Division
		return Num[0]/Num[1];
	}
	
}


public class A1_caculator {	
	public static void main(String[] args) throws IOException {
		
		calculator Calcul;	// new class calculator	
		BufferedReader keyin=new BufferedReader(new InputStreamReader(System.in));//preparation of input  
		String F="";
		
		while(true){
			F=keyin.readLine();//input Mathematical Forms

			if(F.equals("out"))break;//over
			
			Calcul=new calculator(F);
			
			System.out.println("Ans: "+Calcul.GetAns());
	
		}
	}		

}
