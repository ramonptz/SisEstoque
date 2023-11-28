package br.com.estoque.estoquedeequipamentos.api.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

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