/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.sga.servicio;

import jakarta.inject.Inject;
import java.util.List;
import mx.com.gm.sga.datos.UsuarioDAO;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;

/**
 *
 * @author jesus
 */
public class UsuarioServiceImpl implements UsuarioService{
    
    @Inject
    private UsuarioDAO usuarioDao;
    

    @Override
    public List<Usuario> listarUsuarios() {
       return usuarioDao.findAllUsuarios();
    }

    @Override
    public Usuario encontrarUsuarioPorId(Usuario usuario) {
         return usuarioDao.findUsuarioById(usuario);
    }

    @Override
    public void registrarUsuario(Usuario usuario) {
         usuarioDao.insertUsuario(usuario);
    }

    @Override
    public void modificarUsuario(Usuario usuario) {
          usuarioDao.updateUsuario(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
         usuarioDao.deleteUsuario(usuario);
    }

 
}
