package com.davidgames.main;
import javax.swing.JFrame;

public class Game {
    public static final int WINDOW_HEIGHT = 800;
    public static final int WINDOW_WIDTH = 384;
    
    private static final String TITLE = "new and improved game";
    
    private JFrame mainWindow;
    private LevelPanel lp;
    
    public Game()
    {
        initGame();
        initComponents();
        initWindow();
        
        lp.startGame();
        
    }
    
    private void initGame()
    {
        lp = new LevelPanel ();
        mainWindow = new JFrame();
        
    }
    
    private void initComponents()
    {
        mainWindow.add(lp);
        
    }
    private void initWindow()
    {
        mainWindow.setTitle(Game.TITLE);
        mainWindow.setSize(Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setVisible(true);
    }
    public static void main(String[] args) {
        Game g = new Game();
    }
    
    
    
    
}
