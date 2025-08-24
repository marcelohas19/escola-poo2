public interface IMapeador {
    public ObjetoPersistente obter(Oid oid);
    public boolean inserir(ObjetoPersistente ob);
    public boolean excluir(ObjetoPersistente ob);
    public  boolean atualizar(ObjetoPersistente ob);
}
