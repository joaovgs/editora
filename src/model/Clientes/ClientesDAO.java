package model.Clientes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import service.Database;

public class ClientesDAO {
    private Connection connection;

    public ClientesDAO() {
        this.connection = Database.connect();
    }

    public void adicionarAmigo(ClientesBean amigo) {
        String sql = "INSERT INTO Clientes (nome, documento, status) VALUES (?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, amigo.getNome());
            preparedStatement.setString(2, amigo.getDocumento());
            preparedStatement.setString(3, amigo.getStatus());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ClientesBean> listarClientes() {
        List<ClientesBean> Clientes = new ArrayList<>();
        String sql = "SELECT * FROM Clientes";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ClientesBean amigo = new ClientesBean();
                amigo.setId(resultSet.getInt("id"));
                amigo.setNome(resultSet.getString("nome"));
                amigo.setDocumento(resultSet.getString("documento"));
                Clientes.add(amigo);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Clientes;
    }
}
