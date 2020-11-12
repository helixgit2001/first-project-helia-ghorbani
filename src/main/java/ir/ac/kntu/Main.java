package ir.ac.kntu;

public class Main {
    public static void main(String[] args) {
        
        //Factory Name As A Sender
        String sender="Paper Factory";

        //Make Customers
        Customer customer1=new Customer("Zahra","0020219091");
        Customer customer2=new Customer("Hedie","0022239291");
        Customer customer3=new Customer("Narges","0024232290");
        Customer customer4=new Customer("Shirin","0041751219");



        //Make City For Customers
        City city1=new City("Tehran","12.434","16.896");
        City city2=new City("Shiraz","14.7675","17.8797");
        City city3=new City("Mashhad","17.3534","19.4342");
        City city4=new City("Isfahan","20.3545","27.0953");
        City city5=new City("Golestan","20.3545","27.0953");
        City city6=new City("Gilan","20.3545","27.0953");


        //Make ir.ac.kntu.City For Branches
        City branchCity1=new City("Tehran","12.7675","13.908");
        City branchCity2=new City("Isfahan","20.987","18.328");
        City branchCity3=new City("Mazandaran","23.807","12.976");

        //Make Branches
        Branch branch1=new Branch("1001",branchCity1,50);
        Branch branch2=new Branch("1002",branchCity2,79);
        Branch branch3=new Branch("1003",branchCity3,205);


        //Make Dates As Sending And Receiving
        Date sendingDate1=new Date(1399,11,22);
        Date receivingDate1=new Date(1399,12,1);

        Date sendingDate2=new Date(1399,12,2);
        Date receivingDate2=new Date(1399,12,27);

        Date sendingDate3=new Date(1399,9,11);
        Date receivingDate3=new Date(1399,9,23);

        Date sendingDate4=new Date(1399,11,22);
        Date receivingDate4=new Date(1399,12,1);

        Date sendingDate5=new Date(1399,12,6);
        Date receivingDate5=new Date(1399,12,28);

        Date sendingDate6=new Date(1399,9,12);
        Date receivingDate6=new Date(1399,9,23);

        //sending method
        String ground=SendingMethod.GROUND.toString();
        String aerial=SendingMethod.AERIAL.toString();
        String marine=SendingMethod.MARINE.toString();

        //posting method
        String usual=PostingMethod.USUAL.toString();
        String custom=PostingMethod.CUSTOM.toString();




        //Make Consignments

        Consignment consignment1=new Consignment("A4 Paper",765.5,sender,customer1,branch1,city2,12.5,sendingDate1,receivingDate1,ground,usual);
        Consignment consignment2=new Consignment("A2 Paper",560,sender,customer1,branch2,city4,25.8,sendingDate2,receivingDate2,aerial,custom);
        Consignment consignment3=new Consignment("A1 Paper",90,sender,customer1,branch3,city5,100.45,sendingDate3,receivingDate3,marine,usual);
        Consignment consignment4=new Consignment("A3 Paper",73.5,sender,customer1,branch3,city6,220,sendingDate4,receivingDate4,aerial,custom);
        Consignment consignment5=new Consignment("A4 Paper",222.5,sender,customer1,branch2,city1,122.5,sendingDate5,receivingDate5,ground,usual);
        Consignment consignment6=new Consignment("A2 Paper",27.98,sender,customer1,branch3,city3,254.8,sendingDate6,receivingDate6,marine,custom);
        customer1.cart(consignment1);
        customer1.cart(consignment2);
        customer1.cart(consignment3);
        customer1.cart(consignment4);
        customer1.cart(consignment5);
        customer1.cart(consignment6);

        Consignment consignment7=new Consignment("A4 Paper",1500.6,sender,customer2,branch1,city2,20.7,sendingDate4,receivingDate4,ground,usual);
        Consignment consignment8=new Consignment("A2 Paper",908,sender,customer2,branch2,city4,100.6,sendingDate2,receivingDate2,aerial,custom);
        Consignment consignment9=new Consignment("A1 Paper",90,sender,customer2,branch3,city5,27.5,sendingDate5,receivingDate5,marine,usual);
        Consignment consignment10=new Consignment("A3 Paper",750,sender,customer3,branch3,city6,227,sendingDate3,receivingDate3,aerial,custom);
        Consignment consignment11=new Consignment("A4 Paper",1560,sender,customer3,branch2,city1,270,sendingDate2,receivingDate2,ground,usual);
        Consignment consignment12=new Consignment("A2 Paper",650,sender,customer4,branch3,city3,89,sendingDate6,receivingDate6,marine,custom);
        customer2.cart(consignment7);
        customer2.cart(consignment8);
        customer2.cart(consignment9);
        customer3.cart(consignment10);
        customer3.cart(consignment11);
        customer4.cart(consignment12);

        Menu.showMainMenu();




































    }
}
