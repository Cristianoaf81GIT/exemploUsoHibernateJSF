package gestaoescolar.dao.hibernate;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;

import gestaoescolar.dao.UsuarioDAO;
import gestaoescolar.entidades.Usuario;

public class UsuarioDAOHibernate implements UsuarioDAO {
	
	private Session session;
		

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(Usuario usuario) {
		this.session.save(usuario);
		
	}

	@Override
	public void atualizar(Usuario usuario) {
		this.session.update(usuario);
		
	}

	@Override
	public void excluir(Usuario usuario) {
		this.session.delete(usuario);
		
	}

	@Override
	public Usuario buscarPorId(Integer codigo) {
		return (Usuario) this.session.get(Usuario.class, codigo);
	}

	@Override
	public Usuario BuscarPorLogin(String login) {
		String hql = "select u from Usuario u where u.login = :login";
		Query<?> consulta = this.session.createQuery(hql);
		consulta.setParameter("login", login);
		return (Usuario) consulta.uniqueResult();
	}

	
	@Override
	public List<Usuario> listar() {
		return this.session.createQuery(
				"from Usuario",
				Usuario.class
		).list();
	}

}
