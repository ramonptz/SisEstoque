package br.com.estoque.estoquedeequipamentos.api.model.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Historico implements Serializable {
    @Id
    private Long id;
    private Equipamento equipamento;
    private LocalDate dataSaida;
    private LocalDate dataEntrada;
}