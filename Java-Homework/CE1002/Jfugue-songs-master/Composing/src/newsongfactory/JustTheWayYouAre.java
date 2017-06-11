package newsongfactory;

import org.jfugue.Pattern;

public class JustTheWayYouAre implements Song {
	
	public void playJustTheWayYouAre() {
		Pattern intro = new Pattern("T[105] I[Piano] " + // F1
				"A5q+C6q+F6q+F4i_F4q F6q_A5q+C6q+F4i_F4q F6q_A5q+C6q+F4q_F4q A5q+C6q_F4q Bb5i " + // F2
				"G5q+F4i_F4q Bb5q+A5q+F4i Bb5i+A5i+F4q_Bb5q+A5q_F4q " + // Dm1
				"A5i A5q+C6q+F6q+F4i_D4q A5q+C6q+D4i_D4q F6q_A5q+C6q+D4q_D4q A5q+C6q_D4q Bb5i " + // Dm2
				"G5q+D4i_D4q Bb5q+A5q+D4i Bb5i+A5i+D4q_Bb5q+A5q_D4q " + // Bb1
				"A5q+C6q+F6q+Bb3i_Bb3q F6q_A5q+C6q+Bb3i_Bb3q F6q_A5q+C6q+Bb3q_Bb3q A5q+C6q_Bb3q Bb5i " + // Bb2
				"G5q+Bb3i_Bb3q Bb5q+A5q+Bb3i Bb5i+A5i+Bb3q_Bb5q+A5q_Bb3q " + // F1
				"A5q+C6q+F6q+F4i_F4q F6q_A5q+C6q+F4i_F4q F6q_A5q+C6q+F4q_F4q A5q+C6q_F4q Bb5i " + // F2
				"G5q+F4i_F4q Bb5q+A5q+F4i Bb5i+A5i+F4q_Bb5q+A5q_F4q");
		Pattern verse1 = new Pattern(// F1
				"F2q A5i+C6i A5q+C6q+F3q A5q+C6q+F3q A5q+C6q_F3q_C6s_A5s " + // F2
				"C6i.+F2q C6i+F3q A5i C6i+F3q D6i A5i+C6i+F3q A5i+F5i " + // Dm1
				"D2q A5i+C6i A5q+C6q+D3q A5q+C6q+D3q A5q+C6q_D3q_A5i " + // Dm2
				"D2q+C6i_A5s_C6s C6i+D3q_A5i C6s+D3q_D6i_A5i+C6i+D3q_F5i+A5i " + // Bb1
				"R Bb3q Bb5i+Bb4q_A5i Bb5i+Bb4q_A5s_Bb5s Bb5q+Bb4q " + // Bb2
				"Bb3q Bb5i+Bb4q_A5i Bb5i+Bb4q_A5s_Bb5s Bb5q+Bb4i_C6i " + // F
				"A5q+C6q+F6q+F2q F6q_A5q+C6q+F3i F6q_A5q+C6q_F3q A5q+C6q_F3q Bb5i " + // F1
				"F2q A5i+C6i A5q+C6q+F3q A5q+C6q+F3q A5q+C6q_F3q_C6s_A5s " + // F2
				"D2q+C6i_A5s_C6s_C6s C6i+D3q_A5i C6s+D3q_D6i_A5i+C6i+D3q_F5i+A5i " + // Dm1
				"F2q A5i+C6i A5q+C6q+F3q A5q+C6q+F3q A5q+C6q_F3q_C6s_A5s " + // Dm2
				"C6i.+F2q C6i+F3q A5i C6i+F3q D6i A5i+C6i+F3q A5i+F5i " + // Bb1
				"Bb3q A5s Bb5i+Bb4i_A5s_Bb5s Bb5i+Bb4i_A5s_Bb5s Bb5i+Bb4i_A5s " + // Bb2
				"C6i+Bb3i_F5s_F5s F5i+Bb4i_F5i F5i+Bb4i_F5i_G5i+Bb4i+A5i " + // F1
				"A5q+C6q+F6q+F2q F6q_A5q+C6q+F3i F6q_A5q+C6q_F3q A5q+C6q_F3q Bb5i ");
		Pattern chorus = new Pattern( //F1 
				"T[185] A5q+F3q F4q+C6q_C6q F6i+F4q G6q F4q A6i+F6i+C6i_" //F2
				+ "F6i+F3w F4q_F6i+F4q_A5i+C6i+F4q A5i+C6i+F4q_C6i+A5i+F4q_F4q_Bb5s+F4q_" //F3
				+ "A5i+Bb2w F4q F4q C6i+F4q F6i+F4q G6i+F4q F4q A6i+F6i+D6i+F4q " //Dm1
				+ "A6i+F6i+D6i+Bb2w G6i+D6i+F4q F4q F6i+D6i+F4q F6i+D6i+F4q G6i+D6i+F4q F4q F6i+D6i+F4q " //Dm2
				+ "F6i+D6i+F3w F4q F4q A5i+F4q F6i+F4q F4q+G6i F4q F6i+D6i+A6i+F4q " //Bb1
				+ "D4w+F6i+D6i+A6i G6q.+D6q.+D4q D4q D4q D4q D4q D4q D4q+D6i+F6i+Bb6i " //Bb2
				+ "D4w+F6i+D6i+Bb6i A6i+D6i+F6i+D4q D4q D4q+D6i+F6i D4q+D6i+F6i G6q+D4q D4q D4q.+A5i.+C6i.+F6i. " //F1
				+ "A5i+C6i+F6i+G3w G4w F6i+G4w C6q+A5q+G4q C6i+A5i+G4q C6q+A5q+D4q D4q Bb5i+D4q "
				+ "A5q+F3q F4q+C6q C6q F6i+F4q G6q F4q A6i+F6i+C6i " //F2
				+ "F6i+F3w F4q F6i F4q A5i+C6i A5i+C6i F4q C6i+A5i F4q F4q Bb5s+F4q " //F3
				+ "A5i+Bb2w F4q F4q C6i+F4q F6i+F4q G6i+F4q F4q A6i+F6i+D6i+F4q " //Dm1
				+ "A6i+F6i+D6i+Bb2w G6i+D6i+F4q F4q F6i+D6i+F4q F6i+D6i+F4q G6i+D6i+F4q F4q F6i+D6i+F4q " //Dm2
				+ "F6i+D6i+F3w F4q F4q A5i+F4q F6i+F4q F4q+G6i F4q F6i+D6i+A6i+F4q " //Bb1
				+ "D4w+F6i+D6i+A6i G6q.+D6q.+D4q D4q D4q D4q D4q D4q D4q+D6i+F6i+Bb6i " //Bb2
				+ "D4w+F6i+D6i+Bb6i A6i+D6i+F6i+D4q D4q D4q+D6i+F6i D4q+D6i+F6i G6q+D4q D4q D4w+A5w+C6w+F6w "
				);
		Pattern song = new Pattern();
		song.add(intro);
		song.add(verse1);
		song.add(chorus);
		
		Panel.player.play(song);
	}

	@Override
	public void play() {
		playJustTheWayYouAre();
	}

}