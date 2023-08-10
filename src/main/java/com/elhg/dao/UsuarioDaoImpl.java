package com.elhg.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.elhg.model.ResponseModel;
import com.elhg.model.Usuario;
import com.elhg.util.UtilJson;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {
	static HashMap<Long, Usuario> usuariosMap = new HashMap<Long, Usuario>();
	 
    public UsuarioDaoImpl() {
           
    }
 
    public ResponseModel getAllUsuarios() {
    	ResponseModel responseModel = new ResponseModel();
    	List<Usuario> usuariosData = UtilJson.readJson();
    	
    	if(!usuariosData.isEmpty()) {
    		Collections.sort(usuariosData);
    		responseModel.setStatus("Información  encontrada.");
			responseModel.setData(usuariosData);
    	}else {
    		responseModel.setStatus("No se encontro informacion.");
			responseModel.setData("");
    	}
        return responseModel;
    }
 
    public ResponseModel getUsuarioForId(long id) {
    	ResponseModel responseModel = new ResponseModel();
    	List<Usuario> usuariosData = UtilJson.readJson();
    	Optional <Usuario> optUser = usuariosData.stream().filter(usr -> usr.getId().equals(id)).findFirst();
    	if(optUser.isPresent()) {
    		responseModel.setStatus("Usuario encontrado.");
			responseModel.setData(optUser.get());
    	}else {
    		responseModel.setStatus("No se encontro informacion.");
			responseModel.setData("");
    	}
    		
        return responseModel;
    }
 
    public ResponseModel createUsuario(Usuario usuario) {
    	ResponseModel responseModel = new ResponseModel();
    	List<Usuario> usuariosData = UtilJson.readJson();
    	Usuario usuarioUltimo = null;
    	
    	// Obtener id's
    	if(!usuariosData.isEmpty()) { // Ultimo Usuario
    		usuarioUltimo = usuariosData.stream().reduce((first, second) -> second).orElseThrow(null);
    	}else { // Primer Usuario
    		usuario.setId(1L);
    		usuariosData = new ArrayList<>();
    	}
    	
    	if(usuarioUltimo != null) {
    		usuario.setId(usuarioUltimo.getId() + 1);
    		usuariosData.add(usuario); 	
    	}else {
    		usuariosData.add(usuario); 	
    	}
    	
    	boolean status = UtilJson.writeJson(usuariosData);
		
		if(status) {
			responseModel.setStatus("Usuario agregado, exitosamente!");
			responseModel.setData(usuario);
		}
    	
        return responseModel;
    }
 
    public ResponseModel updateUsuario(Usuario usuario, long id) {
    	ResponseModel responseModel = new ResponseModel();
    	List<Usuario> usuariosData = UtilJson.readJson();
    	Usuario usuarioEditado = null;
    	
    	// Busca el Id
    	Optional <Usuario> optUser = usuariosData.stream().filter(usr -> usr.getId().equals(id)).findFirst();
    	if(optUser.isPresent()) {
    		usuarioEditado = new Usuario();
    		usuarioEditado.setId(id);
    		usuarioEditado.setNombre(usuario.getNombre());
    		usuarioEditado.setCorreo(usuario.getCorreo());
    		
    		usuariosData.removeIf(usr -> usr.getId().equals(id));
    		usuariosData.add(usuarioEditado);
    		
    		boolean status = UtilJson.writeJson(usuariosData);
    		if(status) {
    			responseModel.setStatus("Usuario encontrado.");
    			responseModel.setData(usuarioEditado);
    		}
    	}else {
    		responseModel.setStatus("No se encontro informacion para actualizar.");
			responseModel.setData("");
    	}

        
        return responseModel;
    }
 
    public ResponseModel deleteUsuario(long id) {
    	ResponseModel responseModel = new ResponseModel();
    	List<Usuario> usuariosData = UtilJson.readJson();
    	
    	// Busca el Id
    	Optional <Usuario> optUser = usuariosData.stream().filter(usr -> usr.getId().equals(id)).findFirst();
    	if(optUser.isPresent()) {
    		usuariosData.removeIf(usr -> usr.getId().equals(id));
    		
    		boolean status = UtilJson.writeJson(usuariosData);
    		if(status) {
    			Collections.sort(usuariosData);
    			responseModel.setStatus("Usuario eliminado con exito!.");
    			responseModel.setData(optUser.get());
    		}
    	}else {
    		responseModel.setStatus("No se encontro informacion para eliminar.");
			responseModel.setData("");
    	}

        
        return responseModel;
    }
 
}
