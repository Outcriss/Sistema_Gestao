import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TarefaDAO {

    public void salvar(Tarefa tarefa) {

        String sql = "INSERT INTO tarefas (titulo, descricao, status, usuario_responsavel_id, projeto_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, tarefa.getTitulo());
            stmt.setString(2, tarefa.getDescricao());
            stmt.setString(3, tarefa.getStatus());
            stmt.setInt(4, tarefa.getUsuarioResponsavel().getId());
            stmt.setInt(5, tarefa.getIdProjeto());

            stmt.executeUpdate();
            System.out.println("✅ BANCO DE DADOS: Tarefa '" + tarefa.getTitulo() + "' salva no MySQL com sucesso!");

        } catch (SQLException e) {
            System.out.println("❌ Erro ao salvar tarefa no banco de dados: " + e.getMessage());
        }
    }
}