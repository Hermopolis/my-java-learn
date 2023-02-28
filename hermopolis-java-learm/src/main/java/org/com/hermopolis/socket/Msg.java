package org.com.hermopolis.socket;

import lombok.Builder;
import lombok.Data;

import java.net.Socket;

@Data
@Builder
public class Msg {
    private String ip;
    private String port;
    private String toUid;
    private String msg;

}
