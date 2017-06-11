package newsongfactory;

import org.jfugue.Pattern;

public class AThousandMiles implements Song {
	
	public void playAThousandMiles() {
		String m_intro = "Rq Rw Rw Rw Rw ";
		
		String m_verse = "F#5s F#5s F#5s F#5s- F#5-s C#5i C#5s- C#5-i. D#5s- D#5-s C#5i C#5s- C#5-i. D#5s- D#5-s C#5i C#5s- C#5-s C#5s B4s D#5s- D#5-s B4i. " +
						 "Rw Rw F#5s F#5i F#5s- F#5-s D#5s D#5s D#5s- D#5-i. B4s D#5s C#5s C#5s C#5s- C#5-i. D#5s- D#5-s C#5s C#5s C#5s- C#5-s- B4-i D#5s- D#5-s C#5i. C#5i.- C#5-s- C#5-i- B4-i- B4-q Rq Rw ";
		
		String rh_intro = "Ri. B5s B6s B5s B6s A#6s B5s A#6s F#6i- F#6-q D#6i C#6s B5s B6s B5s B6s A#6s B5s A#6s F#6s B5s F#6s B5s F#6s B5s D#6s E6s D#6s B5s " +
						   "B6s B5s B6s A#6s B5s A#6s F#6i- F#6-q D#6i C#6s B5s D#6s C#6s B5s D#6s C#6s B5s F#6s- F#6-q C#6q ";
		
		String rh_verse = "B5i. A#5s Rq F#5i. E5s. Rq B5i. A#5s. Rq F#5i. E5s. Ri. B4s " +
						   "B5s B4s B5s A#5s B4s A#5s F#5s B4s F#5s B4s F#5s B4s D#5i C#5s B4s B5s B4s B5s A#5s B4s A#5s F#5s B4s F#5s B4s F#5s B4s D#5s E5s D#5s C#5s " +
						   "B6i.+B5i. A#6s.+A#5s Rq F#6i.+F#5i. E6s.+E5s Rq B5i. A#5s. Rq F#5i. E5s. Ri. B4s " +
						   "B5s B4s B5s A#5s B4s A#5s F#5s B4s F#5s B4s F#5s B4s D#5i C#5s B4s B5s B4s B5s A#5s B4s A#5s F#5s B4s F#5s B4s F#5s B4s D#5s E5s D#5s C#5s ";
					
		String m_coda = "Rh+Rq Ri. B4s Rs+B4i B4s B4i+B4i D#5i C#5-s B4-s Rh+Rq Ri. B4s Rs+B4i B4s B4i+B4i F#5i C#5i " +
						"Rh Ri B4i D#5i C#5i B4h A#4q Ri. ";
		
		String rh_coda = "B5s+E5s+F#5s B5s+E5s+F#5s B5s+E5s+F#5s D#6s+B5s+E5s+F#5s D#6s+B5s+E5s+F#5s D#6s+B5s+E5s+F#5s C#6i+F#5i+C#5i. Rh B5s+E5s+F#5s B5s+E5s+F#5s B5s+E5s+F#5s D#6s+B5s+E5s+F#5s D#6s+B5s+E5s+F#5s D#6s+B5s+E5s+F#5s C#6i+F#5i+C#5i. Rh " +
						 "B5s+E5s+F#5s B5s+E5s+F#5s B5s+E5s+F#5s D#6s+B5s+E5s+F#5s D#6s+B5s+E5s+F#5s D#6s+B5s+E5s+F#5s C#6i.+F#5i.+C#5i. Rh B4h+F#5w A#4h ";
		
		String m_chorus = "A4s A#4i. B4s- B4-i F#5i- F#5-q Ri A#4i " +
			    	      "A#4i. B4s- B4-i G#4i- G#4-q Ri. A#4s A#4i. B4s- B4-i F#5i- F#5-q Ri A#4i " +
			    	      "A#4i. B4s- B4-i B4i- B4-q Ri A#4i A#4i. B4s- B4-i F#5i- E5-i D#5q D#5i " +
			    	      "D#5i. D#5s- D#5-i D#5s- C#5-s- B4-i B4s B4s- B4-i A#4i B4q Ri D#5i. D#5i- C#5-i C#5q- " +
			    	      "C#5-q Rq Ri. B4s B4q Rh Rh Rq Ri. B4s ";
			    	     
		String rh_chorus =  "A#5i. B5s- B5-i F#6i+F#5i A#5i. B5s- B5-i F#6i+F#5i A#5i. B5s- B5-i F#6i+F#5i A#5i. B5s- B5-i F#6i+F#5i " +
		   	 "A#5i.+F#5i. B5s- B5-i F#6i+F#5i F#5i.+A#5i. B5s- B5-i F#6i+F#5i A#5i.+F#5i. B5s- B5-i F#6i+F#5i F#5i.+A#5i. B5s- B5-i F#6i+F#5i " +
			 "A#5i.+F#5i. B5s- B5-i F#6i+F#5i F#5i.+A#5i. A#5i.+F#5i. B5s- B5-i F#6i+F#5i F#5i.+A#5i. B6q.+F#6q.+B5q. C#7i+F#6i+C#6i- C#7-q+F#6-i+C#6-i A#6-q+F#6-q+A#5-q- " +
			 "A#6-h.+F#6-h.+A#5-h. Ri. B5s B6s B5s B6s A#6s B5s A#6s F#6s B5s F#6s B5s F#6s B5s D#6i C#6s B5s " +
			 "B6s B5s B6s A#6s B5s A#6s F#6s B5s F#6s B5s F#6s B5s D#6s E6s D#6s B5s ";
	 
		String m_bridge = "Rw Rw Ri. " +
				"B4s A#4i.- B4-s -B4-q A#4i.- B4-s- B4-q " +
				"Ri A#4i A#4i B4i C#5i. D#5s- D#5-i A#4i A#4i.- B4-s- B4-q A#4i.- B4-s- B4-q " +
				"Ri A#4i A#4i B4i C#5i. D#5s- D#5-i D#5i A#4i.- B4-s- B4-q A#4i.- B4-s- B4-q " +
				"Ri A#4i A#4i B4i C#5i. D#5s- D#5-i A#4i A#4i.- B4-s- B4-q A#4i.- B4-s- B4-s C#5s. B4i- B4-h Rh ";
				
		String rh_bridge = 
				"D#6s C#6s B5s D#6s C#6s B5s F#6i-+A#6i- F#6-i+A#6-i C#6i C#6s D#6s C#6s B5s C#6i.+A#5i.+F#5i.+C#5i. C#6s+A#5s+F#5s+C#5s -|- C#6i+A#5i+F#5i+C#5i C#6i+A#5i+F#5i+C#5i C#6i.+A#5i.+F#5i.+C#5i. C#6s-+A#5s-+F#5s-+C#5s- C#6-i+A#5-i+F#5i+C#5i C#6i+A#5i+F#5i+C#5i " +
				"C#6i.+A#5i.+F#5i.+C#5i. C#6s-+A#5s-+F#5s-+C#5s- C#6-i+A#5-i+F#5-i+C#5-i C#6i+A#5i+F#5i+C#5i C#6i.+A#5i.+F#5i.+C#5i. C#6s+A#5s-+F#5s-+C#5s- C#6-i+A#5-i+F#5-i+C#5-i C#6i+A#5i+F#5i+C#5i C#6i.+A#5i.+F#5i.+C#5i. C#6s+A#5s+F#5s+C#5s -|- C#6i+A#5i+F#5i+C#5i C#6i+A#5i+F#5i+C#5i C#6i.+A#5i.+F#5i.+C#5i. C#6s+A#5s+F#5s+C#5s -|- C#6i+A#5i+F#5i+C#5i C#6i+A#5i+F#5i+C#5i " +
				"C#6i.+A#5i.+F#5i.+C#5i. C#6s-+A#5s-+F#5s-+C#5s- C#6-i+A#5-i+F#5-i+C#5-i C#6i+A#5i+F#5i+C#5i C#6i.+A#5i.+F#5i.+C#5i. C#6s+A#5s-+F#5s-+C#5s- C#6-i+A#5-i+F#5-i+C#5-i C#6i+A#5i+F#5i+C#5i C#6i.+A#5i.+F#5i.+C#5i. C#6s+A#5s+F#5s+C#5s -|- C#6i+A#5i+F#5i+C#5i C#6i+A#5i+F#5i+C#5i C#6i.+A#5i.+F#5i.+C#5i. C#6s+A#5s+F#5s+C#5s -|- C#6i+A#5i+F#5i+C#5i C#6i+A#5i+F#5i+C#5i " +
				"C#6i.+A#5i.+F#5i.+C#5i. C#6s-+A#5s-+F#5s-+C#5s- C#6i-+A#5i-+F#5i-+C#5-i C#6i+A#5i+F#5i+C#5i C#6i.+A#5i.+F#5i. C#6s-+A#5s-+F#5s- C#6-i+A#5-i+F#5-i C#6i+A#5i+F#5i A#6i.+F#5i.+A#5i. B5s-+F#5s-+B6s- B5-i+F#5-i+B6-i C#6i A#6i.+F#5i.+A#5i. B5s+F#5s+B6s -|- C#6i+F#5i+B6i+C#7i -|- B6w+C#7w+F#6w+C#6w " +
				"B5s+E5s+F#5s B5s+E5s+F#5s B5s+E5s+F#5s B5s+E5s+F#5s+D#6s B5s+E5s+F#5s+D#6s B5s+E5s+F#5s+D#6s C#5i.+F#5i+C#6i Ri B6i+B5i D#7i+D#6i C#7i+C#6i T[75] B6h+F#6h+B5h T[90] ";
		
		String rh_last = //chorus
				"A#6w+F#6w+A#5w A#5i.+F#5i. B5s- B5i F#6i+F#5i A#5i. B5s- B5i F#6i+F#5i " +
				"A#5i. B5s- B5-i F#6i+F#5i A#5i. B5s- B5-i F#6i+F#5i A#5i.+F#5i. B5s- B5-i F#6i+F#5i A#5i. B5s- B5-i F#6i+F#5i " +
				"A#5i. B5s- B5-i F#6i+F#5i A#5i. B5s- B5-i F#6i+F#5i A#5i.+F#5i. B5s- B5i F#6i+F#5i A#5i. B5s- B5-i F#6i+F#5i " +
				"A#5i.+F#5i. B5s- B5-i F#6i+F#5i A#5i.+F#5i B5s- B5-i F#6i+F#5i B6q.+F#6q.+B5q. C#7i-+F#6i-+C#6i- C7-q+F#6-q+C6-q A#6q-+F#6q-+A#5q- " +
				"A#6-w+F#6-w+A#5-w A#5i. B5s- B5-i F#6i+F#5i A#5i. B5s- B5-i F#6i+F#5i " +
				"A#5i. B5s- B5-i F#6i+F#5i A#5i. B5s- B5-i F#6i+F#5i A#5i. B5s- B5-i F#6i+F#5i A#5i. B5s- B5-i F#6i+F#5i " +
				"A#5i. B5s- B5-i F#6i+F#5i A#5i. B5s- B5-i F#6i+F#5i A#5i.+F#5i. B5s- B5-i F#6i+F#5i A#5i.+F#5i. B5s- B5-i F#6i+F#5i " +
				"A#5i.+F#5i B5s- B5-i F#6i+F#5i A#5i.+F#5i B5s- B5-i F#6i+F#5i B6q.+F#6q.+B5q. C#7i-+F#6i-+C#6i- C#7-q+F#6-q+C#6-q A#6q-+F#6q-+A#5q- " +
				//if i could just
				"A#6-w+F#6-w+A#5-w B5q.+F#5q. C#5i-+F#5i- C#5-q+F#5-q A#5q-+F#5q- A#5-h.-+F#5-h.- A#5-i+F#5-i B5s " +
				"B6s B5s B6s A#6s B5s A#6s F#6i- F#6-q D#6i C#6s B5s B6s B5s B6s A#6s B5s A#6s F#6s B5s F#6s B5s F#6s B5s D#6s E6s D#6s B5s " +
				"B6s B5s B6s A#6s B5s A#6s F#6i- F#6-q D#6i C#6s B5s D#6s C#6s B5s D#6s C#6s B5s F#6s- F#6-q B5q+C#6q- B5-q+C#6q Rq Rh I[APPLAUSE] C#6s C#6s C#6s ";
		
		Pattern melody = new Pattern(m_intro + m_verse + m_coda + m_chorus + "Rh " + m_verse + m_coda + m_chorus + m_bridge);
		Pattern righthand = new Pattern(rh_intro + rh_verse + rh_coda + rh_chorus + rh_verse + rh_coda + rh_chorus + rh_bridge + rh_last );
		
		Pattern pattern = new Pattern();
		pattern.add("T[90] I[Piano] V0 " + melody.getMusicString());
		pattern.add("T[90] I[PIANO] V1 " + righthand.getMusicString());
		
		Panel.player.play(pattern);
	}

	@Override
	public void play() {
		
		playAThousandMiles();
		
	}
}