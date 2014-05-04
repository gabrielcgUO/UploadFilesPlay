package controllers;

import java.io.File;

import play.mvc.Controller;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.mvc.Result;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("¿Subida de archivos?"));
    }
    
    public static Result showUpload() {
    	return ok(upload.render());
    }
    
    public static Result uploadFile() {
    	MultipartFormData body = request().body().asMultipartFormData();
    	FilePart file = body.getFile("file");
    	if (file != null) {
    		String fileName = file.getFilename();
    		String contentType = file.getContentType();
    		File archivo = file.getFile();
    		
    		
    		
    		return ok(archivo);
    	}
    	
    	return internalServerError("Error en la subida de archivo");
    }

}
