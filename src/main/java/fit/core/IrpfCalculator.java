package fit.core;

public class IrpfCalculator {
  /**
   *
   */
  private static final double EXEMPTION_VALUE_2021 = 1903.98;
  private static final double DEPENDENTS_DISCOUNT = 189.59;

  private IrpfCalculator() {
    throw new IllegalStateException("Utility class");
  }

  public static double calculateBaseSalary(double totalSalary) {
    return totalSalary - (totalSalary * 0.11);
  }

  public static double calculateExemption() {
    return EXEMPTION_VALUE_2021;
  }

  public static double dependentsDiscount(int nroDependents) {
    return nroDependents * DEPENDENTS_DISCOUNT;
  }

  public static double calculateDiscount(double baseSalary) {
    return baseSalary - calculateExemption();
  }

  public static double calculateTaxLayer(double baseSalary) {
    if (baseSalary <= 1903.98) return 0.0;
    if (baseSalary <= 2826.65) return 0.075;
    if (baseSalary <= 3751.05) return 0.15;
    if (baseSalary <= 4664.68) return 0.225;
    return 0.275;
  }

  public static double calculateIrpf(double totalSalary) {
    var baseSalary = calculateBaseSalary(totalSalary);
    var discountValue = calculateDiscount(baseSalary);
    var taxValue = calculateTaxLayer(baseSalary);

    return discountValue * taxValue;
  }

  public static double calculateIrpf(double totalSalary, int nroDependents) {
    var baseSalary = calculateBaseSalary(totalSalary);
    var dependentsDiscount = dependentsDiscount(nroDependents);
    baseSalary = baseSalary - dependentsDiscount;
    var discountValue = calculateDiscount(baseSalary);
    var taxValue = calculateTaxLayer(baseSalary);

    return discountValue * taxValue;
  }
}
