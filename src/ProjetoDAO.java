import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProjetoDAO {

    public void salvar(Projeto projeto) {

        String sql = "INSERT INTO projetos (nome, descricao, dataInicio, dataTerminoPrevista, status, gerente_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, projeto.getNome());
            stmt.setString(2, projeto.getDescricao());
            stmt.setDate(3, Date.valueOf(projeto.getDataInicio()));
            stmt.setDate(4, Date.valueOf(projeto.getDataTerminoPrevista()));
            stmt.setString(5, projeto.getStatus());
            stmt.setInt(6, projeto.getGerenteResponsavel().getId());

            stmt.executeUpdate();
            System.out.println("✅ BANCO DE DADOS: Projeto '" + projeto.getNome() + "' salvo no MySQL com sucesso!");

        } catch (SQLException e) {
            System.out.println("❌ Erro ao salvar projeto no banco de dados: " + e.getMessage());
        }
    }
}