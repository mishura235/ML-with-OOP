package ru.students.neuron;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FixedNeuron extends AbstractBaseNeuron {

    public FixedNeuron(int numberOfIns, ActivationFunction activationFunction) {
        super(activationFunction);
        generateLinks(numberOfIns);
    }

    private void generateLinks(int numberOfIns) {
        List<NeuronLink> result = new ArrayList<>();

        for (int i = 0; i < numberOfIns; i++) {
            result.add(new NeuronLink());
        }
        setLinks(Collections.unmodifiableList(result));
    }
}

