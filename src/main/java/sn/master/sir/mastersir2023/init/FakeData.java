package sn.master.sir.mastersir2023.init;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import sn.master.sir.mastersir2023.models.Customer;
import sn.master.sir.mastersir2023.repository.CustomerRepository;

@Component
public class FakeData implements ApplicationListener<ApplicationReadyEvent> {

    private CustomerRepository customerRepository;

    public FakeData(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {

        Customer customer = new Customer();
        customerRepository.save(customer);

    }
}

/*

    # This workflow will build a Java project with Maven, and cache/restore any dependencies to improve the workflow execution time
# For more information see: https://docs.github.com/en/actions/automating-builds-and-tests/building-and-testing-java-with-maven

# This workflow uses actions that are not certified by GitHub.
# They are provided by a third-party and are governed by
# separate terms of service, privacy policy, and support
# documentation.

name: Java CI with Maven

on:
  push:
    branches: [ "main" ]
  pull_request:
    branches: [ "main" ]

jobs:
  build:

    runs-on: ubuntu-latest

    steps:
    - uses: actions/checkout@v3
    - name: Set up JDK 17
      uses: actions/setup-java@v3
      with:
        java-version: '17'
        distribution: 'temurin'
        cache: maven
    - name: Build with Maven
      run: mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install




* */
