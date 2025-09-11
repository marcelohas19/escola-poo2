import java.util.Scanner;

public class Main {

    public static int opcoes(Scanner sc) {
        int n = 0;
        do {
            System.out.println("1- inserir aluno");
            System.out.println("2- inserir disciplina");
            System.out.println("3- inserir matricula");
            System.out.println("4- alterar aluno");
            System.out.println("5- alterar disciplina");
            System.out.println("6- excluir aluno");
            System.out.println("7- excluir disciplina");
            System.out.println("8- excluir matricula");
            System.out.println("9- sair");
            System.out.print("Opção: ");
            n = sc.nextInt();
            sc.nextLine(); // limpar buffer
        } while (n < 1 || n > 9);
        return n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op;
        Aluno aluno;
        Disciplina disciplina;
        Matricula matricula;

        do {
            op = opcoes(sc);
            switch (op) {

                case 1: // Inserir aluno
                    System.out.print("ID aluno: ");
                    aluno = new Aluno(new Oid(sc.nextLine()));
                    System.out.print("Nome do aluno: ");
                    aluno.setNome_aluno(sc.nextLine());

                    if (Persistencia.obterInstancia().inserir(aluno)) {
                        System.out.println("Aluno inserido com sucesso.");
                    } else {
                        System.out.println("REGISTRO REPETIDO");
                    }
                    break;

                case 2: // Inserir disciplina
                    System.out.print("ID disciplina: ");
                    disciplina = new Disciplina(new Oid(sc.nextLine()));
                    System.out.print("Nome da disciplina: ");
                    disciplina.setNome_disc(sc.nextLine());
                    System.out.print("Carga horária: ");
                    disciplina.setCargaHoraria(sc.nextInt());
                    sc.nextLine(); // limpar buffer

                    if (Persistencia.obterInstancia().inserir(disciplina)) {
                        System.out.println("Disciplina inserida com sucesso.");
                    } else {
                        System.out.println("REGISTRO REPETIDO");
                    }
                    break;

                case 3: // Inserir matrícula
                    System.out.print("ID matrícula: ");
                    matricula = new Matricula(new Oid(sc.nextLine()));
                    System.out.print("ID aluno: ");
                    matricula.setIdAluno(sc.nextInt());
                    sc.nextLine(); // limpar buffer
                    System.out.print("ID disciplina: ");
                    matricula.setCodDisciplina(sc.nextLine());

                    if (Persistencia.obterInstancia().inserir(matricula)) {
                        System.out.println("Matrícula inserida com sucesso.");
                    } else {
                        System.out.println("REGISTRO REPETIDO");
                    }
                    break;

                case 4: // Alterar aluno
                    System.out.print("ID aluno a alterar: ");
                    aluno = new Aluno(new Oid(sc.nextLine()));
                    System.out.print("Novo nome do aluno: ");
                    aluno.setNome_aluno(sc.nextLine());

                    if (Persistencia.obterInstancia().atualizar(aluno)) {
                        System.out.println("Aluno alterado com sucesso.");
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                    break;

                case 5: // Alterar disciplina
                    System.out.print("ID disciplina a alterar: ");
                    disciplina = new Disciplina(new Oid(sc.nextLine()));
                    System.out.print("Novo nome da disciplina: ");
                    disciplina.setNome_disc(sc.nextLine());
                    System.out.print("Nova carga horária: ");
                    disciplina.setCargaHoraria(sc.nextInt());
                    sc.nextLine();

                    if (Persistencia.obterInstancia().atualizar(disciplina)) {
                        System.out.println("Disciplina alterada com sucesso.");
                    } else {
                        System.out.println("Disciplina não encontrada.");
                    }
                    break;

                case 6: // Excluir aluno
                    System.out.print("ID aluno a excluir: ");
                    aluno = new Aluno(new Oid(sc.nextLine()));
                    if (Persistencia.obterInstancia().excluir(aluno.getOid(), Aluno.class)) {
                        System.out.println("Aluno excluído com sucesso.");
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                    break;

                case 7: // Excluir disciplina
                    System.out.print("ID disciplina a excluir: ");
                    disciplina = new Disciplina(new Oid(sc.nextLine()));
                    if (Persistencia.obterInstancia().excluir(disciplina.getOid(), Disciplina.class)) {
                        System.out.println("Disciplina excluída com sucesso.");
                    } else {
                        System.out.println("Disciplina não encontrada.");
                    }
                    break;

                case 8: // Excluir matrícula
                    System.out.print("ID matrícula a excluir: ");
                    matricula = new Matricula(new Oid(sc.nextLine()));
                    if (Persistencia.obterInstancia().excluir(matricula.getOid(), Matricula.class)) {
                        System.out.println("Matrícula excluída com sucesso.");
                    } else {
                        System.out.println("Matrícula não encontrada.");
                    }
                    break;
            }
        } while (op != 9);

        sc.close();
        System.out.println("Programa encerrado.");
    }
}
