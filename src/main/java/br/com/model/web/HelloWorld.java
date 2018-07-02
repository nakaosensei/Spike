package br.com.model.web;
import br.com.model.Arquivo;

import static spark.Spark.*;
/**
 *
 * @author nakao
 */
public class HelloWorld {
    public static void main(String[] args) {
        get("/hello",(req,res)->Arquivo.lerArquivo("../../view/login.html"));
    }
}
