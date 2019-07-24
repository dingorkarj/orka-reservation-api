package reserve;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    public static final String appName= "Reservation";
    public static final String groupName= "Orka";
    public static final String authorName= "Jay D";

    @Value("${name}")
    public String name;

    @RequestMapping("/")
    public String index(){
        return "Greeting from "+ appName + " App! \n By " + groupName + "Group \n" + authorName + " env name " + name;
    }
}
