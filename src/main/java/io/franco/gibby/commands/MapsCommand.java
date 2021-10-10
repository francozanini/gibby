package io.franco.gibby.commands;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import io.franco.gibby.models.MapRotationDto;
import org.springframework.http.MediaType;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class MapsCommand implements SlashCommand {
    private final WebClient client;

    public MapsCommand() {
        this.client = WebClient
                .builder()
                .exchangeStrategies(ExchangeStrategies.builder().codecs(configurer ->{
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                    configurer.customCodecs().register(new Jackson2JsonDecoder(mapper, MimeTypeUtils.parseMimeType(MediaType.TEXT_PLAIN_VALUE)));
                }).build())
                .build();;
    }

    @Override
    public String getName() {
        return "maps";
    }

    private String apexToken() {
        return System.getenv("APEX_TOKEN");
    }



    @Override
    public Mono<Void> handle(ChatInputInteractionEvent event) {
        MapRotationDto mapRotationDto = client
                .get()
                .uri("https://api.mozambiquehe.re/maprotation?version=2&auth=" + apexToken())
                .retrieve()
                .bodyToMono(MapRotationDto.class)
                .block();

        event.

        return event
                .reply()
                .withEphemeral(true)
                .withContent(mapRotationDto.getBattleRoyale().getCurrent().getMap());
    }
}
