# Panduan Pengguna untuk Aplikasi (SALT - Test - Adi Munawar)

Panduan ini akan membantu Anda mengkloning repositori, menjalankan aplikasi Spring Boot dengan JDBC PostgreSQL di lingkungan lokal Anda, dan memberikan panduan singkat tentang cara mendeploynya di lingkungan produksi.

## Langkah 1: Clone Repositori

1. **Clone Repositori**: Buka terminal atau command prompt, dan jalankan perintah berikut untuk mengkloning repositori proyek:

    ```bash
    https://github.com/AdiMunawar31/adimunawar-test-salt.git
    ```

    kemudiain masuk ke folder server :
    ```bash
    cd server
    ```

## Langkah 2: Persiapan Database PostgreSQL

1. **Buat Database**: Pastikan Anda memiliki PostgreSQL terinstal di lingkungan lokal Anda. Buatlah database yang akan digunakan oleh aplikasi.

2. **Konfigurasi Database**: Buka file `application.properties` dalam proyek Anda. Isi properti database seperti `spring.datasource.url`, `spring.datasource.username`, dan `spring.datasource.password` dengan nilai yang sesuai.

## Langkah 3: Menjalankan Aplikasi

1. **Menjalankan Aplikasi**: Di terminal, masuk ke direktori proyek yang baru saja Anda kloning. Jalankan perintah berikut untuk menjalankan aplikasi Spring Boot:

    ```bash
    mvn spring-boot:run
    ```

2. **Akses Aplikasi**: Buka browser web Anda dan akses aplikasi melalui URL `http://localhost:8080` atau URL yang sesuai sesuai dengan konfigurasi Anda.

## Langkah 4: Uji Aplikasi

1. **Uji Aplikasi**: Anda sekarang dapat menguji aplikasi dengan menjalankan permintaan HTTP ke endpoint yang telah Anda definisikan dalam aplikasi. Pastikan aplikasi berjalan dengan baik dan dapat mengakses data dari database PostgreSQL Anda.

## Langkah 5: Mendeploy Aplikasi (Opsional)

Jika Anda ingin mendeploy aplikasi ini di lingkungan produksi, ikuti langkah-langkah berikut:

1. **Pilih Platform Deployment**: Pilih platform hosting sesuai kebutuhan Anda, seperti Amazon Web Services (AWS), Google Cloud Platform (GCP), Microsoft Azure, atau penyedia hosting lainnya.

2. **Konfigurasi Server**: Siapkan server yang sesuai dengan persyaratan aplikasi Anda. Pastikan server memiliki perangkat lunak dan dependensi yang dibutuhkan.

3. **Konfigurasi Server Web (Opsional)**: Jika diperlukan, konfigurasikan server web seperti Nginx atau Apache sebagai penampung aplikasi Anda.

4. **Build Aplikasi**: Jalankan perintah `mvn clean package` untuk membuat paket aplikasi (JAR atau WAR).

5. **Deploy Aplikasi**: Unggah paket aplikasi ke server Anda dan jalankan aplikasi menggunakan perintah yang sesuai.

6. **Konfigurasi Database (Opsional)**: Sesuaikan konfigurasi database di server produksi dengan properti `application.properties` yang sesuai.

7. **Pemeliharaan Rutin**: Atur pemeliharaan rutin untuk memastikan aplikasi berjalan dengan baik di lingkungan produksi.


Ini adalah panduan lengkap tentang cara mengkloning, menjalankan, dan mendeploy aplikasi Spring Boot dengan JDBC PostgreSQL. Ikuti langkah-langkah ini sesuai kebutuhan Anda dan pastikan untuk merinci dokumentasi, tugas, dan rencana pengembangan sesuai dengan proyek Anda.
