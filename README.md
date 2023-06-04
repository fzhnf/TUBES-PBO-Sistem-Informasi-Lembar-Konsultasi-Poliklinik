# TUBES-PBO-Sistem-Informasi-Lembar-Konsultasi-Poliklinik
* [x] uml
- [ ] routine activity
* [ ] business rules
* [ ] database
* [ ] testing
* [ ] final product 
* [ ] final presentation

# proses lembar konsultasi dalam aplikasi web e-MRs

terdapat beberapa bagian yang dipecah berdasarkan tiap halaman yang dilalui oleh dokter atau asisten dokter ketika mengerjakan assessment lembar konsultasi, dan melihat sejarah lembar konsultasi, dari bagian tersebut dimulai dari:

## login
berisi authentication langsung dari pihak rumah sakit saja, tanpa ada register.

username: s String @Unique
password: String

action dari dokter : isi username dan password

## homepage
setiap halaman memiliki sidebar yaitu:
- daftar pasien
- radiologi
- obat
- assesmen awal
- cppt dokter
- konsultasi/raber
- alih dpjp
- prmrj
- ekg
- dll

action dari dokter: pencet daftar pasien

## halaman daftar pasien
memiliki dua tabel besar terpisah yang satu berisi daftar assesmen (lembar konsultasi) dan satunya tabel sejarah konsultasi (lembar konsultasi).

keduanya dengan format tabel seperti berikut:
| no | tanggal perawat assesmen |  No MR | No Registrasi | Nama | Jenis Kelamin | Tanggal Lahir  | Klinik | Action |
|--|--|--|--|--|--|--|--|--|
int| dd-mm-yyyy | id | id | String | Char | dd-mm-yyyy | String | CPPT / edit / batal




lembar konsultasi di input hanya dari admin, lalu jika dokter telah mengubah (mengisi) lembar terebut pada tabel assesmen, maka lembar tersebut akan berpindah ke tabel konsultasi.

action dari dokter: 
- menyelesaikan assesmen
- melihat daftar konsultasi



## halaman lembar konsultasi

berupa kumpulan data, yang berisikan:
* hasil scan berkas
* assesmen awal keperawatan rawat jalan
* riwayat cppt: BLOB
>BLOB (objek besar biner) akan memungkinkan Anda untuk menyimpan file biner seperti file DOC, file yang dapat dieksekusi, dan file PDF.
>Lembar CPPT terdiri dari 5 kolom, yaitu:
>1. Tgl/jam
>2. Profesi/bagian
>3. Hasil pemeriksaan, analisa, rencana dan penatalaksanaan pasien
>4. Instruksi nakes termasuk pasca bedah/prosedur
>5. Verifikasi dari Dokter Penanggung Jawab Pelayanan DPJP


* lembar konsultasi:
  1. format penomoran Rekaman Medis
  2. String
  3. dd-mm-yyyy
* tgl masuk: dd-MM-yyyy jam: ss-mm-hh <\time code>
* rencana Tindakan: tidak ada / penanganan lebih lanjut
* keterangan: berisi informasi terkait rencana tindakan yang ingin dilakukan
* keluhan: berisikan keluhan yang disampaikan oleh pasien ke dokter
* riwayat penyakit sekarang: berisi penyakit terkini sedang dimiliki pasien
* kedaan umum radio button \[baik / tampak sakit / sesak / pucat / lemah / kejang / lainnya]
* suhu: input integer \[celcius]
* tekanan darah : input integer \[mmhg]
* nadi: input integer \[x / mnt]
* nafas: input integer \[x / mnt]
* berat badan:input integer \[kg]
* tinggi badan:input integer \[cm]
* lila(linkar lengan atas): integer [] 
* status lokalis(?): deskripsi lokasi dan keadaan dari daerah badan yang sakit
* gambar status lokalis: gambar x ray atau daerah penyakit
tinggal ambil gambar
* Status Psikiatrikus: radio button \[ya/tidak]
* hasil pemeriksaan laboratorium: pemeriksaan laboratorium
* hasil pemeriksaan radiologi: pemeriksaan radiologi
* riwayat pemberian obat: riwayat obat \[farmasi]
* riwayat pemeriksaan EKG: pemeriksaan EKG (jantung)

