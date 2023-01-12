package br.com.cod3r.bridge.converter;

import br.com.cod3r.bridge.converter.converters.CSVConverter;
import br.com.cod3r.bridge.converter.converters.Converter;
import br.com.cod3r.bridge.converter.converters.JsonConverter;
import br.com.cod3r.bridge.converter.employees.ITGuy;
import br.com.cod3r.bridge.converter.employees.ProjectManager;

public class Client {

	public static void main(String[] args) {
		Converter csvConverter = new CSVConverter();
		Converter jsonConverter = new JsonConverter();

		ITGuy it = new ITGuy("Marcio Silva", 34, 6400d);
		ProjectManager pm = new ProjectManager("Aurelio Morais", 41, 7500d);

		System.out.println(csvConverter.getEmployeeFormated(it));
		System.out.println(jsonConverter.getEmployeeFormated(it));
		System.out.println(csvConverter.getEmployeeFormated(pm));
		System.out.println(jsonConverter.getEmployeeFormated(pm));
	}
}
