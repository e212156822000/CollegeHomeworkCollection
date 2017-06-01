package ce1002.s103403513;

import java.util.*;

public class s103403513 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("�п�J�a�Ϥj�p: ");
		int Map_Size = in.nextInt();
		int [][] Map = new int[Map_Size][Map_Size];
		System.out.println("�п�J�a�ϸ��|: ");
		for (int i = 0; i < Map_Size ; i++){
			for(int j =0; j < Map_Size ; j++){
				Map[i][j] = in.nextInt();
			}
		}
		if(TrivrseMap(0,0,Map,Map_Size)){
			System.out.print("�i��");
		}
		else{
			System.out.print("���i��");
		}
		System.out.print("����X�f");
		
	}
	
	//it will mark 2 as stepped.
	public static boolean TrivrseMap(int i , int j , int M[][] , int Map_Size){
		if(i == Map_Size -1 && j == Map_Size -1 && M[i][j] == 1){ //found
			return true;
		}
		if(i+1 < Map_Size && M[i+1][j] == 1){//has down
			M[i][j] = 2;
			return TrivrseMap(i+1,j,M,Map_Size);
		}
		if(j+1 < Map_Size && M[i][j+1] == 1){ // has right
			M[i][j] = 2;
			return TrivrseMap(i,j+1,M,Map_Size);
		}
		if(i-1 >= 0 && M[i-1][j] != 0 && (j-1 < 0 || M[i][j-1] != 1) ){ //has up but has no "new left road" to go
			//�ë��u�����N���F�S���~���v
			M[i][j] = 2;
			return TrivrseMap(i-1,j,M,Map_Size);
		}
		if(j-1 >= 0 && M[i][j-1] != 0){ //has left
			M[i][j] = 2;
			return TrivrseMap(i,j-1,M,Map_Size);
		}else return false;
	}
}
