package Calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
class SimpleCalculator{

	BigDecimal Num[]=new BigDecimal[2];//����ׯB�I�ƹB��
	char MathSymbol;//�����B��Ÿ�
	
	SimpleCalculator(){
		Num[0]=new BigDecimal("0");//��l��0
		Num[1]=new BigDecimal("0");
	}
	
	String GetAns(){//���o����
		return String.valueOf(compute()); 
	}
	
	private double compute(){//�p�ⳡ��
	
		switch (MathSymbol){
			case '+': return Add();
			case '-': return Sub();
			case '*': return Mul();
			default: return Div();		
		}
	}
	
	
	private double Add(){ //�[�k
		return Num[0].add(Num[1]).doubleValue();
	}
	
	private double Sub(){ //��k
		return Num[0].subtract(Num[1]).doubleValue();
	}
	
	private double Mul(){ // ���k
		return Num[0].multiply(Num[1]).doubleValue();
	}
	
	 private double Div(){ //���k�A���F���L���p�ƥi�H���T��ܦӰ��ק�
		return Num[0].divide(Num[1],5, RoundingMode.HALF_UP).doubleValue();
	}
	
}
