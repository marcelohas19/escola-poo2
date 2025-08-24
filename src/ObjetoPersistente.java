public class ObjetoPersistente {
    private Oid oid;

    public ObjetoPersistente(Oid oid){
        this.oid = oid;
    }
    public String getClasse(){
        return this.getClass().getSimpleName();
    }

    public Oid getOid() {
        return oid;
    }
}
