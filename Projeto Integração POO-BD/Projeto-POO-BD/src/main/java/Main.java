import br.inatel.DAO.*;
import Model.Tecnico;
import Model.Time;
import Model.Jogadores;
import Model.Campeonato;
import Model.TimeHasCampeonato;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static TecnicoDAO tecnicoDAO = new TecnicoDAO();
    private static TimeDAO timeDAO = new TimeDAO();
    private static JogadoresDAO jogadoresDAO = new JogadoresDAO();
    private static void adicionarTecnico() {
        System.out.print("Digite os dados necessários -> CPF, nome, idade e títulos: ");
        int cpf = scanner.nextInt();
        scanner.nextLine();
        String nome = scanner.nextLine();
        int idade = scanner.nextInt();
        scanner.nextLine();
        int titulos = scanner.nextInt();
        scanner.nextLine();
        Tecnico tecnico = new Tecnico(cpf, nome, idade, titulos);
        tecnicoDAO.insertTecnico(tecnico);
        System.out.println("Técnico adicionado com sucesso!");
    }
    private static void adicionarTime() {
        System.out.print("Digite os dados necessários -> Nome, mascote e CPF do técnico responsável: ");
        String nome = scanner.nextLine();
        String mascote = scanner.nextLine();
        int tecnicoCpf = scanner.nextInt();
        scanner.nextLine();
        Time time = new Time(nome, mascote, tecnicoCpf);
        timeDAO.insertTime(time);
        System.out.println("Time adicionado com sucesso!");
    }
    private static void adicionarJogadores() {
        System.out.print("Digite os dados necessários -> CPF, nome, altura, peso, número da camisa e nome do time que ele joga: ");
        int cpf = scanner.nextInt();
        scanner.nextLine();
        String nome = scanner.nextLine();
        int altura = scanner.nextInt();
        scanner.nextLine();
        int peso = scanner.nextInt();
        scanner.nextLine();
        int n_da_camisa = scanner.nextInt();
        scanner.nextLine();
        String timeNome = scanner.nextLine();
        Jogadores jogador = new Jogadores(cpf, nome, altura, peso, n_da_camisa, timeNome);
        jogadoresDAO.insertJogadores(jogador);
        System.out.println("Jogador adicionado com sucesso!");
    }

    public static void main(String[] args) {

        Tecnico t1 = new Tecnico(71809, "Thiago",50, 30);
        tecnicoDAO.insertTecnico(t1);

        Time time1 = new Time("Chute de Ouro FC", "raposa", 71809);
        timeDAO.insertTime(time1);

        Jogadores j1 = new Jogadores(12345,"Joao",169,72,6,"Chute de Ouro FC");
        Jogadores j2 = new Jogadores(67890,"Pedro",188,85,4,"Chute de Ouro FC");
        Jogadores j3 = new Jogadores(54321,"Lucas",175,78,8,"Chute de Ouro FC");
        Jogadores j4 = new Jogadores(18403,"Gabriel",170,75,7,"Chute de Ouro FC");
        Jogadores j5 = new Jogadores(89356,"Henrique",180,80,9,"Chute de Ouro FC");
        Jogadores j6 = new Jogadores(34907,"Guilherme",185,83,5,"Chute de Ouro FC");

        jogadoresDAO.insertJogadores(j1);
        jogadoresDAO.insertJogadores(j2);
        jogadoresDAO.insertJogadores(j3);
        jogadoresDAO.insertJogadores(j4);
        jogadoresDAO.insertJogadores(j5);
        jogadoresDAO.insertJogadores(j6);
        jogadoresDAO.updateJogadoresNumeroCamisa(67890,10);
        jogadoresDAO.selectJogadores();
        jogadoresDAO.deleteJogadores(34907);

        CampeonatoDAO campeonatoDAO = new CampeonatoDAO();
        Campeonato c1 = new Campeonato("Sub 20 municipal", "Troféu e medalhas", "Santa rita do Sapucaí - MG");
        Campeonato c2 = new Campeonato("Sub 20 regional", "Troféu, medalhas e R$10.000,00", "Minas Gerais");
        campeonatoDAO.insertCampeonato(c1);
        campeonatoDAO.insertCampeonato(c2);

        TimeCampDAO timeCampDAO = new TimeCampDAO();
        TimeHasCampeonato tc1 = new TimeHasCampeonato("Chute de Ouro FC","Sub 20 municipal");
        TimeHasCampeonato tc2 = new TimeHasCampeonato("Chute de Ouro FC","Sub 20 regional");
        timeCampDAO.insertTimeCamp(tc1);
        timeCampDAO.insertTimeCamp(tc2);

        while (true) {
            System.out.println("Escolha o que deseja adicionar:");
            System.out.println("1 -> Técnico");
            System.out.println("2 -> Time");
            System.out.println("3 -> Jogador");
            System.out.println("0. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (opcao) {
                case 1:
                    adicionarTecnico();
                    break;
                case 2:
                    adicionarTime();
                    break;
                case 3:
                    adicionarJogadores();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Essa opção não é aceita, faça uma nova escolha");
            }
        }
    }
}
