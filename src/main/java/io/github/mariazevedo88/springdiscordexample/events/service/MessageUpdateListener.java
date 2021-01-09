package io.github.mariazevedo88.springdiscordexample.events.service;

import org.springframework.stereotype.Service;

import discord4j.core.event.domain.message.MessageUpdateEvent;
import io.github.mariazevedo88.springdiscordexample.events.EventListener;
import io.github.mariazevedo88.springdiscordexample.events.MessageListener;
import reactor.core.publisher.Mono;

@Service
public class MessageUpdateListener extends MessageListener implements EventListener<MessageUpdateEvent> {

    @Override
    public Class<MessageUpdateEvent> getEventType() {
        return MessageUpdateEvent.class;
    }

    @Override
    public Mono<Void> execute(MessageUpdateEvent event) {
        return Mono.just(event)
           .filter(MessageUpdateEvent::isContentChanged)
           .flatMap(MessageUpdateEvent::getMessage)
           .flatMap(super::processCommand);
    }
}