package com.vndustrybackend.vndustrybackend.Controllers;

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

    @PostMapping("/ping")
    public ResponseEntity<?> ping(@RequestBody HashMap<Object, Object> data) {
        Object ip = data.get("ip");
        if (ip == null) {
            return ResponseEntity.badRequest().body(new HashMap<Object, Object>() {
                {
                    put("message", "Invalid IP address");
                }
            });
        }

        ServerDTO sv = new ServerDTO();

        ServerHandler.pingServer(ip.toString(), server -> {
            sv.setIp((String) ip);
            sv.setName(server.name);
            sv.setPing(server.ping);
            sv.setPlayers(server.players);
            sv.setMap(server.mapname);
            sv.setWave(server.wave);
            sv.setVersion(server.version);
            sv.setLimit(server.playerLimit);
            sv.setModename(server.modeName);
            sv.setDesc(server.description);

        });
        return ResponseEntity.ok(sv);
    }

    @PostMapping("/post")
    public ResponseEntity<?> post(@RequestBody HashMap<Object, Object> data) {
        String id = UUID.randomUUID().toString().replace("-", "");
    }

}
