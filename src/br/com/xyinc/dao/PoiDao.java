package br.com.xyinc.dao;

import java.util.List;

import br.com.xyinc.entity.Poi;
import br.com.xyinc.filter.PoiFilter;

/**
 * Interface para DAO da entidade POI
 *
 */
public interface PoiDao {
	
	/**
	 * Salva o POI
	 * @param entity
	 */
	void salvar(Poi entity);
	
	/**
	 * Lista o POI
	 * @param entity
	 */
	List<Poi> listarPois();
	 
	/**
	 * Lista o POI por proximidade
	 * @param entity
	 */
	List<Poi> listarPoisProximidade(PoiFilter filter);
}
