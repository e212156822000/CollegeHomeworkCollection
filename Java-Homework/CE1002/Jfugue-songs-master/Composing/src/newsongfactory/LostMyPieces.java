package newsongfactory;

import org.jfugue.Pattern;


public class LostMyPieces implements Song {
	
	public void playLostMyPieces() {
		Pattern player1 = new Pattern("V0");
		Pattern pattern1 = new Pattern("T[90] I[Celesta] D7i G6i F#6i D7q. E7q B6w " + "C6h+E6h+G6h+B6i C7i B6i A6i G6i F#6i G6i A6i D6h "
		+ "F#6q G6q A6h F#6q A6q D7h A6h B6h A#6h B6w " + "C6h+E6q F#6q B5h+G6q D6q C6h+E6q F#6q G6q A6q B6w A6h " 
		+ "I[STRING_ENSEMBLE_1] B5q C6q E5w+G5w+D6i E6i D6i G6i F#6i D6i A5i E6i D5h+F#5h+A5h+D6h A5q C6q E5w+G5w+B5i C6i B5i E6i D6i G5i A5i C6i B5h "
		+ "G5q A5q E5w+G5w+D6i E6i D6i G6i F#6i D6i A5i E6i D6q G6q A6q C7q G6h+B6h D6h+A6h E6h+G6h D6h+F#6h " 
		+ "I[Celesta] Rh. D6i+D7i G5i+G6i F#5i+F#6i D6q.+D7q. E6q+E7q G5w+D6w+B6w B5i+E6h+G6h+B6i C6i+C7i B5i+B6i A5i+A6i G5i+C6h+G6i F#5i+F#6i G5i+G6i A5i+A6i "
		+ "D5h+D6h F#5q+F#6q G5q+G6q A5h+E6h+A6h F#5q+F#6q A5q+A6q D6h+F#6h+D7h A5h+A6h B5h+F#6h+B6h A#5h+F#6h+A#6h B5h.+B6h. Rs " 
		+ "I[Atmosphere] B5i+B6i C6i+C7i D6i+E6i+G6i+D7i E6i+E7i D6i+D7i G6i+G7i F#6i+F#7i D6i+D7i A5i+A6i E6i+E7i D6h+F#6h+A6h+D7h A5q+A6q C6q+C7q B5i+E6i+G6i+B6i " 
		+ "C6i+C7i B5i+B6i E6i+E7i D6i+D7i G5i+G6i A5i+A6i C6i+C7i B5h+B6h G5q+G6q A5q+A6q D6i+E6i+G6i+D7i E6i+E7i D6i+D7i G6i+G7i F#6i+F#7i D6i+D7i A5i+A6i E6i+E7i "
		+ "D6q+A6q+D7q G5q+D6q+G6q A5q+F#6q+A6q C6q+A6q+C7q B5h+G6h+B6h A5h+D6h+A6h G5w+E6w+G6w "
		+ "I[Celesta] D6i+D7i G5i+G6i F#5i+F#6i D6i+D7i Rq E6q F#6h G6h F#6w+G6w+G7w Rw ");
		player1.add(pattern1);
		
		Pattern player2 = new Pattern("V1");
		Pattern pattern2 = new Pattern("T[90] I[Celesta] E4i B4i F#5i D6h Ri D4h+F#4h A5h+D6h+F#6h C4h C5h+E5h+G6h+C6h B3i G4i A4i D5i_D5h C4i G4i A4i A5i A5h " 
		+ "B3i+A4i D4i F#4i D5i+A5i D5h+A5h F#3h+C#4h+E4h C#5h B3h+D#4h+F#4h F#5h+B5h A3h G3h C4w C#4w+G4w B3h+F#4h Rh " 
		+ "I[Music_Box] C3i+C4i G3i C4i E4i G4i B4i E5i B4i D3i+D4i A3i D4i F#4i A4i D5i F#5i D5i E3i+E4i B3i E4i G4i B4i E5i B4i G4i D3i+D4i A3i D4i F#4i A4i D5i F#5i D5i "
		+ "C3i+C4i G3i C4i E4i G4i B4i E5i G5i D3i+D4i A3i D4i F#4i A4q D5q E3i+E4i G4i B4i E5i D3i+D4i F#4i A4i D5i C3i+C4i E4i G4i C5i D3i+D4i F#4i A4i D5i+F#5i+A5i "
		+ "I[Celesta] Rh. E4i B4i E5i F#5i G5h D4h+F#4h A5h+D6h+F#6h C4h C5h+E5h B3i G4i A4i D5i_D5h C4i G4i A4i A5i A5h B3i+A4i D4i F#4i D5i+A5i D5h+A5h F#3h+C#4h+E4h C#5h B3h.+D#4h.+F#4h. Rq "
		+ "I[Music_Box] Rs C3i+C4i G3i C4i E4i C4i+G4i B4i G4i+E5i B4i D3i+D4i A3i D4i F#4i D4i+A4i D5i A4i+F#5i D5i E3i+E4i B3i E4i G4i E4i+B4i E5i E4i+B4i G4i D3i+D4i A3i D4i F#4i D4i+A4i D5i A4i+F#5i D5i C3i+C4i G3i C4i E4i C4i+G4i B4i G4i+E5i G5i D3i+D4i A3i D4i F#4i D4q+A4q D4q+A4q+D5q "
		+ "E3i+E4i B4i E5i G5i D3i+D4i A4i D5i F#5i C3i+C4i C5i E5i G5i_G5h "
		+ "I[Celesta] C5w+F#5w C5w+F#5w G4w+D5w+F#5w Rw ");
		player2.add(pattern2);
		
		Pattern player3 = new Pattern("V2");
		Pattern pattern3 = new Pattern("T[90] I[Music_Box] D7i G6i F#6i D7q. E7q B6w " + "C6h+E6h+G6h+B6i C7i B6i A6i G6i F#6i G6i A6i D6h "
		+ "F#6q G6q A6h F#6q A6q D7h A6h B6h A#6h B6w " + "C6h+E6q F#6q B5h+G6q D6q C6h+E6q F#6q G6q A6q B6w A6h " 
		+ "I[Dulcimer] B5q C6q E5w+G5w+D6i E6i D6i G6i F#6i D6i A5i E6i D5h+F#5h+A5h+D6h A5q C6q E5w+G5w+B5i C6i B5i E6i D6i G5i A5i C6i B5h "
		+ "G5q A5q E5w+G5w+D6i E6i D6i G6i F#6i D6i A5i E6i D6q G6q A6q C7q G6h+B6h D6h+A6h E6h+G6h D6h+F#6h " 
		+ "I[Music_Box] Rh. D6i+D7i G5i+G6i F#5i+F#6i D6q.+D7q. E6q+E7q G5w+D6w+B6w B5i+E6h+G6h+B6i C6i+C7i B5i+B6i A5i+A6i G5i+C6h+G6i F#5i+F#6i G5i+G6i A5i+A6i "
		+ "D5h+D6h F#5q+F#6q G5q+G6q A5h+E6h+A6h F#5q+F#6q A5q+A6q D6h+F#6h+D7h A5h+A6h B5h+F#6h+B6h A#5h+F#6h+A#6h B5h.+B6h. Rs " 
		+ "I[Dulcimer] B5i+B6i C6i+C7i D6i+E6i+G6i+D7i E6i+E7i D6i+D7i G6i+G7i F#6i+F#7i D6i+D7i A5i+A6i E6i+E7i D6h+F#6h+A6h+D7h A5q+A6q C6q+C7q B5i+E6i+G6i+B6i " 
		+ "C6i+C7i B5i+B6i E6i+E7i D6i+D7i G5i+G6i A5i+A6i C6i+C7i B5h+B6h G5q+G6q A5q+A6q D6i+E6i+G6i+D7i E6i+E7i D6i+D7i G6i+G7i F#6i+F#7i D6i+D7i A5i+A6i E6i+E7i "
		+ "D6q+A6q+D7q G5q+D6q+G6q A5q+F#6q+A6q C6q+A6q+C7q B5h+G6h+B6h A5h+D6h+A6h G5w+E6w+G6w "
		+ "I[Music_Box] D6i+D7i G5i+G6i F#5i+F#6i D6i+D7i Rq E6q F#6h G6h F#6w+G6w+G7w Rw ");
		player3.add(pattern3);
		
		Pattern finalPattern = new Pattern();
		finalPattern.add(player1);
		finalPattern.add(player2);
		finalPattern.add(player3);
		
		Panel.player.play(finalPattern);
	}

	@Override
	public void play() {
		playLostMyPieces();
	} 


}
