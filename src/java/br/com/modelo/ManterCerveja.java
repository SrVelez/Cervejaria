/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modelo;


import br.com.controle.Cerveja;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author artt
 */
public class ManterCerveja extends DAO{
   public void inserir(Cerveja ce) throws Exception {
    try {
    abrirBanco();
    String query = "INSERT INTO cerveja (codigo,nome,tipo,teor,ano,marca) "
            + "values(null,?,?,?,?,?)";
    ps=(PreparedStatement) con.prepareStatement(query);
    ps.setString(1, ce.getNome());
    ps.setString(2, ce.getTipo());
    ps.setInt(3, ce.getTeor());
    ps.setInt(4, ce.getAno());
    ps.setString(5, ce.getMarca());
    
    ps.execute();
    fecharBanco();
    } catch (Exception e) {
        System.out.println("Erro " + e.getMessage());
    }
   } 
   //=====iniico do listar===
  public ArrayList pesquisarTudo(){
   ArrayList<Cerveja> listacer = new ArrayList<Cerveja>();
         try{
         abrirBanco();  
         String query = "select  * FROM cerveja";
         ps = con.prepareStatement(query);
         ResultSet rs = ps.executeQuery();
         Cerveja ntcer ;
         while (rs.next()){ 
           ntcer = new Cerveja();
           ntcer.setCodigo(rs.getInt("codigo"));
           ntcer.setNome(rs.getString("nome"));
           ntcer.setTipo(rs.getString("tipo"));
           ntcer.setTeor(rs.getInt("teor"));
           ntcer.setAno(rs.getInt("ano"));
           ntcer.setMarca(rs.getString("marca"));
           listacer.add(ntcer); 
         } 
         fecharBanco();
       }catch (Exception e){
           System.out.println("Erro " + e.getMessage());
     } 
       return listacer;
     }
   //=fim do listar==
   
  //=====iniico do deletar===
        public void deletar(Cerveja ce) throws Exception{
         abrirBanco();
         String query = "delete FROM cerveja where codigo=?";
         ps=(PreparedStatement) con.prepareStatement(query);
         ps.setInt(1, ce.getCodigo());
         ps.execute();
        fecharBanco();   
     }   
       //=fim do deletar==
     
     
      //=====iniico do editar===
        public void editarCerveja(Cerveja ce) throws Exception {
        abrirBanco();
        String query = "UPDATE cerveja set nome = ?, tipo = ?, teor = ?, ano = ?, marca = ? where codigo = ?";
        ps = (PreparedStatement) con.prepareStatement(query);
        ps.setString(1, ce.getNome());
        ps.setString(2, ce.getTipo());
        ps.setInt(3, ce.getTeor());
        ps.setInt(4, ce.getAno());
        ps.setString(5, ce.getMarca());
        ps.setInt(6, ce.getCodigo());
        ps.executeUpdate();
        fecharBanco();
    }   
         //=fim do editar==
        
        
        //=====iniico do pesquisar===
        public Cerveja pesquisar(int codigo) throws Exception {
         try {
            Cerveja ce = new Cerveja();
            System.out.println(" Chegou no pesquisar registo" + codigo);
            abrirBanco();
            String query = "select * FROM cerveja where codigo=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
              ce.setCodigo(rs.getInt("codigo"));
              ce.setNome(rs.getString("nome"));
              ce.setTipo(rs.getString("tipo"));
              ce.setTeor(rs.getInt("teor"));
              ce.setAno(rs.getInt("ano"));
              ce.setMarca(rs.getString("marca"));
              
             
                return ce;
            }
            fecharBanco();
    } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
    }
    return null;
	}
     //=fim do pesquisar==
}
