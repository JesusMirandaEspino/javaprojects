/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos;

import domain.PersonaDTO;
import java.util.List;

/**
 *
 * @author jesus
 */
public interface IPersonaDAO {
    public int insertar(PersonaDTO persona);
    public int actualizar(PersonaDTO persona);
    public int delete(PersonaDTO persona);
    public List<PersonaDTO> seleccionar();
}
