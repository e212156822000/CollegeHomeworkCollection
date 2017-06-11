package newsongfactory;

import org.jfugue.Pattern;

public class Magasin implements Song {

	public void playMagasin() {
		Pattern pattern1 = new Pattern("T[150] I[Guitar] Rh C6w D6q. B5i.h. D6q. C6i.h. E6q. C6h. G5q. "
				+ "Rq. C6w D6q. B5i.h. D6q. C6i.h. E6q. C6h. G5h. C6h. G5h. "
				
				+ "Rq. G5i G5q E5i. E5i G5h. G5i G5i. G5q C6i. D6i. E6q " 
				+ "Rq. E6s. E6i. C6i. C6i. D6i E6q C6h. F5i. F5i. G5q A5q. "
				+ "Rq G5s. G5i G5q E5q G5h. G5i. G5i. G5i. A5q C6q E6q "
				+ "Rq. E6i. C6i. D6i E6q D6i. C6i. D6i E6q C6i. F6q E6i E6i. D6q. B5q.. "
				
				+ "Rq. G5i. G5i. G5i. E5q E5q G5q. G5i. G5i. G5i. A5q C6q E6q "
				+ "Rq E6i.. C6i. C6i. D6i E6q C6h. F5i. F5i. G5i A5q. "
				+ "Rq. G5i. G5i. E5i. E5i E5i. E5i G5h G5i G5i. G5i. A5i. A5i A5i C6i. D6i E6q "
				+ "Rq E6i. E6i.. C6i D6i. E6i. C6i D6i. C6h C6i. F6i. G6i G6q F6h.. G6q. "
				
				+ "Rq G6s.. G6i D6i. C6i. D6i. D6i E6q " 
				+ "Rq. G6s.. G6i D6i. C6i. D6i. D6i E6q "
				+ "Rq. G6i. D6i. C6i. D6i. C6i D6i.. C6q F6i. E6q. D6q.. C6i. D6i. E6i "
				+ "Rq G6i. D6i. C6i. D6i. C6s.. D6q E6i "
				+ "Rq G6i. D6i. C6i. D6i. C6s.. D6q E6i "
				+ "Rq G6i. D6i. C6i. D6i. C6q. C6i C6i F6i. G6q. G6h. F6h. "
				+ "Rq. G6i. G6s.. E6w E6q. D6q.. "	
				+ "Rq. C6i. C6i D6i. C6q. C6i. C6i. D6q E6i C6i. A5q " );

		Panel.player.play(pattern1);
	}

	@Override
	public void play() {
		playMagasin();
		
	}
}
