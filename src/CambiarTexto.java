import javax.swing.*;
import java.awt.*;

public class CambiarTexto extends JFrame {
    private JPanel mainPanel;
    private JTextField campoTexto;
    private JButton boton;

    CambiarTexto() {
        setContentPane(mainPanel);
        setVisible(true);
        setSize(200, 80);
        setTitle("Cambiar texto");
        setLocation(300, 100);
    }

    public JButton getBoton() {
        return boton;
    }

    public String getTexto() {
        return this.campoTexto.getText();
    }

}
