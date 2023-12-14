
package Classe;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Programa {

    public static void main(String[] args) {
        
        ImageIcon erro = new ImageIcon("img/erro.png");
        ImageIcon confirme = new ImageIcon("img/confirme.png");
        ImageIcon aviso = new ImageIcon("img/aviso.png");
        ImageIcon Usuario = new ImageIcon("img/usuario.png");
        ImageIcon cinema = new ImageIcon("img/cinema.png");


        String dados[] = new String[4];
        Ingresso ingresso = new Ingresso();
        ArrayList<Cliente> clienteLista = new ArrayList<Cliente>();
      JOptionPane.showMessageDialog(null, "Bem vindo ao CineMovie", "Entre com seus dados para começarmos!", JOptionPane.PLAIN_MESSAGE,cinema);

        try {
            int opcao;
            do {
                String menu = "Menu:\n" +
                        "1. Cadastrar-se\n" +
                        "2. Escolher filme\n" +
                        "3. Conferir o horario da sua seção\n"+
                        "4. Deletar cadastro\n"+
                        "5.Editar cadastro\n"+
                        "6.Diga nos sua opnião\n"+
                        "";
                opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
                switch (opcao) {
                    case 1:
                    JOptionPane.showMessageDialog(null, "Cadastrar-se","Bem vindo ao cadastro",JOptionPane.PLAIN_MESSAGE,Usuario);
                    dados[0] = JOptionPane.showInputDialog("Nome completo:");
                    dados[1] = JOptionPane.showInputDialog("CPF:");
                    dados[2] = JOptionPane.showInputDialog("Email completo:");
                    dados[3] = JOptionPane.showInputDialog("Informe o telefone:");
                    
                    for (int i = 0; i < dados.length; i++) {
                        while (dados[i] == null || dados[i].isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo não pode estar vazio. Por favor, digite novamente:","Erro",JOptionPane.ERROR_MESSAGE,erro);
                    dados[0] = JOptionPane.showInputDialog("Nome completo:");
                    dados[1] = JOptionPane.showInputDialog("CPF:");
                    dados[2] = JOptionPane.showInputDialog("Email completo:");
                    dados[3] = JOptionPane.showInputDialog("Informe o telefone:");
                        }
                    }
                        
                    
                    Cliente cliente = new Cliente(dados[0], dados[1], dados[2], dados[3]);
                    clienteLista.add(cliente);
                    int cont = lerValorContador();
                        
                    writeInArchive(cont, clienteLista, "ClientesCadastrados.txt");
                    cont++;
                        salvarValorContador(cont);
                        JOptionPane.showMessageDialog(null, "Cadastro realizado!","CADASTRO REALIZADO",JOptionPane.PLAIN_MESSAGE,confirme);
                        
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
                                JOptionPane.showMessageDialog(null, "Filme não encontrado!", "", JOptionPane.PLAIN_MESSAGE, aviso);

                                op = JOptionPane.showInputDialog("Lista de todos filmes catalogados:\n" + lista)
                                        .toUpperCase();
                                System.out.println("Filme digitado " + op);
                            } else {
                                JOptionPane.showMessageDialog(null, "Filme " + op + " adicionado a sua lista!","FILME ADICIONADO",JOptionPane.ERROR_MESSAGE,confirme);
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
                                   JOptionPane.showMessageDialog(null,"Compra realizada com sucesso","Pagamento realizado!",JOptionPane.ERROR_MESSAGE,confirme);
                                    
                                } else {
                                     JOptionPane.showMessageDialog(null, "Saldo insuficiente para compra","SALDO INSUFICIENTE",JOptionPane.ERROR_MESSAGE,erro);

                                }

                                break;

                            case 2:
                                preço = 24.50;
                                pagamento = Double.parseDouble(JOptionPane.showInputDialog(
                                        "O filme escolhido está no preço fora da promoção de: R$" + preço));
                                if (preço == pagamento || preço < pagamento) {
                                    int id = lerValorContador();
                                    ingresso.registrarVenda(id, pagamento, op);
                                   JOptionPane.showMessageDialog(null,"Compra realizada com sucesso","Pagamento realizado!",JOptionPane.ERROR_MESSAGE,confirme);
                                } else {
                                  JOptionPane.showMessageDialog(null, "Saldo insuficiente para compra","SALDO INSUFICIENTE",JOptionPane.ERROR_MESSAGE,erro);

                                }
                                break;

                            case 3:
                                preço = 30.00;
                                pagamento = Double.parseDouble(JOptionPane.showInputDialog(
                                        "O filme escolhido está no preço fora da promoção de: R$" + preço));
                                if (preço == pagamento || preço < pagamento) {
                                    int id = lerValorContador();
                                    ingresso.registrarVenda(id, pagamento, op);
                                 JOptionPane.showMessageDialog(null,"Compra realizada com sucesso","Pagamento realizado!",JOptionPane.ERROR_MESSAGE,confirme);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Saldo insuficiente para compra","SALDO INSUFICIENTE",JOptionPane.ERROR_MESSAGE,erro);

                                }
                                break;

                            case 4:
                                preço = 35.00;
                                pagamento = Double.parseDouble(
                                        JOptionPane.showInputDialog("O filme escolhido está na promoção!: R$" + preço));
                                if (preço == pagamento || preço < pagamento) {
                                    int id = lerValorContador();
                                    ingresso.registrarVenda(id, pagamento, op);
                                   JOptionPane.showMessageDialog(null,"Compra realizada com sucesso","Pagamento realizado!",JOptionPane.ERROR_MESSAGE,confirme);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Saldo insuficiente para compra","SALDO INSUFICIENTE",JOptionPane.ERROR_MESSAGE,erro);

                                }
                                break;

                            case 5:

                                preço = 30.00;
                                pagamento = Double.parseDouble(JOptionPane.showInputDialog(
                                        "O filme escolhido está no preço fora da promoção de: R$" + preço));
                                if (preço == pagamento || preço < pagamento) {
                                    int id = lerValorContador();
                                    ingresso.registrarVenda(id, pagamento, op);
                                      JOptionPane.showMessageDialog(null,"Compra realizada com sucesso","Pagamento realizado!",JOptionPane.ERROR_MESSAGE,confirme);
                                } else {
                                   JOptionPane.showMessageDialog(null, "Saldo insuficiente para compra","SALDO INSUFICIENTE",JOptionPane.ERROR_MESSAGE,erro);

                                }
                                break;
                            default:
                                preço = 20;
                                pagamento = Double.parseDouble(JOptionPane.showInputDialog(
                                        "O filme escolhido está no preço fora da promoção de: R$" + preço));
                                if (preço == pagamento || preço < pagamento) {
                                    int id = lerValorContador();
                                    ingresso.registrarVenda(id, pagamento, op);
                                     JOptionPane.showMessageDialog(null,"Compra realizada com sucesso","Pagamento realizado!",JOptionPane.ERROR_MESSAGE,confirme);
                                } else {
                                 JOptionPane.showMessageDialog(null, "Saldo insuficiente para compra","SALDO INSUFICIENTE",JOptionPane.ERROR_MESSAGE,erro);

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
                        String filmeEscolhido = JOptionPane.showInputDialog("Filme que irá assistir:\nPara voltar ao menu digite Sair ou S").toUpperCase();
                        String horario = ingresso.getHorariosSalas(filmeEscolhido);
                        while(filmeEscolhido != null){
                                
                              System.out.println(filmeEscolhido);
                              if(horario == null){
                                JOptionPane.showMessageDialog(null, "Filme escolhido não está em seção hoje");
                              }else{
                                JOptionPane.showMessageDialog(null, horario);
                              }
                        }
                            JOptionPane.showMessageDialog(null, "Use mascara e não se esqueça de pegar seu oculos 3D bom filme!");
                            break;
                        case 4:
                        JOptionPane.showMessageDialog(null, "Que pena vai nos deixar :(\n Voce sempre sera bem vindo! )");
                        String nome = JOptionPane.showInputDialog( "Informe seu primeiro nome");
                        System.out.println("usuario irá deletar seu nome do banco de dados");
                        deletarUsuarioPorNome(nome, "ClientesCadastrados.txt");

                        break;

                        case 5:
                         JOptionPane.showMessageDialog(null, "Claro vamos editar seu cadastro!");
                         String Campo= JOptionPane.showInputDialog("INFORME O CAMPO QUE DESEJA EDITAR\nNome:\nTelefone:\nEmail:\nCPF:").toUpperCase();
                         String ValorAntigo = JOptionPane.showInputDialog("Valor antigo:");
                         int option;
                         do{
                            option =JOptionPane.showConfirmDialog(null, "Tem certeza que deseja alterar o "+Campo+"?","Confirme a alteração",JOptionPane.YES_NO_OPTION); 
                         }while (option != JOptionPane.YES_NO_OPTION); 
                            
                        
                         
                         String novoNome= JOptionPane.showInputDialog("Novo nome");
                         
                         editarInformacaoCliente(ValorAntigo, novoNome, Campo, "ClientesCadastrados.txt");
                            break;
                        case 6:
                            String categoria = JOptionPane.showInputDialog("Diga-nos o que gostaria de avaliar?");
                            int nota = Integer.parseInt(JOptionPane.showInputDialog("Nota:"));
                            String avaliacao = JOptionPane.showInputDialog("Conte-nos sua opnião");
                            RegistrarAvaliacao(categoria, nota,avaliacao, "AvaliaçãoClientes.txt");
                            break;
                       


                       
                    default:
                         JOptionPane.showMessageDialog(null, "Opção invalida!","Erro",JOptionPane.ERROR_MESSAGE,erro);
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
                id++;
                salvarValorContador(id);
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
        ImageIcon aviso = new ImageIcon("img/aviso.png");
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
                JOptionPane.showMessageDialog(null, "Usuario não encontrado","OPS!",JOptionPane.ERROR_MESSAGE,aviso);
                return; 
            }
    
        } catch (IOException e) {
            System.err.println("Erro ao deletar o usuário: " + e.getMessage());
            return;
        }
    
      
           try {
        Files.move(Paths.get("temp.txt"), Paths.get(nomeArquivo), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Usuário removido com sucesso!");
    } catch (IOException e) {
        System.out.println("Falha ao substituir o arquivo original: " + e.getMessage());
    }
    }


    public static void RegistrarAvaliacao(String categoria,int nota,String avaliacao,  String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
         
              int id = lerValorContador();
                String linha = "\nUsuario - "+id+" \nAvaliou com nota de ("+nota+") para a : "+ categoria+"\n"+avaliacao;
                escreverLinha(writer, linha);
                salvarValorContador(id);
            
        } catch (IOException e) {
            System.err.println("Erro ao gravar no arquivo: " + e.getMessage());
        }
    }


    public static void editarInformacaoCliente(String valorAntigo, String novoValor, String campo, String nomeArquivo) {
        ImageIcon aviso = new ImageIcon("img/aviso.png");
         ImageIcon confirme = new ImageIcon("img/confirme.png");
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo));
             BufferedWriter writer = new BufferedWriter(new FileWriter("temp.txt"))) {
    
                String linha;
                boolean editou = false;
                while ((linha = reader.readLine()) != null) {
                    String[] partes = linha.split(", "); 
        
                    for (int i = 0; i < partes.length; i++) {
                        if (partes[i].startsWith(campo + ": ") && partes[i].contains(valorAntigo)) {
                            editou = true;
                            partes[i] = campo + ": " + novoValor; 
                        }
                    }
        
                
                    String linhaAtualizada = String.join(", ", partes);
        
             
                    writer.write(linhaAtualizada);
                    writer.newLine();
                }
        
                if (!editou) {
                    JOptionPane.showMessageDialog(null, "Usuario não encontrado","OPS!",JOptionPane.ERROR_MESSAGE,aviso);
                    return;
                }
        
            } catch (IOException e) {
                System.err.println("Erro ao editar a informação do cliente: " + e.getMessage());
                return;
            }
     
        try {
            Files.move(Paths.get("temp.txt"), Paths.get(nomeArquivo), StandardCopyOption.REPLACE_EXISTING);
          JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!","Sucesso",JOptionPane.ERROR_MESSAGE,confirme);
        } catch (IOException e) {
            System.out.println("Falha ao substituir o arquivo original: " + e.getMessage());
        }
    }
}