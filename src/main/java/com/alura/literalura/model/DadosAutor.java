package com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DadosAutor(@JsonAlias("name") String nome,
                         @JsonAlias("birth_year") String nascimento,
                         @JsonAlias("death_year") String morte) {

    @Override
    public String toString() {
        return  "-----------------------------" +
                "\nNome: " + nome.toUpperCase() +
                "\nAno de nascimento: " + nascimento +
                ", Ano da morte: " + morte +
                "\n-----------------------------";
    }
}
