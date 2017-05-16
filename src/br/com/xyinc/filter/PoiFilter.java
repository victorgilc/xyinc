package br.com.xyinc.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


/**
 * Filtro para a entidade POI
 *
 */
@Getter
@Setter
@AllArgsConstructor
public class PoiFilter {
	private Long coordenadaX;
	
	private Long coordenadaY;
	
	private Long dMax;
}
