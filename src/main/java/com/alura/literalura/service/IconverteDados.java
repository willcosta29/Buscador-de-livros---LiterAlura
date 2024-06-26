package com.alura.literalura.service;

public interface IconverteDados {
    <T> T obterDados(String json, Class<T> classe);
}