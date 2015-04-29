package bean;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dao.ClienteService;
import dao.EnderecoService;
import dao.exceptions.NonexistentEntityException;
import dao.util.JPAUtil;
import models.Cliente;
import models.Endereco;


@ManagedBean
@RequestScoped
public class ClienteMB {
	private Cliente cliente = new Cliente();
	private Endereco endereco = new Endereco();
	public final ClienteService dao = new ClienteService(JPAUtil.EMF);
	public final EnderecoService daoEndereco = new EnderecoService(JPAUtil.EMF);
	private String pesquisa;
	private List<Cliente> clientes;
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Endereco getEndereco()
	{
		return endereco;
	}
	
	public void setEndereco(Endereco endereco){
		this.endereco = endereco;
	}

	public void salvar(){
		try {
			daoEndereco.createEndereco(endereco);
			cliente.setEndereco(endereco);
			dao.createCliente(cliente);
		} catch (Exception ex) {
			// TODO: handle exception
		}
	}
	
	public void excluir(long id, long idEnd){
        try {
            dao.destroy(id);
            daoEndereco.destroy(idEnd);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ClienteMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
	public void carregar(Cliente cliente){
        this.setCliente(cliente);
    }
  
    public void limpar(){
        this.setCliente(new Cliente());
    }
    
    public List<Cliente> getClientes(){
        if(pesquisa == null){
            clientes = dao.findClienteEntities();
        } else if(pesquisa.isEmpty()){
            clientes = dao.findClienteEntities();
        } else {
            pesquisarPorNome();
        }
        return clientes;
    }
    
   
    public void pesquisarPorNome(){
        clientes = dao.pesquisarPorNome(pesquisa);
    }
    
   
    public void getTodos(){
        pesquisa = "";
        this.getClientes();
    }
    
     public void pesquisar() {
        clientes = dao.findClienteEntities();
    }
	
}