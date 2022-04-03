/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jsf;

import br.data.Cidade;
import br.data.Cliente;
import br.data.CrudCidade;
import br.data.CrudCliente;
//import com.mifmif.common.regex.Generex;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import lombok.Data;

@Named(value = "jsfCliente")
@RequestScoped
@Data
public class JsfCliente {
 
    private int id;
    private String nome;
    private int idCidade;
    private String nomeCidade;
      
    private int idClienteEscolhido;
    private String nomeClienteEscolhido;
    private String cidadeClienteEscolhido;
    
    private Cliente clienteSelected;
    
    JsFCidade jsfCidade = new JsFCidade();
    
      public JsfCliente() {
    }

    public java.util.ArrayList<Cliente> getAll() {
      
        return new CrudCliente().getAll();
    }

    public void add() {
        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setNome(nome);
        cliente.setCodigoCidade(idCidade);
        
        jsfCidade.setIdCidadeEscolhida(idCidade);
        jsfCidade.buscaCidadeEscolhida();
        
        String cidadeRetornada = jsfCidade.getNomeCidadeEscolhida();
          
        cliente.setCidade(cidadeRetornada);
        
        new CrudCliente().add(cliente);
    }
    
     public void buscaClienteEscolhido(){
           
       
        // clienteSelected = new CrudCliente().getCliente(idClienteEscolhido);
        clienteSelected = new CrudCliente().getCliente(id);
         
         nomeClienteEscolhido = clienteSelected.getNome();
         cidadeClienteEscolhido = clienteSelected.getCidade();
        
         
         setNome(nomeClienteEscolhido);
         
         setIdCidade(clienteSelected.getCodigoCidade());
         
                 
      }
    
   public void edit(){
       
       jsfCidade.setIdCidadeEscolhida(idCidade);
        jsfCidade.buscaCidadeEscolhida();
        
        String cidadeRetornada = jsfCidade.getNomeCidadeEscolhida();
             
       new CrudCliente().edit(id, nome, cidadeRetornada);
    }

   public void del(){
       new CrudCliente().remove(id);
   }
  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

   
    
}
