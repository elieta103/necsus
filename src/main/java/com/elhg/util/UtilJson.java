package com.elhg.util;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.elhg.model.Usuario;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class UtilJson {
	public static final String JSON_FILE = "src/main/resources/usuarios.json";

	public static List<Usuario> readJson(){
		List<Usuario> usuarios = new ArrayList<>();
		try {
			String json = Files.readString(Path.of(JSON_FILE));
			usuarios = new Gson().fromJson(json, new TypeToken<List<Usuario>>(){}.getType() );
		}catch(IOException e) {
			e.printStackTrace();
		}
		return usuarios;
	}
	
	public static boolean writeJson(List<Usuario> listUsuario) {
		boolean response = false;
		try (FileWriter file = new FileWriter(JSON_FILE)) {
            file.write(new Gson().toJson(listUsuario));
            file.flush();
            
            response = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
		return response;
	}
}
