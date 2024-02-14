import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    HashMap<Vehicle, BufferedImage> carImages = new HashMap<>();
    HashMap<Vehicle, Point> imagePoints = new HashMap<>();
    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point();

    void moveit(Vehicle v, int x, int y){
        imagePoints.get(v).x = x;
        imagePoints.get(v).y = y;

        repaint();
    }

    // Initializes the panel and reads the images
    public void addVehicle(Vehicle v){
        imagePoints.put(v, v.getPosition());

        try {
            if(v.getModelName().equals("Volvo240")){
                carImages.put(v, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
            } else if (v.getModelName().equals("Saab95")) {
                carImages.put(v, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));
            } else if (v.getModelName().equals("Scania")){
                carImages.put(v, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));
            }
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
    public void addWorkshop(RepairShop<Volvo240> w){
        volvoWorkshopPoint = w.getPosition();
        try {
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);


        // Print an error message in case file is not found with a try/catch block
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Vehicle v : carImages.keySet()){
            g.drawImage(carImages.get(v), imagePoints.get(v).x, imagePoints.get(v).y, null);
        }
         // see javadoc for more info on the parameters
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
    }
}