package ru.students.neuron;


import java.util.Random;

public class NeuronLink {

    private double weight;
    private double in;
    private double out;

    private boolean active = true;

    public NeuronLink() {
        Random random = new Random();
        weight = - 1 + random.nextDouble(2);
    }

    public NeuronLink(double weight) {
        this.weight = weight;
    }

    public void setIn(double in) {
        this.in = in;
        forward();
    }

    public double getOut() {
        return out;
    }

    public void setOut(double out) {
        this.out = out;
    }

    public double forward() {
        if (!active){
            return 0;
        }
        this.out = in * weight;
        return out;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isActive() {
        return active;
    }

    public void activate(){
        active = true;
    }
    public void deactivate(){
        active = false;
    }
}
