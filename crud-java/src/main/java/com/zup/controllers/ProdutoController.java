package com.zup.controllers

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @PostMapping
    private List<Map<String, Object> createProduct(@RequestBody Map<String, Object> payload){
        if (!payload.containsKey("nome") || !payload.containsKey(("data_criacao")|| !payload.containsKey("quantidade_disponivel"))) {
            throw new IllegalArgumentException("Os campos 'nome', 'data_criacao' e 'quantiade_disponivel' sao obrigatorios.");
            
        }
        Map<String, Object> novoProduto = new HashMap<>();
        novoProduto.put("id", UUID.randomUUID().toString());
        novoProduto.put("nome", payload.get("nome"));
        novoProduto.put("data_criacao", payload.get("data_criacao"));
        novoProduto.put("quantidade_disponivel", payload.get("quantidade_criacao"));
        produtos.add(novoProduto);
        return novoProduto;
    }

    @GetMapping
    public Map<String, Object> getProduto(@PathVariable String id) {
        return produtos.stream().filter(p -> p.get("id").equals(id)).findFirst().orElseThrow(() -> new NoSuchElementException("Produto nao encontrado"));
    }
    
    
}
