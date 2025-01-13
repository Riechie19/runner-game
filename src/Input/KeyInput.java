package Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import gamestates.Gamestate;
import main.GamePanel;

public class KeyInput implements KeyListener{
	private GamePanel gamePanel;
	public KeyInput(GamePanel gamePanel)
	{
		this.gamePanel = gamePanel;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(Gamestate.state)
		{
		case GAMEMENU:
			gamePanel.getGame().getGameMenu().keyPressed(e);
			break;
		case PLAYING:
			gamePanel.getGame().getPlaying().keyPressed(e);
			break;
		case DRAWING:
			gamePanel.getGame().getDrawing().keyPressed(e);
			break;
		case HELPMENU:
			gamePanel.getGame().getHelpMenu().keyPressed(e);
		default:
			break;
		
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(Gamestate.state)
		{
		case GAMEMENU:
			break;
		case PLAYING:
			gamePanel.getGame().getPlaying().keyReleased(e);
			break;
		case DRAWING:
			gamePanel.getGame().getDrawing().keyReleased(e);
			break;
		case HELPMENU:
			gamePanel.getGame().getHelpMenu().keyReleased(e);
		default:
			break;
		
		}
	
	}
	
}
