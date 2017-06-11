package newsongfactory;
import javax.swing.*;	
import javax.swing.UIManager.LookAndFeelInfo;

public class MusicPlayer {
static JFrame frame;
	
	public MusicPlayer(){
		
		frame = new JFrame("Music Player");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.pack();
		frame.setSize(200, 300);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setContentPane(new Panel());
		frame.revalidate();
		
	}
	
	public static void main(String[] args) {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e1) {

			// If Nimbus is not available, fall back to cross-platform
			try {
				UIManager.setLookAndFeel(UIManager
						.getCrossPlatformLookAndFeelClassName());
			} catch (Exception e2) {
			}
		}
		
		new MusicPlayer();
	}

}
