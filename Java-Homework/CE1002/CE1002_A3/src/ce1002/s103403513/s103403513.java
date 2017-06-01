package ce1002.s103403513;

import java.util.*;

public class s103403513 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int SizeX = 10 , SizeY = 7;
		String search_type ="";//用書名還是書號
		String answer ="";
		String query = "";//搜尋的關鍵字
		String operation = "";//儲存操作的動作: 借書/還書等
		String identity = "";//儲存使用者身分，student/staff/exit
		Scanner in = new Scanner(System.in);
		String [][] booklists = new String[SizeX][SizeY];
		//建立資料庫
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
		
		System.out.println("【圖書館租借模擬系統】");
		BookSystem bs = new BookSystem();
		do{
			System.out.println("請問你是何種身分？學生(student)或者圖書館人員(staff)？(輸入exit離開)");
			identity = in.nextLine();
			if(identity.equals("student")){
				do{
					bs.ViewStudent(booklists, SizeX);
					System.out.println("請問你要進行何種操作？");
					System.out.println("1. 借書(borrow)");
					System.out.println("2. 還書(return)");
					System.out.println("3. 預約書籍(reserve)");
					System.out.println("4. 取消預約書籍(reservecancel)");
					System.out.println("5. 查詢書單(search)");
					System.out.println("6. 離開(exit)");
					operation = in.nextLine();
					while(!operation.equals("borrow")&&!operation.equals("1")
						&&!operation.equals("return")&&!operation.equals("2")
						&&!operation.equals("reserve")&&!operation.equals("3")
						&&!operation.equals("reservecancel")&&!operation.equals("4")
						&&!operation.equals("search")&&!operation.equals("5")
						&&!operation.equals("exit")&&!operation.equals("6")){
							System.out.println("輸入錯誤！請重新輸入：");
							operation = in.nextLine();
					}
					if(!operation.equals("search") && !operation.equals("5")&&!operation.equals("exit")&&!operation.equals("6")  ){
						if(operation.equals("borrow")|| operation.equals("1")) 
							System.out.println("請問你要輸入[書名](bookname)還是[書號](booknum)來借閱呢？");
						else if(operation.equals("return")||operation.equals("2")) 
							System.out.println("請問你要輸入[書名](bookname)還是[書號](booknum)來還書呢？");
						else if(operation.equals("reserve")||operation.equals("3")) 
							System.out.println("請問你要輸入[書名](bookname)還是[書號](booknum)來預借呢？");
						else if(operation.equals("reservecancel")||operation.equals("4")) 
							System.out.println("請問你要輸入[書名](bookname)還是[書號](booknum)來取消預借呢？");
						search_type = in.nextLine();
						
						if(search_type.equals("bookname"))	System.out.print("請輸入書名：");
						else if(search_type.equals("booknum"))	System.out.print("請輸入書號：");
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
						System.out.println("請問你要以何種方式查詢呢？");
						System.out.println("1. [書號](booknum)");
						System.out.println("2. [書名](bookname)");
						System.out.println("3. [種類](booktype)");
						System.out.println("4. [全部列出](all)");
						search_type = in.nextLine();
						int OrderIndex = 0;
						int TypeIndex = 0;
						if(search_type.equals("booknum")){
							OrderIndex = 0;//依書號排列
							TypeIndex = 0;
						}else if(search_type.equals("bookname")||search_type.equals("all")){
							OrderIndex = 1;//依書名排列
							TypeIndex = 1;
						}else if(search_type.equals("booktype")){
							OrderIndex = 1;//依書名排列
							TypeIndex = 2;
						}
						if(!search_type.equals("all")){
							System.out.print("請輸入 "+search_type+"的關鍵字：");
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
					System.out.println("請問你要進行何種操作？");
					System.out.println("1. 登錄新書籍(bookregister)");
					System.out.println("2. 刪除書籍(bookdelete)");
					System.out.println("3. 更新書籍資料(bookedit)");
					System.out.println("4. 查詢書單(search)");
					System.out.println("5. 查詢學生資料(viewstudent)");
					System.out.println("6. 離開(exit)");
					operation = in.nextLine();
					if(operation.equals("bookregister")||operation.equals("1")){
						booklists = bs.RregisterBook(booklists,SizeX);
					}else if(operation.equals("bookdelete")||operation.equals("2")
							||operation.equals("bookedit")||operation.equals("3")){
						if(operation.equals("bookdelete")||operation.equals("2"))
							System.out.println("請問你要輸入[書名](bookname)還是[書號](booknum)來刪除書籍呢？");
						else if(operation.equals("bookedit")||operation.equals("3"))
							System.out.println("請問你要輸入[書名](bookname)還是[書號](booknum)來修改書籍呢？");
						search_type = in.nextLine();						
						if(search_type.equals("bookname"))	System.out.print("請輸入書名：");
						else if(search_type.equals("booknum"))	System.out.print("請輸入書號：");
						answer = in.nextLine();
						if(operation.equals("bookdelete")||operation.equals("2"))
							booklists = bs.DeleteBooks(booklists,SizeX,SizeY,answer,search_type);
						else if(operation.equals("bookedit")||operation.equals("3"))
							booklists = bs.EditBooks(booklists,SizeX,answer,search_type);
					
					}else if(operation.equals("search")||operation.equals("4")){
						System.out.println("請問你要以何種方式查詢呢？");
						System.out.println("1. [書號](booknum)");
						System.out.println("2. [書名](bookname)");
						System.out.println("3. [種類](booktype)");
						System.out.println("4. [全部列出](all)");
						search_type = in.nextLine();
						int OrderIndex = 0;
						int TypeIndex = 0;
						if(search_type.equals("booknum")||search_type.equals("1")){
							OrderIndex = 0;//依書號排列
							TypeIndex = 0;
						}else if(search_type.equals("bookname")||search_type.equals("all")||search_type.equals("2")||search_type.equals("3")){
							OrderIndex = 1;//依書名排列
							TypeIndex = 1;
						}else if(search_type.equals("booktype")||search_type.equals("3")){
							OrderIndex = 1;//依書名排列
							TypeIndex = 2;
						}
						if(!search_type.equals("all")){
							System.out.print("請輸入 "+search_type+"的關鍵字：");
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
		
		System.out.println("感謝您使用此系統！");
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