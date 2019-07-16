package teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Sisout<SQLite> {

	// Cria um objeto de conexão com banco de dados
	private Connection objConexao;

	public Connection getObjConexao() {
		return objConexao;
	}

	public void setObjConexao(Connection objConexao) {
		this.objConexao = objConexao;
	}

	private String banco = "jdbc:sqlite:C:/Users/S13Ro/Banc.db";
	private String usuario = "";
	private String senha = "";

	// Abre conexão com o banco de dados.

	public Connection abrirConexaoBD() throws SQLException {

		// Registra um novo driver para conexão com banco de dados
		DriverManager.registerDriver(new Tela_principal());

		// Estabelece conexão com banco de dados a partir do objeto de conexão
		this.objConexao = DriverManager.getConnection(this.banco, this.usuario, this.senha);

		return this.objConexao;

	}

	// Fecha conexão com banco de dados.

	public void fecharConexaoBD() throws SQLException {
		this.objConexao.close();
	}

	public Connection Connect() {
		Connection conn = null;

		try {
			String url = "jdbc:sqlite:C:/Users/S13Ro/Banc.db";

			conn = DriverManager.getConnection(url);
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return conn;
	}

	public void incluirPessoa(String nome, String email, String CPF) {
		String sql = "INSERT INTO BANC (NOME, EMAIL, CPF) VALUES (?,?,?)";

		try (Connection conn = this.Connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, nome);
			pstmt.setString(2, email);
			pstmt.setString(3, CPF);
			pstmt.executeUpdate();
			System.out.println("teste");
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public void alterarPessoa(Base objPessoa) throws SQLException {

		// Query de atualização
		String updateQuerySQL = "UPDATE BANC SET NOME = ?, EMAIL = ? CPF = ?";
		PreparedStatement objSQLUpdate = this.objConexao.prepareStatement(updateQuerySQL);

		// Executa a query
		objSQLUpdate.setString(1, objPessoa.getnome());
		objSQLUpdate.setString(2, objPessoa.getEmail());
		objSQLUpdate.setString(3, objPessoa.getCPF());
		objSQLUpdate.executeUpdate();

	}

	// Exclui uma pessoa registrada na tabela.

	public void excluirPessoa(int codigo) throws SQLException {

		// Query de remoção
		String deleteQuerySQL = "DELETE FROM BANC WHERE CODIGO = ?";
		PreparedStatement objSQLDelete = this.objConexao.prepareStatement(deleteQuerySQL);

		// Executa a query
		objSQLDelete.setInt(1, codigo);
		objSQLDelete.executeUpdate();

	}

}
