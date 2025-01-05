package hw.netology.diploma.controllers;

import hw.netology.diploma.repositories.CloudServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cloud")
public class CloudServiceController {
    final CloudServiceRepository repository;

    @Autowired
    public CloudServiceController(CloudServiceRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/testSecure")
    public String testAuthorise() {
        return "Test succesfull!";
    }

    @PostMapping("/file")
    public void uploadFile(@RequestParam String filename, @RequestBody byte[] data) {
        repository.saveFile(filename, data);
    }
}

