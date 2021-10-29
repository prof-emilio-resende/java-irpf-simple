package fit.core;

public class IrpfCalculator {
  public static final double INSS_TAX = 0.11;
  public static final double EXEMPTION_VALUE = 1903.98;

  public static double calculateBaseSalary(double totalSalary) {
    return totalSalary - (totalSalary * INSS_TAX);
  }

  public static double calculateDiscount(double baseSalary) {
    return baseSalary - EXEMPTION_VALUE;
  }

  public static double calculateTaxLayer(double baseSalary) {
    if (baseSalary <= 1903.98) return 0.0;
    if (baseSalary <= 2826.65) return 0.075;
    if (baseSalary <= 3751.05) return 0.15;
    if (baseSalary <= 4664.68) return 0.225;
    
    return 0.275;
  }

  public static double calculateExemption() {
    return EXEMPTION_VALUE;
  }

  public static double calculateIrpf(double totalSalary) {
    var baseSalary = calculateBaseSalary(totalSalary);
    var discountValue = calculateDiscount(baseSalary);
    var tax = calculateTaxLayer(baseSalary);

    return discountValue * tax;
  }
}
