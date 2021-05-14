package br.com.store.controller;

import br.com.store.constant.Constant;
import br.com.store.model.Avaliacao;
import br.com.store.model.Product;
import br.com.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class AvaliacaoController {

    @Autowired
    private ProductService productService;

    @PostMapping(Constant.API_AVALIA)
    public void save(@RequestBody Avaliacao avaliacao){
        productService.sendProductRabbit(avaliacao);
    }

    @GetMapping(Constant.API_AVALIA)
    public List<Avaliacao> findAll(){
        return productService.findAll();
    }

    @PutMapping(Constant.API_AVALIA)
    public void update (@RequestBody Avaliacao avaliacao){
        productService.save(avaliacao);
    }

    @DeleteMapping(Constant.API_AVALIA + "/{id}")
    public void delete(@PathVariable("id") String id){
        productService.delete(id);
    }

    @GetMapping(Constant.API_AVALIA + "/{id}")
    public Optional<Avaliacao> findById(@PathVariable("id") String id){
        return productService.findById(id);
    }
}
