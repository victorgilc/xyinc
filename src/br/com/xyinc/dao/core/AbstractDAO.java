package br.com.xyinc.dao.core;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import br.com.xyinc.entity.IModel;
import br.com.xyinc.util.JpaUtils;

/**
 * Classe abstrata para DAOs
 */
public abstract class AbstractDAO <T>{

	@Inject
    private JpaUtils jpaUtils;
    
    public T saveOrUpdate(T value) {
        return jpaUtils.saveOrUpdate(value);
    }

    public void save(T... item) {
        jpaUtils.save(item);
    }
    
    public void delete(T... value) {
        jpaUtils.delete(value);
    }

    public void update(T... item) {
        jpaUtils.update(item);
    }

    public T findForId(Class<? extends IModel> model,Long id) {
        return (T)jpaUtils.findForId(model, id);
    }

    public List<T> findAll() {
        return (List<T>) jpaUtils.findAll(getType());
    }
    
    
    public List<T> findList(String jpaQuery, Map parametros) {
        return (List<T>) jpaUtils.findList(jpaQuery, parametros);
    }
    
    public T findObject(String jpaQuery, Map<String, Object> parametros)
    {
    	return (T) jpaUtils.findObject(jpaQuery, parametros);
    }

    public abstract Class<? extends IModel> getType();
}
