package ce1002.s103403513;

import java.util.*;

public class s103403513 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int SizeX = 10 , SizeY = 7;
		String search_type ="";//�ήѦW�٬O�Ѹ�
		String answer ="";
		String query = "";//�j�M������r
		String operation = "";//�x�s�ާ@���ʧ@: �ɮ�/�ٮѵ�
		String identity = "";//�x�s�ϥΪ̨����Astudent/staff/exit
		Scanner in = new Scanner(System.in);
		String [][] booklists = new String[SizeX][SizeY];
		//�إ߸�Ʈw
		booklists = AddBooks("82101","Cihai","Reference","Shu Xincheng","20000",booklists,0);
		booklists = AddBooks("80001","WW2 History","History","Winston Churchill","971",booklists,1);
		booklists = AddBooks("00003","Egg 100","Cookbook","Su yuan ma","104",booklists,2);
		booklists = AddBooks("50001","Be a honest man","Political","Ma Ying jeou","520",booklists,3);
		booklists = AddBooks("85719","Sword Art Online","Novel","Reki Kawahara","8763",booklists,4);
		booklists = AddBooks("85728","Spice and Wolf","Novel","Isuna Hasekura","510",booklists,5);
		booklists = AddBooks("85707","The Old Man and the Sea","Novel","Ernest Hemingway","127",booklists,6);
		booklists = AddBooks("85703","Romance of the Three Kingdoms","Novel","Luo Guanzhong","480",booklists,7);
		booklists = AddBooks("80005","Records of the Grand Historian","History","Sima Qian","6000",booklists,8);
		booklists[4][5] = "true";
		booklists[4][6] = "1";
		
		System.out.println("�i�Ϯ��]���ɼ����t�Ρj");
		BookSystem bs = new BookSystem();
		do{
			System.out.println("�аݧA�O��ب����H�ǥ�(student)�Ϊ̹Ϯ��]�H��(staff)�H(��Jexit���})");
			identity = in.nextLine();
			if(identity.equals("student")){
				do{
					bs.ViewStudent(booklists, SizeX);
					System.out.println("�аݧA�n�i���ؾާ@�H");
					System.out.println("1. �ɮ�(borrow)");
					System.out.println("2. �ٮ�(return)");
					System.out.println("3. �w�����y(reserve)");
					System.out.println("4. �����w�����y(reservecancel)");
					System.out.println("5. �d�߮ѳ�(search)");
					System.out.println("6. ���}(exit)");
					operation = in.nextLine();
					while(!operation.equals("borrow")&&!operation.equals("1")
						&&!operation.equals("return")&&!operation.equals("2")
						&&!operation.equals("reserve")&&!operation.equals("3")
						&&!operation.equals("reservecancel")&&!operation.equals("4")
						&&!operation.equals("search")&&!operation.equals("5")
						&&!operation.equals("exit")&&!operation.equals("6")){
							System.out.println("��J���~�I�Э��s��J�G");
							operation = in.nextLine();
					}
					if(!operation.equals("search") && !operation.equals("5")&&!operation.equals("exit")&&!operation.equals("6")  ){
						if(operation.equals("borrow")|| operation.equals("1")) 
							System.out.println("�аݧA�n��J[�ѦW](bookname)�٬O[�Ѹ�](booknum)�ӭɾ\�O�H");
						else if(operation.equals("return")||operation.equals("2")) 
							System.out.println("�аݧA�n��J[�ѦW](bookname)�٬O[�Ѹ�](booknum)���ٮѩO�H");
						else if(operation.equals("reserve")||operation.equals("3")) 
							System.out.println("�аݧA�n��J[�ѦW](bookname)�٬O[�Ѹ�](booknum)�ӹw�ɩO�H");
						else if(operation.equals("reservecancel")||operation.equals("4")) 
							System.out.println("�аݧA�n��J[�ѦW](bookname)�٬O[�Ѹ�](booknum)�Ө����w�ɩO�H");
						search_type = in.nextLine();
						
						if(search_type.equals("bookname"))	System.out.print("�п�J�ѦW�G");
						else if(search_type.equals("booknum"))	System.out.print("�п�J�Ѹ��G");
						answer = in.nextLine();
						if(operation.equals("borrow")||operation.equals("1")) 
							booklists = bs.BorrowBooks(booklists,SizeX,answer,search_type);
						else if(operation.equals("return")||operation.equals("2")) 
							booklists = bs.ReturnBooks(booklists,SizeX,answer,search_type);
						else if(operation.equals("reserve")||operation.equals("3")) 
							booklists = bs.ReserveBooks(booklists,SizeX,answer,search_type);
						else if(operation.equals("reservecancel")||operation.equals("4")) 
							booklists = bs.ReserveCancel(booklists,SizeX,answer,search_type);
						
					}else if(operation.equals("search")||operation.equals("5")){
						System.out.println("�аݧA�n�H��ؤ覡�d�ߩO�H");
						System.out.println("1. [�Ѹ�](booknum)");
						System.out.println("2. [�ѦW](bookname)");
						System.out.println("3. [����](booktype)");
						System.out.println("4. [�����C�X](all)");
						search_type = in.nextLine();
						int OrderIndex = 0;
						int TypeIndex = 0;
						if(search_type.equals("booknum")){
							OrderIndex = 0;//�̮Ѹ��ƦC
							TypeIndex = 0;
						}else if(search_type.equals("bookname")||search_type.equals("all")){
							OrderIndex = 1;//�̮ѦW�ƦC
							TypeIndex = 1;
						}else if(search_type.equals("booktype")){
							OrderIndex = 1;//�̮ѦW�ƦC
							TypeIndex = 2;
						}
						if(!search_type.equals("all")){
							System.out.print("�п�J "+search_type+"������r�G");
							query = in.nextLine();
							bs.SearchBooks(booklists,SizeX,SizeY,query,TypeIndex,OrderIndex);
						}else{
							bs.SearchBooks(booklists,SizeX,SizeY,TypeIndex,OrderIndex);
						}
					}
				}while(!operation.equals("exit"));
			}else if(identity.equals("staff")){
				do{
					System.out.println("=========This is staff page=============");
					System.out.println("�аݧA�n�i���ؾާ@�H");
					System.out.println("1. �n���s���y(bookregister)");
					System.out.println("2. �R�����y(bookdelete)");
					System.out.println("3. ��s���y���(bookedit)");
					System.out.println("4. �d�߮ѳ�(search)");
					System.out.println("5. �d�߾ǥ͸��(viewstudent)");
					System.out.println("6. ���}(exit)");
					operation = in.nextLine();
					if(operation.equals("bookregister")||operation.equals("1")){
						booklists = bs.RregisterBook(booklists,SizeX);
					}else if(operation.equals("bookdelete")||operation.equals("2")
							||operation.equals("bookedit")||operation.equals("3")){
						if(operation.equals("bookdelete")||operation.equals("2"))
							System.out.println("�аݧA�n��J[�ѦW](bookname)�٬O[�Ѹ�](booknum)�ӧR�����y�O�H");
						else if(operation.equals("bookedit")||operation.equals("3"))
							System.out.println("�аݧA�n��J[�ѦW](bookname)�٬O[�Ѹ�](booknum)�ӭק���y�O�H");
						search_type = in.nextLine();						
						if(search_type.equals("bookname"))	System.out.print("�п�J�ѦW�G");
						else if(search_type.equals("booknum"))	System.out.print("�п�J�Ѹ��G");
						answer = in.nextLine();
						if(operation.equals("bookdelete")||operation.equals("2"))
							booklists = bs.DeleteBooks(booklists,SizeX,SizeY,answer,search_type);
						else if(operation.equals("bookedit")||operation.equals("3"))
							booklists = bs.EditBooks(booklists,SizeX,answer,search_type);
					
					}else if(operation.equals("search")||operation.equals("4")){
						System.out.println("�аݧA�n�H��ؤ覡�d�ߩO�H");
						System.out.println("1. [�Ѹ�](booknum)");
						System.out.println("2. [�ѦW](bookname)");
						System.out.println("3. [����](booktype)");
						System.out.println("4. [�����C�X](all)");
						search_type = in.nextLine();
						int OrderIndex = 0;
						int TypeIndex = 0;
						if(search_type.equals("booknum")||search_type.equals("1")){
							OrderIndex = 0;//�̮Ѹ��ƦC
							TypeIndex = 0;
						}else if(search_type.equals("bookname")||search_type.equals("all")||search_type.equals("2")||search_type.equals("3")){
							OrderIndex = 1;//�̮ѦW�ƦC
							TypeIndex = 1;
						}else if(search_type.equals("booktype")||search_type.equals("3")){
							OrderIndex = 1;//�̮ѦW�ƦC
							TypeIndex = 2;
						}
						if(!search_type.equals("all")){
							System.out.print("�п�J "+search_type+"������r�G");
							query = in.nextLine();
							bs.SearchBooks(booklists,SizeX,SizeY,query,TypeIndex,OrderIndex);
						}else{
							bs.SearchBooks(booklists,SizeX,SizeY,TypeIndex,OrderIndex);
						}
					}else if(operation.equals("viewstudent")||operation.equals("5")){
						bs.ViewStudent(booklists,SizeX);
					}
				}while(!operation.equals("exit"));
			}
			
		}while(!identity.equals("exit"));
		
		System.out.println("�P�±z�ϥΦ��t�ΡI");
	}
	//for building books
	public static String[][] AddBooks(
			String booknum,
			String bookname,
			String type, 
			String author,
			String page ,
			String list[][],
			int index)
	{
		list[index][0] = booknum;
		list[index][1] = bookname;
		list[index][2] = type;
		list[index][3] = author;
		list[index][4] = page;
		list[index][5] = "false";
		list[index][6] = "0";
		return list;
	}
}