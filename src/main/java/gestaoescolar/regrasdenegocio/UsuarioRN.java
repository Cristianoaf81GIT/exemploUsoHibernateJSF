package gestaoescolar.regrasdenegocio;

import java.util.List;

import gestaoescolar.dao.UsuarioDAO;
import gestaoescolar.entidades.Usuario;
import gestaoescolar.util.DAOFactory;

public class UsuarioRN {
	
	private UsuarioDAO usuarioDAO;
	
	public UsuarioRN() {
		this.usuarioDAO = DAOFactory.criarUsuarioDAO();
	}
	
	public Usuario carregar(Integer codigo) {
		return this.usuarioDAO.buscarPorId(codigo);
	}
	
	public Usuario buscarPorlogin(String login) {
		return this.usuarioDAO.BuscarPorLogin(login);
	}
	
	public void salvar(Usuario usuario) {
		Integer codigo = usuario.getCodigo();
		
		if(codigo == null || codigo == 0) {
			this.usuarioDAO.salvar(usuario);
		}else {
			this.usuarioDAO.atualizar(usuario);
		}
	}
	
	public void excluir(Usuario usuario) {
		this.usuarioDAO.excluir(usuario);
	}
	
	public List<Usuario> listar(){
		return this.usuarioDAO.listar();
	}
}
