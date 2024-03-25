package Client;

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

/*
esta clase representa el model del cliente el cual 
contiene los atributos necesarios y los metodos para 
acceder y modificar sus atributos*
 */
public class ClientModel {

    private Long id;
    private String name;
    private String lastName;
    private String phone;
    //private String category;

    public ClientModel() {
    }

    public ClientModel(Long id, String name, String lastName, String phone) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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