package com.everis.academia.java.agenda.digital.dao.impl.hibernate;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.everis.academia.java.agenda.digital.dao.ICidadeDAO;
import com.everis.academia.java.agenda.digital.entidades.Cidade;

@Repository
public class CidadeHibernateDAO implements ICidadeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	private Session session;

	@Override
	public void create(Cidade entidade) {
		session = sessionFactory.getCurrentSession();
		session.save(entidade);
		session.flush();
	}

	@Override
	public Collection<Cidade> read() {
		session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Cidade.class);
		return criteria.list();
	}

	@Override
	public void update(Cidade entidade) {
		session = sessionFactory.getCurrentSession();
		session.update(entidade);
		session.flush();
	}

	@Override
	public void delete(Cidade entidade) {
		session = sessionFactory.getCurrentSession();
		entidade = session.get(Cidade.class, entidade.getCodigo());
		session.delete(entidade);
	}

	@Override
	public Boolean delete(Integer codigo) {
		session = sessionFactory.getCurrentSession();
		Cidade cidade = session.get(Cidade.class, codigo);
		session.delete(cidade);
		return null;
	}

	@Override
	public Boolean contains(Cidade cidade) {
		session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Cidade.class);
		criteria.add(Restrictions.and(Restrictions.eq("nome", cidade.getNome()).ignoreCase(),
				Restrictions.or(Restrictions.isNotNull("codigo"), Restrictions.ne("codigo", cidade.getCodigo()))));
		criteria.setProjection(Projections.count("codigo"));
		return (long) criteria.uniqueResult() > 0;
	}
}
