package ir.ac.kntu;

import java.util.*;

public class Branch {
    private String branchCode;
    private City city;
    private int numberOfEmployees;
    private double income=0.0;
    private int numberOfConsignments=0;
    private static ArrayList<Branch>branches=new ArrayList<Branch>();
    Scanner in=new Scanner(System.in);

    public Branch() {
    }

    public Branch(String branchCode, City city, int numberOfEmployees) {
        this.branchCode = branchCode;
        this.city = city;
        this.numberOfEmployees = numberOfEmployees;
        branches.add(this);
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public static ArrayList<Branch> getBranches() {
        return branches;
    }

    public static void setBranches(ArrayList<Branch> branches) {
        Branch.branches = branches;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public int getNumberOfConsignments() {
        return numberOfConsignments;
    }

    public void setNumberOfConsignments(int numberOfConsignments) {
        this.numberOfConsignments = numberOfConsignments;
    }

    public static void branchIncome(int id){
        if (id<=branches.size() && id!=0) {
            income();
            System.out.println("Income Of " + branches.get(id-1) + "\n"+ "***" + branches.get(id-1).income+ "***");
            helpIncome();
        }
        if (id>branches.size()) {
            System.out.println("Incorrect Input! Try Again!");
            helpIncome();
        }
        if (id==0)
            Menu.statisticsOfBranchesMenu();
    }

    public static void helpIncome(){
        Scanner in=new Scanner(System.in);
        System.out.println("Choose A Branch: ");
        Menu.branchesMenu();
        System.out.println("0.Choose A Statistics Way ");
        branchIncome(in.nextInt());
    }

   public static void income(){
       for (Branch branch : branches) {
           branch.income = 0.0;
           for (int i = 0; i < Consignment.getConsignments().size(); i++) {
               if (Consignment.getConsignments().get(i).getBranch().equals(branch))
                   branch.income += Consignment.getConsignments().get(i).getPrice();
           }
       }

    }

    public static void numberOfConsignment(){
        for (Branch branch : branches) {
            branch.numberOfConsignments = 0;
            for (int i = 0; i < Consignment.getConsignments().size(); i++) {
                if (Consignment.getConsignments().get(i).getBranch().equals(branch))
                    branch.numberOfConsignments++;
            }
        }

    }

    public static void numberOfConsignments(int id) {
        if (id<=branches.size() && id!=0) {
           numberOfConsignment();
            System.out.println("Number Of " + branches.get(id-1) + "Consignments : " + branches.get(id-1).numberOfConsignments);
            helpNumber();
        }
        if (id>branches.size()) {
            System.out.println("Incorrect Input! Try Again!");
            helpNumber();

        }
        if(id==0)
        Menu.statisticsOfBranchesMenu();

    }
    public static void helpNumber(){
        Scanner in=new Scanner(System.in);
        System.out.println("Choose A Branch: ");
        Menu.branchesMenu();
        System.out.println("0.Choose A Statistics Way ");
        numberOfConsignments(in.nextInt());
    }

    public void compareTo(Branch branch){
        if (this.income>branch.income)
            System.out.println(this+" have much income than "+branch);
        if (this.income<branch.income)
            System.out.println(this+" have less income than "+branch);
        if (this.income==branch.income)
            System.out.println(this+" have equal income with "+ branch);
        if (this.numberOfConsignments>branch.numberOfConsignments)
            System.out.println(this+" have more Consignments than "+branch);
        if (this.numberOfConsignments<branch.numberOfConsignments)
            System.out.println(this+" have less Consignments than "+branch);
        if (this.numberOfConsignments==branch.numberOfConsignments)
            System.out.println(this+" have equal Consignments with "+branch);
    }


    public static void compareToAllBranches(int id){
        if (id!=0 && id<=branches.size()){
        Branch temp=branches.get(id-1);
            income();
            numberOfConsignment();
            for (Branch branch : branches) {
                if (!branch.equals(temp)) {
                    if (temp.income > branch.income)
                        System.out.println(temp + " have much income than " + "\n" + "{" + branch + "}");
                    if (temp.income < branch.income)
                        System.out.println(temp + " have less income than " + "\n" + "{" + branch + "}");
                    if (temp.income == branch.income)
                        System.out.println(temp + " have equal income with " + "\n" + "{" + branch + "}");
                    if (temp.numberOfConsignments > branch.numberOfConsignments)
                        System.out.println(temp + " have more Consignments than " + "\n" + "{" + branch + "}");
                    if (temp.numberOfConsignments < branch.numberOfConsignments)
                        System.out.println(temp + " have less Consignments than " + "\n" + "{" + branch + "}");
                    if (temp.numberOfConsignments == branch.numberOfConsignments)
                        System.out.println(temp + " have equal Consignments with " + "\n" + "{" + branch + "}");
                }
            }
            helpCompareTo();
        }
        if (id>branches.size()) {
            System.out.println("Incorrect Input! Try Again!");
            helpCompareTo();
        }
        if (id==0)
        Menu.statisticsOfBranchesMenu();
    }

    public static void helpCompareTo(){
        Scanner in=new Scanner(System.in);
        System.out.println("Choose A Branch: ");
        Menu.branchesMenu();
        System.out.println("0.Choose A Statistics Way ");
       compareToAllBranches(in.nextInt());
    }

    @Override
    public String toString() {
        return "Branch:" +"\n" +
                "branchCode= " + branchCode + "\n" +
                "city= " + city + "\n" +
                "numberOfEmployees= " + numberOfEmployees;
    }

}
