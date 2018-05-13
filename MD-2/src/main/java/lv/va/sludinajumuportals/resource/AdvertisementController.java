package lv.va.sludinajumuportals.resource;

import lv.va.sludinajumuportals.dao.AdvertisementRepository;
import lv.va.sludinajumuportals.domain.Response;
import lv.va.sludinajumuportals.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Map;

@Controller
public class AdvertisementController 
{
    @Autowired
    private AdvertisementService advertisementService;

    @Autowired
    AdvertisementRepository advertisementRepository;

    @GetMapping(value = "/")
    @ResponseBody
    public String testEndpoint() 
    {
        return "Hello!";
    }

    @GetMapping(value = "/hey")
    @ResponseBody
    public Response nextTestEndpoint() 
    {
        return new Response("Hey Ya");
    }

    @RequestMapping("/main")
    public String getUI(Map<String, Object> model) 
    {
        model.put("message", "Hello User!");
        model.put("advertisement", advertisementService.getAdvertisement());
        return "main";
    }

    @GetMapping("/advertisements")
    public String getAdvertisements(Map<String, Object> model) 
    {
        model.put("advertisementList", advertisementService.getAdvertisementListReverse());
        return "advertisementui";
    }

    @RequestMapping("/advertisements/{author}")
    public String getAdvertisementsByAuthor(Map<String, Object> model, @PathVariable(value = "author") String author) 
    {
        model.put("advertisementsList", advertisementService.getAdvertisementListByAuthor(author));
        return "advertisementui";
    }
}