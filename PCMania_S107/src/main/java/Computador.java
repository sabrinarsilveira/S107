public class Computador {

    String marca;
    float preco;
    MemoriaUSB memoria;
    SistemaOperacional sop = new SistemaOperacional();
    HardwareBasico[] hardware = new HardwareBasico[5];


    void mostraPCConfigs(){

        System.out.println("Marca do PC: " + marca);
        System.out.println("Preço: " + preco + "R$");
        System.out.println("Sistema Operacional: " + sop.nome + " " + sop.tipo + "bits");
        System.out.println("Hardware Basico");
        for (int i = 0; i < hardware.length ; i++) {
            if(hardware[i] != null)
                System.out.println("Nome: " + hardware[i].nome + " Capacidade: " + hardware[i].capacidade);
        }

        System.out.println("Memória conjunta da promoção: " + "Tipo " + memoria.nome + " Capacidade: " + memoria.nome);

    }

    void addMemoriaUSB(MemoriaUSB musb){

        memoria = musb;

    }
}
