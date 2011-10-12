package br.com.plano2.cadastro.controller;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.plano2.cadastro.dao.ClienteDao;
import br.com.plano2.cadastro.modelo.Cliente;

@Resource
public class ClienteController {

	private ClienteDao dao;
	private Result result;

	public ClienteController(Result result, ClienteDao dao) {
		this.dao = dao;
		this.result = result;
	}

	@Path("/formulario")
	@Get
	public void formulario() {
	}

	@Path("/cliente")
	@Post
	public void adicionar(Cliente cliente) {
		dao.save(cliente);
		result.redirectTo(ClienteController.class).lista();
	}

	@Path("/cliente/{id}")
	@Get
	public void editar(Integer id) {
		result.include("cliente", dao.findById(id));
	}

	@Path("/cliente/{id}")
	@Put
	public void alterar(Cliente cliente) {
		dao.update(cliente);
		result.redirectTo(ClienteController.class).lista();
	}

	@Path("/cliente/{id}")
	@Delete
	public void excluir(Integer id) {
		dao.delete(id);
		result.redirectTo(ClienteController.class).lista();
	}

	@Path("/cliente")
	@Get
	public void lista() {
		result.include("clientes", dao.findAll());
	}

}
