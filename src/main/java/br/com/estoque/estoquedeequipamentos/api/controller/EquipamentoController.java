package br.com.estoque.estoquedeequipamentos.api.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.estoque.estoquedeequipamentos.api.model.model.ModeloEquipamento;
import br.com.estoque.estoquedeequipamentos.api.repository.ModeloEquipamentoRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("equipamento")
public class EquipamentoController {
    private ModeloEquipamentoRepository repository;


    @GetMapping("listar-modelo-equipamento")
    public ModelAndView listarModeloEquipamento(){
        ModelAndView mv = new ModelAndView("listar-modelo-equipamento");
        List<ModeloEquipamento> equipamento = repository.findAll();
        //passar objeto
        mv.addObject("equipamentos", equipamento);
        return mv;
    }

    @GetMapping("/cadastrar-modelo-equipamento")
    public String cadastrar(ModeloEquipamento modeloEquipamento){
        return "cadastrar-modelo-equipamento";
    }

    @PostMapping("/cadastrar")
    public String cadastro(ModeloEquipamento modeloEquipamento){
        repository.save(modeloEquipamento);
        return "redirect:listar-modelo-equipamento";
    }

    // @DeleteMapping("/excluir/{id}")
    // public String excluirUsuario(@PathVariable("id") Long id){
    //     repository.deleteById(id);
    //     return "redirect:/equipamento/listar-modelo-equipamento";
    // }
}
