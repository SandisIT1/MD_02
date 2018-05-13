package lv.va.sludinajumuportals.service;

import lv.va.sludinajumuportals.domain.Advertisement;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class AdvertisementService {

    String name = "Sandis";
    public List<Advertisement> hardcodedAdvertisementList;
    public List<Advertisement> reverseAdvertisementList;

    public AdvertisementService() 
    {
        hardcodedAdvertisementList = hardcodedAdvertisementInititialization();
        reverseAdvertisementList = hardcodedAdvertisementList;
        Collections.reverse(reverseAdvertisementList);
    }

    public Advertisement getAdvertisement() 
    {
        Advertisement advertisement = new Advertisement(1L, "Pardod maju", "Cesis", "Janis", 23456712L, 500.00D);
        return advertisement;
    }

    public List<Advertisement> getAdvertisementListByAuthor(String author) 
    {
        List<Advertisement> filteredByName = new ArrayList<>();
        for (Advertisement advertisement : hardcodedAdvertisementList)
        {
            if(advertisement.getAuthor().matches(author)) {
                filteredByName.add(advertisement);
            }
        }
        return filteredByName;
    }

    public List<Advertisement> getAdvertisementListReverse() 
    {
        return reverseAdvertisementList;
    }

    public ArrayList<Advertisement> getAdvertisementList() 
    {
        ArrayList<Advertisement> advertisements = new ArrayList<>();
        Advertisement advertisement = new Advertisement(1L, "Pardod maju", "Cesis", "Janis", 23456712L, 500.00D);
        advertisements.add(advertisement);
        return advertisements;
    }

    private List<Advertisement> hardcodedAdvertisementInititialization() 
    {
        List<Advertisement> advertisements = new ArrayList<>();
        for(int i = 1; i< name.length(); i++)
        {
            Advertisement advertisement = new Advertisement(Long.valueOf(i), "Maja", "Pardodu maju " + i, getAuthorName(i), 23456712L, 500.00D);
            advertisements.add(advertisement);
        }
        return advertisements;
    }

    private String getAuthorName(int i) 
    {
        if(i % 2 == 0 ) 
        {
            return "Jānis";
        }
        return "Pēteris";
    }
}
