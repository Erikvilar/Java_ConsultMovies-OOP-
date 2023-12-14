
package Classe;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

public class Programa {

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Bem vindo ao CineMovie", "Entre com seus dados para começarmos!", 1);

        String dados[] = new String[4];
        Ingresso ingresso = new Ingresso();
        ArrayList<Cliente> clienteLista = new ArrayList<Cliente>();
        HashMap<Integer, ArrayList<Cliente>> mapeamento = new HashMap<>();

        try {
            int opcao;
            do {
                String menu = "Menu:\n" +
                        "1. Cadastrar-se\n" +
                        "2. Escolher filme\n\n" +
                        "3. Conferir o horario da sua seção\n\n"+
                        "4. Deletar cadastro"+
                        "Editar cadastro"+
                        "Diga nos sua opnião"+
                        "";
                opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
                switch (opcao) {
                    case 1:
                        JOptionPane.showMessageDialog(null, "Cadastrar-se");
                        dados[0] = JOptionPane.showInputDialog("Nome completo:");
                        dados[1] = JOptionPane.showInputDialog("CPF:");
                        dados[2] = JOptionPane.showInputDialog("Email completo:");
                        dados[3] = JOptionPane.showInputDialog("Informe o telefone:");
                        Cliente cliente = new Cliente(dados[0], dados[1], dados[2], dados[3]);
                        clienteLista.add(cliente);
                        int cont = lerValorContador();
                        for (Cliente c : clienteLista) {
                            mapeamento.put(cont, clienteLista);
                            writeInArchive(cont, clienteLista, "ClientesCadastrados.txt");
                            cont++;
                        }
                        salvarValorContador(cont);
                        JOptionPane.showMessageDialog(null, "Cadastro realizado!");
                        break;
                        case 2:

                        String lista = ingresso.getTodosFilmes();
                        ingresso.filmesRegistrados("Catalogo de filmes.txt");
                        String op = JOptionPane.showInputDialog("Lista de todos filmes catalogados:\n" + lista)
                                .toUpperCase();
                        double preço;
                        double pagamento;
                        int keyMovie = ingresso.getKeyMovie(op);
                        boolean condição = true;
                        do {
                            keyMovie = ingresso.getKeyMovie(op);
                            if (keyMovie == -1) {
                                JOptionPane.showMessageDialog(null, "Filme não encontrado!", "", 3);

                                op = JOptionPane.showInputDialog("Lista de todos filmes catalogados:\n" + lista)
                                        .toUpperCase();
                                System.out.println("Filme digitado " + op);
                            } else {
                                JOptionPane.showMessageDialog(null, "Filme " + op + " adicionado a sua lista!");
                                condição = false;
                            }
                        } while (condição == true);

                        switch (keyMovie) {

                            case 1:
                                preço = 25.00;
                                pagamento = Double.parseDouble(JOptionPane.showInputDialog(
                                        "O filme escolhido está no preço fora da promoção de: R$" + preço));
                                if (preço == pagamento || preço < pagamento) {
                                    int id = lerValorContador();
                                    ingresso.registrarVenda(id, pagamento, op);
                                    JOptionPane.showMessageDialog(null, "Compra realizada com sucesso");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Saldo insuficiente para compra");

                                }

                                break;

                            case 2:
                                preço = 24.50;
                                pagamento = Double.parseDouble(JOptionPane.showInputDialog(
                                        "O filme escolhido está no preço fora da promoção de: R$" + preço));
                                if (preço == pagamento || preço < pagamento) {
                                    int id = lerValorContador();
                                    ingresso.registrarVenda(id, pagamento, op);
                                    JOptionPane.showMessageDialog(null, "Compra realizada com sucesso");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Saldo insuficiente para compra");

                                }
                                break;

                            case 3:
                                preço = 30.00;
                                pagamento = Double.parseDouble(JOptionPane.showInputDialog(
                                        "O filme escolhido está no preço fora da promoção de: R$" + preço));
                                if (preço == pagamento || preço < pagamento) {
                                    int id = lerValorContador();
                                    ingresso.registrarVenda(id, pagamento, op);
                                    JOptionPane.showMessageDialog(null, "Compra realizada com sucesso");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Saldo insuficiente para compra");

                                }
                                break;

                            case 4:
                                preço = 35.00;
                                pagamento = Double.parseDouble(
                                        JOptionPane.showInputDialog("O filme escolhido está na promoção!: R$" + preço));
                                if (preço == pagamento || preço < pagamento) {
                                    int id = lerValorContador();
                                    ingresso.registrarVenda(id, pagamento, op);
                                    JOptionPane.showMessageDialog(null, "Compra realizada com sucesso");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Saldo insuficiente para compra");

                                }
                                break;

                            case 5:

                                preço = 30.00;
                                pagamento = Double.parseDouble(JOptionPane.showInputDialog(
                                        "O filme escolhido está no preço fora da promoção de: R$" + preço));
                                if (preço == pagamento || preço < pagamento) {
                                    int id = lerValorContador();
                                    ingresso.registrarVenda(id, pagamento, op);
                                    JOptionPane.showMessageDialog(null, "Compra realizada com sucesso");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Saldo insuficiente para compra");

                                }
                                break;
                            default:
                                preço = 20;
                                pagamento = Double.parseDouble(JOptionPane.showInputDialog(
                                        "O filme escolhido está no preço fora da promoção de: R$" + preço));
                                if (preço == pagamento || preço < pagamento) {
                                    int id = lerValorContador();
                                    ingresso.registrarVenda(id, pagamento, op);
                                    JOptionPane.showMessageDialog(null, "Compra realizada com sucesso");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Saldo insuficiente para compra");

                                }
                                break;

                              
                        } 
                        
                        case 3:
                        JOptionPane.showMessageDialog(null,"Seções de segunda a quarta começam após as 12:00!" );
                        
                        ingresso.adicionarHorariosSalas("HOMEM ARANHA ATRAVES DO ARANHA VERSO", "20-12-2020 : 15:00 - Dublado - Sala 4");
                        ingresso.adicionarHorariosSalas("HOMEM ARANHA ATRAVES DO ARANHA VERSO", "20-12-2020 : 17:10 - Legendado - Sala DMAX");
                        ingresso.adicionarHorariosSalas("MISSÃO IMPOSSIVEL PROTOCOLO FANTASMA", "20-12-2020 : 19:50 - Legendado - Sala DMAX");
                        ingresso.adicionarHorariosSalas("A FREIRA 2", "20-12-2020 : 21:30 - Dublado - Sala Sala 5");
                         JOptionPane.showMessageDialog(null, "Verifique sua seção! Não perca!");
                        String filmeEscolhido;
                        do {
                           
                            filmeEscolhido = JOptionPane.showInputDialog("Filme que irá assistir:\nPara voltar ao menu digite Sair ou S");
                                String horario = ingresso.getHorariosSalas(filmeEscolhido);
                                JOptionPane.showMessageDialog(null, horario);
                              System.out.println(filmeEscolhido);
                        }while (!filmeEscolhido.equals("SAIR") && !filmeEscolhido.equals("S")) ;
                        
                            break;
                        case 4:
                        JOptionPane.showMessageDialog(null, "Que pena vai nos deixar :(\n Voce sempre sera bem vindo! )");
                        String nome = JOptionPane.showInputDialog( "Informe seu primeiro nome");
                      
                        deletarUsuarioPorNome(nome, "ClientesCadastrados.txt");

                        break;
                        case 5:
                            break;
                        case 6:
                            break;
                        case 7:
                            break;


                       
                    default:

                }

            }while(opcao!=0);

        } catch (InputMismatchException e) {
            JOptionPane.showMessageDialog(null, "Deu erro", "Erro", 0);
        }catch(NumberFormatException e){
            System.out.println("Um erro em tempo de execução ocorreu por causa de um Integer\n 0 Processos foram afetados\n programa fechado inesperadamente.");
        }
    }

    public static void writeInArchive(int id, ArrayList<Cliente> clientes, String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            for (Cliente cliente : clientes) {
                id = lerValorContador();
                String linha = "ID " + id + cliente.toString();
                escreverLinha(writer, linha);

            }
        } catch (IOException e) {
            System.err.println("Erro ao gravar no arquivo: " + e.getMessage());
        }
    }

    public static void escreverLinha(BufferedWriter writer, String linha) throws IOException {
        writer.write(linha);
        writer.newLine();
    }

    public static int lerValorContador() {
        int valor = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("contador.txt"))) {
            String linha;

            if ((linha = br.readLine()) != null) {
                valor = Integer.parseInt(linha);

            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o contador: " + e.getMessage());
        }
        return valor;
    }

    public static void salvarValorContador(int valor) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("contador.txt"))) {

            bw.write(Integer.toString(valor));

        } catch (IOException e) {
            System.err.println("Erro ao salvar o contador: " + e.getMessage());
        }
    }

    public static void deletarUsuarioPorNome(String nome, String nomeArquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo));
             BufferedWriter writer = new BufferedWriter(new FileWriter("temp.txt"))) {
    
            String linha;
            boolean deletou = false;
            while ((linha = reader.readLine()) != null) {
            
                if (linha.startsWith("ID") && linha.contains(nome)) {
                    deletou = true;
                    continue; 
                }
              
                writer.write(linha);
                writer.newLine();
            }
    
            if (!deletou) {
                System.out.println("Usuário não encontrado.");
                return; 
            }
    
        } catch (IOException e) {
            System.err.println("Erro ao deletar o usuário: " + e.getMessage());
            return;
        }
    
      
        File original = new File(nomeArquivo);
        File tempFile = new File("temp.txt");
        if (tempFile.renameTo(original)) {
            System.out.println("Usuário removido com sucesso!");
        } else {
            System.out.println("Falha ao remover o usuário.");
        }
    }
}
