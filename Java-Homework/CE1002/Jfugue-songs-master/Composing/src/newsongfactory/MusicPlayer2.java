package newsongfactory;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import org.jfugue.Player;

public class MusicPlayer2 extends JFrame implements ActionListener {

	JButton[] songList;
	static Player player;
	boolean play = false;
	Image image;
	ImageIcon i = new ImageIcon(getClass().getResource(
			"/images/musicbutton.png"));

	public MusicPlayer2() {
		image = i.getImage();
		//setLayout(null);
		
		setTitle("Music Player");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		pack();
		//setSize(200, 300);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		setContentPane(panel());
		revalidate();
	}

	public JPanel panel() {
		
		player = new Player();

		// Creates main panel
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.black);
		add(mainPanel);

		// Creates panel for the list of songs
		JPanel songPanel = new JPanel();
		songPanel.setLayout(new GridLayout(10, 1));
		songPanel.setBackground(Color.black);

		songList = new JButton[10];
		for (int i = 0; i < songList.length; i++) {
			songList[i] = new JButton();
			songList[i].addActionListener(this);
			songPanel.add(songList[i]);
		}

		songList[0].setText("A Thousand Miles");
		songList[1].setText("How to Save a Life");
		songList[2].setText("Just the Way You Are");
		songList[3].setText("Lost My Pieces");
		songList[4].setText("Magasin");
		songList[5].setText("Out of My League");
		songList[6].setText("Payphone");
		songList[7].setText("Sunday Morning");
		songList[8].setText("Watermelon");

		JScrollPane scrollPane = new JScrollPane(songPanel);
		scrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(180, 180));
		scrollPane.setBackground(Color.black);

		// Creates panel for music buttons
		JPanel buttonsPanel = new JPanel();

		// Creates play, pause and stop buttons
		/*
		 * JButton[] buttonsList = new JButton[3]; for (int i = 0; i <
		 * buttonsList.length; i++) { buttonsList[i] = new JButton();
		 * buttonsList[0].setBounds(50, 250, 30, 30);
		 * songList[i].addActionListener(this); background.add(buttonsList[i]);
		 * }
		 */

		//play.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		mainPanel.add(scrollPane);
		mainPanel.add(buttonsPanel);

		return mainPanel;
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
		new MusicPlayer2();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Thread thread;
		String songTitle = null;
		
		if (e.getSource() == songList[6]) {
			if (play)
			player.stop();
			songTitle = "payphone";
			play = true;
		}
		if (e.getSource() == songList[7]) {
			if (play)
				player.stop();
			songTitle = "sundaymorning";
			play = true;
		}
		System.out.println(play);

		final String song = songTitle;
		thread = new Thread(songTitle) {
			public void run() {
				SongFactory.getSong(song).play();
			}
		};
		thread.start();
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, null);
	}
}
