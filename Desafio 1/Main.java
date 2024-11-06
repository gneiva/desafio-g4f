public class Main {
    public static void main(String[] args) {
        // Instancia os dispositivos
        Device tv = new Television("TV da sala");
        Device ac = new AirConditioner("AR da sala");

        System.out.println("=========================================");
        System.out.println("==== TESTANDO CONTROLE REMOTO COM TV ====");
        System.out.println("=========================================");
        // Instancia o controle remoto e associa à TV
        RemoteControl remote = new RemoteControl(tv);
        
        // Liga e desliga a TV
        remote.pressPowerButton(); // Deve ligar a TV
        remote.pressPowerButton(); // Deve desligar a TV
        remote.pressPowerButton(); // Deve ligar a TV

        System.out.println("=========================================");        
        System.out.println("==== TESTANDO CONTROLE REMOTO COM AR ====");
        System.out.println("=========================================");
        // Alterna para o ar-condicionado
        remote.setDevice(ac);
        remote.pressPowerButton(); // Deve ligar o ar-condicionado
    }
}
