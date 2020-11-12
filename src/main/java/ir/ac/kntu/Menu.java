package ir.ac.kntu;

import java.util.*;

public class Menu {
    static Scanner in=new Scanner(System.in);
    public static int counter=0;

    public static void showMainMenu(){
        System.out.println("1.Current Time");
        System.out.println("2.Search Consignment By Order Status Menu");
        System.out.println("3.Search Status Of Consignment By Consignment");
        System.out.println("4.Search Status Of Consignments By Origin");
        System.out.println("5.Search Status Of Consignments By Destinations");
        System.out.println("6.Search Customer By Name And National Code");
        System.out.println("7.Choose A Branch To Statistics");
        System.out.println("0.End");
        mainMenu(in.nextInt());

    }

    public static void mainMenu(int main){
        switch (main){
            case 0:
                System.out.println("*THE END*");
                break;
            case 1:
                timeMenu();
                break;
            case 2:
                counter++;
                orderStatusMenu();
                Consignment.searchByStatus(in.nextInt());
                break;
            case 3:
                counter++;
                consignmentsMenu();
                Consignment.consignmentsStatus(in.nextInt());
                break;
            case 4:
                counter++;
                originMenu();
                Consignment.chooseBranch(in.nextInt());
                break;
            case 5:
                counter++;
                destinationsMenu();
                Consignment.chooseDestination(in.nextInt());
                break;
            case 6:
                customerInfoMenu();
                break;
            case 7:
                counter++;
                statisticsOfBranchesMenu();
                break;
            default:
                System.out.println("Incorrect Input! Try Again!");
                showMainMenu();
        }
    }

    public static void sendingMethodsMenu(){
        System.out.println("Choose Sending Method:");
        System.out.println("1.Ground"+"\n"+"2.Aerial"+"\n"+"3.Marine"+"\n"+"0.Main Menu");
    }

    public static void postingMethodsMenu(){
        System.out.println("Choose Posting Method:");
        System.out.println("1.Usual"+"\n"+"2.Custom"+"\n"+"0.Main Menu");
    }

    public static void orderStatusMenu(){
        System.out.println("Choose Sending Status :");
        System.out.println("1.In stock"+"\n"+"2.Posted"+"\n"+"3.Received"+"\n"+"0.Main Menu");
    }

    public static void consignmentsMenu(){
        System.out.println("Choose A Consignment To Find The Status :");
        for (int i = 0; i< Consignment.getConsignments().size(); i++)
            System.out.println(i+1+"."+Consignment.getConsignments().get(i));
        System.out.println("0.Main Menu");
    }

    public static void originMenu(){
        System.out.println("Search By Branch (Origin):");
        branchesMenu();
        System.out.println("0.Main Menu");
    }
    public static void branchesMenu(){
        for (int i=0;i<Branch.getBranches().size();i++)
            System.out.println(i+1+"."+Branch.getBranches().get(i));
    }

    public static void destinationsMenu(){
        System.out.println("Search By Destination: ");
        for (int i=0;i<Consignment.getHelpDestinations().size();i++)
            System.out.println(i+1+"."+Consignment.getHelpDestinations().get(i));
        System.out.println("0.Main Menu");


    }



    public static void timeMenu(){
        System.out.println("Enter Current Time: ");
        System.out.println("1.Date"+"\n"+"2.Time"+"\n"+"0.Main Menu");
        switch (in.nextInt()){
            case 1:
                dateMenu();
                break;
            case 2:
                hourMenu();
                break;
            case 0:
                showMainMenu();
                break;
            default:
                System.out.println("Incorrect Input! Try Again!");
                timeMenu();

        }

    }

    public static void dateMenu(){
        int day,month,year;
        System.out.println("Enter Current Date:");
        System.out.print("Year: ");
        year=in.nextInt();
        System.out.print("Month: ");
        month=in.nextInt();
        System.out.print("Day: ");
        day=in.nextInt();
        Date currentDate=new Date(year,month,day);
        Consignment.changeStatus(currentDate);
        timeMenu();
    }

    public static void hourMenu(){
        Time time=new Time();
        System.out.println("Enter Current Time:");
        System.out.print("Hour: ");
        time.setHour(in.nextInt());
        System.out.print("Minute: ");
        time.setMinute(in.nextInt());
        timeMenu();
    }

    public static void customerInfoMenu(){
        System.out.println("1.Name"+"\n"+"2.National Code "+"\n"+"0.Main Menu");
        switch (in.nextInt()){
            case 0:
                showMainMenu();
                break;
            case 1:
                Consignment.searchByName();
                break;
            case 2:
                Consignment.searchByNationalCode();
                break;
            default:
                System.out.println("Incorrect Input! Try Again!");
                customerInfoMenu();
        }

    }
    public static void statisticsOfBranchesMenu(){
        System.out.println("Choose A Statistics Way: ");
        System.out.println("1.Income Of A Branch"+"\n"+"2.Number Of Consignments Of A Branch"+"\n"+"3.Compare A Branch With Other Branches"+"\n"+"0.Main Menu");
        switch (in.nextInt()){
            case 0:
                showMainMenu();
                break;
            case 1:
                helpBranchMenu();
                Branch.branchIncome(in.nextInt());
                break;
            case 2:
                helpBranchMenu();
                Branch.numberOfConsignments(in.nextInt());
                break;
            case 3:
                helpBranchMenu();
                Branch.compareToAllBranches(in.nextInt());
                break;
            default:
                System.out.println("Incorrect Input! Try Again!");
                statisticsOfBranchesMenu();

        }
    }

    public static void helpBranchMenu(){
        System.out.println("Choose A Branch: ");
        branchesMenu();
        System.out.println("0.Choose A Statistics Way ");
    }

}
