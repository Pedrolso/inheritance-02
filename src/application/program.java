package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> list = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int empNumber = sc.nextInt();

        for (int i = 1; i <= empNumber; i++) {
            System.out.println("Tax payer #" + i + " data:");

            System.out.print("Individual or company (i/c)? ");
            char ic = sc.next().charAt(0);

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Anual income: ");
            double aIncome = sc.nextDouble();

            if (ic == 'i') {
                System.out.print("Health expenditures: ");
                double healthE = sc.nextDouble();

                TaxPayer iTaxPayer = new Individual(name, aIncome, healthE);
                list.add(iTaxPayer);
            } else if (ic == 'c') {
                System.out.print("Number of employees: ");
                int eNumber = sc.nextInt();

                TaxPayer cTaxPayer = new Company(name, aIncome, eNumber);
                list.add(cTaxPayer);
            }
        }
        System.out.println();
        System.out.println("TAXES PAID:");

        for (TaxPayer c : list) {
            System.out.println(c.getName() + ": $ " + String.format("%.2f", c.tax()));
        }

        double som = 0.0;
        for (TaxPayer s : list) {
            som += s.tax();
        }

        System.out.println();
        System.out.print("TOTAL TAXES: $ " + String.format("%.2f", som));
    }
}
