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

    private static Chat ultimoMensaje;
    // Creamos un chat con el nombre de usuario
    Chat(String usuario){
        this.esteUsuario = usuario;
        this.setContentPane(mainPanel);
        this.setVisible(true);
        this.setSize(300,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Ventana de " + esteUsuario);
        this.setLocation(300, 300);
        botonEnviar.addActionListener(this);

    }
    // Una vez hayamos creado un cat, creamos otro pasando el chat ya creado para vincularlos
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
        // Si no hay texto en el mensaje entonces detiene el método
        if (mensaje.equals("")){return;}

        // Por añguna razón si gasto el mismo objeto Mensaje en ambos Chats solo aparecerá en una ventana
        Mensaje mensajeRemoto = new Mensaje(mensaje, this.esteUsuario);

        if (ultimoMensaje == this){
            // Si el último mensaje es de este usuario entonces en el mensaje remoto no aparecerá el nombre (mensajes concadenados)
            mensajeRemoto.getUsuarioOrigen().setVisible(false);
        }


        GridBagConstraints otro = new GridBagConstraints();
        // Si el mensaje es ajeno aparece a la izquierda (primera columna)
        otro.gridx = 1;
        otro.gridy = numMensajes;
        otroChat.mensajes.add(mensajeRemoto, otro);
        otroChat.mensajes.revalidate();

        Mensaje mensajeLocal = new Mensaje(mensaje, this.esteUsuario);

        if (ultimoMensaje == this){
            mensajeLocal.getUsuarioOrigen().setVisible(false);
        }

        GridBagConstraints propio = new GridBagConstraints();
        // Si el mensaje es propio que aparezca a la derecha (segunda columna)
        propio.gridx = 2;
        propio.gridy = numMensajes;

        this.mensajes.add(mensajeLocal, propio);
        this.mensajes.revalidate();
        numMensajes++;
        otroChat.numMensajes++;
        this.inputMensaje.setText("");
        // El último emisor del chat será el último que ha mandado un mensaje
        ultimoMensaje = this;
    }
}
