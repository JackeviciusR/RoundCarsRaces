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
public class Car {
    protected String name;
    protected int maxSpeed;
    protected int speed;
    protected int distance;
    
    public Car(String name, int maxSpeed) {
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.speed = 0;
        this.distance = 0;
    }
    
    
    public void increaseSpeed(int deltaSpeed) {
        if (this.speed + deltaSpeed <= this.maxSpeed) {
            this.speed += deltaSpeed;
        } else {
            this.speed = maxSpeed;
        }
    }
    
    
    public void reduceSpeed(int deltaSpeed) {
        if (this.speed - deltaSpeed >= 0) {
            this.speed -= deltaSpeed;
        } else {
            this.speed = 0;
        }
    }
    
    
    public void movement() {
        this.distance += this.speed;
    }
    
    
    public String getName() {
        return this.name;
    }
    
    
    public int getMaxSpeed() {
        return this.maxSpeed;
    }
    
    
    public int getSpeed() {
        return this.speed;
    }
    
    
    public int getDistance() {
        return this.distance;
    }

    @Override
    public String toString() {
        return "Car{" + "name=" + name + ", maxSpeed=" + maxSpeed + ", speed=" + speed + ", distance=" + distance + '}';
    }
    
    
    
    
}
