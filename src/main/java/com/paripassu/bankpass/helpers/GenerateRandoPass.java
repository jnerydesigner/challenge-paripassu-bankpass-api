package com.paripassu.bankpass.helpers;

import java.util.Random;

import org.springframework.web.bind.annotation.PathVariable;

public class GenerateRandoPass {
  public String tickets(@PathVariable("type") String type) {
    Random random = new Random();
    int numero1 = random.nextInt(9);
    if (numero1 == 0) {
      numero1 = 1;
    }
    int numero2 = random.nextInt(9);
    int numero3 = random.nextInt(9);
    int numero4 = random.nextInt(9);

    String numero = type + String.valueOf(numero1) + String.valueOf(numero2) + String.valueOf(numero3)
        + String.valueOf(numero4);

    return numero;
  }
}
