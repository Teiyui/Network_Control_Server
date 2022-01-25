package com.zyw.server.controller;

import com.zyw.server.entity.Response;
import com.zyw.server.service.RaspberryPiNetworkControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: ywzheng
 * @Description: TODO
 * @date: 2022/1/25 2:26 PM
 */
@RestController
@RequestMapping("/network")
public class NetworkController {

    @Autowired
    private RaspberryPiNetworkControlService raspberryPiNetworkControlService;

    @Autowired
    private Response response;

    @GetMapping(path = "/enablePi")
    public @ResponseBody
    Response enablePi(@RequestParam("ip") String ip, @RequestParam("username") String username,
                      @RequestParam("password") String password) {
        if (raspberryPiNetworkControlService.enableRaspberry(ip, username, password)) {
            response.setCode(200);
            response.setMsg("enable:success");
        } else {
            response.setCode(500);
            response.setMsg("enable:failure");
        }
        response.setResult(null);
        return response;
    }

    /**
     *
     * @param content
     * loss="5"
     * delay="100"
     * burst="0"
     * bw="2000"
     * act="add"
     * dir="downlink"
     * ip="xx.xx.xx.xx"
     * @return
     */
    @GetMapping(path = "/setPi")
    public @ResponseBody Response setPi(@RequestBody String content) {
        if (raspberryPiNetworkControlService.enableDisableImpairment(content)) {
            response.setCode(200);
            response.setMsg("activate:success");
        } else {
            response.setCode(500);
            response.setMsg("activate:failure");
        }
        response.setResult(null);
        return response;
    }

    @GetMapping(path = "/resetPi")
    public @ResponseBody Response resetPi(@RequestParam("ip") String ip) {
        if (raspberryPiNetworkControlService.resetNetworkImpairment(ip)) {
            response.setCode(200);
            response.setMsg("reset:success");
        } else {
            response.setCode(500);
            response.setMsg("reset:failure");
        }
        response.setResult(null);
        return response;
    }
}
