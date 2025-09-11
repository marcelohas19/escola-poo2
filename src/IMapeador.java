public interface IMapeador {
     ObjetoPersistente obter(Oid oid);
     boolean inserir(ObjetoPersistente ob);
     boolean excluir(Oid oid);
     boolean atualizar(ObjetoPersistente ob);
}
