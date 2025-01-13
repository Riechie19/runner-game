package gamestates;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import main.Game;

public class Drawing extends State implements Statemethods {
	private static final int SCOLOR = 35;
	private Color color;
	private boolean blue = false;
	private boolean red = false;
	private boolean green = false;
	private boolean orange = false;
	private boolean pink = false;
	private boolean white =false;
	private boolean yellow = false;
	private boolean magenta = false;
	
	
	public Drawing(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		game.repaint();
	}

	@Override
	public void render(Graphics g) {
		for(int i=0; i < game.getXDraw().size();i++)
		{
			g.setColor(game.getColors().get(i));
			g.fillOval(game.getXDraw().get(i), game.getYDraw().get(i), 8, 8);
		}
		
		if (blue == true)
		{
			g.setColor(Color.WHITE);
			g.fillOval(850-2, 100-2, SCOLOR+4,SCOLOR+4);
			g.setColor(Color.blue);
			g.fillOval(850, 100, SCOLOR,SCOLOR);
		}
		else if (blue != true)
		{
			g.setColor(Color.blue);
			g.fillOval(850, 100, SCOLOR,SCOLOR);
		}
		
		if (red == true)
		{
			g.setColor(Color.WHITE);
			g.fillOval(910-2, 100-2, SCOLOR+4,SCOLOR+4);
			g.setColor(Color.RED);
			g.fillOval(910, 100, SCOLOR,SCOLOR);
		}
		else if (red != true)
		{
			g.setColor(Color.RED);
			g.fillOval(910, 100, SCOLOR,SCOLOR);
		}
		
		if (green == true)
		{
			g.setColor(Color.WHITE);
			g.fillOval(850-2, 160-2, SCOLOR+4,SCOLOR+4);
			g.setColor(Color.GREEN);
			g.fillOval(850, 160, SCOLOR,SCOLOR);
		}
		else if (green != true)
		{
			g.setColor(Color.GREEN);
			g.fillOval(850, 160, SCOLOR,SCOLOR);
		}
		
		if (orange == true)
		{
			g.setColor(Color.WHITE);
			g.fillOval(910-2, 160-2, SCOLOR+4,SCOLOR+4);
			g.setColor(Color.ORANGE);
			g.fillOval(910, 160, SCOLOR,SCOLOR);
		}
		else if (orange != true)
		{
			g.setColor(Color.ORANGE);
			g.fillOval(910, 160, SCOLOR,SCOLOR);
		}
		
		if (pink == true)
		{
			g.setColor(Color.WHITE);
			g.fillOval(850-2, 220-2, SCOLOR+4,SCOLOR+4);
			g.setColor(Color.PINK);
			g.fillOval(850, 220, SCOLOR,SCOLOR);
		}
		else if (pink != true)
		{
			g.setColor(Color.PINK);
			g.fillOval(850, 220, SCOLOR,SCOLOR);
		}
		
		if (white == true)
		{
			g.setColor(Color.WHITE);
			g.fillOval(910-2, 220-2, SCOLOR+4,SCOLOR+4);
			g.setColor(Color.WHITE);
			g.fillOval(910, 220, SCOLOR,SCOLOR);
		}
		else if (white != true)
		{
			g.setColor(Color.WHITE);
			g.fillOval(910, 220, SCOLOR,SCOLOR);
		}
		
		if (yellow == true)
		{
			g.setColor(Color.WHITE);
			g.fillOval(850-2, 280-2, SCOLOR+4,SCOLOR+4);
			g.setColor(Color.YELLOW);
			g.fillOval(850, 280, SCOLOR,SCOLOR);
		}
		else if (yellow != true)
		{
			g.setColor(Color.YELLOW);
			g.fillOval(850, 280, SCOLOR,SCOLOR);
		}
		
		if (magenta == true)
		{
			g.setColor(Color.WHITE);
			g.fillOval(910-2, 280-2, SCOLOR+4,SCOLOR+4);
			g.setColor(Color.MAGENTA);
			g.fillOval(910, 280, SCOLOR,SCOLOR);
		}
		else if (magenta != true)
		{
			g.setColor(Color.MAGENTA);
			g.fillOval(910, 280, SCOLOR,SCOLOR);
		}
		
		g.setColor(new Color(100, 233, 150));
		g.fillRect(0, 400, 1000, 200);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getX() >=850 && e.getX() <= 850+SCOLOR && e.getY() >=100 && e.getY() <= 100 + SCOLOR)
		{
			color = Color.blue;
			blue = true;
			red = false;
			green = false;
			orange = false;
			pink = false;
			white = false;
			yellow = false;
			magenta = false;
		}
		
		else if(e.getX() >=910 && e.getX() <= 910+SCOLOR && e.getY() >=100 && e.getY() <= 100 + SCOLOR)
		{
			color = Color.RED;
			blue = false;
			red = true;
			green = false;
			orange = false;
			pink = false;
			white = false;
			yellow = false;
			magenta = false;
		}
		
		else if(e.getX() >=850 && e.getX() <= 850+SCOLOR && e.getY() >=160 && e.getY() <= 160 + SCOLOR)
		{
			color = Color.GREEN;
			blue = false;
			red = false;
			green = true;
			orange = false;
			pink = false;
			white = false;
			yellow = false;
			magenta = false;
		}
		
		else if(e.getX() >=910 && e.getX() <= 910+SCOLOR && e.getY() >=160 && e.getY() <= 160 + SCOLOR)
		{
			color = Color.ORANGE;
			blue = false;
			red = false;
			green = false;
			orange = true;
			pink = false;
			white = false;
			yellow = false;
			magenta = false;
		}
		
		else if(e.getX() >=850 && e.getX() <= 850+SCOLOR && e.getY() >=220 && e.getY() <= 220 + SCOLOR)
		{
			color = Color.PINK;
			blue = false;
			red = false;
			green = false;
			orange = false;
			pink = true;
			white = false;
			yellow = false;
			magenta = false;
		}
		
		else if(e.getX() >=910 && e.getX() <= 910+SCOLOR && e.getY() >=220 && e.getY() <= 220 + SCOLOR)
		{
			color = Color.WHITE;
			blue = false;
			red = false;
			green = false;
			orange = false;
			pink = false;
			white = true;
			yellow = false;
			magenta = false;
		}
		
		else if(e.getX() >=850 && e.getX() <= 850+SCOLOR && e.getY() >=280 && e.getY() <= 280 + SCOLOR)
		{
			color = Color.YELLOW;
			blue = false;
			red = false;
			green = false;
			orange = false;
			pink = false;
			white = false;
			yellow = true;
			magenta = false;
		}
		
		else if(e.getX() >=910 && e.getX() <= 910+SCOLOR && e.getY() >=280 && e.getY() <= 280 + SCOLOR)
		{
			color = Color.MAGENTA;
			blue = false;
			red = false;
			green = false;
			orange = false;
			pink = false;
			white = false;
			yellow = false;
			magenta = true;
		}
		
		else
		{
			game.setXDraw(e.getX());
			game.setYDraw(e.getY());
			game.setColor(color);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		game.setXDraw(e.getX());
		game.setYDraw(e.getY());
		game.setColor(color);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_C:
			game.clearXAndY();
			break;
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
