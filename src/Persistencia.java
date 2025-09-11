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
        IMapeador mapeador = (IMapeador) FabricanteDeMapeador.obterInstancia().getMapeador(ob.getClass());
        return mapeador.inserir(ob);
    }

    public boolean atualizar(ObjetoPersistente ob){
        IMapeador mapeador = (IMapeador) FabricanteDeMapeador.obterInstancia().getMapeador(ob.getClass());
        return mapeador.atualizar(ob);
    }

    public boolean excluir(Oid oid, Class<?> classeDePersistencia){
        IMapeador mapador = (IMapeador) FabricanteDeMapeador.obterInstancia().getMapeador(classeDePersistencia);
        return mapador.excluir(oid);
    }
}
