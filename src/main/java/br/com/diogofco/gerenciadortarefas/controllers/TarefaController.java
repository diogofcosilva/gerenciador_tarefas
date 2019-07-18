package br.com.diogofco.gerenciadortarefas.controllers;

import br.com.diogofco.gerenciadortarefas.models.Tarefa;
import br.com.diogofco.gerenciadortarefas.repository.RepositoryTarefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Comparator;
import java.util.Date;

@Controller
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private RepositoryTarefa repositoryTarefa;

    @GetMapping("/listar")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("tarefas/listar");
        mv.addObject("tarefas", repositoryTarefa.findAll(Sort.by(Sort.Direction.DESC, "dataExpiracao")));
        return mv;
    }

    @GetMapping("/inserir")
    public ModelAndView inserir() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("tarefas/inserir");
        mv.addObject("tarefa", new Tarefa());
        return mv;
    }

    @PostMapping("/inserir")
    public ModelAndView inserir(@Valid Tarefa tarefa, BindingResult result) {
        ModelAndView mv = new ModelAndView();

        if (tarefa.getDataExpiracao() == null) {
            result.rejectValue("dataExpiracao", "tarefa.dataExpiracaoInvalida",
                    "A data de expiração é obrigatória.");
        } else {
            if (tarefa.getDataExpiracao().before(new Date())) {
                result.rejectValue("dataExpiracao", "tarefa.dataExpiracaoInvalida",
                        "A data de expiração não pode ser anterior a data atual.");
            }
        }

        if (result.hasErrors()) {
            mv.setViewName("tarefas/inserir");
            mv.addObject(tarefa);
        } else {
            mv.setViewName("redirect:/tarefas/listar");
            repositoryTarefa.save(tarefa);
        }
        return mv;
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView();
        Tarefa tarefa = repositoryTarefa.getOne(id);
        mv.addObject("tarefa", tarefa);
        mv.setViewName("tarefas/alterar");
        return mv;
    }

    @PostMapping("/alterar")
    public ModelAndView alterar(@Valid Tarefa tarefa, BindingResult result) {
        ModelAndView mv = new ModelAndView();

        if (tarefa.getDataExpiracao() == null) {
            result.rejectValue("dataExpiracao", "tarefa.dataExpiracaoInvalida",
                    "A data de expiração é obrigatória.");
        } else {
            if (tarefa.getDataExpiracao().before(new Date())) {
                result.rejectValue("dataExpiracao", "tarefa.dataExpiracaoInvalida",
                        "A data de expiração não pode ser anterior a data atual.");
            }
        }

        if (result.hasErrors()) {
            mv.setViewName("tarefas/alterar");
            mv.addObject(tarefa);
        } else {
            mv.setViewName("redirect:/tarefas/listar");
            repositoryTarefa.save(tarefa);
        }
        return mv;
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id) {
        repositoryTarefa.deleteById(id);
        return "redirect:/tarefas/listar";
    }

    @GetMapping("/concluir/{id}")
    public String concluir(@PathVariable("id") Long id) {
        Tarefa tarefa = repositoryTarefa.getOne(id);
        tarefa.setConcluida(true);
        repositoryTarefa.save(tarefa);
        return "redirect:/tarefas/listar";
    }
}
