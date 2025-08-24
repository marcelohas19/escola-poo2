public class Matricula extends ObjetoPersistente{
    private int idAluno;
    private String codDisciplina;

    public Matricula(Oid oid) {
        super(oid);
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public void setCodDisciplina(String codDisciplina) {
        this.codDisciplina = codDisciplina;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public String getCodDisciplina() {
        return codDisciplina;
    }

    @Override
    public String toString() {
        return "Matricula{idMatricula=" + getOid() + ", idAluno=" + idAluno + ", codDisciplina=" + codDisciplina + "}";
    }
}
