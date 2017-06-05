package edu.american;

import java.util.Random;

import org.jfugue.player.Player;

public class MusicController extends Thread{
	//簡單的歌曲
	public static String Little_Star = "C C G G A A Gq. F F E E D D C";//小星星
	public static String Little_Donkey = "T180 D5 D5 D5 E5 G5 G5 G5q. G5 A5 A5 A5 C6 G5h";//小毛驢
	public static String Little_Bee = "G E Eh F D Dh C D E F G G Gh";//小蜜蜂
	//普通
	public static String God_Rest_You = "A5 A#5 G5 A5 A#5 C6 D6 A5 G5 F5 E5 D5h";//天賜奇蹟  前半段:D D A A G F E D C D E F G A
	public static String To_Alice = "T60 E6s D#6s E6s D#6s E6s B5s D6s C6s A5i.";//給愛麗絲
	//困難
	public static String Servent_Of_Evil = "T240 G G G Gh F E D Eh C C C D Eh. | F F F Fh E D C Eh Dq D D C E Dh";//惡之召使
    public static String Sakura = "T240 D D D C D F F G D D D C D C A4 Cq D D D C D F F G Ah Gh Fh Dh";//千本櫻
	
	private String[] Easy = {Little_Star,Little_Donkey,Little_Bee};
    private String[] Normal = {God_Rest_You,To_Alice};
    private String[] Hard = {Servent_Of_Evil,Sakura};
	private int which_song = 0;
	private String song_in_player = "";
	private Player player = new Player();
	
	public void PickSong(String WhichLevel){
		Random ran = new Random();
    	if(WhichLevel.equals("Easy")){
    		which_song = ran.nextInt(Easy.length);
    		song_in_player = Easy[which_song];
    	}else if(WhichLevel.equals("Normal")){
    		which_song = ran.nextInt(Normal.length);
    		song_in_player = Normal[which_song];
    	}else if(WhichLevel.equals("Hard")){
    		which_song = ran.nextInt(Hard.length);
    		song_in_player = Hard[which_song];
    	}
	}
	public void PutSongInPlayer(String song){
		song_in_player = song;
	}
	public void run(){
		player.play(song_in_player);
	}
	
}
