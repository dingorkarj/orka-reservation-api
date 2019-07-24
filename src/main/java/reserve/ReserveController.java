package reserve;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import producer.PhoneNumberProducer;

@RestController
@RequestMapping("/reserve")
public class ReserveController {

    private static final String reserve = "reserve";

    @Autowired
    private PhoneNumberProducer phoneNumberProducer;

    @RequestMapping("")
    public String welcome(){
        return reserve;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get")
    public String welcomeGet(){
        String response = reserve + "/get";
        System.out.println(response);
        return response;
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    @ResponseBody
    public String addReservation(@RequestBody String x){
        String response = "Your Reservation **" + x+ "**is saved!";
        System.out.println(response);
        return response;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/phone")
    public String addPhoneNumber(@RequestBody String number){
        String response = "Your phone number **" + number + "** is saved!";
        phoneNumberProducer.sendPhoneNumber(number);
        response = "Your phone number **" + number + "** is saved! f";
        System.out.println(response);
        return response;
    }

}
