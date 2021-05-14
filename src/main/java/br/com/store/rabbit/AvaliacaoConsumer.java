package br.com.store.rabbit;

import br.com.store.model.Avaliacao;
import br.com.store.service.AvaliacaoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class AvaliacaoConsumer {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @RabbitListener(queues = {"${queue.produto.name}"})
    public void receive (@Payload Avaliacao avaliacao){
        System.out.println("Id: "+ Avaliacao.get_id() + "\nDescricao: " + Avaliacao.getDescricao() + "\nNota: " + Avaliacao.getNota() + "\nDescricao: " + Avaliacao.getNomeAluno());
        avaliacaoService.save(avaliacao);
    }
}
