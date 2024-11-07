public class AirConditioner implements Device {
    
	private String name;
	private boolean isOn = false;

    public AirConditioner(String name) {
        this.name = name;
    }
    
    @Override
    public void turnOn() {
        if (!isOn) {
        	//TODO chamar serviço para ligar o ar-condicionado
            isOn = true;
            System.out.println("O device: " + name + " foi ligado");
        } else {
            System.out.println("O device: " + name + " já está ligado");
        }
    }

    @Override
    public void turnOff() {
        if (isOn) {
        	//TODO chamar serviço para desligar o ar-condicionado
            isOn = false;
            System.out.println("O device: " + name + " foi desligado");
        } else {
            System.out.println("O device: " + name + " já está desligado");
        }
    }
    
    @Override
	public String getName() {
		return this.name;
	}

	@Override
	public boolean isOn() {
		return this.isOn;
	}
}
