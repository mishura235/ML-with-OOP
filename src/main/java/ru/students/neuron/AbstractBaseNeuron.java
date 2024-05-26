package ru.students.neuron;

import java.util.List;
import java.util.Random;

public abstract class AbstractBaseNeuron {

    private List<NeuronLink> links;
    private Double out;
    private double bias;

    protected boolean active = true;
    protected ActivationFunction activationFunction;

    public AbstractBaseNeuron() {
        Random random = new Random();
        bias = - 1 + random.nextDouble(2);
    }

    public AbstractBaseNeuron(ActivationFunction activationFunction) {
        Random random = new Random();
        bias = - 1 + random.nextDouble(2);
        setActivationFunction(activationFunction);
    }

    public void setBias(double bias) {
        this.bias = bias;
    }

    public void setIns(List<Double> ins) {
        if (links.size()!=ins.size()) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < links.size(); i++) {
            NeuronLink link = links.get(i);
            Double in = ins.get(i);
            link.setIn(in);
        }
    }

    public void setActivationFunction(ActivationFunction activationFunction) {
        if (activationFunction == null) throw new IllegalArgumentException("нельзя null");
        this.activationFunction = activationFunction;
    }

    public double forward() {
        if (!active) {
            return 0;
        }
        double sum = bias;
        for (NeuronLink link : links) {
            sum += link.forward();
        }

        this.out = activationFunction.normalize(sum);
        return out;
    }

    public void activate(){
        active = true;
    }
    public void deactivate(){
        active = false;
    }

    public void setLinks(List<NeuronLink> links) {
        this.links = links;
    }
}
