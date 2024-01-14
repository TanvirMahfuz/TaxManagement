package com.example.demo.Service;

import com.example.demo.JavaClasses.TaxFunctions;
import com.example.demo.Repo.TaxFunctionsRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaxFunctionsService {

    private final TaxFunctionsRepo taxFunctionsRepo;
    @Autowired
    public TaxFunctionsService(TaxFunctionsRepo taxFunctionsRepo) {
        this.taxFunctionsRepo = taxFunctionsRepo;
    }
    public TaxFunctions createTaxFunctions(TaxFunctions t){
        System.out.println("Service problem..............");
        return taxFunctionsRepo.save(t);}
    public List<TaxFunctions> getAllTaxFunctions() {
        return taxFunctionsRepo.findAll();
    }
    public TaxFunctions getTaxFunctionsByID(int id){return taxFunctionsRepo.findById(id).orElse(null);}
    public void deleteTaxFunctions(int id) {
        taxFunctionsRepo.deleteById(id);
    }
    public TaxFunctions updateTaxFunction(TaxFunctions taxFunctions) {
        Optional<TaxFunctions> existingtaxFunctionsOptional = taxFunctionsRepo.findById(taxFunctions.getTaxFunctionID());
        if (existingtaxFunctionsOptional.isPresent()) {
            TaxFunctions existingUser = existingtaxFunctionsOptional.get();
             existingUser.setTotal_taxable(0);
             taxFunctions.setTotalTax(0);
             existingUser.setMain_salary(taxFunctions.getMain_salary());
             existingUser.setBonusSalary(taxFunctions.getBonusSalary());
             existingUser.setSpecial_salary(taxFunctions.getSpecial_salary());
             existingUser.setSalary_dues(taxFunctions.getSalary_dues());
             existingUser.setDearness_allowance(taxFunctions.getDearness_allowance());
             existingUser.setRent_allowance(taxFunctions.getRent_allowance());
             existingUser.setMedical_allowance(taxFunctions.getMedical_allowance());
             existingUser.setAdditionalMedicalAllowance(taxFunctions.getAdditionalMedicalAllowance());
             existingUser.setTravel_allowance(taxFunctions.getTravel_allowance());
             existingUser.setFestival_allowance(taxFunctions.getFestival_allowance());
             existingUser.setAttendant_allowance(taxFunctions.getAttendant_allowance());
             existingUser.setonLeaveAllowance(taxFunctions.getOnLeaveAllowance());
             existingUser.setEarnedReward(taxFunctions.getEarnedReward());
             existingUser.setOverTimeFee(taxFunctions.getOverTimeFee());
             existingUser.setBonusSalary(taxFunctions.getBonusSalary());
             existingUser.setSavedInFutureFund(taxFunctions.getSavedInFutureFund());
             existingUser.setInterestFromFutureFund(taxFunctions.getInterestFromFutureFund());
             existingUser.setUseOfOfficeVehicle(taxFunctions.getUseOfOfficeVehicle());
             existingUser.setUseOfOfficeHome(taxFunctions.getUseOfOfficeHome());
             existingUser.setOtherAdvantagesFromCompany(taxFunctions.getOtherAdvantagesFromCompany());
             existingUser.setVacation_monetization(taxFunctions.getVacation_monetization());
             existingUser.setGratuity(taxFunctions.getGratuity());
             existingUser.setWorkers_participation_fund(taxFunctions.getWorkers_participation_fund());
             existingUser.setTotalTax(taxFunctions.getTotalTax());


            return taxFunctionsRepo.save(existingUser);
        } else {

            throw new EntityNotFoundException("User not found with ID: " + taxFunctions.getTaxFunctionID());
        }
    }
}
