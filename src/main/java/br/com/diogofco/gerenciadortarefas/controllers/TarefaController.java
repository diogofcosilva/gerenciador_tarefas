package br.com.diogofco.gerenciadortarefas.controllers;

import br.com.diogofco.gerenciadortarefas.repository.RepositoryTarefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private RepositoryTarefa repositoryTarefa;

    @GetMapping("/listar")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("tarefas/listar");
        mv.addObject("tarefas", repositoryTarefa.findAll());
        return mv;
    }
}
