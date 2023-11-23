package br.com.estoque.estoquedeequipamentos.api.model.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;


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
    private String sn;

    // @ManyToOne(targetEntity = ModeloEquipamento.class, fetch = FetchType.LAZY)
	// @JoinColumn(name = "ID_M_MODELO_EQUIPAMENTO", nullable = false)
	// private ModeloEquipamento modeloEquipamento;
    
    
}