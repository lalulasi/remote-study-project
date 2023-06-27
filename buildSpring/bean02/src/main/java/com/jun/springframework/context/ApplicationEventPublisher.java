package com.jun.springframework.context;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-27 16:12
 **/
public interface ApplicationEventPublisher {
    /**
     * Notify all listeners registered with this application of an application
     * event. Events may be framework events (such as RequestHandledEvent)
     * or application-specific events.
     * @param event the event to publish
     */
    void publishEvent(ApplicationEvent event);
}
