package gm.Empleados.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString
public class Empleado {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    Integer idEmpleado;
    String nombreEmpleado;
    String departamento;
    Double sueldo;

}
