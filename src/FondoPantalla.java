import javax.swing.*;
import java.awt.*;

public class FondoPantalla extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        Image fondo = new ImageIcon("./pinguino.jpg").getImage();
        setOpaque(true);
        g2d.drawImage(fondo, 0, 0, 1024, 500,this);
        g2d.drawString("Hola", 2, 34);
    }
}
