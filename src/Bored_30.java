import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

 

class Bored_30 extends JFrame implements ActionListener, MouseMotionListener {

	
	// object to use some varibles from class settingMenue
	
	SettingMenu obj = new SettingMenu();
	
	
	// variables for the class 

	JButton setTarpButton_1, setTarpButton_2, setTarpButton_3, setTarpButton_4;

	public int setTrap1, setTrap2, setTrap3, setTrap4;

	public int setTrap_1x, setTrap_2x, setTrap_3x, setTrap_4x, setTrap_y = 38;

	public int selectWhoSetTrap;

	String winner_1, winner_2, winner_3, winner_4;

	JButton restartGame, closeGame;

	BufferedImage d1 = ImageIO.read(getClass().getResource("images/dice1_.png")); 
	BufferedImage d2 = ImageIO.read(getClass().getResource("images/dice2_.png")); 
	BufferedImage d3 = ImageIO.read(getClass().getResource("images/dice3_.png")); 
	BufferedImage d4 = ImageIO.read(getClass().getResource("images/dice4_.png")); 
	BufferedImage d5 = ImageIO.read(getClass().getResource("images/dice5_.png")); 
	BufferedImage d6 = ImageIO.read(getClass().getResource("images/dice6_.png")); 
	
	ImageIcon dicePic1 = new ImageIcon(d1);
	ImageIcon dicePic2 = new ImageIcon(d2);
	ImageIcon dicePic3 = new ImageIcon(d3);
	ImageIcon dicePic4 = new ImageIcon(d4);
	ImageIcon dicePic5 = new ImageIcon(d5);
	ImageIcon dicePic6 = new ImageIcon(d6);

	JLabel mousePos;
	JButton dice;
	static GamePanel bored;
	int frameX = 1435;
	int frameY = 820;

	
	
	// where the players begin 
	
	int player1_X = 10;
	int player2_X = 40;
	int player3_X = 70;
	int player4_X = 100;

	int player1_Y = 650;
	int player2_Y = 650;
	int player3_Y = 650;
	int player4_Y = 650;

	JLabel currentTurn;
	JLabel diceNumber;

	Random r = new Random();
	int roll;

	JMenuBar mainBar;
	JMenu Restart, Help, About;
	JMenuItem Restart1, Help2, About3;

