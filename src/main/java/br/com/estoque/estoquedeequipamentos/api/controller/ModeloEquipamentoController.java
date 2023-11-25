package br.com.estoque.estoquedeequipamentos.api.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.estoque.estoquedeequipamentos.api.model.model.ModeloEquipamento;
import br.com.estoque.estoquedeequipamentos.api.model.model.Usuario;
import br.com.estoque.estoquedeequipamentos.api.repository.ModeloEquipamentoRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("modelo-equipamento")
public class ModeloEquipamentoController {
    private ModeloEquipamentoRepository repository;


    @GetMapping("listar-modelo-equipamento")
    public ModelAndView listarModeloEquipamento(){
        ModelAndView mv = new ModelAndView("listar-modelo-equipamento");
        List<ModeloEquipamento> modeloDeEquipamento = repository.findAll();
        //passar objeto
        mv.addObject("modeloDeEquipamentos", modeloDeEquipamento);
        return mv;
    }

    @GetMapping("/cadastrar-modelo-equipamento")
    public String cadastrar(ModeloEquipamento modeloEquipamento){
        return "cadastrar-modelo-equipamento";
    }


    @PostMapping("/cadastrar")
    public String cadastro(@Valid ModeloEquipamento modeloEquipamento, BindingResult resultado){
        System.out.println(modeloEquipamento.getPreco());

        if(resultado.hasErrors()) {
            return "cadastrar-modelo-equipamento";
        }

        repository.save(modeloEquipamento);
        return "redirect:listar-modelo-equipamento";
    }

    

    // @DeleteMapping("/excluir/{id}")
    // public String excluirUsuario(@PathVariable("id") Long id){
    //     repository.deleteById(id);
    //     return "redirect:/equipamento/listar-modelo-equipamento";
    // }
}
