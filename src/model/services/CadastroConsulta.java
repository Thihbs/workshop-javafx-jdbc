package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entities.Cadastro;

public class CadastroConsulta {

public List<Cadastro> findAll() {
	List<Cadastro> list = new ArrayList<>();
	list.add(new Cadastro(1,"Thiago"));
	list.add(new Cadastro(2,"Fabiana"));
	list.add(new Cadastro(3,"Rodrigo"));
	return list;
	};

}
