public class Tarefa {
    private int id;
    private String titulo;
    private String descricao;
    private String status;
    private Usuario usuarioResponsavel;
    private int idProjeto;

    public Tarefa(String titulo, String descricao, String status, Usuario usuarioResponsavel, int idProjeto) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.usuarioResponsavel = usuarioResponsavel;
        this.idProjeto = idProjeto;
    }


    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public String getStatus() { return status; }
    public Usuario getUsuarioResponsavel() { return usuarioResponsavel; }
    public int getIdProjeto() { return idProjeto; }
}