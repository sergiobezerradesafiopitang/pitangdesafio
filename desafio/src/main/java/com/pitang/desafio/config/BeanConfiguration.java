package com.pitang.desafio.config;

import com.pitang.desafio.repository.IUsuarioRepository;
import com.pitang.desafio.validation.Validacoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Bean
    public Validacoes getValidacoes(){
        return new Validacoes(this.usuarioRepository);
    }

}
