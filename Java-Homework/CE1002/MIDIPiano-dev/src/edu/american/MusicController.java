package edu.american;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.sound.midi.MidiUnavailableException;

import org.jfugue.player.Player;
import org.jfugue.realtime.RealtimePlayer;

public class MusicController implements Runnable{
	//簡單的歌曲
	public static String Little_Star = "C5 C5 G5 G5 A5 A5 G5q. F5 F5 E5 E5 D5 D5 C5";//小星星
	public static String Little_Donkey = "T180 C5 C5 C5 E5 G5 G5 G5h A5 A5 A5 C6 G5h";//小毛驢
	public static String Little_Bee = "G5 E5 E5h F5 D5 D5h C5 D5 E5 F5 G5 G5 G5h";//小蜜蜂
	//普通
	public static String God_Rest_You = "A5 A#5 G5 A5 A#5 C6 D6 A5 G5 F5 E5 D5h";//天賜奇蹟  前半段:D D A A G F E D C D E F G A
	public static String To_Alice = "T60 E6s D#6s E6s D#6s E6s B5s D6s C6s A5i.";//給愛麗絲
	//困難
	public static String Servent_Of_Evil = "T180 G6q G6i G6. G6q F6q E6i D6h E6q C6q C6i C6 C6s D6q E6w | F6q F6i F6. F6q E6q D6i C6h E6q D6q D6i D6 C6s E6q D6w";//惡之召使
    public static String Sakura = "T240 D5 D5 D5 C5 D5 F5 F5 G5 D5 D5 D5 C5 D5 C5 A4 C5q D5 D5 D5 C5 D5 F5 F5 G5 A5h G5h F5h D5h";//千本櫻
	
    
	private String[] Easy = {Little_Star,Little_Donkey,Little_Bee};
    private String[] Normal = {God_Rest_You,To_Alice};
    private String[] Hard = {Servent_Of_Evil,Sakura};
    //private boolean[] pass = {false,false,false};
	public boolean pass = false;
    private int which_song = 0;
	private String song_in_player = "";
	private boolean alreadyExecuted  = false;
	private Player player = new Player();
	private String testsong = "",TestSongMelody = "";
	private final String REGEX = "[A-G](#)*[0-9]";
	RealtimePlayer rplayer;
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
    	TestSongMelody = song_in_player;
	}
	public String getTestSong(){
		return testsong;
	}
	public void setTestSong(String str){
		testsong = str;
	}
	public void PutSongInPlayer(String song){
		song_in_player = song;
	}
	public void PutKeyInPlayer(String key){
		song_in_player = "T200 "+key;
	}
	public boolean CheckAnswer(String Answer){
		if(Answer.length()>testsong.length()){
			Answer = Answer.trim();//去掉尾巴的空格鍵
			Answer = Answer.substring(Answer.length() - testsong.length());//擷取最後彈的部分
		}
		if(Answer.equals(testsong)) pass = true;
		return pass;
	}
	
	public String SongFilter(String original_song){
		  Pattern p = Pattern.compile(REGEX);
	      Matcher m = p.matcher(original_song);   // get a matcher object
	      String str = "";
	      while(m.find()) {
	         str += m.group() + " ";
	      }
	      return str.trim();
	}
	
	public void run(){
		while(!Thread.interrupted()){
			System.out.print("x");
		}
	}
	public void PlayMusic(){
		if(!alreadyExecuted) {
			try {
				rplayer = new RealtimePlayer();
			} catch (MidiUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			alreadyExecuted = true;
		}
		rplayer.play(song_in_player);
	}
	public void Signal(String song_in_player){
		
	}
	public String getTestSongMelody() {
		// TODO Auto-generated method stub
		return TestSongMelody;
	}
}
