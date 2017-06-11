package newsongfactory;
public class SongFactory{
	
	
	public static Song getSong(String songTitle){
		Song song = null;
		
		if(songTitle.equalsIgnoreCase("athousandmiles"))
			song = new AThousandMiles();
		else if(songTitle.equalsIgnoreCase("howtosavealife"))
			song = new HowToSaveALife();
		else if(songTitle.equalsIgnoreCase("justthewayyouare"))
			song = new JustTheWayYouAre();
		else if(songTitle.equalsIgnoreCase("lostmypieces"))
			song = new LostMyPieces();
		else if(songTitle.equalsIgnoreCase("magasin"))
			song = new Magasin();
		else if(songTitle.equalsIgnoreCase("outofmyleague"))
			song = new OutOfMyLeague();
		else if(songTitle.equalsIgnoreCase("payphone"))
			song = new Payphone();
		else if(songTitle.equalsIgnoreCase("sundaymorning"))
			song = new SundayMorning();
		else if(songTitle.equalsIgnoreCase("watermelon"))
			song = new WaterMelon();
		
		return song;
	}
	

}
