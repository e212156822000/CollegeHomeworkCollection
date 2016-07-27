package Calculator;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

class win extends JFrame implements ActionListener{
	 
	Font font = new Font(Font.DIALOG, Font.BOLD, 100);//�r��
	JButton btn[]= new JButton[10]; //�x�s 0~9 ���ƭ�
	JButton btnPoint,btnDel,btnRem,btnEqu; // �p���I �h�� �R�� ����
	JButton btnDiv,btnMul,btnSub,btnAdd;// + - * /
	JTextField txtMF = new JTextField("0"); // ��J��r��
	double n[]=new double[2]; // �x�s�B��� 
	FinalCalculator Cal = new FinalCalculator(); // �s�X�p���
	char MathSymbol; // �B��Ÿ�
	String str ="";
	win() {
		//�ǤJ�p��L���W�r
		super("foo");
		//�B�z�Ʀr��
		for(int y = 175, i = 0; y >= 65 ; y -= 55){
			for(int x = 10;x <= 130; x += 60,i++){
				btn[i] = new JButton(Integer.toString(i+1));
				btn[i].setActionCommand(Integer.toString(i+1));
				btn[i].setBounds(x, y, 55, 50);
				btn[i].addActionListener(this);
				add(btn[i]);
			}
		}
		btn[9] = new JButton("0");
		btn[9].setActionCommand("0");
		btn[9].setBounds(10, 230,115, 50);
		btn[9].addActionListener(this);
		add(btn[9]);
		//��L���䪺��m�B�z�C
		btnPoint = new JButton(".");
		btnPoint.setActionCommand(".");
		btnPoint.setBounds(130, 230, 55, 50);
		btnPoint.addActionListener(this);
		add(btnPoint);
		btnDel = new JButton("B");
		btnDel.setActionCommand("B");
		btnDel.setBounds(250, 65, 55, 50);
		btnDel.addActionListener(this);
		add(btnDel);
		btnRem = new JButton("c");
		btnRem.setActionCommand("c");
		btnRem.setBounds(250, 120, 55, 50);
		btnRem.addActionListener(this);
		add(btnRem);
		btnEqu = new JButton("=");
		btnEqu.setActionCommand("=");
		btnEqu.setBounds(250, 175, 55, 105);
		btnEqu.addActionListener(this);
		add(btnEqu);
		btnDiv = new JButton("/");
		btnDiv.setActionCommand("/");
		btnDiv.setBounds(190, 65, 55, 50);
		btnDiv.addActionListener(this);
		add(btnDiv);
		JButton btnMul = new JButton("*");
		btnMul.setActionCommand("*");
		btnMul.setBounds(190, 120, 55, 50);
		btnMul.addActionListener(this);
		add(btnMul);
		btnSub = new JButton("-");
		btnSub.setActionCommand("-");
		btnSub.setBounds(190,175, 55, 50);
		btnSub.addActionListener(this);
		add(btnSub);
		btnAdd = new JButton("+");
		btnAdd.setActionCommand("+");
		btnAdd.setBounds(190, 230, 55, 50);
		btnAdd.addActionListener(this);
		add(btnAdd);
		txtMF.setBounds(10, 5, 295, 50);
		txtMF.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMF.setEditable(true);
		add(txtMF);
		//�]�wframe���䥦�ݩ�
		setLocationRelativeTo(null);
		setSize(320, 335);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e){
		String cmd = e.getActionCommand();
		//���ˬd�O�_���Ʀr
		if( Cal.isNumeric(cmd) ){
			int action = Integer.parseInt(e.getActionCommand());
			for(int i=0;i<10;i++){
				if(action == i){
					str = Cal.exapnd(str, action);
					txtMF.setText(str);
				}
			}
		}else{
			switch(cmd){
				
				case "+" :
				case "-" :
				case "*" :
				case "/" :{
					Cal.setNum1(str);
					Cal.setMathStmbol(e.getActionCommand().charAt(0));
					str = "";
					break;
				}
				
				case "B" :
					str = Cal.Delete(str);
					if(str.length() > 0) txtMF.setText(str);
					else txtMF.setText("0");
					break;
				case "c" :
					str = Cal.Remove(str);
					txtMF.setText(str);
					break;
				case "." :
					str = Cal.exapndPoint(str,'.');
					txtMF.setText(str);
					break;
				
				case "=" :
					if(str != "") Cal.setNum2(str);
					else str = Cal.getNum2();
					if( Cal.checkDivisonZero() ){
						txtMF.setText("Divison by zero");
					}else{
						//System.out.println(Cal.GetAns());
						str = Cal.GetAns();
						Cal.setNum1(str);//�N���ש��num1�A�o�˥i�H���s��[������\��
						
						double value = Double.parseDouble(str);
						double non_sen = Double.parseDouble(String.format("%.0f", value));
		
						if(value != (int)value){
							
							if(String.format("%.0f", value).length() > 25 ) txtMF.setText("Error:Overflow!");
							else if(value==non_sen) txtMF.setText(String.format("%.0f", value));
							else txtMF.setText(Double.toString(value));
						}
						
						else txtMF.setText(Integer.toString((int)value));
					}
					str = "";
					break;
					
					default :
						break;
			}
			
		}
		
	}
	
	
}