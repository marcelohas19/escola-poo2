public class Aluno extends ObjetoPersistente{
    private String nome_aluno;

    public  Aluno(Oid oid){
        super(oid);
    }

    public String getNome_aluno() {
        return nome_aluno;
    }

    public void setNome_aluno(String nome_aluno) {
        this.nome_aluno = nome_aluno;
    }

    @Override
        public String toString(){
        return "Aluno{id=" + getOid() + ",nome'='" + nome_aluno + "'}";
    }
}
