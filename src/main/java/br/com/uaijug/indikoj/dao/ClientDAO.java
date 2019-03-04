package br.com.uaijug.indikoj.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.uaijug.indikoj.model.domain.Company;

@Repository
public class ClientDAO {
	private List<Company> clientes = new ArrayList<>();

	public void salvar(Company cliente) {
		clientes.add(cliente);
	}

	public void alterar(int id, Company cliente) {
		clientes.set(id, cliente);
	}

	public void delete(int id) {
		clientes.remove(id);
	}

	public List<Company> listar() {
		return clientes;
	}

	public static void main(String[] args) {
		Company cliente = new Company();
		cliente.setName("Rogerio Fontes");
		cliente.setEmail("root@localhost.com");

		Company cliente2 = new Company();
		cliente2.setName("Rogerio Fontes");
		cliente2.setEmail("root@localhost.com");

		ClientDAO dao = new ClientDAO();
		dao.salvar(cliente);
		dao.salvar(cliente2);
		
		Company clienteALt = new Company();
		clienteALt.setName("Rogerio Fontes- Alterado");
		clienteALt.setEmail("root@localhost.com");
		
		dao.alterar(1, clienteALt);
		
		dao.delete(0);

		List<Company> resultadoDaLista = dao.listar();

		for (Company c : resultadoDaLista) {
			System.out.println(c.toString());
		}

	}
}
