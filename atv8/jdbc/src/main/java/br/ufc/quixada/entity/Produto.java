package br.ufc.quixada.entity;


import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Produto {
	private Integer id;
	private String codigo;
	private String descricao;
	private Double preco;
	private int qtd;
	private LocalDate data;	
}