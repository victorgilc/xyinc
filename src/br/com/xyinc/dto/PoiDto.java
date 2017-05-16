package br.com.xyinc.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PoiDto {
	
	private String nome;

	private Long coordenadaX;
	
	private Long coordenadaY;
	
	private Long id;
	
	private LocalDateTime dataInclusao;
}
