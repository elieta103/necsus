package com.elhg.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.elhg.service.UsuarioService;
import com.elhg.model.ResponseModel;
import com.elhg.model.Usuario;

@RestController
@RequestMapping("/user")
public class UsuarioController {
 
    @Autowired
    private UsuarioService usuarioService;
   
    // CRUD -- CREAR
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<ResponseModel> createUser(@RequestBody Usuario user) {
    	ResponseModel responseModel = usuarioService.createUser(user);
        return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.CREATED);
    }
 
    // CRUD -- READ
    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    public ResponseEntity<ResponseModel> getAllUsers() {
        ResponseModel responseModel = usuarioService.getAllUsuarios();
        return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.OK);
    }
 
    // CRUD -- READ(id)
    @RequestMapping(value = "/getSpecificUser/{id}", method = RequestMethod.GET)
    public ResponseEntity<ResponseModel> getUserForId(@PathVariable ("id") long id) {
        ResponseModel responseModel = usuarioService.getUserForId(id);
        return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.OK);
    }
 
    // CRUD -- UPDATE
    @RequestMapping(value = "/updateUser/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ResponseModel> updateUser(@RequestBody Usuario user, @PathVariable ("id") long id) {
    	ResponseModel responseModel = usuarioService.updateUser(user, id);
        return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.OK);
    }
 
    // CRUD -- DELETE
    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ResponseModel> deleteUser(@PathVariable("id") long id) {
    	ResponseModel responseModel = usuarioService.deleteUser(id);
        return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.OK);
        
        
    }
}
