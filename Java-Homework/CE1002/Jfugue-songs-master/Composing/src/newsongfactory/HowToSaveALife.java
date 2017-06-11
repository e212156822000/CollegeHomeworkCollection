package newsongfactory;

import org.jfugue.Pattern;

public class HowToSaveALife implements Song {

	public void playHowToSaveALife() {
		Pattern G1_1 = new Pattern("T[120] I[PIANO] " + 
										"Rw " +
										"Rw " +
										"Rw " +
										"Rq. C6q C6i D6q. " + 
										"D6i F6q. F6i F6q. " + 
										"E6i_E6i D6q D6i D6q. " + 
										"D6i F6q F6q F6q " + 
										"Eb6q Eb6q. C6q F6i_Bb5i " +
										"Rq. D6i F6q F6i F6q " +
										"Eb6q. Eb6i_D6i D6h " + 
										"Rq D6q D6q D6i D6q " + 
										"C6q. C6i D6q Bb5i " + 
										"Rq Bb6q Bb6q Bb6i Bb6q " +
										"C7q C7q. Bb6i_Bb6i " +
										"Rq C7i C7q D7q D7q. " +
										"D7i C7q Bb6i_C7i C7q. " + 
										"Bb6i C7q. Bb6i C7h " +
										"Bb6i C7q D7i_Bb6i " +
										"Rq D7i_C7i D7q F7i D7q " +
										"C7q A6q C7i Bb6q ");
		
		Pattern G2 = new Pattern("T[120] I[ACOUSTIC_BASS] " + 
										"Bb5w " + 
										"C6w " + 
										"D6w " + 
										"A5h Rh Ri " +
										"Bb5w " + 
										"C6w " + 
										"Rw " + 
										"Rq A5h Rh " + 
										"Bb5w " + 
										"C6w " + 
										"Rw " + 
										"A5h Rh " +
										"Bb5w " +
										"C6w " +
										"D6w " +
										"Rw " +
										"Bb5w " +
										"C6w " +
										"D6w " +
										"Rw");
		
		Pattern F1 = new Pattern("T[120] I[PIANO] " + 
										"Ri F5i_D5i F5q F5i D5i_F5i " + 
										"Ri F5i_D5i F5q F5i D5i_F5i " + 
										"Ri F5i_D5i F5q F5i D5i_F5i " +
										"Ri F5q F5q Ri F5i D5i_F5i " + 
										"Ri F5i_D5i F5q F5q F5i " + 
										"Ri F5i_D5i F5q F5i D5i_F5i " + 
										"Ri F5i_D5i F5q F5i D5i_F5i " + 
										"Ri F5q F5q Rq F5i D5i_F5i " +
										"Ri F5i_D5i F5q F5q F5i " +
										"Ri F5i_D5i F5q F5i D5i_F5i " + 
										"Ri F5i_D5i F5q F5i D5i_F5i " +
										"Ri F5q F5q F5i D5i_F5i " +
										"Ri F5i_D5i F5q F5q F5i " +
										"Ri F5i_D5i F5q F5i D5i_F5i " +
										"Ri F5i_D5i F5q F5i D5i_F5i " +
										"Ri F5q F5q F5i C5i_F5i " +
										"Ri F5i_C5i F5q F5q F5i " +
										"Ri F5i_C5i F5q F5i C5i_F5i " +
										"Ri F5i_C5i F5q F5i C5i_F5i " +
										"Ri F5q. F4h+A3h ");
		
		Pattern F2 = new Pattern("T[120] I[ACOUSTIC_BASS] " + 
										"Bb4w " +
										"A4w ");
		
		Pattern introAndVerse = new Pattern();
		
		Pattern voice = new Pattern("V0");
		voice.add(G1_1);
		introAndVerse.add(voice);
		
		voice = new Pattern("V1");
		voice.add(G2);
		introAndVerse.add(voice);
		
		voice = new Pattern("V2");
		voice.add(F1);
		introAndVerse.add(voice);
		
		voice = new Pattern("V3");
		voice.add(F2, 10);
		introAndVerse.add(voice);
		
		G1_1 = new Pattern("T[120] I[PIANO] " + 
								"G5q F6i G5q+C6q E5q+G5q+B5q C6q. " +
								"F5q+A5q C6i F5q+A5q+D6q C5i+A5i_C5i+A5i D5q.+G5q.+Bb5q. " +
								"F6i G5q.+C6q. G5i+Bb5i D5q+F5q+C6q " + 
								"C6i D5q+C6i_C#6i F5i+Cn6i F5q+C6q F5i+Bb5i " +
								"E5q+G5q+Bb5q F6i G5q+C6q Bb5i_E5i+G5i+C6i C6q. " + 
								"F5q+A5q Bb5i F5q_A5q+D6q C5q+A5q D5q.+Bb5q. " +
								"F6i G5q+C6q D5q.+G5q.+Bb5q. " +
								"Bb5q Bb5i C6q. A5i Bb5w");

		G2 = new Pattern("T[120] I[ACOUSTIC_BASS] " + 
								"G5q F6i G5q+C6q E5q+G5q+B5q C6q. " +
								"F5q+A5q C6i F5q+A5q+D6q C5i+A5i_C5i+A5i D5q.+G5q.+Bb5q. " +
								"F6i G5q.+C6q. G5i+Bb5i D5q+F5q+C6q " + 
								"C6i D5q+C6i_C#6i F5i+Cn6i F5q+C6q F5i+Bb5i " +
								"E5q+G5q+Bb5q F6i G5q+C6q Bb5i_E5i+G5i+C6i C6q. " + 
								"F5q+A5q Bb5i F5q_A5q+D6q C5q+A5q D5q.+Bb5q. " +
								"F6i G5q+C6q D5q.+G5q.+Bb5q. " +
								"Rw ");

		F1 = new Pattern("T[120] I[PIANO] " + 
								"Eb3q. Eb3q Eb3q. " + 
								"F3q. F3q F3q. " + 
								"G3q. G3q G3q. " + 
								"Bb3h A3i A3q A3i " +
								"E3q. E3q E3q. " +
								"F3q. F3q F3q. " +
								"G3q. G3q G3q. " +
								"Bb3h A3h ");

		F2 = new Pattern("T[120] I[ACOUSTIC_BASS] " +
								"Eb3q. Eb3q Eb3q. " + 
								"F3q. F3q F3q. " + 
								"G3q. G3q G3q. " + 
								"Bb3h A3i A3q A3i " +
								"E3q. E3q E3q. " +
								"F3q. F3q F3q. " +
								"G3q. G3q G3q. " +
								"Rw ");
	
		Pattern chorus = new Pattern();
		
		voice = new Pattern("V0");
		voice.add(G1_1);
		chorus.add(voice);
		
		voice = new Pattern("V1");
		voice.add(G2);
		chorus.add(voice);
		
		voice = new Pattern("V2");
		voice.add(F1);
		chorus.add(voice);
		
		voice = new Pattern("V3");
		voice.add(F2);
		chorus.add(voice);

		Pattern song = new Pattern();
		song.add(introAndVerse);
		song.add(chorus);
		
		Panel.player.play(song);
	}

	@Override
	public void play() {
		playHowToSaveALife();
	}
}
