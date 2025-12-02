package com.example.xml.Controller;

import com.example.xml.Service.XmlService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/api/xml")
public class XmlController {

    private XmlService xmlService;

    public XmlController(XmlService xmlService) {
        this.xmlService = xmlService;
    }

    @GetMapping("/xml")
    public String xmlPage() {
        return "xmlPage";
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadXml(@RequestParam("file") MultipartFile file, @RequestParam("invoiceID") String invoiceID) {
        String result = xmlService.processXmlFile(file, invoiceID);
        return ResponseEntity.ok(result);
    }



}
