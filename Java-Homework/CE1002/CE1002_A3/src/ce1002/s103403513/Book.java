package ce1002.s103403513;

public class Book{
	int book_size = 9;
	String [][] bookList = new String[book_size][book_size];
	int booknum;
	String bookname;
	String bookauthor;
	String booktype;
	int bookpage;
	int book_amount = 0;
	// 0: 書號  1:書名  2:種類  3:作者  4:頁數
	public Book(String num , String name , String author , String type, String page){
		/*
		booknum = num;
		bookname = name;
		bookauthor = author;
		booktype = type;
		bookpage = page;
		*/
		bookList[book_amount][0] = num;
		bookList[book_amount][1] = name;
		bookList[book_amount][2] = author;
		bookList[book_amount][3] = type;
		bookList[book_amount][4] = page;
		book_amount ++;
	}
	public void ListBook(){
		for(int i = 0; i < book_size ; i++){
			for(int j = 0; j < book_size ; j++){
				System.out.print(bookList[i][j]+ " ");
			}
			System.out.print("\n");
		}
	}
	public boolean QueryBook(int num){
		for(int i = 0; i < book_size ; i++){
			if(bookList[i][0].equals(Integer.toString(num))){
				return true;
			}
		}
		return false;
	}
	public boolean QueryBook(String name){
		for(int i = 0; i < book_size ; i++){
			if(bookList[i][1].equals(name)){
				return true;
			}
		}
		return false;
	}
}
