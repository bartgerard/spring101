package be.continuum.slice.controller;

import be.continuum.slice.event.AddPhoneNumber;
import be.continuum.slice.event.ChangeCoreCustomerData;
import be.continuum.slice.event.RemovePhoneNumber;
import be.continuum.slice.model.Customer;
import be.continuum.slice.service.CustomerService;
import be.continuum.slice.value.Address;
import be.continuum.slice.value.FoodAllergen;
import be.continuum.slice.value.PhoneNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

/**
 * CustomerRestController
 *
 * @author bartgerard
 * @version v0.0.1
 */
@RestController
@RequestMapping("customers")
@RequiredArgsConstructor
public class CustomerRestController {

    private final CustomerService customerService;

    @GetMapping("{email}")
    public Customer byEmail(@PathVariable final String email) {
        return customerService.findOne(email);
    }

    @PutMapping("{email}")
    public Customer save(
            @PathVariable final String email,
            @RequestBody final ChangeCoreCustomerData changeCoreCustomerData
    ) {
        return customerService.save(email, customer -> customer.handle(changeCoreCustomerData));
    }

    @GetMapping("/{email}/phones")
    public Set<PhoneNumber> phonesByEmail(@PathVariable final String email) {
        return customerService.findOne(email)
                              .getPhoneNumbers();
    }

    @PostMapping("/{email}/phones")
    public Set<PhoneNumber> addPhoneNumber(
            @PathVariable final String email,
            @RequestBody final AddPhoneNumber addPhoneNumber
    ) {
        return customerService.save(email, customer -> customer.handle(addPhoneNumber))
                              .getPhoneNumbers();
    }

    @DeleteMapping("/{email}/phones")
    public Set<PhoneNumber> removePhoneNumber(
            @PathVariable final String email,
            @RequestBody final RemovePhoneNumber removePhoneNumber
    ) {
        return customerService.save(email, customer -> customer.handle(removePhoneNumber))
                              .getPhoneNumbers();
    }

    @GetMapping("/{email}/allergens")
    public Set<FoodAllergen> allergensByEmail(@PathVariable final String email) {
        return customerService.findOne(email)
                              .getAllergens();
    }

    @PutMapping("/{email}/allergens/{allergen}")
    public Set<FoodAllergen> addAllergen(
            @PathVariable final String email,
            @PathVariable final FoodAllergen allergen
    ) {
        return customerService.save(email, customer -> customer.addAllergen(allergen))
                              .getAllergens();
    }

    @DeleteMapping("/{email}/allergens/{allergen}")
    public Set<FoodAllergen> removeAllergen(
            @PathVariable final String email,
            @PathVariable final FoodAllergen allergen
    ) {
        return customerService.save(email, customer -> customer.removeAllergen(allergen))
                              .getAllergens();
    }

    @GetMapping("/{email}/addresses")
    public Map<String, Address> addressesByEmail(@PathVariable final String email) {
        return customerService.findOne(email)
                              .getAddresses();
    }

    @PutMapping("/{email}/addresses/{alias}")
    public Map<String, Address> addAddress(
            @PathVariable final String email,
            @PathVariable final String alias,
            @RequestBody final Address address
    ) {
        return customerService.save(email, customer -> customer.addAddress(alias, address))
                              .getAddresses();
    }

    @DeleteMapping("/{email}/addresses/{alias}")
    public Map<String, Address> removeAllergen(
            @PathVariable final String email,
            @PathVariable final String alias
    ) {
        return customerService.save(email, customer -> customer.removeAddress(alias))
                              .getAddresses();
    }

}
