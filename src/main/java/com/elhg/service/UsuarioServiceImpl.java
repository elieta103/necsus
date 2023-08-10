package com.elhg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elhg.dao.UsuarioDao;
import com.elhg.model.ResponseModel;
import com.elhg.model.Usuario;


@Service
public class UsuarioServiceImpl implements UsuarioService{
   
    @Autowired
    private UsuarioDao usuarioDao;
 
    public ResponseModel getAllUsuarios() {
    	ResponseModel responseModel = usuarioDao.getAllUsuarios();
        return responseModel;
    }
 
    public ResponseModel getUserForId(long id) {
    	ResponseModel responseModel = usuarioDao.getUsuarioForId(id);
        return responseModel;
    }
 
    public ResponseModel createUser(Usuario user) {
    	ResponseModel responseModel = usuarioDao.createUsuario(user);
        return responseModel;
    }
 
    public ResponseModel updateUser(Usuario user, long id) {
    	ResponseModel responseModel = usuarioDao.updateUsuario(user, id);
        return responseModel;
    }
 
    public ResponseModel deleteUser(long id) {
    	ResponseModel responseModel = usuarioDao.deleteUsuario(id);
        return responseModel;
    }
 
}