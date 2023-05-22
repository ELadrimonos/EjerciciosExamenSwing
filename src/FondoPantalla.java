import javax.swing.*;
import java.awt.*;

public class FondoPantalla extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        // La ruta relativa de las imagenes empiaza por la raiz del proyecto
        Image fondo = new ImageIcon("./src/pinguino.jpg").getImage();
        setOpaque(true);
        g2d.drawImage(fondo, 0, 0, 1024, 500,this);
        g2d.drawString("Hola", 2, 34);
    }
}
