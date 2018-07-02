package br.com.view;

import br.com.model.Address;
import br.com.model.Alarm;
import br.com.model.Houseowner;
import br.com.model.dao.DAOAlarmEvent;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author nakao
 */
public class MenuGenerator {

    public static String printMenuScreen(){
        System.out.println("Bem vindo ao Spike System Console");
        System.out.println("Escolha uma opção:");
        System.out.println("1-Login");
        System.out.println("2-Cadastro de proprietario");
        System.out.println("3-Sair");
        Scanner keyboard = new Scanner(System.in);
        return keyboard.nextLine();
    }
    
    public static HashMap<String,String> getLoginPw(){
        HashMap<String,String> out = new HashMap<>();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("login:");
        out.put("login", keyboard.nextLine());
        System.out.println("password:");
        out.put("password", keyboard.nextLine());
        return out;
    }
    
    public static void showAlarm(Alarm a){
        DAOAlarmEvent daoAE = new DAOAlarmEvent();
        a.print(daoAE);
    }
    
    
    public static HashMap<String,String> cadastroProprietario(){
        HashMap<String,String> out = new HashMap<>();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("name:");
        out.put("name", keyboard.nextLine());
        System.out.println("password:");
        out.put("password", keyboard.nextLine());
        System.out.println("email:");
        out.put("email", keyboard.nextLine());        
        return out;
    } 
    
    public static HashMap<String,String> cadastroEndereco(){
        HashMap<String,String> out = new HashMap<>();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("street:");
        out.put("street", keyboard.nextLine());
        System.out.println("number:");
        out.put("number", keyboard.nextLine());
        System.out.println("zip code:");
        out.put("zipCode", keyboard.nextLine());        
        return out;
    };

    public static void showEnderecos(Houseowner owner){
        System.out.println("id:"+owner.getOwnerId()+" name:"+owner.getOwnerName()+" mail:"+owner.getOwnerMail());
        DAOAlarmEvent daoAE = new DAOAlarmEvent();
        for(Address a:owner.getAddressList()){
            a.print(daoAE);
        }
    };    
    
    
}
