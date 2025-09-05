public class Disciplina extends ObjetoPersistente  {
    private String nome_disc;
    private int cargaHoraria;

    public Disciplina(Oid oid) {
        super(oid);
    }

    public void setNome_disc(String nome) {
        this.nome_disc = nome;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getNome_disc() {
        return nome_disc;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    @Override
    public String toString() {
        return "Disciplina{codigo=" + getOid() + ", nome='" + nome_disc + "', cargaHoraria=" + cargaHoraria + "}";
    }
}
