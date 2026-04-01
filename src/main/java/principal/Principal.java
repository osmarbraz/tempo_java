package principal;

import java.util.Scanner;
import model.Tempo;

public class Principal {

    public static void main(String args[]) {
        Tempo tempo = new Tempo();
        int op = -2;
        Scanner in = new Scanner(System.in);
        while (op != 99) {
            System.out.println(
                    "\n1  - Mudar Horario\n"
                    + "2  - Incrementar segundo\n"
                    + "3  - Incrementar minuto\n"
                    + "4  - Incrementar hora\n"
                    + "5  - Decrementar segundo\n"
                    + "6  - Decrementar minuto\n"
                    + "7  - Decrementar hora\n"
                    + "8  - Mostrar Hora\n"
                    + "9  - Adicionar 2 Tempos\n"
                    + "10 - Segundos entre Tempos\n"
                    + "99 - Sair"
                    + "\nOpção:");
            op = in.nextInt();
            switch (op) {
                case 1:
                    tempo.preencher();
                    break;
                case 2:
                    tempo.incrementaSegundo();
                    break;
                case 3:
                    tempo.incrementaMinuto();
                    break;
                case 4:
                    tempo.incrementaHora();
                    break;
                case 5:
                    tempo.decrementaSegundo();
                    break;
                case 6:
                    tempo.decrementaMinuto();
                    break;
                case 7:
                    tempo.decrementaHora();
                    break;
                case 8:
                    tempo.imprimir();
                    break;
                case 9: {
                    Tempo t1 = new Tempo();
                    t1.preencher();
                    Tempo t2 = new Tempo();
                    t2.preencher();
                    tempo = tempo.adicionaTempos(t1, t2);
                    tempo.imprimir();
                    break;
                }
                case 10: {
                    Tempo t1 = new Tempo();
                    t1.preencher();
                    Tempo t2 = new Tempo();
                    t2.preencher();
                    int saida = tempo.segundosEntre(t1, t2);
                    System.out.println("Segundos: " + saida);
                    break;
                }
                case 99:
                    break;
                default:
                    op = -2;
                    break;
            }
        }
    }
}
