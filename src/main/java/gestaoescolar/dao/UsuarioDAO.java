package gestaoescolar.dao;

import gestaoescolar.entidades.Usuario;

public interface UsuarioDAO {
	
	public void salvar(Usuario usuario);
	public void atualizar(Usuario usuario);
	public void excluir(Usuario usuario);
	public Usuario buscarPorId(Integer codigo);
	public Usuario BuscarPorLogin(String login);
	public java.util.List<Usuario> listar();

}
