import java.util.HashMap;
import java.util.Map;

public class CreditScoringSystem {

    private Map<String, Customer> customers;

    public CreditScoringSystem() {
        customers = new HashMap<>();
    }

    public void addCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    public int calculateCreditScore(String customerId) {
        Customer customer = customers.get(customerId);
        if (customer == null) {
            throw new IllegalArgumentException("Customer not found.");
        }

        int score = 0;

        // Example scoring logic (you'll need to customize this)
        score += calculateAgeScore(customer.getAge());
        score += calculateIncomeScore(customer.getAnnualIncome());
        score += calculateEmploymentScore(customer.getEmploymentStatus());
        score += calculateCreditHistoryScore(customer.getCreditHistory()); // Example: Credit score or history length

        return score;
    }

    private int calculateAgeScore(int age) {
        if (age >= 18 && age <= 25) {
            return 10;
        } else if (age > 25 && age <= 40) {
            return 20;
        } else if (age > 40 && age <= 60) {
            return 15;
        } else if(age > 60){
            return 5;
        }else {
            return 0; // Or handle invalid age
        }
    }

    private int calculateIncomeScore(double annualIncome) {
        if (annualIncome < 30000) {
            return 5;
        } else if (annualIncome >= 30000 && annualIncome < 60000) {
            return 15;
        } else if (annualIncome >= 60000) {
            return 25;
        } else {
            return 0; // Or handle invalid income
        }
    }

    private int calculateEmploymentScore(String employmentStatus) {
        if (employmentStatus.equalsIgnoreCase("Employed")) {
            return 20;
        } else if (employmentStatus.equalsIgnoreCase("Self-Employed")) {
            return 15;
        } else if (employmentStatus.equalsIgnoreCase("Unemployed")) {
            return 5;
        } else {
            return 0; // Or handle other statuses
        }
    }

    private int calculateCreditHistoryScore(int creditHistory) { // Example: Using a credit score or history length
        if (creditHistory > 700) {
            return 30;
        } else if (creditHistory > 600 && creditHistory <= 700) {
            return 20;
        } else if (creditHistory > 500 && creditHistory <= 600) {
            return 10;
        } else {
            return 0;
        }
    }


    public static void main(String args) {
        CreditScoringSystem system = new CreditScoringSystem();

        Customer customer1 = new Customer("123", 30, 50000, "Employed", 680);
        Customer customer2 = new Customer("456", 22, 25000, "Unemployed", 550);
        system.addCustomer(customer1);
        system.addCustomer(customer2);

        int score1 = system.calculateCreditScore("123");
        int score2 = system.calculateCreditScore("456");

        System.out.println("Customer 1 Score: " + score1);
        System.out.println("Customer 2 Score: " + score2);

    }
}


class Customer {
    private String id;
    private int age;
    private double annualIncome;
    private String employmentStatus;
    private int creditHistory; // Could be a credit score or length of credit history

    public Customer(String id, int age, double annualIncome, String employmentStatus, int creditHistory) {
        this.id = id;
        this.age = age;
        this.annualIncome = annualIncome;
        this.employmentStatus = employmentStatus;
        this.creditHistory = creditHistory;
    }

    // Getters (and potentially setters if needed)
    public String getId() { return id;}
    public int getAge() { return age;}
    public double getAnnualIncome() { return annualIncome;}
    public String getEmploymentStatus() { return employmentStatus;}
    public int getCreditHistory() { return creditHistory;}


}
