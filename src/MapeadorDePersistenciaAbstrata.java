import java.util.Hashtable;

public abstract class MapeadorDePersistenciaAbstrata implements IMapeador{
    private Hashtable<String, ObjetoPersistente>cache = new Hashtable<String, ObjetoPersistente>();

    public ObjetoPersistente obter(Oid oid){
        ObjetoPersistente objeto;

        if(!cache.containsKey(oid.getString())){
            objeto = obterObjetoDoArmazem(oid);
            if(objeto != null){
                cache.put(oid.getString(), objeto);
            }
        }else{
            objeto = cache.get(oid.getString());
        }
        return objeto;
    }

    protected abstract ObjetoPersistente obterObjetoDoArmazem(Oid oid);

    public boolean inserir(ObjetoPersistente ob){
        if(obter(ob.getOid()) == null){
            if(inserirObjetoNoArmazem(ob)){
                cache.put(ob.getOid().getString(), ob);
                return true;
            }
        }
        return false;
    }
    protected abstract Boolean inserirObjetoNoArmazem(ObjetoPersistente ob);

    public boolean excluir(Oid oid){
        if(obter(oid) != null){
            if(excluirDoArmazem(oid)){
                cache.remove(oid.getString());
                return true;
            }
        }
        return false;
    }

    protected abstract Boolean excluirDoArmazem(Oid oid);

    public boolean atualizar(ObjetoPersistente ob){
        if(obter(ob.getOid()) != null){
            if(atualizarNoArmazem(ob)) {
                cache.put(ob.getOid().getString(), ob);
                return true;
            }
        }
        return false;
    }

    protected abstract Boolean atualizarNoArmazem(ObjetoPersistente ob);

}
