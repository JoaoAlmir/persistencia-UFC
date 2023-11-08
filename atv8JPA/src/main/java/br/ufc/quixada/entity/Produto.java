package br.ufc.quixada.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Produto {

	public Produto(int id) {
		this.id = id;
	}

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;

	@Column(unique=true)
	private String codigo;
	private String descricao;
	private Double preco;
	private int qtd;

	@GeneratedValue(strategy=GenerationType.AUTO)

	private LocalDate data;		
}
