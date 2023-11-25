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

import br.com.estoque.estoquedeequipamentos.api.model.model.Usuario;
import br.com.estoque.estoquedeequipamentos.api.repository.UsuarioRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/usuario")
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
    public ModelAndView cadastrar(Usuario usuario){
        ModelAndView mv = new ModelAndView("cadastrar-usuario");
        return mv;
    }

    @PostMapping("/cadastrar")
    public String cadastro(@Valid Usuario usuario, BindingResult resultado){
        
        if(resultado.hasErrors()) {
            return "cadastrar-usuario";
        }
        
        System.out.println("teste de cadastro:" + usuario.getNascimento());
        usuarioRepository.save(usuario);
        return "redirect:/usuario/listar-usuarios";
    }

    @PostMapping("/editar-usuario")
    public ModelAndView editarUsuario(Long id){
        ModelAndView mv = new ModelAndView("cadastrar-usuario");
        // Usuario usuarioLocalizado = usuarioRepository.getReferenceById(id);
        mv.addObject("usuario", usuarioRepository.getReferenceById(id));
        return mv;
    }

    @DeleteMapping("/excluir/{id}")
    public String excluirUsuario(@PathVariable(required = true) Long id){
        usuarioRepository.deleteById(id);
        return "redirect:/usuario/listar-usuarios";
    }
}
