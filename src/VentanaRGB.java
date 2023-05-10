import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class VentanaRGB extends JFrame {
    private JSlider rojo;
    private JSlider verde;
    private JSlider azul;
    private JPanel mainPanel;
    private JButton enviarButton;
    private JPanel testColor;
    public Color colorActual;

    VentanaRGB() {
        this.setContentPane(mainPanel);
        this.setSize(500,200);
        this.setVisible(false);
        this.setTitle("Personalizar color");
        testColor.setBackground(new Color(rojo.getValue(), verde.getValue(), azul.getValue()));
        colorActual = testColor.getBackground();

        // Creamos un solo ChangeListener que podamos implementar en cada slider
        ChangeListener cambioValor = changeEvent -> {
            colorActual = new Color(rojo.getValue(), verde.getValue(), azul.getValue());
            testColor.setBackground(colorActual);
        };

        // Implementamos el ChangeListener creado en cada slider
        rojo.addChangeListener(cambioValor);
        verde.addChangeListener(cambioValor);
        azul.addChangeListener(cambioValor);
    }

    public JButton getEnviarButton(){return enviarButton;}
}

