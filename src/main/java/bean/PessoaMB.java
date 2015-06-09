package bean;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import dao.PessoaService;
import dao.exceptions.NonexistentEntityException;
import dao.util.JPAUtil;
import models.Pessoa;


@ManagedBean
@RequestScoped
@ViewScoped
public class PessoaMB {

    
    PessoaService dao = new PessoaService(JPAUtil.EMF);
    private String mensagem = "";
    private List<Pessoa> pessoas = new ArrayList<Pessoa>();
    private Pessoa pessoa = new Pessoa();
    private String pessoaPesquisado;
    private LoginPessoaMB pessoaLogado = new LoginPessoaMB();

    public PessoaMB() {
        pesquisar();
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagemExclusao() {
        return mensagem;
    }

    public void setMensagemExclusao(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagemAlteracao() {
        return mensagem;
    }

    public void setMensagemAlteracao(String mensagem) {
        this.mensagem = mensagem;
    }

    //metodo de inserção no banco de dados
    public void inserir() {
        try {
            dao.create(pessoa);
            this.setMensagem(this.pessoa.getNome() + " cadastrado(a) com sucesso! ");
            pessoa = new Pessoa();
        } catch (Exception ex) {
            setMensagem(this.pessoa.getNome() + "já existe no sistema, cadastro não realizado!");
            Logger.getLogger(PessoaMB.class.getName()).log(Level.SEVERE, null, ex);
        }

        pesquisar();
    }

    public void excluir(long idPessoa) {
        try {
            dao.destroy(idPessoa);
            
            setMensagemExclusao(this.pessoa.getNome() + "  foi excluído(a) com sucesso!");
            pessoa = new Pessoa();
        } catch (NonexistentEntityException ex) {
            this.setMensagemExclusao("id não existe");
            Logger.getLogger(PessoaMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        pesquisar();
    }

    public void alterar() throws Exception {
        try {
            dao.edit(pessoa);
            setMensagemAlteracao(this.pessoa.getNome() + " foi alterado(a) com sucesso!");
            pessoa = new Pessoa();
        } catch (NonexistentEntityException ex) {
            this.setMensagemAlteracao("id não existe");
            Logger.getLogger(PessoaMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        pesquisar();
    }

    public void carregar(Long id) {
        Pessoa a = dao.findPessoa(id);
        pessoa.setNome(a.getNome());
        pessoa.setCPF(a.getCPF());
        pessoa.setSenha(a.getSenha());
        pessoa.setEmail(a.getEmail());
        pessoa.setId(a.getId());

        if (pessoa == null) {
            pessoa = new Pessoa();
        }
    }
    
    public void carregar1(Pessoa pessoa){
    	this.setPessoa(pessoa);
    }

    public int pesquisar() {
        pessoas = dao.findPessoaEntities();
        return pessoas.size();
    }

    public void pesquisarPessoas() {
        pessoas = new ArrayList<Pessoa>();
        for (Pessoa a : dao.findPessoaEntities()) {
            if ((a.getEmail().toLowerCase().contains(pessoaPesquisado) || (a.getNome().toLowerCase().contains(pessoaPesquisado)))) {
                pessoas.add(a);

            }
        }
        setPessoaPesquisado("");
       
    }
    
  

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getPessoaList() {
        return pessoas;
    }

    public void setPessoaList(ArrayList<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public List<Pessoa> pesquisarPessoa() {
        return dao.findPessoaEntities();
    }

    public String getPessoaPesquisado() {
        return pessoaPesquisado;
    }

    public void setPessoaPesquisado(String pessoaPesquisado) {
        this.pessoaPesquisado = pessoaPesquisado;
    }

	public LoginPessoaMB getPessoaLogado() {
		return pessoaLogado;
	}

	public void setPessoaLogado(LoginPessoaMB pessoaLogado) {
		this.pessoaLogado = pessoaLogado;
	}
}