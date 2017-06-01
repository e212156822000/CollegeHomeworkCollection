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
		
		System.out.print("請輸入書號：");
		booknum = in.nextLine();
		System.out.print("請輸入書名：");
		bookname = in.nextLine();
		System.out.print("請輸入種類：");
		booktype = in.nextLine();
		System.out.print("請輸入作者：");
		author = in.nextLine();
		System.out.print("請輸入頁數：");
		page = in.nextLine();
		
		found_booknum = IndexOfTheBook(M,x,booknum,"booknum");//找到那本書
		found_bookname = IndexOfTheBook(M,x,bookname,"bookname");//找到那本書
		for(int i = 0;i<x;i++){
			if(M[i][0] == null) last_index = i;
		}
		if(found_booknum != -1){
			System.out.println("新增失敗，有重複的書號！");
		}else if(found_bookname != -1){
			System.out.println("新增失敗，有重複的書名！");
		}else if(last_index == -1){
			System.out.println("新增失敗，資料庫滿了！");
		}else{
			M[last_index][0] = booknum;
			M[last_index][1] = bookname;
			M[last_index][2] = booktype;
			M[last_index][3] = author;
			M[last_index][4] = page;
			M[last_index][5] = "false";
			M[last_index][6] = "0";
			System.out.println("新增成功！");
		}
		return M;
	}
	public String[][] EditBooks(String M[][],int x, String query,String type)
	{
		int index = IndexOfTheBook(M,x,query,type);
		if(index != -1){//確定找到那本書
			String bookname = "",booknum = "",booktype = "",author="",page="";
			System.out.print("請輸入書號：");
			booknum = in.nextLine();
			System.out.print("請輸入書名：");
			bookname = in.nextLine();
			System.out.print("請輸入種類：");
			booktype = in.nextLine();
			System.out.print("請輸入作者：");
			author = in.nextLine();
			System.out.print("請輸入頁數：");
			page = in.nextLine();
			M[index][0] = booknum;
			M[index][1] = bookname;
			M[index][2] = booktype;
			M[index][3] = author;
			M[index][4] = page;
		}else{
			System.out.println("修改失敗！書不在書單內。");
		}
		return M;
	}
	public String[][] DeleteBooks(String M[][],int x ,int y ,String query,String type){
		int index = 0;
		index = IndexOfTheBook(M,x,query,type);//找到那本書
		//有找到那本書
		if(index != -1){
			for(int i = index;i < x;i++){
				for(int j = 0; j < y;j++){
					if(i+1 == x){//刪除最後一筆
						M[i][j] = null;
					}
					else{//把後面的資料往前移動
						M[i][j] = M[i+1][j];
					}
				}
			}
			System.out.println("刪除成功！");
		}else{
			System.out.println("無此書");
		}
		return M;
	}
	public void ViewStudent(String M[][],int x){
		System.out.println("學生已借閱：");
		for(int i = 0; i< x;i++){ 
			if(M[i][5]!= null && M[i][5].equals("true")){
				System.out.println("書號："+M[i][0]+"\t書名："+M[i][1]);//已借出
			}
		}
		System.out.println("學生已預借：");
		for(int i = 0; i< x;i++){ 
			if(M[i][6]!= null && !M[i][6].equals("0")){
				System.out.println("書號："+M[i][0]+"\t書名："+M[i][1]);//已借出
			}
		}
	}
//==================Student System=======================
	public String[][] BorrowBooks(String M[][],int x ,String query,String type){
		String ans = "";
		int index = 0;
		index = IndexOfTheBook(M,x,query,type);//找到那本書
		//檢查那本書有沒有被借走
		if(index != -1 && M[index][5]!=null && M[index][5].equals("false")){ //那本書有沒有被借走
			M[index][5] = "true";
			System.out.println("借出成功！");
		}else{
			System.out.println("書本已經被借出了，請問要預約嗎？(y/n)");
			ans = in.nextLine();
			if(ans.equals("y")){
				ReserveBooks(M,x,query,type);
			}
		}
		return M;
	}
	public String[][] ReturnBooks(String M[][],int x,String query,String type){
		int index = 0;
		index = IndexOfTheBook(M,x,query,type);//找到那本書
		//檢查那本書有沒有被借走
		if(index != -1 && M[index][5]!=null && M[index][5].equals("true")){ //那本書有被借走
			M[index][5] = "false";
			System.out.println("還書成功！");
		}else{
			System.out.println("你沒有借閱此書");
		}
		return M;
	}
	public String[][] ReserveBooks(String M[][],int x,String query,String type){
		String ans = "";
		int index = 0;
		int reserve_amount = 0;
		index = IndexOfTheBook(M,x,query,type);//找到那本書
		//檢查那本書有沒有被借走
		if(index != -1 && M[index][5]!=null && M[index][5].equals("true"))
		{ //那本書有被借走而且預借人數<10人
			if(M[index][6]!=null && !M[index][6].equals("10")){
				reserve_amount = Integer.parseInt(M[index][6]);
				reserve_amount++;
				M[index][6] = Integer.toString(reserve_amount);
				System.out.println("預借成功！");
			}else{
				System.out.println("太多人預約了，預約失敗！");
			}
		}else{
			System.out.println("這本書沒有被借出，請問要借書嗎？(y/n)");
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
		index = IndexOfTheBook(M,x,query,type);//找到那本書
		//如果那本書有被借走
		if(M[index][6]!=null && !M[index][6].equals("0")){
			reserve_amount = Integer.parseInt(M[index][6]);
			reserve_amount--;
			M[index][6] = Integer.toString(reserve_amount);
			System.out.println("取消預借成功！");
		}else{
			System.out.println("這本書沒有被你預約喔！");
		}
		return M;
	}
//==================Book System=======================
	public void SearchBooks(String M[][],int x,int y,String query,int TypeIndex,int OrderIndex){
		//先依據關鍵字找到數筆，存入一舉陣中，接著在排序。
		String temp[][] = new String [x][y];
		System.out.println("查詢結果如下：");
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
	 * 1. M[][] 傳入資料表
	 * 2. 資料量的長度
	 * 3. 檢索的線索
	 * 4. 檢索的依據
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
		System.out.printf("%-30s%-30s%-30s%-30s%-30s%-30s%-30s\n","[書號]","[書名]","[種類]","[作者]","[頁數]","[借出狀態]","[預約人數]");
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
