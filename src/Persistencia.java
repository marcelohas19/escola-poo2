public class Persistencia {
    private static Persistencia persistencia = null;

    public static Persistencia obterInstancia(){
        if(persistencia == null){
            persistencia = new Persistencia();
        }

        return persistencia;
    }

    public ObjetoPersistente obter(Oid oid, Class<?> classeDePersistencia){
        IMapeador mapeador = (IMapeador) FabricanteDeMapeador.obterInstancia().getMapeador(classeDePersistencia);
        return mapeador.obter(oid);
    }

    public boolean inserir(ObjetoPersistente ob){
        return false;
    }

    public boolean atualizar(ObjetoPersistente oid){
        return false;
    }

    public boolean excluir(ObjetoPersistente ob){
        return false;
    }
}
