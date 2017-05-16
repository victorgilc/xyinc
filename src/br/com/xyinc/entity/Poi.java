package br.com.xyinc.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * Entidade para Pontos de Interesse
 *
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Table(name=Poi.TABLE_NAME)
public class Poi implements IModel{
	
	/**
	 * Nome da tabela
	 */
	static final String TABLE_NAME="poi";
	
	/**
	 * Nome das colunas
	 */
	private static final String COLUNA_ID = "id";
	private static final String COLUNA_NOME = "nome";
	private static final String COLUNA_COORDENADA_X = "coordenada_x";
	private static final String COLUNA_COORDENADA_Y = "coordenada_y";
	private static final String COLUNA_DATA_INCLUSAO = "data_inclusao";

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name=COLUNA_ID)
	private Long id;
	
	@Column(name=COLUNA_NOME)
	@NotNull
	private String nome;
	
	@Column(name=COLUNA_COORDENADA_X)
	@NotNull
	private Long coordenadaX;
	
	@Column(name=COLUNA_COORDENADA_Y)
	@NotNull
	private Long coordenadaY;
	
	@Column(name=COLUNA_DATA_INCLUSAO)
	@NotNull
	private LocalDateTime dataInclusao;
	
	@Override
	public Long getId() {
		return this.id;
	}
}
