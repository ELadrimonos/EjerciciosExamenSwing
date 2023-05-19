import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

// Como nuestra clase implementa distintos listener cuando se le agregue a un tipo de listener concreto de un objeto
// ejecutará el método asociado a ese tipo de evento
public class MultiEvento extends JFrame implements ActionListener, ChangeListener {
    private JPanel mainPanel;
    private JLabel Etiqueta;
    private final VentanaRGB rgb;
    private final CambiarTexto texto;

    MultiEvento() {
        this.setSize(200, 400);
        this.setContentPane(mainPanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Varios Eventos");
        this.setLocation(60, 100);

        // Reutilizamos la clase VentanaRGN aquí
        rgb = new VentanaRGB();
        this.mainPanel.setBackground(rgb.colorActual);
        rgb.setVisible(true);
        rgb.setDefaultCloseOperation(EXIT_ON_CLOSE);
        rgb.setLocation(500, 100);

        // Hacemos que los slider de rgb usen el método stateChanged de esta clase
        rgb.getRojo().addChangeListener(this);
        rgb.getVerde().addChangeListener(this);
        rgb.getAzul().addChangeListener(this);

        texto = new CambiarTexto();
        // Hacemos que el botón de la ventana CambiarTexto envíe el texto escrito a la etiqueta de esta ventana usando
        // el método actionPerformed
        texto.getBoton().addActionListener(this);
        texto.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        MultiEvento ventana = new MultiEvento();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Etiqueta.setText(texto.getTexto());
    }

    @Override
    public void stateChanged(ChangeEvent changeEvent) {
        mainPanel.setBackground(rgb.colorActual);
    }

}
