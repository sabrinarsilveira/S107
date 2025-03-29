import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        cliente.nome = "Sabrina";
        cliente.cpf = 12345678910L;

        MemoriaUSB musb1 = new MemoriaUSB();
        MemoriaUSB musb2 = new MemoriaUSB();
        MemoriaUSB musb3 = new MemoriaUSB();

        musb1.nome = "Pen-drive";
        musb1.capacidade = 16;

        musb2.nome = "Pen-drive";
        musb2.capacidade = 32;

        musb3.nome = "HD Externo";
        musb3.capacidade = 1;

        Computador promocao1 = new Computador();
        Computador promocao2 = new Computador();
        Computador promocao3 = new Computador();

        promocao1.marca = "Positivo";
        promocao1.preco = 2300;
        promocao1.hardware[0] = new HardwareBasico();
        promocao1.hardware[0].nome = "Pentium Core i3";
        promocao1.hardware[0].capacidade = 2200;
        promocao1.hardware[1] = new HardwareBasico();
        promocao1.hardware[1].nome = "Memoria RAM";
        promocao1.hardware[1].capacidade = 8;
        promocao1.hardware[2] = new HardwareBasico();
        promocao1.hardware[2].nome = "HD";
        promocao1.hardware[2].capacidade = 500;
        promocao1.sop.nome = "Linux Ubuntu";
        promocao1.sop.tipo = 32;
        promocao1.addMemoriaUSB(musb1);

        promocao2.marca = "Acer";
        promocao2.preco = 5800;
        promocao2.hardware[0] = new HardwareBasico();
        promocao2.hardware[0].nome = "Pentium Core i5";
        promocao2.hardware[0].capacidade = 3370;
        promocao2.hardware[1] = new HardwareBasico();
        promocao2.hardware[1].nome = "Memoria RAM";
        promocao2.hardware[1].capacidade = 16;
        promocao2.hardware[2] = new HardwareBasico();
        promocao2.hardware[2].nome = "HD";
        promocao2.hardware[2].capacidade = 1;
        promocao2.sop.nome = "Windows 8";
        promocao2.sop.tipo = 64;
        promocao2.addMemoriaUSB(musb2);

        promocao3.marca = "Vaio";
        promocao3.preco = 1800;
        promocao3.hardware[0] = new HardwareBasico();
        promocao3.hardware[0].nome = "Pentium Core i7";
        promocao3.hardware[0].capacidade = 4500;
        promocao3.hardware[1] = new HardwareBasico();
        promocao3.hardware[1].nome = "Memoria RAM";
        promocao3.hardware[1].capacidade = 32;
        promocao3.hardware[2] = new HardwareBasico();
        promocao3.hardware[2].nome = "HD";
        promocao3.hardware[2].capacidade = 2;
        promocao3.sop.nome = "Windows 10";
        promocao3.sop.tipo = 64;
        promocao3.addMemoriaUSB(musb3);

        boolean flag = true;    //Flag para o loop de compra
        int escolha;            //Auxiliar para entrada do pedido

        System.out.println("Incríveis ofertas da PC Mania!");
        System.out.println("Os computadores da promoção são esses:");
        System.out.println("Computador 1:");
        promocao1.mostraPCConfigs();
        System.out.println("Computador 2:");
        promocao2.mostraPCConfigs();
        System.out.println("Computador 3:");
        promocao3.mostraPCConfigs();


        Scanner entrada = new Scanner(System.in);


        while(flag){

            System.out.println("Para adicionar um produto ao seu carrinho, digite o número referente a promoção desejada.");
            System.out.println("Para fechar o carrinho, entre com o valor 0.\n");

            escolha = entrada.nextInt();

            switch(escolha){

                case 0:
                    flag = false;
                    System.out.println("Carrinho de compras fechado.\n");
                    break;

                case 1:
                    for(int i=0; i<cliente.computadores.length; i++) {
                        if(cliente.computadores[i] == null) {
                            cliente.computadores[i] = promocao1;
                            System.out.println("Promoção 1 adicionada ao carrinho.\n");
                            break;
                        }
                    }
                    break;

                case 2:
                    for(int i=0; i<cliente.computadores.length; i++) {
                        if(cliente.computadores[i] == null) {
                            cliente.computadores[i] = promocao2;
                            System.out.println("Promoção 2 adicionada ao carrinho.\n");
                            break;
                        }
                    }
                    break;

                case 3:
                    for(int i=0; i<cliente.computadores.length; i++) {
                        if(cliente.computadores[i] == null) {
                            cliente.computadores[i] = promocao3;
                            System.out.println("Promoção 3 adicionada ao carrinho.\n");
                            break;
                        }
                    }
                    break;

                default:
                    break;
            }
        }

        System.out.print("Prezado(a) " + cliente.nome + " o total de sua compra foi de: R$");
        System.out.printf("%.2f",cliente.calculaTotalCompra());

    }
}

