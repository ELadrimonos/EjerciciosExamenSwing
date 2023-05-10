import javax.swing.*;
import java.awt.*;
// Importo estáticamente el método showMessageDialog
import static javax.swing.JOptionPane.showMessageDialog;


public class TemperaturaReactor extends JFrame {
    private JSlider sliderTemp;
    private JTextField textField1;
    private JPanel mainPanel;
    private JLabel estado;

    public TemperaturaReactor(){
        this.setContentPane(mainPanel);
        this.setSize(600,300);
        this.setTitle("Temperatura Reactor");
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        cambiarEstado();

        // Así es como tocariamos los valores del slider desde código
        /*
        this.sliderTemp.setMinimum(0);
        this.sliderTemp.setMaximum(3000);
        this.sliderTemp.setValue(1500);
        */
        // El change listener se ejecuta cada vez que el valor del slider es cambiado
        sliderTemp.addChangeListener(changeEvent -> {
            textField1.setText(String.valueOf(sliderTemp.getValue()));
            cambiarEstado();
        });
        // Cuando pulsamos Enter mientras tenemos el textField seleccionado ejecutará este bloque
        textField1.addActionListener(actionEvent -> {
            // Asigna el valor del slider a lo que devuelva el método valorValido
            sliderTemp.setValue(valorValido(textField1.getText()));
            cambiarEstado();
        });
    }

    public static void main(String[] args) {
        JFrame ventana = new TemperaturaReactor();
    }

    int valorValido(String valor){
        int numero;
        try{
            // Si el valor introducido es un dígito pasará a las condiciones if
            numero = Integer.parseInt(valor);
        } catch (NumberFormatException nfe){
            // Si tiene un caracter no válido saltará un diálogo con un mensaje y devolverá el valor que había previamente
            showMessageDialog(null, "Error: No es un digito\n" + nfe);
            return this.sliderTemp.getValue();
        }
        if (numero >= 0 && numero <= 3000){
            // Si el número está entre 0 y 3000 devolverá el valor pasado
            return numero;
        } else {
            // Si es inferior o superior al rango, devolverá el valor antiguo
            showMessageDialog(null, "Error: El valor no está entre 0 y 3000");
            return this.sliderTemp.getValue();
        }
    }

    void cambiarEstado(){
        // Asignamos a valor el valor del slider
        int valor = sliderTemp.getValue();
        if (valor >= 0 && valor <= 1000){
            // Si el valor está entre 0 y 1000 el texto dirá estable y será de color verde
            estado.setText("ESTABLE");
            estado.setForeground(Color.GREEN);
        } else if (valor > 1000 && valor <= 1500){
            // Si está entre 1001 y 1500 dirá precaución y en color amarillo
            estado.setText("PRECAUCIÓN");
            estado.setForeground(Color.YELLOW);
        } else {
            // Si no está en ningún rango previo, riesgo de fusión en rojo
            estado.setText("RIESGO DE FUSIÓN");
            estado.setForeground(Color.RED);
        }
    }

}
