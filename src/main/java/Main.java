
import models.*;
import dao.*;
import dao.util.*;
import dao.exceptions.*;

public class Main {

	public static void Main(String[] args) {
		Endereco endereco = new Endereco();
		
		endereco.setNumero(20);
		endereco.setRua("Antônio V. Galvão");
		endereco.setBairro("Gilberto Pinheiro");
		endereco.setCidade("Currais Novos");
		endereco.setUF("RN");
		endereco.setPais("Brasil");
		endereco.setCEP(59380000);
		
		EnderecoService enderecoService = new EnderecoService(JPAUtil.EMF);
		
		enderecoService.createEndereco(endereco);
	}
	
}
