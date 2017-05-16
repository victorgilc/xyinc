package br.com.xyinc.dao.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import br.com.xyinc.dao.PoiDao;
import br.com.xyinc.entity.Poi;
import br.com.xyinc.filter.PoiFilter;

public class PoiDaoImpl extends AbstractDAO<Poi> implements PoiDao{
	
	@Override
	public void salvar(Poi entity)
	{
		save(entity);
	}
	
	@Override
	public List<Poi> listarPois()
	{
		return findAll();
	}
	
	@Override
	public List<Poi> listarPoisProximidade(PoiFilter filter)
	{
		StringBuilder query = new StringBuilder("select p FROM Poi p ");
		query.append("WHERE p.coordenadaX >= :inicioX and p.coordenadaX <= :fimX and ");
		query.append("p.coordenadaY >= :inicioY and p.coordenadaY <= :fimY");
		
		Map parametros = new HashMap<>();
		parametros.put("inicioX", filter.getCoordenadaX());
		parametros.put("fimX", filter.getCoordenadaX()+filter.getDMax());
		
		parametros.put("inicioY", filter.getCoordenadaY());
		parametros.put("fimY", filter.getCoordenadaY()+filter.getDMax());
		
		return findList(query.toString(), parametros);
	}

	@Override
	public Class<Poi> getType() {
		return Poi.class;
	}
}
