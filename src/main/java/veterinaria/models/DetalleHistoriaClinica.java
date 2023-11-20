package veterinaria.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_historia_clinica")
public class DetalleHistoriaClinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "temperatura", nullable = false, length = 255)
    private String temperatura;
    
    @Column(name = "peso", nullable = false)
    private double peso;
    
    @Column(name = "frecuencia_cardiaca", nullable = false)
    private double frecuenciaCardiaca;
    
    @Column(name = "frecuencia_respiratoria", nullable = false)
    private double frecuenciaRespiratoria;
    
    @Column(name = "fecha_hora", nullable = false)
    private String fechaHora;
    
    @Column(name = "alimentacion", nullable = false, length = 255)
    private String alimentacion;
    
    @Column(name = "habitad", nullable = false, length = 255)
    private String habitad;
    
    @Column(name = "observacion", nullable = false, length = 255)
    private String observacion;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private HistoriaClinica historiaClinica;
    
    @OneToOne
    @JoinColumn(name = "colaborador_id", referencedColumnName = "id", nullable = true)
    private Colaborador colaborador;
    
    public DetalleHistoriaClinica(){
//        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    public void setFrecuenciaCardiaca(double frecuenciaCardiaca) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
    }

    public double getFrecuenciaRespiratoria() {
        return frecuenciaRespiratoria;
    }

    public void setFrecuenciaRespiratoria(double frecuenciaRespiratoria) {
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(String alimentacion) {
        this.alimentacion = alimentacion;
    }

    public String getHabitad() {
        return habitad;
    }

    public void setHabitad(String habitad) {
        this.habitad = habitad;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(HistoriaClinica historiaClinica) {
        this.historiaClinica = historiaClinica;
        
    }
    
    public Colaborador getColaborador(){
        return colaborador;
    }
    
    public void setColaborador(Colaborador colaborador){
        this.colaborador = colaborador;
    }

    @Override
    public String toString() {
        return "DetalleHistoriaClinica{" + "id=" + id + ", temperatura=" + temperatura + ", peso=" + peso + ", frecuenciaCardiaca=" + frecuenciaCardiaca + ", frecuenciaRespiratoria=" + frecuenciaRespiratoria + ", fechaHora=" + fechaHora + ", alimentacion=" + alimentacion + ", habitad=" + habitad + ", observacion=" + observacion + ", historiaClinica=" + historiaClinica + '}';
    }
    
}
