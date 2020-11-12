package ir.ac.kntu;

import java.util.*;
public class Consignment {
    private static String sendingMethod;
    private String name;
    private String sender;
    private double price;
    private Customer receiver=new Customer();
    private Branch branch=new Branch();
    private static ArrayList<Branch>branches=new ArrayList<Branch>();
    private City destination;
    private static ArrayList<City> destinations=new ArrayList<City>();
    private static ArrayList<City>helpDestinations=new ArrayList<City>();
    double weight;
    private Date sendingDate=new Date();
    private Date receivingDate=new Date();
    //private String ir.ac.kntu.SendingMethod;
    private String postingMethod;
    private String orderStatus="In stock";
    private static ArrayList<Consignment>consignments=new ArrayList<Consignment>();
    private static ArrayList<Customer>customers=new ArrayList<Customer>();
    static Scanner in=new Scanner(System.in);

    public Consignment() {
    }


    public Consignment(String name, double price , String sender, Customer receiver, Branch branch, City destination, double weight, Date sendingTime, Date receivingTime, String sendingMethod, String postingMethod) {
        this.name = name;
        this.price=price;
        this.sender=sender;
        this.receiver = receiver;
        customers.add(receiver);
        this.branch = branch;
        branches.add(branch);
        this.destination = destination;
        destinations.add(destination);
        helpDestinations=removeDuplicates(destinations);
        this.weight = weight;
        this.sendingDate = sendingTime;
        this.receivingDate = receivingTime;
        Consignment.sendingMethod = sendingMethod;
        this.postingMethod = postingMethod;
        consignments.add(this);
    }

    public Consignment(String name, String sender, Customer receiver, Branch branch, City destination, double weight, Date sendingTime, Date receivingTime) {
        this.name = name;
        this.sender = sender;
        this.receiver = receiver;
        this.branch = branch;
        this.destination = destination;
        this.weight = weight;
    }



    public static ArrayList<Consignment> getConsignments() {
        return consignments;
    }

    public static void setConsignments(ArrayList<Consignment> consignments) {
        Consignment.consignments = consignments;
    }

    public String getStatus() {
        return orderStatus;
    }

    public void setStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Customer getReceiver() {
        return receiver;
    }

    public void setReceiver(Customer receiver) {
        this.receiver = receiver;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public City getDestination() {
        return destination;
    }

    public void setDestination(City destination) {
        this.destination = destination;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Date getSendingTime() {
        return sendingDate;
    }

    public void setSendingTime(Date sendingTime) {
        this.sendingDate = sendingTime;
    }

    public Date getReceivingTime() {
        return receivingDate;
    }

    public void setReceivingTime(Date receivingTime) {
        this.receivingDate = receivingTime;
    }

    public static ArrayList<Branch> getBranches() {
        return branches;
    }

    public static void setBranches(ArrayList<Branch> branches) {
        Consignment.branches = branches;
    }

    public static ArrayList<City> getDestinations() {
        return destinations;
    }

    public static void setDestinations(ArrayList<City> destinations) {
        Consignment.destinations = destinations;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static ArrayList<City> getHelpDestinations() {
        return helpDestinations;
    }

    public static void setHelpDestinations(ArrayList<City> helpDestinations) {
        Consignment.helpDestinations = helpDestinations;
    }


    public static void consignmentsStatus(int consignmentId){
        if (consignmentId<=consignments.size() && consignmentId!=0) {
            System.out.println("************************************");
            System.out.println("The status of " + consignments.get(consignmentId - 1) + ":" +"**"+consignments.get(consignmentId - 1).orderStatus+"**");
            System.out.println("************************************");
            Menu.consignmentsMenu();
            consignmentsStatus(in.nextInt());
        }
        else if (consignmentId==0){
            Menu.showMainMenu();
        }
        else
        {
            System.out.println("Incorrect Input! Try Again!");
            Menu.consignmentsMenu();
            consignmentsStatus(in.nextInt());

        }
    }

    public static void chooseBranch(int branchId){
        if (branchId<=Branch.getBranches().size() && branchId!=0) {
            searchByOrigin(Branch.getBranches().get(branchId-1));
            Menu.originMenu();
            chooseBranch(in.nextInt());
        }
        else if (branchId==0){
            Menu.showMainMenu();
        }
        else
        {
            System.out.println("Incorrect Input! Try Again!");
            Menu.originMenu();
            chooseBranch(in.nextInt());

        }
    }

    public static void chooseDestination(int destinationId){
        if (destinationId<=destinations.size() && destinationId!=0) {
            searchByDestination(destinations.get(destinationId-1));
            Menu.destinationsMenu();
            chooseDestination(in.nextInt());
        }
        else if (destinationId==0){
            Menu.showMainMenu();
        }
        else
        {
            System.out.println("Incorrect Input! Try Again!");
            Menu.destinationsMenu();
            chooseDestination(in.nextInt());

        }
    }

    public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list)
    {
        ArrayList<T> newList = new ArrayList<T>();
        for (T element : list) {
            if (!newList.contains(element)) {

                newList.add(element);
            }
        }
        return newList;
    }

    public static void sendingMethod(int sendingMethodId){
        switch (sendingMethodId) {
            case 1:
                sendingMethod="Ground";
                Menu.sendingMethodsMenu();
                sendingMethod(in.nextInt());
                break;
            case 2:
                sendingMethod="Aerial";
                Menu.sendingMethodsMenu();
                sendingMethod(in.nextInt());
                break;
            case 3:
                sendingMethod="Marine";
                Menu.sendingMethodsMenu();
                sendingMethod(in.nextInt());
                break;
            case 0:
                Menu.showMainMenu();
                break;
            default:
                System.out.println("Incorrect Input! Try Again!");
                Menu.sendingMethodsMenu();
                sendingMethod(in.nextInt());

        }
    }

    public static void  postingMethod(int postingMethodId){
        switch (postingMethodId) {
            case 1:
                sendingMethod="Usual";
                Menu.postingMethodsMenu();
                postingMethod(in.nextInt());
                break;
            case 2:
                sendingMethod="Custom";
                Menu.postingMethodsMenu();
                postingMethod(in.nextInt());
                break;
            case 0:
                Menu.showMainMenu();
                break;
            default:
                System.out.println("Incorrect Input! Try Again!");
                Menu.postingMethodsMenu();
                postingMethod(in.nextInt());

        }
    }

    public void changeOrderStatus(Date date){
        if (date.compareTo(sendingDate)>=0 && date.compareTo(receivingDate)<0)
                orderStatus="Posted";
        else if (date.compareTo(receivingDate)>=0)
                orderStatus="Received";
        }
    public static void changeStatus(Date date){
        for (Consignment consignment : consignments) {
            if (date.compareTo(consignment.getSendingTime()) >= 0 && date.compareTo(consignment.getReceivingTime()) < 0)
                consignment.orderStatus = "Posted";
            else if (date.compareTo(consignment.getReceivingTime()) >= 0)
                consignment.orderStatus = "Received";

        }

    }

    public static void searchByNationalCode() {
        int temp = 0;
        System.out.print("National Code: ");
        if (Menu.counter>0) {
            in.nextLine();
            Menu.counter=0;
        }
        String nationalCode=in.nextLine();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getNationalCode().equalsIgnoreCase(nationalCode)) {
                System.out.println(consignments.get(i));
                temp = i;
            }
        }
        if (!customers.get(temp).getNationalCode().equalsIgnoreCase(nationalCode))
            System.out.println("Not Found!");
        Menu.customerInfoMenu();
    }


