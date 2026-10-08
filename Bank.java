public class Bank {
    private Customer[] customers; // Menggunakan Array Biasa (Customer[])
    private int numberOfCustomers; // Menghitung indeks/jumlah elemen di Array

    public Bank() {
        this.customers = new Customer[10]; // Inisialisasi kapasitas Array (misal: 10 nasabah)
        this.numberOfCustomers = 0;
    }

    public void addCustomer(String f, String l) {
        if (numberOfCustomers < customers.length) {
            customers[numberOfCustomers] = new Customer(f, l);
            numberOfCustomers++;
        } else {
            System.out.println("Kapasitas bank penuh, tidak bisa menambah nasabah!");
        }
    }

    public int getNumOfCustomers() {
        return numberOfCustomers;
    }

    public Customer getCustomer(int index) {
        if (index >= 0 && index < numberOfCustomers) {
            return customers[index]; // Mengambil dari Array biasa
        }
        return null;
    }
}