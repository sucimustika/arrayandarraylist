# 🏦 Simulasi Sistem Perbankan Sederhana (Java OOP)

Proyek ini adalah simulasi sistem perbankan sederhana berbasis **Pemrograman Berorientasi Objek (PBO)** menggunakan bahasa Java. Fokus utama proyek ini adalah menunjukkan perbedaan implementasi **Array biasa** (`Customer[]`) pada kelas `Bank` dan **ArrayList** (`ArrayList<Account>`) pada kelas `Customer`.

---

## 👤 Identitas

| Keterangan | Data |
|---|---|
| **Nama** | `[ISI NAMA LENGKAP ANDA]` |
| **NIM** | `[ISI NIM ANDA]` |
| **Kelas** | `[ISI KELAS ANDA]` |
| **Program Studi** | `[ISI PROGRAM STUDI]` |
| **Mata Kuliah** | Pemrograman Berorientasi Objek (PBO) |
| **Universitas** | `[ISI NAMA UNIVERSITAS]` |

---

## 📁 Struktur Proyek

```
pboBank/
├── Account.java      # Kelas rekening (saldo, setor, tarik)
├── Customer.java     # Kelas nasabah (menyimpan akun dengan ArrayList)
├── Bank.java         # Kelas bank (menyimpan nasabah dengan Array biasa)
├── Main.java         # Kelas utama untuk simulasi transaksi
├── *.class           # Hasil kompilasi
├── Screenshot__194_.png   # Hasil output bagian 1
└── Screenshot__195_.png   # Hasil output bagian 2
```

---

## 🧩 Deskripsi Kelas

| Kelas | Fungsi | Struktur Data |
|---|---|---|
| `Account` | Menyimpan saldo; menyediakan `deposit()`, `withdraw()`, `getBalance()` | `double balance` |
| `Customer` | Menyimpan nama nasabah dan daftar akun miliknya | **`ArrayList<Account>`** |
| `Bank` | Menyimpan seluruh nasabah bank | **`Customer[]` (Array biasa)** |
| `Main` | Menjalankan simulasi: tambah nasabah, buat akun, transaksi, tampilkan saldo | - |

### Relasi Antar Kelas

```
Bank  ──(1 : banyak, Array)──►  Customer  ──(1 : banyak, ArrayList)──►  Account
```

---

## 📌 Implementasi Array (pada `Bank.java`)

Kelas `Bank` menggunakan **Array biasa** untuk menyimpan data nasabah.

```java
private Customer[] customers;     // deklarasi array
private int numberOfCustomers;    // penghitung jumlah elemen yang terisi

public Bank() {
    this.customers = new Customer[10];  // kapasitas tetap: 10 nasabah
    this.numberOfCustomers = 0;
}
```

### Menambah data

```java
public void addCustomer(String f, String l) {
    if (numberOfCustomers < customers.length) {
        customers[numberOfCustomers] = new Customer(f, l);
        numberOfCustomers++;
    } else {
        System.out.println("Kapasitas bank penuh, tidak bisa menambah nasabah!");
    }
}
```

### Mengambil data

```java
public Customer getCustomer(int index) {
    if (index >= 0 && index < numberOfCustomers) {
        return customers[index];
    }
    return null;
}
```

### Karakteristik Array pada proyek ini

- **Ukuran tetap**: kapasitas ditentukan saat dibuat (`new Customer[10]`) dan tidak bisa bertambah otomatis.
- **Harus dicek manual** apakah array masih ada ruang (`numberOfCustomers < customers.length`).
- Memerlukan **variabel penghitung** (`numberOfCustomers`) untuk mengetahui jumlah elemen yang benar-benar terisi, karena `customers.length` hanya menunjukkan kapasitas.
- Akses elemen cepat menggunakan indeks (`customers[i]`).

---

## 📌 Implementasi ArrayList (pada `Customer.java`)

Kelas `Customer` menggunakan **ArrayList** untuk menyimpan akun (rekening) milik nasabah, karena jumlah akun tiap nasabah bisa berbeda-beda dan bertambah.

```java
import java.util.ArrayList;

private ArrayList<Account> accounts;

public Customer(String f, String l) {
    this.firstName = f;
    this.lastName = l;
    this.accounts = new ArrayList<Account>();  // tanpa menentukan ukuran
}
```

