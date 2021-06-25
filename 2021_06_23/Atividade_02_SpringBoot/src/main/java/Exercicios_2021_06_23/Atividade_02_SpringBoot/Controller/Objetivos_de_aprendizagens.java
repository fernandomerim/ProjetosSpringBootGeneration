package Exercicios_2021_06_23.Atividade_02_SpringBoot.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

	@RestController
	public class Objetivos_de_aprendizagens {

		@RequestMapping("/objetivos")
		public String objetivos() {
			return "O objetivo de aprendizagem para essa semana será o SpringBoot.";
		}

}
