/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roundcarsraces;

/**
 *
 * @author Rokas
 */
public class SportCar extends Car {
    private boolean spoilerRaised = true; // true - nuleistas, false - pakeltas
    
    public SportCar(String name, int maxSpeed) {
        super(name, maxSpeed);
        this.spoilerRaised = true;
    }
    
    
    public void increaseSpeed(int deltaSpeed) {
    
        if (this.spoilerRaised) {
            super.increaseSpeed(2*deltaSpeed);
        } else {
            super.increaseSpeed(deltaSpeed);
        }
        
    }
    
    
    public void reduceSpeed(int deltaSpeed) {
        
        if (this.spoilerRaised) {
            super.reduceSpeed(deltaSpeed);
        } else {
            super.reduceSpeed(2*deltaSpeed);
        }
            
    }
    
    
    public void changeSpoiler() {
        this.spoilerRaised = !this.spoilerRaised;
    }
    
    
    @Override
    public String toString() {
        return "SportCar{" + "name=" + name + ", maxSpeed=" + maxSpeed + ", speed=" + speed + ", distance=" + distance + '}';
    }
    
    
    
    
}
