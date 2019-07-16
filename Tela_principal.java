package teste;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.border.BevelBorder;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JFormattedTextField;
import javax.swing.DropMode;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Tela_principal implements Driver {

	JFrame janelaPRINCIPAL_DE_CADASTROS;
	private JMenu Inicio;
	private JTextField textField_DO_NOME_CLIENTE;
	private JTextField textField_DO_EMAIL_CLIENTE;
	private JTextField textField_PREÇO_DO_PRODUTO;
	private JTextField textField_QUANT_DO_PRODUTO;
	private JTextField textField_PRODUTO;
	private JTextField textField_CODIGO_DO_PRODUTO;
	private JTextField textField_CPF_CLIENTE;
	private JTable tb_Cadastro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_principal window = new Tela_principal();
					window.janelaPRINCIPAL_DE_CADASTROS.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tela_principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		janelaPRINCIPAL_DE_CADASTROS = new JFrame();
		janelaPRINCIPAL_DE_CADASTROS.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Tela_principal.class.getResource("/teste/system-settings-icon_31831.png")));
		janelaPRINCIPAL_DE_CADASTROS.setResizable(false);
		janelaPRINCIPAL_DE_CADASTROS.getContentPane().setLocation(-6, -180);
		janelaPRINCIPAL_DE_CADASTROS.setBounds(100, 100, 572, 500);
		janelaPRINCIPAL_DE_CADASTROS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar_BARRA_DE_MENU = new JMenuBar();
		janelaPRINCIPAL_DE_CADASTROS.setJMenuBar(menuBar_BARRA_DE_MENU);

		Inicio = new JMenu("Inicio");
		menuBar_BARRA_DE_MENU.add(Inicio);

		// menu produto 
		
		JMenu NewMenu_CAIXA = new JMenu("Caixa");
		menuBar_BARRA_DE_MENU.add(NewMenu_CAIXA);

		JMenu NewMenu_ESTOQUE = new JMenu("Estoque");
		menuBar_BARRA_DE_MENU.add(NewMenu_ESTOQUE);

		JMenuItem menu_iten_CadastroNovoProduto = new JMenuItem("Novo Produto");
		menu_iten_CadastroNovoProduto.setSelectedIcon(new ImageIcon(Tela_principal.class.getResource("/teste/plus.png")));

		NewMenu_ESTOQUE.add(menu_iten_CadastroNovoProduto);

		JMenu NewMenu_CLIENTES = new JMenu("Clientes");
		menuBar_BARRA_DE_MENU.add(NewMenu_CLIENTES);

		JMenuItem menu_iten_CadastroNovoCliente = new JMenuItem("Novo Cliente");

		NewMenu_CLIENTES.add(menu_iten_CadastroNovoCliente);

		JMenu NewMenu_SAIR = new JMenu("Sair");
		menuBar_BARRA_DE_MENU.add(NewMenu_SAIR);

		JMenuItem menu_iten_FECHAR_SISTEMA = new JMenuItem("Fechar");
		menu_iten_FECHAR_SISTEMA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		NewMenu_SAIR.add(menu_iten_FECHAR_SISTEMA);
		janelaPRINCIPAL_DE_CADASTROS.getContentPane().setLayout(null);

		JPanel panel_CardLayout = new JPanel();
		panel_CardLayout.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, null, null, null));
		panel_CardLayout.setForeground(Color.WHITE);
		panel_CardLayout.setBounds(10, 11, 540, 164);
		janelaPRINCIPAL_DE_CADASTROS.getContentPane().add(panel_CardLayout);
		panel_CardLayout.setLayout(new CardLayout(0, 0));

		JPanel panel_CardLayout_CADASTRO_CLIENTE = new JPanel();
		panel_CardLayout_CADASTRO_CLIENTE.setBackground(Color.WHITE);
		panel_CardLayout.add(panel_CardLayout_CADASTRO_CLIENTE, "name_18587918482325");
		panel_CardLayout_CADASTRO_CLIENTE.setLayout(null);

		// menu cliente 
		
		JLabel lbl_CADASTRO_NOVO_CLIENTE = new JLabel("Cadastro Novo Cliente");
		lbl_CADASTRO_NOVO_CLIENTE.setFont(new Font("Roboto", Font.BOLD, 18));
		lbl_CADASTRO_NOVO_CLIENTE.setForeground(Color.DARK_GRAY);
		lbl_CADASTRO_NOVO_CLIENTE.setBackground(Color.WHITE);
		lbl_CADASTRO_NOVO_CLIENTE.setBounds(167, 4, 227, 26);
		panel_CardLayout_CADASTRO_CLIENTE.add(lbl_CADASTRO_NOVO_CLIENTE);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Tela_principal.class.getResource("/teste/icone-cliente.png")));
		lblNewLabel.setBounds(10, 31, 128, 101);
		panel_CardLayout_CADASTRO_CLIENTE.add(lblNewLabel);

		JLabel lbl_NOME = new JLabel("Nome:");
		lbl_NOME.setForeground(Color.GRAY);
		lbl_NOME.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 18));
		lbl_NOME.setBounds(148, 39, 70, 26);
		panel_CardLayout_CADASTRO_CLIENTE.add(lbl_NOME);

		JLabel lbl_EMAIL = new JLabel("Email:");
		lbl_EMAIL.setForeground(Color.GRAY);
		lbl_EMAIL.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 18));
		lbl_EMAIL.setBounds(148, 70, 70, 26);
		panel_CardLayout_CADASTRO_CLIENTE.add(lbl_EMAIL);

		JLabel lbl_CPF = new JLabel("CPF:");
		lbl_CPF.setForeground(Color.GRAY);
		lbl_CPF.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 18));
		lbl_CPF.setBounds(148, 104, 70, 26);
		panel_CardLayout_CADASTRO_CLIENTE.add(lbl_CPF);

		//textfield "nome" 
		
		textField_DO_NOME_CLIENTE = new JTextField();
		textField_DO_NOME_CLIENTE.setBounds(218, 42, 293, 20);
		panel_CardLayout_CADASTRO_CLIENTE.add(textField_DO_NOME_CLIENTE);
		textField_DO_NOME_CLIENTE.setColumns(10);

		//textfield "email" 
		
		textField_DO_EMAIL_CLIENTE = new JTextField();
		textField_DO_EMAIL_CLIENTE.setColumns(10);
		textField_DO_EMAIL_CLIENTE.setBounds(218, 74, 293, 20);
		panel_CardLayout_CADASTRO_CLIENTE.add(textField_DO_EMAIL_CLIENTE);

		//Botão salvar 
		
		JButton btn_Salvar_O_NOVO_CLIENTE = new JButton("Salvar");
		btn_Salvar_O_NOVO_CLIENTE.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String nome = textField_DO_NOME_CLIENTE.getText();
				String email = textField_DO_EMAIL_CLIENTE.getText();
				String cpf = textField_CPF_CLIENTE.getText();
				Base Cliente = new Base();
				Cliente.setNome(nome);
				Cliente.setEmail(email);
				Cliente.setCPF(cpf);
				
				DefaultTableModel modelo =(DefaultTableModel) tb_Cadastro.getModel();
				modelo.setNumRows(0);
				modelo.addRow(new Object []{
					Cliente.getNome(),
					Cliente.getEmail(),
					Cliente.getCPF(),
				});
				
				
				
				JOptionPane.showMessageDialog(null, "cadastrado com sucesso");
				
			}
		});
		btn_Salvar_O_NOVO_CLIENTE.setBounds(431, 126, 89, 28);
		panel_CardLayout_CADASTRO_CLIENTE.add(btn_Salvar_O_NOVO_CLIENTE);
		btn_Salvar_O_NOVO_CLIENTE.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Sisout sisout = new Sisout();
				
				System.out.println("teste");

				String nome = textField_DO_NOME_CLIENTE.getText();
				String email = textField_DO_EMAIL_CLIENTE.getText();
				String CPF = textField_CPF_CLIENTE.getText();

				System.out.println(nome + email + CPF);
				
				sisout.incluirPessoa(nome, email, CPF);
			}
		});

		textField_CPF_CLIENTE = new JTextField();
		textField_CPF_CLIENTE.setColumns(10);
		textField_CPF_CLIENTE.setBounds(218, 104, 196, 20);
		panel_CardLayout_CADASTRO_CLIENTE.add(textField_CPF_CLIENTE);

		JPanel panel_CardLayout_CADASTRO_DE_PRODUTO = new JPanel();
		panel_CardLayout_CADASTRO_DE_PRODUTO.setBackground(Color.WHITE);
		panel_CardLayout.add(panel_CardLayout_CADASTRO_DE_PRODUTO, "name_18636222739818");
		panel_CardLayout_CADASTRO_DE_PRODUTO.setLayout(null);

		// cadastro de produtos 
		
		JLabel lblCadastroDeProdutos = new JLabel("Cadastro de Produtos");
		lblCadastroDeProdutos.setForeground(Color.DARK_GRAY);
		lblCadastroDeProdutos.setFont(new Font("Roboto", Font.BOLD, 18));
		lblCadastroDeProdutos.setBackground(Color.WHITE);
		lblCadastroDeProdutos.setBounds(168, 6, 227, 26);
		panel_CardLayout_CADASTRO_DE_PRODUTO.add(lblCadastroDeProdutos);

		JLabel lbl_ICONE_IMG_PRODUTO = new JLabel("");
		lbl_ICONE_IMG_PRODUTO.setIcon(new ImageIcon(Tela_principal.class.getResource("/teste/produto.jpg")));
		lbl_ICONE_IMG_PRODUTO.setBounds(7, 32, 134, 117);
		panel_CardLayout_CADASTRO_DE_PRODUTO.add(lbl_ICONE_IMG_PRODUTO);

		JLabel lbl_PRODUTO = new JLabel("Produto:");
		lbl_PRODUTO.setForeground(Color.GRAY);
		lbl_PRODUTO.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 18));
		lbl_PRODUTO.setBounds(146, 39, 78, 26);
		panel_CardLayout_CADASTRO_DE_PRODUTO.add(lbl_PRODUTO);

		JLabel lbl_QUAN = new JLabel("Quant.");
		lbl_QUAN.setForeground(Color.GRAY);
		lbl_QUAN.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 18));
		lbl_QUAN.setBounds(154, 70, 70, 26);
		panel_CardLayout_CADASTRO_DE_PRODUTO.add(lbl_QUAN);

		JLabel lbl_PREÇO = new JLabel("Pre\u00E7o");
		lbl_PREÇO.setForeground(Color.GRAY);
		lbl_PREÇO.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 18));
		lbl_PREÇO.setBounds(154, 104, 70, 26);
		panel_CardLayout_CADASTRO_DE_PRODUTO.add(lbl_PREÇO);

		//textfield produto
		
		textField_PREÇO_DO_PRODUTO = new JTextField();
		textField_PREÇO_DO_PRODUTO.setColumns(10);
		textField_PREÇO_DO_PRODUTO.setBounds(224, 106, 62, 20);
		panel_CardLayout_CADASTRO_DE_PRODUTO.add(textField_PREÇO_DO_PRODUTO);

		// textfield quantidade 
		
		textField_QUANT_DO_PRODUTO = new JTextField();
		textField_QUANT_DO_PRODUTO.setColumns(10);
		textField_QUANT_DO_PRODUTO.setBounds(224, 74, 61, 20);
		panel_CardLayout_CADASTRO_DE_PRODUTO.add(textField_QUANT_DO_PRODUTO);

		// textfield preço 
		
		textField_PRODUTO = new JTextField();
		textField_PRODUTO.setColumns(10);
		textField_PRODUTO.setBounds(224, 42, 293, 20);
		panel_CardLayout_CADASTRO_DE_PRODUTO.add(textField_PRODUTO);

		// botão slavar área de produto 
		
		JButton btn_SALVAR_O_NOVO_PRODUTO = new JButton("Salvar");
		btn_SALVAR_O_NOVO_PRODUTO.setBounds(437, 126, 89, 28);
		panel_CardLayout_CADASTRO_DE_PRODUTO.add(btn_SALVAR_O_NOVO_PRODUTO);
		btn_SALVAR_O_NOVO_PRODUTO.addActionListener(new ActionListener() {

			private Sisout sisout;

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		JLabel lbl_CODIGO_DO_PRODUTO = new JLabel("Codigo:");
		lbl_CODIGO_DO_PRODUTO.setForeground(Color.GRAY);
		lbl_CODIGO_DO_PRODUTO.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 18));
		lbl_CODIGO_DO_PRODUTO.setBounds(313, 70, 70, 26);
		panel_CardLayout_CADASTRO_DE_PRODUTO.add(lbl_CODIGO_DO_PRODUTO);

		// textfield código 
		
		textField_CODIGO_DO_PRODUTO = new JTextField();
		textField_CODIGO_DO_PRODUTO.setColumns(10);
		textField_CODIGO_DO_PRODUTO.setBounds(402, 74, 115, 20);
		panel_CardLayout_CADASTRO_DE_PRODUTO.add(textField_CODIGO_DO_PRODUTO);

		JPanel panel_DO_Excluir_Editar_Adicionar = new JPanel();
		panel_DO_Excluir_Editar_Adicionar.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, null, null, null));
		panel_DO_Excluir_Editar_Adicionar.setBounds(10, 182, 540, 35);
		janelaPRINCIPAL_DE_CADASTROS.getContentPane().add(panel_DO_Excluir_Editar_Adicionar);
		panel_DO_Excluir_Editar_Adicionar.setLayout(null);

		//botão adicionar
		
		JButton btnADICIONAR = new JButton("Adicionar");
		btnADICIONAR.setBounds(382, 4, 89, 28);
		panel_DO_Excluir_Editar_Adicionar.add(btnADICIONAR);

		JButton btnEDITAR = new JButton("Editar");
		btnEDITAR.setBounds(225, 4, 89, 28);
		panel_DO_Excluir_Editar_Adicionar.add(btnEDITAR);

		JButton btnEXCLUIR = new JButton("Excluir");
		btnEXCLUIR.setBounds(64, 4, 89, 28);
		panel_DO_Excluir_Editar_Adicionar.add(btnEXCLUIR);

		JPanel panel_DA_LISTA_DE_CLIENTES = new JPanel();
		panel_DA_LISTA_DE_CLIENTES.setBounds(10, 223, 540, 213);
		janelaPRINCIPAL_DE_CADASTROS.getContentPane().add(panel_DA_LISTA_DE_CLIENTES);
		panel_DA_LISTA_DE_CLIENTES.setLayout(null);

		//// ACAO PARA CHARMAR CARDLAYOUT CADASTRO_CLIENTE
		menu_iten_CadastroNovoProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) panel_CardLayout.getLayout();
				cl.show(panel_CardLayout, "name_18636222739818");
			}
		});

		menu_iten_CadastroNovoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) panel_CardLayout.getLayout();
				cl.show(panel_CardLayout, "name_18587918482325");
			}
		});

		JScrollPane scrollPane_DA_LISTA_DE_CLIENTES = new JScrollPane();
		scrollPane_DA_LISTA_DE_CLIENTES.setBounds(0, 0, 538, 213);
		panel_DA_LISTA_DE_CLIENTES.add(scrollPane_DA_LISTA_DE_CLIENTES);
		
		tb_Cadastro = new JTable();
		tb_Cadastro.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Cliente", "CPF", "Email"
			}
		));
		scrollPane_DA_LISTA_DE_CLIENTES.setViewportView(tb_Cadastro);
	}

	@Override
	public boolean acceptsURL(String arg0) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Connection connect(String arg0, Properties arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMajorVersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMinorVersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DriverPropertyInfo[] getPropertyInfo(String arg0, Properties arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean jdbcCompliant() {
		// TODO Auto-generated method stub
		return false;
	}
}
