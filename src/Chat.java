import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chat extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JPanel mensajes;
    private JLabel otroUsuario;
    private JTextArea inputMensaje;
    private JButton botonEnviar;
    private Chat otroChat;
    private final String esteUsuario;
    private int numMensajes = 0;

    Chat(String usuario){
        this.esteUsuario = usuario;
        this.setContentPane(mainPanel);
        this.setVisible(true);
        this.setSize(300,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Ventana de " + esteUsuario);
        this.setLocation(300, 300);
        botonEnviar.addActionListener(this);
        GridBagConstraints c = new GridBagConstraints();

    }

    Chat(String usuario, Chat otroChat){
        this(usuario);
        this.otroChat = otroChat;
        otroChat.otroChat = this;
        this.otroUsuario.setText(otroChat.esteUsuario + " - En línea");
        otroChat.otroUsuario.setText(this.esteUsuario + " - En línea");
        this.setLocation(700, 300);
    }
    public static void main(String[] args){
        Chat chat1 = new Chat("Adrián");
        Chat chat2 = new Chat("David", chat1);

    }

    public String getEsteUsuario() {
        return esteUsuario;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String mensaje = this.inputMensaje.getText();

        if (mensaje.equals("")){return;}

        Mensaje mensajeRemoto = new Mensaje(mensaje, this.esteUsuario);
        GridBagConstraints otro = new GridBagConstraints();
        otro.gridx = 1;
        otro.gridy = numMensajes;
        otroChat.mensajes.add(mensajeRemoto, otro);
        otroChat.mensajes.revalidate();

        Mensaje mensajeLocal = new Mensaje(mensaje, this.esteUsuario);
        GridBagConstraints propio = new GridBagConstraints();
        propio.anchor = GridBagConstraints.EAST;
        propio.gridx = 2;
        propio.gridy = numMensajes;

        this.mensajes.add(mensajeLocal, propio);
        this.mensajes.revalidate();
        numMensajes++;
        otroChat.numMensajes++;
        this.inputMensaje.setText("");
    }
}
