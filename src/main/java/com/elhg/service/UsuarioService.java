package com.elhg.service;


import com.elhg.model.ResponseModel;
import com.elhg.model.Usuario;

public interface UsuarioService {
	public ResponseModel getAllUsuarios();
	public ResponseModel getUserForId(long id);
	public ResponseModel createUser(Usuario user);
	public ResponseModel updateUser(Usuario user, long id);
	public ResponseModel deleteUser(long id); 
}
