package br.com.model.web;
import br.com.model.Arquivo;

import static spark.Spark.*;
/**
 *
 * @author nakao
 */
public class HelloWorld {
    public static void main(String[] args) {
        get("/home",(req,res)->Arquivo.lerArquivo("src/main/java/br/com/view/login.html"));
    }
}
