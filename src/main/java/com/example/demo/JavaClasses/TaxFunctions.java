package com.example.demo.JavaClasses;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
@Entity
@Component
@Getter
public class TaxFunctions {
        void totalTaxable(double temp){
                total_taxable+=(long)temp;
        }


        @Id
        private int taxFunctionID;
        public int getTaxFunctionID() {
                return taxFunctionID;
        }
        public void setTaxFunctionID(int taxFunctionID) {
                this.taxFunctionID = taxFunctionID;
        }


        private int userID;
        public void setUserID(int userID) {
                this.userID = userID;
        }

        @Setter
        private long total_taxable=0;


        private double main_salary=0;
        private double forgiven_main_salary=0;
        private double taxable_main_salary=0;
        public void setMain_salary(double value){
                this.main_salary=value;
                taxable_main_salary=this.main_salary;
                forgiven_main_salary=0;
                this.totalTaxable(taxable_main_salary);
        }

        private double special_salary=0;
        private double forgiven_special_salary=0;
        private double taxable_special_salary=0;
        public void setSpecial_salary(double value){
                this.special_salary=value;
                taxable_special_salary=this.special_salary;
                forgiven_special_salary=0;
                this.totalTaxable(taxable_special_salary);
        }
        private double salary_dues=0;
        private double forgiven_salary_dues=0;
        private double taxable_salary_dues=0;
        public void setSalary_dues(double value){
                this.salary_dues=value;
                forgiven_salary_dues=0;
                taxable_salary_dues=salary_dues-forgiven_salary_dues;
                this.totalTaxable(taxable_salary_dues);
        }
        private double dearness_allowance=0;
        private double forgiven_dearness_allowance=0;
        private double taxable_dearness_allowance=0;
        public void setDearness_allowance(double value){
                this.dearness_allowance=value;
                forgiven_dearness_allowance=0;
                taxable_dearness_allowance=dearness_allowance-forgiven_dearness_allowance;
                this.totalTaxable(taxable_dearness_allowance);
        }
        private double rent_allowance=0;
        private double forgiven_rent_allowance=0;
        private double taxable_rent_allowance=0;
        public void setRent_allowance(double value){
                this.rent_allowance=value;
                double tem=main_salary/2;
                double rem=300000.0;
                double temp=Math.min(tem,rem);
                forgiven_rent_allowance= Math.min(rent_allowance, temp);
                taxable_rent_allowance=rent_allowance-forgiven_rent_allowance;
                if(taxable_rent_allowance<0)taxable_rent_allowance=0;
                this.totalTaxable(taxable_rent_allowance);
        }
        private double medical_allowance=0;
        private double forgiven_medical_allowance=0;
        private double taxable_medical_allowance=0;
        public void setMedical_allowance(double value){
                this.medical_allowance=value;
                double tem=main_salary/10;
                double rem=120000.0;
                double temp=Math.min(tem,rem);
                forgiven_medical_allowance= Math.min(medical_allowance, temp);
                taxable_medical_allowance=medical_allowance-forgiven_medical_allowance;
                if(taxable_rent_allowance<0)taxable_medical_allowance=0;
                this.totalTaxable(taxable_medical_allowance);
        }

        private double additionalMedicalAllowance=0;//heart,eye,liver,cancer surgery
        private double forgiven_additionalMedicalAllowance=0;
        private double taxable_additionalMedicalAllowance=0;
        public void setAdditionalMedicalAllowance(double value){
                this.additionalMedicalAllowance=value;
                forgiven_additionalMedicalAllowance=additionalMedicalAllowance;
                taxable_additionalMedicalAllowance=0;
                this.totalTaxable(taxable_additionalMedicalAllowance);
        }

        private double travel_allowance=0;
        private double forgiven_travel_allowance=0;
        private double taxable_travel_allowance=0;
        public void setTravel_allowance(double value){
                this.travel_allowance=value;

                forgiven_travel_allowance=(value > 30000.0) ? value-30000.0 : value;
                taxable_travel_allowance=travel_allowance-forgiven_travel_allowance;
                if(taxable_travel_allowance<0)taxable_travel_allowance=0;
                this.totalTaxable(taxable_travel_allowance);
        }

