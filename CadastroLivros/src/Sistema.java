import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    private static List<Livro> livros = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            // Display menu
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar novo livro");
            System.out.println("2 - Ver todos os livros");
            System.out.println("3 - Ver todos os livros de um gênero");
            System.out.println("4 - Buscar um livro por título ou autor");
            System.out.println("9 - Sair");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarLivro(scanner);
                    break;
                case 2:
                    verLivros();
                    break;
                case 3:
                    verLivrosPorGenero(scanner);
                    break;
                case 4:
                    buscarLivro(scanner);
                    break;
                case 9:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 9);
    }

    private static void cadastrarLivro(Scanner scanner) {
        System.out.println("Digite o título do livro:");
        String titulo = scanner.nextLine();
        System.out.println("Digite o autor do livro:");
        String autor = scanner.nextLine();
        System.out.println("Digite o gênero do livro:");
        String genero = scanner.nextLine();

        Livro novoLivro = new Livro(titulo, autor, genero);
        livros.add(novoLivro);

        System.out.println("Livro cadastrado com sucesso!");
    }

    private static void verLivros() {
        if (livros.isEmpty()) {
            System.out.println("Não há livros cadastrados.");
        } else {
            for (Livro livro : livros) {
                System.out.println(livro);
            }
        }
    }

    private static void verLivrosPorGenero(Scanner scanner) {
        System.out.println("Digite o gênero:");
        String genero = scanner.nextLine();

        boolean encontrouLivros = false;
        for (Livro livro : livros) {
            if (livro.getGenero().equalsIgnoreCase(genero)) {
                System.out.println(livro);
                encontrouLivros = true;
            }
        }

        if (!encontrouLivros) {
            System.out.println("Nenhum livro encontrado para esse gênero.");
        }
    }

    private static void buscarLivro(Scanner scanner) {
        System.out.println("Digite o título ou autor do livro:");
        String pesquisa = scanner.nextLine();

        boolean encontrouLivro = false;
        for (Livro livro : livros) {
            if (livro.getTitulo().contains(pesquisa) || livro.getAutor().contains(pesquisa)) {
                System.out.println(livro);
                encontrouLivro = true;
            }
        }

        if (!encontrouLivro) {
            System.out.println("Nenhum livro encontrado.");
        }
    }
}


