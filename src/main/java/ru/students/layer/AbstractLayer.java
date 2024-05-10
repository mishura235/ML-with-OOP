package ru.students.layer;

import java.util.ArrayList;
import java.util.List;
import ru.students.neuron.AbstractBaseNeuron;
import ru.students.neuron.ActivationFunction;

public abstract class AbstractLayer {

    private final ActivationFunction activationFunction;

    AbstractLayer(){
        activationFunction = n -> n*1;
    }
    AbstractLayer(ActivationFunction activationFunction){
        this.activationFunction = activationFunction;
    }

    private final List<Double> outs = new ArrayList<>();
    private final List<AbstractBaseNeuron> neurons = new ArrayList<>();

    public void addNeuron(AbstractBaseNeuron neuron) {
        neuron.setActivationFunction(activationFunction);
        neurons.add(neuron);

    }

    public List<Double> forward(List<Double> ins) {
        outs.clear();

        for (AbstractBaseNeuron neuron : neurons) {
            neuron.setIns(ins);
            double out = neuron.forward();
            outs.add(out);
        }

        return outs;
    }

}
