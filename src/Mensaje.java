import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Mensaje extends JPanel {
    private JPanel laminaMensaje;
    private JLabel usuarioOrigen;
    private JTextArea textoMensaje;

    Mensaje(String texto, String origen){
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        Date fecha = new Date();
        this.add(laminaMensaje);
        textoMensaje.setText(texto);
        this.setSize(100,100);
        this.usuarioOrigen.setText(origen + " - " +  formatter.format(fecha));
    }

    public JLabel getUsuarioOrigen() {
        return usuarioOrigen;
    }
}
