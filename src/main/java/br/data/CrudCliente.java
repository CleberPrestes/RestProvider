/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data;

import java.util.ArrayList;

/**
 * @author CLEBER S PRESTES
 */
public class CrudCliente {
    
    private static ArrayList<Cliente> lcliente = new ArrayList<>();
    
    private int idEditado;
    private String nomeEditado;
    private String nomeCidade;
 
      public void add(Cliente cliente) {
        lcliente.add(cliente);
    }
      
       public void edit(int id, String nome, String cidade) {
           
           for (int i = 0; i < lcliente.size(); i++) {
        if (lcliente.get(i).getId()==id) {
            lcliente.get(i).setNome(nome);
            lcliente.get(i).setCidade(cidade);
           
            }
        }
        
    }
         
      
       public void remove(int id) {
           
             for (int i = 0; i < lcliente.size(); i++) {
        if (lcliente.get(i).getId()==id) {
            lcliente.remove(i);
         
        }
    }
    }
      
       public java.util.ArrayList<Cliente> getAll() {
        return lcliente;
    }
       
        public Cliente getCliente(int id) {
        for (Cliente cliente : lcliente) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }
    
}
