package Calculator;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class FinalCalculator extends SimpleCalculator{
	//完成建構子
	BigDecimal Num1=new BigDecimal("1");
	BigDecimal Num2=new BigDecimal("3");
	FinalCalculator(){
		super();
	}
	//注意，父類別為精度浮點運算，記得要轉型態
	void setNum1(String str1){//設第一個數字的值
		Num[0] = new BigDecimal(str1).setScale(2,BigDecimal.ROUND_HALF_UP);;
	}
	void setNum2(String str2){//設第二個數字的值
		Num[1] = new BigDecimal(str2).setScale(2,BigDecimal.ROUND_HALF_UP);;
	}
	void setMathStmbol(char symbol){//設定加減乘除
		MathSymbol = symbol;
	}
	String getNum1(){//取第一個數字的值
		return String.valueOf(Num[0]);
	}
	String getNum2(){//取第二個數字的值
		return String.valueOf(Num[1]);
	}
	
	boolean isNumeric(String input) {
		  try {
		    Integer.parseInt(input);
		    return true;
		  }
		  catch (NumberFormatException e) {
		    // s is not numeric
		    return false;
		  }
	}
	boolean checkDivisonZero(){//檢查是否除以0
		if( MathSymbol == '/' && Num[1].compareTo(BigDecimal.ZERO) == 0 ){
			return true;
		}else return false;
	}
	//且必須包含以下方法的實作
	
	String Delete(String str){//退格動作
		str = str.substring(0, str.length()-1 > 0 ?str.length()-1: 0 );
		return str;
	}
	
	String exapnd(String str,int i){//擴充動作
		str += Integer.toString(i);
		return str;
	}
	String exapndPoint(String str,char c){//擴充小數點動作
		str += c;
		return str;
	}
	
	String Remove(String str){//刪除動作
		str = "";
		return str;
	}
	
}

