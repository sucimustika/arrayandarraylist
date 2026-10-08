public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // 1. Tambah Nasabah Pertama (Suci Mustika)
        bank.addCustomer("Suci", "Mustika");
        Customer nasabah1 = bank.getCustomer(0);
        nasabah1.setAccount(new Account(1000000.0)); // Akun #1
        nasabah1.setAccount(new Account(500000.0));  // Akun #2

        // 2. Tambah Nasabah Kedua (Gunanata Panji)
        bank.addCustomer("Gunanata", "Panji");
        Customer nasabah2 = bank.getCustomer(1);
        nasabah2.setAccount(new Account(2500000.0)); // Akun #1
        nasabah2.setAccount(new Account(7500000.0)); // Akun #2

        // Tampilkan Kondisi Awal
        System.out.println("==========================================");
        System.out.println("          STATUS KEUANGAN AWAL            ");
        System.out.println("==========================================");
        tampilkanInfoNasabah(nasabah1);
        tampilkanInfoNasabah(nasabah2);

        // Simulasi Transaksi
        System.out.println("\n==========================================");
        System.out.println("           PROSES TRANSAKSI               ");
        System.out.println("==========================================");

        // Transaksi Nasabah 1 (Suci Mustika)
        System.out.println("\n>>> [Suci Mustika] Setor Rp 300.000 ke Akun #1");
        nasabah1.getAccount(0).deposit(300000.0);

        System.out.println(">>> [Suci Mustika] Tarik Rp 100.000 dari Akun #2");
        nasabah1.getAccount(1).withdraw(100000.0);

        // Transaksi Nasabah 2 (Gunanata Panji)
        System.out.println(">>> [Gunanata Panji] Menabung Rp 1.000.000 ke Akun #1");
        nasabah2.getAccount(0).deposit(1000000.0);

        System.out.println(">>> [Gunanata Panji] Tarik Rp 500.000 dari Akun #2");
        nasabah2.getAccount(1).withdraw(500000.0);

        // Tampilkan Kondisi Akhir
        System.out.println("\n==========================================");
        System.out.println("          STATUS KEUANGAN AKHIR           ");
        System.out.println("==========================================");
        
        System.out.println("Total Nasabah di Bank (Array): " + bank.getNumOfCustomers());
        System.out.println();
        
        for (int i = 0; i < bank.getNumOfCustomers(); i++) {
            tampilkanInfoNasabah(bank.getCustomer(i));
        }
    }

    public static void tampilkanInfoNasabah(Customer nasabah) {
        System.out.println("------------------------------------------");
        System.out.println("Nama Nasabah : " + nasabah.getFirstName() + " " + nasabah.getLastName());
        System.out.println("Jumlah Akun  : " + nasabah.getNumOfAccounts());
        
        double totalSaldo = 0;
        for (int i = 0; i < nasabah.getNumOfAccounts(); i++) {
            Account akun = nasabah.getAccount(i);
            System.out.println("  > Akun #" + (i + 1) + " Saldo: Rp " + akun.getBalance());
            totalSaldo += akun.getBalance();
        }
        System.out.println("Total Saldo Keseluruhan: Rp " + totalSaldo);
        System.out.println("------------------------------------------");
    }
}