package com.example.factory;

import com.example.documents.Document;
import com.example.documents.PdfDocument;

public class PdfDocumentFactory extends DocumentFactory {
    private static PdfDocumentFactory instance;

    private PdfDocumentFactory() {
        // private constructor
    }

    public static PdfDocumentFactory getInstance() {
        if (instance == null) {
            synchronized (PdfDocumentFactory.class) {
                if (instance == null) {
                    instance = new PdfDocumentFactory();
                }
            }
        }
        return instance;
    }

    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}
