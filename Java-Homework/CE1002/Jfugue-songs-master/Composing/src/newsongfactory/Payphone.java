package newsongfactory;

import org.jfugue.Pattern;

public class Payphone implements Song{
	
	private void playPayphone()
	{
		Pattern left = new Pattern("T[100] I[Piano] V0 " 
				+ "D#6i E6i F#6i B6i C#7q B6q B6i A#6i F#6i E6i- E6-q E6q E6i D#6i B5i E6i-  E6-i D#6q C#6i- C#6-i B5i D#6i C#6i- C#5-h D#6i E6i F#6i B6i " //1
				+ "C#7q B6q B6i A#6i F#6i E6i-  E6-q E6q E6i D#6i B5i E6i-  E6-i D#6q C#6i- C#6-i B5i D#6i C#6i- C#6-h Ri B5q B5i " //5
				+ "Ri. B5s D#6s F#6i F#6s- F#6-s D#6i C#6s D#6i C#6i Ri. Rs B5s D#6s F#6i F#6s- F#6-s D#6i C#6s D#6q Ri. B5s D#6s F#6i F#6s- F#6-s D#6i C#6s C#6i C#6i Ri. B5s D#6s F#6i F#6s- F#6-s G#6i D#6s D#6q " //9
				+ "Rq B5s D#6s F#6i F#6s- F#6-s D#6i C#6s D#6i C#6i Ri. Rs B5s D#6s F#6i F#6s- F#6-s D#6i C#6s D#6q Ri.. Rx B5s D#6s F#6i F#6s- F#6-s D#6i C#6s C#6i C#6i E6i. D#6s- D#6-i B5i E6i. D#6s- D#6-i C#6i " //13
				+ "D#6q D#6q+B5q D#6i.+B5i. D#6s-+B5s- D#6-i+B5-i C#6i D#6q D#6q+B5q D#6i.+B5i. D#6s-+B5s- D#6-i+B5-i C#6i D#6q D#6q+B5q D#6i.+B5i. D#6s-+B5s- D#6-i+B5-i C#6i C#6q+A#5q A#5q+F#5q A#5i.+F#5i. B5s-+F#5s- B5-i+F#5-i F#6i.+A#5i. " //17
				+ "D#6q+B5q D#6q+B5q D#6i.+B5i. D#6s-+B5s- D#6-i+B5-i C#6i D#6q+B5q D#6q+B5q D#6i.+B5i. D#6s-+B5s- D#6-i+B5-i C#6i D#6q+B5q D#6q+B5q D#6i.+B5i. D#6s-+B5s- D#6-i+B5-i C#6i C#6h+A#5h D#6i E6i F#6i B6i " //21
				+ "C#7q+E6q B6q+E6q B6i+E6i A#6i F#6i E6i-+B5i- E6-q+B5-q E6q+B5q E6i+B5i D#6i B5i E6i-+B5i- E6-i+B5-i D#6q+B5q C#6i-+G#5i- C#6-i+G#5-i B5i D#6i C#6i-+F#5i- C#6-h+F#5-h D#6i E6i F#6i B6i " //25
				+ "C#7q+E6q B6q+E6q B6i+E6i A#6i F#6i E6i-+B5i- E6-q+B5-q E6q+B5q E6i+B5i D#6i B5i E6i-+B5i- E6-i+B5-i D#6q+B5q C#6i-+G#5i- C#6-i+G#5-i B5i D#6i C#6i-+F#5i- C#6-q.+F#5-q. B5i D#6i+B5i E6i D#6i C#6i " //29
				+ "C#6i.+E5i. B5s-+E5s- B5-i+E5-i B5i-+E5i- B5-s+E5-s C#6i.+E5i. D#6q-+B5q- D#6-h+B5-h Rx D#6i+B5i E6i D#6i C#6i C#6i.+D#5i. B5s-+D#5s- B5-i+D#5-i B5i-+D#5i- B5-s+D#5-s F#6i.+B5i. C#6q-+F#5q- C#6-h+F#5-h D#6i+F#5i E6i D#6i C#6i. " //33
				+ "C#6i.+E5i. B5s-+E5s- B5-i+E5-i B5i-+E5i- B5-s+E5-s C#6i.+E5i. D#6q-+B5q- D#6-h+B5-h Rx D#6i+B5i E6i D#6i C#6i C#6i.+G#5i. B5s-+G#5s- B5-i+G#5-i B5i-+G#5i- B5-s+G#5-s F#6i.+B5i. C#6q-+F#5q- C#6-q+F#5-q D#6i-+F#5i- D#6-h+F#5-h Ri Ro " //37
				+ "Ri. B5s D#6s F#6i+B5i F#6s-+B5s- F#6-s+B5-s D#6i+B5i C#6s D#6i C#6i Ri.. B5s D#6s F#6i+B5i F#6s-+B5s- F#6-s+B5-s D#6i+B5i C#6s D#6q Rq B5s D#6s F#6i+B5i F#6s-+B5s- F#6-s+B5-s D#6i+B5i C#6s C#6i C#6i Ri.. B5s D#6s F#6i+B5i F#6s-+B5s- F#6-s+B5-s G#6i+B5i C#6s D#6i+B5i C#6s B5i " // 41
				+ "Ri. B5s D#6s F#6i+B5i F#6s-+B5s- F#6-s+B5-s D#6i+B5i C#6s D#6i C#6i Rq B5s D#6s F#6i+B5i F#6s-+B5s- F#6-s+B5-s D#6i+B5i C#6s D#6q Ri.. B5s D#6s F#6i+B5i F#6s-+B5s- F#6-s+B5-s D#6i+B5i C#6s C#6i C#6i E6i.+B5i. D#6s-+B5s- D#6-i+B5-i B5i E6i.+B5i. D#6s-+B5s- D#6-i+B5-i C#6i " //45
				+ "D#6q+B5q D#6q+B5q D#6i.+B5i. D#6s-+B5s- D#6-i+B5-i C#6i D#6q+B5q D#6q+B5q D#6i.+B5i. D#6s-+B5s- D#6-i+B5-i C#6i D#6q+B5q D#6q+B5q D#6i.+B5i. D#6s-+B5s- D#6-i+B5-i C#6i C#6q+A#5q A#5q+F#5q A#5i.+F#5i. B5s-+F#5s- B5-i+F#5-i F#6i.+A#5i. " //49		
				+ "D#6q+B5q D#6q+B5q D#6i.+B5i. D#6s-+B5s- D#6-i+B5-i C#6i D#6q+B5q D#6q+B5q D#6i.+B5i. D#6s-+B5s- D#6-i+B5-i C#6i D#6q+B5q D#6q+B5q D#6i.+B5i. D#6s-+B5s- D#6-i+B5-i C#6i C#6h+A#5h D#6i E6i F#6i B6i " //53
				+ "C#7q+E6q B6q+E6q B6i+E6i A#6i F#6i E6i-+B5i- E6-q+B5-q E6q+B5q E6i+B5i D#6i B5i E6i-+B5i- E6-i+B5-i D#6q+B5q C#6i-+G#5i- C#6-i+G#5-i B5i D#6i C#6i-+F#5i- C#6-h+F#5-h D#6i E6i F#6i B6i " //57 
				+ "C#7q+E6q B6i+E6i B6i B6i+E6i A#6i F#6i E6i-+B5i- E6-q+B5-q E6q+B5q E6i+B5i D#6i B5i E6i-+B5i- E6-i+B5-i D#6q+B5q C#6i-+G#5i- C#6-i+G#5-i B5i D#6i C#6i-+F#5i- C#6-q.+F#5-q. B5i D#6i+B5i E6i D#6i C#6i " //61
				+ "C#6i.+E5i. B5s-+E5s- B5-i+E5-i B5i-+E5i- B5-s+E5-s C#6i.+E5i. D#6q-+B5q- D#6-h+B5-h Rx D#6i+B5i E6i D#6i C#6i C#6i.+D#5i. B5s-+D#5s- B5-i+D#5-i B5i-+D#5i- B5-s+D#5-s F#6i.+B5i. C#6q-+F#5q- C#6-h+F#5-h D#6i+F#5i E6i D#6i C#6i " //65
				+ "Rx C#6i.+E5i. B5s-+E5s- B5-i+E5-i B5i-+E5i- B5-s+E5-s C#6i.+E5i. D#6q-+B5q- D#6-h+B5-h Rx D#6i+B5i E6i D#6i C#6i C#6i.+G#5i. B5s-+G#5s- B5-i+G#5-i B5i-+G#5i- B5-s+G#5-s F#6i.+B5i. C#6q-+F#5q- C#6-q.+F#5-q. B5i D#6i+B5i E6i D#6i C#6i Rs.. " //69
				+ "B5q+F#5q B5i A#5s B5s F#6i B5i B5q+G#5q B5i+F#5i B5i B5s A#5s B5i F#6i B5i B5q+F#5q B5s+F#5s A#5s B5i F#6q+B5q B5s+F#5s A#5s B5i B5i+F#5i G#5i B5s+F#5s B5s B5s G#5s B5s B5s G#5s B5s D#6i G#5i B5q+F#5q " //73
				+ "B5q+F#5q B5s A#5s B5s F#6s- F#6-i B5i B5q+G#5q Rx. " + "B5i+F#5i B5i B5s A#5s B5s F#6s- F#6-i B5i B5q+F#5q " + "B5s+F#5s A#5s B5i F#6i.+B5i. G#6s-+B5s- G#6-s+B5-s F#6s D#6s B5s G#5s D#5s B4i D#5q. C#5s D#6i E6i F#6i B6i "//77
				+ "C#7q B6q B6i A#6i F#6i E6i- E6-q E6q E6i D#6i B5i E6i- E6-i D#6q C#6i- C#6-i B5i D#6i C#6i- C#6-h D#6i E6i F#6i B6i " //81
				+ "C#7q B6q B6i A#6i F#6i E6i- E6-q E6q E6i D#6i B5i E6i- E6-i D#6q C#6i- C#6-i B5i D#6i C#6i- C#6q. B5i D#6i E6i D#6i C#6i " //85
				+ "C#6i. B5s- B5-i B5i- B5-s C#6i. D#6q- D#6-h D#6i E6i D#6i C#6i C#6i. B5s- B5-i B5i- B5-s F#6i. C#6q- C#6-h D#6i E6i D#6i C#6i  " //89
				+ "C#6i. B5s- B5-i B5i- B5-s C#6i. D#6q- D#6-s C#6s B5i. Rq D#6i E6i D#6i C#6i C#6i. B5s- B5-i B5i- B5-s F#6i. C#6q- C#6-q. B5i D#6i E6i D#6i C#6i- C#6-i B5i- B5h." //93
				);
		
		Pattern right = new Pattern("T[100] I[Piano] V1 " 
				+ "Ri Ri Ri Ri " 
				+ "E5i B5q F#6i- F#6-q B5q " + "B4i F#5q B5i- B5-q F#5q " + "G#4q D#5q G#5q D#5q " + "F#4q C#5i F#5i- F#5-h "//1
				+ "E4i B4q F#5i- F#5-q B4q " + "B3i F#4q B4i- B4-q F#4q " + "G#4q D#5q G#5q D#5q F#4w " //5
				+ "E4i B4i E5i B4i G#5i B4i E5i B4i " + "B3i F#4i B4i F#4i D#5i F#4i B4i F#4i " + "G#3i D#4i G#4i D#4i B4i D#4i G#4i D#4i " + " F#3i C#4i F#4i C#4i A#4i C#4i F#4i C#4i " //9
				+ "E3i B3i E4i B3i G#4i B3i E4i B3i " + "B3i F#4i B4i F#4i D#5i F#4i B4i F#4i " + "G#3i D#4i G#4i D#4i B4i D#4i G#4i D#4i " + " F#3i C#4i F#4i C#4i F#3i C#4i F#4i C#4i " //13
				+ "E3i B3i E4i B3i F#4i B3i F#4i B3i " + "B3i F#4i B4i F#4i B4i F#4i B4i F#4i " + "G#3i D#4i G#4i D#4i B4i D#4i B4i D#4i " + "F#3i C#4i F#4i C#4i F#3i C#4i F#4i C#4i "//17 
				+ "E3i B3i E4i B3i F#4i B3i F#4i B3i " + "B3i F#4i B4i F#4i B4i F#4i B4i F#4i " + "G#3i D#4i G#4i D#4i B4i D#4i B4i D#4i " + "F#3i C#4i F#4i C#4i- C#4-h "//21
				+ "E4i+E3i B3i F#4i B3i " + "E3i B3i F#4i B3i " + "B4i+B3i F#4i B4i F#4i B3i F#4i B4i F#4i " + "G#3i+G#4i D#4i B4i D#4i G#3i D#4i B4i D#4i " + " F#4i+F#3i C#4i F#4i C#4i F#3i C#4i F#4i C#4i " //25
				+ "E4i+E3i B3i F#4i B3i " + "E3i B3i F#4i B3i " + "B4i+B3i F#4i B4i F#4i B3i F#4i B4i F#4i " + "G#3i+G#4i D#4i B4i D#4i G#3i D#4i B4i D#4i " + " F#4i+F#3i C#4i F#4i C#4i F#3i C#4i F#4i C#4i " //29
				+ "E4i+E3i B3i F#4i B3i " + "E3i B3i F#4i B3i " + "B4i+B3i F#4i B4i F#4i B3i F#4i B4i F#4i " + "G#3i+G#4i D#4i B4i D#4i G#3i D#4i B4i D#4i " + " F#4i+F#3i C#4i F#4i C#4i F#3i C#4i F#4i C#4i " //33
				+ "E4i+E3i B3i F#4i B3i " + "E3i B3i F#4i B3i " + "B4i+B3i F#4i B4i F#4i B3i F#4i B4i F#4i " + "G#3i+G#4i D#4i B4i D#4i G#3i D#4i B4i D#4i " + " F#4i+F#3i C#4i F#4i C#4i F#3i C#4i F#4i C#4i " //37
				+ "E3i B3i E4i B3i G#4i B3i E4i B3i " + "B3i F#4i B4i F#4i D#5i F#4i B4i F#4i " + "G#3i D#4i G#4i D#4i B4i D#4i G#4i D#4i " + " F#3i C#4i F#4i C#4i A#4i C#4i F#4i C#4i "//41
				+ "E3i B3i E4i B3i G#4i B3i E4i B3i " + "B3i F#4i B4i F#4i D#5i F#4i B4i F#4i " + "G#3i D#4i G#4i D#4i B4i D#4i G#4i D#4i " + " F#3i C#4i F#4i C#4i F#3i C#4i F#4i C#4i "//45
				+ "E3i B3i E4i B3i F#4i B3i F#4i B3i " + "B3i F#4i B4i F#4i B4i F#4i B4i F#4i " + "G#3i D#4i G#4i D#4i B4i D#4i B4i D#4i " + " F#3i C#4i F#4i C#4i F#3i C#4i F#4i C#4i " //49
				+ "E3i B3i E4i B3i F#4i B3i F#4i B3i " + "B3i F#4i B4i F#4i B4i F#4i B4i F#4i " + "G#3i D#4i G#4i D#4i B4i D#4i B4i D#4i " + " F#3i C#4i F#4i C#4i- C#4-h "//51
				+ "E4i+E3i B3i F#4i B3i " + "E3i B3i F#4i B3i " + "B4i+B3i F#4i B4i F#4i B3i F#4i B4i F#4i " + "G#3i+G#4i D#4i B4i D#4i G#3i D#4i B4i D#4i " + " F#4i+F#3i C#4i F#4i C#4i F#3i C#4i F#4i C#4i " //53
				+ "E4i+E3i B3i F#4i B3i " + "E3i B3i F#4i B3i " + "B4i+B3i F#4i B4i F#4i B3i F#4i B4i F#4i " + "G#3i+G#4i D#4i B4i D#4i G#3i D#4i B4i D#4i " + " F#4i+F#3i C#4i F#4i C#4i F#3i C#4i F#4i C#4i " //57
				+ "E4i+E3i B3i F#4i B3i " + "E3i B3i F#4i B3i " + "B4i+B3i F#4i B4i F#4i B3i F#4i B4i F#4i " + "G#3i+G#4i D#4i B4i D#4i G#3i D#4i B4i D#4i " + " F#4i+F#3i C#4i F#4i C#4i F#3i C#4i F#4i C#4i " //65
				+ "E4i+E3i B3i F#4i B3i " + "E3i B3i F#4i B3i " + "B4i+B3i F#4i B4i F#4i B3i F#4i B4i F#4i " + "G#3i+G#4i D#4i B4i D#4i G#3i D#4i B4i D#4i " + " F#4i+F#3i C#4i F#4i C#4i F#3i C#4i F#4i C#4i " //69
				+ "E3i B3i E4i B3i G#4i B3i E4i B3i " + "B3i F#4i B4i F#4i D#5i F#4i B4i F#4i " + "G#3i D#4i G#4i D#4i B4i D#4i G#4i D#4i " + "F#3i C#4i F#4i C#4i F#3i C#4i F#4i C#4i " //73
				+ "E3i B3i E4i B3i G#4i B3i E4i B3i " + "B3i F#4i B4i F#4i D#5i F#4i B4i F#4i " + "G#3i D#4i G#4i D#4i B4i D#4i G#4i D#4i " + "F#3i C#4i F#4i- F#4-h " //77
				+ "E5q B5q E6h " + "B4q F#5q B5h " + "G#4q D#5q G#5h " + "F#4q C#5q F#5h "//81
				+ "E4q B4q E5h " + "B3q F#4q B4h " + "G#3q D#4q G#4h " + "F#3q C#4q F#4h "//85
				+ "E4q B4q E5h " + "B3q F#4q B4h " + "G#3q D#4q G#4h " + "F#3q C#4q F#4h "//89	
				+ "E4q B4q E5h " + "B3q F#4q B4h " + "G#3q D#4q G#4h " + "F#3q C#4q F#4h " + "E3w" //93
				);	
		
		Pattern misc = new Pattern("T[100] V2 " 
				+ "Ri Ri Ri Ri " 
				+ "I[PAD_WARM] E5i B5q F#6i- F#6-q B5q " + "I[WOODBLOCK] B4i F#5q B5i- B5-q F#5q " + "G#4q D#5q G#5q D#5q " + "I[PAD_WARM] F#4q C#5i F#5i- F#5-h "//1
				+ "E4i B4q F#5i- F#5-q B4q " + "I[WOODBLOCK] B3i F#4q B4i- B4-q F#4q " + "I[PAD_WARM] G#4q D#5q G#5q D#5q F#4w " //5
				+ "I[PAD_WARM] E4i B4i E5i B4i G#5i B4i E5i B4i " + "B3i F#4i B4i F#4i D#5i F#4i B4i F#4i " + "G#3i D#4i G#4i D#4i B4i D#4i G#4i D#4i " + " F#3i C#4i F#4i C#4i A#4i C#4i F#4i C#4i " //9
				+ "E3i B3i E4i B3i G#4i B3i E4i B3i " + "B3i F#4i B4i F#4i D#5i F#4i B4i F#4i " + "G#3i D#4i G#4i D#4i B4i D#4i G#4i D#4i " + " F#3i C#4i F#4i C#4i F#3i C#4i F#4i C#4i " //13
				+ "I[STEEL_DRUMS] E3i B3i E4i B3i F#4i B3i F#4i B3i " + "B3i F#4i B4i F#4i B4i F#4i B4i F#4i " + "G#3i D#4i G#4i D#4i B4i D#4i B4i D#4i " + "F#3i C#4i F#4i C#4i F#3i C#4i F#4i C#4i "//17 
				+ "E3i B3i E4i B3i F#4i B3i F#4i B3i " + "B3i F#4i B4i F#4i B4i F#4i B4i F#4i " + "G#3i D#4i G#4i D#4i B4i D#4i B4i D#4i " + "F#3i C#4i F#4i C#4i- C#4-h "//21
				+ "I[WOODBLOCK] E4i+E3i B3i F#4i B3i " + "E3i B3i F#4i B3i " + "B4i+B3i F#4i B4i F#4i B3i F#4i B4i F#4i " + "G#3i+G#4i D#4i B4i D#4i G#3i D#4i B4i D#4i " + " F#4i+F#3i C#4i F#4i C#4i F#3i C#4i F#4i C#4i " //25
				+ "E4i+E3i B3i F#4i B3i " + "E3i B3i F#4i B3i " + "B4i+B3i F#4i B4i F#4i B3i F#4i B4i F#4i " + "G#3i+G#4i D#4i B4i D#4i G#3i D#4i B4i D#4i " + " F#4i+F#3i C#4i F#4i C#4i F#3i C#4i F#4i C#4i " //29
				+ "I[PAD_WARM] E4i+E3i B3i F#4i B3i " + "E3i B3i F#4i B3i " + "B4i+B3i F#4i B4i F#4i B3i F#4i B4i F#4i " + "G#3i+G#4i D#4i B4i D#4i G#3i D#4i B4i D#4i " + " F#4i+F#3i C#4i F#4i C#4i F#3i C#4i F#4i C#4i " //33
				+ "E4i+E3i B3i F#4i B3i " + "E3i B3i F#4i B3i " + "B4i+B3i F#4i B4i F#4i B3i F#4i B4i F#4i " + "G#3i+G#4i D#4i B4i D#4i G#3i D#4i B4i D#4i " + " F#4i+F#3i C#4i F#4i C#4i F#3i C#4i F#4i C#4i " //37
				+ "E3i B3i E4i B3i G#4i B3i E4i B3i " + "B3i F#4i B4i F#4i D#5i F#4i B4i F#4i " + "G#3i D#4i G#4i D#4i B4i D#4i G#4i D#4i " + " F#3i C#4i F#4i C#4i A#4i C#4i F#4i C#4i "//41
				+ "E3i B3i E4i B3i G#4i B3i E4i B3i " + "B3i F#4i B4i F#4i D#5i F#4i B4i F#4i " + "G#3i D#4i G#4i D#4i B4i D#4i G#4i D#4i " + " F#3i C#4i F#4i C#4i F#3i C#4i F#4i C#4i "//45
				+ "I[STEEL_DRUMS] E3i B3i E4i B3i F#4i B3i F#4i B3i " + "B3i F#4i B4i F#4i B4i F#4i B4i F#4i " + "G#3i D#4i G#4i D#4i B4i D#4i B4i D#4i " + " F#3i C#4i F#4i C#4i F#3i C#4i F#4i C#4i " //49
				+ "E3i B3i E4i B3i F#4i B3i F#4i B3i " + "B3i F#4i B4i F#4i B4i F#4i B4i F#4i " + "G#3i D#4i G#4i D#4i B4i D#4i B4i D#4i " + " F#3i C#4i F#4i C#4i- C#4-h "//51
				+ "I[WOODBLOCK] E4i+E3i B3i F#4i B3i " + "E3i B3i F#4i B3i " + "B4i+B3i F#4i B4i F#4i B3i F#4i B4i F#4i " + "G#3i+G#4i D#4i B4i D#4i G#3i D#4i B4i D#4i " + " F#4i+F#3i C#4i F#4i C#4i F#3i C#4i F#4i C#4i " //53
				+ "E4i+E3i B3i F#4i B3i " + "E3i B3i F#4i B3i " + "B4i+B3i F#4i B4i F#4i B3i F#4i B4i F#4i " + "G#3i+G#4i D#4i B4i D#4i G#3i D#4i B4i D#4i " + " F#4i+F#3i C#4i F#4i C#4i F#3i C#4i F#4i C#4i " //57
				+ "I[PAD_WARM] E4i+E3i B3i F#4i B3i " + "E3i B3i F#4i B3i " + "B4i+B3i F#4i B4i F#4i B3i F#4i B4i F#4i " + "G#3i+G#4i D#4i B4i D#4i G#3i D#4i B4i D#4i " + " F#4i+F#3i C#4i F#4i C#4i F#3i C#4i F#4i C#4i " //65
				+ "E4i+E3i B3i F#4i B3i " + "E3i B3i F#4i B3i " + "B4i+B3i F#4i B4i F#4i B3i F#4i B4i F#4i " + "G#3i+G#4i D#4i B4i D#4i G#3i D#4i B4i D#4i " + " F#4i+F#3i C#4i F#4i C#4i F#3i C#4i F#4i C#4i " //69
				+ "I[STRING_ENSEMBLE_1] E3i B3i E4i B3i G#4i B3i E4i B3i " + "B3i F#4i B4i F#4i D#5i F#4i B4i F#4i " + "G#3i D#4i G#4i D#4i B4i D#4i G#4i D#4i " + "F#3i C#4i F#4i C#4i F#3i C#4i F#4i C#4i " //73
				+ "E3i B3i E4i B3i G#4i B3i E4i B3i " + "B3i F#4i B4i F#4i D#5i F#4i B4i F#4i " + "G#3i D#4i G#4i D#4i B4i D#4i G#4i D#4i " + "F#3i C#4i F#4i- F#4-h " //77
				+ "I[PAD_WARM] E5q B5q E6h " + "B4q F#5q B5h " + "G#4q D#5q G#5h " + "F#4q C#5q F#5h Rx "//81
				+ "E4q B4q E5h " + "B3q F#4q B4h " + "G#3q D#4q G#4h " + "F#3q C#4q F#4h "//85
				+ "E4q B4q E5h " + "B3q F#4q B4h " + "G#3q D#4q G#4h " + "F#3q C#4q F#4h "//89	
				+ "E4q B4q E5h " + "B3q F#4q B4h " + "G#3q D#4q G#4h " + "F#3q C#4q F#4h " + "E3w" //93
				);
		
		Pattern song = new Pattern();
		song.add(left);
		song.add(right);
		song.add(misc);
		Panel.player.play(song);
	} 
	
	@Override
	public void play() {
		
		playPayphone();
	}

}
