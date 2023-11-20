package veterinaria.models;

// Indica que la clase es una entidad que se mapeará a una tabla en la base de datos.
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.CascadeType;
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
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
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

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Usuario usuario;
    
    @OneToOne(mappedBy = "mascota", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private HistoriaClinica historiaClinica;


}
