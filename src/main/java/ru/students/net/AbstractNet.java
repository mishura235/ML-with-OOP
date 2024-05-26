package ru.students.net;

import java.util.ArrayList;
import java.util.List;
import ru.students.layer.AbstractLayer;
import ru.students.neuron.ActivationFunction;

abstract class AbstractNet {

    private final List<Double> outs = new ArrayList<>();
    private final List<AbstractLayer> layers = new ArrayList<>();
    private final ActivationFunction activationFunction;
    AbstractNet(){
        this.activationFunction = n -> n;
    }
    AbstractNet(ActivationFunction activationFunction){
        this.activationFunction = activationFunction;
    }

    public void addLayer(AbstractLayer layer) {
        if (activationFunction != null) {
            layer.setActivationFunction(activationFunction);
        }
        layers.add(layer);

    }

    public List<Double> forward(List<Double> ins) {

        for (AbstractLayer layer : layers) {
            ins = layer.forward(ins);
        }

        return ins;
    }
}
