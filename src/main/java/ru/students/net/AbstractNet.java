package ru.students.net;

import java.util.ArrayList;
import java.util.List;
import ru.students.layer.AbstractLayer;

abstract class AbstractNet {

    private final List<Double> outs = new ArrayList<>();
    private final List<AbstractLayer> layers = new ArrayList<>();


    public void addLayer(AbstractLayer layer) {
        layers.add(layer);
    }

    public List<Double> forward(List<Double> ins) {

        for (AbstractLayer layer : layers) {
            ins = layer.forward(ins);
        }

        return ins;
    }
}