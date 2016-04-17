# CollegeHomeworkCollection
to backup those code in my college life
/******************************************************************************
助教會輸入Ｎ的數值及Ｍ個thread的數目，
請同學產生N個隨機的數字，平均分配給Ｍ個thread去計算，
且主執行緒也需做N個數字的加總，請將M個thread執行的結果印出，
且需印出thread加總後與主執行緒結果做比對，若相同則答案正確。（測資會有數筆）
******************************************************************************/
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

//run in run()
class SumWork{
    public synchronized int SumEachThread(int threadID, int[] n){
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
   public synchronized void run(){
        synchronized(SW){
            singleSum = SW.SumEachThread(threadID, threadData);
            System.out.println("Thread id: "+threadID+" total:"+singleSum);
        }
        //add each sum of thread
        sum(singleSum);
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
        
        for(int ti=0; ti < amountOfThread ; ti++){
            int[] part = genData(equal);
            SumThread threadtemp = new SumThread(ti, part , SW );//thread id , data, SW
            threadtemp.start();
            try{
                threadtemp.join();
            }catch (Exception ex){
                System.out.println("error" );
            }
            if(ti == amountOfThread-1){
                System.out.println("Thread: "+ threadtemp.sum(nothing) );
                System.out.println("Main: "+ totalOfMain );
            }
        }
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
