package com.everis.academia.java.agenda.digital.dao.impl.hibernate;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.everis.academia.java.agenda.digital.dao.ITipoServicoDAO;
import com.everis.academia.java.agenda.digital.entidades.TipoServico;

@Repository
public class TipoServicoHibernateDAO implements ITipoServicoDAO {

	@Autowired
	private SessionFactory sessionFactory;
	private Session session;

	@Override
	public void create(TipoServico entidade) {
		session = sessionFactory.getCurrentSession();
		session.save(entidade);
		session.flush();
	}

	@Override
	public Collection<TipoServico> read() {
		session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(TipoServico.class);
		return criteria.list();
	}

	@Override
	public void update(TipoServico entidade) {
		session = sessionFactory.getCurrentSession();
		session.update(entidade);
		session.flush();
	}

	@Override
	public void delete(Short codigo) {
		session = sessionFactory.getCurrentSession();
		TipoServico servico = session.get(TipoServico.class, codigo);
		session.delete(servico);
	}
}
