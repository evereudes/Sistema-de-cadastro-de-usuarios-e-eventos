package sistemaeventos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class SistemaEvento {
    private String nome;
    private String endereco;
    private String categoria;
    private LocalDateTime horario;
    private String descricao;
    private List<String> participantes;

    public SistemaEvento(String nome, String endereco, String categoria, LocalDateTime horario, String descricao) {
        this.nome = nome;
        this.endereco = endereco;
        this.categoria = categoria;
        this.horario = horario;
        this.descricao = descricao;
        this.participantes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCategoria() {
        return categoria;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<String> getParticipantes() {
        return participantes;
    }

    public void adicionarParticipante(String participante) {
        participantes.add(participante);
    }

    public void removerParticipante(String participante) {
        participantes.remove(participante);
    }
}

public class SistemaEventos {
    private List<SistemaEvento> eventos;

    public SistemaEventos() {
        this.eventos = new ArrayList<>();
    }

    public void cadastrarEvento(SistemaEvento evento) {
        eventos.add(evento);
        System.out.println("Evento cadastrado com sucesso!");
    }

    public void mostrarEventos() {
        eventos.sort(Comparator.comparing(SistemaEvento::getHorario)); // Ordenar por horário
        System.out.println("\nLista de eventos cadastrados:");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        for (SistemaEvento evento : eventos) {
            System.out.println("Nome: " + evento.getNome());
            System.out.println("Endereço: " + evento.getEndereco());
            System.out.println("Categoria: " + evento.getCategoria());
            System.out.println("Horário: " + evento.getHorario().format(formatter)); // Formatar a data e a hora
            System.out.println("Descrição: " + evento.getDescricao());
            System.out.println();
        }
    }

    public void participarEvento(SistemaEvento evento, String participante) {
        evento.adicionarParticipante(participante);
        System.out.println(participante + " confirmou participação no evento " + evento.getNome());
    }

    public void cancelarParticipacao(SistemaEvento evento, String participante) {
        evento.removerParticipante(participante);
        System.out.println(participante + " cancelou participação no evento " + evento.getNome());
    }

    public static void main(String[] args) {
        SistemaEventos sistema = new SistemaEventos();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar evento");
            System.out.println("2. Mostrar eventos cadastrados");
            System.out.println("3. Participar de um evento");
            System.out.println("4. Cancelar participação em um evento");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
            case 1:
                System.out.println("\nCadastro de evento:");
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("Endereço: ");
                String endereco = scanner.nextLine();
                System.out.print("Categoria (festas, eventos esportivos, shows, missas em igreja): ");
                String categoria = scanner.nextLine();
                LocalDateTime horario = null;
                boolean dataValida = false;
                do {
                	System.out.print("Horário (formato DD-MM-YYYY HH:MM, por exemplo, 01-03-2024 18:00): ");
                	String horarioStr = scanner.nextLine();
                	try {
                	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                	    horario = LocalDateTime.parse(horarioStr, formatter);
                	    if (horario.toLocalDate().isAfter(LocalDate.now())) {
                	        dataValida = true;
                	    } else {
                	        System.out.println("Data anterior à data atual. Tente novamente.");
                	    }
                	} catch (DateTimeParseException e) {
                	    System.out.println("Formato de data/horário inválido. Tente novamente.");
                	}

                } while (!dataValida);
                System.out.print("Descrição: ");
                String descricao = scanner.nextLine();

                SistemaEvento evento = new SistemaEvento(nome, endereco, categoria, horario, descricao);
                sistema.cadastrarEvento(evento);
                break;

            case 2:
                sistema.mostrarEventos();
                break;
                case 3:
                    // Código para participar de um evento
                    break;
                case 4:
                    // Código para cancelar participação em um evento
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    scanner.close(); // Fechar o scanner antes de sair do programa
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }
}
