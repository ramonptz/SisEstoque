package br.com.estoque.estoquedeequipamentos.api.model.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import br.com.estoque.estoquedeequipamentos.api.enums.Sexo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="modeloequipamento_sequence")
    @SequenceGenerator(name="modeloequipamento_sequence", sequenceName="modeloequipamento_sequence", allocationSize=100)
    private Long id;
    private String primeiroNome;
    private String sobrenome;
    private Sexo sexo;
    private String cpf;
    private String nascimento;
    private String email;


    
    
}