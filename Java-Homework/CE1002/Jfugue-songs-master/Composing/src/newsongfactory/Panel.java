package newsongfactory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.jfugue.Player;

public class Panel extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	static Player player = new Player();
	ImageIcon i;
	Image img;
	JPanel songPanel, buttonsPanel;
	JScrollPane scrollPane;
	JButton payPhone, waterMelon, sundayMorning;
	JButton[] songList;
	JButton play, pause, stop;
	
	public Panel(){
		i = new ImageIcon(getClass().getResource("/images/musicbutton.png"));
		img = i.getImage();
		//setLayout(null);
		
		// Creates panel for the list of songs
		songPanel = new JPanel();
		songPanel.setLayout(new GridLayout(11, 1));
		songPanel.setBackground(Color.black);

		songList = new JButton[11];
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
		
		scrollPane = new JScrollPane(songPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(180, 180));
		
		add(scrollPane);
		
		// Creates panel for the music buttons
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(1, 3));
		
		play = new JButton();
		play.setSize(50, 50);
		play.addActionListener(this);
		pause = new JButton();
		pause.setSize(50, 50);
		pause.addActionListener(this);
		stop = new JButton();
		stop.setSize(50, 50);
		stop.addActionListener(this);
		
		
		
		buttonsPanel.add(play);
		buttonsPanel.add(pause);
		buttonsPanel.add(stop);
		
		add(buttonsPanel);
		
		//player = new Player();

	}

	public void paintComponent(Graphics g){
		g.drawImage(img, -2, -20, null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Thread thread;
		String songTitle = null;
		boolean button = false;
		
		songList[0].setText("A Thousand Miles");
		songList[1].setText("How to Save a Life");
		songList[2].setText("Just the Way You Are");
		songList[3].setText("Lost My Pieces");
		songList[4].setText("Magasin");
		songList[5].setText("Out of My League");
		songList[6].setText("Payphone");
		songList[7].setText("Sunday Morning");
		songList[8].setText("Watermelon");
		
		if (e.getSource() == songList[0]) {
			if (player.isPlaying())
				player.stop();
			songTitle = "athousandmiles";
		}
		
		if (e.getSource() == songList[1]) {
			if (player.isPlaying())
				player.stop();
			songTitle = "howtosavealife";
		}
		
		if (e.getSource() == songList[2]) {
			if (player.isPlaying())
				player.stop();
			songTitle = "justthewayyouare";
		}
		
		if (e.getSource() == songList[3]) {
			if (player.isPlaying())
				player.stop();
			songTitle = "lostmypieces";
		}
		
		if (e.getSource() == songList[4]) {
			if (player.isPlaying())
				player.stop();
			songTitle = "magasin";
		}
		
		if (e.getSource() == songList[5]) {
			if (player.isPlaying())
				player.stop();
			songTitle = "outofmyleague";
		}
		if (e.getSource() == songList[6]) {
			if (player.isPlaying())
				player.stop();
			songTitle = "payphone";
		}
		
		if (e.getSource() == songList[7]) {
			if (player.isPlaying())
				player.stop();
			songTitle = "sundaymorning";
		}
		
		if (e.getSource() == songList[8]) {
			if (player.isPlaying())
				player.stop();
			songTitle = "watermelon";
		}
		
		if (e.getSource() == play) {
			if (player.isPaused())
				player.resume();
			button = true;
		}
		
		if (e.getSource() == pause) {
			if (player.isPlaying())
				player.pause();
			button = true;
		}
		
		if (e.getSource() == stop) {
			if (player.isPlaying() || player.isPaused())
				player.stop();
			button = true;
		}
		
		if (!button) {	
			final String song = songTitle;
			thread = new Thread(songTitle) {
				public void run() {
					try{
					SongFactory.getSong(song).play();
					}catch(IllegalStateException e){
						SongFactory.getSong(song).play();
					}
				}
			};
			thread.start();
		}
	}
}
