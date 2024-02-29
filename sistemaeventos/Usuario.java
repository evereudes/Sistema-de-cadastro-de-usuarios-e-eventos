package sistemaeventos;

import java.util.Scanner;

public class Usuario {
    private String nomeCompleto;
    private int idade;
    private String cpf;
    private String email;
    private String bairro;

    // Construtor
    public Usuario(String nomeCompleto, int idade, String cpf, String email, String bairro) {
        this.nomeCompleto = nomeCompleto;
        this.idade = idade;
        this.cpf = cpf;
        this.email = email;
        this.bairro = bairro;
    }

    // Métodos getters para acessar os atributos privados
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public int getIdade() {
        return idade;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getBairro() {
        return bairro;
    }
}

class CadastroUsuario {
    // Método para cadastrar um novo usuário
	public Usuario cadastrarUsuario() {
	    Scanner scanner = new Scanner(System.in);

	    System.out.println("Digite o nome completo do usuário:");
	    String nomeCompleto = scanner.nextLine();

	    System.out.println("Digite a idade do usuário:");
	    int idade = scanner.nextInt();
	    scanner.nextLine(); // Consumir a quebra de linha

	    System.out.println("Digite o CPF do usuário:");
	    String cpf = scanner.nextLine();

	    System.out.println("Digite o e-mail do usuário:");
	    String email = scanner.nextLine();

	    System.out.println("Digite o bairro onde o usuário mora:");
	    String bairro = scanner.nextLine();

	    // Fechar o Scanner após a leitura dos dados
	    scanner.close();

	    // Criando e retornando um novo objeto Usuario com os dados informados
	    return new Usuario(nomeCompleto, idade, cpf, email, bairro);
	}
    
    public static void main(String[] args) {
        CadastroUsuario cadastro = new CadastroUsuario();
        Usuario usuarioCadastrado = cadastro.cadastrarUsuario();

        // Exibindo os dados do usuário cadastrado
        System.out.println("\nUsuário cadastrado:");
        System.out.println("Nome completo: " + usuarioCadastrado.getNomeCompleto());
        System.out.println("Idade: " + usuarioCadastrado.getIdade());
        System.out.println("CPF: " + usuarioCadastrado.getCpf());
        System.out.println("E-mail: " + usuarioCadastrado.getEmail());
        System.out.println("Bairro: " + usuarioCadastrado.getBairro());
    }
}