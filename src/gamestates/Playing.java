package gamestates;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import Objects.Obstacle;
import Objects.Rocket;
import main.Game;

public class Playing extends State implements Statemethods{
	
	private Rocket rocket;
	private ArrayList<Obstacle> obstacles;
	private int speed;
	private int time;
	private int currentTime;
	private int intervalValue[];
	private int intervalValue2[];
	boolean isJumping = false;
	
	public Playing(Game game) {
		super(game);
		init();
	}
	
	public void init()
	{
		currentTime = -1;
		speed = 8;
		rocket = new Rocket(122);
		obstacles = new ArrayList<Obstacle>();
		obstacles.add(new Obstacle()); 
		intervalValue = new int[] {200,420, 480};
		intervalValue2 = new int[] {220, 250, 360  };
	}

	@Override
	public void update() {
		rocket.update();
		time = game.getGameTimeIndex();
		if (currentTime != time)
		{
			currentTime = time;
			if(currentTime%10 == 0 && currentTime != 0)
				speed++;
		}
		Obstacle.setSpeed(speed);
		for (int i = 0; i<obstacles.size();i++)
		{
			if (obstacles.get(i).getX() == getRandomValue1(intervalValue) || obstacles.get(i).getX() == getRandomValue2(intervalValue2))
			{
				if (obstacles.get(i).getHasAdd()==false)
				{
					obstacles.add(new Obstacle());
					obstacles.get(i).setHasAdd();
				}
			}
			if(obstacles.get(i).getHasAdd()==false && obstacles.get(i).getX() <0)
			{
				obstacles.add(new Obstacle());
				obstacles.get(i).setHasAdd();
			}
			if(rocket.intersects(obstacles.get(i)))
			{
				game.stopSE();
				if(game.getAudioOff() != true)game.startSE(2);
				game.stop();
				game.stopGameTimer();
				if (game.getBestScore() < currentTime)game.setBestScore(currentTime);;
			}
		}
		for (int i = 0; i < obstacles.size();i++)
		{
			obstacles.get(i).update();
			if (obstacles.get(i).getX() < 0-obstacles.get(i).getWidth())
				obstacles.remove(i);
		}
		game.repaint();
		
	}
	

	@Override
	public void render(Graphics g) {
		for(int i=0; i < game.getXDraw().size();i++)
		{
			g.setColor(game.getColors().get(i));
			g.fillOval(game.getXDraw().get(i), game.getYDraw().get(i), 8, 8);
		}
		g.setColor(new Color(100, 233, 150));
		g.fillRect(0, 400, 1000, 200);
		
		Dimension d = game.getPanelSize();
		Font font1 = new Font("Helvetica", Font.BOLD, 15);
		g.setFont(font1);
		FontMetrics fm1 = g.getFontMetrics();
		int x1 = (int) (( d.getWidth() - fm1.stringWidth("Score: ")) / 2);
		int x2 = (int) (( d.getWidth() - fm1.stringWidth("Best Score: ")) / 2);
		g.setColor(Color.white);
		g.drawString("Score: "+game.getGameTimeIndex(), x1, 50);
		g.drawString("Best Score: " + game.getBestScore(), x2, 75);
		
		if(game.gameOver())
		{
			Font font2 = new Font("Helvetica", Font.BOLD, 50);
			g.setFont(font2);
			drawCenteredString("Game Over.", d.width, d.height, g);
		}
		
		rocket.render(g);
		for (int i = 0; i < obstacles.size();i++)
			obstacles.get(i).render(g);
		
	}
	
	public void drawCenteredString(String s, int w, int h, Graphics g) 
	{
		FontMetrics fm2 = g.getFontMetrics();
		int x = (w - fm2.stringWidth(s)) / 2;
		int y = (fm2.getAscent() + (h - (fm2.getAscent() + fm2.getDescent())) / 2);
		g.setColor(Color.white);
		g.drawString(s, x, y);
	}
	
	public static int getRandomValue1 (int[] array) 
	{
		Random random = new Random();
		int result = random.nextInt(array.length);
		return array[result];
	}
	public static int getRandomValue2 (int[] array) 
	{
		Random random = new Random();
		int result = random.nextInt(array.length);
		return array[result];
	}

	@Override
	public void mouseClicked(MouseEvent e) {
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
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_SPACE:
		{
			if(game.gameOver())
			{
				game.stopSE();
				game.init();
				game.stopMusic();
				game.runGameTimer();
			}
			else 
			{
				if (rocket.isGrounded())
				{
					if(game.getAudioOff() != true) game.startSE(1);
					rocket.jump();
				}
			}
			isJumping = true;
			break;
		}
		case KeyEvent.VK_UP:
		{
			if(game.gameOver())
			{
				game.stopSE();
				game.init();
				game.stopMusic();
				game.runGameTimer();
			}
			else 
			{
				if (rocket.isGrounded())
				{
					if(game.getAudioOff() != true) game.startSE(1);
					rocket.jump();
				}
			}
			isJumping = true;
			break;
		}
		case KeyEvent.VK_DOWN:
		{
			if (isJumping == false && rocket.isGrounded() == false)
				rocket.down();
			break;
		}
		case KeyEvent.VK_ESCAPE:
		{
			if (game.gameOver())
			{
				game.stopSE();
				Gamestate.state = Gamestate.GAMEMENU;
				game.init();
			}
			break;
		}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_SPACE:
		{
			isJumping = false;
			break;
		}
		case KeyEvent.VK_UP:
		{
			isJumping = false;
			break;
		}
		}
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
