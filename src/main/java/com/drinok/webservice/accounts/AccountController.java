package com.drinok.webservice.accounts;

import com.drinok.webservice.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountRepository ar;

    @Autowired
    public AccountController(AccountRepository accountRepository) {
        this.ar = accountRepository;
    }

    private void verifyIfAccountExist(String username) {
        Account account = ar.findByUsername(username);
        if (account == null) {
            throw new ResourceNotFoundException("Account not found for username " + username);
        }
    }

    private void verifyIfAccountExist(Long id) {
        Optional<Account> account = ar.findById(id);
        if (!account.isPresent()) {
            throw new ResourceNotFoundException("Account not found for id " + id);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(ar.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{username}")
    public ResponseEntity<?> getOne(@PathVariable String username) {
        verifyIfAccountExist(username);
        return new ResponseEntity<>(ar.findByUsername(username), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createAccount(@Validated @RequestBody Account account) {
        return new ResponseEntity<>(ar.save(account), HttpStatus.CREATED);
    }

    @PutMapping(path="/{username}")
    public ResponseEntity<?> updateAccount(@PathVariable String username, @Validated @RequestBody Account account) {
        verifyIfAccountExist(username);
        return new ResponseEntity<>(ar.save(account), HttpStatus.OK);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable Long id) {
        verifyIfAccountExist(id);
        Account account = ar.getOne(id);
        ar.deleteById(id);
        return new ResponseEntity<>(account, HttpStatus.NO_CONTENT);
    }
}
