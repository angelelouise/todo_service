package br.ufrn.ws.todoservice.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaudacaoResources {

		@RequestMapping("/saudacao")
		public String saudacao() {
			return "Ola";
		}
}
