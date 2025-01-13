package main;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

import Input.KeyInput;
import Input.MouseInput;

public class GamePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private Game game;
	private MouseInput mouseInput;
	Timer timer;
	int timeIndex;
	TimerTask task;
	
	public GamePanel(Game game)
	{
		mouseInput = new MouseInput(this);
		this.game = game;
		//this.setBackground(new Color(120,200,255));
		this.setBackground(Color.BLACK);
		this.addKeyListener(new KeyInput(this));
		addMouseListener(mouseInput);
		addMouseMotionListener(mouseInput);
	}
	
	public void paint (Graphics g)
	{
		super.paintComponent(g);
		
		game.render(g);
	}
	
	public void drawCenteredString(String s, int w, int h, Graphics g) 
	{
		FontMetrics fm2 = g.getFontMetrics();
		int x = (w - fm2.stringWidth(s)) / 2;
		int y = (fm2.getAscent() + (h - (fm2.getAscent() + fm2.getDescent())) / 2);
		g.setColor(Color.black);
		g.drawString(s, x, y);
	}
	
	public void runTimer()
	{
		timer = new Timer();
		timeIndex = 0;
		task = new TimerTask() {
			public void run () {
				timeIndex++;
			}
		};
		timer.schedule(task, 0, 1000);
	}
	public void stopTimer()
	{
		timer.cancel();
	}
	
	public int getTimeIndex()
	{
		return timeIndex;
	}
	
	public Game getGame()
	{
		return game;
	}
}
