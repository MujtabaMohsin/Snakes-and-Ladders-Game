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

class Bored_50 extends JFrame
		implements ActionListener, MouseMotionListener   {

	SettingMenu obj = new SettingMenu();

	 
	JButton setTarpButton_1 , setTarpButton_2 , setTarpButton_3 , setTarpButton_4 ;
	
	public int setTrap1 , setTrap2 , setTrap3 , setTrap4;
	
	public int  setTrap_1x, setTrap_2x, setTrap_3x, setTrap_4x, setTrap_y = 45;
	
	public int selectWhoSetTrap;
	
	String winner_1 , winner_2 , winner_3 , winner_4 ;
	
	
	JButton restartGame , closeGame ;

	ImageIcon dicePic1 = new ImageIcon("images/dice1_.png");
	ImageIcon dicePic2 = new ImageIcon("images/dice2_.png");
	ImageIcon dicePic3 = new ImageIcon("images/dice3_.png");
	ImageIcon dicePic4 = new ImageIcon("images/dice4_.png");
	ImageIcon dicePic5 = new ImageIcon("images/dice5_.png");
	ImageIcon dicePic6 = new ImageIcon("images/dice6_.png");

	JLabel mousePos;
	JButton dice;
	static GamePanel bored;
	int frameX = 1690;
	int frameY = 830;

	int player1_X = 10;
	int player2_X = 40;
	int player3_X = 70;
	int player4_X = 90;

	int player1_Y = 680;
	int player2_Y = 680;
	int player3_Y = 680;
	int player4_Y = 680;

	JLabel currentTurn;
	JLabel diceNumber;

	Random r = new Random();
	int roll;
	

	JMenuBar mainBar;
	JMenu Restart, Help, About;
	JMenuItem Restart1, Help2, About3;


	public Bored_50() throws IOException {

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
							  player4_X = 90;

							  player1_Y = 680;
							  player2_Y = 680;
							  player3_Y = 680;
							  player4_Y = 680;
						  
						  bored.repaint();

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
	        	new SetTrapClass();
	             

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
	        	new SetTrapClass();
	             

	        }
	    });
		
		panel3.add(imageMan22);
		panel3.add(player2text);
		panel3.add(setTarpButton_2);

		// ---------------------------panel 4 -----------------
		 

		JPanel panel4 = new JPanel();

		if (obj.is3players == true) {
			ImageIcon imageMan3 = new ImageIcon("images/man3_leftPanel.png");
			JLabel imageMan33 = new JLabel("", imageMan3, JLabel.CENTER);
			JLabel player3text = new JLabel("Player 3");
			player3text.setFont(fontText);
			setTarpButton_3 = new JButton("Set Trap");
			setTarpButton_3.addActionListener(new ActionListener() {

		        public void actionPerformed(ActionEvent e) {
		        	selectWhoSetTrap = 3;
		        	new SetTrapClass();
		             

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
		        	selectWhoSetTrap = 4 ;
		        	new SetTrapClass();
		             

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
		
		

		if (e.getSource() == dice) {

			roll = r.nextInt(6) + 1;
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

			// if stetment to choose which player
			
			
			// ----------------player 1---------------------
			

			if (currentTurn.getText().equals("Player 1")) {

				for (int i = 1; i <= roll; i++) {

					// row1
					if (player1_X < 1270 && player1_Y == 680) {
						player1_X = player1_X + 140;

						if (player1_X == 430 && player1_Y == 680 && i == roll) {
							player1_X = 570;
							player1_Y = 525;
							break;
						}
						
						if (player1_X == 1270 && player1_Y == 680 && i == roll) {
							player1_X = 1130;
							player1_Y = 370;
							break;
						}
						

					}

					else if (player1_X == 1270 && player1_Y == 680) {

						player1_X = 1270;
						player1_Y = 525;
						continue;

					}

					// row2
					if (player1_X > 10 && player1_Y == 525) {
						player1_X = player1_X - 140;

						if (player1_X == 850 && player1_Y == 525 && i == roll) {
							player1_X = 990;
							player1_Y = 215;
							break;
						}
						
						if (player1_X == 290 && player1_Y == 525 && i == roll) {
							player1_X = 150;
							player1_Y = 215;
							break;
						}
						
					}

					else if (player1_X == 10 && player1_Y == 525) {
						player1_X = 10;
						player1_Y = 370;
						continue;
					}

					// row3
					if (player1_X < 1270 && player1_Y == 370) {
						player1_X = player1_X + 140;
						
						if (player1_X == 990 && player1_Y == 370 && i == roll) {
							player1_X = 1130;
							player1_Y = 680;
							break;
						}

						if (player1_X == 710 && player1_Y == 370 && i == roll) {
							player1_X = 570;
							player1_Y = 680;
							break;
						}
						
						 
					}

					else if (player1_X == 1270 && player1_Y == 370) {

						player1_X = 1270;
						player1_Y = 215;
						continue;

					}

					// row4
					if (player1_X > 10 && player1_Y == 215) {
						player1_X = player1_X - 140;


						if (player1_X == 570 && player1_Y == 215 && i == roll) {
							player1_X = 430;
							player1_Y = 370;
							break;
						}
						

						if (player1_X == 290 && player1_Y == 215 && i == roll) {
							player1_X = 430;
							player1_Y = 525;
							break;
						}
						 
					}

					else if (player1_X == 10 && player1_Y == 215) {
						player1_X = 10;
						player1_Y = 60;
						continue;
					}

					// row5
					if (player1_X < 1270 && player1_Y == 60) {
						player1_X = player1_X + 140;


						if (player1_X == 150 && player1_Y == 60 && i == roll) {
							player1_X = 150;
							player1_Y = 680;
							break;
						}
						

						if (player1_X == 990 && player1_Y == 60 && i == roll) {
							player1_X = 850;
							player1_Y = 370;
							break;
						}
						 

					}

					else if (player1_X == 1270 && player1_Y == 60) {

						player1_X = 1270;
						player1_Y = 60;

			if ( winner_1 == null && winner_2 == null && winner_3 == null && winner_4 == null ){
							
				winner_1 = "Player 1";
				
						}
			
			else if ( winner_1 != null && !(winner_1.equals("Player 1")) &&  winner_2 == null 
					
					&& winner_3 == null && winner_4 == null ){
				winner_2 = "Player 1";
			}
			
			else if ( winner_1 != null && !(winner_1.equals("Player 1")) && winner_2 != null
					&& !(winner_2.equals("Player 1")) && winner_3 == null && winner_4 == null ){
				winner_3 = "Player 1";
			}
			
			else if ( winner_1 != null && !(winner_1.equals("Player 1")) && winner_2 != null
					&& !(winner_2.equals("Player 1")) && winner_3 != null && !(winner_3.equals("Player 1"))
					&& winner_4 == null ){
				winner_4 = "Player 1";
			}

						break;

					}

				}

			}
			
			
			// ----------------player 2---------------------
				
			
			if (currentTurn.getText().equals("Player 2")) {

				for (int i = 1; i <= roll; i++) {

					// row1
					if (player2_X < 1300 && player2_Y == 680) {
						player2_X = player2_X + 140;

						if (player2_X == 460 && player2_Y == 680 && i == roll) {
							player2_X = 600;
							player2_Y = 525;
							break;
						}
						
						if (player2_X == 1300 && player2_Y == 680 && i == roll) {
							player2_X = 1160;
							player2_Y = 370;
							break;
						}
						

					}

					else if (player2_X == 1300 && player2_Y == 680) {

						player2_X = 1300;
						player2_Y = 525;
						continue;

					}

					// row2
					if (player2_X > 40 && player2_Y == 525) {
						player2_X = player2_X - 140;

						if (player2_X == 880 && player2_Y == 525 && i == roll) {
							player2_X = 1020;
							player2_Y = 215;
							break;
						}
						
						if (player2_X == 320 && player2_Y == 525 && i == roll) {
							player2_X = 180;
							player2_Y = 215;
							break;
						}
						
					}

					else if (player2_X == 40 && player2_Y == 525) {
						player2_X = 40;
						player2_Y = 370;
						continue;
					}

					// row3
					if (player2_X < 1300 && player2_Y == 370) {
						player2_X = player2_X + 140;
						
						if (player2_X == 1020 && player2_Y == 370 && i == roll) {
							player2_X = 1160;
							player2_Y = 680;
							break;
						}

						if (player2_X == 740 && player2_Y == 370 && i == roll) {
							player2_X = 600;
							player2_Y = 680;
							break;
						}
						
						 
					}

					else if (player2_X == 1300 && player2_Y == 370) {

						player2_X = 1300;
						player2_Y = 215;
						continue;

					}

					// row4
					if (player2_X > 40 && player2_Y == 215) {
						player2_X = player2_X - 140;


						if (player2_X == 600 && player2_Y == 215 && i == roll) {
							player2_X = 460;
							player2_Y = 370;
							break;
						}
						

						if (player2_X == 320 && player2_Y == 215 && i == roll) {
							player2_X = 460;
							player2_Y = 525;
							break;
						}
						 
					}

					else if (player2_X == 40 && player2_Y == 215) {
						player2_X = 40;
						player2_Y = 60;
						continue;
					}

					// row5
					if (player2_X < 1300 && player2_Y == 60) {
						player2_X = player2_X + 140;


						if (player2_X == 180 && player2_Y == 60 && i == roll) {
							player2_X = 180;
							player2_Y = 680;
							break;
						}
						

						if (player2_X == 1020 && player2_Y == 60 && i == roll) {
							player2_X = 880;
							player2_Y = 370;
							break;
						}
						 

					}

			     	else if (player2_X == 1300 && player2_Y == 60) {

						player2_X = 1300;
						player2_Y = 60;
						
				if ( winner_1 == null && winner_2 == null && winner_3 == null && winner_4 == null ){
							
							winner_1 = "Player 2";
							
									}
						
				else if ( winner_1 != null && !(winner_1.equals("Player 2")) &&  winner_2 == null && winner_3 == null && winner_4 == null ){
							winner_2 = "Player 2";
						}
						
				else if ( winner_1 != null  && !(winner_1.equals("Player 2")) 
						&& winner_2 != null  && !(winner_2.equals("Player 2")) && winner_3 == null && winner_4 == null ){
							winner_3 = "Player 2";
						}
						
				else if ( winner_1 != null  && !(winner_1.equals("Player 2")) && winner_2 != null
						 && !(winner_2.equals("Player 2")) && winner_3 != null  && !(winner_3.equals("Player 2"))
						 && winner_4 == null ){
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
						if (player3_X < 1330 && player3_Y == 680) {
							player3_X = player3_X + 140;

							if (player3_X == 490 && player3_Y == 680 && i == roll) {
								player3_X = 630;
								player3_Y = 525;
								break;
							}
							
							if (player3_X == 1330 && player3_Y == 680 && i == roll) {
								player3_X = 1190;
								player3_Y = 370;
								break;
							}
							

						}

						else if (player3_X == 1330 && player3_Y == 680) {

							player3_X = 1330;
							player3_Y = 525;
							continue;

						}

						// row2
						if (player3_X > 70 && player3_Y == 525) {
							player3_X = player3_X - 140;

							if (player3_X == 910 && player3_Y == 525 && i == roll) {
								player3_X = 1050;
								player3_Y = 215;
								break;
							}
							
							if (player3_X == 350 && player3_Y == 525 && i == roll) {
								player3_X = 210;
								player3_Y = 215;
								break;
							}
							
						}

						else if (player3_X == 70 && player3_Y == 525) {
							player3_X = 70;
							player3_Y = 370;
							continue;
						}

						// row3
						if (player3_X < 1330 && player3_Y == 370) {
							player3_X = player3_X + 140;
							
							if (player3_X == 1050 && player3_Y == 370 && i == roll) {
								player3_X = 1190;
								player3_Y = 680;
								break;
							}

							if (player3_X == 770 && player3_Y == 370 && i == roll) {
								player3_X = 630;
								player3_Y = 680;
								break;
							}
							
							 
						}

						else if (player3_X == 1330 && player3_Y == 370) {

							player3_X = 1330;
							player3_Y = 215;
							continue;

						}

						// row4
						if (player3_X > 70 && player3_Y == 215) {
							player3_X = player3_X - 140;


							if (player3_X == 630 && player3_Y == 215 && i == roll) {
								player3_X = 490;
								player3_Y = 370;
								break;
							}
							

							if (player3_X == 350 && player3_Y == 215 && i == roll) {
								player3_X = 490;
								player3_Y = 525;
								break;
							}
							 
						}

						else if (player3_X == 70 && player3_Y == 215) {
							player3_X = 70;
							player3_Y = 60;
							continue;
						}

						// row5
						if (player3_X < 1330 && player3_Y == 60) {
							player3_X = player3_X + 140;


							if (player3_X == 210 && player3_Y == 60 && i == roll) {
								player3_X = 210;
								player3_Y = 680;
								break;
							}
							

							if (player3_X == 1050 && player3_Y == 60 && i == roll) {
								player3_X = 910;
								player3_Y = 370;
								break;
							}
							 

						}

						else if (player3_X == 1330 && player3_Y == 60) {

							player3_X = 1330;
							player3_Y = 60;

							if ( winner_1 == null && winner_2 == null && winner_3 == null && winner_4 == null ){
								
								winner_1 = "Player 3";
								
										}
							
							else if ( winner_1 != null  && !(winner_1.equals("Player 3")) && winner_2 == null && winner_3 == null && winner_4 == null ){
								winner_2 = "Player 3";
							}
							
							else if ( winner_1 != null && !(winner_1.equals("Player 3")) && winner_2 != null 
									&& !(winner_2.equals("Player 3")) && winner_3 == null && winner_4 == null ){
								winner_3 = "Player 3";
							}
							
							else if ( winner_1 != null && !(winner_1.equals("Player 3")) && winner_2 != null 
									&& !(winner_2.equals("Player 3")) && winner_3 != null && !(winner_3.equals("Player 3")) && winner_4 == null ){
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
						if (player4_X < 1350 && player4_Y == 680) {
							player4_X = player4_X + 140;

							if (player4_X == 510 && player4_Y == 680 && i == roll) {
								player4_X = 650;
								player4_Y = 525;
								break;
							}
							
							if (player4_X == 1350 && player4_Y == 680 && i == roll) {
								player4_X = 1210;
								player4_Y = 370;
								break;
							}
							

						}

						else if (player4_X == 1350 && player4_Y == 680) {

							player4_X = 1350;
							player4_Y = 525;
							continue;

						}

						// row2
						if (player4_X > 90 && player4_Y == 525) {
							player4_X = player4_X - 140;

							if (player4_X == 930 && player4_Y == 525 && i == roll) {
								player4_X = 1070;
								player4_Y = 215;
								break;
							}
							
							if (player4_X == 370 && player4_Y == 525 && i == roll) {
								player4_X = 230;
								player4_Y = 215;
								break;
							}
							
						}

						else if (player4_X == 90 && player4_Y == 525) {
							player4_X = 90;
							player4_Y = 370;
							continue;
						}

						// row3
						if (player4_X < 1350 && player4_Y == 370) {
							player4_X = player4_X + 140;
							
							if (player4_X == 1070 && player4_Y == 370 && i == roll) {
								player4_X = 1210;
								player4_Y = 680;
								break;
							}

							if (player4_X == 790 && player4_Y == 370 && i == roll) {
								player4_X = 650;
								player4_Y = 680;
								break;
							}
							
							 
						}

						else if (player4_X == 1350 && player4_Y == 370) {

							player4_X = 1350;
							player4_Y = 215;
							continue;

						}

						// row4
						if (player4_X > 90 && player4_Y == 215) {
							player4_X = player4_X - 140;


							if (player4_X == 650 && player4_Y == 215 && i == roll) {
								player4_X = 510;
								player4_Y = 370;
								break;
							}
							

							if (player4_X == 370 && player4_Y == 215 && i == roll) {
								player4_X = 510;
								player4_Y = 525;
								break;
							}
							 
						}

						else if (player4_X == 90 && player4_Y == 215) {
							player4_X = 90;
							player4_Y = 60;
							continue;
						}

						// row5
						if (player4_X < 1350 && player4_Y == 60) {
							player4_X = player4_X + 140;


							if ( player4_X == 230 && player4_Y == 60 && i == roll) {
								player4_X = 230;
								player4_Y = 680;
								break;
							}
							

							if (player4_X == 1070 && player4_Y == 60 && i == roll) {
								player4_X = 930;
								player4_Y = 370;
								break;
							}
							 

						}

						else if (player4_X == 1350 && player4_Y == 60) {

							player4_X = 1350;
							player4_Y = 60;

							if ( winner_1 == null && winner_2 == null && winner_3 == null && winner_4 == null ){
								
								winner_1 = "Player 4";
								
										}
							
							else if ( winner_1 != null && !(winner_1.equals("Player 4"))  && winner_2 == null && winner_3 == null && winner_4 == null ){
								winner_2 = "Player 4";
							}
							
							else if ( winner_1 != null && !(winner_1.equals("Player 4")) && winner_2 != null 
									&& !(winner_2.equals("Player 4"))	&& winner_3 == null && winner_4 == null ){
								winner_3 = "Player 4";
							}
							
							else if ( winner_1 != null && !(winner_1.equals("Player 4")) && winner_2 != null 
									&& !(winner_2.equals("Player 4")) && winner_3 != null && !(winner_3.equals("Player 4")) && winner_4 == null ){
								winner_4 = "Player 4";
							}
							
							
							break;

						}

					}

				}
				
				
			}
			 

			 

			if (currentTurn.getText().equals("Player 1")) {
				currentTurn.setText("Player 2");
			}

			
			
			
			else if (currentTurn.getText().equals("Player 2")) {
				if (obj.is3players == true) {
					currentTurn.setText("Player 3");
				}
				else{
					currentTurn.setText("Player 1");
				}
				
			}

			else if (currentTurn.getText().equals("Player 3")) {
				if (obj.is4players == true) {
					currentTurn.setText("Player 4");
				}
				else{
					currentTurn.setText("Player 1");
				}
				 
			}

			else if (currentTurn.getText().equals("Player 4")) {
				currentTurn.setText("Player 1");
			}

			bored.repaint();

		}
		
		
		
		
		if ( obj.is3players == false && obj.is4players == false &&
			player1_X == 1270 && player1_Y == 60 && player2_X == 1300 && player2_Y == 60 ){
			
			new WinnersWindow();
			
		}
		
		if ( obj.is4players == false  && obj.is3players == true && player1_X == 1270 && player1_Y == 60 && 
				player2_X == 1300 && player2_Y == 60 && player3_X == 1330 && player3_Y == 60  ){
			new WinnersWindow();
		}
		
		if (obj.is4players == true && player1_X == 1270 && player1_Y == 60 && 
				player2_X == 1300 && player2_Y == 60 && player3_X == 1330 && player3_Y == 60 
				&& player4_X == 1350 && player4_Y == 60
				){
			
			new WinnersWindow();
		}
		
		

	}

	class GamePanel extends JPanel {

		private BufferedImage image;
		private BufferedImage imageMan1;
		private BufferedImage imageMan2;
		private BufferedImage imageMan3;
		private BufferedImage imageMan4;
		private BufferedImage setTrapImage1 , setTrapImage2 , setTrapImage3 , setTrapImage4 ;

		public GamePanel() {
			try {

				image = ImageIO.read(getClass().getResource("images/50.png"));
				imageMan1 = ImageIO.read(getClass().getResource("images/man1_50.png"));
				imageMan2 = ImageIO.read(getClass().getResource("images/man2_50.png"));
				if (obj.is3players == true) {
					imageMan3 = ImageIO.read(getClass().getResource("images/man3_50.png"));
				}
				if (obj.is4players == true) {
					imageMan4 = ImageIO.read(getClass().getResource("images/man4_50.png"));
				}
				
				

				 setTrapImage1 = ImageIO.read(getClass().getResource("images/setTrap_50.png"));
				 
				 setTrapImage2 = ImageIO.read(getClass().getResource("images/setTrap_50.png"));
			
			 
				 setTrapImage3 = ImageIO.read(getClass().getResource("images/setTrap_50.png"));

				 setTrapImage4 = ImageIO.read(getClass().getResource("images/setTrap_50.png"));
			 
				

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
			
			if ( selectWhoSetTrap == 1 ){
				
				if (setTrap1 == 41 ){
					g.drawImage(setTrapImage1, setTrap_1x, setTrap_y, this);
				}
				
				else if (setTrap1 == 42 ){
					g.drawImage(setTrapImage1, setTrap_1x, setTrap_y, this);
				}
				
				else if (setTrap1 == 43 ){
					g.drawImage(setTrapImage1, setTrap_1x, setTrap_y, this);
				}
				
				else if (setTrap1 == 44 ){
					g.drawImage(setTrapImage1, setTrap_1x, setTrap_y, this);
				}
				
				else if (setTrap1 == 45 ){
					g.drawImage(setTrapImage1, setTrap_1x, setTrap_y, this);
				}
				
				else if (setTrap1 == 46 ){
					g.drawImage(setTrapImage1, setTrap_1x, setTrap_y, this);
				}
				
				else if (setTrap1 == 47 ){
					g.drawImage(setTrapImage1, setTrap_1x, setTrap_y, this);
				}
				
				else if (setTrap1 == 48 ){
					g.drawImage(setTrapImage1, setTrap_1x, setTrap_y, this);
				}
				
				else if (setTrap1 == 49 ){
					g.drawImage(setTrapImage1, setTrap_1x, setTrap_y, this);
				}
				
			}
			
			 if ( selectWhoSetTrap == 2 ){ 
				if (setTrap1 == 25 ){
					g.drawImage(setTrapImage2, setTrap_2x, setTrap_y, this);
				}
				
				else if (setTrap2 == 41 ){
					g.drawImage(setTrapImage2, setTrap_2x, setTrap_y, this);
				}
				
				else if (setTrap2 == 42 ){
					g.drawImage(setTrapImage2, setTrap_2x, setTrap_y, this);
				}
				
				else if (setTrap2 == 43 ){
					g.drawImage(setTrapImage2, setTrap_2x, setTrap_y, this);
				}
				
				else if (setTrap2 == 44 ){
					g.drawImage(setTrapImage2, setTrap_2x, setTrap_y, this);
				}
				
				else if (setTrap2 == 45 ){
					g.drawImage(setTrapImage2, setTrap_2x, setTrap_y, this);
				}
				
				else if (setTrap2 == 46 ){
					g.drawImage(setTrapImage2, setTrap_2x, setTrap_y, this);
				}
				
				else if (setTrap2 == 47 ){
					g.drawImage(setTrapImage2, setTrap_2x, setTrap_y, this);
				}
				
				else if (setTrap2 == 48 ){
					g.drawImage(setTrapImage2, setTrap_2x, setTrap_y, this);
				}
				
				else if (setTrap2 == 49 ){
					g.drawImage(setTrapImage2, setTrap_2x, setTrap_y, this);
				}
			}
			
			 if ( selectWhoSetTrap == 3 ){ 
				if (setTrap3 == 41 ){
					g.drawImage(setTrapImage3, setTrap_3x, setTrap_y, this);
				}
				
				else if (setTrap3 == 42 ){
					g.drawImage(setTrapImage3, setTrap_3x, setTrap_y, this);
				}
				
				else if (setTrap3 == 43 ){
					g.drawImage(setTrapImage3, setTrap_3x, setTrap_y, this);
				}
				
				else if (setTrap3 == 44 ){
					g.drawImage(setTrapImage3, setTrap_3x, setTrap_y, this);
				}
				
				else if (setTrap3 == 45 ){
					g.drawImage(setTrapImage3, setTrap_3x, setTrap_y, this);
				}
				
				else if (setTrap3 == 46 ){
					g.drawImage(setTrapImage3, setTrap_3x, setTrap_y, this);
				}
				
				else if (setTrap3 == 47 ){
					g.drawImage(setTrapImage3, setTrap_3x, setTrap_y, this);
				}
				
				else if (setTrap3 == 48 ){
					g.drawImage(setTrapImage3, setTrap_3x, setTrap_y, this);
				}
				
				else if (setTrap3 == 49 ){
					g.drawImage(setTrapImage3, setTrap_3x, setTrap_y, this);
				}
				
			}
			
			if ( selectWhoSetTrap == 4 ){ 
				if (setTrap4 == 41 ){
					g.drawImage(setTrapImage4, setTrap_4x, setTrap_y, this);
				}
				
				else if (setTrap4 == 42 ){
					g.drawImage(setTrapImage4, setTrap_4x, setTrap_y, this);
				}
				
				else if (setTrap4 == 43 ){
					g.drawImage(setTrapImage4, setTrap_4x, setTrap_y, this);
				}
				
				else if (setTrap4 == 44 ){
					g.drawImage(setTrapImage4, setTrap_4x, setTrap_y, this);
				}
				
				else if (setTrap4 == 45 ){
					g.drawImage(setTrapImage4, setTrap_4x, setTrap_y, this);
				}
				
				else if (setTrap4 == 46 ){
					g.drawImage(setTrapImage4, setTrap_4x, setTrap_y, this);
				}
				
				else if (setTrap4 == 47 ){
					g.drawImage(setTrapImage4, setTrap_4x, setTrap_y, this);
				}
				
				else if (setTrap4 == 48 ){
					g.drawImage(setTrapImage4, setTrap_4x, setTrap_y, this);
				}
				
				else if (setTrap4 == 49 ){
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
	
	
	class SetTrapClass extends JDialog {
		public SetTrapClass() {
			this.setSize(494, 111);
			this.setLocationRelativeTo(null);
			setLayout(new FlowLayout());

			JLabel text = new JLabel(
					"Set Trap in the last row 41-49 to make anyone fall in it to come back to start point");

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

					if (setTrap1 < 41 || setTrap1 > 49) {

						JOptionPane.showMessageDialog(null, "The numer should be between 41 - 49", "Warning Message",
								JOptionPane.WARNING_MESSAGE);

					}
					
					if (setTrap2 < 41 || setTrap2 > 49) {

						JOptionPane.showMessageDialog(null, "The numer should be between 41 - 49", "Warning Message",
								JOptionPane.WARNING_MESSAGE);

					}
					
					if (setTrap3 < 41 || setTrap3 > 49) {

						JOptionPane.showMessageDialog(null, "The numer should be between 41 - 49", "Warning Message",
								JOptionPane.WARNING_MESSAGE);

					}
					
					if (setTrap4 < 41 || setTrap4 > 49) {

						JOptionPane.showMessageDialog(null, "The numer should be between 41 - 49", "Warning Message",
								JOptionPane.WARNING_MESSAGE);

					}
					
					
					//-------------------------------------------------------
					
					if ( selectWhoSetTrap == 1 ){
						
						if (setTrap1 == 41 ){
							setTrap_1x = 40;
						}
						
						else if (setTrap1 == 42 ){
							setTrap_1x = 190;
						}
						
						else if (setTrap1 == 43 ){
							setTrap_1x =  320 ;
						}
						
						else if (setTrap1 == 44 ){
							setTrap_1x = 450  ;
						}
						
						else if (setTrap1 == 45 ){
							setTrap_1x = 600  ;
						}
						
						else if (setTrap1 == 46 ){
							setTrap_1x =  733 ;
						}
						
						else if (setTrap1 == 47 ){
							setTrap_1x = 888 ;
						}
						
						else if (setTrap1 == 48 ){
							setTrap_1x = 1028 ;
						}
						
						else if (setTrap1 == 49 ){
							setTrap_1x = 1150  ;
						}
						
						
						
					}
					
					 if ( selectWhoSetTrap == 2 ){
						
							if (setTrap1 == 41 ){
								setTrap_2x = 30;
							}
							
							else if (setTrap1 == 42 ){
								setTrap_2x = 180;
							}
							
							else if (setTrap1 == 43 ){
								setTrap_2x =  300 ;
							}
							
							else if (setTrap1 == 44 ){
								setTrap_2x = 440  ;
							}
							
							else if (setTrap1 == 45 ){
								setTrap_2x = 600  ;
							}
							
							else if (setTrap1 == 46 ){
								setTrap_2x =  735 ;
							}
							
							else if (setTrap1 == 47 ){
								setTrap_2x = 888 ;
							}
							
							else if (setTrap1 == 48 ){
								setTrap_2x = 1022 ;
							}
							
							else if (setTrap1 == 49 ){
								setTrap_2x = 1150  ;
							}
						
					}
					
					 if ( selectWhoSetTrap == 3 ){
						
							if (setTrap1 == 41 ){
								setTrap_3x = 30;
							}
							
							else if (setTrap1 == 42 ){
								setTrap_3x = 179;
							}
							
							else if (setTrap1 == 43 ){
								setTrap_3x =  310 ;
							}
							
							else if (setTrap1 == 44 ){
								setTrap_3x = 450  ;
							}
							
							else if (setTrap1 == 45 ){
								setTrap_3x = 600  ;
							}
							
							else if (setTrap1 == 46 ){
								setTrap_3x =  735 ;
							}
							
							else if (setTrap1 == 47 ){
								setTrap_3x = 880 ;
							}
							
							else if (setTrap1 == 48 ){
								setTrap_3x = 1030 ;
							}
							
							else if (setTrap1 == 49 ){
								setTrap_3x = 1160  ;
							}
						
					}
					
					if ( selectWhoSetTrap == 4 ){
						
						if (setTrap1 == 41 ){
							setTrap_4x = 30;
						}
						
						else if (setTrap1 == 42 ){
							setTrap_4x = 180;
						}
						
						else if (setTrap1 == 43 ){
							setTrap_4x =  303 ;
						}
						
						else if (setTrap1 == 44 ){
							setTrap_4x = 450  ;
						}
						
						else if (setTrap1 == 45 ){
							setTrap_4x = 600  ;
						}
						
						else if (setTrap1 == 46 ){
							setTrap_4x =  735 ;
						}
						
						else if (setTrap1 == 47 ){
							setTrap_4x = 877 ;
						}
						
						else if (setTrap1 == 48 ){
							setTrap_4x = 1018 ;
						}
						
						else if (setTrap1 == 49 ){
							setTrap_4x = 1150  ;
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
	
	class WinnersWindow extends JDialog {
		public WinnersWindow() {
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
			
			//----------------------------------------------------
			
			JPanel panel__2 = new JPanel();
			
			JLabel winnerText_2 = new JLabel("Winner 2 : ");
			JLabel winner__2 = new JLabel(winner_2);
			winnerText_2.setFont(fontText7);
			winner__2.setFont(fontText7);
			winner__2.setForeground(Color.RED);
			panel__2.add(winnerText_2);
			panel__2.add(winner__2);
			
			
			//----------------------------------------------------
			
			
			
				JPanel panel__3 = new JPanel();
			
			JLabel winnerText_3 = new JLabel("Winner 3 : ");
			JLabel winner__3 = new JLabel(winner_3);
			winnerText_3.setFont(fontText7);
			winner__3.setFont(fontText7);
			winner__3.setForeground(Color.GREEN);
			panel__3.add(winnerText_3);
			panel__3.add(winner__3);
			 
			
			
			//----------------------------------------------------
			
			 
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
			
			
			//--------------------------------
			
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
						  player4_X = 90;

						  player1_Y = 680;
						  player2_Y = 680;
						  player3_Y = 680;
						  player4_Y = 680;
					  
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
			
			//----------------------------------------------------
			
			
			
			setVisible(true);

		}
	}

}
