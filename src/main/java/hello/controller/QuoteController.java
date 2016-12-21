package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import hello.model.Quote;
import hello.repository.QuoteRepository;
import hello.repository.ValueRepository;

@RestController
public class QuoteController {
    @Autowired
    private QuoteRepository quoteRepository;

    @Autowired
    private ValueRepository valueRepository;

    @RequestMapping("/make-quote")
    public Quote home() {
        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        valueRepository.save(quote.getValue());

        return quote;
    }
}
