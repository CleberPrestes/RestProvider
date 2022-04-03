package br.resources;


import br.data.Cidade;
import br.data.Cliente;
import br.data.CrudCidade;
import br.data.CrudCliente;
import jakarta.json.JsonObject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;



/**
 *
 * @author 
 */
@Path("rest")
public class JakartaEE9Resource {
    
    Cidade cidade = new Cidade();
    @GET
    @Path("clientes")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Cliente> getAllClientes(){
        ArrayList<Cliente> listaCliente = new CrudCliente().getAll();
        return listaCliente;
    }
    
    
    @GET
    @Path("cidades")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Cidade> getAllCidades(){
                       
      ArrayList<Cidade> listaCidades = new CrudCidade().getAll();

      return listaCidades;
      }
      
    //Buscando clientes por id
    @GET
    @Path("cliente/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente getCliente(@PathParam("id") int id){
        return new CrudCliente().getCliente(id);
    }
        
    @GET
    @Path("cidade/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cidade getCcidade(@PathParam("id") int id){
        return new CrudCidade().getCidade(id);
    }
    
    // adicionando novas cidades
    
  
    @PUT
    @Path("cliente/{id}/{nome}/{cidade}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") int id,@PathParam("nome") String nome, @PathParam("cidade") String cidade){
        Cliente cid = new Cliente();
        cid.setId(id);
        cid.setNome(nome);
        cid.setCidade(cidade);
        new CrudCliente().edit(id, nome, cidade);
    }
    
      // adicionando novas cidades
    @POST
    @Path("cliente/{id}/{nome}/{cidade}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void add(@PathParam("id") int id,@PathParam("nome") String nome, @PathParam("cidade") String cidade){
        System.out.println("Adicionar um novo cliente com parametros.......");
        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setNome(nome);
        cliente.setCidade(cidade);
        new CrudCliente().add(cliente);
    }
    
   
    //Deletar por id
    
    @DELETE
    @Path("cliente/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") int id){
        new CrudCliente().remove(id);
    }

}
