// Interface Tanımı
interface Controllable {
    void turnOn();
    void turnOff();
    boolean isOn();
}

// Temel Sınıf
abstract class Appliance implements Controllable {
    private boolean isOn;

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println(getClass().getSimpleName() + " turned on.");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println(getClass().getSimpleName() + " turned off.");
    }

    @Override
    public boolean isOn() {
        return isOn;
    }
}

// Cihaz Sınıfları
class Light extends Appliance {
    public void dim(int level) {
        if (isOn()) {
            System.out.println("Light dimmed to level: " + level);
        } else {
            System.out.println("Light is off. Cannot dim.");
        }
    }
}

class Thermostat extends Appliance {
    private int temperature;

    public void setTemperature(int temperature) {
        if (isOn()) {
            this.temperature = temperature;
            System.out.println("Thermostat temperature set to: " + temperature + "°C");
        } else {
            System.out.println("Thermostat is off. Cannot set temperature.");
        }
    }

    public int getTemperature() {
        return temperature;
    }
}

class SecuritySystem extends Appliance {
    public void activateAlarm() {
        if (isOn()) {
            System.out.println("Security alarm activated!");
        } else {
            System.out.println("Security system is off. Cannot activate alarm.");
        }
    }
}

// Konsol Uygulaması
public class SmartHomeSystem {
    public static void main(String[] args) {
        Light light = new Light();
        Thermostat thermostat = new Thermostat();
        SecuritySystem securitySystem = new SecuritySystem();

        // Light işlemleri
        light.turnOn();
        light.dim(5);
        light.turnOff();

        // Thermostat işlemleri
        thermostat.turnOn();
        thermostat.setTemperature(22);
        thermostat.turnOff();

        // SecuritySystem işlemleri
        securitySystem.turnOn();
        securitySystem.activateAlarm();
        securitySystem.turnOff();
    }
}
