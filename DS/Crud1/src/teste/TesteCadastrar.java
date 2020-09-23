/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;


import dao.ClienteDao;
import mapeamento.Cliente;

/**
 *
 * @author thaly
 */
public class TesteCadastrar {
    public static void main(String[] args) {
        ClienteDao cd = new ClienteDao();
        Cliente c = new Cliente();
        c.setNome("Thalys");
        c.setTelefone("12334");
        c.setEndereco("Rua x");
        c.setCep("123");
        c.setComplemento("qqq");
        c.setCpf_cnpj("123");
        cd.cadastrarCliente(c);
    }
    
  
}
