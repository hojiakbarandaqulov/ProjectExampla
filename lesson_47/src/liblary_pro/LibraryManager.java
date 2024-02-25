package liblary_pro;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LibraryManager {

    List<Book> stringList = new LinkedList<>();

    // kitob kiritish
    public void addNewBook(String title, String author, int publishYear) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublishYear(publishYear);
    }

    // nomi bo'yicha kitobbi qaytaring
    public Book getBookByTitle(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter query: ");
        String query = scanner.next();
        for (Book book : stringList) {
            if (book != null && (book.getTitle().toLowerCase().startsWith(query.toLowerCase())
                    || book.getAuthor().toLowerCase().startsWith(query.toLowerCase()))) {
                System.out.println(book.getTitle() + " " + book.getAuthor() + " " + book.getPublishYear());
            }
        }
        return null;
    }

    // aftorni barcha kitoblarini qaytaring
    public List<Book> getAuthorBooks(String author) {
        Book book=new Book();
        if (stringList != null) {
            System.out.println(book.getTitle() + " " + book.getAuthor() + " " + book.getPublishYear());
        }
        return null;
    }

    // bor kitoblar sonini son qo'shish agar kitob bo'lmasa -1 return qiling.
    // agar  bo'lsa  uni sonini ko'paytirib xosil bo'lgan sonni return qiling
    public int addAvailableBook(String title, int count) {

        return 0;
    }

    // shu  kitobdan nechta borligini return qiling
    public int getAvailableBook(String title) {

        return 0;
    }

    //  berilgan aftor ni  kitoblar sonini return qiling
    public int getAvailableBookByAuthor(String author) {
        return 0;
    }

    public Student addStudent(String name, String surname, String phone, int level) {

        return null;
    }

    // bu method studentga  kitob berish uchun ishlatiladi.
    // agar berilgan student yokiy kitob bo'lmasa false return qiling.
    // agar student da uje olingan kitoblar soni 5 da bo'lsa false ruturn qiling.
    // (Bitta student bir vaqtni o'zida 5ta kitob olga bo'lishi mumkin)
    // agar ok bo'lsa  shu kitobni shu student oldi deb yozib qo'yish kerak (qayerdadir)

    public boolean takeBook(Integer studentId, String title) {
        return false;
    }

    // bu metod berilgan kitobni qaytarish uchun ishlatiladi.
    // agar berilgan student yokiy kitob bo'lmasa -1 return qiling
    // agar hammasi ok bo'lsa student kitobni topshirsin.
    // va studentni olib xali qaytarmagan kitoblar sonini qaytaring.
    // returnBook
    public int returnTakenBook(Integer studentId, String title) {
        return 0;
    }

    // bu metod studentni qolidagi kitoblar sonini return qiladi (xali qaytarmagan kitoblar sonini)
    // agar student bo'lmasa -1 return qiling
    public int getStudentTookBookCount(String studentId) {
        return -1;
    }

    // bu metod olib xali qaytarilmagan kitoblar sonini return qiladi
    public int booksOnHand() {
        return 0;
    }

    // bu metod barcha kitob olgan studentlar sonini return qiladi.
    // bitta student birmarta xisoblansin
    public int studentCountWhichTookABook() {
        return 0;
    }

    // berilgan kitob nechi marta olingam?
    public int bookTookCount(String title) {
        return 0;
    }

    // berilgan kurs o'qidigan studentlar ning qolida nechta kitob bor?
    public int bookOnHandCountByLevel(Integer level) {
        return 0;
    }

}
