package com.example.solutionsproject.classes.flashcard;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class FlashcardManager {
    private final Context context;
    private final Map<String, FlashcardList> flashcardLists;
    public FlashcardManager(Context context) {
        this.context = context;
        this.flashcardLists = new LinkedHashMap<>();
        loadSavedFlashcardList();
    }

    public void save(FlashcardList flashcardList) {
        try {
            FileOutputStream fos1 = context.openFileOutput(flashcardList.getId() + ".ser", Context.MODE_PRIVATE);
            ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
            oos1.writeObject(flashcardList);
            oos1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveAllFlashcardList() {
        for (FlashcardList flashcardList : flashcardLists.values()) {
            try {
                FileOutputStream fos1 = context.openFileOutput(flashcardList.getId() + ".ser", Context.MODE_PRIVATE);
                ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
                oos1.writeObject(flashcardList);
                oos1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public FlashcardList load(String id) {
        FlashcardList loadedFlashcards = null;
        try {
            FileInputStream fis1 = context.openFileInput(id + ".ser");
            ObjectInputStream ois1 = new ObjectInputStream(fis1);
            loadedFlashcards = (FlashcardList) ois1.readObject();
            ois1.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return loadedFlashcards;
    }

    public void deleteSavedFlashcardList(String id) {
        boolean deleted = context.deleteFile(id + ".ser");
        if (deleted) {
            Log.d("FLASHCARD", "File deleted successfully");
        } else {
            Log.e("FLASHCARD", "Error deleting file");
        }
    }

    public void loadSavedFlashcardList() {
        File[] files = context.getFilesDir().listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".ser");
            }
        });
        if (files != null) {
            for (File file : files) {
                try {
                    FileInputStream fis = new FileInputStream(file);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    Object obj = ois.readObject();
                    if (obj instanceof FlashcardList) {
                        FlashcardList flashcardList = (FlashcardList) obj;
                        flashcardLists.put(flashcardList.getId(), flashcardList);
                    }
                    ois.close();
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Flashcard generateFillInTheBlank(String statement) {
        Random random = new Random();

        String[] words = statement.split(" ");

        int indexToRemove = random.nextInt(words.length);

        String removedWord = words[indexToRemove];

        StringBuilder spaces = new StringBuilder();
        for (int i = 0; i < removedWord.length(); i++) {
            spaces.append("_");
        }

        words[indexToRemove] = spaces.toString();

        StringBuilder question = new StringBuilder();
        for (String word : words) {
            question.append(word).append(" ");
        }

        return new Flashcard(question.toString(), removedWord);
    }

    public int getTotalFlashcardList() {
        return flashcardLists.size();
    }

    public void addFlashcardList(FlashcardList flashcardList) {
        flashcardLists.put(flashcardList.getId(), flashcardList);
    }

    public FlashcardList getFlashcardList(String id) {
        return flashcardLists.get(id);
    }

    public Map<String, FlashcardList> getFlashcardLists() {
        return flashcardLists;
    }

    @NonNull
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (FlashcardList flashcardList : flashcardLists.values()) {
            sb.append(flashcardList.toString());
        }

        return sb.toString();
    }
}
