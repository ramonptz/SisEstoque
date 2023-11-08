package br.com.estoque.estoquedeequipamentos.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.estoque.estoquedeequipamentos.api.model.model.ModeloEquipamento;

@Repository
public interface ModeloEquipamentoRepository extends JpaRepository<ModeloEquipamento, Long> {

}