        private double festival_allowance=0;
        private double forgiven_festival_allowance=0;
        private double taxable_festival_allowance=0;
        public void setFestival_allowance(double value){
                this.festival_allowance=value;
                forgiven_festival_allowance=0;
                taxable_festival_allowance=value;
                if(taxable_festival_allowance<0)taxable_festival_allowance=0;
                this.totalTaxable(taxable_festival_allowance);
        }
        private double attendant_allowance=0;
        private double forgiven_attendant_allowance=0;
        private double taxable_attendant_allowance=0;
        public void setAttendant_allowance(double value){
                this.attendant_allowance=value;
                forgiven_attendant_allowance=0;
                taxable_attendant_allowance=value;
                if(taxable_attendant_allowance<0)taxable_attendant_allowance=0;
                this.totalTaxable(taxable_attendant_allowance);
        }
        private double onLeaveAllowance=0;
        private double forgiven_onLeave_allowance=0;
        private double taxable_onLeave_allowance=0;
        public void setonLeaveAllowance(double value){
                this.onLeaveAllowance=value;
                forgiven_onLeave_allowance=0;
                taxable_onLeave_allowance=value;
                if(taxable_onLeave_allowance<0)taxable_onLeave_allowance=0;
                this.totalTaxable(taxable_onLeave_allowance);
        }

        private double earnedReward=0;
        private double forgiven_earnedReward=0;
        private double taxable_earnedReward=0;
        public void setEarnedReward(double value){
                this.earnedReward=value;
                forgiven_earnedReward=0;
                taxable_earnedReward=this.earnedReward;
                this.totalTaxable(this.taxable_earnedReward);
        }

        private double overTimeFee=0;
        private double forgiven_overTimeFee=0;
        private double taxable_overTimeFee=0;

        public void setOverTimeFee(double value){
                this.overTimeFee=value;
                this.forgiven_overTimeFee=0;
                this.taxable_overTimeFee=value;
                this.totalTaxable(this.taxable_overTimeFee);
        }

        private double bonusSalary=0;
        private double forgiven_bonus_salary=0;
        private double taxable_bonus_salary=0;
        public void setBonusSalary(double value){
                this.bonusSalary =value;
                forgiven_bonus_salary=0;
                taxable_bonus_salary=value;
                if(taxable_bonus_salary<0)taxable_bonus_salary=0;
                this.totalTaxable(taxable_bonus_salary);
        }

        private double savedInFutureFund=0;
        private double forgiven_savedInFutureFund=0;
        private double taxable_savedInFutureFund=0;

        public void setSavedInFutureFund(double value){
                this.savedInFutureFund=value;
                this.forgiven_savedInFutureFund=0;
                this.taxable_savedInFutureFund=value;
                this.totalTaxable(this.taxable_savedInFutureFund);
        }


        private double interestFromFutureFund=0;
        private double forgiven_interestFromFutureFund=0;
        private double taxable_interestFromFutureFund=0;
        public void setInterestFromFutureFund(double value){
                this.interestFromFutureFund=value;
                double temp= Math.min((main_salary / 3), (main_salary * 0.1450));
                if(interestFromFutureFund<=temp)
                        forgiven_interestFromFutureFund=value;
                else
                        forgiven_interestFromFutureFund=temp;
                taxable_interestFromFutureFund=interestFromFutureFund-forgiven_interestFromFutureFund;
                if(taxable_interestFromFutureFund<0)taxable_interestFromFutureFund=0;
                this.totalTaxable(taxable_interestFromFutureFund);
        }

