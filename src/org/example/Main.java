package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    // URLs dos Back-ends que já estão rodando
    private static final String URL_USUARIOS = "http://localhost:8081/usuarios";
    private static final String URL_LIVROS = "http://localhost:8082/livros";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HttpClient client = HttpClient.newHttpClient();

        while (true) {
            System.out.println("\n--- SISTEMA SCRIPTA (CLIENTE JAVA) ---");
            System.out.println("1. Listar Usuários (API 8081)");
            System.out.println("2. Listar Livros (API 8082)");
            System.out.println("3. Cadastrar Usuário Rápido");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            if (opcao == 0) break;

            try {
                switch (opcao) {
                    case 1:
                        listar(client, URL_USUARIOS);
                        break;
                    case 2:
                        listar(client, URL_LIVROS);
                        break;
                    case 3:
                        cadastrarUsuario(client, scanner);
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.err.println("Erro ao conectar: " + e.getMessage());
            }
        }
    }

    // Método GET genérico
    private static void listar(HttpClient client, String url) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("\n--- RESPOSTA DO SERVIDOR ---");
        System.out.println("Status: " + response.statusCode());
        System.out.println("Dados: " + response.body());
    }

    // Método POST para criar usuário
    private static void cadastrarUsuario(HttpClient client, Scanner scanner) throws Exception {
        System.out.print("Digite o Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a Matrícula: ");
        String matricula = scanner.nextLine();

        // JSON manual (String block do Java 15+)
        String json = """
                {
                    "nome": "%s",
                    "matricula": "%s",
                    "senha": "SenhaForte123456",
                    "tipoDeConta": "ALUNO"
                }
                """.formatted(nome, matricula);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL_USUARIOS))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200 || response.statusCode() == 201) {
            System.out.println("✅ Usuário cadastrado com sucesso via Java!");
        } else {
            System.out.println("❌ Erro: " + response.body());
        }
    }
}