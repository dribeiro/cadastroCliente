package br.com.plano2.cadastro.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.com.plano2.cadastro.modelo.Cliente;

@SessionScoped
@Component
public class ClienteDao {
	
	private EntityManagerFactory factory;
	private EntityManager manager;
	
	public ClienteDao() {
		factory = Persistence.createEntityManagerFactory("cadastro");
		manager = factory.createEntityManager();
	}
	
	private void abrirTransaction(EntityTransaction transaction){
		if (!transaction.isActive())
			transaction.begin();
	}

	public void save(final Cliente entity) {
		EntityTransaction transaction = manager.getTransaction();
		abrirTransaction(transaction);
		manager.merge(entity);
		transaction.commit();
	}

	public void delete(final Cliente entity) {
		EntityTransaction transaction = manager.getTransaction();
		abrirTransaction(transaction);
		manager.remove(entity);
		transaction.commit();
	}

	public void delete(final Integer id) {
		Cliente object = findById(id);
		if (null != object)
			delete(object);
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> findAll() {
		Session delegate = (Session) manager.getDelegate();
		Criteria criteria = delegate.createCriteria(Cliente.class);
		return criteria.list();
	}

	public Cliente findById(final Integer id) {
		return manager.find(Cliente.class, id);
	}

	public Cliente update(final Cliente entity) {
		EntityTransaction transaction = manager.getTransaction();
		abrirTransaction(transaction);
		Cliente cliente = manager.merge(entity);
		transaction.commit();
		return cliente;
	}

}
