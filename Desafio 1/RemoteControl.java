public class RemoteControl {
    private Device device;

    public RemoteControl(Device device) {
        this.device = device;
        System.out.println("Controle configurado para controlar o device: " + device.getName() );
    }

    public void setDevice(Device device) {
        this.device = device;
        System.out.println("Controle configurado para controlar o device: " + device.getName() );
    }

    public void pressPowerButton() {
        if (device != null) {
            System.out.println("Botão de ligar/desligar acionado...");
            
            if(!device.isOn()) {
            	device.turnOn();
            }else { 
            	device.turnOff();
            }
            
        } else {
            System.out.println("Nenhum device informado para o controle.");
        }
    }
}
