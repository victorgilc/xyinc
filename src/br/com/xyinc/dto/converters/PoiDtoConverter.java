package br.com.xyinc.dto.converters;

import br.com.xyinc.dto.PoiDto;
import br.com.xyinc.entity.Poi;

/**
 * Reponsavel por realizar a conversao dto entity e vice-versa
 *
 */
public class PoiDtoConverter {
	/**
	 * Converte uma entidade para um DTO
	 * @param entity
	 * @return o DTO
	 */
	public static PoiDto convertToDto(Poi entity)
	{
		PoiDto dto = new PoiDto();
		dto.setId(entity.getId());
		dto.setNome(entity.getNome());
		dto.setCoordenadaX(entity.getCoordenadaX());
		dto.setCoordenadaY(entity.getCoordenadaY());
		dto.setDataInclusao(entity.getDataInclusao());
		return dto;
	}
	
	/**
	 * Converte um DTO para uma entidade
	 * @param dto
	 * @return a entidade
	 */
	public static Poi convertToEntity(PoiDto dto)
	{
		Poi entity = new Poi();
		entity.setNome(dto.getNome());
		entity.setCoordenadaX(dto.getCoordenadaX());
		entity.setCoordenadaY(dto.getCoordenadaY());
		return entity;
	}
}

