package ce1002.s103403513;
import java.util.*;
import java.io.BufferedReader;

public class s103403513 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int i = 0, j = 0;
		int n = 0;//¯x°}
		System.out.println("Enter the number of Matrix n*n: ");
		n = in.nextInt();
		int [][] arrayA = new int[n][n];
		int [][] arrayB = new int[n][n];
		//for 2D array input 
		System.out.println("Enter A matrix:");
		MatrixInput(arrayA,n);
		System.out.println("Enter B matrix:");
		MatrixInput(arrayB,n);
		//for array to output
		System.out.println("The A matrix is:");
		MatrixPrint(arrayA,n);
		System.out.println("The B matrix is:");
		MatrixPrint(arrayB,n);
		System.out.println("The A+B matrix is:");
		MatrixPrint(MatrixAdd(arrayA,arrayB,n),n);
		System.out.println("The A-B matrix is:");
		MatrixPrint(MatrixSub(arrayA,arrayB,n),n);
		System.out.println("The A*B matrix is:");
		MatrixPrint(MatrixMul(arrayA,arrayB,n),n);
		System.out.println("The A matrix transpose is:");
		MatrixPrint(MatrixTran(arrayA,n),n);
	}
	public static void MatrixPrint(int M[][],int n){
		for(int i = 0; i< n; i++){
			for(int j = 0;j< n;j++){
				System.out.print(M[i][j]+"\t");
			}
			System.out.print("\n");
		}
	}
	public static int[][] MatrixAdd(int A[][],int B[][], int n){
		int [][] M = new int[n][n];
		for(int i = 0; i< n; i++){
			for(int j = 0;j< n;j++){
				M[i][j] = A[i][j]+B[i][j];
			}
		}
		return M;
	}
	public static int[][] MatrixTran(int A[][], int n){
		int [][] M = new int[n][n];
		for(int i = 0; i< n; i++){
			for(int j = 0;j< n;j++){
				M[i][j] = A[j][i];
			}
		}
		return M;
	}
	public static int[][] MatrixSub(int A[][],int B[][], int n){
		int [][] M = new int[n][n];
		for(int i = 0; i< n; i++){
			for(int j = 0;j< n;j++){
				M[i][j] = A[i][j]-B[i][j];
			}
		}
		return M;
	}
	public static int[][] MatrixMul(int A[][],int B[][], int n){
		int [][] M = new int[n][n];
		for(int i = 0; i< n; i++){
			for(int j = 0;j< n;j++){
				M[i][j] = A[i][j]*B[i][j];
			}
		}
		return M;
	}
	public static int[][] MatrixInput(int M[][], int n){
		Scanner in = new Scanner(System.in);
		for(int i = 0; i< n; i++){
			for(int j = 0;j< n;j++){
				M[i][j] = in.nextInt();
			}
		}
		return M;
	}

}
