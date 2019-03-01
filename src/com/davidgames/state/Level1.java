package com.davidgames.state;

import com.davidgames.entity.Player;
import com.davidgames.main.LevelPanel;
import com.davidgames.tilemap.TileMapManager;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class Level1  extends LevelState
{

    private Player p;
    private boolean win;
    
    private Enemy[] enemies;
    
    private Collectable[] collectables;
    
    public Level1(LevelManager lm)
    {
        super(lm);
        p = new Player("/Images/player.png");
        
        win = false;
        init();
        initEnemies();
        initCollectables();
    }
    
    private void init()
    {
        
    }
    private void initEnemies()
    {
        enemies = new Enemy[5];
        
        for(int i = 0; i < enemies.length; i++)
        {
            enemies[i] = new Enemy("/Images/enemy.png");
        }
    }
    @Override
    public void keyPressed(int keyCode) 
    {
        if(keyCode == KeyEvent.VK_A)
            p.moveLeft(true);
        if(keyCode == KeyEvent.VK_D)
            p.moveRight(true);
    }

    @Override
    public void keyReleased(int keyCode) 
    {
         if(keyCode == KeyEvent.VK_A)
           p.moveLeft(false);
            if(keyCode == KeyEvent.VK_D)
            p.moveRight(false);
    }

    @Override
    public void update() 
    {
        p.update();
        p.checkCollectableCollision(collectables);
        p.checkEnemyCollision(enemies);
    }

    @Override
    public void draw(Graphics2D g) 
    {
        //Level drawing
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, LevelPanel.PANEL_WIDTH, LevelPanel.PANEL_HEIGHT);
        // player drawing
        p.draw(g);
    }   //enemy drawing
    
}
