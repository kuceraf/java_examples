package cz.fku.designPatterns.structural.adapter;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class KmHMovableAdapterTest {
    @Test
    public void adaptSpeed_success() {
        BugattiVeyron bugattiVeyron = new BugattiVeyron();
        MovableAdapter movableAdapter = new KmHMovableAdapter(bugattiVeyron);
        assertThat(movableAdapter.adaptSpeed()).isEqualTo(431.30312);
    }
}