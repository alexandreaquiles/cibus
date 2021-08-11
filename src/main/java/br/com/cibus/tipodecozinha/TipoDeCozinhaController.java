package br.com.cibus.tipodecozinha;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Controller
public class TipoDeCozinhaController {

    private final TipoDeCozinhaRepository tipoDeCozinhaRepository;

    public TipoDeCozinhaController(TipoDeCozinhaRepository tipoDeCozinhaRepository) {
        this.tipoDeCozinhaRepository = tipoDeCozinhaRepository;
    }

    @GetMapping("/admin/tipos-de-cozinha")
    public String lista(Model model) {
        List<TipoDeCozinha> tiposDeCozinha = tipoDeCozinhaRepository.findByOrderByNomeAsc();
        model.addAttribute("tiposDeCozinha", tiposDeCozinha);
        return "tipo-de-cozinha/listagem";
    }

    @GetMapping("/admin/tipos-de-cozinha/novo")
    public String formularioAdicionar() {
        return "tipo-de-cozinha/formulario-adicionar";
    }

    @PostMapping("/admin/tipos-de-cozinha/novo")
    public String adiciona(@Valid TipoDeCozinhaParaAdicaoForm tipoDeCozinhaParaAdicaoForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "tipo-de-cozinha/formulario-adicionar";
        }

        TipoDeCozinha tipoDeCozinha = tipoDeCozinhaParaAdicaoForm.toEntity();
        tipoDeCozinhaRepository.save(tipoDeCozinha);
        return "redirect:/admin/tipos-de-cozinha";
    }

    @GetMapping("/admin/tipos-de-cozinha/edicao/{id}")
    public String formularioEditar(@PathVariable("id") Long id, Model model) {
        TipoDeCozinha tipoDeCozinha = tipoDeCozinhaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
        model.addAttribute("tipoDeCozinha", tipoDeCozinha);
        return "tipo-de-cozinha/formulario-editar";
    }

    @PostMapping("/admin/tipos-de-cozinha/edicao/{id}")
    public String edita(@Valid TipoDeCozinhaParaEdicaoForm tipoDeCozinhaForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return formularioEditar(tipoDeCozinhaForm.getId(), model);
        }

        TipoDeCozinha tipoDeCozinha = tipoDeCozinhaForm.toEntity(tipoDeCozinhaRepository::findById);
        tipoDeCozinhaRepository.save(tipoDeCozinha);

        return "redirect:/admin/tipos-de-cozinha";
    }

    @PostMapping("/admin/tipos-de-cozinha/remocao/{id}")
    public String remover(@PathVariable("id") Long id) {
        tipoDeCozinhaRepository.deleteById(id);
        return "redirect:/admin/tipos-de-cozinha";
    }
}
