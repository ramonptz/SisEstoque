package br.com.estoque.estoquedeequipamentos.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.estoque.estoquedeequipamentos.api.model.Equipamento;

@Repository
public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {

    List<Equipamento> findByAtiva(Boolean ativa);

    List<Equipamento> findByLocatarioIsNull();
    
    List<Equipamento> findByLocatarioIsNotNull();


}
