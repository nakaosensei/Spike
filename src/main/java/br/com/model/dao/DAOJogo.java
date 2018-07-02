/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*package Model.DAO;

import static Model.DAO.DAOGenerico.em;
import Model.Jogo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;


/**
 *
 * @author thiago
 */
/*
public class DAOJogo extends DAOGenerico<Jogo> {
    public DAOJogo(){
        super(Jogo.class);
    }
        public Boolean checkExistance(Integer id){
        try{
            Jogo x = (Jogo)em.createQuery("SELECT a from Jogo a WHERE a.idJogo like :id").setParameter("id",id).getSingleResult();
            return true;
        }catch(NoResultException ex){
            return false;
            
        }        
    }
        public Jogo obter(String nomeJogo){
        try{
            Jogo x = (Jogo)em.createQuery("SELECT a from Jogo as a where a.nome like :nomeJogo").setParameter("nomeJogo",nomeJogo).getSingleResult();
            return x;
        }catch(NoResultException ex){
            return null;
            
        }        
    }
        public List<Jogo> obterJogo(String nomeJogo){
            List<Jogo> x = em.createQuery("SELECT a from Jogo as a where a.nome like :nomeJogo").setParameter("nomeJogo",nomeJogo).getResultList();
            return x;             
        }
        public List<Jogo> obterJogos(String nomeJogo){
            List<Jogo> x = em.createQuery("SELECT a from Jogo as a where a.nome like :nomeJogo").setParameter("nomeJogo","%"+nomeJogo+"%").getResultList();
            return x;
              
    }
        public List<Jogo> obterJogosComNotaMenorIgualQue(Integer notaEntrada){
            List<Jogo> x = em.createQuery("SELECT a from Jogo as a where a.nota <= :notaEntrada").setParameter("notaEntrada",notaEntrada).getResultList();
            return x;         
              
    }
        public List<Jogo> obterJogosComNotaMenorQue(Integer notaEntrada){
            List<Jogo> x = em.createQuery("SELECT a from Jogo as a where a.nota < :notaEntrada").setParameter("notaEntrada",notaEntrada).getResultList();
            return x;
        }      
        public List<Jogo> obterJogosComNotaMaiorIgualQue(Integer notaEntrada){
            List<Jogo> x = em.createQuery("SELECT a from Jogo as a where a.nota >= :notaEntrada").setParameter("notaEntrada",notaEntrada).getResultList();
            return x;
              
    }
        public List<Jogo> obterJogosComNotaMaiorQue(Integer notaEntrada){
            List<Jogo> x = em.createQuery("SELECT a from Jogo as a where a.nota > :notaEntrada").setParameter("notaEntrada",notaEntrada).getResultList();
            return x;
              
    }
        public List<Jogo> obterJogosComNotaIgualA(Integer notaEntrada){
            List<Jogo> x = em.createQuery("SELECT a from Jogo as a where a.nota = :notaEntrada").setParameter("notaEntrada",notaEntrada).getResultList();
            return x;
              
    }
}*/