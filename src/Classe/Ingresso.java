package Classe;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

import java.util.HashMap;

import java.util.Map;

public class Ingresso {
    private float valor;
    private Map<Integer, String> filmes;
    private HashMap<String, String> horariosSalas;
  
   

    public Ingresso() {
        filmes = new HashMap<>();
        horariosSalas = new HashMap<>();
        filmes.put(1, "HOMEM ARANHA ATRAVES DO ARANHA VERSO");
        filmes.put(2, "NAPOLEÃO");
        filmes.put(3, "AQUAMAN E A LEGIÃO SUBMARINA");
        filmes.put(4, "FORD VS FERRARI");
        filmes.put(5, "INTERSTELAR");
        filmes.put(6, "TRANSFORMES E O OUTRO LADO DA LUA NOVAMENTE");
        filmes.put(7, "HOMEM FORMIGA QUANTOMANIA");
        filmes.put(8, "O PORTAL SECRETO");
        filmes.put(9, "MISSÃO IMPOSSIVEL PROTOCOLO FANTASMA");
        filmes.put(10, "FALE COMIGO");
        filmes.put(11, "BEZOURO AZUL");
        filmes.put(12, "A CHAMADA");
        filmes.put(13, "A FREIRA 2");
        
        
      
    }
  
    public void adicionarHorariosSalas(String filme, String horarios) {
        horariosSalas.put(filme, horarios);
    }
 public String getHorariosSalas(String filme) {
        return horariosSalas.get(filme);
    }

    public String getTodosFilmes() {
        StringBuilder listaFilmes = new StringBuilder();
        for (String filme : filmes.values()) {
            listaFilmes.append(filme).append("\n");
        }
        return listaFilmes.toString();
    }
    public int getKeyMovie(String filmeProcurado) {
        for (Map.Entry<Integer, String> entry : filmes.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(filmeProcurado)) {
                return entry.getKey();
            }
        }
        return -1; 
    }

    public void filmesRegistrados(String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            String listaFilmes = getTodosFilmes();
            writer.write("Lista de todos os filmes:\n" + listaFilmes);
            System.out.println("Filmes escritos no arquivo " + nomeArquivo + " com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
      public void registrarVenda(int idCliente, double valorCompra, String nomeFilme) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("vendas.txt", true))) {
            LocalDateTime dataHora = LocalDateTime.now();
            writer.write("Data/Hora: " + dataHora + ", ID Cliente: " + idCliente +
                    ", Filme: " + nomeFilme + ", Valor da Compra: R$" + valorCompra + "\n");
            System.out.println("Venda registrada com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao registrar a venda: " + e.getMessage());
        }
    }


    public String getFilme(int codigo) {
        return filmes.get(codigo);
    }

    public void adicionarFilme(int codigo, String nome) {
        filmes.put(codigo, nome);
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
     public HashMap<String, String> getHorariosSalas() {
        return horariosSalas;
    }

    public void setHorariosSalas(HashMap<String, String> horariosSalas) {
        this.horariosSalas = horariosSalas;
    }

 
}