    public static void searchByName(){
        System.out.print("Name: ");
        if (Menu.counter>0) {
            in.nextLine();
            Menu.counter=0;
        }
        String name=in.nextLine();
        int temp=0;
        for (int i=0;i<customers.size();i++) {
            if (customers.get(i).getName().equalsIgnoreCase(name)) {
                System.out.println(consignments.get(i));
                temp=i;
            }
        }
        if (!customers.get(temp).getName().equalsIgnoreCase(name))
            System.out.println("Not Found!");
        Menu.customerInfoMenu();



    }

    public static void searchByOrigin(Branch branch){
        for (int i=0;i<branches.size();i++) {
            if (branches.get(i).equals(branch))
                System.out.println(consignments.get(i));
        }

    }

    public static void searchByDestination(City destination){
        for (int i=0;i<destinations.size();i++) {
            if (destinations.get(i).equals(destination))
                System.out.println(consignments.get(i));
        }
    }




    public static void searchByStatus(int st){
        switch (st) {
            case 1:
                for (Consignment consignment : consignments) {
                    if (consignment.getStatus().equalsIgnoreCase("In stock"))
                        System.out.println(consignment);
                }
                Menu.orderStatusMenu();
                searchByStatus(in.nextInt());
             break;
            case 2:
                for (Consignment consignment : consignments) {
                    if (consignment.getStatus().equalsIgnoreCase("Posted"))
                        System.out.println(consignment);
                }
                Menu.orderStatusMenu();
                searchByStatus(in.nextInt());
                break;
            case 3:
                for (Consignment consignment : consignments) {
                    if (consignment.getStatus().equalsIgnoreCase("Received"))
                        System.out.println(consignment);
                }
                Menu.orderStatusMenu();
                searchByStatus(in.nextInt());
                break;
            case 0:
                Menu.showMainMenu();
                break;
            default:
                System.out.println("Incorrect Input! Try Again!");
                Menu.orderStatusMenu();
                searchByStatus(in.nextInt());

        }
    }

    @Override
    public String toString() {
        return "Consignment:" +"\n" +
                "name= " + name + "\n" +
                "sender= " + sender + "\n" +
                "price= " + price + "\n"+
                "receiver= " + receiver + "\n"+
                "branch= " + branch + "\n"+
                "destination= " + destination + "\n"+
                "weight= " + weight + "\n"+
                "sendingDate= " + sendingDate + "\n"+
                "receivingDate= " + receivingDate + "\n"+
                "PostingMethod= " + postingMethod +"\n"+
                "**************************************";
    }


}
