package br.com.estoque.estoquedeequipamentos.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.estoque.estoquedeequipamentos.api.model.model.Equipamento;
import br.com.estoque.estoquedeequipamentos.api.model.model.ModeloEquipamento;
import br.com.estoque.estoquedeequipamentos.api.repository.EquipamentoRepository;
import br.com.estoque.estoquedeequipamentos.api.repository.ModeloEquipamentoRepository;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/equipamento")
@AllArgsConstructor
public class EquipamentoController {

    private EquipamentoRepository repository;
    private ModeloEquipamentoRepository modeloEquipamentoRepository;
    // @GetMapping("/123")
    // public String home(){
    // return "index";
    // }

    @GetMapping("listar-equipamento")
    public ModelAndView listarModeloEquipamento() {
        ModelAndView mv = new ModelAndView("listar-equipamento");
        List<Equipamento> equipamento = repository.findAll();
        
        mv.addObject("equipamentos", equipamento);
        return mv;
    }

    @GetMapping("/cadastrar-equipamento")
    public ModelAndView cadastrar(Equipamento equipamento) {
        ModelAndView mv = new ModelAndView("cadastrar-equipamento");
        List<ModeloEquipamento> modeloEquipamento = modeloEquipamentoRepository.findAll();
        mv.addObject("modeloEquipamentos", modeloEquipamento);
        return mv;
    }

    @PostMapping("/cadastrar")
    public String cadastro(@Valid Equipamento equipamento, BindingResult resultado) {
        if (resultado.hasErrors()) {
            return "cadastrar-equipamento";
        }
        repository.save(equipamento);
        return "redirect:listar-equipamento";
    }

}
