public class Television implements Device {
	
	private String name;
    private boolean isOn = false;

    public Television(String name) {
        this.name = name;
    }
    
    @Override
    public void turnOn() {
        if (!isOn) {
        	//TODO chamar serviço para ligar a televisão
            isOn = true;
            System.out.println("O device: " + name + " foi ligado");
        } else {
            System.out.println("O device: " + name + " já está ligado");
        }
    }

    @Override
    public void turnOff() {
        if (isOn) {
        	//TODO chamar serviço para desligar a televisão
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
