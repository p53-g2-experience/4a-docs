package co.misiontic.p53.planes_ms.controllers;

import co.misiontic.p53.planes_ms.exceptions.AccountNotFoundException;
import co.misiontic.p53.planes_ms.models.Account;
import co.misiontic.p53.planes_ms.repositories.AccountRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/accounts/{username}")
    Account getAccount(@PathVariable String username){

        return accountRepository.findById(username).orElseThrow(() -> new AccountNotFoundException("No se encontro una cuenta con el username: " + username));
    }

    @PostMapping("/accounts")
    Account newAccount(@RequestBody Account account){
        return accountRepository.save(account);
    }
}
