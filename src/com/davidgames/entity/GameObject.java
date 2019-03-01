package com.davidgames.entity;
import com.davidgames.tilemap.TileMapManager;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;



public class GameObject {
    
    //Co-ordinates
    protected double x;
    protected double y;
    
    //Sprite image
    protected BufferedImage sprite;
    
    protected TileMapManager tmm;
    
    //collision boxes
    protected int cWidth;
    protected int cHeight;
    
    protected boolean cTopLeft;
    protected boolean cBottomRight;
    protected boolean cTopRight;
    protected boolean cBottomLeft;
    
    public GameObject(String fileName, TileMapManager tmm)
    {
        this.tmm = tmm;
        loadSprite(fileName);
    }
    
    private void loadSprite(String fileName)
    {
        try
        {
            sprite = ImageIO.read(getClass().getResourceAsStream(fileName));
        }catch(IOException ex)
        {
            System.err.println("Error: unable to load Game Object sprite");
        }
        cWidth = sprite.getWidth();
        cHeight = sprite.getHeight();
    }
    public void update()
    {
        
    }
    public Rectangle getBounds()
    {
        return new Rectangle((int)x,(int)y, cWidth, cHeight);
    }
    public void draw(Graphics2D g)
    {
        g.drawImage(sprite, (int)x,(int)y,null);
    }
    public boolean intersects(GameObject obj)
    {
        Rectangle r1 = getBounds();
        Rectangle r2 = obj.getBounds();
        return r1.intersects(r2);
    }
            
            
            
            
}
