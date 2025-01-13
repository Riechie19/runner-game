package gamestates;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import main.Game;

public class HelpMenu extends State implements Statemethods{
	private BufferedImage helpScreen;

	public HelpMenu(Game game) {
		super(game);
		getImage();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		game.repaint();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(helpScreen,125, 35, 750, 500, null);
		
		Dimension d = game.getPanelSize();
		Font font1 = new Font("Times New Roman", Font.BOLD, 15);
		g.setFont(font1);
		g.setColor(Color.white);
		drawCenteredString("Click \"PLAY\" to start playing the game.", d.width, 200, g);
		drawCenteredString("Press \"SPACE\" or \"UP ARROW\" to jump in order to avoid the obstacles, ", d.width, 230, g);
		drawCenteredString("you can also press \"DOWN ARROW\" to fall immediately. The rocket will crash when", d.width, 260, g);
		drawCenteredString("hit by an obstacle, press \"SPACE\" or \"UP ARROW\" to play again.", d.width, 290, g);
		drawCenteredString("Click \"DRAW\" to draw anything you wanted in the background with the", d.width, 350, g);
		drawCenteredString("available colours. Press \"C\" to reset the entire canvas.", d.width, 380, g);
		drawCenteredString("Press \"ESC\" to exit.", d.width, 440, g);
		
	}
	
	public void drawCenteredString(String s, int w, int y, Graphics g) 
	{
		FontMetrics fm2 = g.getFontMetrics();
		int x = (w - fm2.stringWidth(s)) / 2;
		g.setColor(Color.white);
		g.drawString(s, x, y);
	}
	
	private void getImage() {
		InputStream is = getClass().getResourceAsStream("/How_To_Play.png");
		
		try {
			helpScreen = ImageIO.read(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_ESCAPE:
		{
			Gamestate.state = Gamestate.GAMEMENU;
			break;
		}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
