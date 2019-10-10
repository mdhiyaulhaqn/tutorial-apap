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
- 

## Tutorial 3
### What I have learned today
Saya telah belajar bagaimana membuat sebuah aplikasi web dengan menggunakan database mysql dengan menggunakan pendekatan Object Relational Mapping (ORM) memakai JPA.

1. Pada class MenuDb, terdapat method findByRestoranIdRestoran , apakah kegunaan dari
method tersebut?
Keguanaannya adalah untuk mendapatkan list yang berisikan semua menu yang ada pada suatu restoran.

2. Pada class RestoranController, jelaskan perbedaan method addRestoranFormPage dan
addRestoranSubmit?
method addRestoranFormPage berfungsi untuk me-render form add restoran serta membuat objek baru yang akan 'dioper' ke file html.
Sedangkan, method addRestoranSubmit berfungsi untuk mendapatkan objek dari html serta menyimpannya kedalam database. Selain itu method ini untuk me-render halaman jika restoran berhasil ditambahkan.

3. Jelaskan apa kegunaan dari JPA Repository?
Modul JPA dari Spring Data berisi namespace kustom yang memungkinkan mendefinisikan repositori beans. JPA berfungsi untuk mengubah Java object ke relational database. Sehingga memungkinkan kita dalam menambah, update, dan delete di database dengan menggunakan java.

4. Sebutkan dan jelaskan di bagian kode mana sebuah relasi antara RestoranModel dan
MenuModel dibuat?
Pada class RestoranModel terdapat List yang berisi menu dan diberikan anotasi @OneToMany. Sehingga dibuatlah relasi OneToMany antara restoran dengan menu

5. Jelaskan kegunaan FetchType.LAZY , CascadeType.ALL , dan FetchType.EAGER
- FetchType.LAZY : fetching atau pengambilan data dari database hanya saat dibutuhkan/saat user mengakses methodnya
- CascadeType.ALL : melakukan cascade (mempengaruhi entitas terkait) ketika dilakukan REMOVE, MERGE, dan lain sebagainya
- FetchType.EAGER : fetching atau pengambilan data dari database dilakukan ketika aplikasi dijalankan

### What I did not understand
(tuliskan apa saja yang kurang Anda mengerti, Anda dapat men-_check_ apabila Anda sudah mengerti
dikemudian hari, dan tambahkan tulisan yang membuat Anda mengerti)
- [ ] Kapan suatu logic code lebih baik dilakukan di controller dan kapan di service


## Tutorial 4
### What I have learned today
Saya telah mempelajari bagaimana membuat presentation layer dari suatu web dengan menggunakan salah satu Java Library, yaitu Thymeleaf.

1. Jelaskan yang anda pelajari dari melakukan latihan nomor 2, dan jelaskan tahapan bagaimana
anda menyelesaikan latihan nomor 2
Untuk membuat agar Navigation bar dinamis mengikuti title dari setiap html, saya menambahkan attribute pada model bernama titleTab. Pada setiap fungsi di controller, akan ditambahkan nama title ke key 'titleTab', lalu 'titleTab' akan dipanggil di 'fragment.html' bagian tag navbar

2. Jelaskan yang anda pelajari dari latihan nomor 3, dan jelaskan tahapan bagaimana anda
menyelesaikan latihan nomor 3
- Pada menuController, saya membuat 4 fungsi. 2 untuk form dan submit, 1 untuk add row, dan 1 lagi untuk delete row
- Pada fungsi add(..) saya membuat object restoran dan list menu untuk nantinya digunakan dalam menyimpan data form
- pada fungsi addMenuSubmit(..) saya mengambil semua object menu lalu diset restorannya sesuai dengan id
- pada fungsi addRow() saya menambah object menu dan memasukkannya kedalam list
- pada fungsi addRow() saya mengurangi object menu dari list
- pada form-add-menu.html saya mengambil object dari fungsi di controller yang telah dibuat. Lalu saya melakukan loop pada listMenu sehingga terdapat sebanya n baris form. Untuk memasukkan data form ke dalam masing-masing object saya menggunakan th:field sesuai dengan indexnya.

