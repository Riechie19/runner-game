package Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Obstacle {
	private int x, y, width, height;
	private static int speed;
	private int R;
	private int G;
	private int B;
	boolean hasAdd;
	public Obstacle()
	{
		this.width = (int) Math.floor(Math.random() *(50 - 20 + 1) + 20);
		this.height = (int) Math.floor(Math.random() *(100 - 60 + 1) + 60);
		this.x = 1000;
		this.y = 400-height;
		this.hasAdd = false;
		Random random = new Random();
		R = random.nextInt(250)+1;
		G = random.nextInt(250)+1;
		B = random.nextInt(250)+1;
	}
	
	public void update() 
	{
		x -= speed;
	}
	
	public void render(Graphics g)
	{
		g.setColor(new Color(R, G, B));
		g.fillRect(x, y, width, height);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void setHasAdd()
	{
		this.hasAdd = true;
	}
	
	public boolean getHasAdd()
	{
		return hasAdd;
	}
	public int getWidth()
	{
		return width;
	}
	public int getHeight()
	{
		return height;
	}
	public static void setSpeed(int newSpeed)
	{
		speed = newSpeed;
	}
	public int getSpeed()
	{
		return speed;
	}
}
