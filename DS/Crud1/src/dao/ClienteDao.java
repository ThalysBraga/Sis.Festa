/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import mapeamento.Cliente;
import conexoes.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author thaly
 */
public class ClienteDao {

    public void cadastrarCliente(Cliente c) {
        Connection con = Conexao.conectar();
        String sql = "INSERT INTO cliente(nome_cli, endereco_cli, complemento_cli, cpf_cnpj_cli, cep_cli, telefone_cli) VALUES (?, ?, ?, ?, ?, ?);";
        try (PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setString(1, c.getNome());
            stm.setString(2, c.getEndereco());
            stm.setString(3, c.getComplemento());
            stm.setString(4, c.getCpf_cnpj());
            stm.setString(5, c.getCep());
            stm.setString(6, c.getTelefone());
            stm.executeUpdate();
            stm.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar! Erro: " + ex.getMessage());
        }
    }

    public void atualizarCliente(Cliente c) {
        Connection con = Conexao.conectar();
        String sql = "UPDATE cliente SET nome_cli = ?, endereco_cli = ?, complemento_cli = ?, cpf_cnpj_cli = ?, cep_cli = ?, telefone_cli = ? WHERE id_cli = ?;";
        try (PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setString(1, c.getNome());
            stm.setString(2, c.getEndereco());
            stm.setString(3, c.getComplemento());
            stm.setString(4, c.getCpf_cnpj());
            stm.setString(5, c.getCep());
            stm.setString(6, c.getTelefone());
            stm.setInt(7, c.getIdCliente());
            stm.executeUpdate();
            stm.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar cliente!! Erro: " + e.getMessage());
        }
    }

    public void deletarCliente(Cliente c) {
        Connection con = Conexao.conectar();
        String sql = "DELETE FROM cliente WHERE id_cli = ?;";
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o cliente?" + c.getNome(), "Excluir", JOptionPane.YES_NO_CANCEL_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            try (PreparedStatement stm = con.prepareStatement(sql)) {
                stm.setInt(1, c.getIdCliente());
                stm.executeLargeUpdate();
                stm.close();
                con.close();
                JOptionPane.showMessageDialog(null, "Excluido com sucesso!!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir cliente!! Erro: " + e.getMessage());
            }
        }
    }

    public List<Cliente> ListarTodosClientes(String nome) {
        Connection con = Conexao.conectar();
        List<Cliente> listaCliente = new ArrayList<>();
        String sql = "SELCT * FROM cliente WHERE nome_cli LIKE ? ORDER BY nome_cli;";
        try (PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setString(1, "%" + nome + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt("id_cli"));
                c.setNome(rs.getString("nome_cli"));
                c.setEndereco(rs.getString("endereco_cli"));
                c.setComplemento(rs.getString("complemento_cli"));
                c.setCpf_cnpj(rs.getString("cpf_cnpj_cli"));
                c.setCep(rs.getString("cep_cli"));
                c.setTelefone(rs.getString("telefone_cli"));
                listaCliente.add(c);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar clientes!! Erro: " + e.getMessage());
        }
        return listaCliente;
    }
}
