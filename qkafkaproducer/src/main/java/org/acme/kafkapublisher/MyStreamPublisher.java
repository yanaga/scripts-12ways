package org.acme.kafkapublisher;

import javax.enterprise.context.ApplicationScoped;

import org.jboss.logging.Logger;

import io.reactivex.Flowable;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import java.util.Random;
import java.util.concurrent.TimeUnit;


@ApplicationScoped
public class MyStreamPublisher {
    private static final Logger LOG = Logger.getLogger(MyStreamPublisher.class);

    private Random random = new Random();

    @Outgoing("mystream")
    public Flowable<String> generate() {
        return Flowable.interval(1, TimeUnit.SECONDS)
                .map(msg -> random.nextInt(100) + " stuff ");
    }
    
}