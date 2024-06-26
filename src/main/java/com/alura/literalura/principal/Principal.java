package com.alura.literalura.principal;

import com.alura.literalura.model.DadosLivros;
import com.alura.literalura.service.ConsumoApi;
import com.alura.literalura.service.ConverteDados;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private String endereco = "https://gutendex.com/books/?search=";
    private String livro;
    ConverteDados conversor = new ConverteDados();
    ConsumoApi consumo = new ConsumoApi();

    Scanner leitor = new Scanner(System.in);

    public void exibeMenu() {
        System.out.println("""
           *****************************************************
           -----------------------------------------------------
                     Bem vindo a Liter Alura!
           -----------------------------------------------------
           *****************************************************
           
           1 - Pesquisar um título
           2 - Sair
           
           """);
    }

    public void executaMenu (){
        boolean executar = true;
        while (executar) {
            exibeMenu();

            System.out.println("Selecione uma opção: ");
            int opcao = leitor.nextInt();

            switch (opcao) {
                case 1 -> mostraInformacoesLivro();
                case 0 -> executar = false;
            }
        }
    }

    public void mostraInformacoesLivro() {
        try {
            Scanner leitor1 = new Scanner(System.in);

            System.out.println("Digite o nome do livro que deseja pesquisar: ");
            livro = leitor1.nextLine();

            String json = consumo.obterDados(endereco + livro.toLowerCase().replace(" ", "+"));

            JsonNode rootNode = conversor.getObjectMapper().readTree(json);
            JsonNode resultado = rootNode.path("results");

            List<DadosLivros> dadosLivros = conversor.getObjectMapper()
                    .readerForListOf(DadosLivros.class)
                    .readValue(resultado);

            System.out.println(dadosLivros);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
