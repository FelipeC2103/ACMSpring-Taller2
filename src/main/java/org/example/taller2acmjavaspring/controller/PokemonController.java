package org.example.taller2acmjavaspring.controller;


import org.example.taller2acmjavaspring.dto.PokemonDto;
import org.example.taller2acmjavaspring.model.Pokemon;
import org.example.taller2acmjavaspring.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
    private  final PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/{name}")
    public Mono<Pokemon> getPokemonData(@PathVariable String name){
        return pokemonService.getPokemonData(name);
    }

    @GetMapping("/custom/{name}")
    public Mono<PokemonDto> getPokemonDataCustom(@PathVariable String name){
        return pokemonService.getPokemonDataCustom(name);
    }
}
