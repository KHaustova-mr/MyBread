package com.example.mybread.model;
import android.media.Image;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
public class RecipeOnFile implements Serializable {
    String id;
    String site;
    String text;
    String pathimage;

    public RecipeOnFile(String id, String site, String text,String pathimage) {
        this.id=id;
        this.site=site;
        this.text=text;
        this.pathimage=pathimage;

        try(FileWriter writer = new FileWriter(id+".doc", false))
        {
            writer.write(id);
            writer.write(site);
            writer.write(text);
            XWPFDocument doc = new XWPFDocument();

            XWPFParagraph title = doc.createParagraph();
            XWPFRun run = title.createRun();
            run.setText("Fig.1 A Natural Scene");
            run.setBold(true);
            title.setAlignment(ParagraphAlignment.CENTER);

            String imgFile = pathimage;
            FileInputStream is = new FileInputStream(imgFile);
            run.addBreak();
            run.addPicture(is, XWPFDocument.PICTURE_TYPE_JPEG, imgFile, Units.toEMU(200), Units.toEMU(200)); // 200x200 pixels
            is.close();

            FileOutputStream fos = new FileOutputStream(id+".doc");
            doc.write(fos);
            fos.close();

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    }

    public static void SavingToWord (){

    }
}


