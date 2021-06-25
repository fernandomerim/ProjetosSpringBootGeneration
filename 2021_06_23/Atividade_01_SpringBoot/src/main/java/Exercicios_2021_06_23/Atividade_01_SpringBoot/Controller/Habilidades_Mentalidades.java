package Exercicios_2021_06_23.Atividade_01_SpringBoot.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Habilidades_Mentalidades {

	@RequestMapping("/habilidade_mentalidade")
	public String habilidade_mentalidade() {
		return "A habilidade utilizada é: Atenção aos detalhes. <br>A mentalidade utilizada é: Persistência.";
	}
		
}