        private String useOfOfficeVehicle="null";
        private double forgiven_useOfOfficeVehicle=0;
        private double taxable_useOfOfficeVehicle=0;
        public void setUseOfOfficeVehicle(String value){
                this.useOfOfficeVehicle=value;
                if(value.equals("yes")){
                        double temp= Math.max((60000.0), (main_salary * 0.05));
                        forgiven_useOfOfficeVehicle=0;
                      taxable_useOfOfficeVehicle=temp;
                        if(taxable_interestFromFutureFund<0)taxable_interestFromFutureFund=0;
                        this.totalTaxable(taxable_interestFromFutureFund);
                }

        }
        private String useOfOfficeHome="null";
        private double forgiven_useOfOfficeHome=0;
        private double taxable_useOfOfficeHome=0;
        public void setUseOfOfficeHome(String value){
                this.useOfOfficeHome=value;
                if(value.equals("yes")){
                        forgiven_useOfOfficeHome=0;
                        taxable_useOfOfficeHome = main_salary*0.25;
                        if(taxable_useOfOfficeHome<0)taxable_useOfOfficeHome=0;
                        this.totalTaxable(taxable_useOfOfficeHome);
                }

        }
        private double otherAdvantagesFromCompany=0;
        private double forgiven_otherAdvantagesFromCompany=0;
        private double taxable_otherAdvantagesFromCompany=0;
        public void setOtherAdvantagesFromCompany(double value){
                this.otherAdvantagesFromCompany=value;
                forgiven_otherAdvantagesFromCompany=0;
                taxable_otherAdvantagesFromCompany=value;
                        if(taxable_otherAdvantagesFromCompany<0)taxable_otherAdvantagesFromCompany=0;
                        this.totalTaxable(taxable_otherAdvantagesFromCompany);


        }
        private double vacation_monetization=0;
        private double forgiven_vacation_monetization=0;
        private double taxable_vacation_monetization=0;
        public void setVacation_monetization(double value){
                this.vacation_monetization=value;
                forgiven_vacation_monetization=0;
                taxable_vacation_monetization=value;
                if(taxable_vacation_monetization<0)taxable_vacation_monetization=0;
                this.totalTaxable(taxable_vacation_monetization);

        }
        private double gratuity=0;
        private double forgiven_gratuity=0;
        private double taxable_gratuity=0;
        public void setGratuity(double value){
                this.gratuity=value;
                forgiven_gratuity= Math.min(gratuity, 25000000.0);
                taxable_gratuity=value-forgiven_gratuity;
                if(taxable_gratuity<0)taxable_gratuity=0;
                this.totalTaxable(taxable_gratuity);

        }
        private double workers_participation_fund=0;
        private double forgiven_workers_participation_fund=0;
        private double taxable_workers_participation_fund=0;
        public void setWorkers_participation_fund(double value){
                this.workers_participation_fund=value;
                forgiven_workers_participation_fund= Math.min(workers_participation_fund, 50000.0);
                taxable_workers_participation_fund=value-forgiven_workers_participation_fund;
                if(taxable_workers_participation_fund<0)taxable_workers_participation_fund=0;
                this.totalTaxable(taxable_workers_participation_fund);

        }

        @Setter
        private long totalTax=0;

        public long getTotalTax(){
                return calculateTax();
        }
        private long calculateTax(){
                long demoTotalTaxable=this.total_taxable;

                if(demoTotalTaxable<0)return 0;

                else if(demoTotalTaxable>=0 && demoTotalTaxable<=300000){
                        return 0;
                }
                else if(demoTotalTaxable>=300001 && demoTotalTaxable<=400000){
                        return (long) ((demoTotalTaxable-300000)*0.05);

                }
                else if(demoTotalTaxable>=400001 && demoTotalTaxable<=700000){

                        return (long) (((demoTotalTaxable-300000)*0.05)+((demoTotalTaxable-400000)*0.01));
                }
                else {
                        return (long) (((demoTotalTaxable-300000)*0.05)+((demoTotalTaxable-400000)*0.01)+((demoTotalTaxable-700000)*0.15));
                }
        }

}


















