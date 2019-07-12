package com.everis.academia.java.agenda.digital.dao.impl.hibernate;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.everis.academia.java.agenda.digital.dao.IPrestadorServicoDAO;
import com.everis.academia.java.agenda.digital.entidades.Cidade;
import com.everis.academia.java.agenda.digital.entidades.PrestadorServico;
import com.everis.academia.java.agenda.digital.entidades.Telefone;
import com.everis.academia.java.agenda.digital.entidades.TipoServico;

@Repository
public class PrestadorServicoHibernateDAO implements IPrestadorServicoDAO {

	@Autowired
	private SessionFactory sessionFactory;
	private Session session;

	@Override
	public void create(PrestadorServico entidade) {
		session = sessionFactory.getCurrentSession();
		session.save(entidade);
		session.flush();
	}

	@Override
	public Collection<PrestadorServico> read() {
		session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(PrestadorServico.class);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return criteria.list();
	}

	@Override
	public Collection<Telefone> readTelefones() {
		session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Telefone.class);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return criteria.list();
	}

	@Override
	public void update(PrestadorServico entidade) {
		session = sessionFactory.getCurrentSession();
		session.update(entidade);
		session.flush();
	}

	@Override
	public void delete(Integer codigo) {
		session = sessionFactory.getCurrentSession();
		PrestadorServico entidade = session.get(PrestadorServico.class, codigo);
		session.delete(entidade);
	}

	@Override
	public Boolean numeroTelefoneExists(Long numero) {
		session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Telefone.class);
		criteria.add(Restrictions.eq("numero", numero));
		criteria.setProjection(Projections.count("codigo"));
		return (long) criteria.uniqueResult() > 0;
	}

	@Override
	public Boolean emailExists(String email) {
		session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(PrestadorServico.class);
		criteria.add(Restrictions.eq("email", email));
		criteria.setProjection(Projections.count("codigo"));
		return (long) criteria.uniqueResult() > 0;
	}

	@Override
	public Boolean isCidadeAssigned(Cidade cidade) {
		session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(PrestadorServico.class);
		criteria.add(Restrictions.eq("cidade", cidade));
		criteria.setProjection(Projections.count("codigo"));
		return (long) criteria.uniqueResult() > 0;
	}

	@Override
	public Boolean isTipoServicoAssigned(TipoServico tipoServico) {
		Set<TipoServico> servicos = new HashSet<>();
		servicos.add(tipoServico);
		session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(PrestadorServico.class);
		criteria.add(Restrictions.eq("servicosCredenciados", servicos));
		criteria.setProjection(Projections.count("codigo"));
		return (long) criteria.uniqueResult() > 0;
	}
}
