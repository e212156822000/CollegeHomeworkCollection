package Calculator;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class FinalCalculator extends SimpleCalculator{
	//�����غc�l
	BigDecimal Num1=new BigDecimal("1");
	BigDecimal Num2=new BigDecimal("3");
	FinalCalculator(){
		super();
	}
	//�`�N�A�����O����ׯB�I�B��A�O�o�n�૬�A
	void setNum1(String str1){//�]�Ĥ@�ӼƦr����
		Num[0] = new BigDecimal(str1).setScale(2,BigDecimal.ROUND_HALF_UP);;
	}
	void setNum2(String str2){//�]�ĤG�ӼƦr����
		Num[1] = new BigDecimal(str2).setScale(2,BigDecimal.ROUND_HALF_UP);;
	}
	void setMathStmbol(char symbol){//�]�w�[���
		MathSymbol = symbol;
	}
	String getNum1(){//���Ĥ@�ӼƦr����
		return String.valueOf(Num[0]);
	}
	String getNum2(){//���ĤG�ӼƦr����
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
	boolean checkDivisonZero(){//�ˬd�O�_���H0
		if( MathSymbol == '/' && Num[1].compareTo(BigDecimal.ZERO) == 0 ){
			return true;
		}else return false;
	}
	//�B�����]�t�H�U��k����@
	
	String Delete(String str){//�h��ʧ@
		str = str.substring(0, str.length()-1 > 0 ?str.length()-1: 0 );
		return str;
	}
	
	String exapnd(String str,int i){//�X�R�ʧ@
		str += Integer.toString(i);
		return str;
	}
	String exapndPoint(String str,char c){//�X�R�p���I�ʧ@
		str += c;
		return str;
	}
	
	String Remove(String str){//�R���ʧ@
		str = "";
		return str;
	}
	
}

