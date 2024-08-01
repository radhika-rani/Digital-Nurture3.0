package com.example.factory;

import com.example.documents.Document;
import com.example.documents.WordDocument;

public class WordDocumentFactory extends DocumentFactory {
    private static WordDocumentFactory instance;

    private WordDocumentFactory() {
        // private constructor
    }

    public static WordDocumentFactory getInstance() {
        if (instance == null) {
            synchronized (WordDocumentFactory.class) {
                if (instance == null) {
                    instance = new WordDocumentFactory();
                }
            }
        }
        return instance;
    }

    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}
