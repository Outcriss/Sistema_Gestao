import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EquipeDAO {

    public void salvar(Equipe equipe) {

        String sql = "INSERT INTO equipes (nome, descricao) VALUES (?, ?)";

        try (Connection conn = ConnectionFactory.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, equipe.getNome());
            stmt.setString(2, equipe.getDescricao());

            stmt.executeUpdate();
            System.out.println("✅ BANCO DE DADOS: Equipe salva no MySQL com sucesso!");

        } catch (SQLException e) {
            System.out.println("❌ Erro ao salvar equipe no banco de dados: " + e.getMessage());
        }
    }
}