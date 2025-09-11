import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeadorDisciplina extends MapeadorDeBDAbstrato implements IMapeador{

    public MapeadorDisciplina(String nomeTabela) {
        super(nomeTabela);
    }

    @Override
    protected ObjetoPersistente obterObjetoDoRegistro(Oid oid, ResultSet registro_bd){
        Disciplina disciplina = null;
        try {
            if(registro_bd.next()){
                disciplina = new Disciplina(oid);
                disciplina.setNome_disc(registro_bd.getString(2));
                disciplina.setCargaHoraria(registro_bd.getInt(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return disciplina;
    }

    @Override
    protected String inserirObjetoNoRegistro(ObjetoPersistente ob){
        Disciplina disciplina = (Disciplina) ob;
        String sql = "(oid, nome_disciplina, carga_horaria) VALUES ('" + disciplina.getOid().getString() + "', '" + disciplina.getNome_disc() + "', "+ disciplina.getCargaHoraria()+ "')";
        return sql;
    }

    protected String excluirObjetoDoRegistro(Oid oid) {
        return oid.getString();
    }

    protected String atualizaObjetoNoRegistro(ObjetoPersistente ob) {
        Disciplina disciplina = (Disciplina) ob;
        String sql = "nome = '" + disciplina.getNome_disc() + "', carga_horaria = " + disciplina.getCargaHoraria();
        return sql;
    }
}

