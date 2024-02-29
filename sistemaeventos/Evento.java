package sistemaeventos;

class Evento {
    private String nome;
    private String endereco;
    private String categoria;
    private String horario;
    private String descricao;

    public Evento(String nome, String endereco, String categoria, String horario, String descricao) {
        this.nome = nome;
        this.endereco = endereco;
        this.categoria = categoria;
        this.horario = horario;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getHorario() {
        return horario;
    }

    public String getDescricao() {
        return descricao;
    }
}