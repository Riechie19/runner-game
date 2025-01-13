package Input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import gamestates.Gamestate;
import main.GamePanel;

public class MouseInput implements MouseListener ,MouseMotionListener{
	private GamePanel gamePanel;
	public MouseInput (GamePanel gamePanel)
	{
		this.gamePanel = gamePanel;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		switch(Gamestate.state)
		{
		case GAMEMENU:
			gamePanel.getGame().getGameMenu().mouseDragged(e);
			break;
		case PLAYING:
			gamePanel.getGame().getPlaying().mouseDragged(e);
			break;
		case DRAWING:
			gamePanel.getGame().getDrawing().mouseDragged(e);
			break;
		default:
			break;
		
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		switch(Gamestate.state)
		{
		case GAMEMENU:
			gamePanel.getGame().getGameMenu().mouseMoved(e);
			break;
		case PLAYING:
			gamePanel.getGame().getPlaying().mouseMoved(e);
			break;
		case DRAWING:
			gamePanel.getGame().getDrawing().mouseMoved(e);
			break;
		default:
			break;
		
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		switch(Gamestate.state)
		{
		case GAMEMENU:
			gamePanel.getGame().getGameMenu().mousePressed(e);
			break;
		case PLAYING:
			gamePanel.getGame().getPlaying().mousePressed(e);
			break;
		case DRAWING:
			gamePanel.getGame().getDrawing().mousePressed(e);
			break;
		default:
			break;
		
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
