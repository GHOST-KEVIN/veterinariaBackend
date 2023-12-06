package veterinaria.exepciones;

import java.io.Serializable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException implements Serializable{
    private static final long serialVersionUID = 1L;
    
    public ResourceNotFoundException(){}
    
    public ResourceNotFoundException(String mensaje){
        super(mensaje);
    }
}