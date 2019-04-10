package gestaoescolar.util;

import gestaoescolar.dao.UsuarioDAO;
import gestaoescolar.dao.hibernate.UsuarioDAOHibernate;

public class DAOFactory {
	
	public static UsuarioDAO criarUsuarioDAO() {
		UsuarioDAOHibernate usuarioDAO = new UsuarioDAOHibernate();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO;
	}

}
