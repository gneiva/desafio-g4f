# Projeto Controle de Casa

Este projeto implementa um sistema simples de automação para dispositivos em uma casa, permitindo controlar dispositivos como uma TV e um ar-condicionado usando um controle remoto. A implementação utiliza conceitos fundamentais de orientação a objetos (**abstração**, **herança**, **encapsulamento** e **polimorfismo**) e princípios do **SOLID** para criar um sistema modular e extensível.


## Estrutura do Projeto

O projeto é composto pelas seguintes classes:

+ **Device**: Interface que define os métodos básicos (turnOn e turnOff) que todo dispositivo deve implementar.
+ **Television**: Classe que representa uma TV, implementa Device e possui uma lógica própria para ligar e desligar.
+ **AirConditioner**: Classe que representa um ar-condicionado, também implementa Device com sua própria lógica de controle.
+ **RemoteControl**: Classe que representa o controle remoto, que pode controlar qualquer dispositivo que implemente Device.

## Conceitos Aplicados
### 1. Abstração ###
A **abstração** consiste em expor apenas os comportamentos essenciais de um objeto, ocultando detalhes desnecessários. Neste projeto, a interface Device é uma abstração que define os métodos essenciais (turnOn, turnOff, isOn e getName) que qualquer dispositivo deve possuir, sem especificar como cada dispositivo implementa esses métodos.

**Exemplo de Abstração:**
~~~~
public interface Device {
    void turnOn();
    void turnOff();
    boolean isOn();
    String getName();    
}
~~~~

A interface Device define um conjunto básico de funcionalidades que cada dispositivo deve implementar, seguindo o Single Responsibility Principle (SRP) do SOLID ao focar exclusivamente nos métodos turnOn, turnOff, isOn e getName, sem se preocupar com detalhes específicos de cada dispositivo.

### 1. Herança ###
O projeto utiliza herança de comportamento através da interface Device. Tanto Television quanto AirConditioner implementam a interface, garantindo que cada dispositivo compartilhe o comportamento básico exigido pelo Device. Essa herança por interface permite que novos dispositivos sejam adicionados sem modificar o código existente, o que respeita o Open/Closed Principle (OCP) do SOLID.

### 1. Encapsulamento ###
O encapsulamento é o princípio de ocultar os detalhes internos de uma classe, expondo apenas o necessário através de métodos públicos. Cada dispositivo encapsula seu próprio estado (isOn) e sua propriedade name, tornando-os privados e acessíveis apenas pelos métodos get. Isso garante que o estado de cada dispositivo seja protegido e gerenciado internamente e apenas expõe o estado atual.

**Exemplo de Encapsulamento:**
~~~~
public class Television implements Device {
	
	private String name;
    private boolean isOn = false;

    public Television(String name) {
        this.name = name;
    }
    
    @Override
    public void turnOn() {
        if (!isOn) {
        	//TODO Implementar a lógica para ligar a televisão
            isOn = true;
            System.out.println("O device: " + name + " foi ligado");
        } else {
            System.out.println("O device: " + name + " já está ligado");
        }
    }

    @Override
    public void turnOff() {
        if (isOn) {
        	//TODO Implementar a lógica para desligar a televisão
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
~~~~

Aqui, o atributo isOn é privado e só pode ser modificado através dos métodos turnOn e turnOff, mantendo o estado de cada dispositivo encapsulado e seguro.

### 4. Polimorfismo
O **polimorfismo** permite que diferentes objetos sejam tratados de forma uniforme. A classe RemoteControl usa polimorfismo para controlar qualquer dispositivo que implemente Device, independentemente de ser uma TV, um ar-condicionado ou outro dispositivo. Isso é possível porque ambos implementam a interface Device, seguindo o **Dependency Inversion Principle (DIP)** do **SOLID** ao depender de uma abstração (Device) em vez de uma implementação concreta.

**Exemplo de Polimorfismo:**
~~~~
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
~~~~

## Exemplo de Uso
~~~~
public class Main {
    public static void main(String[] args) {
        Device tv = new Television("TV da sala");
        Device ac = new AirConditioner("AR da sala");

        RemoteControl remote = new RemoteControl(tv);
        remote.pressPowerButton(); // Deve ligar a TV
        remote.pressPowerButton(); // Deve desligar a TV

        remote.setDevice(ac);
        remote.pressPowerButton(); // Deve ligar o ar-condicionado
    }
}
~~~~

## Conclusão
Este projeto demonstra a aplicação dos conceitos fundamentais da orientação a objetos
