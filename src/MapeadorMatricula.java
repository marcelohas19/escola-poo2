import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeadorMatricula extends MapeadorDeBRAbstrado {

    public MapeadorMatricula(String nomeTabela) {
        super(nomeTabela);
    }

    @Override
    protected ObjetoPersistente obterObjetoDoRegistro(Oid oid, ResultSet registro_bd){
        Matricula matricula = null;
        try {
            if(registro_bd.next()){
                matricula = new Matricula(oid);;
                matricula.setIdAluno(registro_bd.getInt(2));
                matricula.setCodDisciplina(registro_bd.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matricula;
    }

    @Override
    protected String inserirObjetoNoRegistro(ObjetoPersistente ob){
        Matricula matricula = (Matricula) ob;
        String sql = "(oid, idAluno, codDisciplina) VALUES ('" + matricula.getOid().getString() + "', " + matricula.getIdAluno() + ", '" + matricula.getCodDisciplina()+"')";
        return sql;
    }

    protected String excluirObjetoDoRegistro(ObjetoPersistente ob) {
        return ob.getOid().getString();
    }

    protected String atualizaObjetoNoRegistro(ObjetoPersistente ob) {
        Matricula matricula = (Matricula) ob;
        String sql = "idAluno = " + matricula.getIdAluno() + ", codDiscplina = '" + matricula.getCodDisciplina() + "'" ;
        return sql;
    }
}
