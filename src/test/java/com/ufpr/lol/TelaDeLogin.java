import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaDeLogin {

    public static void main(String[] args) {
        // Cria uma nova janela
        JFrame frame = new JFrame("Tela de Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new BorderLayout());

        // Painel para colocar os componentes
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        // Campos de texto e rótulos
        JLabel usernameLabel = new JLabel("Nome de Usuário:");
        JTextField usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Senha:");
        JPasswordField passwordField = new JPasswordField();

        // Botão de login
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Verificar as credenciais (neste exemplo, usuário: "admin", senha: "admin")
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (username.equals("admin") && password.equals("admin")) {
                    JOptionPane.showMessageDialog(null, "Login bem-sucedido!");
                } else {
                    JOptionPane.showMessageDialog(null, "Nome de usuário ou senha incorretos.");
                }
            }
        });

        // Adiciona componentes ao painel
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel()); // Espaço vazio
        panel.add(loginButton);

        // Adiciona o painel à janela
        frame.add(panel, BorderLayout.CENTER);

        // Torna a janela visível
        frame.setVisible(true);
    }
}
