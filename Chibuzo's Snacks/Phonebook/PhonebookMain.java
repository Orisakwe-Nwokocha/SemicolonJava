public class PhonebookMain {
    public static void main(String[] args) {
        Phonebook nokiaPhonebook = new Phonebook();

        nokiaPhonebook.addContact("Orisha", "2348035729982");
        nokiaPhonebook.addContact("Ajiri", "08023456789");
        nokiaPhonebook.addContact("Izu", "08029853637");

        System.out.println("Type <Ctrl> z then press Enter to terminate the program at any point\n");
        PhonebookApp.startApp(nokiaPhonebook);

    }


}
