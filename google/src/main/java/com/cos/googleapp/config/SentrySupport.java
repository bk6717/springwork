package com.cos.googleapp.config;

import org.springframework.context.annotation.Configuration;

import io.sentry.Sentry;
import io.sentry.event.Event;
import io.sentry.event.EventBuilder;


@Configuration
public class SentrySupport {

	public SentrySupport() {
		System.out.println("=========sentrySuppory init");
		Sentry.init("https://a87ebb913b074f44b226e1e064f1cf24@o434901.ingest.sentry.io/5392547");
	}

    public void logSimpleMessage(String msg) {
        // This sends an event to Sentry.
        EventBuilder eventBuilder = new EventBuilder()
                        .withMessage(msg)
                        .withLevel(Event.Level.ERROR)
                        .withLogger(SentrySupport.class.getName());

        // Note that the *unbuilt* EventBuilder instance is passed in so that
        // EventBuilderHelpers are run to add extra information to your event.
        Sentry.capture(eventBuilder);
    }

   }
