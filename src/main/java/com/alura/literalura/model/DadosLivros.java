package com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivros (@JsonAlias("title") String titulo,
                           @JsonAlias("authors") List<DadosAutor> autor,
                           @JsonAlias("languages") List<String> idioma,
                           @JsonAlias("download_count") Double Download) {

    @Override
    public String toString() {
        return  "\n>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<" +
                "\n Titulo: " + titulo.toUpperCase() +
                "\n" + autor +
                "\n Idioma: " + idioma +
                "\n Download: " + Download +
                "\n>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<";
    }
}