* ICD 10 (primary): drop down berupa pilihan penyakit yang termasuk ICD 10
* ICD 10 (sekunder): string
* Diagnosis: String.txt
* ICD 9 (sekunder): drop down berupa pilihan tindakan, operasi jantung, operasi usus, sunat dll 
* prosedur, check lab
>**Klasifikasi Penyakit Internasional** ([bahasa Inggris](https://id.wikipedia.org/wiki/Bahasa_Inggris "Bahasa Inggris"): _International Classification of Diseases_, disingkat **ICD**) adalah suatu sistem klasifikasi [penyakit](https://id.wikipedia.org/wiki/Penyakit "Penyakit") yang dikelola oleh [Organisasi Kesehatan Dunia](https://id.wikipedia.org/wiki/Organisasi_Kesehatan_Dunia "Organisasi Kesehatan Dunia") (WHO) dan digunakan secara global. ICD dirancang sebagai sistem klasifikasi kesehatan yang memiliki kode diagnostik untuk mengelompokkan penyakit, yang meliputi berbagai tanda, gejala, temuan abnormal, keluhan, kondisi sosial, dan penyebab eksternal suatu cedera atau penyakit. Setiap kondisi kesehatan dipetakan dan diberikan kategori dan kode.
>ICD direvisi secara berkala dan revisi yang berlaku saat ini adalah revisi ke-10, yang disebut ICD-10. WHO pertama kali merilis ICD pada tahun 1992 dan kemudian menerbitkan pembaruan kecil setiap tahun serta pembaruan besar setiap tiga tahun. Revisi kesebelas ICD, yaitu ICD-11, diterima oleh [Majelis Kesehatan Dunia](https://id.wikipedia.org/wiki/Majelis_Kesehatan_Dunia "Majelis Kesehatan Dunia") dari WHO pada 25 Mei 2019 dan akan berlaku secara resmi pada 1 Januari 2022.[[1]](https://id.wikipedia.org/wiki/Klasifikasi_Penyakit_Internasional#cite_note-1) Nama lengkap dan formal dari ICD yaitu _**International Statistical Classification of Diseases and Related Health Problems.**_
>ICD-9 dipublikasikan oleh [WHO](https://id.wikipedia.org/wiki/WHO "WHO") pada tahun 1975. Beberapa waktu kemudian, [Pusat Statistik Kesehatan Nasional](https://id.wikipedia.org/w/index.php?title=Pusat_Statistik_Kesehatan_Nasional&action=edit&redlink=1 "Pusat Statistik Kesehatan Nasional (halaman belum tersedia)") (NCHS) [Amerika Serikat](https://id.wikipedia.org/wiki/Amerika_Serikat "Amerika Serikat") mengembangkan sistem ini dan menyebutnya sebagai "ICD-9-CM". Penambahan CM merujuk pada modifikasi klinis (_clinical modification_).[[2]](https://id.wikipedia.org/wiki/Klasifikasi_Penyakit_Internasional#cite_note-2)
>ICD-10
>Artikel utama: [Daftar kode ICD-10](https://id.wikipedia.org/wiki/Daftar_kode_ICD-10 "Daftar kode ICD-10")
>ICD-10 mulai dikerjakan pada tahun 1983 dan disahkan oleh Majelis Kesehatan Dunia ke-43 pada Mei 1990. Versi ini mulai digunakan di negara-negara anggota WHO pada tahun 1994. Sistem klasifikasi ICD-10 memuat lebih dari 55.000 kode, meningkat signifikan dibandingkan 17.000 kode yang tersedia dalam ICD-9.[[3]](https://id.wikipedia.org/wiki/Klasifikasi_Penyakit_Internasional#cite_note-3)

* diagnosis banding: String (kemungkinan apa aja yang perlu diperhatikan ulang)
* permintaan laboratorium: kategori input pemeriksaan lab, patologi klinik, hematologi, dll, misal covid, rapid test, 
* hematologi, 
* hepatitis
* darah, urine, 
* patologi anatomi:
* dijelaskan tentang penyakit nya
* keterangan 
* permintaan radiologi: warning sign yes or no? input pemeriksaan radiologi
* permintaan obat: String.txt
  1. \[boolean]: apakah ada obat tersebut racikan
* instruksi: perlu rawat inap, dibalut,
* pulang, kontrol rawat inap, konsultasikan, selesai
misal pencet konsultasi dokter

nanti akan keluar daftar dokter, nanti kita milih


kalau misalnya klinik kita mencetnya apa

daftar klinik

kliniknya dipencet

jenis konsultasi
persutujuan operasi 

penanganan lebih lajut

advice

gizi
analisis asupan makanan

review ditulis: kesimpulannya apa
* Saran: String:: dari dokter kepada pihak rumah sakit
* Kesimpulan: String:: dari dokter kepada pihak rumah sakit
* tombol simpan: save lembar konsultasi ke database eMR, harus diisi semua


action dari dokter: mengisi semua data dari lembar konsultasi serta menyimpan ke dalam database


blok sebelah atas, tik 123 tenntang pasien yang masuk, tentang pasien yang sudah dikerjakan ada konsultasi ulang 1 


## konklusi:
dokter membuat lembar konsultasi pada aplikasi web eMRs, dari assesmen yang diberikan pihak rumah sakit dengan permintaan dari pasien, lembar konsultasi dibuat setelah pasien berkunjung kepada dokter, semisal dokter anak di polianak dengan keluhan ataupun permintaan seperti mengecek kesehatan anak, bertanya terkait operasi, resep obat, saran 

Dokter biasanya memberikan saran atau rekomendasi terkait kondisi kesehatan dan kebutuhan pasien. Berikut beberapa saran umum yang dapat diberikan oleh seorang dokter:

1.  Rekomendasi pengobatan: Dokter dapat memberikan saran terkait pengobatan yang diperlukan, seperti memberikan resep obat atau merekomendasikan terapi tertentu.
2.  Perawatan lanjutan: Dokter dapat memberikan petunjuk tentang perawatan lanjutan yang diperlukan untuk mengatasi masalah kesehatan, seperti perubahan pola makan atau rutinitas olahraga.
3.  Tes diagnostik: Dokter dapat merekomendasikan pemeriksaan atau tes tambahan untuk membantu mendiagnosis kondisi kesehatan pasien.
4.  Rujukan spesialis: Jika kondisi memerlukan perhatian lebih lanjut dari spesialis, dokter dapat merujuk pasien kepada dokter spesialis yang lebih ahli dalam bidang tersebut.
5.  Edukasi dan nasihat: Dokter dapat memberikan edukasi tentang penyakit atau kondisi tertentu, memberikan informasi mengenai cara mengelola atau mencegah penyakit, serta memberikan saran gaya hidup sehat.

Dalam konteks aplikasi web eMRs (rekam medis elektronik), "lembar konsultasi" dapat mencakup catatan dokter terkait pemeriksaan, hasil tes, diagnosis, serta saran dan rekomendasi yang diberikan kepada pasien.



## our apps
lalu yang kita buat disini adalah aplikasi rekaman lembar konsultasi, yang merupakan turunan dari eMR ini, mencakup semua dari yang action dokter serta laman laman yang dikunjungi dokter seperti diatas, dokter dan asisten dokter dapat login sebagai perekam lembar konsultasi,
dapat melihat homepage berisi daftar pasien di table assesmen dan table riwayat konsultasi, dokter bisa membuka setiap query, dimana setiap query itu berupa halaman lembar konsultasi seperti diatas dan mengandung data seperti diatas dan format dari data seperti diatas, lalu dokter dapat CRUD (
- [x] CREATE
- [ ] READ
- [ ] UPDATE
- [ ] DELETE
) setiap lembar konsultasi tersebut. 


lalu business rules yang dapat diaplikasikan  kepada aplikasi ini adalah






assesmen pasien bapak sendiri


lembar jawaban hasil konsultan dokter lain

verifikasi bpjp


// This is your Prisma schema file,
// learn more about it in the docs: https://pris.ly/d/prisma-schema

```
generator client {
  provider = "prisma-client-js"
}

datasource db {
  provider = "postgres"
  url      = env("DATABASE_URL")
}

model User {
  id           String      @id @default(nanoid())
  username     String      @unique
  email        String      @unique
  password     String

  books        Book[]
  bookshelves  Bookshelf[]
  Collaboration         Collaboration[]
}

model Book {
  id        Int      @id @default(autoincrement())
  title     String
  year      Int
  author    String
  user_id   String
  description           String?
  
  bookshelves           BookshelfBook[]
  user                  User                    @relation(fields: [user_id], references: [id], onDelete: Cascade)
  }

model Bookshelf {
  id            String                  @id @default(nanoid())
  name          String
  owner         String
  userId        String
 
  collaborators Collaboration[]
  books         BookshelfBook[]
  activities    BookshelfBookActivity[]
  user          User                    @relation(fields: [userId], references: [id])
}

model Collaboration {
  id          String    @id @default(nanoid())
  bookshelfId String
  userId      String
  
  user        User      @relation(fields: [userId], references: [id])
  bookshelf   Bookshelf @relation(fields: [bookshelfId], references: [id])
}

model BookshelfBook {
  id          String    @id @default(nanoid())
  bookId      Int 
  bookshelfId String
  
  book        Book      @relation(fields: [bookId], references: [id])
  bookshelf   Bookshelf @relation(fields: [bookshelfId], references: [id])
}

model BookshelfBookActivity {
  id          String    @id @default(nanoid())
  bookTitle      String
  bookshelfId String
  userId      String
  action      String
  time        DateTime  @default(now())

  bookshelf   Bookshelf @relation(fields: [bookshelfId], references: [id])
}
```
