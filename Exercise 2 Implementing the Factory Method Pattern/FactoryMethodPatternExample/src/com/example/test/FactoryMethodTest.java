package com.example.test;

import com.example.documents.Document;
import com.example.factory.DocumentFactory;
import com.example.factory.WordDocumentFactory;
import com.example.factory.PdfDocumentFactory;
import com.example.factory.ExcelDocumentFactory;

public class FactoryMethodTest {
    public static void main(String[] args) {
        // Test Word Document creation
        DocumentFactory wordFactory = WordDocumentFactory.getInstance();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();
        wordDoc.close();

        // Test PDF Document creation
        DocumentFactory pdfFactory = PdfDocumentFactory.getInstance();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();
        pdfDoc.close();

        // Test Excel Document creation
        DocumentFactory excelFactory = ExcelDocumentFactory.getInstance();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
        excelDoc.close();
    }
}
