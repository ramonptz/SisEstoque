package br.com.estoque.estoquedeequipamentos.api.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.estoque.estoquedeequipamentos.api.model.model.ModeloEquipamento;
import br.com.estoque.estoquedeequipamentos.api.model.model.Usuario;
import br.com.estoque.estoquedeequipamentos.api.repository.ModeloEquipamentoRepository;
import br.com.estoque.estoquedeequipamentos.api.repository.UsuarioRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("usuario")
public class UsuariosController {
    private UsuarioRepository usuarioRepository;

    @GetMapping("listar-usuarios")
    public ModelAndView listarModeloEquipamento(){
        ModelAndView mv = new ModelAndView("listar-usuarios");
        List<Usuario> usuarios = usuarioRepository.findAll();
        //passar objeto
        mv.addObject("usuarios", usuarios);
        return mv;
    }

    @GetMapping("/cadastrar-usuario")
    public String cadastrar(Usuario usuario){
        return "cadastrar-usuario";
    }

    @PostMapping("/cadastrar")
    public String cadastro(Usuario usuario){
        usuarioRepository.save(usuario);
        return "redirect:listar-usuarios";
    }
}
