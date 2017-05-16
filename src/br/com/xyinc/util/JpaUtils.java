
package br.com.xyinc.util;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.com.xyinc.entity.IModel;

/**
 * Utilitário para o JPA, com métodos comuns
 */
@Transactional
public class JpaUtils{

	@PersistenceContext(unitName = "xyinc")
	EntityManager em;

	public <T> T saveOrUpdate(T value) {

		
		if (((IModel) value).getId() != null) {

			em.merge(value);

		} else {

			try
			{
			em.persist(value);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				ex.getSuppressed();
			}
		}

		em.flush();

		return value; 
	}

	public <T> void save(T... values) {
		for (T value : values) {
			em.persist(value);
		}
		em.flush();
	}
	
	public <T> T update(T value) {
			em.persist(value);
			em.merge(value);
			em.flush();
			
			return value;
	}


	public <T> void update(T... values) {
		for (T value : values) {
			em.merge(value);
			em.flush();
		}
	}

	public <T> void delete(T... values) {

		for (T value : values) {
			em.remove(value);
			em.flush();
		}

	}

	public <T> List<T> findList(String jpaQuery,Map<String, Object> parametros) {

		Query query = null;

		List<T> paraRetornar = null;
		try {

			query = em.createQuery(jpaQuery);
			if (parametros != null) {
				Set<String> chaves = parametros.keySet();
				for (String chave : chaves) {
					if (chave != null) {
						Object value = parametros.get(chave);

						if (value instanceof String) {
							String valueString = (String) value;
							query.setParameter(chave, valueString);
						}

						if (value instanceof Long) {
							Long valueLong = (Long) value;
							query.setParameter(chave, valueLong);
						}
						
						if (value instanceof Integer) {
							Integer valueInteger = (Integer) value;
							query.setParameter(chave, valueInteger);
						}

						if (value instanceof Date) {
							Date valueDate = (Date) value;
							query.setParameter(chave, valueDate);
						}
						if (value instanceof List) {
							 List valueList= (List) value;
							query.setParameter(chave, valueList);
						}
					}
				}
			}

			paraRetornar = query.getResultList();
		} catch (NoResultException nre) {
			return null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return paraRetornar;
	}

	public <T> T findObject(String jpaQuery, Map<String, Object> parametros) {

		Query query = null;
		T paraRetornar = null;

		try {
			query = em.createQuery(jpaQuery);

			if (parametros != null) {
				Set<String> chaves = parametros.keySet();
				for (String chave : chaves) {
					if (chave != null) {
						Object value = parametros.get(chave);

						if (value instanceof String) {
							String valueString = (String) value;
							query.setParameter(chave, valueString);
						}
						
						if (value instanceof Long) {
							Long valueLong = (Long) value;
							query.setParameter(chave, valueLong);
						}

						if (value instanceof Integer) {
							Integer valueInteger = (Integer) value;
							query.setParameter(chave, valueInteger);
						}

						if (value instanceof Date) {
							Date valueDate = (Date) value;
							query.setParameter(chave, valueDate);
						}
					}
				}
			}

			query.setMaxResults(1);
			paraRetornar = (T) query.getSingleResult();

		} catch (NoResultException nre) {
			return null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return paraRetornar;
	}
	

	public List<Class<? extends IModel>> findAll(Class<? extends IModel> model) {

		Query query = null;
		List<Class<? extends IModel>> paraRetornar = null;

		try {
			query = em.createQuery("select c FROM " + model.getSimpleName()
					+ " c");

			paraRetornar = query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return paraRetornar;
	}

	public <T> T findForId(Class<? extends IModel> model,
			Long id) {

		Query query = null;

		T paraRetornar = null;

		try {
			query = em.createQuery("select c FROM " + model.getSimpleName()
					+ " c WHERE c.id = " + id);

			paraRetornar = (T)query.getSingleResult();

		} catch (NoResultException ex) {
			return null;
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return paraRetornar;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
}
