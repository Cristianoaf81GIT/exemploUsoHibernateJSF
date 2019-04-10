package gestaoescolar.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import gestaoescolar.util.HibernateUtil;

@WebFilter(urlPatterns = {"*.jsf"})
public class ConexaoHibernateFiltro implements Filter{
	
	private SessionFactory sessionFactory;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.sessionFactory = HibernateUtil.getSessionFactory();
		
	}

	@Override
	public void doFilter(
			ServletRequest request,
			ServletResponse response,
			FilterChain chain)
			throws IOException, ServletException {
		
		
		Session sessaoAtual = this.sessionFactory.getCurrentSession();
		Transaction transacao = null;
		try {
			
			transacao = sessaoAtual.beginTransaction();
			chain.doFilter(request, response);			
			transacao.commit();
			
			if(sessaoAtual.isOpen()) {
				sessaoAtual.close();
			}
			
		}catch(Throwable e) {
			try {
				
				if(transacao.isActive())
					transacao.rollback();
				
			}catch(Throwable t) {
				t.printStackTrace();
			}
			
			throw new ServletException(e);
		}
		
	}

	@Override
	public void destroy() {
		
		
	}

}