3. Jelaskan perbedaan th:include dan th:replace
th:include = Mengambil isi dari fragment yang dituju tanpa menghilangkan yang memanggil
th.replace = Mengambil isi dari fragment yang dituju dan me-replace tag yang memanggilnya

4. Jelaskan bagaimana penggunaan th:object beserta tujuannya
Penggunaannya adalah pada suatu tag (misal tag form), ditulis 'th:model="${namaObject}".
Object ini diinisiasi di controller lalu dilempar ke html. Untuk selanjutnya attribute object tersebut diisi oleh isi dari form. Selanjutnya object ini akan dilempar ke controller dan dimasukkan ke dalam database.

### What I did not understand
- [ ] fungsi sebenarnya "name" pada tag input


## Tutorial 5
### What I have learned today
Pada tutorial kali ini, saya mempelajari membuat unit test untuk service dan controller pada framework Spring (dengan arsitektur MVC). Selain itu juga saya mengetahui cara melihat code coverage dengan menggunakan fitur dari maven.

1. Jelaskan bagian mana saja dari test yang dibuat pada latihan no 2 adalah given, when, dan and
then.
Bagian given adalah mulai dari inisiasi restoran dengan pemanggilan constructor, melakukan set attribut restoran, dan sampai when. Sedangkan when adalah ketika pemanggilan mockMvc.perform(get("/restoran/view?idRestoran=1")). Serta bagian and then adalah ketika pemanggilan method andExpect().

2. Jelaskan perbedaan line coverage dan logic coverage.
Line coverage   Logic coverage memastikan bahwa tes tidak hanya mencapai line tertentu, tetapi beberapa kondisi juga tercover dengan mencoba beberapa kombinasi (sehingga seperti if else bisa tercover). 

3. Pada keadaan ideal, apa yang seharusnya dibuat terlebih dahulu, code atau unit test ? Mengapa
seperti itu? Apa akibatnya jika urutannya dibalik, adakah risiko tak terlihat yang mungkin
terjadi?
Pada keadaan ideal, seharusnya unit test dibuat terlebih dahulu. Karena unit test berfungsi agar programmer membuat program sesuai dengan kebutuhan user/yang diharapkan dan juga mengurangi kemungkinan terjadinya error. Jika urutannya dibalik, maka progoram yang dibuat bisa tidak sesuai harapan dan kemungkinan terjadinya error menjadi tinggi, serta tentunya akan memakan waktu lebih banyak.

4. [Bonus] Jelaskan mengapa pada latihan no 3, main class spring tidak diikutsertakan ke dalam
perhitungan coverage? Apa saja yang dapat menyebabkan suatu class dapat di- exclude dari
perhitungan code coverage.
Karena, main class spring bukan code yang dibuat programmer untuk membuat suatu fitur. Melainkan memang harus ada ketika pada suatu project agar program bisa jalan (built-in). Sehingga, jika main class spring tetap di-include dapat mengurangi persentase coverage, padahal file tersebut tidak dibuat atau dikontrol.

#### Screenshot Coverage
##### Latihan 1
###### Sebelum
![sebelum menu service](/images/screenshot-tutorial-5/menu_service_sebelum.PNG)
###### Sesudah
![sesudah menu service](/images/screenshot-tutorial-5/menu_service_sesudah.PNG)
    
##### Latihan 2
###### Sebelum
![sebelum restoran controller](/images/screenshot-tutorial-5/restoran_controller_sebelum.PNG)
###### Sesudah
![sesudah restoran controller](/images/screenshot-tutorial-5/restoran_controller_sesudah.PNG)

### What I did not understand
- [ ] Apa yang terjadi jika when yang sama ada 2 namun and then berbeda. Seperti yang satu thenReturn, satu lagi thenThrow