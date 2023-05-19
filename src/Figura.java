import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Figura extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        Rectangle2D rectangulo = new Rectangle2D.Double(200, 200, 300, 200);
        g2d.setPaint(Color.GREEN);
        g2d.fill(rectangulo);
        // TODO Método que cambie el tamaño del rectangulo basándonos en el tamaño de la ventana
    }

}
