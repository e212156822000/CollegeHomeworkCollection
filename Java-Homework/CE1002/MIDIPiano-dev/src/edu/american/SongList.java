package edu.american;

import java.util.Random;

public class SongList {
	//簡單的歌曲
	public static String Little_Star = "C C G G A A Gq. F F E E D D C";//小星星
	public static String Little_Donkey = "T180 D5 D5 D5 E5 G5 G5 G5q. G5 A5 A5 A5 C6 G5h";//小毛驢
	public static String Little_Bee = "G E Eh F D Dh C D E F G G Gh";//小蜜蜂
	//普通
	public static String God_Rest_You = "A5 A#5 G5 A5 A#5 C6 D6 A5 G5 F5 E5 D5h";//天賜奇蹟  前半段:D D A A G F E D C D E F G A
	public static String To_Alice = "T60 E6s D#6s E6s D#6s E6s B5s D6s C6s A5i.";//給愛麗絲

    private String[] Easy = {Little_Star,Little_Donkey,Little_Bee};
    private String[] Normal = {God_Rest_You,To_Alice};
    private String[] Hard = {"God_Rest_You","To_Alice"};
	private int which_song = 0;
	public String PickSong(String WhichLevel){
		Random ran = new Random();
		String song_picked = "";
    	if(WhichLevel.equals("Easy")){
    		which_song = ran.nextInt(Easy.length);
    		song_picked = Easy[which_song];
    	}else if(WhichLevel.equals("Normal")){
    		which_song = ran.nextInt(Normal.length);
    		song_picked = Normal[which_song];
    	}else if(WhichLevel.equals("Hard")){
    		which_song = ran.nextInt(Hard.length);
    		song_picked = Hard[which_song];
    	}
    	return song_picked;
	}
	
}
