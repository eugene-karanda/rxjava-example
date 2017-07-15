package io.reactivex;

import io.reactivex.functions.Consumer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 15.07.2017 18:07
 */
@RunWith(MockitoJUnitRunner.class)
public class RxJavaText {

    @Mock
    private Consumer<String> mockConsumer;

    @Test
    public void simpleTest() throws Exception {
        Observable.just("Hello Rx World")
            .subscribe(mockConsumer);

        verify(mockConsumer, only())
            .accept("Hello Rx World");
    }

}
