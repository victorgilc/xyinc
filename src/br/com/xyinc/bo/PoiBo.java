package br.com.xyinc.bo;

import java.util.List;

import br.com.xyinc.entity.Poi;
import br.com.xyinc.filter.PoiFilter;

/**
 * 
 * BO para a entidade de POI
 *
 */
public interface PoiBo {

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
	 * @param filter - filtros recebidos
	 */
	List<Poi> listarPoisProximidade(PoiFilter filter);
}
