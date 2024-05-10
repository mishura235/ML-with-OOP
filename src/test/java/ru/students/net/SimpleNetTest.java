package ru.students.net;

import java.util.List;
import org.junit.jupiter.api.Test;
import ru.students.layer.SimpleLayer;
import ru.students.neuron.FixedNeuron;

class SimpleNetTest {

    @Test
    void simpleTest() {
        SimpleNet net = new SimpleNet();

        for (int i = 0; i < 2; i++) {
            SimpleLayer layer = new SimpleLayer();
            for (int j = 0; j < 2; j++) {
                layer.addNeuron(new FixedNeuron(2, in -> in * 1));
            }
            net.addLayer(layer);
        }

        List<Double> forward = net.forward(List.of(2d, 3d));
        System.out.println(forward);
    }

}