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
        // Cuando inicialicemos una ventana RGB ocurrirá lo siguiente:

        /* Añadimos al contenido de la ventana el panel principal que hemos hecho en el diseñador,
        lo que hayamos hecho será agregado al panel automaticamente gracias al .form
         */
        this.setContentPane(mainPanel);
        // Queremos que tenga un tamaño fijo
        this.setSize(500,200);
        this.setResizable(false);
        // Cuando instanciemos un objeto no queremos que sea visible
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

    // Solo sirve para referenciar el botón de enviar desde MultiFuncion
    public JButton getEnviarButton(){return enviarButton;}
}

