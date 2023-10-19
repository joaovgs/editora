package view;

import java.util.List;

import model.Clientes.ClientesBean;

public class ClientesView {

    public void exibirClientes(List<ClientesBean> Clientes) {
        for (ClientesBean amigo : Clientes) {
            System.out.println("ID: " + amigo.getId());
            System.out.println("Nome: " + amigo.getNome());
            System.out.println("Documento: " + amigo.getDocumento());
            System.out.println("Status: " + amigo.getStatus());
            System.out.println("----------------------");
        }
    }
}
