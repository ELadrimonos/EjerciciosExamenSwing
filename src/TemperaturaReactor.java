import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
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
        /*
        this.sliderTemp.setMinimum(0);
        this.sliderTemp.setMaximum(3000);
        this.sliderTemp.setValue(1500);
        */
        sliderTemp.addComponentListener(new ComponentAdapter() {
        });
        sliderTemp.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                textField1.setText(String.valueOf(sliderTemp.getValue()));
                cambiarEstado();
            }
        });

        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                sliderTemp.setValue(valorValido(textField1.getText()));
                cambiarEstado();
            }
        });
    }

    public static void main(String[] args) {
        JFrame ventana = new TemperaturaReactor();
    }

    int valorValido(String valor){
        int numero = 0;
        try{
            numero = Integer.parseInt(valor);
        } catch (NumberFormatException nfe){
            showMessageDialog(null, "Error: No es un digito\n" + nfe);
            return this.sliderTemp.getValue();
        }
        if (numero >= 0 && numero <= 3000){
            return numero;
        } else {
            showMessageDialog(null, "Error: El valor no está entre 0 y 3000");
            return this.sliderTemp.getValue();
        }
    }

    void cambiarEstado(){
        int valor = sliderTemp.getValue();
        if (valor >= 0 && valor <= 1000){
            estado.setText("ESTABLE");
            estado.setForeground(Color.GREEN);
        } else if (valor > 1000 && valor <= 1500){
            estado.setText("PRECAUCIÓN");
            estado.setForeground(Color.YELLOW);
        } else {
            estado.setText("RIESGO DE FUSIÓN");
            estado.setForeground(Color.RED);
        }
    }

}
