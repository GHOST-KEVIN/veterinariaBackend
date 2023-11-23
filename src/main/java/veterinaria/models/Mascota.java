package veterinaria.models;

// Indica que la clase es una entidad que se mapeará a una tabla en la base de datos.
import javax.persistence.Entity;
// Especifica cómo se generan los valores para la columna principal de una entidad.
import javax.persistence.GeneratedValue;
// Define la estrategia de generación del valor principal. Las estrategias comunes incluyen AUTO, IDENTITY, SEQUENCE y TABLE.
import javax.persistence.GenerationType;
// Define la columna principal de una entidad.
import javax.persistence.Id;
// Especifica detalles sobre la tabla a la que se mapeará una entidad.
import javax.persistence.Table;
// Especifica detalles sobre las columnas a las que se mapearán los campos de una entidad.
import javax.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mascota")
public class Mascota {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nombre", length = 15, nullable = false)
    private String nombre;
    
    @Column(name = "raza", length = 20, nullable = true)
    private String raza;
    
    @Column(name = "sexo", length = 15, nullable = false)
    private String sexo;

    @Column(name = "usuario_id", nullable = false)
    private int usuarioId;

}
