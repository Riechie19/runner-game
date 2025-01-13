package main;

import javax.swing.JFrame;

public class GameFrame extends JFrame{
	private static final long serialVersionUID = 1L;

	public GameFrame(GamePanel gamePanel)
	{
		this.setTitle("Runner Game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.add(gamePanel);
		this.setVisible(true);
	}
}
