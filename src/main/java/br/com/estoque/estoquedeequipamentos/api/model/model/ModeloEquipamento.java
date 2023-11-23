package br.com.estoque.estoquedeequipamentos.api.model.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nomeEquipamento;
    private String lote;
    @OneToMany(mappedBy = "modeloEquipamento", cascade = CascadeType.ALL)
    private List<Equipamento> equipamento;
    private String pn;
    private Double preco;

    
    
}