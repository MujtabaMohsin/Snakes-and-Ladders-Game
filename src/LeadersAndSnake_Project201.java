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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class LeadersAndSnake_Project201 extends JFrame
		implements ActionListener, MouseListener, MouseMotionListener, Runnable {

	SettingMenu obj = new SettingMenu();

	public JTextField setNamePlayer01, setNamePlayer02, setNamePlayer03, setNamePlayer04;

	ImageIcon dicePic1 = new ImageIcon("images/dice1_.png");
	ImageIcon dicePic2 = new ImageIcon("images/dice2_.png");
	ImageIcon dicePic3 = new ImageIcon("images/dice3_.png");
	ImageIcon dicePic4 = new ImageIcon("images/dice4_.png");
	ImageIcon dicePic5 = new ImageIcon("images/dice5_.png");
	ImageIcon dicePic6 = new ImageIcon("images/dice6_.png");

	JLabel mousePos;
	JButton dice;
	static GamePanel bored;
	int frameX = 1440;
	int frameY = 800;

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

	public LeadersAndSnake_Project201() {

		setTitle("Game");
		setSize(frameX, frameY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// -----------------left panel------------------------------

		JPanel leftPanel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(leftPanel);
		leftPanel.setLayout(groupLayout);

		// ---------------------------panel 1.
	 

		JPanel panel1 = new JPanel();

		ImageIcon image = new ImageIcon("images/upLogo.png");
		JLabel Logo = new JLabel("", image, JLabel.CENTER);
		panel1.add(Logo);

		Font fontText = new Font("Arial", Font.BOLD, 20);
		Font fontText2 = new Font("Calibri", Font.BOLD, 18);

		// ---------------------------panel 2
		 

		JPanel panel2 = new JPanel();
		 
		ImageIcon imageMan1 = new ImageIcon("images/man1.png");
		JLabel imageMan11 = new JLabel("", imageMan1, JLabel.CENTER);
 
		JLabel player1text = new JLabel("Player 2");
		player1text.setFont(fontText);

		panel2.add(imageMan11);
		panel2.add(player1text);
		// ---------------------------panel3
		 

		JPanel panel3 = new JPanel();

		ImageIcon imageMan2 = new ImageIcon("images/man2.png");
		JLabel imageMan22 = new JLabel("", imageMan2, JLabel.CENTER);
		JLabel player2text = new JLabel("Player 2");
		player2text.setFont(fontText);
		panel3.add(imageMan22);
		panel3.add(player2text);

		// ---------------------------panel 4 -----------------
		 

		JPanel panel4 = new JPanel();

		if (obj.is3players == true) {
			ImageIcon imageMan3 = new ImageIcon("images/man3.png");
			JLabel imageMan33 = new JLabel("", imageMan3, JLabel.CENTER);
			JLabel player3text = new JLabel("Player 3");
			player3text.setFont(fontText);
			panel4.add(imageMan33);
			panel4.add(player3text);
		}

		// ---------------------------panel 5 ----------------------------

		JPanel panel5 = new JPanel();

		if (obj.is4players == true) {
			ImageIcon imageMan4 = new ImageIcon("images/man4.png");
			JLabel imageMan44 = new JLabel("", imageMan4, JLabel.CENTER);
			JLabel player4text = new JLabel("Player 4");
			player4text.setFont(fontText);
			panel4.add(imageMan44);
			panel4.add(player4text);
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

		mousePos = new JLabel("4");
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

					else if (player1_X == 960 && player1_Y == 38) {

						player1_X = 960;
						player1_Y = 38;
						JOptionPane.showMessageDialog(null, "Player 1 won");
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

					else if (player2_X == 960 && player2_Y == 38) {

						player2_X = 990;
						player2_Y = 38;
						JOptionPane.showMessageDialog(null, "Player 2 won");
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

						else if (player3_X == 1020 && player3_Y == 38) {

							player3_X = 1020;
							player3_Y = 38;
							JOptionPane.showMessageDialog(null, "Player 3 won");
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

						else if (player4_X == 70 && player4_Y == 497) {
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

						else if (player4_X == 1050 && player4_Y == 38) {

							player4_X = 1050;
							player4_Y = 38;
							JOptionPane.showMessageDialog(null, "Player 4 won");
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

	}

	class GamePanel extends JPanel {

		private BufferedImage image;
		private BufferedImage imageMan1;
		private BufferedImage imageMan2;
		private BufferedImage imageMan3;
		private BufferedImage imageMan4;

		public GamePanel() {
			try {

				image = ImageIO.read(new File("images/30.png"));
				imageMan1 = ImageIO.read(new File("images/man1.png"));
				imageMan2 = ImageIO.read(new File("images/man2.png"));
				if (obj.is3players == true) {
					imageMan3 = ImageIO.read(new File("images/man3.png"));
				}
				if (obj.is4players == true) {
					imageMan4 = ImageIO.read(new File("images/man4.png"));
				}

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

		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {

		mousePos.setText("x =" + arg0.getX() + ", y =" + arg0.getY());

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
