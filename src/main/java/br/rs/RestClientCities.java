/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rs;


import br.data.Cidade;
import jakarta.ws.rs.ClientErrorException;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author CLEBER S PRESTES
 */
public class RestClientCities {
    
      private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "https://maventest.herokuapp.com/mavenTest-1.0-SNAPSHOT/webresources/";
    
        public  RestClientCities() {
        client = jakarta.ws.rs.client.ClientBuilder.newClient();
            webTarget = client.target(BASE_URI);
    }
    
      public Response ping() throws ClientErrorException {
        Response resource = webTarget.request().get();
        return resource;
    }
      
      // Modificar essa para obter cidades
       public ArrayList<Cidade> getCidades() throws ClientErrorException {
        ArrayList resource = webTarget.path("cidade").request(MediaType.APPLICATION_JSON).get(ArrayList.class);
        //converter Arraylist de hashmap para ArrayList de Cidade
        ArrayList<Cidade> lcid = new ArrayList<Cidade>();
        for (Object object : resource) {
            HashMap hm = (HashMap) object;
            Cidade cid= new Cidade();
            cid.setCodigo(((BigDecimal) hm.get("codigo")).intValue());
            cid.setNome((String) hm.get("nome"));
            lcid.add(cid);
        }
        return lcid;
    }
            
        //obter uma cidade
    public Cidade getCidade(int id) throws ClientErrorException {
        Cidade resource = webTarget.path("cidade")
                .path("/" + id)
                .request(MediaType.APPLICATION_JSON).get(Cidade.class);
        return resource;
    }
    
}
