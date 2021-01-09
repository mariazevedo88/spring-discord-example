package io.github.mariazevedo88.springdiscordexample.events.service;

import org.springframework.stereotype.Service;

import discord4j.core.event.domain.message.MessageCreateEvent;
import io.github.mariazevedo88.springdiscordexample.events.EventListener;
import io.github.mariazevedo88.springdiscordexample.events.MessageListener;
import reactor.core.publisher.Mono;

@Service
public class MessageCreateListener extends MessageListener implements EventListener<MessageCreateEvent> {

    @Override
    public Class<MessageCreateEvent> getEventType() {
        return MessageCreateEvent.class;
    }

    @Override
    public Mono<Void> execute(MessageCreateEvent event) {
        return processCommand(event.getMessage());
    }
}