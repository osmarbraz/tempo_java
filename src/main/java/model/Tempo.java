/**
 * b)
 */
package model;

import java.util.Scanner;

public class Tempo {

    /**
     * a)
     */
    private int hora;
    private int minuto;
    private int segundo;

    /**
     * d)
     */
    //Construtor sem parâmetros
    public Tempo() {
        this(0, 0, 0);
    }

    //construtor com parâmetros strings
    public Tempo(String hora, String minuto, String segundo) {
        setHora(hora);
        setMinuto(minuto);
        setSegundo(segundo);
        System.out.println("Tempo: " + hora + ":" + minuto + ":" + segundo);
    }

    //construtor com parâmetros int
    public Tempo(int hora, int minuto, int segundo) {
        setHora(hora);
        setMinuto(minuto);
        setSegundo(segundo);
        System.out.println("Tempo: " + hora + ":" + minuto + ":" + segundo);
    }

    /**
     * c)
     */
    //sets
    public void setHora(int hora) {
        this.hora = validaDado(hora, 'h');
    }

    public void setHora(String hora) {
        this.hora = validaDado(hora, 'h');
    }

    public void setMinuto(int minuto) {
        this.minuto = validaDado(minuto, 'm');
    }

    public void setMinuto(String minuto) {
        this.minuto = validaDado(minuto, 'm');
    }

    public void setSegundo(int segundo) {
        this.segundo = validaDado(segundo, 's');
    }

    public void setSegundo(String segundo) {
        this.segundo = validaDado(segundo, 's');
    }

    //gets
    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public int getSegundo() {
        return segundo;
    }

    /**
     * f)
     */
    //valida entradas com strings
    public int validaDado(String _dado, char tipo) {
        if (!_dado.equals("")) {
            int dado = Integer.parseInt(_dado);
            dado = validaDado(dado, tipo);
            return dado;
        } else {
            return 0;
        }
    }

    /**
     * f)
     */
    //valida dados com inteiros
    public int validaDado(int dado, char tipo) {
        if ((tipo == 'h' && (dado < 0 || dado > 23))
                || (tipo == 'm' && (dado < 0 || dado > 59))
                || (tipo == 's' && (dado < 0 || dado > 59))) {
            dado = 0;
        }
        return dado;
    }

    /**
     * g)
     */
    //pede valores e preenche o objeto
    public void preencher() {
        Scanner in = new Scanner(System.in);
        System.out.println("Tempo:\nHora:");
        setHora(in.nextInt());
        System.out.println("Tempo:\nMinuto:");
        setMinuto(in.nextInt());
        System.out.println("Tempo:\nSegundo:");
        setSegundo(in.nextInt());
    }

    /**
     * h)
     */
    //imprime valores na tela
    public void imprimir() {
        System.out.println("Hora atual:" + horaAtual());
    }

    //incrementos
    /**
     * k)
     */
    public void incrementaHora() {
        int hora = getHora() + 1;
        if (hora > 23) {
            hora = 0;
        }
        setHora(hora);
    }

    /**
     * j)
     */
    public void incrementaMinuto() {
        int min = getMinuto() + 1;
        if (min > 59) {
            incrementaHora();
            min = 0;
        }
        setMinuto(min);
    }

    /**
     * i)
     */
    public void incrementaSegundo() {
        int seg = getSegundo() + 1;
        if (seg > 59) {
            seg = 0;
            incrementaMinuto();
        }
        setSegundo(seg);
    }

    //decrementos
    /**
     * n)
     */
    public void decrementaHora() {
        int hora = getHora() - 1;
        if (hora < 0) {
            hora = 23;
        }
        setHora(hora);
    }

    /**
     * m)
     */
    public void decrementaMinuto() {
        int min = getMinuto() - 1;
        if (min < 0) {
            min = 59;
            decrementaHora();
        }
        setMinuto(min);
    }

    /**
     * l)
     */
    public void decrementaSegundo() {
        int seg = getSegundo() - 1;
        if (seg < 0) {
            seg = 59;
            decrementaMinuto();
        }
        setSegundo(seg);
    }

    /**
     * o)
     */
    //retorna um string do tipo hh:mm:ss
    public String horaAtual() {
        String saida = "";
        int hora = getHora();
        int minuto = getMinuto();
        int segundo = getSegundo();
        if (hora < 10) {
            saida += "0";
        }
        saida += hora + ":";
        if (minuto < 10) {
            saida += "0";
        }
        saida += minuto + ":";
        if (segundo < 10) {
            saida += "0";
        }
        saida += segundo;
        return saida;
    }

    /**
     * p)
     */
    //retorna um obj da classe Tempo com a soma de t1 e t2
    public Tempo adicionaTempos(Tempo t1, Tempo t2) {
        int hora = 0, minuto = 0, segundo = 0;

        segundo += t1.getSegundo() + t2.getSegundo();
        if (segundo >= 60) {
            minuto++;
            segundo -= 60;
        }

        minuto += t1.getMinuto() + t2.getMinuto();
        if (minuto >= 60) {
            hora++;
            minuto -= 60;
        }

        hora += t1.getHora() + t2.getHora();
        if (hora >= 24) {
            hora -= 24;
        }
        Tempo t = new Tempo(hora, minuto, segundo);
        return t;
    }

    /**
     * q)
     */
    //retorna quantos segundos entre t1 e t2
    public int segundosEntre(Tempo t1, Tempo t2) {
        int segundosT1 = t1.getHora() * 3600 + t1.getMinuto() * 60 + t1.getSegundo();
        int segundosT2 = t2.getHora() * 3600 + t2.getMinuto() * 60 + t2.getSegundo();
        int resultado = segundosT1 - segundosT2;
        if (resultado < 0) {
            resultado *= -1;
        }
        return resultado;
    }
}
