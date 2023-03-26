package Payroll;
public class PayrollService {
    /**
     * Evaluates TFR from salary
     * @param grossAnnualSalary Salary before taxes
     * @return the TFR
     */
    protected double evaluateTFR(double grossAnnualSalary){
        return grossAnnualSalary * 6.91 /100;
    }
    /**
     * Evaluates INPS from salary
     * @param grossAnnualSalary Salary before taxes
     * @return the INPS
     */
    protected double evaluateINPS(double grossAnnualSalary){
        return grossAnnualSalary * 9.19 /100;
    }

    protected double evaluateIRPEF(double grossAnnualSalary){
        if (grossAnnualSalary<= 15000){
            return calculateIRPEF(grossAnnualSalary,23);
        } else if (grossAnnualSalary <= 28000) {
            return calculateIRPEF(grossAnnualSalary,27,15000,3450);
        } else if (grossAnnualSalary <= 55000) {
            return calculateIRPEF(grossAnnualSalary,38,28000,6960);
        } else if (grossAnnualSalary <= 75000) {
            return calculateIRPEF(grossAnnualSalary,41,55000,17220);
        } else{
            return calculateIRPEF(grossAnnualSalary,43,75000,25420);
        }
    }

    /**
     * Evaluates IRPEF with math formula
     * @param grossAnnualSalary Salary ANNUAL before taxes
     * @param percentage IRPEF percentage
     * @return the IRPEF
     */
    protected double calculateIRPEF(double grossAnnualSalary, double percentage){
        return calculateIRPEF(grossAnnualSalary,percentage,0,0);
    }
    /**
     * Evaluates IRPEF with math formula
     * @param grossAnnualSalary Salary ANNUAL before taxes
     * @param percentage IRPEF percentage
     * @param deltaTax Salary to be removed
     * @param baseTax Fixed tax
     * @return the IRPEF
     */
    protected double calculateIRPEF(double grossAnnualSalary, double percentage,double deltaTax,double baseTax){
        return percentage / 100.0 * (grossAnnualSalary -deltaTax) + baseTax;
    }
    public PayrollEntity evaluateTaxesAnnual(double grossAnnualSalary) {
        PayrollEntity out = new PayrollEntity();
        out.setInps(evaluateINPS(grossAnnualSalary));
        out.setIrpef(evaluateIRPEF(grossAnnualSalary));
        out.setTfr(evaluateTFR(grossAnnualSalary));

        out.setNet(grossAnnualSalary - out.getInps() - out.getIrpef() - out.getTfr());
        return out;
    }

}
