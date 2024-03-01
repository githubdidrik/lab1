import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{
    private HashMap<BufferedImage, Point> imagePointHashMap = new HashMap<>();
    void moveit(BufferedImage image, Point p){
        imagePointHashMap.get(image).x = p.x;
        imagePointHashMap.get(image).y = p.y;
        repaint();
    }
    public void addImage(BufferedImage image, Point p){
        imagePointHashMap.put(image, p);
    }
    public void removeImage(BufferedImage image){
        imagePointHashMap.remove(image);
    }
    public DrawPanel(int x, int y){
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(BufferedImage image : imagePointHashMap.keySet()){
            g.drawImage(image, imagePointHashMap.get(image).x, imagePointHashMap.get(image).y , null);
        }
    }

}