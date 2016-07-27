package Calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
class SimpleCalculator{

	BigDecimal Num[]=new BigDecimal[2];//做精度浮點數運算
	char MathSymbol;//紀錄運算符號
	
	SimpleCalculator(){
		Num[0]=new BigDecimal("0");//初始為0
		Num[1]=new BigDecimal("0");
	}
	
	String GetAns(){//取得答案
		return String.valueOf(compute()); 
	}
	
	private double compute(){//計算部分
	
		switch (MathSymbol){
			case '+': return Add();
			case '-': return Sub();
			case '*': return Mul();
			default: return Div();		
		}
	}
	
	
	private double Add(){ //加法
		return Num[0].add(Num[1]).doubleValue();
	}
	
	private double Sub(){ //減法
		return Num[0].subtract(Num[1]).doubleValue();
	}
	
	private double Mul(){ // 乘法
		return Num[0].multiply(Num[1]).doubleValue();
	}
	
	 private double Div(){ //除法，為了讓無限小數可以正確顯示而做修改
		return Num[0].divide(Num[1],5, RoundingMode.HALF_UP).doubleValue();
	}
	
}
