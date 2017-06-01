package ce1002.s103403513;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
    	int player_num = 5;
        ChunLi chunLi= new ChunLi();
        Ryu ryu = new Ryu ();
        Assassin assassin = new Assassin();
        Madoka madoka = new Madoka();
        Akimison akimison = new Akimison();
        List<GameCharacter> CharaterList = new ArrayList<> (  );
        //加入元素
        CharaterList.add ( chunLi );
        CharaterList.add ( ryu );
        CharaterList.add ( assassin );
        CharaterList.add ( madoka );
        CharaterList.add ( akimison );
        System.out.println ( "Choose Player:" );
        for(int i=0;i<player_num;i++){
            System.out.println ( (i+1) +". "+ CharaterList.get ( i ).getName () );
        }//因為輸出1和2...比較符合正常的選單
        System.out.print("Choice: ");//選玩家的角色
        Scanner scanner = new Scanner ( System.in );
        int choice = scanner.nextInt();
        GameCharacter player = CharaterList.get( choice-1 );//1代表陣列中的0、2代表陣列中的1
        Random ran = new Random();
        int dice = ran.nextInt (player_num);
        GameCharacter enemy = CharaterList.get ( dice );//隨機挑一個敵人
        System.out.println("--------------------------");
        System.out.println(enemy.getName ()+" V.S. "+player.getName ());
        boolean turn = true;
        while(enemy.getHealth()>0&&player.getHealth()>0){ //當兩方的血都還有時，就繼續。
            Thread.sleep(ran.nextInt(500)+500);//稍微
            if(turn){//玩家攻擊
                int attactDice = ran.nextInt(2);//決定普通攻擊還是特殊攻擊
                double enemyHealth = 0;
                switch(attactDice){//攻擊
                    case 0://普通攻擊
                        System.out.println (player.getName ()+" use normal punch!");
                        enemyHealth = enemy.getHealth ();//取得目前的HP
                        enemy.setHealth ( enemyHealth - player.normalPunch () );
                        System.out.println ("Enemy HP: " +enemy.getHealth ());
                        break;
                    case 1://特殊攻擊
                        System.out.println (player.getName ()+" use CA!!!");
                        enemyHealth = enemy.getHealth ();
                        enemy.setHealth ( enemyHealth - player.CA () );
                        System.out.println ("Enemy HP: " +enemy.getHealth ());
                        break;
                    default:
                        System.out.print ("error");
                        break;
                }
            }else{//敵人攻擊
            	int attactDice = ran.nextInt(2);//決定普通攻擊還是特殊攻擊
                double playerHealth = 0;
                switch(attactDice){//攻擊
                    case 0://普通攻擊
                        System.out.println (enemy.getName ()+" use normal punch!");
                        playerHealth = player.getHealth ();//取得目前的HP
                        player.setHealth ( playerHealth - enemy.normalPunch () );
                        System.out.println ("Player HP: " +player.getHealth ());
                        break;
                    case 1://特殊攻擊
                        System.out.println (enemy.getName ()+" use CA!!!");
                        playerHealth = player.getHealth ();
                        player.setHealth ( playerHealth - enemy.CA() );
                        System.out.println ("Player HP: " +player.getHealth ());
                        break;
                    default:
                        System.out.print ("error");
                        break;
                }
                
            }
            System.out.print('\n');
            System.out.println("--------------------------");
            turn = !turn;
        }

        if(enemy.getHealth()<0) System.out.println("Player "+player.getName()+" Wins!");
        else System.out.println("Enemy "+enemy.getName()+" Wins!");
    }
}
