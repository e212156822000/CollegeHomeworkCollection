package newsongfactory;

import org.jfugue.Pattern;

public class SundayMorning implements Song{

	
	private void playSundayMorning() {
		Pattern pattern1 = new Pattern("T[140] I[Flute] Rh G5q E5i G5q E5q G5q E5q D5q C5h. " +
				"Rq G5q E5i G5q E5q D5q.. C5q C5h. " + "Rq G5q E5i G5q E5q E5q. D5q D5i C5q. C5q D5q E5q D5i C5q. " +
				"C5i A4q C5q D5 Eb5q D5q. C5i C5i A4i C5h. Rq " + " C5q A5q G5q G5i E5q A5q G5q. G5i E5q A5q G5q G5q E5i A5q Rq "
 				+ " E5i E5i G5q A5q G5q. G5i E5q A5q Ri G5q. E5q A5q. G5i E5i A5q Rq. " +
				"G5q F5q E5q D5q C5q D5q C5q. D5i E5i E5q Rh " + "G5q F5q E5q D5q C5q D5q E5q D5q C5i C5q.. Rh."
				+ "E5q E5q F5q G5h.. E5h.. C5q Rq Rq C5i E5q D5q E5q F5q G5h.. E5h.. C5q Rq Rq "
				+ "E5i D5q E5q F5q G5h.. E5h.. C5q E5i F5q E5q D5q C5q A4q A4q C5q.. Ri C5i G5q G5i D5q D5q. C5i C5q.. ");
		

		Panel.player.play(pattern1);
	} 
	

	@Override
	public void play() {
		playSundayMorning();
		
	}

}
