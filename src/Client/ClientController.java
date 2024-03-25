package Client;

import Config.Connector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Connection;

/**
 *
 * @author Jhonatan Samuel Martinez Hernandez ficha 2675859
 *
 * Evidencia de desempeño:
 *
 * Codificación de módulos del software según requerimientos del proyecto
 * GA7-220501096-AA2-EV01
 *
 * análisis y desarrollo de software
 *
 */
public class ClientController {

    // I create here a field for connector class
    Connector connector;

    PreparedStatement ps;
    ResultSet rs;
    Connection conn;

    public ClientController() {
    }
    
   

    // method for adding the connector class for the data base
    public void addConnector(Connector connector) {
        this.connector = connector;
    }

    // Save data of a new client in the data base 
    public void saveClient(ClientModel client) {

        try {
            String sql = "insert into client (name, lastName, phone) values(?, ?, ?)";
            conn = this.connector.start();
            ps = conn.prepareStatement(sql);

            ps.setString(1, client.getName());
            ps.setString(2, client.getLastName());
            ps.setString(3, client.getPhone());

            rs = ps.executeQuery();
            System.out.println("User created successfully");
            JOptionPane.showMessageDialog(null, "User created successfully");

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Error when creating user");

            System.out.println("Error al create usuario" + sqle.getMessage());
        }

    }

    // get all  the clients registered in the data base
    public List<ClientModel> getAllClients() {

        List<ClientModel> clientsList = new ArrayList<>();

        try {
            // create the sql
            String sql = "select * from client";

            // connect to data base here
            conn = this.connector.start();
            // Execute the sql 
            ps = conn.prepareStatement(sql);
            // get the result
            rs = ps.executeQuery();
            while (rs.next()) {
                // instantiate a new client 
                ClientModel client = new ClientModel();
                // get the values of each column and 
                //assign them to their corresponding atribute of the client model
                client.setId(rs.getLong("clientId"));
                client.setName(rs.getString("name"));
                client.setLastName(rs.getString("lastName"));
                client.setPhone(rs.getString("phone"));
                // add the client to the list 
                clientsList.add(client);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientsList;
    }

    // Update a especific client by its
    public ClientModel UpdateClient(ClientModel clientTemp) {

        // execute update operation
        try {
            String sql = "update client set name = ?, lastName = ?, phone = ? where clientId = ?";
            conn = this.connector.start();
            ps = conn.prepareStatement(sql);

            ps.setString(1, clientTemp.getName());
            ps.setString(2, clientTemp.getLastName());
            ps.setString(3, clientTemp.getPhone());
            ps.setLong(4, clientTemp.getId());

            rs = ps.executeQuery();
            System.out.println("User information modified successfully");
            JOptionPane.showMessageDialog(null, "User information modified successfully");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error modifing user");

            System.out.println("Error when trying to modify user data " + ex.getMessage());
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);

        }
        return clientTemp;
    }

    // Delets a client by its corresponding id
    public void deleteClientById(Long id, String name) {
// execute update operation
        try {
            String sql = "delete from client where client.clientId = ?";
            conn = this.connector.start();
            ps = conn.prepareStatement(sql);

            ps.setLong(1, id);

            rs = ps.executeQuery();
            System.out.println("User " + name + " with id: " + id + " deleted successfully");
            JOptionPane.showMessageDialog(null, "User " + name + " with id: " + id + " deleted successfully");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error when trying to Delete user data");

            System.out.println("Error when trying to Delete user data " + ex.getMessage());
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
}

/**
 *
 * @author Jhonatan Samuel Martinez Hernandez 
 * ficha 2675859 
 * 
 * Evidencia de desempeño:
 * 
 * Codificación de módulos del software según requerimientos del proyecto GA7-220501096-AA2-EV01
*
 * análisis y desarrollo de software 
 * 
 */
