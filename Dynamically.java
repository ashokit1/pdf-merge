package pdfmerger1;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import java.io.File;
import java.io.IOException;

public class Dynamically {
    public static void main(String[] args) {
        // Path to the folder containing the PDF files to merge
        String folderPath = "C:/Ashok documents";
        
        // Destination path for the merged PDF file
        String outputFilePath = "C:/Ashok documents/merged/merged_output.pdf";

        try {
            // Initialize PDFMergerUtility
            PDFMergerUtility pdfMerger = new PDFMergerUtility();

            // Get all PDF files in the specified folder
            File folder = new File(folderPath);
            File[] pdfFiles = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".pdf"));
            
            if (pdfFiles == null || pdfFiles.length == 0) {
                System.out.println("No PDF files found in the specified folder.");
                return;
            }

            // Add each PDF file in the folder to the merger
            for (File pdfFile : pdfFiles) {
                pdfMerger.addSource(pdfFile);
            }

            // Set the destination file path
            pdfMerger.setDestinationFileName(outputFilePath);
            
            // Merge the documents
            pdfMerger.mergeDocuments(null);

            System.out.println("PDFs merged successfully into: " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}