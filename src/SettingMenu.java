import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

class SettingMenu extends JFrame implements ActionListener {

	// variables for the class 
	
	public static boolean is3players = false, is4players = false;
	
	public JTextField setNamePlayer1, setNamePlayer2, setNamePlayer3, setNamePlayer4;
	BufferedImage settingImage;

	String[] playersChoises = { "2", "3", "4" };
	String[] sizeChoises = { "30", "50", "100" };

	static JComboBox comboBoxPlayers;
	JComboBox comboBoxSizes;

	static JButton startGame, writeNames;

	
	 
	
	public SettingMenu() {

		setSize(640, 670);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		
		
		// to put the logo image 
		try {
			
			settingImage = ImageIO.read(getClass().getResource("images/settinglogo.png"));


		} catch (IOException ex) {
			// handle exception...
		}
		
		
		// set fonts

		Font fontText2 = new Font("Hacen Beirut", Font.PLAIN, 24);
		Font fontText3 = new Font("Arial", Font.BOLD, 15);

		
		// initialize the variabals
		
		JLabel howManyPlayersText = new JLabel("How many players ?");
		howManyPlayersText.setFont(fontText2);

		comboBoxPlayers = new JComboBox(playersChoises);

		JLabel writeNamesText = new JLabel("Set names of playes");
		writeNamesText.setFont(fontText3);
		writeNames = new JButton("set names");

		JLabel sizeOfBoredText = new JLabel("What the size of the bored ?");
		sizeOfBoredText.setFont(fontText2);

		comboBoxSizes = new JComboBox(sizeChoises);

		startGame = new JButton("Click to start the game!");

		howManyPlayersText.setBounds(177, 200, 270, 100);
		comboBoxPlayers.setBounds(230, 270, 100, 30);
		writeNamesText.setBounds(230, 210, 380, 250);
		writeNames.setBounds(240, 350, 100, 36);

		sizeOfBoredText.setBounds(177, 376, 300, 100);
		comboBoxSizes.setBounds(230, 450, 100, 30);
		startGame.setBounds(200, 500, 200, 44);
		startGame.addActionListener(this);
		writeNames.addActionListener(this);

		add(howManyPlayersText);
		add(comboBoxPlayers);
		add(writeNamesText);
		add(writeNames);
		add(sizeOfBoredText);
		add(comboBoxSizes);
		add(startGame);

		setVisible(true);
	}

	public void paint(Graphics g) {
		super.paint(g);
	

		g.drawImage(settingImage, 130, 42, this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == writeNames) {
			new SetNames();
		}
		
		
		if (e.getSource() == startGame) {

			if (comboBoxPlayers.getSelectedItem().equals("3")) {

				is3players = true;
			}

			if (comboBoxPlayers.getSelectedItem().equals("4")) {

				is3players = true;
				is4players = true;
			}
			
			
			
			if (comboBoxSizes.getSelectedItem().equals("30")){
				try {
					new Bored_30();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			else if (comboBoxSizes.getSelectedItem().equals("50")){
				try {
					new Bored_50();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			 
			
			

		}

		

	}
	 

	
	// class set names to open a window to set players's names
	
	
	 class SetNames extends JDialog {


		public JButton okBotton;

		public SetNames() {
			this.setSize(280, 270);
			this.setLocationRelativeTo(null);
			setLayout(new FlowLayout());

			Font fontText4 = new Font("Arial", Font.PLAIN, 18);

			JLabel name1 = new JLabel("Set Player's 1 name : ");
			setNamePlayer1 = new JTextField(7);
			setNamePlayer1.setText("Player 1");

			JLabel name2 = new JLabel("Set Player's 2 name : ");
			setNamePlayer2 = new JTextField(7);
			setNamePlayer2.setText("Player 2");

			JLabel name3 = new JLabel("Set Player's 3 name : ");
			setNamePlayer3 = new JTextField(7);
			setNamePlayer3.setText("Player 3");

			JLabel name4 = new JLabel("Set Player's 4 name : ");
			setNamePlayer4 = new JTextField(7);
			setNamePlayer4.setText("Player 4");

			JPanel panel_1 = new JPanel();

			panel_1.add(name1);
			panel_1.add(setNamePlayer1);

			JPanel panel_2 = new JPanel();

			panel_2.add(name2);
			panel_2.add(setNamePlayer2);

			JPanel panel_3 = new JPanel();

			panel_3.add(name3);
			panel_3.add(setNamePlayer3);

			JPanel panel_4 = new JPanel();

			panel_4.add(name4);
			panel_4.add(setNamePlayer4);

			okBotton = new JButton("OK");

			add(okBotton);

			okBotton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					setNamePlayer1 = new JTextField(setNamePlayer1.getText());
					setNamePlayer2 = new JTextField(setNamePlayer2.getText());
					setVisible(false);

				}
			});

			add(panel_1);

			add(panel_2);

			if (comboBoxPlayers.getSelectedItem().equals("3")) {

				is3players = true;
			}
			add(panel_3);

			add(panel_4);

			add(okBotton);

			this.setVisible(true);

		}

	}

}
