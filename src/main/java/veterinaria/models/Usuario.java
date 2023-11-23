package veterinaria.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nombre", length = 25, nullable = false)
    private String nombre;
    
    @Column(name = "apellido", length = 25, nullable = false)
    private String apellido;
    
    @Column(name = "tipo_documento", length = 2, nullable = false)
    private String tipoDocumento;
   
    @Column(name = "documento_identificacion", nullable = false)
    private int documentoIdentificacion;
    
    @Column(name = "sexo", length = 6, nullable = false)
    private String sexo;
    
}
