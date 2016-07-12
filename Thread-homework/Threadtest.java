/******************************************************************************
�U�з|��J�ܪ��ƭȤ΢ۭ�thread���ƥءA
�ЦP�ǲ���N���H�����Ʀr�A�������t���ۭ�thread�h�p��A
�B�D������]�ݰ�N�ӼƦr���[�`�A�бNM��thread���檺���G�L�X�A
�B�ݦL�Xthread�[�`��P�D��������G�����A�Y�ۦP�h���ץ��T�C�]����|���Ƶ��^
******************************************************************************/
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

//run in run()
class SumWork{
    public int SumEachThread(int threadID, int[] n){
        int sum = 0;
        for(int i = 0; i < n.length ; i++ ){
            sum += n[i];
        }
        return sum;
    }
}

class SumThread extends Thread {
   private Thread t;
   private  int threadID;
   SumWork  SW;
   int totalOfThread = 0;
   int[] threadData;
   static int sumOfAllThread = 0;//static so that two method can acess it
   int singleSum = 0;

   SumThread( int name, int[] num, SumWork sw ){
        threadData = Arrays.copyOfRange(num, 0, num.length);
        threadID = name;
        SW = sw;
   }
   
   public void run(){

        singleSum = SW.SumEachThread(threadID, threadData);
        System.out.println("Thread id: "+threadID+" total:"+singleSum);
        sum(singleSum);
        //add each sum of thread
    }

    public int sum(int single){
        sumOfAllThread += single;
        return sumOfAllThread;
    }
    
}

public class Threadtest {
    
    public static int totalOfMain = 0;

    public static void main(String args[]) {
        //user input
        SumWork SW = new SumWork();
        Scanner input = new Scanner(System.in);
        int nothing = 0;//to send to SumThread sum() method, just make it legal 
        int amountOfNumber = input.nextInt();
        int amountOfThread = input.nextInt();
        int equal = amountOfNumber/amountOfThread;//length of each data array
        SumThread[] newtemp = new SumThread[amountOfThread];
        
        for (int i = 0; i < newtemp.length; i++) {
             int[] part = genData(equal);
             newtemp[i] = new SumThread(i, part , SW );
             newtemp[i].start();
        }
        for (int i = 0; i < newtemp.length; i++) {
            try{
                newtemp[i].join();
            }catch( Exception e){

            }
        }
        System.out.println("Thread: " + newtemp[amountOfThread-1].sum(nothing));
        System.out.println("Main: "+ totalOfMain );
    }//end of main
    //generate random data
    static int[] genData(int equal){
        Random rand = new Random();
        int[] data;
        data = new int[equal];
        for(int i = 0; i < equal; i++){
            data[i] = rand.nextInt(1001);
            totalOfMain += data[i]; 
        }
        return data;
    }//end of genData
}