package com.mycompany.hospitalproject2.PDF;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author joshua
 */
public class Pdf {
    
    public void generarPdf(String codigoCita) throws FileNotFoundException, DocumentException{
        FileOutputStream archivo = new FileOutputStream(codigoCita + ".pdf");
        Document documento = new Document();
        PdfWriter.getInstance(documento, archivo);
        documento.open();
        
        Paragraph parrafo = new Paragraph("Orden Doctor");
        parrafo.setAlignment(1);
        documento.add(parrafo);
        
        documento.add(new Paragraph("Aqui se puede escribir o mandar texto al pdf"));
        documento.close();
        
        
    }
}
