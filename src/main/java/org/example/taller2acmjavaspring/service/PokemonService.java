package org.example.taller2acmjavaspring.service;

import org.example.taller2acmjavaspring.dto.PokemonDto;
import org.example.taller2acmjavaspring.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;


@Service
public class PokemonService {

    private final WebClient webClient;

    @Autowired
    public PokemonService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<Pokemon> getPokemonData(String name) {
        return webClient.get()
                .uri("/pokemon/{name}", name.toLowerCase())
                .retrieve()
                .bodyToMono(Pokemon.class);
    }


    public Mono<PokemonDto> getPokemonDataCustom(String name) {
        return webClient.get()
                .uri("/pokemon/{name}", name.toLowerCase())
                .retrieve()
                .bodyToMono(Pokemon.class)
                .map(pokemon -> new PokemonDto(
                        pokemon.getName(),
                        pokemon.getWeight(),
                        pokemon.getAbilities().stream()
                                .map(ability -> ability.getAbility().getName())
                                .collect(Collectors.toList())
                ));

    }
}
