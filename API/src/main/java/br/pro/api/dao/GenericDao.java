package br.pro.api.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.pro.api.util.HibernateUtil;

import java.lang.reflect.ParameterizedType;
import java.util.List;



public class GenericDao<Entidade> {
	
	private Class<Entidade> classe;
	
	
	@SuppressWarnings("unchecked")
	public GenericDao() {
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	
	public void store(Entidade entindade) {
			Session sessao = HibernateUtil.getSessionfactory().openSession();
			Transaction transcao = null;
			try {
				transcao = sessao.beginTransaction();
				sessao.save(entindade);
				transcao.commit();
			}
			catch (RuntimeException erro) {
				if(transcao != null) {
					transcao.rollback();
				}
				throw erro; 
			}
			finally {
				sessao.close();
			}
	}
	
	@SuppressWarnings("deprecation")
	public List<Entidade> index(){
		
		Session sessao = HibernateUtil.getSessionfactory().openSession();
		try {
			
			Criteria consulta = sessao.createCriteria(this.classe);
			List<Entidade> resultado = consulta.list();
			return resultado;
			
		} catch (RuntimeException e) {
			throw e;
		}
		finally {
			sessao.close();
		}
		
		
	}
	
	public Entidade show(Long codigo){
		
		Session sessao = HibernateUtil.getSessionfactory().openSession();
		try {
			
			Criteria consulta = sessao.createCriteria(this.classe);
			consulta.add(Restrictions.idEq(codigo));
			Entidade resultado = (Entidade) consulta.uniqueResult();
			return resultado;
			
		} catch (RuntimeException e) {
			throw e;
		}
		finally {
			sessao.close();
		}
		
		
	}
	
	public Entidade delete(Long codigo) {
		Session sessao = HibernateUtil.getSessionfactory().openSession();
		Transaction transcao = null;
		try {
			transcao = sessao.beginTransaction();
			Entidade entindade = show(codigo);
			sessao.delete(entindade);
			transcao.commit();
			return entindade;
		}
		catch (RuntimeException erro) {
			if(transcao != null) {
				transcao.rollback();
			}
			throw erro; 
		}
		finally {
			sessao.close();
		}
	}
	
	public void update(Entidade entindade) {
		Session sessao = HibernateUtil.getSessionfactory().openSession();
		Transaction transcao = null;
		try {
			transcao = sessao.beginTransaction();
			sessao.update(entindade);
			transcao.commit();
		}
		catch (RuntimeException erro) {
			if(transcao != null) {
				transcao.rollback();
			}
			throw erro; 
		}
		finally {
			sessao.close();
		}
	}
	
}
