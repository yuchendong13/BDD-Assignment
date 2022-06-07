package A4.G2.controller;

import A4.G2.model.artwork.Art;
import A4.G2.service.Gallery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.util.Objects;


@Controller
@SessionAttributes("name")
public class RemoveArtController {

    Gallery gallery = new Gallery();
    ModelAndView map = new ModelAndView("/remove-art");

    @RequestMapping(value = "/remove-art", method = RequestMethod.GET)
    public ModelAndView showAddArtPage(ModelMap model) throws IOException {
        //add an artwork to gallery
        gallery.initiate();

        List<Art> artList = gallery.getArtList();
        map.addObject("list", artList);
        return map;
    }

    @RequestMapping(value = "/remove-art", method = RequestMethod.POST)
    public ModelAndView showSuccessRemoveArtPage(
            ModelMap model,
            @RequestParam String idToRemove
    ) {
        Art artToRemove = null;
        List<Art> artList = gallery.getArtList();
        for (Art art : artList) {
            if (Objects.equals(art.getId(), idToRemove)) {
                artToRemove = art;
            }
        }
        if (artToRemove != null){
            gallery.removeArt(artToRemove);
            map.addObject("list", gallery.getArtList());
            String message = String.format("Art titled: \"%s\" successfully removed", artToRemove.getTitle());
            model.put("message", message);
        } else {
            map.addObject("list", gallery.getArtList());
            model.put("errorMessage", "Invalid ID please try again");
        }
        return map;
    }

}
