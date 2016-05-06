package cms;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by chris on 4/28/2016.
 */
public class TextBookBag {

    private ArrayList<Textbook> textbookArrayList = new ArrayList<>();

    public void add(Textbook textbook){
        textbookArrayList.add(textbook);
    }

    public String display(){
        return textbookArrayList.toString();
    }

    public Textbook find(Long isbn) {
        int index = 0;
        for (int i = 0; i < textbookArrayList.size(); i++) {
            if (textbookArrayList.get(i).getISBN() == isbn) {
                index = i;
            }
        }
        return textbookArrayList.get(index);
    }

    public void delete(Long isbn) {
        int index = 0;
        for (int i = 0; i < textbookArrayList.size(); i++) {
            if (textbookArrayList.get(i).getISBN() == isbn) {
                index = i;
            }
        }
        textbookArrayList.remove(index);
    }

    public void loadBook(String file) {
        FileReader fopen;
        BufferedReader opened;
        String line;

        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            while (objectInputStream.readObject() != null) {
                String bookTitle = (String) objectInputStream.readObject();
                String author = (String) objectInputStream.readObject();
                String publisher = (String) objectInputStream.readObject();
                double bookPrice = (double) objectInputStream.readObject();
                Long isbn = (Long) objectInputStream.readObject();
                int yearPublished = (int) objectInputStream.readObject();
                Textbook textbook = new Textbook(bookTitle, author, publisher, bookPrice, isbn, yearPublished);
            }
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
