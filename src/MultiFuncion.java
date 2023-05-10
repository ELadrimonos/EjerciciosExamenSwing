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

    private int tamany;
    private String nombreFuente;


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
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    rgb = new VentanaRGB();

    // Dejamos los valores que están por defecto en la fuente referenciados aquí
    tamany = 10;
    nombreFuente = "Purisa";

    // Agregamos el objeto MultiFuncion como ActionListener
    rgb.getEnviarButton().addActionListener(this);


     ActionListener cambioColorListener = actionEvent -> {
       AbstractButton botonActual = (AbstractButton) actionEvent.getSource();
       Lamina12.setBackground(mapaColores.get(botonActual.getText()));
       testLabel.setForeground(mapaColores.get(botonActual.getText()));
     };

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

     serifRadioButton.addActionListener(cambioFuente);
     comicSansRadioButton.addActionListener(cambioFuente);
     purisaRadioButton.addActionListener(cambioFuente);
     broadwayRadioButton.addActionListener(cambioFuente);

     a5RadioButton.addActionListener(cambioFuente);
     a10RadioButton.addActionListener(cambioFuente);
     a15RadioButton.addActionListener(cambioFuente);
     a20RadioButton.addActionListener(cambioFuente);
     a30RadioButton.addActionListener(cambioFuente);
     a50RadioButton.addActionListener(cambioFuente);

     personalizarButton.addActionListener(actionEvent -> rgb.setVisible(true));
    }



    public static void main(String[] args) {
        MultiFuncion ventana = new MultiFuncion();
    }

    // Nuestra clase implementa la interfaz de ActionListener, por lo que podemos hacer que cuando otra clase use esta
    // clase como ActionListener haga este bloque de código
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Lamina12.setBackground(rgb.colorActual);
        testLabel.setForeground(rgb.colorActual);
        rgb.setVisible(false);
    }
}
