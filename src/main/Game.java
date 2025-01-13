package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.net.URL;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import gamestates.Drawing;
import gamestates.GameMenu;
import gamestates.Gamestate;
import gamestates.HelpMenu;
import gamestates.Playing;

public class Game implements Runnable {
	GamePanel gamePanel;
	GameFrame gameFrame;
	private Playing playing;
	private Clip mClip;
	private Clip clip;
	URL file[] = new URL[10];
	private GameMenu gameMenu;
	private Drawing drawing;
	private HelpMenu helpMenu;
	private boolean running;
	private Thread gameThread;
	private int bestScore = 0;
	private ArrayList<Integer> xDraw = new ArrayList<Integer>();
	private ArrayList<Integer> yDraw = new ArrayList<Integer>();
	private ArrayList<Color> colors = new ArrayList<Color>();
	private boolean audioOff = false;
	Game()
	{
		gamePanel = new GamePanel(this);
		gameFrame = new GameFrame(gamePanel);
		gamePanel.requestFocus();
		music();
		init();
	}
	
	public void init()
	{
		playing = new Playing (this);
		gameMenu = new GameMenu(this);
		drawing = new Drawing(this);
		helpMenu = new HelpMenu(this);
		if(audioOff != true)startMusic(0);
		startGameLoop();
	}
	
	public void update()
	{
		
		switch(Gamestate.state)
		{
		case GAMEMENU:
			gameMenu.update();
			break;
		case PLAYING:
			playing.update();
			break;
		case HELPMENU:
			helpMenu.update();
			break;
		case DRAWING:
			drawing.update();
			break;
		default:
			break;
		
		}
	}

	public void render(Graphics g)
	{   
		switch(Gamestate.state)
		{
		case GAMEMENU:
			gameMenu.render(g);
			break;
		case PLAYING:
			playing.render(g);
			break;
		case HELPMENU:
			helpMenu.render(g);
			break;
		case DRAWING:
			drawing.render(g);
			break;
		default:
			break;
		
		}
	}
	
	public void startGameLoop()
	{
		running = true;
		gameThread = new Thread (this);
		gameThread.start();
	}
	
	public void stop() {
		running = false;
	}
	
	@Override
	public void run() {
		while (running) {
            update();
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}
	
	public boolean gameOver()
	{
		if (running)
			return false;
		else return true;
	}
	
	public int getBestScore()
	{
		return bestScore;
	}
	public void setBestScore(int newBestScore)
	{
		bestScore = newBestScore;
	}
	public void	setXDraw(int newX)
	{
		xDraw.add(newX);
	}
	public ArrayList<Integer> getXDraw()
	{
		return xDraw;
	}
	public void	setYDraw(int newY)
	{
		yDraw.add(newY);
	}
	public ArrayList<Integer> getYDraw()
	{
		return yDraw;
	}
	public void clearXAndY ()
	{
		xDraw.removeAll(xDraw);
		yDraw.removeAll(yDraw);
		colors.removeAll(colors);
	}
	public void setColor(Color color)
	{
		colors.add(color);
	}
	public ArrayList<Color> getColors()
	{
		return colors;
	}
	public void runGameTimer()
	{
		gamePanel.runTimer();
	}
	public void stopGameTimer()
	{
		gamePanel.stopTimer();
	}
	public void repaint()
	{
		gamePanel.repaint();
	}
	public int getGameTimeIndex()
	{
		return gamePanel.getTimeIndex();
	}
	public Playing getPlaying()
	{
		return playing;
	}
	public GameMenu getGameMenu()
	{
		return gameMenu;
	}
	public Drawing getDrawing()
	{
		return drawing;
	}
	public HelpMenu getHelpMenu()
	{
		return helpMenu;
	}
	public Dimension getPanelSize()
	{
		return gamePanel.getSize();
	}
	public void music()
	{
		file[0] = getClass().getResource("/Cavemen of the Future.wav");
		file[1] = getClass().getResource("/jump-sound.wav");
		file[2] = getClass().getResource("/electronic-impact-hard.wav");
		file[3] = getClass().getResource("/click.wav");
		
	}
	public void startMusic(int i)
	{
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(file[i]);
			mClip = AudioSystem.getClip();
			mClip.open(audioStream);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		mClip.start();
		mClip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	public void startSE(int i)
	{
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(file[i]);
			clip = AudioSystem.getClip();
			clip.open(audioStream);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		clip.start();
		
	}
	public void stopMusic()
	{
		mClip.stop();
	}
	public void stopSE()
	{
		clip.stop();
	}
	
	public void setAudioOff()
	{
		audioOff = true;
	}
	public void setAudioOn()
	{
		audioOff = false;
	}
	
	public boolean getAudioOff()
	{
		return audioOff;
	}
	
}
