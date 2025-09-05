import java.util.Hashtable;

public class FabricanteDeMapeador {

    private Hashtable<String, IMapeador> colecaoMapeadores = null;

    static FabricanteDeMapeador instancia = null;

    private FabricanteDeMapeador(){
        colecaoMapeadores = new Hashtable<String, IMapeador>();
            // registro de mapeadores
            colecaoMapeadores.put("Aluno", new MapeadorAluno("Aluno"));
            colecaoMapeadores.put("Disciplina", new MapeadorDisciplina("Disciplina"));
            colecaoMapeadores.put("Matricula", new MapeadorMatricula("Matricula"));
    }


    public static FabricanteDeMapeador obterInstancia(){
        if(instancia == null){
            instancia = new FabricanteDeMapeador();
        }
        return instancia;
    }

    public IMapeador getMapeador(Class<?> classeDePersistencia){
        return colecaoMapeadores.get(classeDePersistencia.getSimpleName());
    }
}

