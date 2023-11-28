package br.com.estoque.estoquedeequipamentos.api.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.estoque.estoquedeequipamentos.api.model.Equipamento;
import br.com.estoque.estoquedeequipamentos.api.model.ModeloEquipamento;
import br.com.estoque.estoquedeequipamentos.api.model.Usuario;
import br.com.estoque.estoquedeequipamentos.api.repository.EquipamentoRepository;
import br.com.estoque.estoquedeequipamentos.api.repository.ModeloEquipamentoRepository;
import br.com.estoque.estoquedeequipamentos.api.repository.UsuarioRepository;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/equipamento")
@AllArgsConstructor
public class EquipamentoController {

    private EquipamentoRepository repository;
    private ModeloEquipamentoRepository modeloEquipamentoRepository;
    private UsuarioRepository usuarioRepository;
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
    
    @GetMapping("listar-equipamento-disp")
    public ModelAndView listarModeloEquipamentoDisponivel() {
        ModelAndView mv = new ModelAndView("listar-equipamento-disp");
        List<Equipamento> equipamento = repository.findByLocatarioIsNull();
        
        mv.addObject("equipamentos", equipamento);
        return mv;
    }
    
    @GetMapping("listar-equipamento-indisp")
    public ModelAndView listarModeloEquipamentoIndisponivel() {
        ModelAndView mv = new ModelAndView("listar-equipamento-indisp");
        List<Equipamento> equipamento = repository.findByLocatarioIsNotNull();
        
        mv.addObject("equipamentos", equipamento);
        return mv;
    }

    @GetMapping("/cadastrar-equipamento")
    public ModelAndView cadastrar(Equipamento equipamento) {
        ModelAndView mv = new ModelAndView("cadastrar-equipamento");
        List<ModeloEquipamento> modeloDeEquipamento = modeloEquipamentoRepository.findAll();
        mv.addObject("modeloDeEquipamentos", modeloDeEquipamento);
        return mv;
    }

    @PostMapping("/cadastrar")
    public String cadastro(@Valid Equipamento equipamento, BindingResult resultado) {
        
        if (resultado.hasErrors()) {
            return "cadastrar-equipamento";
        }

        if(equipamento.getLocatario().getId() == 0){
            equipamento.setLocatario(null);
        }

        // if(equipamento.getLocatario() != null){
        //     repository.save(equipamento);
        //     return "redirect:listar-equipamento";

        // }

        repository.save(equipamento);
        return "redirect:listar-equipamento";
    }

    @PostMapping("/emprestar-equipamento")
    public ModelAndView emprestaEquipamento(Long id){
        ModelAndView mv = new ModelAndView("emprestar-equipamento");
        List<ModeloEquipamento> modeloDeEquipamento = modeloEquipamentoRepository.findAll();
        List<Usuario> usuarios = usuarioRepository.findAll();
        mv.addObject("equipamento", repository.getReferenceById(id));
        mv.addObject("modeloDeEquipamentos", modeloDeEquipamento);
        mv.addObject("usuarios", usuarios);
        return mv;
    }

    @PostMapping("/editar-equipamento")
    public ModelAndView editarEquipamento(Long id){
        ModelAndView mv = new ModelAndView("cadastrar-equipamento");
        List<ModeloEquipamento> modeloDeEquipamento = modeloEquipamentoRepository.findAll();
        mv.addObject("equipamento", repository.getReferenceById(id));
        mv.addObject("modeloDeEquipamentos", modeloDeEquipamento);
        return mv;
    }
    @PostMapping("/devolucao-equipamento")
    public ModelAndView devolucaoEquipamento(Long id){
        ModelAndView mv = new ModelAndView("devolucao-equipamento");
        List<ModeloEquipamento> modeloDeEquipamento = modeloEquipamentoRepository.findAll();
        mv.addObject("equipamento", repository.getReferenceById(id));
        mv.addObject("modeloDeEquipamentos", modeloDeEquipamento);
        return mv;
    }
}
