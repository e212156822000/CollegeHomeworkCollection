package ce1002.s103403513;
import java.util.*;
public class BookSystem {
	//String [][] list = new String [11][7];
	Scanner in = new Scanner(System.in);
	String answer;
//==================Staff System=======================
	public String[][] RregisterBook(String M[][],int x)
	{
		int last_index = -1;
		int found_booknum = 0;
		int found_bookname = 0;
		String bookname = "",booknum = "",booktype = "",author="",page="";
		
		System.out.print("�п�J�Ѹ��G");
		booknum = in.nextLine();
		System.out.print("�п�J�ѦW�G");
		bookname = in.nextLine();
		System.out.print("�п�J�����G");
		booktype = in.nextLine();
		System.out.print("�п�J�@�̡G");
		author = in.nextLine();
		System.out.print("�п�J���ơG");
		page = in.nextLine();
		
		found_booknum = IndexOfTheBook(M,x,booknum,"booknum");//��쨺����
		found_bookname = IndexOfTheBook(M,x,bookname,"bookname");//��쨺����
		for(int i = 0;i<x;i++){
			if(M[i][0] == null) last_index = i;
		}
		if(found_booknum != -1){
			System.out.println("�s�W���ѡA�����ƪ��Ѹ��I");
		}else if(found_bookname != -1){
			System.out.println("�s�W���ѡA�����ƪ��ѦW�I");
		}else if(last_index == -1){
			System.out.println("�s�W���ѡA��Ʈw���F�I");
		}else{
			M[last_index][0] = booknum;
			M[last_index][1] = bookname;
			M[last_index][2] = booktype;
			M[last_index][3] = author;
			M[last_index][4] = page;
			M[last_index][5] = "false";
			M[last_index][6] = "0";
			System.out.println("�s�W���\�I");
		}
		return M;
	}
	public String[][] EditBooks(String M[][],int x, String query,String type)
	{
		int index = IndexOfTheBook(M,x,query,type);
		if(index != -1){//�T�w��쨺����
			String bookname = "",booknum = "",booktype = "",author="",page="";
			System.out.print("�п�J�Ѹ��G");
			booknum = in.nextLine();
			System.out.print("�п�J�ѦW�G");
			bookname = in.nextLine();
			System.out.print("�п�J�����G");
			booktype = in.nextLine();
			System.out.print("�п�J�@�̡G");
			author = in.nextLine();
			System.out.print("�п�J���ơG");
			page = in.nextLine();
			M[index][0] = booknum;
			M[index][1] = bookname;
			M[index][2] = booktype;
			M[index][3] = author;
			M[index][4] = page;
		}else{
			System.out.println("�ק異�ѡI�Ѥ��b�ѳ椺�C");
		}
		return M;
	}
	public String[][] DeleteBooks(String M[][],int x ,int y ,String query,String type){
		int index = 0;
		index = IndexOfTheBook(M,x,query,type);//��쨺����
		//����쨺����
		if(index != -1){
			for(int i = index;i < x;i++){
				for(int j = 0; j < y;j++){
					if(i+1 == x){//�R���̫�@��
						M[i][j] = null;
					}
					else{//��᭱����Ʃ��e����
						M[i][j] = M[i+1][j];
					}
				}
			}
			System.out.println("�R�����\�I");
		}else{
			System.out.println("�L����");
		}
		return M;
	}
	public void ViewStudent(String M[][],int x){
		System.out.println("�ǥͤw�ɾ\�G");
		for(int i = 0; i< x;i++){ 
			if(M[i][5]!= null && M[i][5].equals("true")){
				System.out.println("�Ѹ��G"+M[i][0]+"\t�ѦW�G"+M[i][1]);//�w�ɥX
			}
		}
		System.out.println("�ǥͤw�w�ɡG");
		for(int i = 0; i< x;i++){ 
			if(M[i][6]!= null && !M[i][6].equals("0")){
				System.out.println("�Ѹ��G"+M[i][0]+"\t�ѦW�G"+M[i][1]);//�w�ɥX
			}
		}
	}
//==================Student System=======================
	public String[][] BorrowBooks(String M[][],int x ,String query,String type){
		String ans = "";
		int index = 0;
		index = IndexOfTheBook(M,x,query,type);//��쨺����
		//�ˬd�����Ѧ��S���Q�ɨ�
		if(index != -1 && M[index][5]!=null && M[index][5].equals("false")){ //�����Ѧ��S���Q�ɨ�
			M[index][5] = "true";
			System.out.println("�ɥX���\�I");
		}else{
			System.out.println("�ѥ��w�g�Q�ɥX�F�A�аݭn�w���ܡH(y/n)");
			ans = in.nextLine();
			if(ans.equals("y")){
				ReserveBooks(M,x,query,type);
			}
		}
		return M;
	}
	public String[][] ReturnBooks(String M[][],int x,String query,String type){
		int index = 0;
		index = IndexOfTheBook(M,x,query,type);//��쨺����
		//�ˬd�����Ѧ��S���Q�ɨ�
		if(index != -1 && M[index][5]!=null && M[index][5].equals("true")){ //�����Ѧ��Q�ɨ�
			M[index][5] = "false";
			System.out.println("�ٮѦ��\�I");
		}else{
			System.out.println("�A�S���ɾ\����");
		}
		return M;
	}
	public String[][] ReserveBooks(String M[][],int x,String query,String type){
		String ans = "";
		int index = 0;
		int reserve_amount = 0;
		index = IndexOfTheBook(M,x,query,type);//��쨺����
		//�ˬd�����Ѧ��S���Q�ɨ�
		if(index != -1 && M[index][5]!=null && M[index][5].equals("true"))
		{ //�����Ѧ��Q�ɨ��ӥB�w�ɤH��<10�H
			if(M[index][6]!=null && !M[index][6].equals("10")){
				reserve_amount = Integer.parseInt(M[index][6]);
				reserve_amount++;
				M[index][6] = Integer.toString(reserve_amount);
				System.out.println("�w�ɦ��\�I");
			}else{
				System.out.println("�Ӧh�H�w���F�A�w�����ѡI");
			}
		}else{
			System.out.println("�o���ѨS���Q�ɥX�A�аݭn�ɮѶܡH(y/n)");
			ans = in.nextLine();
			if(ans.equals("y")){
				BorrowBooks(M,x,query,type);
			}
		}
		return M;
	}
	public String[][] ReserveCancel(String M[][],int x,String query,String type ){
		int index = 0;
		int reserve_amount = 0;
		index = IndexOfTheBook(M,x,query,type);//��쨺����
		//�p�G�����Ѧ��Q�ɨ�
		if(M[index][6]!=null && !M[index][6].equals("0")){
			reserve_amount = Integer.parseInt(M[index][6]);
			reserve_amount--;
			M[index][6] = Integer.toString(reserve_amount);
			System.out.println("�����w�ɦ��\�I");
		}else{
			System.out.println("�o���ѨS���Q�A�w����I");
		}
		return M;
	}
//==================Book System=======================
	public void SearchBooks(String M[][],int x,int y,String query,int TypeIndex,int OrderIndex){
		//���̾�����r���Ƶ��A�s�J�@�|�}���A���ۦb�ƧǡC
		String temp[][] = new String [x][y];
		System.out.println("�d�ߵ��G�p�U�G");
		for(int i = 0, k = 0; i< x;i++){ 
			if(M[i][TypeIndex]!= null && M[i][TypeIndex].equals(query)){
				for(int j = 0;j<y;j++){
					temp[k][j] = M[i][j];
				}
				k++;
			}
		}
		Arrays.sort(temp, new Comparator<String[]>(){
			@Override
			public int compare(String[] arg0, String[] arg1) {
				// TODO Auto-generated method stub
				final String searchedkey1 = arg0[OrderIndex];
                final String searchedkey2 = arg1[OrderIndex];
                if(searchedkey1 == null || searchedkey2 == null){
                	return -128;
                }else 
                	return searchedkey1.compareTo(searchedkey2);//127 for top , -128 for bottom
			}
		});
		BooklistPrint(temp,x,y);
	}
	public void SearchBooks(String M[][],int x,int y,int TypeIndex,int OrderIndex){
		Arrays.sort(M, new Comparator<String[]>(){
			@Override
			public int compare(String[] arg0, String[] arg1) {
				// TODO Auto-generated method stub
				final String searchedkey1 = arg0[OrderIndex];
                final String searchedkey2 = arg1[OrderIndex];
                if(searchedkey1 == null || searchedkey2 == null){
                	return -128;
                }else 
                	return searchedkey1.compareTo(searchedkey2);//127 for top , -128 for bottom
			}
		});
		BooklistPrint(M,x,y);
	}
	/*
	 * 1. M[][] �ǤJ��ƪ�
	 * 2. ��ƶq������
	 * 3. �˯����u��
	 * 4. �˯����̾�
	 */
	public int IndexOfTheBook(String M[][],int x,String QueryData,String SearchType){
		int TypeIndex = 0;
		/*
		 * 0 : booknum
		 * 1 : bookname
		 * 2 : booktype
		 * 3 : author
		 * 4 : page
		 * 5 : borrow
		 * 6 : reserve
		 */
		
		if(SearchType.equals("booknum")){
			TypeIndex = 0;
		}else if(SearchType.equals("bookname")){
			TypeIndex = 1;
		}else if(SearchType.equals("booktype")){
			TypeIndex = 2;
		}else if(SearchType.equals("borrow")){
			TypeIndex = 5;
		}else if(SearchType.equals("reserve")){
			TypeIndex = 6;
			for(int i = 0; i< x;i++){ 
				if(M[i][TypeIndex]!= null && !M[i][TypeIndex].equals(QueryData)){
					return i;
				}
			}
		}
		
		for(int i = 0; i< x;i++){ 
			if(M[i][TypeIndex]!= null && M[i][TypeIndex].equals(QueryData)){
				return i;
			}
		}
		
		return -1;
	}
	public void BooklistPrint(String[][] M,int endx,int endy){
		System.out.printf("%-30s%-30s%-30s%-30s%-30s%-30s%-30s\n","[�Ѹ�]","[�ѦW]","[����]","[�@��]","[����]","[�ɥX���A]","[�w���H��]");
		for(int i = 0; i< endx; i++){
			if(M[i][0] != null){
				for(int j = 0;j< endy;j++){
					System.out.printf("%-30s",M[i][j]);
				}
				System.out.print("\n");
			}
		}
	}	
}
