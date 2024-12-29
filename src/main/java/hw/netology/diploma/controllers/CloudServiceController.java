package hw.netology.diploma.controllers;

import hw.netology.diploma.repositories.CloudServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/")
public class CloudServiceController {
    final CloudServiceRepository repository;

    @Autowired
    public CloudServiceController(CloudServiceRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public
}

