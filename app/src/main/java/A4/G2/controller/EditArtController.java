package A4.G2.controller;

import A4.G2.model.artwork.Art;
import A4.G2.service.Gallery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class EditArtController {

    @Autowired
    Gallery gallery;
    Art foundArt = null;

    @RequestMapping(value = "/edit-art", method = RequestMethod.GET)
    public String showEditArtPage(ModelMap model, @RequestParam String ID) throws IOException {
        gallery.initiate();
        for (Art art : gallery.getArtList()) {
            if (art.getId().equals(ID)) {
                foundArt = art;
            }
        }
        if (foundArt != null) {
            model.put("editTitle", foundArt.getTitle());
            model.put("editDescription", foundArt.getDescription());
            model.put("editDimensions", foundArt.getDimensions());
        }

        return "/edit-art";
    }

    @RequestMapping(value = "/edit-art", method = RequestMethod.POST)
    public String showSuccessEditArtPage(
            ModelMap model,
            @RequestParam String ID,
            @RequestParam String editTitle,
            @RequestParam String editDescription,
            @RequestParam String editDimensions
    ) {
        for (Art art : gallery.getArtList()) {
            if (art.getId().equals(ID)) {
                foundArt = art;
            }
        }
        if (foundArt != null && !editTitle.isEmpty() && !editDescription.isEmpty() && !editDimensions.isEmpty() ) {
            foundArt.setTitle(editTitle);
            foundArt.setDescription(editDescription);
            foundArt.setDimensions(editDimensions);
            model.put("editTitle", foundArt.getTitle());
            model.put("editDescription", foundArt.getDescription());
            model.put("editDimensions", foundArt.getDimensions());
            model.put("message", "Art successfully edited");
            return "/edit-art";
        } else if (foundArt != null) {
            model.put("editTitle", foundArt.getTitle());
            model.put("editDescription", foundArt.getDescription());
            model.put("editDimensions", foundArt.getDimensions());
        }
        model.put("errorMessage","Invalid inputs please try again");
        return "/edit-art";

    }
}
