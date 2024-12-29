package hw.netology.diploma;

import org.springframework.boot.SpringApplication;

public class TestCloudServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(CloudServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
