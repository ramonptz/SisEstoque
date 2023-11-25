package br.com.estoque.estoquedeequipamentos.api.controller.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.servlet.http.HttpServletRequest;

    @ControllerAdvice
public class RequestDataControllerAdvice {

    @ModelAttribute
    public void addRequestUriToModel(Model model, HttpServletRequest request) {
        model.addAttribute("requestURI", request.getRequestURI());
    }
}
