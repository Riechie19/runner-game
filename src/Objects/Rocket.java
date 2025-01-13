package Objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Rocket {
	private int x, y, width, height, yVel;
	private static final int GRAVITY = 1;
	public final static int GROUND = 400;
	public boolean hasJump = true;
	private BufferedImage img1, img2;
	
	public Rocket(int x)
	{
		getImage();
		this.x = x;
		this.y = GROUND - 128;
		this.width = 64;
		this.height = 64;
		this.yVel = 0;
	}
	
	private void getImage() {
		InputStream is1 = getClass().getResourceAsStream("/roket sprite-1.png");
		InputStream is2 = getClass().getResourceAsStream("/roket sprite-2.png");
		
		try {
			img1 = ImageIO.read(is1);
			img2 = ImageIO.read(is2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void update ()
	{
		yVel += GRAVITY;
		y += yVel;
		if (y > GROUND - height)
		{
			y = GROUND - height;
			yVel = 0;
		}
	}
	
	public void render(Graphics g)
	{
		if (y != GROUND - height && yVel <= 0)
			g.drawImage(img2.getSubimage(256, 128, 512, 704), x, y, width,88,null);
		else
			g.drawImage(img1.getSubimage(256, 128, 512, 512), x, y, width,height,null);
	}
	
	public void jump()
	{
		yVel = -20;
	}
	
	public void down()
	{
		yVel = 20;
	}

	public boolean intersects(Obstacle obstacle) {
		Rectangle boxRect = new Rectangle(x, y, width, height);
        Rectangle obstacleRect = new Rectangle(obstacle.getX(), obstacle.getY(), obstacle.getWidth(), obstacle.getHeight());
        return boxRect.intersects(obstacleRect);
	}
	
	public boolean isGrounded()
	{
		if (y == GROUND - height) return true;
		else return false;
	}
}
