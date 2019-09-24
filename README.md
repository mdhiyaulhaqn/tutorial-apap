# Tutorial APAP

## Authors

* **Muhammad Dhiyaulhaq Nugraha** - *1706043525* - *C*

## Tutorial 1
### What I have learned today
Saya telah belajar bagaimana menggunakan git dengan github. Selain itu saya juga belajar bagaimana membuat project sederhana menggunakan Spring.

#### Github
1. Apa itu Issue Tracker? Masalah apa yang dapat diselesaikan dengan Issue Tracker?
Issue Tracker dapat digunakan untuk kita mencatat task, enhancements (peningkatan) dan bug yang ada pada project kita. Sehingga kita dapat lebih mudah mengerjakannya dan tidak ada isu yang terlewat
2. Apa perbedaan dari git merge dan merge --squash?
File yang digabungkan antara menggunakan 'merge' dengan 'merge --squash' tidak berbeda. Namun commit metadata berubah dengan hanya menampilkan parent commit.

#### Spring
3. Apa itu library & dependency?
Library adalah koleksi code yang telah dibuat sebelumnya untuk digunakan untuk mempermudah programmer lain.
Dependency istilah software engineer yang digunakan untuk merujuk ketika sepotong program bergantung pada program yang lain.
4. Apa itu Maven? Mengapa kita perlu menggunakan Maven?
Maven adalah Java Build Tools yang menggunakan konsep POM (Project Object Model). Salah satu keuntungan menggunakan Maven adalah Maven membuat struktur project sendiri, sehingga project tersebut akan dapat dibuka dengan berbagai IDE dikarenakan Maven mendefinisikan projectnya sendiri. Karena Maven powerful untuk membuat project, dependency,  dan dokumentasi.
5. Apa alternatif dari Maven?
Sebagai alternatif dari Maven, kita bisa menggunakan Gradle.

### What I did not understand
(tuliskan apa saja yang kurang Anda mengerti, Anda dapat men-_check_ apabila Anda sudah mengerti
dikemudian hari, dan tambahkan tulisan yang membuat Anda mengerti)
- [ ] Kenapa saya harus menggunakan Spring dalam pembuatan web?
- [ ] Apa perbedaan github dengan gitlab?# Tutorial APAP


## Tutorial 2
### What I have learned today
Saya telah belajar bagaimana membuat fitur dan method serta menggunakan service untuk menyimpan dan mengolah data. Termasuk add, update, dan delete data.

#### Github
1. Cobalah untuk menambahkan sebuah restoran dengan mengakses link http://localhost:8080/restoran/add?idRestoran=1&nama=PanyuFC&alamat=Kantin%200Fasilkom&nomorTelepon=14022 Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.
Yang terjadi adalah error. Karena belum ada view add-restoran / add-restoran.html

2. Cobalah untuk menambahkan sebuah restoran dengan mengakses link berikut: http://localhost:8080/restoran/add?idRestoran=2&nama=KentukuFC&alamat=Kantin
%20FIK. Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.
Yang terjadi adalah error, karena tidak ada nomorTelepon di link tersebut. padahal kita men-state nomorTelepon itu required (wajib)

3. Jika Papa APAP ingin melihat restoran PanyuFC , link apa yang harus
diakses?
http://localhost:8080/restoran/view?idRestoran=1

4. Tambahkan 1 contoh restoran lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/restoran/viewall , apa yang akan ditampilkan? Sertakan juga bukti screenshot mu.
Yang ditampilkan adalah seluruh data restoran yang pernah di add.
![menambah restoran baru](/images/screenshot-tutorial-2/1.png "add restoran baru")
![membuka link viewall](/images/screenshot-tutorial-2/2.png "view all")

### What I did not understand
(tuliskan apa saja yang kurang Anda mengerti, Anda dapat men-_check_ apabila Anda sudah mengerti
dikemudian hari, dan tambahkan tulisan yang membuat Anda mengerti)
- [ ] Fungsi dari @autowired