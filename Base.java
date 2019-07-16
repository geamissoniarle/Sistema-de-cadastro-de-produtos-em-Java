package teste;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Base {
	private String nome; 
	private String Email; 
	private String CPF; 
	boolean button;
	boolean btnAdicionar;
	boolean btnEditar; 
	boolean btnExcluir;
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getnome(){
		return nome;
	}
	public void nome(){
	 this.nome = nome; 
	}
	public String getEmail(){
		return Email;
	}
	public void Email(){
	 this.Email = Email; 
	}
	public String getCPF(){
		return CPF;
	}
	public void CPF(){
	 this.CPF = CPF; 
	}
	public boolean getbutton(){
		return button;
	}
	public void button(){
	 this.button = button; 
	}
	public boolean getbtnAdicionar(){
		return btnAdicionar;
	}
	public  Base(){
	 this.btnAdicionar = btnAdicionar; 

	}
	public boolean getbtnEditar(){
		return btnEditar;
	}
	public void btnEditar(){
	 this.btnEditar = btnEditar; 
	}
	public boolean getbtnExcluir(){
		return btnExcluir;
	}
	public void btnExcluir(){
	 this.btnExcluir = btnExcluir; 
	}
}

