import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GerenciadorDeVeiculo gerenciadorDeVeiculo = new GerenciadorDeVeiculo();
        gerenciadorDeVeiculo.listarVeiculos();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Cadastrando Veiculo...");
        String placa = "";
        while (placa.isEmpty()) {
            System.out.print("Informe a placa: ");
            placa = scanner.nextLine();
        }

        String tipo = "";
        while (tipo.isEmpty() || !tipo.equalsIgnoreCase("PEQUENO") &&
                !tipo.equalsIgnoreCase("MEDIO") && !tipo.equalsIgnoreCase("SUV")) {
            System.out.print("Informe o tipo do carro (PEQUENO, MEDIO ou SUV): ");
            tipo = scanner.nextLine();
        }

        gerenciadorDeVeiculo.cadastrarVeiculo(placa, tipo);
        gerenciadorDeVeiculo.listarVeiculos();

        System.out.println("-----------------------------------------------------");

        System.out.println("Atualizando Veículo...");
        String placaAntiga = "";
        while (placaAntiga.isEmpty()) {
            System.out.print("Informe a placa antiga: ");
            placaAntiga = scanner.nextLine();
        }

        System.out.print("Informe a nova placa, ou enter para manter a mesma: ");
        String placaNova = scanner.nextLine();

        String tipoNovo = null;
        while(tipoNovo == null ||
                !(tipoNovo.isEmpty() || tipoNovo.equalsIgnoreCase("PEQUENO") ||
                tipoNovo.equalsIgnoreCase("MEDIO") || tipoNovo.equalsIgnoreCase("SUV"))) {
            System.out.print("Informe o novo tipo do carro (PEQUENO, MEDIO ou SUV), ou enter para manter o mesmo: ");
            tipoNovo = scanner.nextLine();
        }

        gerenciadorDeVeiculo.alterarVeiculo(placaAntiga, placaNova, tipoNovo);
        gerenciadorDeVeiculo.listarVeiculos();

        System.out.println("-----------------------------------------------------");

        System.out.println("Buscando placa...");
        String termoDeBusca = "";
        while (termoDeBusca.isEmpty()) {
            System.out.print("Informe a placa, ou parte dela, para pesquisar o carro: ");
            termoDeBusca = scanner.nextLine();
        }

        System.out.println(gerenciadorDeVeiculo.buscarVeiculo(termoDeBusca));

        System.out.println();
        System.out.println("----- Gerenciamndo de pessoas -----");
        System.out.println();

        GerenciadorDePessoa gerenciadorDePessoa = new GerenciadorDePessoa();
        gerenciadorDePessoa.listarPessoas();
        System.out.println("Cadastrando Pessoas...");
        String nome = "";
        while (nome.isEmpty()) {
            System.out.print("Informe o nome: ");
            nome = scanner.nextLine();
        }

        String doc = "";
        while (doc.isEmpty() || (doc.length() == 12) || (doc.length() == 16)) {
            System.out.print("Informe o CPF ou CNPJ: ");
            doc = scanner.nextLine();
        }

        gerenciadorDePessoa.cadastrarPessoa(nome, doc);
        gerenciadorDePessoa.listarPessoas();

        System.out.println("Buscando documento..");
        termoDeBusca = "";
        while (termoDeBusca.isEmpty()) {
            System.out.print("Informe o número do documento, ou parte dele, para pesquisar por Pessoa: ");
            termoDeBusca = scanner.nextLine();
        }
        System.out.println(gerenciadorDePessoa.buscarPessoa(termoDeBusca));



    }
}