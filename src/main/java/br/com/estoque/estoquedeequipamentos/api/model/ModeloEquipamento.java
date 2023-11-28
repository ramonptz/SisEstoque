package br.com.estoque.estoquedeequipamentos.api.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

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