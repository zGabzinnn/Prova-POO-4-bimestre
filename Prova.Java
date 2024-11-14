abstract class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        setNome(nome);
        setIdade(idade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && nome.length() >= 3) {
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("Nome deve ter pelo menos 3 caracteres.");
        }
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade > 0) {
            this.idade = idade;
        } else {
            throw new IllegalArgumentException("Idade deve ser maior que 0.");
        }
    }
}

interface Trabalhador {
    void trabalhar();
    double receberSalario();
}

interface Estudante {
    void estudar();
    int tirarNota();
    int tirarNota(String comentario);
}

class PessoaTrabalhadoraEstudante extends Pessoa implements Trabalhador, Estudante {
    private double salario;
    private int nota;

    public PessoaTrabalhadoraEstudante(String nome, int idade, double salario) {
        super(nome, idade);
        if (salario >= 0) {
            this.salario = salario;
        } else {
            throw new IllegalArgumentException("Salário não pode ser negativo.");
        }
    }

    public void trabalhar() {
        System.out.println(getNome() + " está trabalhando.");
    }

    public double receberSalario() {
        return salario;
    }

    public void estudar() {
        System.out.println(getNome() + " está estudando.");
    }

    public int tirarNota() {
        return nota;
    }

    public int tirarNota(String comentario) {
        System.out.println("Comentário: " + comentario);
        return nota;
    }

    public void setNota(int nota) {
        if (nota >= 0 && nota <= 10) {
            this.nota = nota;
        } else {
            throw new IllegalArgumentException("Nota deve ser entre 0 e 10.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            PessoaTrabalhadoraEstudante p1 = new PessoaTrabalhadoraEstudante("João", 25, 3000);
            p1.setNota(8);
            p1.trabalhar();
            p1.estudar();
            System.out.println("Salário: " + p1.receberSalario());
            System.out.println("Nota: " + p1.tirarNota());
            p1.tirarNota("Excelente desempenho!");

            PessoaTrabalhadoraEstudante p2 = new PessoaTrabalhadoraEstudante("Ana", 20, 3500);
            p2.setNota(7);
            p2.trabalhar();
            p2.estudar();
            System.out.println("Salário: " + p2.receberSalario());
            System.out.println("Nota: " + p2.tirarNota());

            PessoaTrabalhadoraEstudante p3 = new PessoaTrabalhadoraEstudante("Lu", 30, 4000); // Deve lançar exceção
            p3.setNota(9);
            p3.trabalhar();
            p3.estudar();
            System.out.println("Salário: " + p3.receberSalario());
            System.out.println("Nota: " + p3.tirarNota());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
