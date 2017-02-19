/**
 * 
 */
package com.neu.gd.util;

import java.awt.Color;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

/**
 * @author GD
 *
 */
@Component
public class PDFGeneration extends AbstractPdfView{

	@Override
	public void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		Font font_times_18_bold_black = new Font(Font.HELVETICA, 18, Font.BOLD, Color.BLACK);
		Font font_times_18_normal_black = new Font(Font.HELVETICA, 18, Font.NORMAL, Color.BLACK);
		Font font_times_14_bold_black = new Font(Font.HELVETICA, 14, Font.BOLD, Color.BLACK);
		Font font_times_14_normal_black = new Font(Font.HELVETICA, 14, Font.NORMAL, Color.BLACK);
		
		Paragraph paragraph = new Paragraph();
		paragraph.setAlignment(Element.ALIGN_CENTER);
		paragraph.setFont(font_times_18_bold_black);
		paragraph.add("Generic Terms and Conditions template");
		document.add(paragraph);
		document.add(Chunk.NEWLINE);
		document.add(Chunk.NEWLINE);
		
		paragraph = new Paragraph();
		paragraph.setAlignment(Element.ALIGN_LEFT);
		paragraph.setFont(font_times_18_normal_black);
		paragraph.add("Terms and Conditions (\"Terms\")");
		document.add(paragraph);
		document.add(Chunk.NEWLINE);
		document.add(Chunk.NEWLINE);
		
		paragraph = new Paragraph();
		paragraph.setFont(font_times_14_normal_black);
		paragraph.add("Last updated: 06/30/2016");
		document.add(paragraph);
		document.add(Chunk.NEWLINE);
		
		paragraph = new Paragraph();
		paragraph.add("Please read these Terms and Conditions (\"Terms\", \"Terms and Conditions\") carefully before using the http://localhost:9081/gd website (the \"Service\") operated by Gaurang Deshpande (\"us\", \"we\", or \"our\").");
		document.add(paragraph);
		document.add(Chunk.NEWLINE);
		
		paragraph = new Paragraph();
		paragraph.add("Your access to and use of the Service is conditioned on your acceptance of and compliance with these Terms. These Terms apply to all visitors, users and others who access or use the Service.");
		document.add(paragraph);
		document.add(Chunk.NEWLINE);
		
		paragraph = new Paragraph();
		paragraph.setFont(font_times_14_bold_black);
		paragraph.add("By accessing or using the Service you agree to be bound by these Terms. If you disagree with any part of the terms then you may not access the Service.");
		document.add(paragraph);
		document.add(Chunk.NEWLINE);
		
		paragraph = new Paragraph();
		paragraph.setFont(font_times_14_bold_black);
		paragraph.add("Subscriptions");
		document.add(paragraph);
		document.add(Chunk.NEWLINE);
		
		paragraph = new Paragraph();
		paragraph.setFont(font_times_14_normal_black);
		paragraph.add("Some parts of the Service are billed on a subscription basis (\"Subscription(s)\"). You will be billed in advance on a recurring");
		document.add(paragraph);
		document.add(Chunk.NEWLINE);
		
		paragraph = new Paragraph();
		paragraph.setFont(font_times_14_bold_black);
		paragraph.add("Content");
		document.add(paragraph);
		document.add(Chunk.NEWLINE);
		
		paragraph = new Paragraph();
		paragraph.setFont(font_times_14_normal_black);
		paragraph.add("Our Service allows you to post, link, store, share and otherwise make available certain information, text, graphics, videos, or other material (\"Content\"). You are responsible for the …");
		document.add(paragraph);
		document.add(Chunk.NEWLINE);
		
		paragraph = new Paragraph();
		paragraph.setFont(font_times_14_bold_black);
		paragraph.add("Links To Other Web Sites");
		document.add(paragraph);
		document.add(Chunk.NEWLINE);
		
		paragraph = new Paragraph();
		paragraph.setFont(font_times_14_normal_black);
		paragraph.add("Our Service may contain links to third­party web sites or services that are not owned or controlled by Gaurang Deshpande");
		document.add(paragraph);
		document.add(Chunk.NEWLINE);
		
		paragraph = new Paragraph();
		paragraph.add("Gaurang Deshpande has no control over, and assumes no responsibility for, the content, privacy policies, or practices of any third party web sites or services. You further acknowledge and agree that Gaurang Deshpande shall not be responsible or liable, directly or indirectly, for any damage or loss caused or alleged to be caused by or in connection with use of or reliance on any such content, goods or services available on or through any such web sites or services.");
		document.add(paragraph);
		document.add(Chunk.NEWLINE);
		
		paragraph = new Paragraph();
		paragraph.setFont(font_times_14_bold_black);
		paragraph.add("Changes");
		document.add(paragraph);
		document.add(Chunk.NEWLINE);
		
		paragraph = new Paragraph();
		paragraph.setFont(font_times_14_normal_black);
		paragraph.add("We reserve the right, at our sole discretion, to modify or replace these Terms at any time. If a revision is material we will try to provide at least 30 (change this) days' notice prior to any new terms taking effect. What constitutes a material change will be determined at our sole discretion.");
		document.add(paragraph);
		document.add(Chunk.NEWLINE);
		
		paragraph = new Paragraph();
		paragraph.setFont(font_times_14_bold_black);
		paragraph.add("Contact Us");
		document.add(paragraph);
		document.add(Chunk.NEWLINE);
		
		paragraph = new Paragraph();
		paragraph.setFont(font_times_14_normal_black);
		paragraph.add("If you have any questions about these Terms, please contact us.");
		document.add(paragraph);
		document.add(Chunk.NEWLINE);
		document.add(Chunk.NEWLINE);
		
		Phrase ph = new Phrase();
		ph.setFont(font_times_14_bold_black);
		ph.add("Thank You!");
		document.add(ph);
		document.add(Chunk.NEWLINE);

		document.close();
	}
}