### Menambah data

```java
public void setAccount(Account acct) {
    accounts.add(acct);   // ukuran bertambah otomatis
}
```

### Mengambil data & jumlah elemen

```java
public Account getAccount(int index) {
    if (index >= 0 && index < accounts.size()) {
        return accounts.get(index);
    }
    return null;
}

public int getNumOfAccounts() {
    return accounts.size();   // tidak perlu variabel penghitung
}
```

### Karakteristik ArrayList pada proyek ini

- **Ukuran dinamis**: otomatis membesar saat `add()` dipanggil.
- **Tidak perlu penghitung manual**: cukup gunakan `size()`.
- Menggunakan **method bawaan** (`add()`, `get()`, `size()`) sehingga kode lebih ringkas.
- Memakai **generics** (`ArrayList<Account>`) agar hanya objek `Account` yang bisa disimpan.

---

## ⚖️ Perbandingan Array vs ArrayList

| Aspek | Array (`Customer[]` di `Bank`) | ArrayList (`ArrayList<Account>` di `Customer`) |
|---|---|---|
| Ukuran | Tetap (10) | Dinamis |
| Menambah elemen | `customers[n] = ...; n++` | `accounts.add(...)` |
| Mengambil elemen | `customers[i]` | `accounts.get(i)` |
| Jumlah elemen | Variabel `numberOfCustomers` | `accounts.size()` |
| Cek kapasitas | Manual | Tidak diperlukan |
| Paket | Bawaan bahasa Java | `java.util.ArrayList` |

---

## ▶️ Cara Menjalankan

**Prasyarat:** JDK (Java Development Kit) sudah terpasang.

```bash
# 1. Clone repository
git clone https://github.com/<username>/<nama-repository>.git
cd <nama-repository>

# 2. Kompilasi semua file
javac Account.java Customer.java Bank.java Main.java

# 3. Jalankan program
java Main
```

---

## 🧪 Skenario Simulasi (`Main.java`)

**Data awal**

| Nasabah | Akun #1 | Akun #2 |
|---|---|---|
| Suci Mustika | Rp 1.000.000 | Rp 500.000 |
| Gunanata Panji | Rp 2.500.000 | Rp 7.500.000 |

**Transaksi**

| Nasabah | Transaksi |
|---|---|
| Suci Mustika | Setor Rp 300.000 ke Akun #1 |
| Suci Mustika | Tarik Rp 100.000 dari Akun #2 |
| Gunanata Panji | Menabung Rp 1.000.000 ke Akun #1 |
| Gunanata Panji | Tarik Rp 500.000 dari Akun #2 |

**Hasil akhir**

| Nasabah | Akun #1 | Akun #2 | Total |
|---|---|---|---|
| Suci Mustika | Rp 1.300.000 | Rp 400.000 | Rp 1.700.000 |
| Gunanata Panji | Rp 3.500.000 | Rp 7.000.000 | Rp 10.500.000 |

---

## 📸 Hasil Output Program

### Status Keuangan Awal & Proses Transaksi

![Hasil Output 1 - Status Awal dan Transaksi](Screenshot__194_.png)

### Status Keuangan Akhir

![Hasil Output 2 - Status Akhir](Screenshot__195_.png)

> **Catatan:** Total saldo tampil sebagai `1.0E7` dan `1.05E7` karena tipe `double` pada Java otomatis memakai notasi ilmiah untuk angka besar. Nilainya sama dengan `10.000.000` dan `10.500.000`. Untuk menampilkan format biasa, gunakan `System.out.printf("%.0f", totalSaldo)` atau `String.format`.

---

## 🛠️ Teknologi

- Java (JDK 8 atau lebih baru)
- Konsep OOP: Class, Object, Encapsulation (`private` + getter/setter), Composition
- Struktur data: Array & ArrayList

---

## 📄 Lisensi

Proyek ini dibuat untuk keperluan pembelajaran mata kuliah Pemrograman Berorientasi Objek.

---

<p align="center">Dibuat oleh <b>[NAMA ANDA]</b> – <b>[NIM ANDA]</b></p>
