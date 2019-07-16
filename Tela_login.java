package teste;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

public class Tela_login {

	private boolean login_sistema;
	private JFrame janela_LoginDeSistema;
	private JTextField textefield_DO_LOGIN;
	private JPasswordField passwordfield_DO_PASSWORD;

	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_login window = new Tela_login();
					window.janela_LoginDeSistema.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tela_login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		janela_LoginDeSistema = new JFrame();
		janela_LoginDeSistema.setIconImage(Toolkit.getDefaultToolkit().getImage(Tela_login.class.getResource("/teste/send-user.png")));
		janela_LoginDeSistema.setTitle("Login de Sistema");
		janela_LoginDeSistema.setResizable(false);
		janela_LoginDeSistema.setBounds(100, 100, 459, 234);
		janela_LoginDeSistema.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela_LoginDeSistema.getContentPane().setLayout(null);

		JPanel panel_Layout_NULL = new JPanel();
		panel_Layout_NULL.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, null, null, null));
		panel_Layout_NULL.setBounds(0, 0, 453, 206);
		janela_LoginDeSistema.getContentPane().add(panel_Layout_NULL);
		panel_Layout_NULL.setLayout(null);

		JLabel lbl_DO_ICONE = new JLabel("");
		lbl_DO_ICONE.setIcon(new ImageIcon("C:\\Users\\SALVATORY\\Desktop\\img.png"));
		lbl_DO_ICONE.setBounds(24, 11, 140, 163);
		panel_Layout_NULL.add(lbl_DO_ICONE);

		JLabel lblmMENSAGEM = new JLabel("Digite seu Login e Senha");
		lblmMENSAGEM.setForeground(UIManager.getColor("Button.disabledForeground"));
		lblmMENSAGEM.setFont(new Font("Roboto", Font.BOLD, 18));
		lblmMENSAGEM.setBounds(174, 28, 261, 29);
		panel_Layout_NULL.add(lblmMENSAGEM);

		JLabel lblMENSAGEM_LOGIN = new JLabel("Login");
		lblMENSAGEM_LOGIN.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 30));
		lblMENSAGEM_LOGIN.setBounds(168, 82, 102, 37);
		panel_Layout_NULL.add(lblMENSAGEM_LOGIN);

		JLabel lblMENSAGEM_SENHA = new JLabel("Senha");
		lblMENSAGEM_SENHA.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 30));
		lblMENSAGEM_SENHA.setBounds(164, 129, 102, 37);
		panel_Layout_NULL.add(lblMENSAGEM_SENHA);

		//####TEXTFIELDE DO LOGIN ####
		
		textefield_DO_LOGIN = new JTextField();
		textefield_DO_LOGIN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		textefield_DO_LOGIN.setBounds(273, 85, 151, 25);
		panel_Layout_NULL.add(textefield_DO_LOGIN);
		textefield_DO_LOGIN.setColumns(10);
  
		//####TEXTFIELDE DA SENHA ####
		
		passwordfield_DO_PASSWORD = new JPasswordField();
		passwordfield_DO_PASSWORD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		passwordfield_DO_PASSWORD.setBounds(273, 132, 151, 25);
		panel_Layout_NULL.add(passwordfield_DO_PASSWORD);

		JButton btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textefield_DO_LOGIN.getText().equalsIgnoreCase("geamisson") && passwordfield_DO_PASSWORD.getText().equalsIgnoreCase("1234")) {
					login_sistema = true;
					janela_LoginDeSistema.dispose();
					Tela_principal window = new Tela_principal();
					window.janelaPRINCIPAL_DE_CADASTROS.setVisible(true);
				} else if (!textefield_DO_LOGIN.getText().equalsIgnoreCase("geamisson") || !passwordfield_DO_PASSWORD.getText().equalsIgnoreCase("1234")) {
					JOptionPane.showMessageDialog(null, "Usuario e senha incorreto");
				}
			}

		});
		btnLogar.setBounds(335, 168, 89, 23);
		panel_Layout_NULL.add(btnLogar);
			
		//#### ACÃO DO BOTAO LIMPAR######
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textefield_DO_LOGIN.setText("");
				passwordfield_DO_PASSWORD.setText("");

			}
		});
		btnLimpar.setBounds(232, 168, 89, 23);
		panel_Layout_NULL.add(btnLimpar);
	}

	public boolean islogin_sistema() {
		return login_sistema;
	}

	private class SwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}
}
