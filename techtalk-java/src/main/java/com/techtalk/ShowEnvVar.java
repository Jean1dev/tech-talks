package com.techtalk;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ShowEnvVar {

    @Value("${techtalk.valor}")
    private String techTalkValor;

    @PostConstruct
    public void showEnv() {
        System.out.println(techTalkValor);
    }
}
