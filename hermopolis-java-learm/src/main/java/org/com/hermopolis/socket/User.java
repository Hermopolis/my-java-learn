package org.com.hermopolis.socket;

import lombok.Data;

import java.io.PrintWriter;

@Data
public class User {
    private String uid;
    private PrintWriter out;


}
