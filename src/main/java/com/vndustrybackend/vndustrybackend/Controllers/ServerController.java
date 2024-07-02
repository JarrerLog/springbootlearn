package com.vndustrybackend.vndustrybackend.Controllers;

import static com.vndustrybackend.vndustrybackend.Vars.*;

import java.util.HashMap;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vndustrybackend.vndustrybackend.Dtos.ServerDTO;
import com.vndustrybackend.vndustrybackend.Handlers.ServerHandler;

@RestController
@RequestMapping("api/v1/server")
public class ServerController {

    private String databaseURL = "jdbc:sqlite:" + database.path();
    @PostMapping("/post")
    public ResponseEntity<?> post(@RequestBody HashMap<Object, Object> data) {
        String id = UUID.randomUUID().toString().replace("-", "");
        Object ip = data.get("ip");
        if (ip != null) {
            return ResponseEntity.badRequest().body(new HashMap<>() {
                {
                    put("id", id);
                    put("status","Bad Request");
                }
            });
        }

        ServerDTO server = new ServerDTO();
        ServerHandler.pingServer(ip.toString(),(sv) -> {
            server.setIp(ip.toString());
            server.setDesc(sv.description);
            server.setId(id);
            server.setMap(sv.mapname);
            server.setModeName(sv.modeName);
            server.setName(sv.name);
            server.setPing(sv.ping);
            server.setWave(sv.wave);

        } );

        if (server.getName() == null) {
            return ResponseEntity.ok().body("Server Has Offline");
        }
    }

    // make a function insert serverdto to database 



}
