/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data;

import br.rs.RestClientCities;
import java.util.ArrayList;

/**
 *
 * @author CLEBER S PRESTES
 */
public class CrudCidade {
     private static ArrayList<Cidade> lcid = new ArrayList<>();
     RestClientCities rc = new RestClientCities();

    public void add(Cidade cid) {
        lcid.add(cid);
    }

  
     public ArrayList<Cidade> getAll() {
    
         lcid= rc.getCidades();
         return lcid;
    }

    public Cidade getCidade(int id) {
                     
        for (Cidade cidade : lcid) {
            if (cidade.getCodigo()== id) {
                return cidade;
            }
        }
        return null;
    }
}
