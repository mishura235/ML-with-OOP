package ru.students.neuron;

import java.util.List;
import java.util.Random;

public abstract class AbstractBaseNeuron {

    protected List<NeuronLink> links;
    protected Double out;
    protected double bias;

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
        double sum = bias;
        for (NeuronLink link : links) {
            sum += link.forward();
        }

        this.out = activationFunction.normalize(sum);
        return out;
    }
}
