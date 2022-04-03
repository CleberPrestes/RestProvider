
package br.jsf;

import br.data.Cidade;
import br.data.CrudCidade;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import lombok.Data;

/**
 *
 * @author CLEBER S PRESTES
 */
@Named(value = "jsFCidade")
//@SessionScoped
@RequestScoped
@Data
public class JsFCidade {

    private int codigo;
    private String nome;
    private int idCidadeEscolhida;
    private Cidade cidadeSelected;
    private String nomeCidadeEscolhida;
    
    /**
     * Creates a new instance of JsFCidade
     */
    public JsFCidade() {
    }
    
     public java.util.ArrayList<Cidade> getAll() {
        
        return new CrudCidade().getAll();
        
    }
     

      public void buscaCidadeEscolhida(){
                   
         cidadeSelected= new CrudCidade().getCidade(idCidadeEscolhida);
         
         nomeCidadeEscolhida = cidadeSelected.getNome();
                 
      }

    public String getNomeCidadeEscolhida() {
        return nomeCidadeEscolhida;
    }

    public void setNomeCidadeEscolhida(String nomeCidadeEscolhida) {
        this.nomeCidadeEscolhida = nomeCidadeEscolhida;
    }
      
      
      
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdCidadeEscolhida() {
        return idCidadeEscolhida;
    }

    public void setIdCidadeEscolhida(int nomeCidadeEscolhida) {
        this.idCidadeEscolhida = nomeCidadeEscolhida;
    }

    public Cidade getCidadeSelected() {
        return cidadeSelected;
    }

    public void setCidadeSelected(Cidade cidadeSelected) {
        this.cidadeSelected = cidadeSelected;
    }

   
    
}
