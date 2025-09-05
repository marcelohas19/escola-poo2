import java.sql.ResultSet;

public class MapeadorDeBRAbstrado extends MapeadorDePersistenciaAbstrada {
    private String nomeTabela;

    protected String getNomeTabela(){
        return nomeTabela;
    }

    public MapeadorDeBRAbstrado(String nomeTabela){
        this.nomeTabela = nomeTabela;
    }

    @Override
    protected ObjetoPersistente obterObjetoDoArmazem(Oid oid) {
        ResultSet registro_bd = obterRegistroDoBD(oid);

        if(registro_bd == null){
            return null;
        }
        ObjetoPersistente objeto = obterObjetoDoRegistro(oid, registro_bd);
        return objeto;
    }

    protected ObjetoPersistente obterObjetoDoRegistro(Oid oid, ResultSet registro_bd) {
        return null;
    }

    private ResultSet obterRegistroDoBD(Oid oid){
        String sql = "SELECT * FROM \"" + getNomeTabela() + "\" WHERW oid = '"+oid.getString()+"'";
        return ConexaoBD.obterInstancia().consultar(sql);
    }

    @Override
    protected Boolean inserirObjetoNoArmazem(ObjetoPersistente ob){

        return inserirRegistroNoBD(inserirObjetoNoRegistro(ob));
    }

    private boolean inserirRegistroNoBD(String sql_valores){
        String sql = "INSERT INTO \"" + getNomeTabela()+"\" "+ sql_valores;
        return ConexaoBD.obterInstancia().iserir(sql);
    }

    protected String inserirObjetoNoRegistro(ObjetoPersistente ob) {
        return null;
    }

    @Override
    protected Boolean excluirDoArmazem(ObjetoPersistente ob) {
        return excluirObjetoDoBD(excluirObjetoDoRegistro(ob));
    }

    private boolean excluirObjetoDoBD(String oid){
        String sql = "DELETE FROM \"" + getNomeTabela() +"\" WHERE oid ='"+ oid +"'";
        return ConexaoBD.obterInstancia().excluir(sql);
    }

    protected String excluirObjetoDoRegistro(ObjetoPersistente ob) {
        return null;
    }

    @Override
    protected Boolean atualizarNoArmazem(ObjetoPersistente ob) {

        return atualizarRegistroDoBD(atualizaObjetoNoRegistro(ob), ob.getOid());
    }

    private boolean atualizarRegistroDoBD(String sql_coluna_com_valores, Oid oid){
        String sql = "UPDATE \"" + getNomeTabela() +"\" SET " + sql_coluna_com_valores + "WHERE oid = '"+ oid.getString() +"'";
        return ConexaoBD.obterInstancia().atualizar(sql);
    }

    protected String atualizaObjetoNoRegistro(ObjetoPersistente ob) {
        return null;
    }
}