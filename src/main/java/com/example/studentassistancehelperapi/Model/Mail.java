package com.example.studentassistancehelperapi.Model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Mail {
    private String name;
    private String usn;
    private String url;
    private ArrayList<String> to;
    private String from;
    private String subject;
    private int type;
    private String content;
    private String web_url;
}





