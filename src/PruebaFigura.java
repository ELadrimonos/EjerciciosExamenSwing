import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.Locale;


public class PruebaFigura extends JFrame {
    private JPanel mainPanel;
    private FondoPantalla fondo;
    private Figura rectangulo;

    PruebaFigura() {
        setContentPane(mainPanel);
        setVisible(true);
        setSize(1000, 900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        PruebaFigura hola = new PruebaFigura();
    }

    private void createUIComponents() {
        mainPanel = new JPanel();
        fondo = new FondoPantalla();
        rectangulo = new Figura();
    }

}
