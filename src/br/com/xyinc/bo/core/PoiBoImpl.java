package br.com.xyinc.bo.core;

import java.time.LocalDateTime;
import java.util.List;

import javax.inject.Inject;

import br.com.xyinc.bo.PoiBo;
import br.com.xyinc.dao.PoiDao;
import br.com.xyinc.entity.Poi;
import br.com.xyinc.filter.PoiFilter;

public class PoiBoImpl implements PoiBo{

	@Inject
	private PoiDao dao;
	
	/**
	 * Validações para a entidade POI
	 * @param entity
	 */
	private void validate(Poi entity)
	{
		if(entity.getNome()==null)
		{
			throw new RuntimeException("Nome não pode ser nulo");
		}
		if(entity.getCoordenadaX()==null)
		{
			throw new RuntimeException("Coordenada X não pode ser nula");
		}
		
		if(entity.getCoordenadaY()==null)
		{
			throw new RuntimeException("Coordenada Y não pode ser nula");
		}
	}
	
	@Override
	public void salvar(Poi entity) {
		validate(entity);
		entity.setDataInclusao(LocalDateTime.now());
		dao.salvar(entity);
	}

	@Override
	public List<Poi> listarPois() {
		return dao.listarPois();
	}

	@Override
	public List<Poi> listarPoisProximidade(PoiFilter filter) {
		return dao.listarPoisProximidade(filter);
	}

}
