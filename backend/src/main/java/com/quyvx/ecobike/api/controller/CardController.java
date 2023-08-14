package com.quyvx.ecobike.api.controller;

import com.quyvx.ecobike.api.application.services.CardService;
import com.quyvx.ecobike.api.dto.card.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Slf4j
@AllArgsConstructor
@RequestMapping("/api/card")
@RestController
@CrossOrigin(origins = {"http:localhost:5173", "http://127.0.0.1:5173"})
public class CardController {
    @Autowired
    private final CardService cardService;
    @Autowired
    private final RestTemplate restTemplate;

    @PutMapping("processTransaction")
    public ResponseEntity<ProcessTransactionResDto> processTransaction(@RequestBody TransactionDto transactionDto){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String hashCode = cardService.getHashCode(transactionDto);
        ProcessTransactionReqDto processTransactionReqDto =  ProcessTransactionReqDto.builder()
                .version("1.0.1")
                .transaction(transactionDto)
                .hashCode(hashCode)
                .appCode(cardService.findByCardCode(transactionDto.getCardCode())
                        .getAppCode().toString())
                .build();
        return restTemplate.exchange("http://localhost:7777/api/card/processTransaction",
                HttpMethod.PUT,
                new HttpEntity<>(processTransactionReqDto, headers),
                ProcessTransactionResDto.class);
    }

    @PutMapping("reset-balance")
    public ResponseEntity<ResetBalanceResDto> resetBalance(@RequestBody ResetBalanceReqDto resetBalanceReqDto){
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
}
