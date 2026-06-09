package com.smarthire.smarthire360.service;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;

@Service
public class ResumeParserService {

    public String extractText(String filePath)
            throws IOException {

        PDDocument document =
                Loader.loadPDF(new File(filePath));

        PDFTextStripper stripper =
                new PDFTextStripper();

        String text =
                stripper.getText(document);

        document.close();

        return text;
    }
}
