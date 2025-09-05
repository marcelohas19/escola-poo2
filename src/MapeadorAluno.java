import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeadorAluno extends MapeadorDeBRAbstrado {

    public MapeadorAluno(String nomeTabela) {
        super(nomeTabela);
    }

    @Override
    protected ObjetoPersistente obterObjetoDoRegistro(Oid oid, ResultSet registro_bd){
        Aluno aluno = null;
        try {
            if(registro_bd.next()){
                aluno = new Aluno(oid);;
                aluno.setNome_aluno(registro_bd.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aluno;
    }

    @Override
    protected String inserirObjetoNoRegistro(ObjetoPersistente ob){
        Aluno aluno = (Aluno) ob;
        String sql = "(oid, nome) VALUES ('" + aluno.getOid().getString() + "', '" + aluno.getNome_aluno() + "')";
        return sql;
    }

    protected String excluirObjetoDoRegistro(ObjetoPersistente ob) {
        return ob.getOid().getString();
    }

    protected String atualizaObjetoNoRegistro(ObjetoPersistente ob) {
        Aluno aluno = (Aluno) ob;
        String sql = "nome = '" + aluno.getNome_aluno() + "'";
        return sql;
    }
}
