package br.com.estoque.estoquedeequipamentos.api.model.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ModeloEquipamento implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="modeloequipamento_sequence")
    @SequenceGenerator(name="modeloequipamento_sequence", sequenceName="modeloequipamento_sequence", allocationSize=100)
    private Long id;
    private String nomeEquipamento;
    private String sn;
    private String lote;

    
    
}