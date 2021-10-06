//Elizabeth Sims
//September 22, 2021
//Assignment 3

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import javax.swing.JButton;
import java.awt.Color;


class View extends JPanel
{
   Model model;


   View(Controller c, Model m)
   {
       c.setView(this);
       model = m;
   }
  
   void removeButton()
   {
       this.repaint();
	   revalidate();
      
   }
  
   public void paintComponent(Graphics g)
   {
       g.setColor(new Color(128, 255, 255));
       g.fillRect(0, 0, this.getWidth(), this.getHeight());

	   g.setColor(Color.RED);
	   for(int i = 0; i < model.bricks.size(); i++)
	   {
		   Brick b = model.bricks.get(i);
		   g.fillRect(b.x - model.cameraPos, b.y, b.w, b.h);
	   }
   }
}
