import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {


    public void salvar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nomeCompleto, cpf, email, cargo, login, senha, perfil) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {


            stmt.setString(1, usuario.getNomeCompleto());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getCargo());
            stmt.setString(5, usuario.getLogin());
            stmt.setString(6, usuario.getSenha());
            stmt.setString(7, usuario.getPerfil());

            stmt.executeUpdate();
            System.out.println("✅ BANCO DE DADOS: Usuário salvo no MySQL com sucesso!");

        } catch (SQLException e) {
            System.out.println("❌ Erro ao salvar usuário no banco de dados: " + e.getMessage());
        }
    }

    public java.util.List<Usuario> listar() {
        java.util.List<Usuario> utilizadores = new java.util.ArrayList<>();

        String sql = "SELECT * FROM usuarios";

        try (java.sql.Connection conn = ConnectionFactory.conectar();
             java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
             java.sql.ResultSet rs = stmt.executeQuery()) {


            while (rs.next()) {
                Usuario u = new Usuario(
                        rs.getString("nomeCompleto"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getString("cargo"),
                        rs.getString("login"),
                        rs.getString("senha"),
                        rs.getString("perfil")
                );


                u.setId(rs.getInt("id"));

                utilizadores.add(u);
            }

        } catch (java.sql.SQLException e) {
            System.out.println("❌ Erro ao procurar utilizadores no banco de dados: " + e.getMessage());
        }

        return utilizadores;
    }
}