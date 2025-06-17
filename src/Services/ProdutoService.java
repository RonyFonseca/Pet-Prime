package Services;

import Models.Produto;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import static Services.Services.getPath;

public class ProdutoService {
    private static final String FILENAME = getPath()+"estoque.txt";
    private static final String DELIMITER = ";";
    private static Scanner scanner = new Scanner(System.in);
    private List<Produto> produtos = new ArrayList<>();

    public ProdutoService() {
        lerArquivo();
    }

    private void lerArquivo() {
        File file = new File(FILENAME);
        if (!file.exists()) return;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int maxId = 0;
            while ((line = reader.readLine()) != null) {
                Produto produto = Produto.StringDoArquivo(line, DELIMITER);
                if (produto != null) {
                    produtos.add(produto);
                    if (produto.getIdProduto() > maxId) {
                        maxId = produto.getIdProduto();
                    }
                }
            }
            Produto.setProximoId(maxId + 1);
        } catch (IOException e) {
            System.out.println("Erro ao carregar produtos: " + e.getMessage());
        }
    }

    private void salvarArquivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME))) {
            for (Produto produto : produtos) {
                writer.write(produto.ArquivoString(DELIMITER));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar produtos: " + e.getMessage());
        }
    }

    public void salvar(Produto produto) {
        produtos.removeIf(p -> p.getIdProduto() == produto.getIdProduto());
        produtos.add(produto);
        produtos.sort((p1,p2) -> Integer.compare(p1.getIdProduto(), p2.getIdProduto()));
        salvarArquivo();
    }

    public Optional<Produto> buscarPorId(int id) {
        return produtos.stream().filter(p -> p.getIdProduto() == id).findFirst();
    }

    public List<Produto> listarTodos() {
        return new ArrayList<>(produtos);
    }

    public boolean remover(int id) {
        boolean removed = produtos.removeIf(p -> p.getIdProduto() == id);
        if (removed) salvarArquivo();
        return removed;
    }

    public static String lerString(String msg) {
        System.out.print(msg + ": ");
        return scanner.nextLine().trim();
    }

    public static int lerInteiro(String msg) {
        while (true) {
            try {
                System.out.print(msg + ": ");
                int valor = scanner.nextInt();
                scanner.nextLine();
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                scanner.nextLine();
            }
        }
    }

    public static double lerDouble(String msg) {
        while (true) {
            try {
                System.out.print(msg + ": ");
                double valor = scanner.nextDouble();
                scanner.nextLine();
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número decimal (ex: 10.5).");
                scanner.nextLine();
            }
        }
    }
    public static void exibirMensagem(String msg) {
        System.out.println(msg);
    }
}