	public Bored_30() throws IOException {

		setTitle("Game");
		setSize(frameX, frameY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// -----------------up menu---------------------------

		mainBar = new JMenuBar();
		Restart = new JMenu("Restart");
		Help = new JMenu("Help");
		About = new JMenu("About");

		Restart1 = new JMenuItem("Restart the game");
		Help2 = new JMenuItem("Help");
		About3 = new JMenuItem("About");

		Restart.add(Restart1);
		Help.add(Help2);
		About.add(About3);

		mainBar.add(Restart);
		mainBar.add(Help);
		mainBar.add(About);

		Restart1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int result = JOptionPane.showConfirmDialog(null, "Do you want to restart the game",
						"Restert game ?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE );
				
				switch (result) {
				case JOptionPane.YES_OPTION:
					player1_X = 10;
					player2_X = 40;
					player3_X = 70;
					player4_X = 100;

					player1_Y = 650;
					player2_Y = 650;
					player3_Y = 650;
					player4_Y = 650;

					bored.repaint();
					
					break;
				case JOptionPane.NO_OPTION:
				 
					break;
				case JOptionPane.CANCEL_OPTION:
					 
					break;
				case JOptionPane.CLOSED_OPTION:
					 
					break;
				}

				

			}
		});
		
		
		Help2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				 
				JOptionPane.showMessageDialog(null, "if you need any help ask me ", "Information Message", JOptionPane.INFORMATION_MESSAGE);
				

			}
		});
		
		About3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				 
				JOptionPane.showMessageDialog(null, "This program was done by Mujtaba AL-Mohsin", "Information Message", JOptionPane.INFORMATION_MESSAGE);
				

			}
		});

		setJMenuBar(mainBar);
		
		
		

		// -----------------left panel------------------------------

		JPanel leftPanel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(leftPanel);
		leftPanel.setLayout(groupLayout);

		// ---------------------------panel 1.

		JPanel panel1 = new JPanel();
		BufferedImage upLogo = ImageIO.read(getClass().getResource("images/upLogo.png")); 
		ImageIcon image = new ImageIcon(upLogo);
		JLabel Logo = new JLabel("", image, JLabel.CENTER);
		panel1.add(Logo);

		Font fontText = new Font("Arial", Font.BOLD, 20);
		Font fontText2 = new Font("Calibri", Font.BOLD, 18);

		// ---------------------------panel 2

		JPanel panel2 = new JPanel();
		BufferedImage man1_leftPanel = ImageIO.read(getClass().getResource("images/man1_leftPanel.png")); 
		ImageIcon imageMan1 = new ImageIcon(man1_leftPanel);
		JLabel imageMan11 = new JLabel("", imageMan1, JLabel.CENTER);

		JLabel player1text = new JLabel("Player 1");
		player1text.setFont(fontText);

		setTarpButton_1 = new JButton("Set Trap");

		setTarpButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				selectWhoSetTrap = 1;

				new SetTrapClass1();

			}

		});

		panel2.add(imageMan11);
		panel2.add(player1text);
		panel2.add(setTarpButton_1);

		// ---------------------------panel3

		JPanel panel3 = new JPanel();
		BufferedImage man2_leftPanel = ImageIO.read(getClass().getResource("images/man2_leftPanel.png"));
		ImageIcon imageMan2 = new ImageIcon(man2_leftPanel);
		JLabel imageMan22 = new JLabel("", imageMan2, JLabel.CENTER);
		JLabel player2text = new JLabel("Player 2");
		player2text.setFont(fontText);

		setTarpButton_2 = new JButton("Set Trap");
		setTarpButton_2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				selectWhoSetTrap = 2;
				new SetTrapClass1();

			}
		});

		panel3.add(imageMan22);
		panel3.add(player2text);
		panel3.add(setTarpButton_2);

		// ---------------------------panel 4 -----------------

		JPanel panel4 = new JPanel();

		if (obj.is3players == true) {
			BufferedImage man3_leftPanel = ImageIO.read(getClass().getResource("images/man3_leftPanel.png"));
			ImageIcon imageMan3 = new ImageIcon(man3_leftPanel);
			JLabel imageMan33 = new JLabel("", imageMan3, JLabel.CENTER);
			JLabel player3text = new JLabel("Player 3");
			player3text.setFont(fontText);
			setTarpButton_3 = new JButton("Set Trap");

			setTarpButton_3.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					selectWhoSetTrap = 3;
					new SetTrapClass1();

				}
			});

			panel4.add(imageMan33);
			panel4.add(player3text);
			panel4.add(setTarpButton_3);
		}

		// ---------------------------panel 5 ----------------------------

		JPanel panel5 = new JPanel();

		if (obj.is4players == true) {
			BufferedImage man4_leftPanel = ImageIO.read(getClass().getResource("images/man4_leftPanel.png"));
			ImageIcon imageMan4 = new ImageIcon(man4_leftPanel);
			JLabel imageMan44 = new JLabel("", imageMan4, JLabel.CENTER);
			JLabel player4text = new JLabel("Player 4");
			player4text.setFont(fontText);
			setTarpButton_4 = new JButton("Set Trap");

			setTarpButton_4.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					selectWhoSetTrap = 4;
					new SetTrapClass1();

				}
			});

			panel5.add(imageMan44);
			panel5.add(player4text);
			panel5.add(setTarpButton_4);
		}

		// ---------------------------panel 6 -----------------------

		JPanel panel6 = new JPanel();
		JLabel currentTurnText = new JLabel("It's turn : ");
		currentTurn = new JLabel("Player 1");
		currentTurnText.setFont(fontText);
		currentTurn.setFont(fontText);
		panel6.add(currentTurnText);
		panel6.add(currentTurn);

		// ---------------------------panel 7 -------------------

		JPanel panel7 = new JPanel();
		
		dice = new JButton("", new ImageIcon(LeadersAndSnake_Project201.class.getResource("images/Dice1.png")));

		dice.addActionListener(this);
		panel7.add(dice);

		// ---------------------------panel 8 --------------------

		JPanel panel8 = new JPanel();

		diceNumber = new JLabel();
		panel8.add(diceNumber);

		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(panel1).addComponent(panel2).addComponent(panel3).addComponent(panel4)
				.addComponent(panel5).addComponent(panel6).addComponent(panel7).addComponent(panel8));

		groupLayout.setVerticalGroup(groupLayout.createSequentialGroup().addComponent(panel1).addComponent(panel2)
				.addComponent(panel3).addComponent(panel4).addComponent(panel5).addComponent(panel6)
				.addComponent(panel7).addComponent(panel8));

		add(leftPanel, BorderLayout.WEST);

		// -----------------------------------------------------

		mousePos = new JLabel("");
		Font newFont = new Font("Serif", Font.BOLD, 55);

		mousePos.setFont(newFont);
		bored = new GamePanel();
		bored.add(mousePos, BorderLayout.LINE_END);
		bored.addMouseMotionListener(this);

		add(bored);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		
		// here if we click on the dice button the game start moving
		
		if (e.getSource() == dice) {

			
			// take random number
			
			roll = r.nextInt(6) + 1;
			
			// here if stetments to show a picture for the random number
			
			if (roll == 1) {

				diceNumber.setIcon(dicePic1);
			}

			if (roll == 2) {

				diceNumber.setIcon(dicePic2);
			}

			if (roll == 3) {

				diceNumber.setIcon(dicePic3);
			}

			if (roll == 4) {

				diceNumber.setIcon(dicePic4);
			}

			if (roll == 5) {

				diceNumber.setIcon(dicePic5);
			}

			if (roll == 6) {

				diceNumber.setIcon(dicePic6);
			}

			
			
			// if stetment for every player to do the orders

			// ----------------player 1---------------------

			if (currentTurn.getText().equals("Player 1")) {

				for (int i = 1; i <= roll; i++) {

					// row1
					if (player1_X < 960 && player1_Y == 650) {
						player1_X = player1_X + 190;

						if (player1_X == 580 && player1_Y == 650 && i == roll) {
							player1_X = 770;
							player1_Y = 497;
							break;
						}

					}

					else if (player1_X == 960 && player1_Y == 650) {

						player1_X = 960;
						player1_Y = 497;
						continue;

					}

					// row2
					if (player1_X > 10 && player1_Y == 497) {
						player1_X = player1_X - 190;

						if (player1_X == 200 && player1_Y == 497 && i == roll) {
							player1_X = 390;
							player1_Y = 191;
							break;
						}
					}

					else if (player1_X == 10 && player1_Y == 497) {
						player1_X = 10;
						player1_Y = 344;
						continue;
					}

					// row3
					if (player1_X < 960 && player1_Y == 344) {
						player1_X = player1_X + 190;
						if (player1_X == 770 && player1_Y == 344 && i == roll) {
							player1_X = 580;
							player1_Y = 38;
							break;
						}

						if (player1_X == 200 && player1_Y == 344 && i == roll) {
							player1_X = 10;
							player1_Y = 650;
							break;
						}
					}

					else if (player1_X == 960 && player1_Y == 344) {

						player1_X = 960;
						player1_Y = 191;
						continue;

					}

					// row4
					if (player1_X > 10 && player1_Y == 191) {
						player1_X = player1_X - 190;

						if (player1_X == 580 && player1_Y == 191 && i == roll) {
							player1_X = 390;
							player1_Y = 497;
							break;
						}
					}

					else if (player1_X == 10 && player1_Y == 191) {
						player1_X = 10;
						player1_Y = 38;
						continue;
					}

					// row5
					if (player1_X < 960 && player1_Y == 38) {
						player1_X = player1_X + 190;

						if (player1_X == 200 && player1_Y == 38 && i == roll) {
							player1_X = 390;
							player1_Y = 344;
							break;
						}

						if (player1_X == 770 && player1_Y == 38 && i == roll) {
							player1_X = 960;
							player1_Y = 344;
							break;
						}

					}

					// last point 
					
					else if (player1_X == 960 && player1_Y == 38) {

						player1_X = 960;
						player1_Y = 38;
						
						// if stetments to show the winner and postions 

						if (winner_1 == null && winner_2 == null && winner_3 == null && winner_4 == null) {

							winner_1 = "Player 1";

						}

						else if (winner_1 != null && !(winner_1.equals("Player 1")) && winner_2 == null

								&& winner_3 == null && winner_4 == null) {
							winner_2 = "Player 1";
						}

						else if (winner_1 != null && !(winner_1.equals("Player 1")) && winner_2 != null
								&& !(winner_2.equals("Player 1")) && winner_3 == null && winner_4 == null) {
							winner_3 = "Player 1";
						}

						else if (winner_1 != null && !(winner_1.equals("Player 1")) && winner_2 != null
								&& !(winner_2.equals("Player 1")) && winner_3 != null && !(winner_3.equals("Player 1"))
								&& winner_4 == null) {
							winner_4 = "Player 1";
						}

						break;

					}

				}

			}

			// ----------------player 2---------------------

			else if (currentTurn.getText().equals("Player 2")) {

				for (int i = 1; i <= roll; i++) {

					// row1
					if (player2_X < 990 && player2_Y == 650) {
						player2_X = player2_X + 190;

						if (player2_X == 610 && player2_Y == 650 && i == roll) {
							player2_X = 800;
							player2_Y = 497;
							break;
						}
					}

					else if (player2_X == 990 && player2_Y == 650) {

						player2_X = 990;
						player2_Y = 497;
						continue;

					}

					// row2
					if (player2_X > 40 && player2_Y == 497) {
						player2_X = player2_X - 190;

						if (player2_X == 230 && player2_Y == 497 && i == roll) {
							player2_X = 420;
							player2_Y = 191;
							break;
						}

					}

					else if (player2_X == 40 && player2_Y == 497) {
						player2_X = 40;
						player2_Y = 344;
						continue;
					}

					// row3
					if (player2_X < 990 && player2_Y == 344) {
						player2_X = player2_X + 190;

						if (player2_X == 800 && player2_Y == 344 && i == roll) {
							player2_X = 610;
							player2_Y = 38;
							break;
						}

						if (player2_X == 230 && player2_Y == 344 && i == roll) {
							player2_X = 40;
							player2_Y = 650;
							break;
						}

					}

					else if (player2_X == 990 && player2_Y == 344) {

						player2_X = 990;
						player2_Y = 191;
						continue;

					}

					// row4
					if (player2_X > 40 && player2_Y == 191) {
						player2_X = player2_X - 190;

						if (player2_X == 610 && player2_Y == 191 && i == roll) {
							player2_X = 420;
							player2_Y = 497;
							break;
						}

					}

					else if (player2_X == 40 && player2_Y == 191) {
						player2_X = 40;
						player2_Y = 38;
						continue;
					}

					// row5
					if (player2_X < 990 && player2_Y == 38) {
						player2_X = player2_X + 190;

						if (player2_X == 230 && player2_Y == 38 && i == roll) {
							player2_X = 420;
							player2_Y = 344;
							break;
						}

						if (player2_X == 800 && player2_Y == 38 && i == roll) {
							player2_X = 990;
							player2_Y = 344;
							break;
						}
					}

					else if (player2_X == 990 && player2_Y == 38) {
						//last point
						player2_X = 990;
						player2_Y = 38;

						// if stetments to show the winner and postions 
						if (winner_1 == null && winner_2 == null && winner_3 == null && winner_4 == null) {

							winner_1 = "Player 2";

						}

						else if (winner_1 != null && !(winner_1.equals("Player 2")) && winner_2 == null
								&& winner_3 == null && winner_4 == null) {
							winner_2 = "Player 2";
						}

						else if (winner_1 != null && !(winner_1.equals("Player 2")) && winner_2 != null
								&& !(winner_2.equals("Player 2")) && winner_3 == null && winner_4 == null) {
							winner_3 = "Player 2";
						}

						else if (winner_1 != null && !(winner_1.equals("Player 2")) && winner_2 != null
								&& !(winner_2.equals("Player 2")) && winner_3 != null && !(winner_3.equals("Player 2"))
								&& winner_4 == null) {
							winner_4 = "Player 2";
						}

						break;

					}

				}

			}

			// ------------------------player 3--------------

			if (obj.is3players == true) {

				if (currentTurn.getText().equals("Player 3")) {

					for (int i = 1; i <= roll; i++) {

						// row1
						if (player3_X < 1020 && player3_Y == 650) {
							player3_X = player3_X + 190;

							if (player3_X == 640 && player3_Y == 650 && i == roll) {
								player3_X = 830;
								player3_Y = 497;
								break;
							}

						}

						else if (player3_X == 1020 && player3_Y == 650) {

							player3_X = 1020;
							player3_Y = 497;
							continue;

						}

						// row2
						if (player3_X > 70 && player3_Y == 497) {
							player3_X = player3_X - 190;

							if (player3_X == 260 && player3_Y == 497 && i == roll) {
								player3_X = 450;
								player3_Y = 191;
								break;
							}
						}

						else if (player3_X == 70 && player3_Y == 497) {
							player3_X = 70;
							player3_Y = 344;
							continue;
						}

						// row3
						if (player3_X < 1020 && player3_Y == 344) {
							player3_X = player3_X + 190;
							if (player3_X == 830 && player3_Y == 344 && i == roll) {
								player3_X = 640;
								player3_Y = 38;
								break;
							}

							if (player3_X == 260 && player3_Y == 344 && i == roll) {
								player3_X = 70;
								player3_Y = 650;
								break;
							}
						}

						else if (player3_X == 1020 && player3_Y == 344) {

							player3_X = 1020;
							player3_Y = 191;
							continue;

						}

						// row4
						if (player3_X > 70 && player3_Y == 191) {
							player3_X = player3_X - 190;

							if (player3_X == 640 && player3_Y == 191 && i == roll) {
								player3_X = 450;
								player3_Y = 497;
								break;
							}
						}

						else if (player3_X == 70 && player3_Y == 191) {
							player3_X = 70;
							player3_Y = 38;
							continue;
						}

						// row5
						if (player3_X < 1020 && player3_Y == 38) {
							player3_X = player3_X + 190;

							if (player3_X == 260 && player3_Y == 38 && i == roll) {
								player3_X = 450;
								player3_Y = 344;
								break;
							}

							if (player3_X == 830 && player3_Y == 38 && i == roll) {
								player3_X = 1020;
								player3_Y = 344;
								break;
							}

						}

						// last point
						else if (player3_X == 1020 && player3_Y == 38) {

							player3_X = 1020;
							player3_Y = 38;

							// if stetments to show the winner and postions 
							
							if (winner_1 == null && winner_2 == null && winner_3 == null && winner_4 == null) {

								winner_1 = "Player 3";

							}

							else if (winner_1 != null && !(winner_1.equals("Player 3")) && winner_2 == null
									&& winner_3 == null && winner_4 == null) {
								winner_2 = "Player 3";
							}

							else if (winner_1 != null && !(winner_1.equals("Player 3")) && winner_2 != null
									&& !(winner_2.equals("Player 3")) && winner_3 == null && winner_4 == null) {
								winner_3 = "Player 3";
							}

							else if (winner_1 != null && !(winner_1.equals("Player 3")) && winner_2 != null
									&& !(winner_2.equals("Player 3")) && winner_3 != null
									&& !(winner_3.equals("Player 3")) && winner_4 == null) {
								winner_4 = "Player 3";
							}

							break;

						}

					}

				}

			}

			// ------------------------player 4

			if (obj.is4players == true) {

				if (currentTurn.getText().equals("Player 4")) {

					for (int i = 1; i <= roll; i++) {

						// row1
						if (player4_X < 1050 && player4_Y == 650) {
							player4_X = player4_X + 190;

							if (player4_X == 670 && player4_Y == 650 && i == roll) {
								player4_X = 860;
								player4_Y = 497;
								break;
							}

						}

						else if (player4_X == 1050 && player4_Y == 650) {

							player4_X = 1050;
							player4_Y = 497;
							continue;

						}

						// row2
						if (player4_X > 100 && player4_Y == 497) {
							player4_X = player4_X - 190;

							if (player4_X == 290 && player4_Y == 497 && i == roll) {
								player4_X = 480;
								player4_Y = 191;
								break;
							}
						}

						else if (player4_X == 100 && player4_Y == 497) {
							player4_X = 100;
							player4_Y = 344;
							continue;
						}

						// row3
						if (player4_X < 1050 && player4_Y == 344) {
							player4_X = player4_X + 190;
							if (player4_X == 860 && player4_Y == 344 && i == roll) {
								player4_X = 670;
								player4_Y = 38;
								break;
							}

							if (player4_X == 290 && player4_Y == 344 && i == roll) {
								player4_X = 100;
								player4_Y = 650;
								break;
							}
						}

						else if (player4_X == 1050 && player4_Y == 344) {

							player4_X = 1050;
							player4_Y = 191;
							continue;

						}

						// row4
						if (player4_X > 100 && player4_Y == 191) {
							player4_X = player4_X - 190;

							if (player4_X == 670 && player4_Y == 191 && i == roll) {
								player4_X = 480;
								player4_Y = 497;
								break;
							}
						}

						else if (player4_X == 100 && player4_Y == 191) {
							player4_X = 100;
							player4_Y = 38;
							continue;
						}

						// row5
						if (player4_X < 1050 && player4_Y == 38) {
							player4_X = player4_X + 190;

							if (player4_X == 290 && player4_Y == 38 && i == roll) {
								player4_X = 480;
								player4_Y = 344;
								break;
							}

							if (player4_X == 860 && player4_Y == 38 && i == roll) {
								player4_X = 1050;
								player4_Y = 344;
								break;
							}

						}
						// last point
						
						else if (player4_X == 1050 && player4_Y == 38) {

							player4_X = 1050;
							player4_Y = 38;

							
							// if stetments to show the winner and postions 
							
							if (winner_1 == null && winner_2 == null && winner_3 == null && winner_4 == null) {

								winner_1 = "Player 4";

							}

							else if (winner_1 != null && !(winner_1.equals("Player 4")) && winner_2 == null
									&& winner_3 == null && winner_4 == null) {
								winner_2 = "Player 4";
							}

							else if (winner_1 != null && !(winner_1.equals("Player 4")) && winner_2 != null
									&& !(winner_2.equals("Player 4")) && winner_3 == null && winner_4 == null) {
								winner_3 = "Player 4";
							}

							else if (winner_1 != null && !(winner_1.equals("Player 4")) && winner_2 != null
									&& !(winner_2.equals("Player 4")) && winner_3 != null
									&& !(winner_3.equals("Player 4")) && winner_4 == null) {
								winner_4 = "Player 4";
							}

							break;

						}

					}

				}

			}
			
			// to show which player's turn 

			if (currentTurn.getText().equals("Player 1")) {
				currentTurn.setText("Player 2");
			}

			else if (currentTurn.getText().equals("Player 2")) {
				if (obj.is3players == true) {
					currentTurn.setText("Player 3");
				} else {
					currentTurn.setText("Player 1");
				}

			}

			else if (currentTurn.getText().equals("Player 3")) {
				if (obj.is4players == true) {
					currentTurn.setText("Player 4");
				} else {
					currentTurn.setText("Player 1");
				}

			}

			else if (currentTurn.getText().equals("Player 4")) {
				currentTurn.setText("Player 1");
			}
			
			// every turn will repaint

			bored.repaint();

		}
		
		
		// if stetments give Conditions to show the winner and postions 

		if (obj.is3players == false && obj.is4players == false && player1_X == 960 && player1_Y == 38
				&& player2_X == 990 && player2_Y == 38) {

			new WinnersWindow1();

		}

		if (obj.is4players == false && obj.is3players == true && player1_X == 960 && player1_Y == 38 && player2_X == 990
				&& player2_Y == 38 && player3_X == 1020 && player3_Y == 38) {
			new WinnersWindow1();
		}

		if (obj.is4players == true && player1_X == 960 && player1_Y == 38 && player2_X == 990 && player2_Y == 38
				&& player3_X == 1020 && player3_Y == 38 && player4_X == 1050 && player4_Y == 38) {

			new WinnersWindow1();
		}

	}

	
	// class to put the pictures 
	
	class GamePanel extends JPanel {

		private BufferedImage image;
		private BufferedImage imageMan1;
		private BufferedImage imageMan2;
		private BufferedImage imageMan3;
		private BufferedImage imageMan4;
		private BufferedImage setTrapImage1, setTrapImage2, setTrapImage3, setTrapImage4;

		public GamePanel() {
			try {
				
				image = ImageIO.read(getClass().getResource("images/30.png"));
				imageMan1 = ImageIO.read(getClass().getResource("images/man1.png"));
				imageMan2 = ImageIO.read(getClass().getResource("images/man2.png"));
				if (obj.is3players == true) {
					imageMan3 = ImageIO.read(getClass().getResource("images/man3.png"));
				}
				if (obj.is4players == true) {
					imageMan4 = ImageIO.read(getClass().getResource("images/man4.png"));
				}

				setTrapImage1 = ImageIO.read(getClass().getResource("images/setTrap_30.png"));

				setTrapImage2 = ImageIO.read(getClass().getResource("images/setTrap_30.png"));

				setTrapImage3 = ImageIO.read(getClass().getResource("images/setTrap_30.png"));

				setTrapImage4 = ImageIO.read(getClass().getResource("images/setTrap_30.png"));

			} catch (IOException ex) {
				// handle exception...
			}
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.drawImage(image, 0, 0, this);
			g.drawImage(imageMan1, player1_X, player1_Y, this);
			g.drawImage(imageMan2, player2_X, player2_Y, this);
			g.drawImage(imageMan3, player3_X, player3_Y, this);
			g.drawImage(imageMan4, player4_X, player4_Y, this);

			
			// for trap pictures
			
			if (selectWhoSetTrap == 1) {

				if (setTrap1 == 25) {
					g.drawImage(setTrapImage1, setTrap_1x, setTrap_y, this);
				}

				else if (setTrap1 == 26) {
					g.drawImage(setTrapImage1, setTrap_1x, setTrap_y, this);
				}

				else if (setTrap1 == 27) {
					g.drawImage(setTrapImage1, setTrap_1x, setTrap_y, this);
				}

				else if (setTrap1 == 28) {
					g.drawImage(setTrapImage1, setTrap_1x, setTrap_y, this);
				}

				else if (setTrap1 == 29) {
					g.drawImage(setTrapImage1, setTrap_1x, setTrap_y, this);
				}

			}

			if (selectWhoSetTrap == 2) {
				if (setTrap1 == 25) {
					g.drawImage(setTrapImage2, setTrap_2x, setTrap_y, this);
				}

				else if (setTrap2 == 26) {
					g.drawImage(setTrapImage2, setTrap_2x, setTrap_y, this);
				}

				else if (setTrap2 == 27) {
					g.drawImage(setTrapImage2, setTrap_2x, setTrap_y, this);
				}

				else if (setTrap2 == 28) {
					g.drawImage(setTrapImage2, setTrap_2x, setTrap_y, this);
				}

				else if (setTrap2 == 29) {
					g.drawImage(setTrapImage2, setTrap_2x, setTrap_y, this);
				}
			}

			if (selectWhoSetTrap == 3) {
				if (setTrap3 == 25) {
					g.drawImage(setTrapImage3, setTrap_3x, setTrap_y, this);
				}

				else if (setTrap3 == 26) {
					g.drawImage(setTrapImage3, setTrap_3x, setTrap_y, this);
				}

				else if (setTrap3 == 27) {
					g.drawImage(setTrapImage3, setTrap_3x, setTrap_y, this);
				}

				else if (setTrap3 == 28) {
					g.drawImage(setTrapImage3, setTrap_3x, setTrap_y, this);
				}

				else if (setTrap3 == 29) {
					g.drawImage(setTrapImage3, setTrap_3x, setTrap_y, this);
				}
			}

			if (selectWhoSetTrap == 4) {
				if (setTrap4 == 25) {
					g.drawImage(setTrapImage4, setTrap_4x, setTrap_y, this);
				}

				else if (setTrap4 == 26) {
					g.drawImage(setTrapImage4, setTrap_4x, setTrap_y, this);
				}

				else if (setTrap4 == 27) {
					g.drawImage(setTrapImage4, setTrap_4x, setTrap_y, this);
				}

				else if (setTrap4 == 28) {
					g.drawImage(setTrapImage4, setTrap_4x, setTrap_y, this);
				}

				else if (setTrap4 == 29) {
					g.drawImage(setTrapImage4, setTrap_4x, setTrap_y, this);
				}
			}

		}

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {

		

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	
	
	// class for set traps
	
	class SetTrapClass1 extends JDialog {
		public SetTrapClass1() {
			this.setSize(494, 111);
			this.setLocationRelativeTo(null);
			setLayout(new FlowLayout());

			JLabel text = new JLabel(
					"Set Trap in the last row 25-29 to make anyone fall in it to come back to start point");

			JTextField numberWritten = new JTextField(4);
			JButton okButton = new JButton("ok");

			okButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					try {
						setTrap1 = Integer.parseInt(numberWritten.getText());
						setTrap2 = Integer.parseInt(numberWritten.getText());
						setTrap3 = Integer.parseInt(numberWritten.getText());
						setTrap4 = Integer.parseInt(numberWritten.getText());
					} catch (Exception e3) {
						// TODO: handle exception
					}

					if (setTrap1 < 25 || setTrap1 > 29) {

						JOptionPane.showMessageDialog(null, "The numer should be between 25 - 29", "Warning Message",
								JOptionPane.WARNING_MESSAGE);

					}

					if (setTrap2 < 25 || setTrap2 > 29) {

						JOptionPane.showMessageDialog(null, "The numer should be between 25 - 29", "Warning Message",
								JOptionPane.WARNING_MESSAGE);

					}

					if (setTrap3 < 25 || setTrap3 > 29) {

						JOptionPane.showMessageDialog(null, "The numer should be between 25 - 29", "Warning Message",
								JOptionPane.WARNING_MESSAGE);

					}

					if (setTrap4 < 25 || setTrap4 > 29) {

						JOptionPane.showMessageDialog(null, "The numer should be between 25 - 29", "Warning Message",
								JOptionPane.WARNING_MESSAGE);

					}

					// -------------------------------------------------------

					if (selectWhoSetTrap == 1) {

						if (setTrap1 == 25) {
							setTrap_1x = 50;
						}

						else if (setTrap1 == 26) {
							setTrap_1x = 270;
						}

						else if (setTrap1 == 27) {
							setTrap_1x = 450;
						}

						else if (setTrap1 == 28) {
							setTrap_1x = 600;
						}

						else if (setTrap1 == 29) {
							setTrap_1x = 800;
						}

					}

					if (selectWhoSetTrap == 2) {

						if (setTrap2 == 25) {
							setTrap_2x = 50;
						}

						else if (setTrap2 == 26) {
							setTrap_2x = 270;
						}

						else if (setTrap2 == 27) {
							setTrap_2x = 450;
						}

						else if (setTrap2 == 28) {
							setTrap_2x = 600;
						}

						else if (setTrap2 == 29) {
							setTrap_2x = 800;
						}

					}

					if (selectWhoSetTrap == 3) {

						if (setTrap3 == 25) {
							setTrap_3x = 50;
						}

						else if (setTrap3 == 26) {
							setTrap_3x = 270;
						}

						else if (setTrap3 == 27) {
							setTrap_3x = 450;
						}

						else if (setTrap3 == 28) {
							setTrap_3x = 600;
						}

						else if (setTrap3 == 29) {
							setTrap_3x = 800;
						}

					}

					if (selectWhoSetTrap == 4) {

						if (setTrap4 == 25) {
							setTrap_4x = 50;
						}

						else if (setTrap4 == 26) {
							setTrap_4x = 270;
						}

						else if (setTrap4 == 27) {
							setTrap_4x = 450;
						}

						else if (setTrap4 == 28) {
							setTrap_4x = 600;
						}

						else if (setTrap4 == 29) {
							setTrap_4x = 800;
						}

					}

					setVisible(false);

					bored.repaint();

				}

			});

			add(text);
			add(numberWritten);
			add(okButton);

			setVisible(true);

		}
	}
	
	
	// class for showing the window for the winners

	class WinnersWindow1 extends JDialog {

		public WinnersWindow1() {
			this.setSize(400, 400);
			this.setLocationRelativeTo(null);
			setLayout(new FlowLayout());
			setLayout(new GridLayout(5, 1));

			Font fontText7 = new Font("Arial", Font.BOLD, 20);

			JPanel panel__1 = new JPanel();

			JLabel winnerText_1 = new JLabel("Winner 1 : ");
			JLabel winner__1 = new JLabel(winner_1);

			winnerText_1.setFont(fontText7);
			winner__1.setFont(fontText7);
			winner__1.setForeground(Color.blue);

			panel__1.add(winnerText_1);
			panel__1.add(winner__1);

			// ----------------------------------------------------

			JPanel panel__2 = new JPanel();

			JLabel winnerText_2 = new JLabel("Winner 2 : ");
			JLabel winner__2 = new JLabel(winner_2);
			winnerText_2.setFont(fontText7);
			winner__2.setFont(fontText7);
			winner__2.setForeground(Color.RED);
			panel__2.add(winnerText_2);
			panel__2.add(winner__2);

			// ----------------------------------------------------

			JPanel panel__3 = new JPanel();

			JLabel winnerText_3 = new JLabel("Winner 3 : ");
			JLabel winner__3 = new JLabel(winner_3);
			winnerText_3.setFont(fontText7);
			winner__3.setFont(fontText7);
			winner__3.setForeground(Color.GREEN);
			panel__3.add(winnerText_3);
			panel__3.add(winner__3);

			// ----------------------------------------------------

			JPanel panel__4 = new JPanel();

			JLabel winnerText_4 = new JLabel("Winner 4 : ");
			JLabel winner__4 = new JLabel(winner_4);
			winnerText_4.setFont(fontText7);
			winner__4.setFont(fontText7);
			winner__4.setForeground(Color.DARK_GRAY);
			panel__4.add(winnerText_4);
			panel__4.add(winner__4);

			add(panel__1);
			add(panel__2);

			if (obj.is3players == true) {
				add(panel__3);
			}

			if (obj.is4players == true) {
				add(panel__4);
			}

			// --------------------------------

			JPanel panel__5 = new JPanel();

			restartGame = new JButton("New Game");
			closeGame = new JButton("Exit");

			panel__5.add(restartGame);
			panel__5.add(closeGame);

			restartGame.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					player1_X = 10;
					player2_X = 40;
					player3_X = 70;
					player4_X = 100;

					player1_Y = 650;
					player2_Y = 650;
					player3_Y = 650;
					player4_Y = 650;

					bored.repaint();
					setVisible(false);

				}
			});

			closeGame.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					System.exit(0);

				}
			});

			add(panel__5);

			// ----------------------------------------------------

			setVisible(true);

		}

	}

}
