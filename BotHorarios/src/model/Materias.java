package model;

import java.util.HashMap;
import java.util.Map;

public class Materias {
	private Map<String,String> materias = new HashMap<String,String>();
	
	public void construindoMapa(){
		//Análise e Desenvolvimento de Sistemas
		materias.put("pmic", new String("Programação em Microinformática"));
		materias.put("adm", new String("Administração Geral"));
		materias.put("ingI", new String("Inglês I"));
		materias.put("md", new String("Matemática Discreta"));
		materias.put("labH", new String("Laboratório de Hardware"));
		materias.put("aoc", new String("Arquitetura e Organização de Computadores"));
		materias.put("alp", new String("Algoritmos e Lógica de Programação"));
		materias.put("con", new String("Comunicação e Expressão"));
		materias.put("engI", new String("Engenharia de Software I"));
		materias.put("cee", new String("Comunicação e Expressão"));
		materias.put("ingII", new String("Inglês II"));
		materias.put("si", new String("Sistemas de Informação"));
		materias.put("lp", new String("Linguagem de Programação"));
		materias.put("cal", new String("Cálculo"));
		materias.put("soI", new String("Sistemas Operacionais I"));
		materias.put("eco", new String("Economia e Finanças"));
		materias.put("ed", new String("Estruturas de Dados"));
		materias.put("engII", new String("Engenharia de Software II"));
		materias.put("set", new String("Sociedade e Tecnologia"));
		materias.put("ingIII", new String("Inglês III"));
		materias.put("ihc", new String("Interação Humano Computador"));
		materias.put("bd", new String("Banco de Dados"));
		materias.put("engIII", new String("Engenharia de Software III"));
		materias.put("ea", new String("Estatística Aplicada"));
		materias.put("ingIV", new String("Inglês IV"));
		materias.put("soII", new String("Sistemas Operacionais II"));
		materias.put("ts", new String("Teste de Software"));
		materias.put("mpct", new String("Metodologia da Pesquisa Científico-Tecnológica"));
		materias.put("pdm", new String("Programação para Dispositivos Móveis"));
		materias.put("labBD", new String("Laboratório de Banco de Dados"));
		materias.put("labENG", new String("Laboratório de Engenharia de Software"));
		materias.put("rdc", new String("Redes de Computadores"));
		materias.put("pla", new String("Programação Linear e Aplicações"));
		materias.put("ingV", new String("Inglês V"));
		materias.put("tgI", new String("Trabalho de Graduação I"));
		materias.put("sgi", new String("Segurança da Informação"));
		materias.put("ia", new String("Inteligência Artificial"));
		materias.put("tei", new String("Tópicos Especiais em Informática"));
		materias.put("tgII", new String("Trabalho de Graduação II"));
		materias.put("ggti", new String("Gestão e Governança de Tec. da Informação"));
		materias.put("emp", new String("Empreendedorismo"));
		materias.put("gp", new String("Gestão de Projetos"));
		materias.put("ge", new String("Gestão de Equipes"));
		materias.put("erp", new String("Ética e Responsabilidade Profissional"));
		materias.put("ingVI", new String("Inglês VI"));
	}

	public String getMateria(Object mat) {
		return materias.get(mat);
	}
}
