package controller;

import java.util.List;

import model.Clientes.ClientesBean;
import model.Clientes.ClientesDAO;

public class ClientesController {
    private ClientesDAO amigoDAO;

    public ClientesController(ClientesDAO amigoDAO) {
        this.amigoDAO = amigoDAO;
    }

    public void adicionarAmigo(String nome, String documento) {
        ClientesBean amigo = new ClientesBean();
        amigo.setNome(nome);
        amigo.setDocumento(documento);
        amigo.setStatus("ATIVO");
        amigoDAO.adicionarAmigo(amigo);
    }

    public List<ClientesBean> buscarTodosClientes() {
        return amigoDAO.listarClientes();
    }
}
