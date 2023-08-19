package com.quyvx.ecobike.api.controller.subsystem;

import com.quyvx.ecobike.api.application.services.CardService;
import com.quyvx.ecobike.api.application.services.TransactionService;
import com.quyvx.ecobike.api.dto.card.*;
import com.quyvx.ecobike.domain.aggregate_models.Card;
import com.quyvx.ecobike.domain.aggregate_models.Transaction;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Slf4j
@AllArgsConstructor
@RequestMapping("/api/card")
@RestController
@CrossOrigin(origins = {"http://localhost:5173", "http://127.0.0.1:5173"})
public class InterbankController {
    @Autowired
    private final CardService cardService;
    @Autowired
    private final TransactionService transactionService;
    @Autowired
    private final RestTemplate restTemplate;

    @PutMapping("processTransaction")
    public ResponseEntity<ProcessTransactionResDto> processTransaction(@RequestBody TransactionDto transactionDto) {
        ResponseEntity<ProcessTransactionResDto> response = restTemplate.exchange("http://localhost:7777/api/card" +
                        "/processTransaction",
                HttpMethod.PUT,
                cardService.buildRequestDto(transactionDto),
                ProcessTransactionResDto.class);
        Transaction transaction = transactionService.convertIntoTransaction(Objects.requireNonNull(response.getBody()));
        transactionService.saveTransaction(transaction);
        return response;
    }

    @PutMapping("reset-balance")
    public ResponseEntity<ResetBalanceResDto> resetBalance(@RequestBody ResetBalanceReqDto resetBalanceReqDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return restTemplate.exchange("http://localhost:7777/api/card/reset-balance",
                HttpMethod.PUT,
                new HttpEntity<>(resetBalanceReqDto, headers),
                ResetBalanceResDto.class);
    }

    @GetMapping("get-balance/{cardCode}")
    public ResponseEntity<GetBalanceResDto> getBalance(@PathVariable String cardCode) {
        return restTemplate.getForEntity("http://localhost:7777/api/card/get-balance/" + cardCode,
                GetBalanceResDto.class);
    }

    @GetMapping("check-card/{cardCode}")
    public ResponseEntity<Card> getCard(@PathVariable String cardCode) {
        return restTemplate.postForEntity("http://localhost:7777/api/card/check-card",
                new HttpEntity<>(cardCode),
                Card.class);
    }

}
