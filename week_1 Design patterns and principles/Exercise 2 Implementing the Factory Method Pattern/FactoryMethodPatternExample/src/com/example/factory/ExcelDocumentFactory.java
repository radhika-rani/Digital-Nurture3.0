package com.example.factory;

import com.example.documents.Document;
import com.example.documents.ExcelDocument;

public class ExcelDocumentFactory extends DocumentFactory {
    private static ExcelDocumentFactory instance;

    private ExcelDocumentFactory() {
        // private constructor
    }

    public static ExcelDocumentFactory getInstance() {
        if (instance == null) {
            synchronized (ExcelDocumentFactory.class) {
                if (instance == null) {
                    instance = new ExcelDocumentFactory();
                }
            }
        }
        return instance;
    }

    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}
