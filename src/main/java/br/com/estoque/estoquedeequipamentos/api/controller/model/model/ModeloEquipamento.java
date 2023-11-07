package br.com.estoque.estoquedeequipamentos.api.controller.model.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ModeloEquipamento implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="modeloequipamento_sequence")
    @SequenceGenerator(name="modeloequipamento_sequence", sequenceName="modeloequipamento_sequence", allocationSize=100)
    private Long id;
    
    
}