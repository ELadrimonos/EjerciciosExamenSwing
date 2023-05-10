import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class MultiFuncion extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JPanel Lamina11;
    private JPanel Lamina12;
    private JPanel Lamina21;
    private JPanel Lamina22;
    private JRadioButton redButton;
    private JRadioButton blueButton;
    private JRadioButton yellowButton;
    private JRadioButton greenButton;
    private JRadioButton orangeButton;
    private JRadioButton brownButton;
    private JRadioButton comicSansRadioButton;
    private JRadioButton serifRadioButton;
    private JRadioButton purisaRadioButton;
    private JRadioButton broadwayRadioButton;
    private JRadioButton a5RadioButton;
    private JRadioButton a10RadioButton;
    private JRadioButton a15RadioButton;
    private JRadioButton a20RadioButton;
    private JRadioButton a30RadioButton;
    private JRadioButton a50RadioButton;
    private JLabel testLabel;
    private JButton personalizarButton;
    private ButtonGroup tamanys;

    // Aquí están los botones de color agrupados en el fichero form, para que solo podamos seleccionar uno al mismo tiempo
    private ButtonGroup colores;

    // Lo he hecho final porque no voy a volver a inicializarlo y se va a quedar tal y como está
    private final VentanaRGB rgb;
    // Aquí tenemos el tamaño de la fuente y el nombre
    private int tamany;
    private String nombreFuente;

    // Con este HashMap asociamos un String con un Color
    static HashMap<String, Color> mapaColores = new HashMap<>(){{
        put("Azul", Color.BLUE);
        put("Rojo", Color.RED);
        put("Amarillo", Color.YELLOW);
        put("Verde", Color.GREEN);
        put("Naranja", new Color(255, 136, 0));
        put("Marrón", new Color(139,69,19));
    }};

    public MultiFuncion() {
    setSize(600, 600);
    setContentPane(mainPanel);
    setVisible(true);
    setResizable(false);
    setTitle("Multi Función");
    // Cuando cerremos esta ventana queremos que el programa acabe
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // Instanciamos la ventana RGB
    rgb = new VentanaRGB();

    // Dejamos los valores que están por defecto dde la fuente en el form
    tamany = 10;
    nombreFuente = "Purisa";

    // Agregamos el objeto MultiFuncion (este) como ActionListener al botón enviar de la ventana RGB
    rgb.getEnviarButton().addActionListener(this);

    // Cambia los colores del panel y de la etiqueta test
     ActionListener cambioColorListener = actionEvent -> {
       AbstractButton botonActual = (AbstractButton) actionEvent.getSource();
       Lamina12.setBackground(mapaColores.get(botonActual.getText()));
       testLabel.setForeground(mapaColores.get(botonActual.getText()));
     };

     /* Cambia el tipo de fuente y su tamaño dependiendo de si el botón que se acaba de pulsar entre los que estén
     asociados a este listener sea un dígito o no
     */
     ActionListener cambioFuente = actionEvent -> {
       AbstractButton botonActual = (AbstractButton) actionEvent.getSource();
        // Vemos si la opción que acabamos de elegir es un número lo asignamos al tamaño, si no será el nombre de la fuente
       try{
           tamany = Integer.parseInt(botonActual.getText());
       } catch (NumberFormatException nfe){
            nombreFuente = botonActual.getText();
       }
       // Aquí cambiamos la fuente de la etiqueta test con los valores guardados en las variables de la clase
       testLabel.setFont(new Font(nombreFuente, Font.PLAIN, tamany));
     };


     // Agrego los Action listeners para que hagan algo cuando sea clickado
     blueButton.addActionListener(cambioColorListener);
     redButton.addActionListener(cambioColorListener);
     yellowButton.addActionListener(cambioColorListener);
     greenButton.addActionListener(cambioColorListener);
     orangeButton.addActionListener(cambioColorListener);
     brownButton.addActionListener(cambioColorListener);

     // A los botones de tipo de fuente agregamos el evento de cambio fuente
     serifRadioButton.addActionListener(cambioFuente);
     comicSansRadioButton.addActionListener(cambioFuente);
     purisaRadioButton.addActionListener(cambioFuente);
     broadwayRadioButton.addActionListener(cambioFuente);

     // A los botones de tamaño de fuente agregamos el evento de cambio fuente
     a5RadioButton.addActionListener(cambioFuente);
     a10RadioButton.addActionListener(cambioFuente);
     a15RadioButton.addActionListener(cambioFuente);
     a20RadioButton.addActionListener(cambioFuente);
     a30RadioButton.addActionListener(cambioFuente);
     a50RadioButton.addActionListener(cambioFuente);

     /* Cuando le demos al botón de personalizar color solo haremos que la ventana RGB sea visible, podriamos instanciar
      una nueva ventana y hacerla visible aquí para que se reinicien los valores
      */
     personalizarButton.addActionListener(actionEvent -> rgb.setVisible(true));
    }



    public static void main(String[] args) {
        MultiFuncion ventana = new MultiFuncion();
    }

    // Nuestra clase implementa la interfaz de ActionListener, por lo que podemos hacer que cuando otra clase use esta
    // clase como ActionListener haga este bloque de código en esta clase
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Lamina12.setBackground(rgb.colorActual);
        testLabel.setForeground(rgb.colorActual);
        rgb.setVisible(false);
    }
}
