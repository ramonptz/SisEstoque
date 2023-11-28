package br.com.estoque.estoquedeequipamentos.api.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Equipamento implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "modeloEquipamento_id")
    private ModeloEquipamento modeloEquipamento;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario locatario;
    // private Historico historico;
    private Boolean ativa = true;
    //serial number
    private String sn;

    // @ManyToOne(targetEntity = ModeloEquipamento.class, fetch = FetchType.LAZY)
	// @JoinColumn(name = "ID_M_MODELO_EQUIPAMENTO", nullable = false)
	// private ModeloEquipamento modeloEquipamento;
    
    
}