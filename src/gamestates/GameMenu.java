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

public class GameMenu extends State implements Statemethods {
	private BufferedImage playButton,playButtonPressed, helpButton, helpButtonPressed, drawButton, drawButtonPressed, audio, audioPressed;
	private boolean play = false;
	private boolean help = false;
	private boolean draw = false;

	public GameMenu(Game game) {
		super(game);
		getImage();
	}

	@Override
	public void update() {
		game.repaint();
	}

	@Override
	public void render(Graphics g) {
		
		if (play != true)g.drawImage(playButton, 375, 125, null);
		else g.drawImage(playButtonPressed, 375, 125, null);
		
		if (help != true)g.drawImage(helpButton, 375, 275, null);
		else g.drawImage(helpButtonPressed, 375, 275, null);
		
		if (draw != true)g.drawImage(drawButton, 375, 425, null);
		else g.drawImage(drawButtonPressed, 375, 425, null);
		
		if (game.getAudioOff() != true)g.drawImage(audio, 800, 30, 50, 50, null);
		else g.drawImage(audioPressed, 800, 30, 50, 50, null);
	
		Dimension d = game.getPanelSize();
		Font font1 = new Font("Imprint MT Shadow", Font.BOLD, 50);
		g.setFont(font1);
		g.setColor(Color.white);
		drawCenteredString("RISING ROCKET", d.width, 75, g);
		
	}
	
	private void getImage() {
		InputStream is1 = getClass().getResourceAsStream("/Play Button.png");
		InputStream is2 = getClass().getResourceAsStream("/PlayButtonPressed.png");
		InputStream is3 = getClass().getResourceAsStream("/Help-Button.png");
		InputStream is4 = getClass().getResourceAsStream("/Help-Button-Pressed.png");
		InputStream is5 = getClass().getResourceAsStream("/Draw-Button.png");
		InputStream is6 = getClass().getResourceAsStream("/Draw-Button-Pressed.png");
		InputStream is7 = getClass().getResourceAsStream("/audio-on.png");
		InputStream is8 = getClass().getResourceAsStream("/audio-off.png");
		
		try {
			playButton = ImageIO.read(is1);
			playButtonPressed = ImageIO.read(is2);
			helpButton = ImageIO.read(is3);
			helpButtonPressed = ImageIO.read(is4);
			drawButton = ImageIO.read(is5);
			drawButtonPressed = ImageIO.read(is6);
			audio = ImageIO.read(is7);
			audioPressed = ImageIO.read(is8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void drawCenteredString(String s, int w, int y, Graphics g) 
	{
		FontMetrics fm2 = g.getFontMetrics();
		int x = (w - fm2.stringWidth(s)) / 2;
		g.setColor(Color.white);
		g.drawString(s, x, y);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getX() >=375 && e.getX() <= 625 && e.getY() >=150 && e.getY() <= 250)
		{
			Gamestate.state = Gamestate.PLAYING;
			play = false;
			game.stopMusic();
			game.runGameTimer();
		}
		
		if(e.getX() >=375 && e.getX() <= 625 && e.getY() >=275 && e.getY() <= 375)
		{
			help = false;
			Gamestate.state = Gamestate.HELPMENU;
		}
		
		if(e.getX() >=375 && e.getX() <= 625 && e.getY() >=425 && e.getY() <= 525)
		{
			draw = false;
			Gamestate.state = Gamestate.DRAWING;
		}
		
		if(e.getX() >=800 && e.getX() <= 850 && e.getY() >=30 && e.getY() <= 80 && game.getAudioOff() != true)
		{
			game.setAudioOff();
			game.stopMusic();
		}
		
		else if(e.getX() >=800 && e.getX() <= 850 && e.getY() >=30 && e.getY() <= 80 && game.getAudioOff() == true)
		{
			game.setAudioOn();
			game.startMusic(0);;
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if(e.getX() >=375 && e.getX() <= 625 && e.getY() >=125 && e.getY() <= 225)
		{
			if (play == false && game.getAudioOff() != true)game.startSE(3);
			play = true;
		}
		else {
			play = false;
		}
		
		if(e.getX() >=375 && e.getX() <= 625 && e.getY() >=275 && e.getY() <= 375)
		{
			if (help == false && game.getAudioOff() != true)game.startSE(3);
			help = true;
		}
		else help = false;
		
		if(e.getX() >=375 && e.getX() <= 625 && e.getY() >=425 && e.getY() <= 525)
		{
			if (draw == false && game.getAudioOff() != true)game.startSE(3);
			draw = true;
		}
		else draw = false;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
