package gestaoescolar.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import gestaoescolar.entidades.Usuario;
import gestaoescolar.regrasdenegocio.UsuarioRN;

@ManagedBean(name="usuarioBEAN")
@RequestScoped
public class UsuarioBEAN {
	
	private Usuario usuario = new Usuario();
	private String confirmaSenha;
	

	public String novo(){
		this.usuario = new Usuario();
		this.usuario.setAtivo(true);
		return "/publico/usuario";
	}
	
	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		String senha = this.usuario.getSenha();
		if(!senha.equals(this.confirmaSenha)){
			FacesMessage message = new FacesMessage("Usuário ou senha inválido(a)");
			context.addMessage(null, message);
			return null;
		}
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.salvar(this.usuario);
		
		return "usuariosucesso";
	}	
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getConfirmaSenha() {
		return confirmaSenha;
	}
	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}	

}
