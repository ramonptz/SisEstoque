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
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

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
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="usuario_sequence")
    @SequenceGenerator(name="usuario_sequence", sequenceName="usuario_sequence", allocationSize=100)
    private Long id;
    @NotBlank
    @Length(max = 10, message = "O nome deve ter entre 1 e {max} caracteres22")
    private String primeiroNome;
    private String sobrenome;
    private Sexo sexo;
    private String cpf;
    private String nascimento;
    private String email;
    private String telefone;
    @OneToMany(mappedBy = "locatario", cascade = CascadeType.ALL)
    private List<Equipamento> equipamento;


    
    
}