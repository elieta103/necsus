package com.elhg.dao;


import com.elhg.model.ResponseModel;
import com.elhg.model.Usuario;

public interface UsuarioDao {
	  public ResponseModel getAllUsuarios();
	  public ResponseModel getUsuarioForId(long id);
	  public ResponseModel createUsuario(Usuario usuario);
	  public ResponseModel updateUsuario(Usuario usuario, long id);
	  public ResponseModel deleteUsuario(long id);
}
